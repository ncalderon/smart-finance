package com.calderon.sf.reader;

import java.util.stream.Stream;

/**
 * Created by Nathaniel on 3/13/2017.
 */
public interface Reader {
    Stream<Transaction> readTransactions() throws Exception;
    TranMetadata readMetaData() throws Exception;
}
