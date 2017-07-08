package com.calderon.sf.reader;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


/**
 * Created by Nathaniel on 5/27/2017.
 */
public class CSVReaderTest {

    private static final Path path = Paths.get("../../repository/bpd/");
    private CsvReader csvReader;

    @Test(enabled = false)
    public void TestReadTransaction () throws IOException {
        csvReader.getTransactions().forEach(System.out::println);
        assertTrue(true);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        csvReader = new CsvReader(Paths.get("..\\..\\repository\\bpd\\Gold US.ANTEPENULTIMO.ignore.csv"));
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testReadAccount() throws Exception {
        Account account = csvReader.getAccount();
        System.out.println("account = " + account);
        assertTrue(account != null);
    }

    @Test
    public void testMarkFileAsImported() throws Exception {
        csvReader.markAsImported();
        assertTrue(true);
    }

    @Test(enabled = false)
    public void TestDirectory() throws IOException {
        Files.list(path).forEach(System.out::println);
        System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));

    }
}
