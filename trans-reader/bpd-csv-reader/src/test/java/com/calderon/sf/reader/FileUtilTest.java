package com.calderon.sf.reader;



import com.calderon.sf.reader.FileUtil;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by Nathaniel on 5/28/2017.
 */
public class FileUtilTest {
    @Test(enabled = false)
    public void testExtractYear () {
        assertTrue(FileUtil.extractYear("2001u833432") == 2001);
        assertTrue(FileUtil.extractYear("20ff01u833432") == 2017);
    }
}
