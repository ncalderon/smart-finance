package com.calderon.sf.em.data.repository;

import com.calderon.sf.em.data.model.ExpenseReportEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpenseReportRepository extends CrudRepository<ExpenseReportEntity, Long>{
    List<ExpenseReportEntity> findByAccount(String account);
}
