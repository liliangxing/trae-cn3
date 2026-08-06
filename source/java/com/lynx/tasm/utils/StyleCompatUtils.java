package com.lynx.tasm.utils;

/* loaded from: classes7.dex */
public final class StyleCompatUtils {
    public static boolean shouldCompat(Class cls, Class cls2, String str, Class<?>... clsArr) {
        if (cls == cls2) {
            return false;
        }
        return cls.getDeclaredMethod(str, clsArr) != null;
    }

    private static int parseNumericFontWeight(String str) {
        if (str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') {
            return -1;
        }
        return (str.charAt(0) - '0') * 100;
    }

    public static int toFontWeight(String str) {
        if ((str != null ? parseNumericFontWeight(str) : -1) >= 500 || "bold".equals(str)) {
            return 1;
        }
        "normal".equals(str);
        return 0;
    }

    public static int toFontStyle(String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        str.hashCode();
        if (str.equals("oblique")) {
            return 2;
        }
        return !str.equals("italic") ? 0 : 1;
    }

    public static int toTextDecoration(String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (String str2 : str.split(" ")) {
            if ("underline".equals(str2)) {
                i |= 1;
            } else if ("line-through".equals(str2)) {
                i |= 2;
            }
        }
        return i;
    }
}
