package com.ss.vcbkit;

/* loaded from: classes7.dex */
public class VLog {
    private static int VCBLOG_LEVEL_DEBUG = 1;
    private static int VCBLOG_LEVEL_ERROR = 4;
    private static int VCBLOG_LEVEL_FATAL = 5;
    private static int VCBLOG_LEVEL_INFO = 2;
    private static int VCBLOG_LEVEL_SILENT = 6;
    private static int VCBLOG_LEVEL_VERBOSE = 0;
    private static int VCBLOG_LEVEL_WARN = 3;

    public static void v(String str, String str2) {
        Native.nativeLog(VCBLOG_LEVEL_VERBOSE, str, str2);
    }

    public static void d(String str, String str2) {
        Native.nativeLog(VCBLOG_LEVEL_DEBUG, str, str2);
    }

    public static void i(String str, String str2) {
        Native.nativeLog(VCBLOG_LEVEL_INFO, str, str2);
    }

    public static void e(String str, String str2) {
        Native.nativeLog(VCBLOG_LEVEL_ERROR, str, str2);
    }

    public static void w(String str, String str2) {
        Native.nativeLog(VCBLOG_LEVEL_WARN, str, str2);
    }

    public static void f(String str, String str2) {
        Native.nativeLog(VCBLOG_LEVEL_FATAL, str, str2);
    }

    public static void s(String str, String str2) {
        Native.nativeLog(VCBLOG_LEVEL_SILENT, str, str2);
    }

    public static void debug(String str, String str2) {
        Native.nativeLog(VCBLOG_LEVEL_DEBUG, str, str2);
    }

    public static void verbose(String str, String str2) {
        Native.nativeLog(VCBLOG_LEVEL_VERBOSE, str, str2);
    }

    public static void info(String str, String str2) {
        Native.nativeLog(VCBLOG_LEVEL_INFO, str, str2);
    }

    public static void warn(String str, String str2) {
        Native.nativeLog(VCBLOG_LEVEL_WARN, str, str2);
    }

    public static void error(String str, String str2) {
        Native.nativeLog(VCBLOG_LEVEL_ERROR, str, str2);
    }

    public static void fatal(String str, String str2) {
        Native.nativeLog(VCBLOG_LEVEL_FATAL, str, str2);
    }

    public static void setConsoleLog(boolean z) {
        Native.setConsoleLog(z);
    }
}
