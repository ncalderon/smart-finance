package com.calderon.finance;

import com.calderon.finance.handlers.Handler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Nathaniel on 5/28/2017.
 */
public class ImporterImpl implements Importer{
    private final Path fileRepository;
    private final Reader reader;
    private final Handler handler;

    public ImporterImpl(Path fileRepository, Reader reader, Handler handler) {
        this.fileRepository = fileRepository;
        this.reader = reader;
        this.handler = handler;
    }

    @Override
    public void doImport() throws IOException {
        Files.list(fileRepository).forEach(f->

                );
    }

    private void processFile (Path file) {
        reader
    }
}
