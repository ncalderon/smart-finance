package com.calderon.sf.exporter.parser;

import com.calderon.sf.commons.persistence.enums.TranMethodEnum;
import com.calderon.sf.exporter.Exporter;
import com.calderon.sf.persistence.dao.CategoryDAO;
import com.calderon.sf.persistence.dto.TranCategoryEntity;
import com.calderon.sf.persistence.dto.TransactionEntity;
import com.calderon.sf.persistence.external.em.dto.ExpenseReportEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Nathaniel on 6/18/2017.
 */
public class ReportParser {
    private static final String defaultStatus = "Uncleared";
    private static final String defaultProperty4 = "1 PCS";
    private static final Logger log = LogManager.getLogger(ReportParser.class.getName());
    public static final ExpenseReportEntity parse (TransactionEntity tran) {
        log.info("Parsing transaction: " + tran);
        ExpenseReportEntity report = new ExpenseReportEntity();
        report.setAccount(tran.getAccountByAccountId().getAccName());
        report.setCategory(tran.getTranCategoryByCategoryId().getName());
        if(tran.getTranCategoryByCategoryId().getParentId() != 0)
            report.setSubcategory(CategoryDAO.get(tran.getTranCategoryByCategoryId().getParentId()).getName());
        report.setDescription(tran.getTranDesc());
        report.setPaymentMethod(TranMethodEnum.valueOf(tran.getTranMethod()).codename());
        report.setExpensed(tran.getTranPostDate().getTime());
        report.setModified(tran.getCreated().getTime());
        report.setAmount(tran.getTranAmount().toString());
        report.setStatus(defaultStatus);
        report.setProperty4(defaultProperty4);
        return report;
    }
}
