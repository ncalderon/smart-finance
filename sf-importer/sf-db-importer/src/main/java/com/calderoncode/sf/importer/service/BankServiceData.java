package com.calderoncode.sf.importer.service;


import com.calderon.sf.data.model.BankEntity;
import com.calderon.sf.data.service.BankService;

import com.calderoncode.sf.transport.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by Nathaniel on 6/25/2017.
 */
@Component
public class BankServiceData {

    private BankService service;
    private static final HashMap<String,BankEntity> cache = new HashMap<>();

    @Autowired
    public void setService(BankService service) {
        this.service = service;
    }

    public BankEntity getBankEntityFrom(Bank bank){
        BankEntity bankEntity = getFromCache(bank.getName());
        if (null == bankEntity)
            bankEntity = getFromDB(bank);
        if(null == bankEntity)
            bankEntity = createBank(bank);
        return bankEntity;
    }

    private BankEntity getFromDB(Bank bank) {
        BankEntity bankEntity = service.findFirstByName(bank.getName());
        if (null != bankEntity)
            putOnCache(bankEntity);
        return bankEntity;
    }


    private BankEntity createBank (Bank bank) {
        BankEntity bankEntity = new BankEntity();
        bankEntity.setName(bank.getName());
        bankEntity.setDescription(bank.getName());
        putOnCache(bankEntity);
        return bankEntity;
    }

    private void putOnCache(BankEntity bank){
        cache.put(bank.getName(), bank);
    }

    private BankEntity getFromCache(String name){
        return cache.get(name);
    }
}

