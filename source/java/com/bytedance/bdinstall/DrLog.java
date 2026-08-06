package com.bytedance.bdinstall;

import com.bytedance.bdinstall.util.LocalConstants;

/* loaded from: classes3.dex */
public class DrLog {
    public static boolean DEBUG = false;
    public static final int SDK_VERSION_CODE = LocalConstants.getVersionCode();
    static final String TAG = "bdinstall# ";
    private static final String USNP = "U SHALL NOT PASS!";
    private static ILogger logger;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLogger(ILogger iLogger) {
        logger = iLogger;
    }

    public static void d(String str) {
        ILogger iLogger = logger;
        if (iLogger != null) {
            iLogger.d(TAG + str, null);
        }
    }

    public static void w(String str, Throwable th) {
        ILogger iLogger = logger;
        if (iLogger != null) {
            iLogger.w(TAG + str, th);
        }
    }

    public static void e(String str, Throwable th) {
        ILogger iLogger = logger;
        if (iLogger != null) {
            iLogger.e(TAG + str, th);
        }
    }

    public static void i(String str, Throwable th) {
        ILogger iLogger = logger;
        if (iLogger != null) {
            iLogger.i(TAG + str, th);
        }
    }

    public static void v(String str, Throwable th) {
        ILogger iLogger = logger;
        if (iLogger != null) {
            iLogger.v(TAG + str, th);
        }
    }

    public static void ysnp(Throwable th) {
        ILogger iLogger = logger;
        if (iLogger != null) {
            iLogger.e(USNP, th);
        }
    }

    public static boolean debug() {
        return DEBUG;
    }

    public static void v(String str) {
        ILogger iLogger = logger;
        if (iLogger != null) {
            iLogger.v(TAG + str, null);
        }
    }

    public static void e(String str) {
        ILogger iLogger = logger;
        if (iLogger != null) {
            iLogger.e(TAG + str, null);
        }
    }
}
