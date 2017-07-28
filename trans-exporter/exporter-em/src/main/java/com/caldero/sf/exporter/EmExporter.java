package com.caldero.sf.exporter;

import com.caldero.sf.exporter.parser.ReportParser;
import com.calderon.sf.api.exporter.Exporter;
import com.calderon.sf.commons.persistence.enums.TranStatusEnum;
import com.calderon.sf.persistence.dao.TransactionDAO;
import com.calderon.sf.persistence.dto.TransactionEntity;
import com.calderon.sf.persistence.external.em.dao.ReportDAO;
import com.calderon.sf.persistence.external.em.dto.ExpenseReportEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nathaniel on 6/18/2017.
 */
public class EmExporter implements Exporter {
    private static final Logger log = LogManager.getLogger(Exporter.class.getName());
    private List<TransactionEntity> transactions;
    private List<ExpenseReportEntity> reports;


    public EmExporter() {
        init();
    }

    public static void main(String... args) {
        Exporter exporter = new EmExporter();
        exporter.export();
    }

    private void init() {
        log.info("Initializing exporter process...");
        seekPendingTransactions();
        parseTransactions();
    }

    private void seekPendingTransactions() {
        log.info("Trying to get pending transactions...");
        transactions = TransactionDAO.getPendingTransactions();

    }

    private void parseTransactions() {
        log.info("Trying to parse Transactions to Reports...");
        reports = transactions.stream().map(x -> ReportParser.parse(x)).collect(Collectors.toList());
    }

    private boolean updateToStatusExported() {
        return TransactionDAO.updateStatus(transactions, TranStatusEnum.EXPORTED);
    }

    public boolean export() {
        log.info("Transactions to export: " + reports.size());
        boolean result = ReportDAO.saveReports(reports);
        log.info("Transaction export success was: " + result);
        if (result)
            result = updateToStatusExported();
        return result;
    }
}
