package com.calderon.finance;

import java.util.stream.Stream;

/**
 * Created by Nathaniel on 3/13/2017.
 */
public interface TranHandler {

    void perform(SourceMetadata sourceMetadata, Stream<Transaction> rawTran);
}
