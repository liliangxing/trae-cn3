package com.lynx.animax.util;

import android.util.Log;

/* loaded from: classes6.dex */
public class AnimaXLog {
    private static final String TAG = "[AnimaX]";

    /* loaded from: classes6.dex */
    public enum LogLevel {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    private static native void nativeLog(int i, String str, String str2);

    public static void v(String str, String str2) {
        log(LogLevel.VERBOSE, str, str2);
    }

    public static void d(String str, String str2) {
        log(LogLevel.DEBUG, str, str2);
    }

    public static void i(String str, String str2) {
        log(LogLevel.INFO, str, str2);
    }

    public static void w(String str, String str2) {
        log(LogLevel.WARN, str, str2);
    }

    public static void e(String str, String str2) {
        log(LogLevel.ERROR, str, str2);
    }

    private static void log(LogLevel logLevel, String str, String str2) {
        if (AnimaX.inst().hasLibInitialized()) {
            nativeLog(logLevel.ordinal(), str, str2);
        } else {
            Log.e(TAG, "AnimaX is not initialized, log will be ignored: " + str2);
        }
    }
}
