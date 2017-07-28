package com.calderon.sf.api.reader.filter;

import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Created by Nathaniel on 6/25/2017.
 */
public class TransactionFilters {
    private static final String transactionRegex = "^\\d\\d\\/\\d\\d,.+$";
    public static Predicate<String> isTransaction () {
        return s -> Pattern.matches(transactionRegex, s);
    }
}
