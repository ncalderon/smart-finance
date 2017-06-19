package com.calderon.sf.exporter;

import com.calderon.sf.exporter.parser.ReportParser;
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
public class Exporter {
    private static final Logger log = LogManager.getLogger(Exporter.class.getName());
    public static void main (String ... args) {
        Exporter exporter = new Exporter();
        exporter.init();
    }

    public void init() {
        log.info("Initializing exporter process...");
        List<ExpenseReportEntity> reports = getReports();
        log.info("Count of transactions found: " + reports.size());
        doExport(reports);
    }

    private List<ExpenseReportEntity> getReports() {
        log.info("Trying to get pending transactions...");
        return TransactionDAO
                .getPendingTransactions()
                .stream()
                .map(x-> ReportParser.parse(x)).collect(Collectors.toList());
    }

    private void doExport(List<ExpenseReportEntity> reports){
        ReportDAO.saveReports(reports);
    }
}
