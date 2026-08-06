package com.bytedance.realx.base;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes4.dex */
public class RXLogging {
    private static Severity loggableSeverity = null;
    private static volatile boolean loggingEnabled = true;

    /* loaded from: classes4.dex */
    public enum Severity {
        LS_DEBUG,
        LS_TRACE,
        LS_INFO,
        LS_WARNING,
        LS_ERROR,
        LS_NONE
    }

    private static native void nativeEnableLogThreads();

    private static native void nativeEnableLogTimeStamps();

    private static native void nativeEnableLogToDebugOutput(int severity);

    private static native void nativeLog(int severity, String tag, String message);

    @Deprecated
    /* loaded from: classes4.dex */
    public enum TraceLevel {
        TRACE_NONE(0),
        TRACE_STATEINFO(1),
        TRACE_WARNING(2),
        TRACE_ERROR(4),
        TRACE_CRITICAL(8),
        TRACE_APICALL(16),
        TRACE_DEFAULT(255),
        TRACE_MODULECALL(32),
        TRACE_MEMORY(256),
        TRACE_TIMER(512),
        TRACE_STREAM(1024),
        TRACE_DEBUG(2048),
        TRACE_INFO(4096),
        TRACE_TERSEINFO(8192),
        TRACE_ALL(65535);

        public final int level;

        TraceLevel(int level) {
            this.level = level;
        }
    }

    public static void enableLogThreads() {
        nativeEnableLogThreads();
    }

    public static void enableLogTimeStamps() {
        nativeEnableLogTimeStamps();
    }

    public static synchronized void enableLogToDebugOutput(Severity severity) {
        synchronized (RXLogging.class) {
            nativeEnableLogToDebugOutput(severity.ordinal());
            loggingEnabled = true;
        }
    }

    public static void log(Severity severity, String tag, String message) {
        if (tag == null || message == null) {
            throw new IllegalArgumentException("Logging tag or message may not be null.");
        }
        if (loggingEnabled) {
            nativeLog(severity.ordinal(), tag, message);
        }
    }

    public static void d(String tag, String message) {
        log(Severity.LS_DEBUG, tag, message);
    }

    public static void i(String tag, String message) {
        log(Severity.LS_INFO, tag, message);
    }

    public static void e(String tag, String message) {
        log(Severity.LS_ERROR, tag, message);
    }

    public static void w(String tag, String message) {
        log(Severity.LS_WARNING, tag, message);
    }

    public static void e(String tag, String message, Throwable e) {
        log(Severity.LS_ERROR, tag, message);
        log(Severity.LS_ERROR, tag, e.toString());
        log(Severity.LS_ERROR, tag, getStackTraceString(e));
    }

    public static void w(String tag, String message, Throwable e) {
        log(Severity.LS_WARNING, tag, message);
        log(Severity.LS_WARNING, tag, e.toString());
        log(Severity.LS_WARNING, tag, getStackTraceString(e));
    }

    public static void t(String tag, String message) {
        log(Severity.LS_TRACE, tag, message);
    }

    private static String getStackTraceString(Throwable e) {
        if (e == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
