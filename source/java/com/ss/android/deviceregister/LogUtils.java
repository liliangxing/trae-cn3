package com.ss.android.deviceregister;

/* loaded from: classes7.dex */
public class LogUtils {
    public static String TAG = "LogDeviceRegister";
    private static int sLevel;
    private static ILogWriter sLogWriter;

    /* loaded from: classes7.dex */
    public interface ILogWriter {
        void logD(String str, String str2, Throwable th);

        void logE(String str, String str2, Throwable th);

        void logI(String str, String str2, Throwable th);

        void logV(String str, String str2, Throwable th);

        void logW(String str, String str2, Throwable th);
    }

    public static void setLogLevel(int i) {
        sLevel = i;
    }

    public static int getLogLevel() {
        return sLevel;
    }

    public static boolean debug() {
        return sLevel <= 3;
    }

    public static void v(String str, String str2) {
        v(str, str2, null);
    }

    public static void v(String str, String str2, Throwable th) {
        ILogWriter iLogWriter = sLogWriter;
        if (iLogWriter == null || sLevel > 2) {
            return;
        }
        iLogWriter.logV(str, str2, th);
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        ILogWriter iLogWriter = sLogWriter;
        if (iLogWriter == null || sLevel > 3) {
            return;
        }
        iLogWriter.logD(str, str2, th);
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void i(String str, String str2, Throwable th) {
        ILogWriter iLogWriter = sLogWriter;
        if (iLogWriter == null || sLevel > 4) {
            return;
        }
        iLogWriter.logI(str, str2, th);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void e(String str, String str2, Throwable th) {
        ILogWriter iLogWriter = sLogWriter;
        if (iLogWriter == null || sLevel > 6) {
            return;
        }
        iLogWriter.logE(str, str2, th);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void w(String str, String str2, Throwable th) {
        ILogWriter iLogWriter = sLogWriter;
        if (iLogWriter == null || sLevel > 5) {
            return;
        }
        iLogWriter.logW(str, str2, th);
    }

    public static void setLogWriter(ILogWriter iLogWriter) {
        sLogWriter = iLogWriter;
    }
}
