package com.bytedance.crash.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class DateUtils {
    public static final int DAY = 86400000;
    private static DateFormat sDateFormat;
    private static DateFormat sDateFormatMs;
    private static DateFormat sFileDateFormat;
    private static DateFormat sFileDateFormatMs;

    public static DateFormat getDateInstance() {
        if (sDateFormat == null) {
            sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        }
        return sDateFormat;
    }

    public static DateFormat getDateMsInstance() {
        if (sDateFormatMs == null) {
            sDateFormatMs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        }
        return sDateFormatMs;
    }

    public static DateFormat getFileDateInstance() {
        if (sFileDateFormat == null) {
            sFileDateFormat = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss", Locale.getDefault());
        }
        return sFileDateFormat;
    }

    public static DateFormat getFileDateInstanceMs() {
        if (sFileDateFormatMs == null) {
            sFileDateFormatMs = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss.SSS", Locale.getDefault());
        }
        return sFileDateFormatMs;
    }

    public static long parseDateMs(String str) throws ParseException {
        Date parse = getDateMsInstance().parse(str);
        if (parse != null) {
            return parse.getTime();
        }
        return 0L;
    }

    public static String formatDateMs(long j) {
        return getDateMsInstance().format(new Date(j));
    }

    public static String formatDate(long j) {
        return getDateInstance().format(new Date(j));
    }
}
