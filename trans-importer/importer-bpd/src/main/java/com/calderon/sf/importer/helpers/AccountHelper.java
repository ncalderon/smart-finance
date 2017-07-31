package com.calderon.sf.importer.helpers;

import com.calderon.sf.commons.persistence.enums.AccountStatusEnum;
import com.calderon.sf.persistence.dao.AccountDAO;
import com.calderon.sf.persistence.dto.AccountEntity;
import com.calderon.sf.persistence.dto.BankEntity;
import com.calderon.sf.api.reader.Account;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by Nathaniel on 6/25/2017.
 */
public class AccountHelper {
    private Account account;
    private static final HashMap<String,AccountEntity> cache = new HashMap<>();
    public AccountHelper(Account account) {
        this.account = account;
    }

    public AccountEntity getAccount() {
        AccountEntity accountEntity = getFromCache(this.account.getNumber());
        if (null == accountEntity)
            accountEntity = getFromDB();
        if (null == accountEntity)
            accountEntity = createAccount();
        return accountEntity;
    }

    public AccountEntity createAccount(){
        BankEntity bank = new BankHelper(this.account.getBank()).getBank();
        AccountEntity account = new AccountEntity();
        account.setBankId(bank.getId());
        account.setTypeId(this.account.getType().id());
        account.setAccName(this.account.getName());
        account.setAccDescription(this.account.getName());
        account.setAccNum(this.account.getNumber());
        account.setAccBalance(new BigDecimal(0));
        account.setStatusId(AccountStatusEnum.ACTIVE.id());
        putOnCatche(account);
        return account;
    }

    private AccountEntity getFromDB(){
        AccountEntity accountEntity = AccountDAO.getAccountByAccNumAndName(account.getNumber(), account.getName());
        if (null != accountEntity)
            putOnCatche(accountEntity);
        return accountEntity;
    }

    private void putOnCatche(AccountEntity account){
        cache.put(account.getAccNum(), account);
    }

    private AccountEntity getFromCache(String number){
        return cache.get(number);
    }
}
