package com.bytedance.rts.foundation;

import com.bytedance.android.standard.tools.date.DateUtils;
import com.bytedance.sdk.account.induce.FrequencyController;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: Date.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u001d\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BS\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eB\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0013H\u0082\bJ\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\u0007J\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0007J+\u0010)\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010*J7\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00100J\u000e\u00101\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0007J+\u00102\u001a\u00020'2\u0006\u0010-\u001a\u00020\u00072\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010*J\u001f\u00103\u001a\u00020'2\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00104J\u001f\u00105\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00072\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00104J\u000e\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004J\u000e\u00108\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0007J+\u00109\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010*J7\u0010:\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00100J\u000e\u0010;\u001a\u00020'2\u0006\u0010/\u001a\u00020\u0007J+\u0010<\u001a\u00020'2\u0006\u0010-\u001a\u00020\u00072\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010*J\u001f\u0010=\u001a\u00020'2\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00104J\u001f\u0010>\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00072\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00104J\u0006\u0010?\u001a\u00020\u0013J\b\u0010@\u001a\u00020\u0013H\u0016J\u0006\u0010A\u001a\u00020\u0013J\u0006\u0010B\u001a\u00020\u0004R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/bytedance/rts/foundation/Date;", "", "()V", "timestamp", "", "(D)V", "year", "", "month", FrequencyController.RangeType.DAY, FrequencyController.RangeType.HOUR, FrequencyController.RangeType.MINUTE, "second", "millisecond", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "calendar", "Ljava/util/Calendar;", "(Ljava/util/Calendar;)V", "formatGMT", "", "getDate", "getDay", "getFullYear", "getHours", "getMilliseconds", "getMinutes", "getMonth", "getSeconds", "getTime", "getTimezoneOffset", "getUTCDate", "getUTCDay", "getUTCFullYear", "getUTCHours", "getUTCMilliseconds", "getUTCMinutes", "getUTCMonth", "getUTCSeconds", "setDate", "", "date", "setFullYear", "(ILjava/lang/Integer;Ljava/lang/Integer;)J", "setHours", "hours", "min", "sec", "ms", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)J", "setMilliseconds", "setMinutes", "setMonth", "(ILjava/lang/Integer;)J", "setSeconds", "setTime", "time", "setUTCDate", "setUTCFullYear", "setUTCHours", "setUTCMilliseconds", "setUTCMinutes", "setUTCMonth", "setUTCSeconds", "toDateString", "toString", "toTimeString", "valueOf", "Companion", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class Date {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Calendar calendar;

    /* compiled from: Date.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/rts/foundation/Date$Companion;", "", "()V", "now", "", "now_v2", "", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long now() {
            return System.currentTimeMillis();
        }

        public final double now_v2() {
            return System.currentTimeMillis();
        }
    }

    public Date(Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "calendar");
        this.calendar = calendar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Date() {
        this(r0);
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Date(double d) {
        this(r0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis((long) d);
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance().apply {\n  … timestamp.toLong()\n    }");
    }

    public /* synthetic */ Date(int i, int i2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? null : num, (i3 & 8) != 0 ? null : num2, (i3 & 16) != 0 ? null : num3, (i3 & 32) != 0 ? null : num4, (i3 & 64) != 0 ? 0 : num5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Date(int i, int i2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this(r0);
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, num != null ? num.intValue() : 1);
        calendar.set(11, num2 != null ? num2.intValue() : 0);
        calendar.set(12, num3 != null ? num3.intValue() : 0);
        calendar.set(13, num4 != null ? num4.intValue() : 0);
        calendar.set(14, num5 != null ? num5.intValue() : 0);
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance().apply {\n  …, millisecond ?: 0)\n    }");
    }

    public String toString() {
        String format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss", Locale.ENGLISH).format(this.calendar.getTime());
        String displayName = this.calendar.getTimeZone().getDisplayName(false, 1, Locale.ENGLISH);
        TimeZone timeZone = this.calendar.getTimeZone();
        int rawOffset = timeZone.getRawOffset() + timeZone.getDSTSavings();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format2 = String.format("GMT%+03d%02d", java.util.Arrays.copyOf(new Object[]{Integer.valueOf(rawOffset / 3600000), Integer.valueOf((rawOffset % 3600000) / 60000)}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format + " " + format2 + " (" + displayName + ")";
    }

    public final String toDateString() {
        String format = new SimpleDateFormat("EEE MMM dd yyyy", Locale.ENGLISH).format(this.calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "format.format(calendar.time)");
        return format;
    }

    public final String toTimeString() {
        String format = new SimpleDateFormat(DateUtils.PATTERN_HOUR, Locale.ENGLISH).format(this.calendar.getTime());
        String displayName = this.calendar.getTimeZone().getDisplayName(false, 1, Locale.ENGLISH);
        TimeZone timeZone = this.calendar.getTimeZone();
        int rawOffset = timeZone.getRawOffset() + timeZone.getDSTSavings();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format2 = String.format("GMT%+03d%02d", java.util.Arrays.copyOf(new Object[]{Integer.valueOf(rawOffset / 3600000), Integer.valueOf((rawOffset % 3600000) / 60000)}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format + " " + format2 + " (" + displayName + ")";
    }

    public final double valueOf() {
        return this.calendar.getTimeInMillis();
    }

    public final double getTime() {
        return this.calendar.getTimeInMillis();
    }

    public final int getFullYear() {
        return this.calendar.get(1);
    }

    public final int getUTCFullYear() {
        Calendar calendar = this.calendar;
        Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        utcCalendar.setTimeInMillis(calendar.getTimeInMillis());
        Intrinsics.checkNotNullExpressionValue(utcCalendar, "utcCalendar");
        return utcCalendar.get(1);
    }

    public final int getMonth() {
        return this.calendar.get(2);
    }

    public final int getUTCMonth() {
        Calendar calendar = this.calendar;
        Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        utcCalendar.setTimeInMillis(calendar.getTimeInMillis());
        Intrinsics.checkNotNullExpressionValue(utcCalendar, "utcCalendar");
        return utcCalendar.get(2);
    }

    public final int getDate() {
        return this.calendar.get(5);
    }

    public final int getUTCDate() {
        Calendar calendar = this.calendar;
        Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        utcCalendar.setTimeInMillis(calendar.getTimeInMillis());
        Intrinsics.checkNotNullExpressionValue(utcCalendar, "utcCalendar");
        return utcCalendar.get(5);
    }

    public final int getDay() {
        return this.calendar.get(7) - 1;
    }

    public final int getUTCDay() {
        Calendar calendar = this.calendar;
        Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        utcCalendar.setTimeInMillis(calendar.getTimeInMillis());
        Intrinsics.checkNotNullExpressionValue(utcCalendar, "utcCalendar");
        return utcCalendar.get(7) - 1;
    }

    public final int getHours() {
        return this.calendar.get(11);
    }

    public final int getUTCHours() {
        Calendar calendar = this.calendar;
        Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        utcCalendar.setTimeInMillis(calendar.getTimeInMillis());
        Intrinsics.checkNotNullExpressionValue(utcCalendar, "utcCalendar");
        return utcCalendar.get(11);
    }

    public final int getMinutes() {
        return this.calendar.get(12);
    }

    public final int getUTCMinutes() {
        Calendar calendar = this.calendar;
        Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        utcCalendar.setTimeInMillis(calendar.getTimeInMillis());
        Intrinsics.checkNotNullExpressionValue(utcCalendar, "utcCalendar");
        return utcCalendar.get(12);
    }

    public final int getSeconds() {
        return this.calendar.get(13);
    }

    public final int getUTCSeconds() {
        Calendar calendar = this.calendar;
        Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        utcCalendar.setTimeInMillis(calendar.getTimeInMillis());
        Intrinsics.checkNotNullExpressionValue(utcCalendar, "utcCalendar");
        return utcCalendar.get(13);
    }

    public final int getMilliseconds() {
        return this.calendar.get(14);
    }

    public final int getUTCMilliseconds() {
        Calendar calendar = this.calendar;
        Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        utcCalendar.setTimeInMillis(calendar.getTimeInMillis());
        Intrinsics.checkNotNullExpressionValue(utcCalendar, "utcCalendar");
        return utcCalendar.get(14);
    }

    public final int getTimezoneOffset() {
        TimeZone timeZone = this.calendar.getTimeZone();
        return (-(timeZone.getRawOffset() + timeZone.getDSTSavings())) / 60000;
    }

    public final double setTime(double time) {
        this.calendar.setTimeInMillis((long) time);
        return time;
    }

    public final double setMilliseconds(int ms2) {
        this.calendar.set(14, ms2);
        return this.calendar.getTimeInMillis();
    }

    public final long setUTCMilliseconds(int ms2) {
        long offset = this.calendar.getTimeZone().getOffset(this.calendar.getTimeInMillis());
        long j = 1000;
        this.calendar.setTimeInMillis((((this.calendar.getTimeInMillis() - offset) / j) * j) + ms2 + offset);
        return this.calendar.getTimeInMillis();
    }

    public static /* synthetic */ long setSeconds$default(Date date, int i, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        return date.setSeconds(i, num);
    }

    public final long setSeconds(int sec, Integer ms2) {
        this.calendar.set(13, sec);
        if (ms2 != null) {
            this.calendar.set(14, ms2.intValue());
        }
        return this.calendar.getTimeInMillis();
    }

    public static /* synthetic */ long setUTCSeconds$default(Date date, int i, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        return date.setUTCSeconds(i, num);
    }

    public final long setUTCSeconds(int sec, Integer ms2) {
        long offset = this.calendar.getTimeZone().getOffset(this.calendar.getTimeInMillis());
        this.calendar.setTimeInMillis((this.calendar.getTimeInMillis() - offset) + (sec * 1000) + (ms2 != null ? ms2.intValue() : 0) + offset);
        return this.calendar.getTimeInMillis();
    }

    public static /* synthetic */ long setMinutes$default(Date date, int i, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            num2 = null;
        }
        return date.setMinutes(i, num, num2);
    }

    public final long setMinutes(int min, Integer sec, Integer ms2) {
        this.calendar.set(12, min);
        if (sec != null) {
            this.calendar.set(13, sec.intValue());
        }
        if (ms2 != null) {
            this.calendar.set(14, ms2.intValue());
        }
        return this.calendar.getTimeInMillis();
    }

    public static /* synthetic */ long setUTCMinutes$default(Date date, int i, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            num2 = null;
        }
        return date.setUTCMinutes(i, num, num2);
    }

    public final long setUTCMinutes(int min, Integer sec, Integer ms2) {
        long offset = this.calendar.getTimeZone().getOffset(this.calendar.getTimeInMillis());
        this.calendar.setTimeInMillis((this.calendar.getTimeInMillis() - offset) + (min * 60 * 1000) + ((sec != null ? sec.intValue() : 0) * 1000) + (ms2 != null ? ms2.intValue() : 0) + offset);
        return this.calendar.getTimeInMillis();
    }

    public static /* synthetic */ long setHours$default(Date date, int i, Integer num, Integer num2, Integer num3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            num2 = null;
        }
        if ((i2 & 8) != 0) {
            num3 = null;
        }
        return date.setHours(i, num, num2, num3);
    }

    public final long setHours(int hours, Integer min, Integer sec, Integer ms2) {
        this.calendar.set(11, hours);
        if (min != null) {
            this.calendar.set(12, min.intValue());
        }
        if (sec != null) {
            this.calendar.set(13, sec.intValue());
        }
        if (ms2 != null) {
            this.calendar.set(14, ms2.intValue());
        }
        return this.calendar.getTimeInMillis();
    }

    public static /* synthetic */ long setUTCHours$default(Date date, int i, Integer num, Integer num2, Integer num3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            num2 = null;
        }
        if ((i2 & 8) != 0) {
            num3 = null;
        }
        return date.setUTCHours(i, num, num2, num3);
    }

    public final long setUTCHours(int hours, Integer min, Integer sec, Integer ms2) {
        long offset = this.calendar.getTimeZone().getOffset(this.calendar.getTimeInMillis());
        this.calendar.setTimeInMillis((this.calendar.getTimeInMillis() - offset) + (hours * 60 * 60 * 1000) + ((min != null ? min.intValue() : 0) * 60 * 1000) + ((sec != null ? sec.intValue() : 0) * 1000) + (ms2 != null ? ms2.intValue() : 0) + offset);
        return this.calendar.getTimeInMillis();
    }

    public final long setDate(int date) {
        this.calendar.set(5, date);
        return this.calendar.getTimeInMillis();
    }

    public final long setUTCDate(int date) {
        long offset = this.calendar.getTimeZone().getOffset(this.calendar.getTimeInMillis());
        this.calendar.setTimeInMillis(this.calendar.getTimeInMillis() - offset);
        this.calendar.set(5, date);
        Calendar calendar = this.calendar;
        calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
        return this.calendar.getTimeInMillis();
    }

    public static /* synthetic */ long setMonth$default(Date date, int i, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        return date.setMonth(i, num);
    }

    public final long setMonth(int month, Integer date) {
        this.calendar.set(2, month);
        if (date != null) {
            this.calendar.set(5, date.intValue());
        }
        return this.calendar.getTimeInMillis();
    }

    public static /* synthetic */ long setUTCMonth$default(Date date, int i, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        return date.setUTCMonth(i, num);
    }

    public final long setUTCMonth(int month, Integer date) {
        long offset = this.calendar.getTimeZone().getOffset(this.calendar.getTimeInMillis());
        this.calendar.setTimeInMillis(this.calendar.getTimeInMillis() - offset);
        this.calendar.set(2, month);
        if (date != null) {
            this.calendar.set(5, date.intValue());
        }
        Calendar calendar = this.calendar;
        calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
        return this.calendar.getTimeInMillis();
    }

    public static /* synthetic */ long setFullYear$default(Date date, int i, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            num2 = null;
        }
        return date.setFullYear(i, num, num2);
    }

    public final long setFullYear(int year, Integer month, Integer date) {
        this.calendar.set(1, year);
        if (month != null) {
            this.calendar.set(2, month.intValue());
        }
        if (date != null) {
            this.calendar.set(5, date.intValue());
        }
        return this.calendar.getTimeInMillis();
    }

    public static /* synthetic */ long setUTCFullYear$default(Date date, int i, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            num2 = null;
        }
        return date.setUTCFullYear(i, num, num2);
    }

    public final long setUTCFullYear(int year, Integer month, Integer date) {
        long offset = this.calendar.getTimeZone().getOffset(this.calendar.getTimeInMillis());
        this.calendar.setTimeInMillis(this.calendar.getTimeInMillis() - offset);
        this.calendar.set(1, year);
        if (month != null) {
            this.calendar.set(2, month.intValue());
        }
        if (date != null) {
            this.calendar.set(5, date.intValue());
        }
        Calendar calendar = this.calendar;
        calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
        return this.calendar.getTimeInMillis();
    }

    private final String formatGMT() {
        TimeZone timeZone = this.calendar.getTimeZone();
        int rawOffset = timeZone.getRawOffset() + timeZone.getDSTSavings();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("GMT%+03d%02d", java.util.Arrays.copyOf(new Object[]{Integer.valueOf(rawOffset / 3600000), Integer.valueOf((rawOffset % 3600000) / 60000)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
