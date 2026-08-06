package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.openid.appauth.BuildConfig;

/* compiled from: Duration.kt */
@Metadata(m4d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0015\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001d\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015\u001a\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a)\u0010\u0017\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a)\u0010\u001c\u001a\u00020\u0002*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002\u001a\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002\u001a\u0015\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u0015\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u001d\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010-\u001a\u0015\u0010.\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u0015\u0010/\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\"\u000e\u0010\u001d\u001a\u00020\u0002X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, m5d2 = {"toDuration", "Lkotlin/time/Duration;", BuildConfig.FLAVOR, "unit", "Lkotlin/time/DurationUnit;", "(ILkotlin/time/DurationUnit;)J", BuildConfig.FLAVOR, "(JLkotlin/time/DurationUnit;)J", BuildConfig.FLAVOR, "(DLkotlin/time/DurationUnit;)J", "times", "duration", "times-mvk6XK0", "(IJ)J", "times-kIfJnKk", "(DJ)J", "parseDuration", "value", BuildConfig.FLAVOR, "strictIso", BuildConfig.FLAVOR, "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "substringWhile", "startIndex", "predicate", "Lkotlin/Function1;", BuildConfig.FLAVOR, "skipWhile", "NANOS_IN_MILLIS", "MAX_NANOS", "MAX_MILLIS", "MAX_NANOS_IN_MILLIS", "nanosToMillis", "nanos", "millisToNanos", "millis", "durationOfNanos", "normalNanos", "(J)J", "durationOfMillis", "normalMillis", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "kotlin-stdlib"}, m6k = 2, m7mv = {2, 1, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    public static final long millisToNanos(long j) {
        return j * 1000000;
    }

    public static final long toDuration(int i, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo(DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(i, unit, DurationUnit.NANOSECONDS));
        }
        return toDuration(i, unit);
    }

    public static final long toDuration(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long convertDurationUnitOverflow = DurationUnitKt.convertDurationUnitOverflow(MAX_NANOS, DurationUnit.NANOSECONDS, unit);
        boolean z = false;
        if ((-convertDurationUnitOverflow) <= j && j <= convertDurationUnitOverflow) {
            z = true;
        }
        if (z) {
            return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(j, unit, DurationUnit.NANOSECONDS));
        }
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt.convertDurationUnit(j, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS));
    }

    public static final long toDuration(double d, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double convertDurationUnit = DurationUnitKt.convertDurationUnit(d, unit, DurationUnit.NANOSECONDS);
        if (!(!Double.isNaN(convertDurationUnit))) {
            throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        long roundToLong = MathKt.roundToLong(convertDurationUnit);
        if (-4611686018426999999L <= roundToLong && roundToLong < 4611686018427000000L) {
            return durationOfNanos(roundToLong);
        }
        return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt.convertDurationUnit(d, unit, DurationUnit.MILLISECONDS)));
    }

    /* renamed from: times-mvk6XK0 */
    private static final long m1822timesmvk6XK0(int i, long j) {
        return Duration.m1756timesUwyO8pc(j, i);
    }

    /* renamed from: times-kIfJnKk */
    private static final long m1821timeskIfJnKk(double d, long j) {
        return Duration.m1755timesUwyO8pc(j, d);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x009c A[LOOP:1: B:26:0x006c->B:37:0x009c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa A[EDGE_INSN: B:38:0x00aa->B:39:0x00aa BREAK  A[LOOP:1: B:26:0x006c->B:37:0x009c], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long parseDuration(String str, boolean z) {
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        long m1816getZEROUwyO8pc = Duration.INSTANCE.m1816getZEROUwyO8pc();
        char charAt = str.charAt(0);
        boolean z5 = true;
        int i2 = (charAt == '+' || charAt == '-') ? 1 : 0;
        boolean z6 = i2 > 0;
        boolean z7 = z6 && StringsKt.startsWith$default((CharSequence) str, '-', false, 2, (Object) null);
        if (length <= i2) {
            throw new IllegalArgumentException("No components");
        }
        char charAt2 = str.charAt(i2);
        char c = AbstractJsonLexerKt.COLON;
        char c2 = '0';
        if (charAt2 == 'P') {
            int i3 = i2 + 1;
            if (i3 == length) {
                throw new IllegalArgumentException();
            }
            boolean z8 = false;
            DurationUnit durationUnit = null;
            while (i3 < length) {
                if (str.charAt(i3) != 'T') {
                    int i4 = i3;
                    while (true) {
                        if (i4 >= str.length()) {
                            z3 = z7;
                            break;
                        }
                        char charAt3 = str.charAt(i4);
                        if (!((c2 > charAt3 || charAt3 >= c) ? false : z5)) {
                            z3 = z7;
                            if (!StringsKt.contains$default((CharSequence) "+-.", charAt3, false, 2, (Object) null)) {
                                z4 = false;
                                if (z4) {
                                    break;
                                }
                                i4++;
                                z7 = z3;
                                c2 = '0';
                                c = AbstractJsonLexerKt.COLON;
                                z5 = true;
                            }
                        } else {
                            z3 = z7;
                        }
                        z4 = true;
                        if (z4) {
                        }
                    }
                    Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                    String substring = str.substring(i3, i4);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    String str2 = substring;
                    if (str2.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length2 = i3 + substring.length();
                    String str3 = str;
                    if (!(length2 >= 0 && length2 < str3.length())) {
                        throw new IllegalArgumentException("Missing unit for value " + substring);
                    }
                    char charAt4 = str3.charAt(length2);
                    int i5 = length2 + 1;
                    DurationUnit durationUnitByIsoChar = DurationUnitKt.durationUnitByIsoChar(charAt4, z8);
                    if (durationUnit != null && durationUnit.compareTo(durationUnitByIsoChar) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, '.', 0, false, 6, (Object) null);
                    if (durationUnitByIsoChar == DurationUnit.SECONDS && indexOf$default > 0) {
                        Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
                        String substring2 = substring.substring(0, indexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                        i = i5;
                        long m1754plusLRDsOJo = Duration.m1754plusLRDsOJo(m1816getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(substring2), durationUnitByIsoChar));
                        Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
                        String substring3 = substring.substring(indexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                        m1816getZEROUwyO8pc = Duration.m1754plusLRDsOJo(m1754plusLRDsOJo, toDuration(Double.parseDouble(substring3), durationUnitByIsoChar));
                    } else {
                        i = i5;
                        m1816getZEROUwyO8pc = Duration.m1754plusLRDsOJo(m1816getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(substring), durationUnitByIsoChar));
                    }
                    i3 = i;
                    durationUnit = durationUnitByIsoChar;
                    z7 = z3;
                    c2 = '0';
                    c = AbstractJsonLexerKt.COLON;
                    z5 = true;
                } else {
                    if (z8 || (i3 = i3 + 1) == length) {
                        throw new IllegalArgumentException();
                    }
                    z8 = z5;
                }
            }
            z2 = z7;
        } else {
            z2 = z7;
            if (z) {
                throw new IllegalArgumentException();
            }
            String str4 = "Unexpected order of duration components";
            if (StringsKt.regionMatches(str, i2, "Infinity", 0, Math.max(length - i2, 8), true)) {
                m1816getZEROUwyO8pc = Duration.INSTANCE.m1814getINFINITEUwyO8pc();
            } else {
                boolean z9 = !z6;
                if (z6 && str.charAt(i2) == '(' && StringsKt.last(str) == ')') {
                    i2++;
                    length--;
                    if (i2 == length) {
                        throw new IllegalArgumentException("No components");
                    }
                    z9 = true;
                }
                DurationUnit durationUnit2 = null;
                boolean z10 = false;
                while (i2 < length) {
                    if (z10 && z9) {
                        while (i2 < str.length()) {
                            if (!(str.charAt(i2) == ' ')) {
                                break;
                            }
                            i2++;
                        }
                    }
                    int i6 = i2;
                    while (i6 < str.length()) {
                        char charAt5 = str.charAt(i6);
                        if (!(('0' <= charAt5 && charAt5 < ':') || charAt5 == '.')) {
                            break;
                        }
                        i6++;
                    }
                    Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                    String substring4 = str.substring(i2, i6);
                    Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
                    String str5 = substring4;
                    if (str5.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = i2 + substring4.length();
                    int i7 = length3;
                    while (i7 < str.length()) {
                        char charAt6 = str.charAt(i7);
                        if (!('a' <= charAt6 && charAt6 < '{')) {
                            break;
                        }
                        i7++;
                    }
                    Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                    String substring5 = str.substring(length3, i7);
                    Intrinsics.checkNotNullExpressionValue(substring5, "substring(...)");
                    i2 = length3 + substring5.length();
                    DurationUnit durationUnitByShortName = DurationUnitKt.durationUnitByShortName(substring5);
                    if (durationUnit2 != null && durationUnit2.compareTo(durationUnitByShortName) <= 0) {
                        throw new IllegalArgumentException(str4);
                    }
                    String str6 = str4;
                    int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str5, '.', 0, false, 6, (Object) null);
                    if (indexOf$default2 > 0) {
                        Intrinsics.checkNotNull(substring4, "null cannot be cast to non-null type java.lang.String");
                        String substring6 = substring4.substring(0, indexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(substring6, "substring(...)");
                        long m1754plusLRDsOJo2 = Duration.m1754plusLRDsOJo(m1816getZEROUwyO8pc, toDuration(Long.parseLong(substring6), durationUnitByShortName));
                        Intrinsics.checkNotNull(substring4, "null cannot be cast to non-null type java.lang.String");
                        String substring7 = substring4.substring(indexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(substring7, "substring(...)");
                        m1816getZEROUwyO8pc = Duration.m1754plusLRDsOJo(m1754plusLRDsOJo2, toDuration(Double.parseDouble(substring7), durationUnitByShortName));
                        if (i2 < length) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                    } else {
                        m1816getZEROUwyO8pc = Duration.m1754plusLRDsOJo(m1816getZEROUwyO8pc, toDuration(Long.parseLong(substring4), durationUnitByShortName));
                    }
                    str4 = str6;
                    durationUnit2 = durationUnitByShortName;
                    z10 = true;
                }
            }
        }
        return z2 ? Duration.m1769unaryMinusUwyO8pc(m1816getZEROUwyO8pc) : m1816getZEROUwyO8pc;
    }

    private static final long parseOverLongIsoComponent(String str) {
        int length = str.length();
        boolean z = false;
        int i = (length <= 0 || !StringsKt.contains$default((CharSequence) "+-", str.charAt(0), false, 2, (Object) null)) ? 0 : 1;
        if (length - i > 16) {
            int i2 = i;
            while (true) {
                if (i < length) {
                    char charAt = str.charAt(i);
                    if (charAt != '0') {
                        if (!('1' <= charAt && charAt < ':')) {
                            break;
                        }
                    } else if (i2 == i) {
                        i2++;
                    }
                    i++;
                } else if (length - i2 > 16) {
                    if (str.charAt(0) == '-') {
                        return Long.MIN_VALUE;
                    }
                    return LongCompanionObject.MAX_VALUE;
                }
            }
        }
        if (StringsKt.startsWith$default(str, "+", false, 2, (Object) null) && length > 1) {
            char charAt2 = str.charAt(1);
            if ('0' <= charAt2 && charAt2 < ':') {
                z = true;
            }
            if (z) {
                str = StringsKt.drop(str, 1);
            }
        }
        return Long.parseLong(str);
    }

    private static final int skipWhile(String str, int i, Function1<? super Character, Boolean> function1) {
        while (i < str.length() && function1.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
            i++;
        }
        return i;
    }

    public static final long nanosToMillis(long j) {
        return j / 1000000;
    }

    public static final long durationOfNanos(long j) {
        return Duration.m1725constructorimpl(j << 1);
    }

    public static final long durationOfMillis(long j) {
        return Duration.m1725constructorimpl((j << 1) + 1);
    }

    public static final long durationOf(long j, int i) {
        return Duration.m1725constructorimpl((j << 1) + i);
    }

    public static final long durationOfNanosNormalized(long j) {
        boolean z = false;
        if (-4611686018426999999L <= j && j < 4611686018427000000L) {
            z = true;
        }
        if (z) {
            return durationOfNanos(j);
        }
        return durationOfMillis(nanosToMillis(j));
    }

    public static final long durationOfMillisNormalized(long j) {
        boolean z = false;
        if (-4611686018426L <= j && j < 4611686018427L) {
            z = true;
        }
        if (z) {
            return durationOfNanos(millisToNanos(j));
        }
        return durationOfMillis(RangesKt.coerceIn(j, -4611686018427387903L, MAX_MILLIS));
    }

    private static final String substringWhile(String str, int i, Function1<? super Character, Boolean> function1) {
        int i2 = i;
        while (i2 < str.length() && function1.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
            i2++;
        }
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }
}
