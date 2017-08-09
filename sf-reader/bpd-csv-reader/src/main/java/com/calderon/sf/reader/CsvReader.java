package com.calderon.sf.reader;

import com.calderon.sf.reader.interpreter.AccountInterpreter;
import com.calderon.sf.reader.interpreter.TransactionsInterpreter;
import com.calderon.sf.reader.interpreter.AccountLinesInterpreter;
import com.calderoncode.sf.reader.Account;
import com.calderoncode.sf.reader.Reader;
import com.calderoncode.sf.reader.Transaction;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Created by Nathaniel on 3/18/2017.
 */
public class CsvReader implements Reader {

    private static final String ENCODING = "CP1252";

    private final String fileName;
    private final Path source;
    private List<Transaction> transactions;
    private Account account;
    private boolean isLoaded = false;

    public CsvReader (Path source) {
        if (!Files.isRegularFile(source))
            throw new IllegalArgumentException("Source must be a real file.");
        if(!source.getFileName().toString().endsWith(".csv"))
            throw new IllegalArgumentException("Source file must be a CSV.");
        this.source = source;
        this.fileName = source.getFileName().toString().replaceAll("\\..*", "" );
    }

    private Stream<String> getLines() throws IOException {
        Stream<String> lines = Files.lines(source, Charset.forName(ENCODING));
        return lines;
    }

    private void load ()  {
        if(isLoaded)
            return;
        try {
            this.account = new AccountInterpreter(new AccountLinesInterpreter(getLines(), fileName).interpret()).interpret();
            this.transactions = new TransactionsInterpreter(getLines(), account).interpret();
            this.orderTransByDate();
                    /*getLines().skip(TRANSACTION_HEADER_INDEX)
                    .filter(TransactionFilters.isTransaction())
                    .map(s-> new TransactionInterpreter(s, account).interpret())
                    .collect(Collectors.toList());*/
            isLoaded = true;
        } catch (IOException e) {
            isLoaded = false;
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {

        }
    }

    private void orderTransByDate(){
        Collections.sort(transactions, Comparator.comparing(Transaction::getPostDate));
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

    public void markAsImported()  {
        try {
            Files.move(source, source.resolveSibling(getNewName()), REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getNewName(){
        String currentName = source.getFileName().toString();
        if(currentName.contains(".ignore"))
            return currentName;
        StringBuilder newName = new StringBuilder(currentName);
        newName.insert(currentName.indexOf("."), ".ignore");
        return newName.toString();
    }

}
