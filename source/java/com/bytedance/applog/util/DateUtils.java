package com.bytedance.applog.util;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class DateUtils {
    public static SimpleDateFormat getDateFormat() {
        return getFormat(com.bytedance.android.standard.tools.date.DateUtils.PATTERN_YEAR);
    }

    public static SimpleDateFormat getDateTimeFormat() {
        return getFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static SimpleDateFormat getFormat(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC+8"));
        return simpleDateFormat;
    }
}
