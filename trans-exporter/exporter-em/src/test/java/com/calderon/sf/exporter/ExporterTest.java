package com.calderon.sf.exporter;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Nathaniel on 6/19/2017.
 */
public class ExporterTest {
    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testInit() throws Exception {
        Exporter exporter = new Exporter();
        exporter.init();
        assertEquals(1,1);
    }

}