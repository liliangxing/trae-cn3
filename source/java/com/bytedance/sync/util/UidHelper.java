package com.bytedance.sync.util;

import android.text.TextUtils;

/* loaded from: classes5.dex */
public class UidHelper {
    public static boolean isSameUser(String str, String str2) {
        if (TextUtils.equals(str, str2)) {
            return true;
        }
        return isNullOrInValid(str) && isNullOrInValid(str2);
    }

    private static boolean isNullOrInValid(String str) {
        return TextUtils.isEmpty(str) || TextUtils.equals(str, "0");
    }
}
