package com.calderon.sf.reader;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Nathaniel on 3/13/2017.
 */
public interface Reader {
    List<Transaction> getTransactions();
    TranMetadata getMetadata();
}
