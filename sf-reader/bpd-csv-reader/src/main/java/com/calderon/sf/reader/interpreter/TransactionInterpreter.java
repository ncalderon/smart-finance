package com.calderon.sf.reader.interpreter;


import com.calderoncode.sf.reader.interpreter.BodyInterpreter;
import com.calderoncode.sf.transport.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Nathaniel on 6/25/2017.
 */
public class TransactionInterpreter implements BodyInterpreter<Transaction> {
    private final Account account;
    private String[] tranValues;
    private static final String splitRegex = ",";

    private static final int POST_DATE_INDEX = 0;
    private static final int TYPE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int SERIAL_NUMBER_INDEX = 3;
    private static final int REFERENCE_NUMBER_INDEX = 4;
    private static final int DESCRIPTION_INDEX = 5;

    public TransactionInterpreter(String transaction, Account account) {
        if (transaction == null || transaction.isEmpty())
            throw new IllegalArgumentException("String transaction cannot be null.");
        this.tranValues = transaction.split(splitRegex);
        this.account = account;
    }

    @Override
    public Transaction interpret() {
        LocalDate created = LocalDate.parse(account.getCreated().getYear() + "/" +tranValues[POST_DATE_INDEX], DateTimeFormatter.ofPattern("yyyy/dd/MM"));
        TranTypeEnum type = tranValues[TYPE_INDEX].equals(TranTypeEnum.DEBIT.codename())? TranTypeEnum.DEBIT: TranTypeEnum.CREDIT;
        TranCategoryEnum category = type == TranTypeEnum.DEBIT? TranCategoryEnum.INCOME: TranCategoryEnum.EXPENSE;
        return new Transaction.Builder()
                .setTranPostDate(created)
                .setAccount(account)
                .setType(type)
                .setTranAmount(new BigDecimal(tranValues[AMOUNT_INDEX]))
                .setTranRefNum(tranValues[REFERENCE_NUMBER_INDEX])
                .setTranNum(tranValues[SERIAL_NUMBER_INDEX])
                .setTranDesc(tranValues[DESCRIPTION_INDEX])
                .setCategory(category)
                .setTranMethod(TranMethodEnum.DEFAULT)
                .build();
    }
}

