package com.bytedance.crash.util;

import android.util.Log;
import com.bytedance.crash.config.RuntimeConfig;

/* loaded from: classes3.dex */
public final class NpthLog {
    private static final String TAG = "NPTH";

    public static void d(Object obj) {
        if (RuntimeConfig.isLocalDebug()) {
            Log.d(TAG, String.valueOf(obj));
        }
    }

    public static void d(String str, Object obj) {
        if (RuntimeConfig.isLocalDebug()) {
            Log.i(TAG, str + " " + obj);
        }
    }

    public static void i(Object obj) {
        if (RuntimeConfig.isDebugMode()) {
            Log.i(TAG, String.valueOf(obj));
        }
    }

    public static void i(String str, Object obj) {
        if (RuntimeConfig.isDebugMode()) {
            Log.i(TAG, str + " " + obj);
        }
    }

    public static void w(Throwable th) {
        w(TAG, th);
    }

    public static void w(String str) {
        w(TAG, str);
    }

    public static void w(String str, Throwable th) {
        if (RuntimeConfig.isDebugMode()) {
            Log.w(str, th);
        }
    }

    public static void w(String str, String str2) {
        if (RuntimeConfig.isDebugMode()) {
            Log.w(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (RuntimeConfig.isDebugMode()) {
            Log.w(str, str2, th);
        }
    }

    public static void e(Throwable th) {
        e("", th);
    }

    public static void e(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    public static void e(String str, Object obj) {
        Log.e(TAG, str + " " + obj);
    }

    public static void e(String str, Object obj, Throwable th) {
        if (RuntimeConfig.isDebugMode()) {
            Log.e(TAG, str + " " + obj, th);
        }
    }
}
