package com.calderon.sf.api.importers.helpers;

import com.calderon.sf.persistence.dao.BankDAO;
import com.calderon.sf.persistence.dto.BankEntity;
import com.calderon.sf.api.reader.Bank;

import java.util.HashMap;

/**
 * Created by Nathaniel on 6/25/2017.
 */
public class BankHelper {
    private Bank bank;
    private static final HashMap<String,BankEntity> cache = new HashMap<>();
    public BankHelper(Bank bank) {
        this.bank = bank;
    }

    public BankEntity getBank(){
        BankEntity bank = getFromCache(this.bank.getName());
        if (null == bank)
            bank = getFromDB();
        if(null == bank)
            bank = createBank();
        return bank;
    }

    private BankEntity getFromDB() {
        BankEntity bank = BankDAO.getBankByName(this.bank.getName());
        if (null != bank)
            putOnCache(bank);
        return bank;
    }


    private BankEntity createBank () {
        BankEntity bank = new BankEntity();
        bank.setName(this.bank.getName());
        bank.setDescription(this.bank.getName());
        putOnCache(bank);
        return bank;
    }

    private void putOnCache(BankEntity bank){
        cache.put(bank.getName(), bank);
    }

    private BankEntity getFromCache(String name){
        return cache.get(name);
    }
}

