package com.bytedance.ies.web.jsbridge2;

import android.util.Log;

/* loaded from: classes4.dex */
class DebugUtil {
    private static final String LOG_TAG = "JsBridge2";
    private static boolean debug;

    private DebugUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(boolean z) {
        debug = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isDebug() {
        return debug;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(String str) {
        if (debug) {
            Log.i(LOG_TAG, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(String str) {
        if (debug) {
            Log.w(LOG_TAG, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(String str, Throwable th) {
        if (debug) {
            Log.w(LOG_TAG, str, th);
            Log.w(LOG_TAG, "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(String str) {
        if (debug) {
            Log.e(LOG_TAG, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(String str, Throwable th) {
        if (debug) {
            Log.e(LOG_TAG, str, th);
            Log.e(LOG_TAG, "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void throwRuntimeException(RuntimeException runtimeException) {
        if (debug) {
            throw runtimeException;
        }
    }
}
