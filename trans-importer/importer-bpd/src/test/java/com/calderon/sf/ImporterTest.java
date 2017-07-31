package com.calderon.sf.api.importers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.*;
/**
 * Created by Nathaniel on 6/15/2017.
 */
public class ImporterTest {

    private static final Path path = Paths.get("../../repository/bpd/");
    private static final Logger logger = LogManager.getLogger(Importer.class);
    @Test(enabled = false)
    public static void testImport () throws IOException {
        Importer importer = new Importer(path);
        importer.doImport();
        assertEquals(true, true);
    }

    @Test(enabled = false)
    public void TestDirectory() throws IOException {
        System.out.println(Paths.get("..\\..\\repository\\bpd\\pdcsvexport.csv").getFileName().toString().endsWith(".csv"));
        //Files.list(path).forEach(System.out::println);
        //System.out.println(Importer.class.getSimpleName());
        //System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));

    }
}
