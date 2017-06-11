package com.calderon.sf.reader;

import java.util.stream.Stream;

/**
 * Created by Nathaniel on 3/13/2017.
 */
public interface TranHandler {

    void perform(TranMetadata tranMetadata, Stream<Transaction> rawTran);
}
