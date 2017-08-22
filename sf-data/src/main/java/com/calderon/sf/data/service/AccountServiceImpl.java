package com.calderon.sf.data.service;

import com.calderon.sf.data.model.AccountEntity;
import com.calderon.sf.data.repository.AccountRepository;
import com.calderon.sf.data.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public void setAccountRepository(AccountRepository repository) {
        this.accountRepository = repository;
    }

    public AccountEntity findOneByAccNumAndAccName(String accNum, String accName) {
        return accountRepository.findOneByAccNumAndAccName(accNum, accName);
    }

    @Override
    public List<AccountEntity> findAll() {
        return accountRepository.findAll();
    }
}
