package com.ss.android.message.util;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

/* loaded from: classes7.dex */
public class DateUtils {
    public static int compareDates(String str, String str2) {
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern(com.bytedance.android.standard.tools.date.DateUtils.PATTERN_YEAR);
        return LocalDate.parse(str, ofPattern).compareTo((ChronoLocalDate) LocalDate.parse(str2, ofPattern));
    }
}
