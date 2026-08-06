package com.lynx.tasm.base;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;

/* loaded from: classes6.dex */
public class LLog {
    public static final int DEBUG = 1;
    public static final int ERROR = 4;
    public static final int INFO = 2;

    @Deprecated
    public static final int REPORT = -1;
    public static final int VERBOSE = 0;
    public static final int WARN = 3;

    @Deprecated
    public static int addLoggingDelegate(AbsLogDelegate absLogDelegate) {
        return -1;
    }

    @Deprecated
    public static void initALog(long j) {
    }

    public static void internalLog(int i, String str, String str2, LogSource logSource, Long l, int i2) {
    }

    @Deprecated
    public static boolean isLoggable(int i) {
        return false;
    }

    @Deprecated
    public static void onEnvReady() {
    }

    @Deprecated
    public static void setLoggingDelegate(AbsLogDelegate absLogDelegate) {
    }

    public static void initLynxLog() {
        LynxLog.initLynxLog(LynxEnv.inst().isDevtoolEnabled());
    }

    public static void setDebugLoggingDelegate(AbsLogDelegate absLogDelegate) {
        BaseLogDelegate.inst().setDelegate(absLogDelegate);
        LynxLog.setDebugLoggingDelegate(BaseLogDelegate.inst());
    }

    public static void setMinimumLoggingLevel(int i) {
        LynxLog.setMinimumLoggingLevel(i);
    }

    public static int getMinimumLoggingLevel() {
        return LynxLog.getMinimumLoggingLevel();
    }

    public static void setJSLogsFromExternalChannels(boolean z) {
        LynxLog.setJSLogsFromExternalChannels(z);
    }

    public static void v(String str, String str2) {
        LynxLog.v(str, str2);
    }

    public static void d(String str, String str2) {
        LynxLog.d(str, str2);
    }

    public static void i(String str, String str2) {
        LynxLog.i(str, str2);
    }

    public static void w(String str, String str2) {
        LynxLog.w(str, str2);
    }

    public static void e(String str, String str2) {
        LynxLog.e(str, str2);
    }

    @Deprecated
    public static void report(String str, String str2) {
        LynxLog.e(str, str2);
    }

    public static void internalLog(int i, String str, String str2) {
        LynxLog.internalLog(i, str, str2);
    }

    public static void DCHECK(boolean z) {
        LynxLog.DCHECK(z);
    }

    public static void DTHROW() {
        DTHROW(null);
    }

    public static void DTHROW(RuntimeException runtimeException) {
        LynxLog.DTHROW(runtimeException);
    }

    @Deprecated
    public static synchronized void removeLoggingDelegate(int i) {
        synchronized (LLog.class) {
        }
    }
}
