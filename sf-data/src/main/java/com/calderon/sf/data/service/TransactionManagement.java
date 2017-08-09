package com.calderon.sf.data.service;

import com.calderon.sf.data.model.AccountEntity;
import com.calderon.sf.data.model.BankEntity;
import com.calderon.sf.data.model.TransactionEntity;

import java.util.List;

public interface TransactionManagement {
    public void save(BankEntity bank, AccountEntity account, List<TransactionEntity> transactions);
    public void save(BankEntity bank, AccountEntity account, TransactionEntity transaction);
}
