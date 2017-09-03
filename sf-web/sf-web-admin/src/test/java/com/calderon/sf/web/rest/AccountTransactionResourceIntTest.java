package com.calderon.sf.web.rest;

import com.calderon.sf.SfWebAdminApp;

import com.calderon.sf.domain.AccountTransaction;
import com.calderon.sf.repository.AccountTransactionRepository;
import com.calderon.sf.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.calderon.sf.domain.enumeration.TranStatus;
import com.calderon.sf.domain.enumeration.TranType;
import com.calderon.sf.domain.enumeration.TranMethod;
/**
 * Test class for the AccountTransactionResource REST controller.
 *
 * @see AccountTransactionResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SfWebAdminApp.class)
public class AccountTransactionResourceIntTest {

    private static final TranStatus DEFAULT_TRAN_STATUS = TranStatus.PENDING;
    private static final TranStatus UPDATED_TRAN_STATUS = TranStatus.EXPORTED;

    private static final TranType DEFAULT_TRAN_TYPE = TranType.DB;
    private static final TranType UPDATED_TRAN_TYPE = TranType.CR;

    private static final String DEFAULT_TRAN_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_TRAN_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_REFERENCE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_REFERENCE_NUMBER = "BBBBBBBBBB";

    private static final Instant DEFAULT_POST_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_POST_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_AMOUNT = new BigDecimal(2);

    private static final TranMethod DEFAULT_TRAN_METHOD = TranMethod.DEFAULT;
    private static final TranMethod UPDATED_TRAN_METHOD = TranMethod.DEFAULT;

    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restAccountTransactionMockMvc;

    private AccountTransaction accountTransaction;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AccountTransactionResource accountTransactionResource = new AccountTransactionResource(accountTransactionRepository);
        this.restAccountTransactionMockMvc = MockMvcBuilders.standaloneSetup(accountTransactionResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AccountTransaction createEntity(EntityManager em) {
        AccountTransaction accountTransaction = new AccountTransaction()
            .tranStatus(DEFAULT_TRAN_STATUS)
            .tranType(DEFAULT_TRAN_TYPE)
            .tranNumber(DEFAULT_TRAN_NUMBER)
            .referenceNumber(DEFAULT_REFERENCE_NUMBER)
            .postDate(DEFAULT_POST_DATE)
            .description(DEFAULT_DESCRIPTION)
            .amount(DEFAULT_AMOUNT)
            .tranMethod(DEFAULT_TRAN_METHOD);
        return accountTransaction;
    }

    @Before
    public void initTest() {
        accountTransaction = createEntity(em);
    }

    @Test
    @Transactional
    public void createAccountTransaction() throws Exception {
        int databaseSizeBeforeCreate = accountTransactionRepository.findAll().size();

        // Create the AccountTransaction
        restAccountTransactionMockMvc.perform(post("/api/account-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountTransaction)))
            .andExpect(status().isCreated());

        // Validate the AccountTransaction in the database
        List<AccountTransaction> accountTransactionList = accountTransactionRepository.findAll();
        assertThat(accountTransactionList).hasSize(databaseSizeBeforeCreate + 1);
        AccountTransaction testAccountTransaction = accountTransactionList.get(accountTransactionList.size() - 1);
        assertThat(testAccountTransaction.getTranStatus()).isEqualTo(DEFAULT_TRAN_STATUS);
        assertThat(testAccountTransaction.getTranType()).isEqualTo(DEFAULT_TRAN_TYPE);
        assertThat(testAccountTransaction.getTranNumber()).isEqualTo(DEFAULT_TRAN_NUMBER);
        assertThat(testAccountTransaction.getReferenceNumber()).isEqualTo(DEFAULT_REFERENCE_NUMBER);
        assertThat(testAccountTransaction.getPostDate()).isEqualTo(DEFAULT_POST_DATE);
        assertThat(testAccountTransaction.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testAccountTransaction.getAmount()).isEqualTo(DEFAULT_AMOUNT);
        assertThat(testAccountTransaction.getTranMethod()).isEqualTo(DEFAULT_TRAN_METHOD);
    }

    @Test
    @Transactional
    public void createAccountTransactionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = accountTransactionRepository.findAll().size();

        // Create the AccountTransaction with an existing ID
        accountTransaction.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAccountTransactionMockMvc.perform(post("/api/account-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountTransaction)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<AccountTransaction> accountTransactionList = accountTransactionRepository.findAll();
        assertThat(accountTransactionList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkTranStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = accountTransactionRepository.findAll().size();
        // set the field null
        accountTransaction.setTranStatus(null);

        // Create the AccountTransaction, which fails.

        restAccountTransactionMockMvc.perform(post("/api/account-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountTransaction)))
            .andExpect(status().isBadRequest());

        List<AccountTransaction> accountTransactionList = accountTransactionRepository.findAll();
        assertThat(accountTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTranTypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = accountTransactionRepository.findAll().size();
        // set the field null
        accountTransaction.setTranType(null);

        // Create the AccountTransaction, which fails.

        restAccountTransactionMockMvc.perform(post("/api/account-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountTransaction)))
            .andExpect(status().isBadRequest());

        List<AccountTransaction> accountTransactionList = accountTransactionRepository.findAll();
        assertThat(accountTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTranNumberIsRequired() throws Exception {
        int databaseSizeBeforeTest = accountTransactionRepository.findAll().size();
        // set the field null
        accountTransaction.setTranNumber(null);

        // Create the AccountTransaction, which fails.

        restAccountTransactionMockMvc.perform(post("/api/account-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountTransaction)))
            .andExpect(status().isBadRequest());

        List<AccountTransaction> accountTransactionList = accountTransactionRepository.findAll();
        assertThat(accountTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPostDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = accountTransactionRepository.findAll().size();
        // set the field null
        accountTransaction.setPostDate(null);

        // Create the AccountTransaction, which fails.

        restAccountTransactionMockMvc.perform(post("/api/account-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountTransaction)))
            .andExpect(status().isBadRequest());

        List<AccountTransaction> accountTransactionList = accountTransactionRepository.findAll();
        assertThat(accountTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAmountIsRequired() throws Exception {
        int databaseSizeBeforeTest = accountTransactionRepository.findAll().size();
        // set the field null
        accountTransaction.setAmount(null);

        // Create the AccountTransaction, which fails.

        restAccountTransactionMockMvc.perform(post("/api/account-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountTransaction)))
            .andExpect(status().isBadRequest());

        List<AccountTransaction> accountTransactionList = accountTransactionRepository.findAll();
        assertThat(accountTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTranMethodIsRequired() throws Exception {
        int databaseSizeBeforeTest = accountTransactionRepository.findAll().size();
        // set the field null
        accountTransaction.setTranMethod(null);

        // Create the AccountTransaction, which fails.

        restAccountTransactionMockMvc.perform(post("/api/account-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountTransaction)))
            .andExpect(status().isBadRequest());

        List<AccountTransaction> accountTransactionList = accountTransactionRepository.findAll();
        assertThat(accountTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllAccountTransactions() throws Exception {
        // Initialize the database
        accountTransactionRepository.saveAndFlush(accountTransaction);

        // Get all the accountTransactionList
        restAccountTransactionMockMvc.perform(get("/api/account-transactions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(accountTransaction.getId().intValue())))
            .andExpect(jsonPath("$.[*].tranStatus").value(hasItem(DEFAULT_TRAN_STATUS.toString())))
            .andExpect(jsonPath("$.[*].tranType").value(hasItem(DEFAULT_TRAN_TYPE.toString())))
            .andExpect(jsonPath("$.[*].tranNumber").value(hasItem(DEFAULT_TRAN_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].referenceNumber").value(hasItem(DEFAULT_REFERENCE_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].postDate").value(hasItem(DEFAULT_POST_DATE.toString())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].amount").value(hasItem(DEFAULT_AMOUNT.intValue())))
            .andExpect(jsonPath("$.[*].tranMethod").value(hasItem(DEFAULT_TRAN_METHOD.toString())));
    }

    @Test
    @Transactional
    public void getAccountTransaction() throws Exception {
        // Initialize the database
        accountTransactionRepository.saveAndFlush(accountTransaction);

        // Get the accountTransaction
        restAccountTransactionMockMvc.perform(get("/api/account-transactions/{id}", accountTransaction.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(accountTransaction.getId().intValue()))
            .andExpect(jsonPath("$.tranStatus").value(DEFAULT_TRAN_STATUS.toString()))
            .andExpect(jsonPath("$.tranType").value(DEFAULT_TRAN_TYPE.toString()))
            .andExpect(jsonPath("$.tranNumber").value(DEFAULT_TRAN_NUMBER.toString()))
            .andExpect(jsonPath("$.referenceNumber").value(DEFAULT_REFERENCE_NUMBER.toString()))
            .andExpect(jsonPath("$.postDate").value(DEFAULT_POST_DATE.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.amount").value(DEFAULT_AMOUNT.intValue()))
            .andExpect(jsonPath("$.tranMethod").value(DEFAULT_TRAN_METHOD.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingAccountTransaction() throws Exception {
        // Get the accountTransaction
        restAccountTransactionMockMvc.perform(get("/api/account-transactions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAccountTransaction() throws Exception {
        // Initialize the database
        accountTransactionRepository.saveAndFlush(accountTransaction);
        int databaseSizeBeforeUpdate = accountTransactionRepository.findAll().size();

        // Update the accountTransaction
        AccountTransaction updatedAccountTransaction = accountTransactionRepository.findOne(accountTransaction.getId());
        updatedAccountTransaction
            .tranStatus(UPDATED_TRAN_STATUS)
            .tranType(UPDATED_TRAN_TYPE)
            .tranNumber(UPDATED_TRAN_NUMBER)
            .referenceNumber(UPDATED_REFERENCE_NUMBER)
            .postDate(UPDATED_POST_DATE)
            .description(UPDATED_DESCRIPTION)
            .amount(UPDATED_AMOUNT)
            .tranMethod(UPDATED_TRAN_METHOD);

        restAccountTransactionMockMvc.perform(put("/api/account-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedAccountTransaction)))
            .andExpect(status().isOk());

        // Validate the AccountTransaction in the database
        List<AccountTransaction> accountTransactionList = accountTransactionRepository.findAll();
        assertThat(accountTransactionList).hasSize(databaseSizeBeforeUpdate);
        AccountTransaction testAccountTransaction = accountTransactionList.get(accountTransactionList.size() - 1);
        assertThat(testAccountTransaction.getTranStatus()).isEqualTo(UPDATED_TRAN_STATUS);
        assertThat(testAccountTransaction.getTranType()).isEqualTo(UPDATED_TRAN_TYPE);
        assertThat(testAccountTransaction.getTranNumber()).isEqualTo(UPDATED_TRAN_NUMBER);
        assertThat(testAccountTransaction.getReferenceNumber()).isEqualTo(UPDATED_REFERENCE_NUMBER);
        assertThat(testAccountTransaction.getPostDate()).isEqualTo(UPDATED_POST_DATE);
        assertThat(testAccountTransaction.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testAccountTransaction.getAmount()).isEqualTo(UPDATED_AMOUNT);
        assertThat(testAccountTransaction.getTranMethod()).isEqualTo(UPDATED_TRAN_METHOD);
    }

    @Test
    @Transactional
    public void updateNonExistingAccountTransaction() throws Exception {
        int databaseSizeBeforeUpdate = accountTransactionRepository.findAll().size();

        // Create the AccountTransaction

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restAccountTransactionMockMvc.perform(put("/api/account-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountTransaction)))
            .andExpect(status().isCreated());

        // Validate the AccountTransaction in the database
        List<AccountTransaction> accountTransactionList = accountTransactionRepository.findAll();
        assertThat(accountTransactionList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteAccountTransaction() throws Exception {
        // Initialize the database
        accountTransactionRepository.saveAndFlush(accountTransaction);
        int databaseSizeBeforeDelete = accountTransactionRepository.findAll().size();

        // Get the accountTransaction
        restAccountTransactionMockMvc.perform(delete("/api/account-transactions/{id}", accountTransaction.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<AccountTransaction> accountTransactionList = accountTransactionRepository.findAll();
        assertThat(accountTransactionList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AccountTransaction.class);
        AccountTransaction accountTransaction1 = new AccountTransaction();
        accountTransaction1.setId(1L);
        AccountTransaction accountTransaction2 = new AccountTransaction();
        accountTransaction2.setId(accountTransaction1.getId());
        assertThat(accountTransaction1).isEqualTo(accountTransaction2);
        accountTransaction2.setId(2L);
        assertThat(accountTransaction1).isNotEqualTo(accountTransaction2);
        accountTransaction1.setId(null);
        assertThat(accountTransaction1).isNotEqualTo(accountTransaction2);
    }
}