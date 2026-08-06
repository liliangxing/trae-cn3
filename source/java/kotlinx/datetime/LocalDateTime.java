package kotlinx.datetime;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.DayOfWeek;
import bytedance.jvm.time.Month;
import bytedance.jvm.time.format.DateTimeParseException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.LocalDateTimeFormat;
import kotlinx.datetime.format.LocalDateTimeFormatKt;
import kotlinx.datetime.serializers.LocalDateTimeIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import net.openid.appauth.BuildConfig;

/* compiled from: LocalDateTime.kt */
@Metadata(m4d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00000\u0001:\u000278B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005BE\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u000eBI\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\u000f\u001a\u00060\u0011j\u0002`\u0010\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u0012B\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0004\u0010\u0017J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0096\u0002J\b\u00103\u001a\u00020\u0007H\u0016J\b\u00104\u001a\u000205H\u0016J\u0011\u00106\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0000H\u0096\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001bR\u0015\u0010\u000f\u001a\u00060\u0011j\u0002`\u00108F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0015\u0010 \u001a\u00060\"j\u0002`!8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b&\u0010\u001bR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b'\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b(\u0010\u001bR\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b)\u0010\u001bR\u0011\u0010\r\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b*\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00069"}, m5d2 = {"Lkotlinx/datetime/LocalDateTime;", BuildConfig.FLAVOR, "value", "Lbytedance/jvm/time/LocalDateTime;", "<init>", "(Lbytedance/jvm/time/LocalDateTime;)V", "year", BuildConfig.FLAVOR, "monthNumber", "dayOfMonth", "hour", "minute", "second", "nanosecond", "(IIIIIII)V", "month", "Lkotlinx/datetime/Month;", "Lbytedance/jvm/time/Month;", "(ILbytedance/jvm/time/Month;IIIII)V", "date", "Lkotlinx/datetime/LocalDate;", "time", "Lkotlinx/datetime/LocalTime;", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalTime;)V", "getValue$kotlinx_datetime_release", "()Lbytedance/jvm/time/LocalDateTime;", "getYear", "()I", "getMonthNumber", "getMonth", "()Lbytedance/jvm/time/Month;", "getDayOfMonth", "dayOfWeek", "Lkotlinx/datetime/DayOfWeek;", "Lbytedance/jvm/time/DayOfWeek;", "getDayOfWeek", "()Lbytedance/jvm/time/DayOfWeek;", "dayOfYear", "getDayOfYear", "getHour", "getMinute", "getSecond", "getNanosecond", "getDate", "()Lkotlinx/datetime/LocalDate;", "getTime", "()Lkotlinx/datetime/LocalTime;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "compareTo", "Companion", "Formats", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
@Serializable(with = LocalDateTimeIso8601Serializer.class)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class LocalDateTime implements Comparable<LocalDateTime> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LocalDateTime MAX;
    private static final LocalDateTime MIN;
    private final bytedance.jvm.time.LocalDateTime value;

    public LocalDateTime(bytedance.jvm.time.LocalDateTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    /* renamed from: getValue$kotlinx_datetime_release, reason: from getter */
    public final bytedance.jvm.time.LocalDateTime getValue() {
        return this.value;
    }

    public /* synthetic */ LocalDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, i5, (i8 & 32) != 0 ? 0 : i6, (i8 & 64) != 0 ? 0 : i7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this(r1);
        try {
            bytedance.jvm.time.LocalDateTime of = bytedance.jvm.time.LocalDateTime.of(i, i2, i3, i4, i5, i6, i7);
            Intrinsics.checkNotNull(of);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public /* synthetic */ LocalDateTime(int i, Month month, int i2, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, month, i2, i3, i4, (i7 & 32) != 0 ? 0 : i5, (i7 & 64) != 0 ? 0 : i6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalDateTime(int i, Month month, int i2, int i3, int i4, int i5, int i6) {
        this(i, MonthKt.getNumber(month), i2, i3, i4, i5, i6);
        Intrinsics.checkNotNullParameter(month, "month");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalDateTime(LocalDate date, LocalTime time) {
        this(r2);
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        bytedance.jvm.time.LocalDateTime of = bytedance.jvm.time.LocalDateTime.of(date.getValue(), time.getValue());
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
    }

    public final int getYear() {
        return this.value.getYear();
    }

    public final int getMonthNumber() {
        return this.value.getMonthValue();
    }

    public final Month getMonth() {
        Month month = this.value.getMonth();
        Intrinsics.checkNotNullExpressionValue(month, "getMonth(...)");
        return month;
    }

    public final int getDayOfMonth() {
        return this.value.getDayOfMonth();
    }

    public final DayOfWeek getDayOfWeek() {
        DayOfWeek dayOfWeek = this.value.getDayOfWeek();
        Intrinsics.checkNotNullExpressionValue(dayOfWeek, "getDayOfWeek(...)");
        return dayOfWeek;
    }

    public final int getDayOfYear() {
        return this.value.getDayOfYear();
    }

    public final int getHour() {
        return this.value.getHour();
    }

    public final int getMinute() {
        return this.value.getMinute();
    }

    public final int getSecond() {
        return this.value.getSecond();
    }

    public final int getNanosecond() {
        return this.value.getNano();
    }

    public final LocalDate getDate() {
        bytedance.jvm.time.LocalDate localDate = this.value.toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "toLocalDate(...)");
        return new LocalDate(localDate);
    }

    public final LocalTime getTime() {
        bytedance.jvm.time.LocalTime localTime = this.value.toLocalTime();
        Intrinsics.checkNotNullExpressionValue(localTime, "toLocalTime(...)");
        return new LocalTime(localTime);
    }

    public boolean equals(Object other) {
        return this == other || ((other instanceof LocalDateTime) && Intrinsics.areEqual(this.value, ((LocalDateTime) other).value));
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        String localDateTime = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(localDateTime, "toString(...)");
        return localDateTime;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalDateTime other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo(other.value);
    }

    /* compiled from: LocalDateTime.kt */
    @Metadata(m4d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tJ\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018R\u0014\u0010\f\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0019"}, m5d2 = {"Lkotlinx/datetime/LocalDateTime$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "parse", "Lkotlinx/datetime/LocalDateTime;", "input", BuildConfig.FLAVOR, "format", "Lkotlinx/datetime/format/DateTimeFormat;", "isoString", BuildConfig.FLAVOR, "MIN", "getMIN$kotlinx_datetime_release", "()Lkotlinx/datetime/LocalDateTime;", "MAX", "getMAX$kotlinx_datetime_release", "Format", "builder", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", BuildConfig.FLAVOR, "Lkotlin/ExtensionFunctionType;", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LocalDateTime> serializer() {
            return LocalDateTimeIso8601Serializer.INSTANCE;
        }

        public final LocalDateTime parse(CharSequence input, DateTimeFormat<LocalDateTime> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format == Formats.INSTANCE.getISO()) {
                try {
                    return new LocalDateTime(bytedance.jvm.time.LocalDateTime.parse(input));
                } catch (DateTimeParseException e) {
                    throw new DateTimeFormatException(e);
                }
            }
            return format.parse(input);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is only kept for binary compatibility")
        public final /* synthetic */ LocalDateTime parse(String isoString) {
            Intrinsics.checkNotNullParameter(isoString, "isoString");
            return parse$default(this, isoString, null, 2, null);
        }

        public final LocalDateTime getMIN$kotlinx_datetime_release() {
            return LocalDateTime.MIN;
        }

        public final LocalDateTime getMAX$kotlinx_datetime_release() {
            return LocalDateTime.MAX;
        }

        public final DateTimeFormat<LocalDateTime> Format(Function1<? super DateTimeFormatBuilder.WithDateTime, Unit> builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            return LocalDateTimeFormat.INSTANCE.build(builder);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LocalDateTime parse$default(Companion companion, CharSequence charSequence, DateTimeFormat dateTimeFormat, int i, Object obj) {
            if ((i & 2) != 0) {
                dateTimeFormat = LocalDateTimeKt.getIsoDateTimeFormat();
            }
            return companion.parse(charSequence, dateTimeFormat);
        }
    }

    static {
        bytedance.jvm.time.LocalDateTime MIN2 = bytedance.jvm.time.LocalDateTime.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN2, "MIN");
        MIN = new LocalDateTime(MIN2);
        bytedance.jvm.time.LocalDateTime MAX2 = bytedance.jvm.time.LocalDateTime.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX2, "MAX");
        MAX = new LocalDateTime(MAX2);
    }

    /* compiled from: LocalDateTime.kt */
    @Metadata(m4d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m5d2 = {"Lkotlinx/datetime/LocalDateTime$Formats;", BuildConfig.FLAVOR, "<init>", "()V", "ISO", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDateTime;", "getISO", "()Lkotlinx/datetime/format/DateTimeFormat;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class Formats {
        public static final Formats INSTANCE = new Formats();
        private static final DateTimeFormat<LocalDateTime> ISO = LocalDateTimeFormatKt.getISO_DATETIME();

        private Formats() {
        }

        public final DateTimeFormat<LocalDateTime> getISO() {
            return ISO;
        }
    }
}
