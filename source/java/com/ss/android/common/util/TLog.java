package com.ss.android.common.util;

import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;

/* loaded from: classes7.dex */
public class TLog {
    private static final IAppLogLogger global = LoggerImpl.global();
    private static volatile ILogger sLogger;

    public static void setLogger(ILogger iLogger) {
        sLogger = iLogger;
    }

    public static void v(String str) {
        v(str, null);
    }

    public static void d(String str) {
        d(str, null);
    }

    public static void i(String str) {
        i(str, null);
    }

    public static void w(String str) {
        w(str, null);
    }

    public static void e(String str) {
        e(str, null);
    }

    public static void v(String str, Throwable th) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.v(str, th);
        }
        global.verbose(str, new Object[0]);
    }

    public static void d(String str, Throwable th) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.d(str, th);
        }
        global.debug(str, new Object[0]);
    }

    public static void i(String str, Throwable th) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.i(str, th);
        }
        global.info(str, new Object[0]);
    }

    public static void w(String str, Throwable th) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.w(str, th);
        }
        global.warn(str, new Object[0]);
    }

    public static void e(String str, Throwable th) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.e(str, th);
        }
        global.error(str, th, new Object[0]);
    }
}
