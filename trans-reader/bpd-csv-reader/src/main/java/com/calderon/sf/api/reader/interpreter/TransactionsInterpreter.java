package com.calderon.sf.api.reader.interpreter;

import com.calderon.sf.api.reader.Transaction;
import com.calderon.sf.api.reader.Account;
import com.calderon.sf.api.reader.filter.TransactionFilters;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nathaniel on 7/3/2017.
 */
public class TransactionsInterpreter implements BodyInterpreter<List<Transaction>> {

    private static final int TRANSACTION_START_INDEX = 11;
    private static final int TRANSACTION_HEADER_INDEX = 11;

    private Stream<String> fileLines;
    private Account account;

    public TransactionsInterpreter(Stream<String> fileLines, Account account) {
        this.fileLines = fileLines;
        this.account = account;
    }

    @Override
    public List<Transaction> interpret() {
        return fileLines.skip(TRANSACTION_HEADER_INDEX)
                .filter(TransactionFilters.isTransaction())
                .map(s-> new TransactionInterpreter(s, account).interpret())
                .collect(Collectors.toList());
    }
}
