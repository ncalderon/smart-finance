package com.calderon.sf.importer;

import com.calderon.sf.reader.CsvReader;
import com.calderoncode.sf.importer.Importer;
import com.calderoncode.sf.reader.Reader;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class ImporterTest extends AbstractBasicTest {
    @Autowired
    private Importer importer;
    private static final Path path = Paths.get("../../repository/bpd/JetBlue RD.0728.csv");

    @Test
    public void doImport(){
        assertThat(importer).isNotNull();
        Reader reader = new CsvReader(path);
        importer.doImport(reader);
    }
}
