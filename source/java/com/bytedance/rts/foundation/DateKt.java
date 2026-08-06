package com.bytedance.rts.foundation;

import java.util.Calendar;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Date.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0082\b¨\u0006\u0003"}, d2 = {"getUTCCalendar", "Ljava/util/Calendar;", "calendar", "lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class DateKt {
    private static final Calendar getUTCCalendar(Calendar calendar) {
        Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        utcCalendar.setTimeInMillis(calendar.getTimeInMillis());
        Intrinsics.checkNotNullExpressionValue(utcCalendar, "utcCalendar");
        return utcCalendar;
    }
}
