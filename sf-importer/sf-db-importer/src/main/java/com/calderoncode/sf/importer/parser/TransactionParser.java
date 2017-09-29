package com.calderoncode.sf.importer.parser;


import com.calderon.sf.data.model.TransactionEntity;
import com.calderoncode.sf.transport.TranStatusEnum;
import com.calderoncode.sf.transport.Transaction;
/**
 * Created by Nathaniel on 6/18/2017.
 */
public class TransactionParser {
    public final static TransactionEntity parse (Transaction tran) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setStatusId(TranStatusEnum.PENDING.id());
        transactionEntity.setCategoryId(tran.getCategory().id());
        transactionEntity.setTranAmount(tran.getTranAmount());
        transactionEntity.setTranPostDate(tran.getTimestampTranPostDate());
        transactionEntity.setTranDesc(tran.getTranDesc());
        transactionEntity.setTranRefNum(tran.getTranRefNum());
        transactionEntity.setTypeId(tran.getType().id());
        transactionEntity.setTranNum(tran.getTranNum());
        transactionEntity.setTranMethod(tran.getTranMethod().codename());
        return transactionEntity;
    }
}
