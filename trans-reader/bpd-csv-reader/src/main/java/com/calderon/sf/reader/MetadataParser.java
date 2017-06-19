package com.calderon.sf.reader;

import java.text.ParsePosition;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private static final String accountLabelToRemove = "Cuenta: ************";

    public static CsvMetadata parse (String sourceName, String contentMeta, String separator) {

        //String[] metaFromSourcename = sourceName.split(separator);
        String[] metaFromContent = contentMeta.split(separator);

        return new CsvMetadata.Builder()
                .setSourceName(sourceName.substring(0, sourceName.indexOf(".")))
                .setSourceType(sourceName.substring(sourceName.indexOf(".")+1))
                .setAccountName(metaFromContent[ACCOUNT_INDEX].replace(accountLabelToRemove, ""))
                .setAccountNumber(metaFromContent[ACCOUNT_INDEX].replace(accountLabelToRemove, ""))
                .setBankName(metaFromContent[BANK_NAME_INDEX])
                .setAccountType(metaFromContent[ACCOUNT_INDEX].indexOf("************") == -1? AccountTypeEnum.DEFAULT: AccountTypeEnum.CREDIT_CARD)
                .setCreated(MetadataParser.parseGenDate(metaFromContent[GENERATE_DATE_INDEX]))
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
