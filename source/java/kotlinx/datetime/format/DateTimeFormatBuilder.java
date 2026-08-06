package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.UtcOffset;
import net.openid.appauth.BuildConfig;

/* compiled from: DateTimeFormatBuilder.kt */
@Metadata(m4d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0006\u0007\b\t\nJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, m5d2 = {"Lkotlinx/datetime/format/DateTimeFormatBuilder;", BuildConfig.FLAVOR, "chars", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "WithDate", "WithTime", "WithDateTime", "WithUtcOffset", "WithDateTimeComponents", "Lkotlinx/datetime/format/AbstractDateTimeFormatBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface DateTimeFormatBuilder {
    void chars(String value);

    /* compiled from: DateTimeFormatBuilder.kt */
    @Metadata(m4d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000fH&J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&\u0082\u0001\u0002\u0014\u0015¨\u0006\u0016"}, m5d2 = {"Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "Lkotlinx/datetime/format/DateTimeFormatBuilder;", "year", BuildConfig.FLAVOR, "padding", "Lkotlinx/datetime/format/Padding;", "yearTwoDigits", "baseYear", BuildConfig.FLAVOR, "monthNumber", "monthName", "names", "Lkotlinx/datetime/format/MonthNames;", "dayOfMonth", "dayOfWeek", "Lkotlinx/datetime/format/DayOfWeekNames;", "date", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDate;", "Lkotlinx/datetime/format/AbstractWithDateBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public interface WithDate extends DateTimeFormatBuilder {
        void date(DateTimeFormat<LocalDate> format);

        void dayOfMonth(Padding padding);

        void dayOfWeek(DayOfWeekNames names);

        void monthName(MonthNames names);

        void monthNumber(Padding padding);

        void year(Padding padding);

        void yearTwoDigits(int baseYear);

        /* compiled from: DateTimeFormatBuilder.kt */
        @Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void year$default(WithDate withDate, Padding padding, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: year");
                }
                if ((i & 1) != 0) {
                    padding = Padding.ZERO;
                }
                withDate.year(padding);
            }

            public static /* synthetic */ void monthNumber$default(WithDate withDate, Padding padding, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monthNumber");
                }
                if ((i & 1) != 0) {
                    padding = Padding.ZERO;
                }
                withDate.monthNumber(padding);
            }

            public static /* synthetic */ void dayOfMonth$default(WithDate withDate, Padding padding, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dayOfMonth");
                }
                if ((i & 1) != 0) {
                    padding = Padding.ZERO;
                }
                withDate.dayOfMonth(padding);
            }
        }
    }

    /* compiled from: DateTimeFormatBuilder.kt */
    @Metadata(m4d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0016\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&\u0082\u0001\u0002\u0016\u0017¨\u0006\u0018"}, m5d2 = {"Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "Lkotlinx/datetime/format/DateTimeFormatBuilder;", "hour", BuildConfig.FLAVOR, "padding", "Lkotlinx/datetime/format/Padding;", "amPmHour", "amPmMarker", "am", BuildConfig.FLAVOR, "pm", "minute", "second", "secondFraction", "minLength", BuildConfig.FLAVOR, "maxLength", "fixedLength", "time", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "Lkotlinx/datetime/format/AbstractWithTimeBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public interface WithTime extends DateTimeFormatBuilder {
        void amPmHour(Padding padding);

        void amPmMarker(String am, String pm);

        void hour(Padding padding);

        void minute(Padding padding);

        void second(Padding padding);

        void secondFraction(int fixedLength);

        void secondFraction(int minLength, int maxLength);

        void time(DateTimeFormat<LocalTime> format);

        /* compiled from: DateTimeFormatBuilder.kt */
        @Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void hour$default(WithTime withTime, Padding padding, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hour");
                }
                if ((i & 1) != 0) {
                    padding = Padding.ZERO;
                }
                withTime.hour(padding);
            }

            public static /* synthetic */ void amPmHour$default(WithTime withTime, Padding padding, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: amPmHour");
                }
                if ((i & 1) != 0) {
                    padding = Padding.ZERO;
                }
                withTime.amPmHour(padding);
            }

            public static /* synthetic */ void minute$default(WithTime withTime, Padding padding, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: minute");
                }
                if ((i & 1) != 0) {
                    padding = Padding.ZERO;
                }
                withTime.minute(padding);
            }

            public static /* synthetic */ void second$default(WithTime withTime, Padding padding, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: second");
                }
                if ((i & 1) != 0) {
                    padding = Padding.ZERO;
                }
                withTime.second(padding);
            }

            public static /* synthetic */ void secondFraction$default(WithTime withTime, int i, int i2, int i3, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: secondFraction");
                }
                if ((i3 & 1) != 0) {
                    i = 1;
                }
                if ((i3 & 2) != 0) {
                    i2 = 9;
                }
                withTime.secondFraction(i, i2);
            }

            public static void secondFraction(WithTime withTime, int i) {
                withTime.secondFraction(i, i);
            }
        }
    }

    /* compiled from: DateTimeFormatBuilder.kt */
    @Metadata(m4d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&\u0082\u0001\u0002\b\t¨\u0006\n"}, m5d2 = {"Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "dateTime", BuildConfig.FLAVOR, "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDateTime;", "Lkotlinx/datetime/format/AbstractWithDateTimeBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public interface WithDateTime extends WithDate, WithTime {
        void dateTime(DateTimeFormat<LocalDateTime> format);

        /* compiled from: DateTimeFormatBuilder.kt */
        @Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        public static final class DefaultImpls {
            public static void secondFraction(WithDateTime withDateTime, int i) {
                WithTime.DefaultImpls.secondFraction(withDateTime, i);
            }
        }
    }

    /* compiled from: DateTimeFormatBuilder.kt */
    @Metadata(m4d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&\u0082\u0001\u0002\f\r¨\u0006\u000e"}, m5d2 = {"Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "Lkotlinx/datetime/format/DateTimeFormatBuilder;", "offsetHours", BuildConfig.FLAVOR, "padding", "Lkotlinx/datetime/format/Padding;", "offsetMinutesOfHour", "offsetSecondsOfMinute", "offset", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/UtcOffset;", "Lkotlinx/datetime/format/AbstractWithOffsetBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public interface WithUtcOffset extends DateTimeFormatBuilder {
        void offset(DateTimeFormat<UtcOffset> format);

        void offsetHours(Padding padding);

        void offsetMinutesOfHour(Padding padding);

        void offsetSecondsOfMinute(Padding padding);

        /* compiled from: DateTimeFormatBuilder.kt */
        @Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void offsetHours$default(WithUtcOffset withUtcOffset, Padding padding, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offsetHours");
                }
                if ((i & 1) != 0) {
                    padding = Padding.ZERO;
                }
                withUtcOffset.offsetHours(padding);
            }

            public static /* synthetic */ void offsetMinutesOfHour$default(WithUtcOffset withUtcOffset, Padding padding, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offsetMinutesOfHour");
                }
                if ((i & 1) != 0) {
                    padding = Padding.ZERO;
                }
                withUtcOffset.offsetMinutesOfHour(padding);
            }

            public static /* synthetic */ void offsetSecondsOfMinute$default(WithUtcOffset withUtcOffset, Padding padding, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offsetSecondsOfMinute");
                }
                if ((i & 1) != 0) {
                    padding = Padding.ZERO;
                }
                withUtcOffset.offsetSecondsOfMinute(padding);
            }
        }
    }

    /* compiled from: DateTimeFormatBuilder.kt */
    @Metadata(m4d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u0082\u0001\u0001\t¨\u0006\n"}, m5d2 = {"Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "timeZoneId", BuildConfig.FLAVOR, "dateTimeComponents", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "Lkotlinx/datetime/format/DateTimeComponentsFormat$Builder;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public interface WithDateTimeComponents extends WithDateTime, WithUtcOffset {
        void dateTimeComponents(DateTimeFormat<DateTimeComponents> format);

        void timeZoneId();

        /* compiled from: DateTimeFormatBuilder.kt */
        @Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        public static final class DefaultImpls {
            public static void secondFraction(WithDateTimeComponents withDateTimeComponents, int i) {
                WithDateTime.DefaultImpls.secondFraction(withDateTimeComponents, i);
            }
        }
    }
}
