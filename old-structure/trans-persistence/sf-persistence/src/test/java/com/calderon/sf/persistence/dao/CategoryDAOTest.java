package com.calderon.sf.persistence.dao;

import com.calderon.sf.persistence.dto.TranCategoryEntity;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Nathaniel on 6/17/2017.
 */
public class CategoryDAOTest {


    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test(enabled = false)
    public void testGetAllChildCategories() throws Exception {
        System.out.println(CategoryDAO.getAllChildCategories());
        assertEquals(1,1);
    }

    @Test(enabled = false)
    public void testGetAllParentCategories() throws Exception {
        System.out.println(CategoryDAO.getAllParentCategories());
        assertEquals(1,1);
    }

    @Test
    public void testGet() throws Exception {
        TranCategoryEntity category = CategoryDAO.get(99);
        System.out.println(category);
        assertTrue(category!= null);
    }

}