package com.calderon.finance;

import java.util.regex.Pattern;

/**
 * Created by Nathaniel on 3/18/2017.
 */
class TransactionFilter {
    private static final String regex = "^\\d\\d\\/\\d\\d,.+$";
    public static boolean filter (String text) {
        return !text.isEmpty() && Pattern.matches(regex, text);
    }
}
