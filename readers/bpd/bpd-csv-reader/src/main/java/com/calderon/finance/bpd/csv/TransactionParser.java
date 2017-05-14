package com.calderon.finance.bpd.csv;

import com.calderon.finance.reader.TranTypeEnum;
import com.calderon.finance.reader.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Nathaniel on 3/18/2017.
 */
class TransactionParser {
    private static final int POST_DATE_INDEX = 0;
    private static final int TYPE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int REFERENCE_NUMBER_INDEX = 3;
    private static final int SERIAL_NUMBER_INDEX = 4;
    private static final int DESCRIPTION_INDEX = 5;

    public static Transaction parse (String text) {
        if (text == null || text.isEmpty())
            throw new IllegalArgumentException("Null or Empty string cannot be parse.");
        String[] tranValues = text.split(",");
        return new Transaction.Builder()
        .setPostDate(LocalDate.parse(tranValues[POST_DATE_INDEX], DateTimeFormatter.ofPattern("dd/MM/yyyy")))
        .setType(tranValues[TYPE_INDEX].charAt(0)=='D'? TranTypeEnum.DEBIT: TranTypeEnum.CREDIT)
        .setAmount(new BigDecimal(tranValues[AMOUNT_INDEX]))
        .setReferenceNumber(tranValues[REFERENCE_NUMBER_INDEX])
        .setSerialNumber(tranValues[SERIAL_NUMBER_INDEX])
        .setDescription(tranValues[DESCRIPTION_INDEX])
        .build();
    }
}
