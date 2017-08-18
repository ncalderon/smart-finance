package com.calderon.sf.persistence.dao;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Nathaniel on 6/18/2017.
 */
public class BankDAOTest {
    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetBankByName() throws Exception {
        assertNotEquals(BankDAO.getBankByName("Banco Popular Dominicano"), null);
    }

}