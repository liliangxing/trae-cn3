package com.bytedance.upc.common.log;

import android.util.Log;

/* loaded from: classes6.dex */
public class LogUtils {
    public static final String TAG = "UpcSDKLog";
    private static boolean debug;
    private static ILog sLogger = new DefaultLog();

    public static void setDebug(boolean z) {
        debug = z;
    }

    public static void v(String str) {
        ILog iLog;
        if (!debug || (iLog = sLogger) == null) {
            return;
        }
        iLog.v(TAG, str);
    }

    public static void e(String str) {
        ILog iLog;
        if (!debug || (iLog = sLogger) == null) {
            return;
        }
        iLog.e(TAG, str);
    }

    public static void e(Throwable th) {
        ILog iLog;
        if (!debug || (iLog = sLogger) == null) {
            return;
        }
        iLog.e(TAG, Log.getStackTraceString(th));
    }

    public static void d(String str) {
        ILog iLog;
        if (!debug || (iLog = sLogger) == null) {
            return;
        }
        iLog.d(TAG, str);
    }

    public static void i(String str) {
        ILog iLog;
        if (!debug || (iLog = sLogger) == null) {
            return;
        }
        iLog.i(TAG, str);
    }

    public static void w(String str) {
        ILog iLog;
        if (!debug || (iLog = sLogger) == null) {
            return;
        }
        iLog.w(TAG, str);
    }

    public static void setILog(ILog iLog) {
        if (!debug || sLogger == null) {
            return;
        }
        sLogger = iLog;
    }
}
