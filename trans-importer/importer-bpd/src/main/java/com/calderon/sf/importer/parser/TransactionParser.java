package com.calderon.sf.importer.parser;

import com.calderon.sf.commons.persistence.enums.TranMethodEnum;
import com.calderon.sf.commons.persistence.enums.TranStatusEnum;
import com.calderon.sf.importer.CategoryMatcher;
import com.calderon.sf.persistence.dto.TransactionEntity;

import com.calderon.sf.reader.Transaction;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Calendar;

/**
 * Created by Nathaniel on 6/18/2017.
 */
public class TransactionParser {
    public static TransactionEntity parse (Transaction tran) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setStatusId(TranStatusEnum.PENDING.id());
        transactionEntity.setCategoryId(CategoryMatcher.matchCategory(tran));
        transactionEntity.setTranAmount(tran.getAmount());
        transactionEntity.setTranPostDate(getTranPostDate(tran));
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

    private static Timestamp getTranPostDate (Transaction tran) {
        Calendar instance = Calendar.getInstance();
        instance.set(tran.getPostDate().getYear(), tran.getPostDate().getMonthValue()-1, tran.getPostDate().getDayOfMonth(), 0, 0, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return new Timestamp(instance.getTimeInMillis());
    }
}
