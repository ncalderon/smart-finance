package com.calderon.sf.em.data.service;

import com.calderon.sf.em.data.model.ExpenseReportEntity;

import java.util.List;

public interface ExpenseReportService {
    List<ExpenseReportEntity> findByAccount(String account);
    void save(List<ExpenseReportEntity> reports);
    void save(ExpenseReportEntity report);
}
