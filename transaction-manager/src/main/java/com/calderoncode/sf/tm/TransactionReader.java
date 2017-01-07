package com.calderoncode.sf.tm;

import com.calderoncode.sf.tm.dto.TransactionEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Nathaniel on 1/3/2017.
 */
public class TransactionReader {
    Path bankFile;
    List<TransactionEntity> transactions;
    public TransactionReader(Path bankFile) {
        if (bankFile == null)
            throw new IllegalArgumentException("File doesn't exist or isn't a file.");
        this.bankFile = bankFile;
    }

    public void process () throws IOException {
            //Files.lines(bankFile).filter((String line) -> { return true; }).map((String line) -> { return new TransactionEntity();}).;

    }

    public List<TransactionEntity> getTransactions () {
        return transactions;
    }
}
