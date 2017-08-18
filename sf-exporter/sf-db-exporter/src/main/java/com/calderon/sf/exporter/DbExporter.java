package com.calderon.sf.exporter;

import com.calderon.sf.data.model.TransactionEntity;
import com.calderon.sf.data.service.TransactionService;
import com.calderon.sf.exporter.parser.TransactionParser;
import com.calderoncode.sf.transport.TranStatusEnum;
import com.calderoncode.sf.transport.Transaction;
import com.calderoncode.sf.writer.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DbExporter implements Exporter{
    private TransactionService transactionService;

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /*public TransactionService getTransactionService() {
        return transactionService;
    }*/

    /*@Autowired*/
    @Override
    public void doExport(Writer writer) {
        List<TransactionEntity> pendingTransactions = transactionService.findByPendingStatus();
        List<Transaction> transactions = pendingTransactions.stream().map(t-> TransactionParser.parse(t)).collect(Collectors.toList());
        writer.write(transactions);
        pendingTransactions.stream().forEach(t->t.setStatusId(TranStatusEnum.EXPORTED.id()));
        transactionService.save(pendingTransactions);
    }
}
