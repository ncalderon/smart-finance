package com.calderon.finance.finance;

import com.calderon.finance.Transaction;
import com.calderon.finance.CsvReader;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

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

    private static final Path path = Paths.get("../../../repository/bpd/");

    @Test()
    public void TestReadTransaction () throws IOException {
        Files.list(path).forEach(f->{
            try {
                CsvReader csvReader = new CsvReader(f);
                Stream<Transaction> transactionsStream = null;
                transactionsStream = csvReader.readTransactions();
                transactionsStream.forEach(System.out::println);
                assertTrue(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Ignore
    @Test
    public void TestDirectory() throws IOException {
        Files.list(path).forEach(System.out::println);
        System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));

    }
}
