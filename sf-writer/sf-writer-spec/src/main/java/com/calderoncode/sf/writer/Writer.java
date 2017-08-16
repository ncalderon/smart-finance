package com.calderoncode.sf.writer;

import com.calderoncode.sf.transport.Transaction;

import java.util.List;

public interface Writer {
    void write(List<Transaction> transactions);
    void write(Transaction transaction);
}
