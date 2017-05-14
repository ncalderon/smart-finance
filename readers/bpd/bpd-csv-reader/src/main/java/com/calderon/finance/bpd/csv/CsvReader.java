package com.calderon.finance.bpd.csv;

import com.calderon.finance.reader.Reader;
import com.calderon.finance.reader.SourceMetadata;
import com.calderon.finance.reader.TranHandler;
import com.calderon.finance.reader.Transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nathaniel on 3/18/2017.
 */
public class CsvReader implements Reader {
    private Path source;
    private static final long TRANSACTION_START_INDEX = 12L;
    private static final long TRANSACTION_HEADER_INDEX = 11L;
    private static final long META_DATA_END__INDEX = 8L;

    private static final String META_SEPARATOR = "|";
    public CsvReader (Path source) {
        if (!Files.isRegularFile(source))
            throw new IllegalArgumentException("Source must be a file.");
        this.source = source;
    }

    public Stream<Transaction> readTransactions() throws IOException {
        return Files
                .lines(source)
                .skip(TRANSACTION_START_INDEX-1)
                .parallel()
                .filter(TransactionFilter::filter)
                .map(TransactionParser::parse)
                ;
    }

    public SourceMetadata readMetaData() throws IOException {
        String contentMeta = Files
                            .lines(source)
                            .limit(META_DATA_END__INDEX)
                            .filter(CsvMetadataFilter::filter)
                            .collect(Collectors.joining(META_SEPARATOR));

        return MetadataParser.parse(source.getFileName().toString(), contentMeta, META_SEPARATOR);

    }
}
