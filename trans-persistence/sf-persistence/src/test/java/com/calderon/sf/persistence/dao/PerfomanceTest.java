package com.calderon.sf.persistence.dao;

import com.calderon.sf.persistence.dto.BankEntity;
import com.calderon.sf.persistence.util.HibernateHelper;
import org.hibernate.Session;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Nathaniel on 6/26/2017.
 */
public class PerfomanceTest {
    Session session;
    @Test
    public void testPerfomance() throws Exception {
        System.out.println(session.bySimpleNaturalId(BankEntity.class).load("Banco Popular Dominicano"));
        System.out.println(session.bySimpleNaturalId(BankEntity.class).load("Banco Popular Dominicano"));
    }

    @BeforeMethod
    public void setUp() throws Exception {
        session = HibernateHelper.getSessionFactory().openSession();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        if(session.isOpen())
            session.close();
    }

    @DataProvider(name = "Name")
    public static Object[][] Name() {
        return new Object[][] {

        };
    }
}
