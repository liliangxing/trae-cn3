package com.huawei.secure.android.common.anonymization;

/* renamed from: com.huawei.secure.android.common.anonymization.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1284a {
    /* renamed from: a */
    public static String[] m2231a(String[] strArr, String[] strArr2) {
        if (strArr.length <= 0) {
            return strArr2.length <= 0 ? new String[0] : strArr2;
        }
        if (strArr2.length <= 0) {
            return strArr;
        }
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    /* renamed from: b */
    public static String[] m2233b(String str, String[] strArr) {
        return m2231a(new String[]{str}, strArr);
    }

    /* renamed from: b */
    public static String[] m2232b(String str, char c) {
        if (str == null) {
            return new String[0];
        }
        if (str.length() <= 0) {
            return new String[]{str};
        }
        int i = 1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                i++;
            }
        }
        if (i <= 1) {
            return new String[]{str};
        }
        String[] strArr = new String[i];
        StringBuilder sb = new StringBuilder(str.length());
        int i3 = 0;
        for (int i4 = 0; i4 < str.length() && i3 < i; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == c) {
                strArr[i3] = sb.toString();
                sb.setLength(0);
                i3++;
            } else {
                sb.append(charAt);
            }
        }
        strArr[i3] = sb.toString();
        return strArr;
    }

    /* renamed from: a */
    public static String[] m2230a(String[] strArr, String str) {
        return m2231a(strArr, new String[]{str});
    }

    /* renamed from: a */
    public static String[] m2227a(String str, int i, int i2) {
        String[] m2226a = m2226a(str, i);
        return m2233b(m2225a(m2226a, 0), m2226a(m2225a(m2226a, 1), i2 - i));
    }

    /* renamed from: a */
    public static String[] m2228a(String str, int i, int i2, int i3) {
        String[] m2226a = m2226a(str, i);
        return m2233b(m2225a(m2226a, 0), m2227a(m2225a(m2226a, 1), i2 - i, i3 - i));
    }

    /* renamed from: a */
    public static String[] m2229a(String str, int... iArr) {
        if (str == null) {
            return new String[]{""};
        }
        if (str.length() <= 1 || iArr.length <= 0) {
            return new String[]{str};
        }
        if (iArr.length <= 1) {
            return m2226a(str, iArr[0]);
        }
        int i = iArr[0];
        int length = iArr.length - 1;
        int[] iArr2 = new int[length];
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            iArr2[i2] = iArr[i3] - i;
            i2 = i3;
        }
        String[] m2226a = m2226a(str, i);
        return m2233b(m2225a(m2226a, 0), m2229a(m2225a(m2226a, 1), iArr2));
    }

    /* renamed from: a */
    public static String[] m2226a(String str, int i) {
        if (str == null) {
            return new String[]{"", ""};
        }
        return (i < 0 || i > str.length()) ? new String[]{str, ""} : new String[]{str.substring(0, i), str.substring(i)};
    }

    /* renamed from: a */
    public static String m2224a(String str, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i] != null) {
                sb.append(str).append(strArr[i]);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m2223a(String str, String str2, String str3) {
        if (str == null || str.length() <= 0 || str2.length() <= 0 || str3.length() <= 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] cArr = new char[str.length()];
        char charAt = str3.charAt(str3.length() - 1);
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int lastIndexOf = str2.lastIndexOf(c);
            if (lastIndexOf < 0) {
                cArr[i] = c;
            } else {
                cArr[i] = lastIndexOf >= str3.length() ? charAt : str3.charAt(lastIndexOf);
            }
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static String m2225a(String[] strArr, int i) {
        return (strArr == null || strArr.length <= 0 || i < 0 || i >= strArr.length) ? "" : strArr[i];
    }

    /* renamed from: a */
    public static String m2222a(String str, char c) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int length = str.length();
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = c;
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static int m2221a(String str, char c, int i) {
        int length = str.length() - 1;
        while (length >= 0 && (str.charAt(length) != c || i - 1 > 0)) {
            length--;
        }
        return length;
    }
}
