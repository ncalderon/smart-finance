package com.calderon.sf.em.data.service;

import com.calderon.sf.em.data.model.ExpenseReportEntity;
import com.calderon.sf.em.data.repository.ExpenseReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExpenseReportServiceImpl implements ExpenseReportService {

    private ExpenseReportRepository repository;

    @Autowired
    public void setRepository(ExpenseReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ExpenseReportEntity> findByAccount(String account) {
        return repository.findByAccount(account);
    }

    @Transactional
    @Override
    public void save(List<ExpenseReportEntity> reports) {
        repository.save(reports);
    }
    @Transactional
    @Override
    public void save(ExpenseReportEntity report) {
        repository.save(report);
    }
}
