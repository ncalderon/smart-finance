package com.calderon.sf.reader.parser;

import java.text.ParsePosition;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Nathaniel on 6/24/2017.
 */
public class DatetimeParser {

    /*public static final LocalDateTime parse(String date) {
        return parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME., null);
    }*/
    public static final LocalDateTime parse (String date, String pattern, ParsePosition parsePosition) {
        return LocalDateTime.from(
                DateTimeFormatter.ofPattern(pattern)
                        .parse(date, parsePosition)
        );
    }
}
