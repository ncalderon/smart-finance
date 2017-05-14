package com.calderon.file;

import com.calderon.dto.TransactionEntity;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by Nathaniel on 1/3/2017.
 */
public class FileReader {
    Path bankFile;
    List<TransactionEntity> transactions;
    public FileReader(Path bankFile) {
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
