package com.bytedance.crash.util;

/* loaded from: classes3.dex */
public final class LogcatUtils {
    private static LogcatImpl sLogcat;

    /* loaded from: classes3.dex */
    public static abstract class LogcatImpl {
        abstract String dumpLogcat();

        abstract void dumpLogcat(String str);
    }

    public static void dumpLogcat(String str) {
        LogcatImpl logcatImpl = sLogcat;
        if (logcatImpl != null) {
            logcatImpl.dumpLogcat(str);
        }
    }

    public static void setLogcatImpl(LogcatImpl logcatImpl) {
        sLogcat = logcatImpl;
    }
}
