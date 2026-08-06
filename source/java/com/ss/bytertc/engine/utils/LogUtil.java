package com.ss.bytertc.engine.utils;

import android.content.Context;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* loaded from: classes7.dex */
public class LogUtil {
    private static final String DEBUG_LEVEL = "DEBUG";
    public static final String DIR_TAIL = "logs";
    private static final String ERROR_LEVEL = "ERROR";
    private static final String INFO_LEVEL = "INFO";
    private static final String LOG_TAG = "ByteRTC";
    private static final String WARN_LEVEL = "WARNING";
    private static AtomicReference<ILoggerSink> sLoggerSink = new AtomicReference<>();
    private static String sDeviceID = null;
    private static LogLevel sLogLevel = LogLevel.LOG_LEVEL_INFO;
    private static String sLogDir = null;

    /* loaded from: classes7.dex */
    public interface ILoggerSink {
        void onLoggerMessage(LogLevel level, String msg, Throwable throwable);
    }

    /* loaded from: classes7.dex */
    public enum LogLevel {
        LOG_LEVEL_TRACE,
        LOG_LEVEL_DEBUG,
        LOG_LEVEL_INFO,
        LOG_LEVEL_WARNING,
        LOG_LEVEL_ERROR
    }

    public static void setDebug(boolean debug) {
    }

    public static void setLoggerSink(ILoggerSink sink) {
        if (sink != null) {
            sLoggerSink.set(sink);
        } else {
            UByte$$ExternalSyntheticBackport0.m((AtomicReference) sLoggerSink, (Object) getLoggerSink(), (Object) null);
        }
    }

    private static ILoggerSink getLoggerSink() {
        return sLoggerSink.get();
    }

    private static void notifyLoggerSinks(LogLevel level, String msg, Throwable throwable) {
        ILoggerSink loggerSink;
        if (sLoggerSink == null || (loggerSink = getLoggerSink()) == null) {
            return;
        }
        loggerSink.onLoggerMessage(level, msg, throwable);
    }

    public static void d(String tag, String message) {
        if (LogLevel.LOG_LEVEL_DEBUG.compareTo(sLogLevel) >= 0) {
            notifyLoggerSinks(LogLevel.LOG_LEVEL_DEBUG, String.format("[%s:%s]:%s", LOG_TAG, tag, String.format("[msg:%s]", message)), null);
        }
    }

    public static void i(String tag, String message) {
        if (LogLevel.LOG_LEVEL_INFO.compareTo(sLogLevel) >= 0) {
            notifyLoggerSinks(LogLevel.LOG_LEVEL_INFO, String.format("[%s:%s]:%s", LOG_TAG, tag, String.format("[msg:%s]", message)), null);
        }
    }

    public static void w(String tag, String message) {
        if (LogLevel.LOG_LEVEL_WARNING.compareTo(sLogLevel) >= 0) {
            notifyLoggerSinks(LogLevel.LOG_LEVEL_WARNING, String.format("[%s:%s]:%s", LOG_TAG, tag, String.format("[msg:%s]", message)), null);
        }
    }

    public static void w(String tag, String message, Throwable exception) {
        if (LogLevel.LOG_LEVEL_WARNING.compareTo(sLogLevel) >= 0) {
            notifyLoggerSinks(LogLevel.LOG_LEVEL_WARNING, String.format("[%s:%s]:%s", LOG_TAG, tag, String.format("[msg:%s]", message)), exception);
        }
    }

    public static void e(String tag, String message) {
        if (LogLevel.LOG_LEVEL_ERROR.compareTo(sLogLevel) >= 0) {
            notifyLoggerSinks(LogLevel.LOG_LEVEL_ERROR, String.format("[%s:%s]:%s", LOG_TAG, tag, String.format("[msg:%s]", message)), null);
        }
    }

    public static void e(String tag, String message, Throwable exception) {
        if (LogLevel.LOG_LEVEL_ERROR.compareTo(sLogLevel) >= 0) {
            notifyLoggerSinks(LogLevel.LOG_LEVEL_ERROR, String.format("[%s:%s]:%s", LOG_TAG, tag, String.format("[msg:%s]", message)), exception);
        }
    }

    public static LogLevel getLogLevel() {
        return sLogLevel;
    }

    public static void setLogLevel(LogLevel logLevel) {
        sLogLevel = logLevel;
    }

    public static String getLogDir(Context context) {
        String str = sLogDir;
        if (str != null) {
            return str;
        }
        String str2 = context.getExternalFilesDir(null) + File.separator + "RTCEngine" + File.separator + "Log" + File.separator + "logs";
        sLogDir = str2;
        return str2;
    }

    public static void setLogDir(String logDir) {
        sLogDir = logDir + File.separator + "logs";
    }

    public static void setDeviceID(String deviceID) {
        sDeviceID = deviceID;
    }

    public static String getDeviceID() {
        return sDeviceID;
    }
}
