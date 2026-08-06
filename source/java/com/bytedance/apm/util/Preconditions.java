package com.bytedance.apm.util;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes3.dex */
public final class Preconditions {
    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str + " must not be null");
    }

    public static String checkNotEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2 + " must not be empty");
        }
        return str;
    }

    public static String checkNotEmptySafely(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            Log.w("apm", str2 + " is empty, please make sure");
        }
        return str;
    }

    private Preconditions() {
        throw new AssertionError();
    }
}
