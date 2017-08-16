package com.calderon.sf.em.writer;

import com.calderon.sf.em.data.model.ExpenseReportEntity;
import com.calderon.sf.em.data.service.ExpenseReportService;
import com.calderon.sf.em.writer.parser.ExpenseReportParser;
import com.calderoncode.sf.transport.Transaction;
import com.calderoncode.sf.writer.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class DbWriter implements Writer {
    private ExpenseReportService service;
    @Autowired
    public void setService(ExpenseReportService service) {
        this.service = service;
    }

    @Override
    public void write(List<Transaction> transactions) {
        List<ExpenseReportEntity> reports = transactions.stream().map(t->ExpenseReportParser.parse(t)).collect(Collectors.toList());
        service.save(reports);
    }

    @Override
    public void write(Transaction transaction) {
        service.save(ExpenseReportParser.parse(transaction));
    }
}
