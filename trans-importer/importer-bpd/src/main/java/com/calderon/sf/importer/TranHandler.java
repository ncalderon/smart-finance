package com.calderon.sf.importer;

import com.calderon.sf.persistence.dao.TransactionDAO;
import com.calderon.sf.persistence.dto.AccountEntity;
import com.calderon.sf.persistence.dto.TranStatusEnum;
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
        transactionEntity.setStatusId(TranStatusEnum.DEFAULT.id());
        transactionEntity.setCategoryId(CategoryMatcher.matchCategory(tran.getDescription()).getId());
        transactionEntity.setTranAmount(tran.getAmount());
        transactionEntity.setTranDate(new Timestamp(tran.getPostDate().toEpochDay()));
        transactionEntity.setTranDesc(tran.getDescription());
        transactionEntity.setTranRefNum(tran.getReferenceNumber());
        transactionEntity.setTypeId(tran.getType().id());
        transactionEntity.setTranNum(tran.getSerialNumber());
        TransactionDAO.saveOrUpdate(transactionEntity);
    }



}
