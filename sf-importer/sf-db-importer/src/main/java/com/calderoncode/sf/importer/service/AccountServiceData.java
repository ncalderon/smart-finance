package com.calderoncode.sf.importer.service;

import com.calderon.sf.commons.data.AccountStatusEnum;
import com.calderon.sf.data.model.AccountEntity;
import com.calderon.sf.data.model.BankEntity;
import com.calderon.sf.data.service.AccountService;
import com.calderoncode.sf.reader.Account;
import com.calderoncode.sf.reader.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by Nathaniel on 6/25/2017.
 */
@Component
public class AccountServiceData {

    private AccountService service;
    private static final HashMap<String,AccountEntity> cache = new HashMap<>();

    @Autowired
    public void setService(AccountService service) {
        this.service = service;
    }

    public AccountEntity getAccountEntityFrom(Account account, BankEntity bank) {
        AccountEntity accountEntity = getFromCache(account.getNumber());
        if (null == accountEntity)
            accountEntity = getFromDB(account);
        if (null == accountEntity)
            accountEntity = createAccount(account, bank);
        return accountEntity;
    }

    private AccountEntity createAccount(Account account, BankEntity bank){
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setBankId(bank.getId());
        accountEntity.setTypeId(account.getType().id());
        accountEntity.setAccName(account.getName());
        accountEntity.setAccDescription(account.getName());
        accountEntity.setAccNum(account.getNumber());
        accountEntity.setAccBalance(new BigDecimal(0));
        accountEntity.setStatusId(AccountStatusEnum.ACTIVE.id());
        putOnCache(accountEntity);
        return accountEntity;
    }

    private AccountEntity getFromDB(Account account){
        AccountEntity accountEntity = service.findOneByAccNumAndAccName(account.getNumber(), account.getName());
        if (null != accountEntity)
            putOnCache(accountEntity);
        return accountEntity;
    }

    private void putOnCache(AccountEntity account){
        cache.put(account.getAccNum(), account);
    }

    private AccountEntity getFromCache(String number){
        return cache.get(number);
    }
}
