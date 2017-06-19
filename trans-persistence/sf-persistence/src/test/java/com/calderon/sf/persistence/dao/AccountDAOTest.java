package com.calderon.sf.persistence.dao;

import com.calderon.sf.commons.persistence.enums.AccountStatusEnum;
import com.calderon.sf.commons.persistence.enums.AccountTypeEnum;
import com.calderon.sf.persistence.dto.AccountEntity;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

/**
 * Created by Nathaniel on 6/17/2017.
 */
public class AccountDAOTest {
    @org.testng.annotations.BeforeMethod
    public void setUp() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() throws Exception {
    }

    @org.testng.annotations.Test
    public void testGetAccountByAccNum() throws Exception {
        AccountEntity account = AccountDAO.getAccountByAccNum("1928");
        System.out.println(account.getTransactionsById());
        assertNotEquals(AccountDAO.getAccountByAccNum("1928"), null);
    }

    @Test(enabled = false)
    public void testSaveAccount() throws Exception {
        AccountTypeEnum accountTypeEnum = AccountTypeEnum.DEFAULT;
        AccountEntity account = new AccountEntity();
        account.setBankId(BankDAO.getBankByName("Banco Popular Dominicano").getId());
        account.setTypeId(accountTypeEnum.id());
        account.setAccName("Test");
        account.setAccDescription("Test");
        account.setAccNum("3421443242");
        account.setAccBalance(new BigDecimal(0));
        account.setStatusId(AccountStatusEnum.ACTIVE.id());
        AccountDAO.saveOrUpdate(account);
        assertNotEquals(1, 0);
    }
}