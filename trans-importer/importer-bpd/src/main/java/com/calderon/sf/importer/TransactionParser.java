package com.calderon.sf.importer;

import com.calderon.sf.commons.persistence.enums.TranMethodEnum;
import com.calderon.sf.commons.persistence.enums.TranStatusEnum;
import com.calderon.sf.persistence.dto.TransactionEntity;

import com.calderon.sf.reader.Transaction;

import java.sql.Timestamp;

/**
 * Created by Nathaniel on 6/18/2017.
 */
public class TransactionParser {
    public static TransactionEntity parse (Transaction tran) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setStatusId(TranStatusEnum.DEFAULT.id());
        transactionEntity.setCategoryId(CategoryMatcher.matchCategory(tran.getDescription()).getId());
        transactionEntity.setTranAmount(tran.getAmount());
        transactionEntity.setTranPostDate(new Timestamp(tran.getPostDate().toEpochDay()));
        transactionEntity.setTranDesc(tran.getDescription());
        transactionEntity.setTranRefNum(tran.getReferenceNumber());
        transactionEntity.setTypeId(tran.getType().id());
        transactionEntity.setTranNum(tran.getSerialNumber());
        transactionEntity.setTranMethod(getTranMethod(tran).name());
        return transactionEntity;
    }

    private static TranMethodEnum getTranMethod (Transaction tran) {
        return TranMethodEnum.DEFAULT;
    }
}
