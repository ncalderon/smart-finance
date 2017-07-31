package com.calderon.sf.data.service;

import com.calderon.sf.commons.persistence.enums.TranStatusEnum;
import com.calderon.sf.data.model.TransactionEntity;
import com.calderon.sf.data.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository repository;

    @Autowired
    public void setRepository(TransactionRepository repository) {
        this.repository = repository;
    }

    public TransactionEntity findFirstByAccountIdAndTranNum(Integer accountId, String tranNum) {
        return repository.findFirstByAccountIdAndTranNum(accountId, tranNum);
    }

    public List<TransactionEntity> findByPendingStatus() {
        return repository.findByStatusIdOrderByTranPostDateAsc(TranStatusEnum.PENDING.id());
    }

    public void saveTransactions(List<TransactionEntity> transactions) {
        repository.save(transactions);
    }
}
