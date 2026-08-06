package com.google.gson.internal.bind.util;

import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* loaded from: classes6.dex */
public class ISO8601Utils {
    private static final String UTC_ID = "UTC";
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(AbstractJsonLexerKt.COLON);
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(AbstractJsonLexerKt.COLON);
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int abs = Math.abs(i / 60);
            int abs2 = Math.abs(i % 60);
            sb.append(offset >= 0 ? '+' : '-');
            padInt(sb, abs, 2);
            sb.append(AbstractJsonLexerKt.COLON);
            padInt(sb, abs2, 2);
        } else {
            sb.append(Matrix.MATRIX_TYPE_ZERO);
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00d8 A[Catch: IllegalArgumentException -> 0x01c4, NumberFormatException -> 0x01c6, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c8, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c8, blocks: (B:3:0x000a, B:5:0x001c, B:6:0x001e, B:8:0x002a, B:9:0x002c, B:11:0x003c, B:13:0x0042, B:18:0x0059, B:20:0x0069, B:21:0x006b, B:23:0x0077, B:24:0x0079, B:26:0x007f, B:30:0x0089, B:35:0x0099, B:37:0x00a1, B:43:0x00d2, B:45:0x00d8, B:47:0x00df, B:48:0x018a, B:55:0x00ee, B:56:0x0106, B:57:0x0107, B:60:0x0125, B:62:0x0132, B:65:0x013b, B:67:0x0156, B:70:0x0165, B:71:0x0185, B:73:0x0188, B:74:0x0112, B:75:0x01bc, B:76:0x01c3, B:77:0x00ba, B:78:0x00bd), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01bc A[Catch: IllegalArgumentException -> 0x01c4, NumberFormatException -> 0x01c6, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c8, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c8, blocks: (B:3:0x000a, B:5:0x001c, B:6:0x001e, B:8:0x002a, B:9:0x002c, B:11:0x003c, B:13:0x0042, B:18:0x0059, B:20:0x0069, B:21:0x006b, B:23:0x0077, B:24:0x0079, B:26:0x007f, B:30:0x0089, B:35:0x0099, B:37:0x00a1, B:43:0x00d2, B:45:0x00d8, B:47:0x00df, B:48:0x018a, B:55:0x00ee, B:56:0x0106, B:57:0x0107, B:60:0x0125, B:62:0x0132, B:65:0x013b, B:67:0x0156, B:70:0x0165, B:71:0x0185, B:73:0x0188, B:74:0x0112, B:75:0x01bc, B:76:0x01c3, B:77:0x00ba, B:78:0x00bd), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Date parse(String str, ParsePosition parsePosition) throws ParseException {
        int i;
        int i2;
        int i3;
        int i4;
        int length;
        TimeZone timeZone;
        char charAt;
        try {
            int index = parsePosition.getIndex();
            int i5 = index + 4;
            int parseInt = parseInt(str, index, i5);
            if (checkOffset(str, i5, '-')) {
                i5++;
            }
            int i6 = i5 + 2;
            int parseInt2 = parseInt(str, i5, i6);
            if (checkOffset(str, i6, '-')) {
                i6++;
            }
            int i7 = i6 + 2;
            int parseInt3 = parseInt(str, i6, i7);
            boolean checkOffset = checkOffset(str, i7, 'T');
            if (!checkOffset && str.length() <= i7) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(parseInt, parseInt2 - 1, parseInt3);
                gregorianCalendar.setLenient(false);
                parsePosition.setIndex(i7);
                return gregorianCalendar.getTime();
            }
            if (checkOffset) {
                int i8 = i7 + 1;
                int i9 = i8 + 2;
                int parseInt4 = parseInt(str, i8, i9);
                if (checkOffset(str, i9, AbstractJsonLexerKt.COLON)) {
                    i9++;
                }
                int i10 = i9 + 2;
                i2 = parseInt(str, i9, i10);
                if (checkOffset(str, i10, AbstractJsonLexerKt.COLON)) {
                    i10++;
                }
                if (str.length() > i10 && (charAt = str.charAt(i10)) != 'Z' && charAt != '+' && charAt != '-') {
                    int i11 = i10 + 2;
                    i4 = parseInt(str, i10, i11);
                    if (i4 > 59 && i4 < 63) {
                        i4 = 59;
                    }
                    if (checkOffset(str, i11, '.')) {
                        int i12 = i11 + 1;
                        int indexOfNonDigit = indexOfNonDigit(str, i12 + 1);
                        int min = Math.min(indexOfNonDigit, i12 + 3);
                        int parseInt5 = parseInt(str, i12, min);
                        int i13 = min - i12;
                        if (i13 == 1) {
                            parseInt5 *= 100;
                        } else if (i13 == 2) {
                            parseInt5 *= 10;
                        }
                        i3 = parseInt5;
                        i7 = indexOfNonDigit;
                        i = parseInt4;
                    } else {
                        i = parseInt4;
                        i7 = i11;
                        i3 = 0;
                    }
                    if (str.length() > i7) {
                        throw new IllegalArgumentException("No time zone indicator");
                    }
                    char charAt2 = str.charAt(i7);
                    if (charAt2 == 'Z') {
                        timeZone = TIMEZONE_UTC;
                        length = i7 + 1;
                    } else {
                        if (charAt2 != '+' && charAt2 != '-') {
                            throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                        }
                        String substring = str.substring(i7);
                        if (substring.length() < 5) {
                            substring = substring + "00";
                        }
                        length = i7 + substring.length();
                        if (!"+0000".equals(substring) && !"+00:00".equals(substring)) {
                            String str2 = "GMT" + substring;
                            TimeZone timeZone2 = TimeZone.getTimeZone(str2);
                            String id = timeZone2.getID();
                            if (!id.equals(str2) && !id.replace(Constants.COLON_SEPARATOR, "").equals(str2)) {
                                throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str2 + " given, resolves to " + timeZone2.getID());
                            }
                            timeZone = timeZone2;
                        }
                        timeZone = TIMEZONE_UTC;
                    }
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                    gregorianCalendar2.setLenient(false);
                    gregorianCalendar2.set(1, parseInt);
                    gregorianCalendar2.set(2, parseInt2 - 1);
                    gregorianCalendar2.set(5, parseInt3);
                    gregorianCalendar2.set(11, i);
                    gregorianCalendar2.set(12, i2);
                    gregorianCalendar2.set(13, i4);
                    gregorianCalendar2.set(14, i3);
                    parsePosition.setIndex(length);
                    return gregorianCalendar2.getTime();
                }
                i = parseInt4;
                i7 = i10;
            } else {
                i = 0;
                i2 = 0;
            }
            i3 = 0;
            i4 = 0;
            if (str.length() > i7) {
            }
        } catch (IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException e) {
            String str3 = str == null ? null : "\"" + str + '\"';
            String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str3 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -digit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - digit2;
            i4 = i5;
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
