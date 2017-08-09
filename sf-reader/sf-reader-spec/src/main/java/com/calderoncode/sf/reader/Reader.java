package com.calderoncode.sf.reader;

import java.util.List;

/**
 * Created by Nathaniel on 3/13/2017.
 */
public interface Reader {
    Account getAccount();
    List<Transaction> getTransactions();
    void markAsImported();
}
