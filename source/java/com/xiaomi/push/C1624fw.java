package com.xiaomi.push;

import java.util.Random;

/* renamed from: com.xiaomi.push.fw */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1624fw {

    /* renamed from: a */
    private static final char[] f1854a = "&quot;".toCharArray();

    /* renamed from: b */
    private static final char[] f1855b = "&apos;".toCharArray();

    /* renamed from: c */
    private static final char[] f1856c = "&amp;".toCharArray();

    /* renamed from: d */
    private static final char[] f1857d = "&lt;".toCharArray();

    /* renamed from: e */
    private static final char[] f1858e = "&gt;".toCharArray();

    /* renamed from: a */
    private static Random f1853a = new Random();

    /* renamed from: f */
    private static char[] f1859f = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: a */
    public static String m2647a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuilder sb = new StringBuilder((int) (length * 1.3d));
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char c = charArray[i];
            if (c <= '>') {
                if (c == '<') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(f1857d);
                } else if (c == '>') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(f1858e);
                } else if (c == '&') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    int i3 = i + 5;
                    if (length <= i3 || charArray[i + 1] != '#' || !Character.isDigit(charArray[i + 2]) || !Character.isDigit(charArray[i + 3]) || !Character.isDigit(charArray[i + 4]) || charArray[i3] != ';') {
                        i2 = i + 1;
                        sb.append(f1856c);
                    }
                } else if (c == '\"') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(f1854a);
                } else if (c == '\'') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(f1855b);
                }
            }
            i++;
        }
        if (i2 == 0) {
            return str;
        }
        if (i > i2) {
            sb.append(charArray, i2, i - i2);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static final String m2650b(String str) {
        return m2648a(m2648a(m2648a(m2648a(m2648a(str, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", "&");
    }

    /* renamed from: a */
    public static final String m2648a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2, 0);
        if (indexOf < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str3.toCharArray();
        int length = str2.length();
        StringBuilder sb = new StringBuilder(charArray.length);
        sb.append(charArray, 0, indexOf).append(charArray2);
        int i = indexOf + length;
        while (true) {
            int indexOf2 = str.indexOf(str2, i);
            if (indexOf2 > 0) {
                sb.append(charArray, i, indexOf2 - i).append(charArray2);
                i = indexOf2 + length;
            } else {
                sb.append(charArray, i, charArray.length - i);
                return sb.toString();
            }
        }
    }

    /* renamed from: a */
    public static String m2649a(byte[] bArr) {
        return String.valueOf(C1490ax.m1589a(bArr));
    }

    /* renamed from: a */
    public static String m2646a(int i) {
        if (i < 1) {
            return null;
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = f1859f[f1853a.nextInt(71)];
        }
        return new String(cArr);
    }
}
