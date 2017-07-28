package com.calderon.sf.data.service;

import com.calderon.sf.data.model.AccountEntity;
import com.calderon.sf.data.repository.AccountRepository;
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

    public List<AccountEntity> findByAccName(String accName) {
        return accountRepository.findByAccName(accName);
    }
}
