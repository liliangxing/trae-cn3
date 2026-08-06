package com.bytedance.android.monitor.logger;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes3.dex */
public class MonitorLog {
    private static final String TAG_PRE = "hybrid_multi_monitor_";
    private static boolean isLogEnable;
    private static ILogger sLogger;

    public static void setLogger(ILogger iLogger) {
        sLogger = iLogger;
    }

    public static void setLogEnable(boolean z) {
        isLogEnable = z;
    }

    public static boolean isLogEnable() {
        return isLogEnable;
    }

    public static void v(String str, String str2) {
        if (isLogEnable()) {
            String logTag = getLogTag(str);
            ILogger iLogger = sLogger;
            if (iLogger != null) {
                iLogger.v(logTag, str2);
            } else {
                Log.v(logTag, str2);
            }
        }
    }

    public static void d(String str, String str2) {
        if (isLogEnable()) {
            String logTag = getLogTag(str);
            ILogger iLogger = sLogger;
            if (iLogger != null) {
                iLogger.d(logTag, str2);
            } else {
                Log.d(logTag, str2);
            }
        }
    }

    public static void i(String str, String str2) {
        if (isLogEnable()) {
            String logTag = getLogTag(str);
            ILogger iLogger = sLogger;
            if (iLogger != null) {
                iLogger.i(logTag, str2);
            } else {
                Log.i(logTag, str2);
            }
        }
    }

    public static void w(String str, String str2) {
        if (isLogEnable()) {
            String logTag = getLogTag(str);
            ILogger iLogger = sLogger;
            if (iLogger != null) {
                iLogger.w(logTag, str2);
            } else {
                Log.w(logTag, str2);
            }
        }
    }

    public static void e(String str, String str2) {
        String logTag = getLogTag(str);
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.e(logTag, str2);
        } else {
            Log.e(logTag, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (isLogEnable()) {
            String logTag = getLogTag(str);
            ILogger iLogger = sLogger;
            if (iLogger != null) {
                iLogger.e(logTag, str2, th);
            } else {
                Log.e(logTag, str2, th);
            }
        }
    }

    private static String getLogTag(String str) {
        return TextUtils.isEmpty(str) ? "hybrid_multi_monitor" : !str.startsWith(TAG_PRE) ? TAG_PRE + str : str;
    }
}
