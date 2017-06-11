package com.calderon.sf.importer;

import com.calderon.sf.persistence.dto.AccountEntity;
import com.calderon.sf.reader.CsvReader;
import com.calderon.sf.reader.Transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Nathaniel on 3/24/2017.
 */
public class Importer {
    private static final String DEFAULT_SOURCE_PATH = "bpd/import";
    private final String CUSTOM_SOURCE_PATH;

    public Importer() {
        this("");
    }
    public Importer(String sourcePath) {
        this.CUSTOM_SOURCE_PATH = sourcePath;
    }
    public void doImport()throws IOException {
        init();
    }

    private void init() throws IOException {
        seekPendingFiles().filter(this::filterValidFiles).forEach(this::processFile);
    }

    private Stream<Path> seekPendingFiles() throws IOException {
        return Files.list(Paths.get(CUSTOM_SOURCE_PATH.isEmpty()? DEFAULT_SOURCE_PATH:CUSTOM_SOURCE_PATH));
    }

    private boolean filterValidFiles (Path path) {
        return Files.isRegularFile(path);
    }

    private void processFile (Path source) throws RuntimeException {
        try {
            CsvReader reader = new CsvReader(source);
            TranMetadataHelper metadataHelper = new TranMetadataHelper(reader.readMetaData());
            AccountEntity account = metadataHelper.getAccount();
            reader.readTransactions().forEach(x->processTransaction(account, x));
        }catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void processTransaction (AccountEntity account, Transaction transaction) {
        TranHandler handler = new TranHandler(account, transaction);
        handler.perform();
    }
}
