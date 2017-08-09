package com.calderon.sf.data.service;

import com.calderon.sf.data.model.TransactionEntity;

import java.util.List;

public interface TransactionService {
    TransactionEntity findFirstByAccountIdAndTranNum(Integer accountId, String tranNum);
    List<TransactionEntity> findByPendingStatus();
    void save(TransactionEntity transaction);
    void save(List<TransactionEntity> transactions);
}
