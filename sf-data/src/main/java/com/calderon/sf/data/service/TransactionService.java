package com.calderon.sf.data.service;

import com.calderon.sf.commons.persistence.enums.TranStatusEnum;
import com.calderon.sf.data.model.TransactionEntity;

import java.util.List;

public interface TransactionService {
    TransactionEntity findFirstByAccountIdAndTranNum(Integer accountId, String tranNum);
    List<TransactionEntity> findByPendingStatus();
    void saveTransactions(List<TransactionEntity> transactions);
}
