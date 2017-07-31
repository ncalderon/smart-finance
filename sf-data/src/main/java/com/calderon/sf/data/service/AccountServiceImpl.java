package com.calderon.sf.data.service.impl;

import com.calderon.sf.data.model.AccountEntity;
import com.calderon.sf.data.repository.AccountRepository;
import com.calderon.sf.data.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /*@Autowired
    public void setAccountRepository(AccountRepository repository) {
        System.out.println("We are using Setter Injection");
        this.accountRepository = repository;
    }*/

    public AccountEntity findOneByAccNumAndAccName(String accNum, String accName) {
        return accountRepository.findOneByAccNumAndAccName(accNum, accName);
    }
}
