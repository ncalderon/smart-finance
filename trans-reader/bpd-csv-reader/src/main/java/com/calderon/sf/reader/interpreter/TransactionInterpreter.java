package com.calderon.sf.api.reader.interpreter;

import com.calderon.sf.api.reader.Transaction;
import com.calderon.sf.commons.persistence.enums.TranTypeEnum;
import com.calderon.sf.api.reader.Account;

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
        return new Transaction.Builder()
                .setPostDate(created)
                .setAccount(account)
                .setType(type)
                .setAmount(new BigDecimal(tranValues[AMOUNT_INDEX]))
                .setReferenceNumber(tranValues[REFERENCE_NUMBER_INDEX])
                .setSerialNumber(tranValues[SERIAL_NUMBER_INDEX])
                .setDescription(tranValues[DESCRIPTION_INDEX])
                .build();
    }
}

