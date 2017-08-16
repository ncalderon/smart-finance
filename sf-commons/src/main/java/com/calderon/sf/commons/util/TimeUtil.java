package com.calderon.sf.commons.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

public class TimeUtil {
    public static final Timestamp newTimestampFrom(LocalDate localDate) {
        Calendar instance = Calendar.getInstance();
        instance.set(localDate.getYear(), localDate.getMonthValue()-1, localDate.getDayOfMonth(), 0, 0, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return new Timestamp(instance.getTimeInMillis());
    }

    public static final Timestamp newTimestampFrom(LocalDateTime localDateTime) {
        Calendar instance = Calendar.getInstance();
        instance.set(localDateTime.getYear()
                , localDateTime.getMonthValue()-1
                , localDateTime.getDayOfMonth()
                , localDateTime.getHour()
                , localDateTime.getMinute()
                , localDateTime.getSecond());
        instance.set(Calendar.MILLISECOND, 0);
        return new Timestamp(instance.getTimeInMillis());
    }
}
