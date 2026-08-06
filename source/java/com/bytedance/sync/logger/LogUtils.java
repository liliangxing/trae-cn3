package com.bytedance.sync.logger;

import com.bytedance.sync.interfaze.ILogger;

/* loaded from: classes5.dex */
public class LogUtils {
    public static final String TAG = "SyncSDKLog";
    private static ILogger sLogger = new ALogger();

    public static void v(String str) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.v(str);
        }
    }

    public static void e(String str) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.e(str);
        }
    }

    public static void d(String str) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.d(str);
        }
    }

    public static void i(String str) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.i(str);
        }
    }

    public static void setLogger(ILogger iLogger) {
        if (iLogger != null) {
            sLogger = iLogger;
        }
    }
}
