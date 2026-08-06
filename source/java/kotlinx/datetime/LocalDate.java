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
import kotlinx.datetime.format.LocalDateFormat;
import kotlinx.datetime.format.LocalDateFormatKt;
import kotlinx.datetime.internal.MathKt;
import kotlinx.datetime.serializers.LocalDateIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import net.openid.appauth.BuildConfig;

/* compiled from: LocalDate.kt */
@Metadata(m4d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002'(B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\nB%\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\u000b\u001a\u00060\rj\u0002`\f\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u000eJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0011\u0010%\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0000H\u0096\u0002J\u0006\u0010&\u001a\u00020\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0015\u0010\u000b\u001a\u00060\rj\u0002`\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0015\u0010\u0017\u001a\u00060\u0019j\u0002`\u00188F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0012¨\u0006)"}, m5d2 = {"Lkotlinx/datetime/LocalDate;", BuildConfig.FLAVOR, "value", "Lbytedance/jvm/time/LocalDate;", "<init>", "(Lbytedance/jvm/time/LocalDate;)V", "year", BuildConfig.FLAVOR, "monthNumber", "dayOfMonth", "(III)V", "month", "Lkotlinx/datetime/Month;", "Lbytedance/jvm/time/Month;", "(ILbytedance/jvm/time/Month;I)V", "getValue$kotlinx_datetime_release", "()Lbytedance/jvm/time/LocalDate;", "getYear", "()I", "getMonthNumber", "getMonth", "()Lbytedance/jvm/time/Month;", "getDayOfMonth", "dayOfWeek", "Lkotlinx/datetime/DayOfWeek;", "Lbytedance/jvm/time/DayOfWeek;", "getDayOfWeek", "()Lbytedance/jvm/time/DayOfWeek;", "dayOfYear", "getDayOfYear", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "compareTo", "toEpochDays", "Companion", "Formats", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
@Serializable(with = LocalDateIso8601Serializer.class)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class LocalDate implements Comparable<LocalDate> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LocalDate MAX;
    private static final LocalDate MIN;
    private final bytedance.jvm.time.LocalDate value;

    /* compiled from: LocalDate.kt */
    @Metadata(m4d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tJ\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u0019J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bR\u0014\u0010\f\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, m5d2 = {"Lkotlinx/datetime/LocalDate$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "parse", "Lkotlinx/datetime/LocalDate;", "input", BuildConfig.FLAVOR, "format", "Lkotlinx/datetime/format/DateTimeFormat;", "isoString", BuildConfig.FLAVOR, "MIN", "getMIN$kotlinx_datetime_release", "()Lkotlinx/datetime/LocalDate;", "MAX", "getMAX$kotlinx_datetime_release", "fromEpochDays", "epochDays", BuildConfig.FLAVOR, "Format", "block", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", BuildConfig.FLAVOR, "Lkotlin/ExtensionFunctionType;", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LocalDate> serializer() {
            return LocalDateIso8601Serializer.INSTANCE;
        }

        public final LocalDate parse(CharSequence input, DateTimeFormat<LocalDate> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format == Formats.INSTANCE.getISO()) {
                try {
                    return new LocalDate(bytedance.jvm.time.LocalDate.parse(input));
                } catch (DateTimeParseException e) {
                    throw new DateTimeFormatException(e);
                }
            }
            return format.parse(input);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is only kept for binary compatibility")
        public final /* synthetic */ LocalDate parse(String isoString) {
            Intrinsics.checkNotNullParameter(isoString, "isoString");
            return parse$default(this, isoString, null, 2, null);
        }

        public final LocalDate getMIN$kotlinx_datetime_release() {
            return LocalDate.MIN;
        }

        public final LocalDate getMAX$kotlinx_datetime_release() {
            return LocalDate.MAX;
        }

        public final LocalDate fromEpochDays(int epochDays) {
            bytedance.jvm.time.LocalDate ofEpochDay = bytedance.jvm.time.LocalDate.ofEpochDay(epochDays);
            Intrinsics.checkNotNullExpressionValue(ofEpochDay, "ofEpochDay(...)");
            return new LocalDate(ofEpochDay);
        }

        public final DateTimeFormat<LocalDate> Format(Function1<? super DateTimeFormatBuilder.WithDate, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return LocalDateFormat.INSTANCE.build(block);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LocalDate parse$default(Companion companion, CharSequence charSequence, DateTimeFormat dateTimeFormat, int i, Object obj) {
            if ((i & 2) != 0) {
                dateTimeFormat = LocalDateKt.getIsoDateFormat();
            }
            return companion.parse(charSequence, dateTimeFormat);
        }
    }

    public LocalDate(bytedance.jvm.time.LocalDate value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    /* renamed from: getValue$kotlinx_datetime_release, reason: from getter */
    public final bytedance.jvm.time.LocalDate getValue() {
        return this.value;
    }

    static {
        bytedance.jvm.time.LocalDate MIN2 = bytedance.jvm.time.LocalDate.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN2, "MIN");
        MIN = new LocalDate(MIN2);
        bytedance.jvm.time.LocalDate MAX2 = bytedance.jvm.time.LocalDate.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX2, "MAX");
        MAX = new LocalDate(MAX2);
    }

    /* compiled from: LocalDate.kt */
    @Metadata(m4d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, m5d2 = {"Lkotlinx/datetime/LocalDate$Formats;", BuildConfig.FLAVOR, "<init>", "()V", "ISO", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDate;", "getISO", "()Lkotlinx/datetime/format/DateTimeFormat;", "ISO_BASIC", "getISO_BASIC", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class Formats {
        public static final Formats INSTANCE = new Formats();
        private static final DateTimeFormat<LocalDate> ISO_BASIC = LocalDateFormatKt.getISO_DATE_BASIC();

        private Formats() {
        }

        public final DateTimeFormat<LocalDate> getISO() {
            return LocalDateFormatKt.getISO_DATE();
        }

        public final DateTimeFormat<LocalDate> getISO_BASIC() {
            return ISO_BASIC;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalDate(int i, int i2, int i3) {
        this(r1);
        try {
            bytedance.jvm.time.LocalDate of = bytedance.jvm.time.LocalDate.of(i, i2, i3);
            Intrinsics.checkNotNull(of);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalDate(int i, Month month, int i2) {
        this(i, MonthKt.getNumber(month), i2);
        Intrinsics.checkNotNullParameter(month, "month");
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

    public boolean equals(Object other) {
        return this == other || ((other instanceof LocalDate) && Intrinsics.areEqual(this.value, ((LocalDate) other).value));
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        String localDate = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(localDate, "toString(...)");
        return localDate;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalDate other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo(other.value);
    }

    public final int toEpochDays() {
        return MathKt.clampToInt(this.value.toEpochDay());
    }
}
