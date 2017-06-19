package com.calderon.sf.importer;

import com.calderon.sf.commons.persistence.enums.TranStatusEnum;
import com.calderon.sf.persistence.dto.AccountEntity;
import com.calderon.sf.persistence.dto.TransactionEntity;
import com.calderon.sf.reader.Transaction;

import java.sql.Timestamp;

/**
 * Created by Nathaniel on 6/10/2017.
 */
public class TranHandler {
    private Transaction tran;
    private AccountEntity account;

    public TranHandler(AccountEntity account, Transaction tran) {
        this.account = account;
        this.tran = tran;
    }

    public void perform () {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAccountId(account.getId());
        transactionEntity.setStatusId(TranStatusEnum.PENDING.id());
        transactionEntity.setCategoryId(CategoryMatcher.matchCategory(tran));
        transactionEntity.setTranAmount(tran.getAmount());
        transactionEntity.setTranPostDate(new Timestamp(tran.getPostDate().toEpochDay()));
        transactionEntity.setTranDesc(tran.getDescription());
        transactionEntity.setTranRefNum(tran.getReferenceNumber());
        transactionEntity.setTypeId(tran.getType().id());
        transactionEntity.setTranNum(tran.getSerialNumber());
        //TransactionDAO.saveOrUpdate(transactionEntity);
    }

    @Override
    public String toString() {
        return "TranHandler{" +
                "tran=" + tran +
                ", account=" + account +
                '}';
    }
}
