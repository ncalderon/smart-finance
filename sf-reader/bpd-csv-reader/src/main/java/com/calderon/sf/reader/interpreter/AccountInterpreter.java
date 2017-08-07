package com.calderon.sf.reader.interpreter;

import com.calderon.sf.api.reader.interpreter.BodyInterpreter;
import com.calderon.sf.commons.data.AccountTypeEnum;
import com.calderon.sf.api.reader.Account;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

/**
 * Created by Nathaniel on 6/24/2017.
 */
public class AccountInterpreter implements BodyInterpreter<Account> {

    private static final Logger log = LogManager.getLogger(AccountInterpreter.class.getName());
    private static final String splitRegex = ",";
    private static final int ACCOUNT_NAME_INDEX = 0;
    private static final int BANK_NAME_INDEX = 1;
    private static final int ACCOUNT_NUM_INDEX = 2;
    private static final String accountLabelToRemove = "Cuenta: ************";
    private String[] accountValues;
    public AccountInterpreter(String account) {
        if (account == null) {
            throw new IllegalArgumentException("String account cannot be null.");
        }
        log.info("Creating interpreter for account: " + account);
        this.accountValues = account.split(splitRegex);
    }

    @Override
    public Account interpret() {
        log.info("Trying to interpret account: ", accountValues);
        return new Account.Builder()
                .setBank(new BankInterpreter(accountValues[BANK_NAME_INDEX]).interpret())
                .setCreated(getCreated())
                .setNumber(getNumber())
                .setName(getName())
                .setType(getType())
                .build();
    }

    private AccountTypeEnum getType(){
        return accountValues[ACCOUNT_NUM_INDEX].indexOf("************") == -1? AccountTypeEnum.DEFAULT: AccountTypeEnum.CREDIT_CARD;
    }

    private String getName(){
        return accountValues[ACCOUNT_NAME_INDEX];
    }

    private String getNumber(){
        return accountValues[ACCOUNT_NUM_INDEX].replace(accountLabelToRemove, "");
    }

    private LocalDateTime getCreated(){
        return LocalDateTime.now();
    }
}
