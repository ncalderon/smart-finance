package com.calderon.finance.finance;

import static org.junit.Assert.*;

import com.calderon.finance.FileUtil;
import org.junit.Test;

/**
 * Created by Nathaniel on 5/28/2017.
 */
public class FileUtilTest {
    @Test
    public void testExtractYear () {
        assertTrue(FileUtil.extractYear("2001u833432") == 2001);
        assertTrue(FileUtil.extractYear("20ff01u833432") == 2017);
    }
}
