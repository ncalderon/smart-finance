package com.calderon.finance.handlers;

import com.calderon.finance.SourceMetadata;
import com.calderon.finance.Transaction;

/**
 * Created by Nathaniel on 5/28/2017.
 */
public interface Handler extends Runnable{
    void perform (SourceMetadata sourceMetadata, Transaction transaction);
}
