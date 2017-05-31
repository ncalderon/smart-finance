package com.calderon.finance;

import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * Created by Nathaniel on 5/28/2017.
 */
public final class FileUtil {
    public static int extractYear (String name) {
        int year = LocalDate.now().getYear();
        boolean customYear = false;
        if(!name.isEmpty())
            customYear = Pattern.matches("^\\d\\d\\d\\d.+$", name);
        if (customYear)
            year = Integer.parseInt(name.substring(0, 4));
        return year;
    }
}
