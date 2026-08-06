package com.bytedance.applog.util;

/* loaded from: classes3.dex */
public class TLog {
    public static boolean DEBUG = false;
    public static final int SDK_VERSION = 5071151;
    public static final int SDK_VERSION_CODE;
    public static final String SDK_VERSION_NAME = "5.7.11-rc.1";
    private static final String TAG = "AppLog";
    public static final boolean USE_ID = true;
    private static final String USNP = "U SHALL NOT PASS!";
    public static volatile boolean sEnableEventTraceLog;

    @Deprecated
    public static void d(String str) {
    }

    @Deprecated
    public static void d(String str, Throwable th) {
    }

    @Deprecated
    public static void e(String str, Throwable th) {
    }

    @Deprecated
    public static void i(String str, Throwable th) {
    }

    @Deprecated
    public static void r(String str) {
    }

    @Deprecated
    public static void r(String str, Throwable th) {
    }

    @Deprecated
    public static void w(String str, Throwable th) {
    }

    static {
        if (String.valueOf(5071151).charAt(0) >= '4') {
            SDK_VERSION_CODE = 15070750;
        } else {
            SDK_VERSION_CODE = 5071151;
        }
    }
}
