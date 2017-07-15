package com.calderon.sf.persistence.external.em.dao;

import com.calderon.sf.persistence.external.em.dto.ExpenseReportEntity;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Nathaniel on 6/18/2017.
 */
public class ReportDAOTest {
    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetReportsByAccount() throws Exception {
        List<ExpenseReportEntity> list = ReportDAO.getReportsByAccount("JetBlue RD");
        System.out.println(list);
        assertTrue(list.size() > 0);
    }

}