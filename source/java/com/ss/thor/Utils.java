package com.ss.thor;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes7.dex */
public class Utils {
    private static final int FALSE = 2;
    private static final int TRUE = 1;
    private static final int UNKNOWN = 3;
    private static int isOppo = 3;
    private static int isSamsung = 3;
    private static int isSihi = 3;

    public static boolean isOppo() {
        int i = isOppo;
        if (i != 3) {
            return i == 1;
        }
        String str = Build.BRAND;
        int i2 = (TextUtils.isEmpty(str) || !str.toLowerCase().contains("oppo")) ? 2 : 1;
        isOppo = i2;
        return i2 == 1;
    }

    public static boolean isSihi() {
        int i = isSihi;
        if (i != 3) {
            return i == 1;
        }
        String str = Build.HARDWARE;
        int i2 = (TextUtils.isEmpty(str) || !(str.toLowerCase().contains("hi") || str.toLowerCase().contains("kirin"))) ? 2 : 1;
        isSihi = i2;
        return i2 == 1;
    }

    public static boolean isSamsung() {
        int i = isSamsung;
        if (i != 3) {
            return i == 1;
        }
        String str = Build.BRAND;
        int i2 = (TextUtils.isEmpty(str) || !str.toLowerCase().contains("samsung")) ? 2 : 1;
        isSamsung = i2;
        return i2 == 1;
    }
}
