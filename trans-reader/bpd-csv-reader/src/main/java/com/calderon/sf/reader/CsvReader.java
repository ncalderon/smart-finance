package com.calderon.sf.reader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nathaniel on 3/18/2017.
 */
public class CsvReader implements Reader {

    private static final long TRANSACTION_START_INDEX = 12L;
    private static final long TRANSACTION_HEADER_INDEX = 11L;
    private static final long META_DATA_END_INDEX = 8L;
    private static final String ENCODING = "CP1252";
    private static final String META_SEPARATOR = ",";

    private final Path source;

    private TranMetadata metadata;
    private List<Transaction> transactions;

    public CsvReader (Path source) {
        if (!Files.isRegularFile(source))
            throw new IllegalArgumentException("Source must be a file.");
        this.source = source;
        this.load();
    }

    private void load ()  {
        try {
            this.metadata = readMetadata();
            this.transactions = readTransactions().collect(Collectors.toList());
        } catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public TranMetadata getMetadata() {
        return metadata;
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }

    private Stream<Transaction> readTransactions() throws IOException {
        return Files
                .lines(source, Charset.forName(ENCODING))
                .skip(TRANSACTION_START_INDEX-1)
                /*.parallel()*/
                .filter(TransactionFilter::filter)
                .map(s->metadata.getCreated().getYear()+"/"+s)
                .map(TransactionParser::parse)
                ;
    }

    private TranMetadata readMetadata () throws IOException {
        String contentMeta = Files
                            .lines(source, Charset.forName(ENCODING))
                            .limit(META_DATA_END_INDEX)
                            .filter(CsvMetadataFilter::filter)
                            .collect(Collectors.joining(META_SEPARATOR));

        return MetadataParser.parse(source.getFileName().toString(), contentMeta, META_SEPARATOR);

    }
}
