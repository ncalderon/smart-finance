package com.calderon.sf.exporter;

import com.calderon.sf.data.service.TransactionService;
import com.calderon.sf.exporter.parser.TransactionParser;
import com.calderoncode.sf.transport.Transaction;
import com.calderoncode.sf.writer.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*@Component*/
public class DbExporter implements Exporter{
    private TransactionService transactionService;

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Autowired
    @Override
    public void doExport(Writer writer) {
        List<Transaction> transactions = transactionService.findByPendingStatus().stream().map(t-> TransactionParser.parse(t)).collect(Collectors.toList());
        writer.write(transactions);
    }
}
