package com.calderon.sf.em.writer.parser;

import com.calderon.sf.em.data.model.ExpenseReportEntity;
import com.calderoncode.sf.transport.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ExpenseReportParser {
    private static final String defaultStatus = "Cleared";
    private static final String defaultProperty4 = "1 PCS";
    private static final String defaultSubCategory = "Other";
    private static final Logger log = LogManager.getLogger(ExpenseReportParser.class);
    public static final ExpenseReportEntity parse (Transaction tran) {
        log.info("Parsing transaction: " + tran);
        ExpenseReportEntity report = new ExpenseReportEntity();
        report.setAccount(tran.getAccount().getName());
        report.setCategory(tran.getCategory().codename());
        report.setSubcategory(defaultSubCategory);
        report.setDescription(tran.getTranDesc());
        report.setPaymentMethod(tran.getTranMethod().codename());
        report.setExpensed(tran.getTranPostDate().getTime());
        report.setModified(tran.getTranPostDate().getTime());
        report.setAmount(tran.getTranAmount().toString());
        report.setStatus(defaultStatus);
        report.setProperty4(defaultProperty4);
        report.setReferenceNumber(tran.getTranRefNum());
        return report;
    }
}
