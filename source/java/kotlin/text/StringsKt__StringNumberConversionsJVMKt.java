package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.BuildConfig;
import org.bouncycastle.crypto.digests.Blake2xsDigest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversionsJVM.kt */
@Metadata(m4d1 = {"\u0000V\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\u0010\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u000e\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u000f\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u0001H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0002*\u00020\u0001H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0005*\u00020\u0001H\u0087\b\u001a\u0015\u0010\n\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\u0004*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\f\u001a\u00020\u0006*\u00020\u0001H\u0087\b\u001a\u0015\u0010\f\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0001H\u0087\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0001H\u0087\b\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0010*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0016*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0015\u001a\u00020\u0016*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u00020\u0001H\u0007\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\r\u0010\u0018\u001a\u00020\u0019*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bH\u0087\b\u001a\u000e\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u0001H\u0007\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bH\u0007\u001a4\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u001f\u001a\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001e0!H\u0082\b¢\u0006\u0004\b\"\u0010#\u001a\u0015\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0001H\u0002¢\u0006\u0002\b&\u001a \u0010'\u001a\u0004\u0018\u00010\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0083\b¢\u0006\u0002\b*\u001a\u0012\u0010+\u001a\u00020\b*\u00020,H\u0083\b¢\u0006\u0002\b-\u001a\u0012\u0010.\u001a\u00020\b*\u00020,H\u0083\b¢\u0006\u0002\b/\u001a\u0012\u00100\u001a\u00020\u0004*\u00020,H\u0083\b¢\u0006\u0002\b1\u001a6\u00102\u001a\u00020\u0004*\u00020\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b0!H\u0083\b¢\u0006\u0002\b4\u001a6\u00105\u001a\u00020\u0004*\u00020\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b0!H\u0083\b¢\u0006\u0002\b6\u001a>\u00107\u001a\u00020\u0004*\u00020\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u00108\u001a\u00020\b2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b0!H\u0083\b¢\u0006\u0002\b9¨\u0006:"}, m5d2 = {"toString", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "radix", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "toBoolean", BuildConfig.FLAVOR, "toByte", "toShort", "toInt", "toLong", "toFloat", BuildConfig.FLAVOR, "toDouble", BuildConfig.FLAVOR, "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toBigInteger", "Ljava/math/BigInteger;", "toBigIntegerOrNull", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "screenFloatValue", "T", "str", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "isValidFloat", "s", "isValidFloat$StringsKt__StringNumberConversionsJVMKt", "guessNamedFloatConstant", "start", "endInclusive", "guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt", "isAsciiDigit", BuildConfig.FLAVOR, "isAsciiDigit$StringsKt__StringNumberConversionsJVMKt", "isHexLetter", "isHexLetter$StringsKt__StringNumberConversionsJVMKt", "asciiLetterToLowerCaseCode", "asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt", "advanceWhile", "predicate", "advanceWhile$StringsKt__StringNumberConversionsJVMKt", "backtrackWhile", "backtrackWhile$StringsKt__StringNumberConversionsJVMKt", "advanceAndValidateMantissa", "hexFormat", "advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt", "kotlin-stdlib"}, m6k = 5, m7mv = {2, 1, 0}, m9xi = 49, m10xs = "kotlin/text/StringsKt")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    /* renamed from: asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt */
    private static final int m57xae944efa(char c) {
        return c | ' ';
    }

    private static final String guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt(int i, int i2) {
        if (i2 == (i + 3) - 1) {
            return "NaN";
        }
        if (i2 == (i + 8) - 1) {
            return "Infinity";
        }
        return null;
    }

    private static final boolean isAsciiDigit$StringsKt__StringNumberConversionsJVMKt(char c) {
        return ((c + 65488) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) < 10;
    }

    private static final boolean isHexLetter$StringsKt__StringNumberConversionsJVMKt(char c) {
        return (((c | ' ') + (-97)) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) < 6;
    }

    private static final String toString(byte b, int i) {
        String num = Integer.toString(b, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    private static final String toString(short s, int i) {
        String num = Integer.toString(s, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    private static final String toString(int i, int i2) {
        String num = Integer.toString(i, CharsKt.checkRadix(i2));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    private static final String toString(long j, int i) {
        String l = Long.toString(j, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
        return l;
    }

    private static final boolean toBoolean(String str) {
        return Boolean.parseBoolean(str);
    }

    private static final byte toByte(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Byte.parseByte(str);
    }

    private static final byte toByte(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Byte.parseByte(str, CharsKt.checkRadix(i));
    }

    private static final short toShort(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Short.parseShort(str);
    }

    private static final short toShort(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Short.parseShort(str, CharsKt.checkRadix(i));
    }

    private static final int toInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Integer.parseInt(str);
    }

    private static final int toInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Integer.parseInt(str, CharsKt.checkRadix(i));
    }

    private static final long toLong(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Long.parseLong(str);
    }

    private static final long toLong(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Long.parseLong(str, CharsKt.checkRadix(i));
    }

    private static final float toFloat(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Float.parseFloat(str);
    }

    private static final double toDouble(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Double.parseDouble(str);
    }

    private static final BigInteger toBigInteger(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigInteger(str);
    }

    private static final BigInteger toBigInteger(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigInteger(str, CharsKt.checkRadix(i));
    }

    public static final BigInteger toBigIntegerOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.toBigIntegerOrNull(str, 10);
    }

    public static final BigInteger toBigIntegerOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            if (CharsKt.digitOf(str.charAt(0), i) < 0) {
                return null;
            }
        } else {
            for (int i2 = str.charAt(0) == '-' ? 1 : 0; i2 < length; i2++) {
                if (CharsKt.digitOf(str.charAt(i2), i) < 0) {
                    return null;
                }
            }
        }
        return new BigInteger(str, CharsKt.checkRadix(i));
    }

    private static final BigDecimal toBigDecimal(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigDecimal(str);
    }

    private static final BigDecimal toBigDecimal(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(str, mathContext);
    }

    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return function1.invoke(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x00c2 A[LOOP:6: B:153:0x009f->B:164:0x00c2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00c7 A[EDGE_INSN: B:165:0x00c7->B:166:0x00c7 BREAK  A[LOOP:6: B:153:0x009f->B:164:0x00c2], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0088 A[LOOP:2: B:34:0x0064->B:46:0x0088, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d A[EDGE_INSN: B:47:0x008d->B:48:0x008d BREAK  A[LOOP:2: B:34:0x0064->B:46:0x0088], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final boolean isValidFloat$StringsKt__StringNumberConversionsJVMKt(String str) {
        boolean z;
        int charAt;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        int length = str.length() - 1;
        int i3 = 0;
        while (i3 <= length) {
            if (!(str.charAt(i3) <= ' ')) {
                break;
            }
            i3++;
        }
        if (i3 > length) {
            return false;
        }
        while (length > i3) {
            if (!(str.charAt(length) <= ' ')) {
                break;
            }
            length--;
        }
        if (str.charAt(i3) == '+' || str.charAt(i3) == '-') {
            i3++;
        }
        if (i3 > length) {
            return false;
        }
        if (str.charAt(i3) == '0') {
            int i4 = i3 + 1;
            if (i4 > length) {
                return true;
            }
            if ((str.charAt(i4) | ' ') == 120) {
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 <= length) {
                    char charAt2 = str.charAt(i6);
                    if (!(((charAt2 + 65488) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) < 10)) {
                        if (!((((charAt2 | ' ') + (-97)) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) < 6)) {
                            z5 = false;
                            if (z5) {
                                break;
                            }
                            i6++;
                        }
                    }
                    z5 = true;
                    if (z5) {
                    }
                }
                boolean z6 = i5 != i6;
                if (i6 <= length) {
                    if (str.charAt(i6) == '.') {
                        int i7 = i6 + 1;
                        i2 = i7;
                        while (i2 <= length) {
                            char charAt3 = str.charAt(i2);
                            if (!(((charAt3 + 65488) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) < 10)) {
                                if (!((((charAt3 | ' ') + (-97)) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) < 6)) {
                                    z4 = false;
                                    if (z4) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            z4 = true;
                            if (z4) {
                            }
                        }
                        if (i7 != i2) {
                            z3 = true;
                            if (!z6 || z3) {
                                i3 = i2;
                                if (i3 != -1 || i3 > length) {
                                    return false;
                                }
                                z = true;
                                if (!z) {
                                    int i8 = i3;
                                    while (i8 <= length) {
                                        if (!(((str.charAt(i8) - '0') & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) < 10)) {
                                            break;
                                        }
                                        i8++;
                                    }
                                    boolean z7 = i3 != i8;
                                    if (i8 > length) {
                                        i3 = i8;
                                    } else {
                                        if (str.charAt(i8) == '.') {
                                            int i9 = i8 + 1;
                                            i = i9;
                                            while (i <= length) {
                                                if (!(((str.charAt(i) - '0') & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) < 10)) {
                                                    break;
                                                }
                                                i++;
                                            }
                                            if (i9 != i) {
                                                z2 = true;
                                                if (!z7 || z2) {
                                                    i3 = i;
                                                } else {
                                                    String str2 = length == (i + 3) - 1 ? "NaN" : length == (i + 8) - 1 ? "Infinity" : null;
                                                    i3 = (str2 != null && StringsKt.indexOf((CharSequence) str, str2, i, false) == i) ? length + 1 : -1;
                                                }
                                            }
                                        } else {
                                            i = i8;
                                        }
                                        z2 = false;
                                        if (z7) {
                                        }
                                        i3 = i;
                                    }
                                    if (i3 == -1) {
                                        return false;
                                    }
                                    if (i3 > length) {
                                        return true;
                                    }
                                }
                                int i10 = i3 + 1;
                                charAt = str.charAt(i3) | ' ';
                                if (charAt == (!z ? 112 : 101)) {
                                    return !z && (charAt == 102 || charAt == 100) && i10 > length;
                                }
                                if (i10 > length) {
                                    return false;
                                }
                                if ((str.charAt(i10) == '+' || str.charAt(i10) == '-') && (i10 = i10 + 1) > length) {
                                    return false;
                                }
                                while (i10 <= length) {
                                    if (!(((str.charAt(i10) - '0') & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) < 10)) {
                                        break;
                                    }
                                    i10++;
                                }
                                if (i10 > length) {
                                    return true;
                                }
                                if (i10 != length) {
                                    return false;
                                }
                                int charAt4 = str.charAt(i10) | ' ';
                                return charAt4 == 102 || charAt4 == 100;
                            }
                        }
                    } else {
                        i2 = i6;
                    }
                    z3 = false;
                    if (!z6) {
                    }
                    i3 = i2;
                    if (i3 != -1) {
                    }
                    return false;
                }
                i3 = -1;
                if (i3 != -1) {
                }
                return false;
            }
            i3 = i4 - 1;
        }
        z = false;
        if (!z) {
        }
        int i102 = i3 + 1;
        charAt = str.charAt(i3) | ' ';
        if (charAt == (!z ? 112 : 101)) {
        }
    }

    private static final int advanceWhile$StringsKt__StringNumberConversionsJVMKt(String str, int i, int i2, Function1<? super Character, Boolean> function1) {
        while (i <= i2 && function1.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
            i++;
        }
        return i;
    }

    private static final int backtrackWhile$StringsKt__StringNumberConversionsJVMKt(String str, int i, int i2, Function1<? super Character, Boolean> function1) {
        while (i2 > i && function1.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
            i2--;
        }
        return i2;
    }

    /* renamed from: advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt */
    private static final int m56x47690acb(String str, int i, int i2, boolean z, Function1<? super Character, Boolean> function1) {
        boolean z2;
        int i3 = i;
        while (i3 <= i2 && function1.invoke(Character.valueOf(str.charAt(i3))).booleanValue()) {
            i3++;
        }
        boolean z3 = i != i3;
        if (i3 > i2) {
            if (z) {
                return -1;
            }
            return i3;
        }
        if (str.charAt(i3) == '.') {
            int i4 = i3 + 1;
            int i5 = i4;
            while (i5 <= i2 && function1.invoke(Character.valueOf(str.charAt(i5))).booleanValue()) {
                i5++;
            }
            z2 = i4 != i5;
            i3 = i5;
        } else {
            z2 = false;
        }
        if (z3 || z2) {
            return i3;
        }
        if (z) {
            return -1;
        }
        String str2 = i2 == (i3 + 3) - 1 ? "NaN" : i2 == (i3 + 8) - 1 ? "Infinity" : null;
        if (str2 != null && StringsKt.indexOf((CharSequence) str, str2, i3, false) == i3) {
            return i2 + 1;
        }
        return -1;
    }

    public static final Float toFloatOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final Double toDoubleOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final BigDecimal toBigDecimalOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final BigDecimal toBigDecimalOrNull(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
