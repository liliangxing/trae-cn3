package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.format.AbstractWithDateBuilder;
import kotlinx.datetime.format.AbstractWithTimeBuilder;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.FormatStructure;
import net.openid.appauth.BuildConfig;

/* compiled from: LocalDateTimeFormat.kt */
@Metadata(m4d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0016J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¨\u0006\u0011"}, m5d2 = {"Lkotlinx/datetime/format/AbstractWithDateTimeBuilder;", "Lkotlinx/datetime/format/AbstractWithDateBuilder;", "Lkotlinx/datetime/format/AbstractWithTimeBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", "addFormatStructureForDateTime", BuildConfig.FLAVOR, "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "Lkotlinx/datetime/format/DateTimeFieldContainer;", "addFormatStructureForDate", "Lkotlinx/datetime/format/DateFieldContainer;", "addFormatStructureForTime", "Lkotlinx/datetime/format/TimeFieldContainer;", "dateTime", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDateTime;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface AbstractWithDateTimeBuilder extends AbstractWithDateBuilder, AbstractWithTimeBuilder, DateTimeFormatBuilder.WithDateTime {
    @Override // kotlinx.datetime.format.AbstractWithDateBuilder
    void addFormatStructureForDate(FormatStructure<? super DateFieldContainer> structure);

    void addFormatStructureForDateTime(FormatStructure<? super DateTimeFieldContainer> structure);

    @Override // kotlinx.datetime.format.AbstractWithTimeBuilder
    void addFormatStructureForTime(FormatStructure<? super TimeFieldContainer> structure);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDateTime
    void dateTime(DateTimeFormat<LocalDateTime> format);

    /* compiled from: LocalDateTimeFormat.kt */
    @Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class DefaultImpls {
        public static void amPmHour(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithTimeBuilder.DefaultImpls.amPmHour(abstractWithDateTimeBuilder, padding);
        }

        public static void amPmMarker(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, String am, String pm) {
            Intrinsics.checkNotNullParameter(am, "am");
            Intrinsics.checkNotNullParameter(pm, "pm");
            AbstractWithTimeBuilder.DefaultImpls.amPmMarker(abstractWithDateTimeBuilder, am, pm);
        }

        public static void date(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, DateTimeFormat<LocalDate> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            AbstractWithDateBuilder.DefaultImpls.date(abstractWithDateTimeBuilder, format);
        }

        public static void dayOfMonth(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateBuilder.DefaultImpls.dayOfMonth(abstractWithDateTimeBuilder, padding);
        }

        public static void dayOfWeek(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, DayOfWeekNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            AbstractWithDateBuilder.DefaultImpls.dayOfWeek(abstractWithDateTimeBuilder, names);
        }

        public static void hour(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithTimeBuilder.DefaultImpls.hour(abstractWithDateTimeBuilder, padding);
        }

        public static void minute(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithTimeBuilder.DefaultImpls.minute(abstractWithDateTimeBuilder, padding);
        }

        public static void monthName(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, MonthNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            AbstractWithDateBuilder.DefaultImpls.monthName(abstractWithDateTimeBuilder, names);
        }

        public static void monthNumber(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateBuilder.DefaultImpls.monthNumber(abstractWithDateTimeBuilder, padding);
        }

        public static void second(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithTimeBuilder.DefaultImpls.second(abstractWithDateTimeBuilder, padding);
        }

        public static void secondFraction(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, int i) {
            AbstractWithTimeBuilder.DefaultImpls.secondFraction(abstractWithDateTimeBuilder, i);
        }

        public static void secondFraction(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, int i, int i2) {
            AbstractWithTimeBuilder.DefaultImpls.secondFraction(abstractWithDateTimeBuilder, i, i2);
        }

        public static void time(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, DateTimeFormat<LocalTime> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            AbstractWithTimeBuilder.DefaultImpls.time(abstractWithDateTimeBuilder, format);
        }

        public static void year(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateBuilder.DefaultImpls.year(abstractWithDateTimeBuilder, padding);
        }

        public static void yearTwoDigits(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, int i) {
            AbstractWithDateBuilder.DefaultImpls.yearTwoDigits(abstractWithDateTimeBuilder, i);
        }

        public static void addFormatStructureForDate(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, FormatStructure<? super DateFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            abstractWithDateTimeBuilder.addFormatStructureForDateTime(structure);
        }

        public static void addFormatStructureForTime(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, FormatStructure<? super TimeFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            abstractWithDateTimeBuilder.addFormatStructureForDateTime(structure);
        }

        public static void dateTime(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, DateTimeFormat<LocalDateTime> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            if (format instanceof LocalDateTimeFormat) {
                abstractWithDateTimeBuilder.addFormatStructureForDateTime(((LocalDateTimeFormat) format).getActualFormat());
            }
        }
    }
}
