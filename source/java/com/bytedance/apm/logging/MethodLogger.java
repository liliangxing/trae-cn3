package com.bytedance.apm.logging;

import com.bytedance.apm.logging.MethodLog;

/* loaded from: classes3.dex */
public class MethodLogger {
    private static MethodLog.LogImp logImp = MethodLog.sLog;

    private MethodLogger() {
    }

    public static void i(String str, String str2, Object... objArr) {
        MethodLog.LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.i(str, str2, objArr);
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        MethodLog.LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.v(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        MethodLog.LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.w(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        MethodLog.LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        MethodLog.LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.printErrStackTrace(str, th, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        MethodLog.LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.e(str, str2, objArr);
        }
    }
}
