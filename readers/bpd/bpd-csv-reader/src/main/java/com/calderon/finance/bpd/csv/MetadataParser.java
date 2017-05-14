package com.calderon.finance.bpd.csv;

import java.text.ParsePosition;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * Created by Nathaniel on 3/19/2017.
 */
public class MetadataParser {

    /*FILENAME METADATA*/
    private static final int SOURCENAME_INDEX = 0;

    private static final int SOURCE_TYPE_INDEX = 1;
    private static final int ACCOUNT_NAME_INDEX = 2;


    /*CONTENT METADATA*/
    private static final int FULLNAME_INDEX = 0;
    private static final int REPORT_NAME_INDEX = 1;
    private static final int DATE_RANGE_INDEX = 2;
    private static final int GENERATE_DATE_INDEX = 3;
    private static final int GEN_DATE_COLUMN_START_INDEX = 12;
    private static final String GEN_DATE_PATTERN = "dd/MM/yyyy hh:mm:ss a";

    private static final int BANK_NAME_INDEX = 4;
    private static final int ACCOUNT_INDEX = 5;

    public static CsvMetadata parse (String sourceName, String contentMeta, String separator) {

        String[] metaFromSourcename = sourceName.split(separator);
        String[] metaFromContent = contentMeta.split(separator);

        return new CsvMetadata.Builder()
                .setSourceName(metaFromSourcename[SOURCENAME_INDEX])
                .setSourceType(metaFromSourcename[SOURCE_TYPE_INDEX])
                .setAccountName(metaFromSourcename[ACCOUNT_NAME_INDEX])
                .setAccountNumber(metaFromContent[ACCOUNT_INDEX])
                .setBankName(metaFromContent[BANK_NAME_INDEX])
                .setCreated(MetadataParser.parseGenDate(GEN_DATE_PATTERN))
                .build()
                ;

    }

    private static final LocalDateTime parseGenDate (String date) {
        return LocalDateTime.from(
                DateTimeFormatter.ofPattern(GEN_DATE_PATTERN)
                .parse(date, new ParsePosition(GEN_DATE_COLUMN_START_INDEX))
        );
    }


}
