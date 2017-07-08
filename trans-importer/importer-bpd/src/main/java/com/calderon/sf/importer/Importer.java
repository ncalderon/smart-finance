package com.calderon.sf.importer;

import com.calderon.sf.importer.helpers.AccountHelper;
import com.calderon.sf.importer.helpers.BankHelper;
import com.calderon.sf.importer.parser.TransactionParser;
import com.calderon.sf.persistence.dao.TransactionDAO;
import com.calderon.sf.persistence.dto.AccountEntity;
import com.calderon.sf.persistence.dto.BankEntity;
import com.calderon.sf.persistence.dto.TransactionEntity;
import com.calderon.sf.reader.*;
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
    private static final String DEFAULT_SOURCE_PATH = "repository/bpd";
    private final Path repository;

    public Importer() {
        this(Paths.get(DEFAULT_SOURCE_PATH));
        init();
    }
    public Importer(Path sourcePath) {
        this.repository = sourcePath;
        init();
    }

    public void doImport()throws IOException {
        log.info("Seeking files from Repository: ", repository);
        seekPendingFiles().filter(this::filterValidFiles).forEach(this::processFile);
    }

    private void init()  {

    }

    private Stream<Path> seekPendingFiles() throws IOException {
        return Files.list(repository);
    }

    private boolean filterValidFiles (Path path) {
        log.info("Validating file: " + path);
        String filename = path.getFileName().toString();
        return Files.isRegularFile(path) && !filename.contains(".ignore") && filename.endsWith(".csv");
    }

    private void processFile (Path source)  {
        log.info("Processing file: " + source);
        Reader reader = new CsvReader(source);
        AccountEntity account = new AccountHelper(reader.getAccount()).getAccount();
        BankEntity bank = new BankHelper(reader.getAccount().getBank()).getBank();
        log.info("Currently account: " + account);
        List<TransactionEntity> transactions = reader.getTransactions().stream().map(x->parseTransaction(x)).collect(Collectors.toList());
        boolean result = TransactionDAO.saveTransactions(bank, account, transactions);
        if(result)
            reader.markAsImported();
    }

    private TransactionEntity parseTransaction (Transaction tran) {
        log.info("Transaction to process: " + tran);
        return TransactionParser.parse(tran);
    }
}
