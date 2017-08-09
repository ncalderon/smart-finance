package com.calderon.sf.reader.interpreter;

import com.calderoncode.sf.reader.interpreter.BodyInterpreter;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nathaniel on 6/25/2017.
 */
public class AccountLinesInterpreter implements BodyInterpreter<String> {

    private static final int ACCOUNT_LINES_BEGIN_INDEX = 6;
    private static final int ACCOUNT_LINES_END_INDEX = 8;
    private static final String META_SEPARATOR = ",";

    private Stream<String> lines;
    private String accountName;

    public AccountLinesInterpreter(Stream<String> lines, String fileName) {
        this.lines = lines;
        accountName = fileName;
    }

    @Override
    public String interpret() {
        return  accountName + META_SEPARATOR+ lines.limit(ACCOUNT_LINES_END_INDEX).skip(ACCOUNT_LINES_BEGIN_INDEX)
                .filter(s->!s.isEmpty())
                .collect(Collectors.joining(META_SEPARATOR));

    }
}
