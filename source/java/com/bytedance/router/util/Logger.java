package com.bytedance.router.util;

import android.util.Log;

/* loaded from: classes4.dex */
public final class Logger {
    private static final String TAG = "SmartRouter";
    private static boolean sDebug;

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static void v(String str) {
        v(TAG, str);
    }

    public static void d(String str) {
        d(TAG, str);
    }

    public static void i(String str) {
        i(TAG, str);
    }

    public static void w(String str) {
        w(TAG, str);
    }

    public static void e(String str) {
        e(TAG, str);
    }

    public static void v(String str, String str2) {
        if (sDebug) {
            Log.v(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (sDebug) {
            Log.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (sDebug) {
            Log.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        Log.w(str, str2);
    }

    public static void e(String str, String str2) {
        Log.e(str, str2);
    }
}
