package com.calderon.sf.data.repository;

import com.calderon.sf.data.model.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
    TransactionEntity findFirstByAccountIdAndTranNum(Integer accountId, String tranNum);
    List<TransactionEntity> findByStatusIdOrderByTranPostDateAsc(Integer statusId);
}
