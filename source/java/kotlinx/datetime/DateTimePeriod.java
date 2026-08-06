package kotlinx.datetime;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.DateCalculationsKt;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.serializers.DateTimePeriodIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import net.openid.appauth.BuildConfig;
import org.bouncycastle.i18n.TextBundle;

/* compiled from: DateTimePeriod.kt */
@Metadata(m4d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 !2\u00020\u0001:\u0001!B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0013\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010 \u001a\u00020\u0005H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X \u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u000bX \u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007\u0082\u0001\u0002\"#¨\u0006$"}, m5d2 = {"Lkotlinx/datetime/DateTimePeriod;", BuildConfig.FLAVOR, "<init>", "()V", "totalMonths", BuildConfig.FLAVOR, "getTotalMonths$kotlinx_datetime_release", "()I", "days", "getDays", "totalNanoseconds", BuildConfig.FLAVOR, "getTotalNanoseconds$kotlinx_datetime_release", "()J", "years", "getYears", "months", "getMonths", "hours", "getHours", "minutes", "getMinutes", "seconds", "getSeconds", "nanoseconds", "getNanoseconds", "allNonpositive", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "equals", "other", "hashCode", "Companion", "Lkotlinx/datetime/DatePeriod;", "Lkotlinx/datetime/DateTimePeriodImpl;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
@Serializable(with = DateTimePeriodIso8601Serializer.class)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class DateTimePeriod {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ DateTimePeriod(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getDays();

    public abstract int getTotalMonths$kotlinx_datetime_release();

    public abstract long getTotalNanoseconds$kotlinx_datetime_release();

    private DateTimePeriod() {
    }

    public final int getYears() {
        return getTotalMonths$kotlinx_datetime_release() / 12;
    }

    public final int getMonths() {
        return getTotalMonths$kotlinx_datetime_release() % 12;
    }

    public int getHours() {
        return (int) (getTotalNanoseconds$kotlinx_datetime_release() / DateCalculationsKt.NANOS_PER_HOUR);
    }

    public int getMinutes() {
        return (int) ((getTotalNanoseconds$kotlinx_datetime_release() % DateCalculationsKt.NANOS_PER_HOUR) / DateCalculationsKt.NANOS_PER_MINUTE);
    }

    public int getSeconds() {
        return (int) ((getTotalNanoseconds$kotlinx_datetime_release() % DateCalculationsKt.NANOS_PER_MINUTE) / 1000000000);
    }

    public int getNanoseconds() {
        return (int) (getTotalNanoseconds$kotlinx_datetime_release() % 1000000000);
    }

    private final boolean allNonpositive() {
        return getTotalMonths$kotlinx_datetime_release() <= 0 && getDays() <= 0 && getTotalNanoseconds$kotlinx_datetime_release() <= 0 && !((getTotalMonths$kotlinx_datetime_release() | getDays()) == 0 && getTotalNanoseconds$kotlinx_datetime_release() == 0);
    }

    public String toString() {
        int i;
        String str;
        StringBuilder sb = new StringBuilder();
        if (allNonpositive()) {
            sb.append('-');
            i = -1;
        } else {
            i = 1;
        }
        sb.append('P');
        if (getYears() != 0) {
            sb.append(getYears() * i).append('Y');
        }
        if (getMonths() != 0) {
            sb.append(getMonths() * i).append('M');
        }
        if (getDays() != 0) {
            sb.append(getDays() * i).append('D');
        }
        int hours = getHours();
        String str2 = BuildConfig.FLAVOR;
        String str3 = "T";
        if (hours != 0) {
            sb.append("T").append(getHours() * i).append('H');
            str3 = BuildConfig.FLAVOR;
        }
        if (getMinutes() != 0) {
            sb.append(str3).append(getMinutes() * i).append('M');
        } else {
            str2 = str3;
        }
        if ((getSeconds() | getNanoseconds()) != 0) {
            sb.append(str2);
            if (getSeconds() != 0) {
                str = Integer.valueOf(getSeconds() * i);
            } else {
                str = getNanoseconds() * i < 0 ? "-0" : "0";
            }
            sb.append(str);
            if (getNanoseconds() != 0) {
                sb.append('.').append(StringsKt.padStart(String.valueOf(Math.abs(getNanoseconds())), 9, '0'));
            }
            sb.append('S');
        }
        if (sb.length() == 1) {
            sb.append("0D");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DateTimePeriod)) {
            return false;
        }
        DateTimePeriod dateTimePeriod = (DateTimePeriod) other;
        return getTotalMonths$kotlinx_datetime_release() == dateTimePeriod.getTotalMonths$kotlinx_datetime_release() && getDays() == dateTimePeriod.getDays() && getTotalNanoseconds$kotlinx_datetime_release() == dateTimePeriod.getTotalNanoseconds$kotlinx_datetime_release();
    }

    public int hashCode() {
        return (((getTotalMonths$kotlinx_datetime_release() * 31) + getDays()) * 31) + Long.hashCode(getTotalNanoseconds$kotlinx_datetime_release());
    }

    /* compiled from: DateTimePeriod.kt */
    @Metadata(m4d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, m5d2 = {"Lkotlinx/datetime/DateTimePeriod$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "parse", "Lkotlinx/datetime/DateTimePeriod;", TextBundle.TEXT_ENTRY, BuildConfig.FLAVOR, "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DateTimePeriod> serializer() {
            return DateTimePeriodIso8601Serializer.INSTANCE;
        }

        private static final Void parse$parseException(String str, int i) {
            throw new DateTimeFormatException("Parse error at char " + i + ": " + str);
        }

        /* JADX WARN: Removed duplicated region for block: B:126:0x0288 A[LOOP:2: B:118:0x026f->B:126:0x0288, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:127:0x028b A[EDGE_INSN: B:127:0x028b->B:128:0x028b BREAK  A[LOOP:2: B:118:0x026f->B:126:0x0288], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final DateTimePeriod parse(String text) {
            int i;
            int i2;
            int i3;
            boolean z;
            char c;
            Intrinsics.checkNotNullParameter(text, "text");
            int i4 = 0;
            int i5 = 0;
            char c2 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 1;
            while (i5 < text.length()) {
                if (c2 == 0) {
                    int i15 = i5 + 1;
                    if (i15 >= text.length() && (text.charAt(i5) == '+' || text.charAt(i5) == '-')) {
                        parse$parseException("Unexpected end of string; 'P' designator is required", i5);
                        throw new KotlinNothingValueException();
                    }
                    char charAt = text.charAt(i5);
                    if (charAt == '+' || charAt == '-') {
                        if (text.charAt(i5) == '-') {
                            i14 = -1;
                        }
                        if (text.charAt(i15) != 'P') {
                            parse$parseException("Expected 'P', got '" + text.charAt(i15) + '\'', i15);
                            throw new KotlinNothingValueException();
                        }
                        i5 += 2;
                    } else {
                        if (charAt != 'P') {
                            parse$parseException("Expected '+', '-', 'P', got '" + text.charAt(i5) + '\'', i5);
                            throw new KotlinNothingValueException();
                        }
                        i5 = i15;
                    }
                    i4 = 0;
                    c2 = 1;
                } else {
                    char charAt2 = text.charAt(i5);
                    if (charAt2 == '+' || charAt2 == '-') {
                        i = text.charAt(i5) == '-' ? i14 * (-1) : i14;
                        i2 = i5 + 1;
                        if (i2 < text.length()) {
                            char charAt3 = text.charAt(i2);
                            if (!('0' <= charAt3 && charAt3 < ':')) {
                            }
                        }
                        parse$parseException("A number expected after '" + text.charAt(i2) + '\'', i2);
                        throw new KotlinNothingValueException();
                    }
                    if (('0' <= charAt2 && charAt2 < ':') || charAt2 != 'T') {
                        i2 = i5;
                        i = i14;
                    } else {
                        if (c2 >= 6) {
                            parse$parseException("Only one 'T' designator is allowed", i5);
                            throw new KotlinNothingValueException();
                        }
                        i5++;
                        i4 = 0;
                        c2 = 6;
                    }
                    long j = 0;
                    int i16 = i14;
                    while (true) {
                        if (i2 >= text.length()) {
                            i3 = i6;
                            break;
                        }
                        char charAt4 = text.charAt(i2);
                        i3 = i6;
                        if (!('0' <= charAt4 && charAt4 < ':')) {
                            break;
                        }
                        try {
                            j = MathJvmKt.safeAdd(MathJvmKt.safeMultiply(j, 10L), text.charAt(i2) - '0');
                            i2++;
                            i6 = i3;
                        } catch (ArithmeticException unused) {
                            parse$parseException("The number is too large", i5);
                            throw new KotlinNothingValueException();
                        }
                    }
                    long j2 = j * i;
                    if (i2 == text.length()) {
                        parse$parseException("Expected a designator after the numerical value", i2);
                        throw new KotlinNothingValueException();
                    }
                    char upperCase = Character.toUpperCase(text.charAt(i2));
                    int i17 = i7;
                    int i18 = i8;
                    if (upperCase != 'Y') {
                        if (upperCase == 'M') {
                            if (c2 >= 6) {
                                c = '\b';
                                if (c2 >= '\b') {
                                    parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                    throw new KotlinNothingValueException();
                                }
                                i12 = parse$toIntThrowing(j2, i5, 'M');
                            } else {
                                c = 3;
                                if (c2 >= 3) {
                                    parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                    throw new KotlinNothingValueException();
                                }
                                i9 = parse$toIntThrowing(j2, i5, 'M');
                            }
                            c2 = c;
                        } else if (upperCase == 'W') {
                            if (c2 >= 4) {
                                parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                throw new KotlinNothingValueException();
                            }
                            c2 = 4;
                            i7 = parse$toIntThrowing(j2, i5, 'W');
                            i6 = i3;
                            i8 = i18;
                        } else if (upperCase == 'D') {
                            if (c2 >= 5) {
                                parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                throw new KotlinNothingValueException();
                            }
                            c2 = 5;
                            i6 = parse$toIntThrowing(j2, i5, 'D');
                            i7 = i17;
                            i8 = i18;
                        } else if (upperCase == 'H') {
                            if (c2 >= 7 || c2 < 6) {
                                parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                throw new KotlinNothingValueException();
                            }
                            i11 = parse$toIntThrowing(j2, i5, 'H');
                            c2 = 7;
                        } else if (upperCase == 'S') {
                            if (c2 >= '\t' || c2 < 6) {
                                parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                throw new KotlinNothingValueException();
                            }
                            c2 = '\t';
                            i6 = i3;
                            i7 = i17;
                            i8 = i18;
                            i13 = parse$toIntThrowing(j2, i5, 'S');
                        } else if (upperCase == '.' || upperCase == ',') {
                            int i19 = i2 + 1;
                            if (i19 >= text.length()) {
                                parse$parseException("Expected designator 'S' after " + text.charAt(i19 - 1), i19);
                                throw new KotlinNothingValueException();
                            }
                            int i20 = i19;
                            while (i20 < text.length()) {
                                char charAt5 = text.charAt(i20);
                                if ('0' <= charAt5 && charAt5 < ':') {
                                    z = true;
                                    if (z) {
                                        break;
                                    }
                                    i20++;
                                }
                                z = false;
                                if (z) {
                                }
                            }
                            int i21 = i20 - i19;
                            if (i21 > 9) {
                                parse$parseException("Only the nanosecond fractions of a second are supported", i19);
                                throw new KotlinNothingValueException();
                            }
                            StringBuilder sb = new StringBuilder();
                            String substring = text.substring(i19, i20);
                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                            int parseInt = Integer.parseInt(sb.append(substring).append(StringsKt.repeat("0", 9 - i21)).toString(), CharsKt.checkRadix(10)) * i;
                            if (text.charAt(i20) != 'S') {
                                parse$parseException("Expected the 'S' designator after a fraction", i20);
                                throw new KotlinNothingValueException();
                            }
                            if (c2 >= '\t' || c2 < 6) {
                                parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i20);
                                throw new KotlinNothingValueException();
                            }
                            i13 = parse$toIntThrowing(j2, i5, 'S');
                            c2 = '\t';
                            i10 = parseInt;
                            i2 = i20;
                        } else {
                            parse$parseException("Expected a designator after the numerical value", i2);
                            throw new KotlinNothingValueException();
                        }
                        i6 = i3;
                        i7 = i17;
                        i8 = i18;
                    } else {
                        if (c2 >= 2) {
                            parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                            throw new KotlinNothingValueException();
                        }
                        i8 = parse$toIntThrowing(j2, i5, 'Y');
                        c2 = 2;
                        i6 = i3;
                        i7 = i17;
                    }
                    i5 = i2 + 1;
                    i14 = i16;
                    i4 = 0;
                }
            }
            if (c2 == 0) {
                parse$parseException("Unexpected end of input; 'P' designator is required", i5);
                throw new KotlinNothingValueException();
            }
            if (c2 == 6) {
                parse$parseException("Unexpected end of input; at least one time component is required after 'T'", i5);
                throw new KotlinNothingValueException();
            }
            long j3 = i6 + (i7 * 7);
            if (((-2147483648L > j3 || j3 > 2147483647L) ? i4 : 1) == 0) {
                parse$parseException("The total number of days under 'D' and 'W' designators should fit into an Int", i4);
                throw new KotlinNothingValueException();
            }
            return DateTimePeriodKt.DateTimePeriod(i8, i9, (int) j3, i11, i12, i13, i10);
        }

        private static final int parse$toIntThrowing(long j, int i, char c) {
            if (j >= -2147483648L && j <= 2147483647L) {
                return (int) j;
            }
            parse$parseException("Value " + j + " does not fit into an Int, which is required for component '" + c + '\'', i);
            throw new KotlinNothingValueException();
        }
    }
}
