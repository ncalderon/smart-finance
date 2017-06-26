package com.calderon.sf.reader.interpreter;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nathaniel on 6/25/2017.
 */
public class AccountLinesInterpreter implements BodyInterpreter<String> {

    private Stream<String> lines;
    private static final int ACCOUNT_LINES_BEGIN_INDEX = 1;
    private static final int ACCOUNT_LINES_END_INDEX = 8;
    private static final String META_SEPARATOR = ",";

    public AccountLinesInterpreter(Stream<String> lines) {
        this.lines = lines;
    }

    @Override
    public String interpret() {
        return lines.skip(ACCOUNT_LINES_BEGIN_INDEX)
                .limit(ACCOUNT_LINES_END_INDEX)
                .filter(String::isEmpty)
                .collect(Collectors.joining(META_SEPARATOR));

    }
}
