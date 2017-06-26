package com.calderon.sf.reader.interpreter;

import com.calderon.sf.commons.persistence.enums.AccountTypeEnum;
import com.calderon.sf.reader.Account;
import com.calderon.sf.reader.Reader;
import com.calderon.sf.reader.parser.DatetimeParser;

import java.text.ParsePosition;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Nathaniel on 6/24/2017.
 */
public class AccountInterpreter implements BodyInterpreter<Account> {
    private String[] accountValues;

    private static final String splitRegex = ",";

    private static final int GENERATE_DATE_INDEX = 3;
    private static final int GEN_DATE_COLUMN_START_INDEX = 12;
    private static final String GEN_DATE_PATTERN = "dd/MM/yyyy hh:mm:ss a";

    private static final int BANK_NAME_INDEX = 4;
    private static final int ACCOUNT_INDEX = 5;
    private static final String accountLabelToRemove = "Cuenta: ************";

    public AccountInterpreter(String account) {
        if (account == null) {
            throw new IllegalArgumentException("String account cannot be null.");
        }
        this.accountValues = account.split(splitRegex);
    }

    @Override
    public Account interpret() {
        return new Account.Builder()
                .setBank(new BankInterpreter(accountValues[4]).interpret())
                .setCreated(DatetimeParser.parse(accountValues[3], GEN_DATE_PATTERN, new ParsePosition(GEN_DATE_COLUMN_START_INDEX)))
                .setNumber(accountValues[ACCOUNT_INDEX].replace(accountLabelToRemove, ""))
                .setName(accountValues[ACCOUNT_INDEX].replace(accountLabelToRemove, ""))
                .setType(accountValues[ACCOUNT_INDEX].indexOf("************") == -1? AccountTypeEnum.DEFAULT: AccountTypeEnum.CREDIT_CARD)
                .build();
    }
}
