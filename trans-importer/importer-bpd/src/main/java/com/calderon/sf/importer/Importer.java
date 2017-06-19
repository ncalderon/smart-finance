package com.calderon.sf.importer;

import com.calderon.sf.persistence.dao.TransactionDAO;
import com.calderon.sf.persistence.dto.AccountEntity;
import com.calderon.sf.persistence.dto.TransactionEntity;
import com.calderon.sf.reader.CsvReader;
import com.calderon.sf.reader.Reader;
import com.calderon.sf.reader.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nathaniel on 3/24/2017.
 */
public class Importer {
    private static final Logger log = LogManager.getLogger(Importer.class.getName());
    private static final String DEFAULT_SOURCE_PATH = "bpd/import";
    private final Path repository;

    public Importer() {
        this(Paths.get(DEFAULT_SOURCE_PATH));
    }
    public Importer(Path sourcePath) {
        this.repository = sourcePath;
    }
    public void doImport()throws IOException {
        init();
    }

    private void init() throws IOException {
        log.info("Seeking files from Repository: ", repository);
        seekPendingFiles().filter(this::filterValidFiles).forEach(this::processFile);
    }

    private Stream<Path> seekPendingFiles() throws IOException {
        return Files.list(repository);
    }

    private boolean filterValidFiles (Path path) {
        log.info("Validating file: " + path);
        return Files.isRegularFile(path) && path.getFileName().toString().endsWith(".csv");
    }

    private void processFile (Path source)  {
        log.info("Processing file: " + source);
        Reader reader = new CsvReader(source);
        TranMetadataHelper metadataHelper = new TranMetadataHelper(reader.getMetadata());
        AccountEntity account = metadataHelper.getAccount();
        log.info("Currently account: " + account);
        List<TransactionEntity> transactions = reader.getTransactions().stream().map(x->parseTransaction(x)).collect(Collectors.toList());
        TransactionDAO.saveTransactions(account, transactions);
        reader.getTransactions().stream().forEach(x->processTransaction(account, x));
    }

    private TransactionEntity parseTransaction (Transaction tran) {
        return TransactionParser.parse(tran);
    }

    private void processTransaction (AccountEntity account, Transaction transaction) {
        TranHandler handler = new TranHandler(account, transaction);
        log.info("Transaction to process: " + transaction);
        handler.perform();

    }
}
