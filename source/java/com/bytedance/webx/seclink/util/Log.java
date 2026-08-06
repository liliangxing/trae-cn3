package com.bytedance.webx.seclink.util;

import com.bytedance.webx.base.logger.ILogger;
import com.bytedance.webx.base.logger.WLog;

/* loaded from: classes6.dex */
public class Log {
    private static boolean isEnable;

    public static void setSecLinkLog(ILogger iLogger) {
        WLog.registerLogger(iLogger);
    }

    public static void setEnable(boolean z) {
        isEnable = z;
    }

    public static void d(String str, String str2) {
        if (isEnable) {
            WLog.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (isEnable) {
            WLog.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (isEnable) {
            WLog.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (isEnable) {
            WLog.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (isEnable) {
            WLog.e(str, str2, th);
        }
    }
}
