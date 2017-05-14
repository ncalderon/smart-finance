package com.calderon.finance;

import com.calderon.finance.bpd.csv.CsvReader;
import com.calderon.finance.reader.SourceMetadata;

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
        Stream<Path> pendingFiles = seekPendingFiles();
        pendingFiles.filter(Files::isRegularFile).forEach(this::processFile);
    }

    private Stream<Path> seekPendingFiles() throws IOException {
        return Files.list(Paths.get(CUSTOM_SOURCE_PATH.isEmpty()? DEFAULT_SOURCE_PATH:CUSTOM_SOURCE_PATH));
    }

    private void processFile (Path source) throws RuntimeException {
        try {
            CsvReader reader = new CsvReader(source);
            SourceMetadata sourceMetadata = reader.readMetaData();
            // TODO: Guardar account
            reader.readTransactions().map(x->x);
            // TODO: Guardar transactions
        }catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
