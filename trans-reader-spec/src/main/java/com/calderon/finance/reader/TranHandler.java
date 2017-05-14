package com.calderon.finance.reader;

import java.util.stream.Stream;

/**
 * Created by Nathaniel on 3/13/2017.
 */
public interface TranHandler {

    void perform(SourceMetadata sourceMetadata, Stream<Transaction> rawTran);
}
