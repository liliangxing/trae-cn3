package com.bytedance.android.standard.tools.date;

import android.content.Context;
import com.bytedance.android.standard.tools.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes3.dex */
public final class DateUtils implements DateDef {
    public static final String PATTERN_HOUR = "HH:mm:ss";
    public static final String PATTERN_YEAR = "yyyy-MM-dd";
    private static final SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat(PATTERN_YEAR);
    public static final String PATTERN_DAY = "MM-dd HH:mm";
    private static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat(PATTERN_DAY);

    public static String timestampToDate(long j, String str) {
        SimpleDateFormat simpleDateFormat;
        str.hashCode();
        if (str.equals(PATTERN_DAY)) {
            simpleDateFormat = DAY_FORMAT;
        } else if (str.equals(PATTERN_YEAR)) {
            simpleDateFormat = YEAR_FORMAT;
        } else {
            simpleDateFormat = new SimpleDateFormat(str);
        }
        return simpleDateFormat.format(new Date(j));
    }

    private DateUtils() {
    }

    public static String getDateString(Context context, long j) {
        if (!isCurrentYear(j)) {
            return YEAR_FORMAT.format(Long.valueOf(j));
        }
        if (!android.text.format.DateUtils.isToday(j)) {
            return DAY_FORMAT.format(Long.valueOf(j));
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        return currentTimeMillis >= 3600000 ? context.getString(R.string.hours_ago, Long.valueOf(currentTimeMillis / 3600000)) : currentTimeMillis >= 60000 ? context.getString(R.string.minutes_ago, Long.valueOf(currentTimeMillis / 60000)) : context.getString(R.string.just_now);
    }

    public static boolean isCurrentYear(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        calendar.setTimeInMillis(System.currentTimeMillis());
        return i == calendar.get(1);
    }
}
