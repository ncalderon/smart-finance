package com.calderon.sf.data.service;

import com.calderon.sf.data.model.AccountEntity;
import com.calderon.sf.data.model.BankEntity;
import com.calderon.sf.data.model.TransactionEntity;
import com.calderon.sf.data.repository.AccountRepository;
import com.calderon.sf.data.repository.BankRepository;
import com.calderon.sf.data.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionManagementImpl implements TransactionManagement {
    private BankRepository bankRepository;
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    @Autowired
    public void setBankRepository(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Autowired
    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    @Override
    public void save(BankEntity bank, AccountEntity account, List<TransactionEntity> transactions) {
        bankRepository.save(bank);
        accountRepository.save(account);
        for(TransactionEntity tran: transactions)
            tran.setAccountId(account.getId());
        transactionRepository.save(transactions);
    }

    @Transactional
    @Override
    public void save(BankEntity bank, AccountEntity account, TransactionEntity transaction) {
        bankRepository.save(bank);
        accountRepository.save(account);
        transactionRepository.save(transaction);
    }
}
