package com.calderon.sf.reader.interpreter;

import com.calderon.sf.reader.Bank;


/**
 * Created by Nathaniel on 6/25/2017.
 */
public class BankInterpreter implements BodyInterpreter<Bank> {
    private String bank;
    public BankInterpreter(String bank){
        this.bank = bank;
    }
    @Override
    public Bank interpret() {
        return new Bank.Builder().setName(bank).build();
    }
}
