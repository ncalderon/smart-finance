package com.calderon.sf.reader;

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

    @Test(enabled = true)
    public void TestReadTransaction () throws IOException {
        CsvReader csvReader = new CsvReader(Paths.get("..\\..\\repository\\bpd\\pdcsvexport.csv"));
        csvReader.getTransactions().forEach(System.out::println);
        assertTrue(true);
    }

    @Test(enabled = false)
    public void TestReadMetaData () throws IOException {


        CsvReader csvReader = new CsvReader(Paths.get("..\\..\\repository\\bpd\\pdcsvexport.csv"));
        System.out.println(csvReader.getMetadata());
        assertTrue(true);


    }

    @Test(enabled = false)
    public void TestDirectory() throws IOException {
        Files.list(path).forEach(System.out::println);
        System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));

    }
}
