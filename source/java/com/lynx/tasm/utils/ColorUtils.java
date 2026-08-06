package com.lynx.tasm.utils;

/* loaded from: classes7.dex */
public class ColorUtils {
    private static native int nativeParse(String str);

    private static native boolean nativeValidate(String str);

    public static int parse(String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        return nativeParse(str);
    }

    public static boolean isValid(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return nativeValidate(str);
    }
}
