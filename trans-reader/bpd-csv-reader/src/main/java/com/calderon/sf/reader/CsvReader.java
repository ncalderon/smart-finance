package com.calderon.sf.reader;

import com.calderon.sf.reader.filter.TransactionFilters;
import com.calderon.sf.reader.interpreter.AccountInterpreter;
import com.calderon.sf.reader.interpreter.AccountLinesInterpreter;
import com.calderon.sf.reader.interpreter.TransactionInterpreter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nathaniel on 3/18/2017.
 */
public class CsvReader implements Reader {

    private static final long TRANSACTION_START_INDEX = 12L;
    private static final long TRANSACTION_HEADER_INDEX = 11L;

    private static final String ENCODING = "CP1252";


    private final Path source;
    private List<Transaction> transactions;
    private Account account;
    private boolean isLoaded = false;

    public CsvReader (Path source) {
        if (!Files.isRegularFile(source))
            throw new IllegalArgumentException("Source must be a file.");
        this.source = source;
    }

    private void load ()  {
        if(isLoaded)
            return;
        try {
            Stream<String> lines = Files.lines(source, Charset.forName(ENCODING));
            this.account = new AccountInterpreter(new AccountLinesInterpreter(lines).interpret()).interpret();
            this.transactions =
                    lines.skip(TRANSACTION_HEADER_INDEX)
                    .filter(TransactionFilters.isTransaction())
                    .map(s-> new TransactionInterpreter(s, account).interpret())
                    .collect(Collectors.toList());
            isLoaded = true;
        } catch (IOException e) {
            isLoaded = false;
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {

        }
    }

    @Override
    public Account getAccount() {
        if (false == isLoaded)
            load();
        return account;
    }

    @Override
    public List<Transaction> getTransactions() {
        if (false == isLoaded)
            load();
        return transactions;
    }

}
