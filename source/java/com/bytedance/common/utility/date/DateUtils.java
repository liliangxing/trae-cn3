package com.bytedance.common.utility.date;

import android.content.Context;
import java.text.SimpleDateFormat;

@Deprecated
/* loaded from: classes3.dex */
public final class DateUtils implements DateDef {
    private static final SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat(com.bytedance.android.standard.tools.date.DateUtils.PATTERN_YEAR);
    private static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat(com.bytedance.android.standard.tools.date.DateUtils.PATTERN_DAY);

    private DateUtils() {
    }

    public static String getDateString(Context context, long j) {
        return com.bytedance.android.standard.tools.date.DateUtils.getDateString(context, j);
    }

    public static boolean isCurrentYear(long j) {
        return com.bytedance.android.standard.tools.date.DateUtils.isCurrentYear(j);
    }
}
