package com.calderon.finance.reader;

import java.util.stream.Stream;

/**
 * Created by Nathaniel on 3/13/2017.
 */
public interface Reader {
    Stream<Transaction> readTransactions() throws Exception;
    SourceMetadata readMetaData() throws Exception;
}
