package com.bytedance.push.utils;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class ArrayUtils {
    public static boolean contains(int[] iArr, Integer num) {
        return indexOf(iArr, num) != -1;
    }

    public static int indexOf(int[] iArr, Integer num) {
        if (iArr == null) {
            return -1;
        }
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == num.intValue()) {
                return i;
            }
        }
        return -1;
    }

    public static boolean contains(String[] strArr, String str) {
        return indexOf(strArr, str) != -1;
    }

    public static int indexOf(String[] strArr, String str) {
        if (strArr == null) {
            return -1;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (TextUtils.equals(strArr[i], str)) {
                return i;
            }
        }
        return -1;
    }
}
