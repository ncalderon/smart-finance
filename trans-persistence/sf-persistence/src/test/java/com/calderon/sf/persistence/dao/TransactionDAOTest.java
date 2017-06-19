package com.calderon.sf.persistence.dao;

import com.calderon.sf.persistence.dto.TransactionEntity;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Nathaniel on 6/19/2017.
 */
public class TransactionDAOTest {
    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testSaveTransactions() throws Exception {
    }

    @Test
    public void testGetPendingTransactions() throws Exception {
        List<TransactionEntity> trans = TransactionDAO.getPendingTransactions();
        trans.stream().forEach(x->System.out.println(x));
    }

}