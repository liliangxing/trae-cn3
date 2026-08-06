package com.bytedance.apm6.util.log;

import android.util.Log;
import com.bytedance.apm6.util.ApmBaseContext;

/* loaded from: classes3.dex */
public class Logger {
    private static ILogger sApmLogImp = new DefaultLogger();

    /* loaded from: classes3.dex */
    public static class DefaultLogger implements ILogger {
        @Override // com.bytedance.apm6.util.log.ILogger
        public void v(String str, String str2) {
            if (ApmBaseContext.isDebugMode()) {
                Log.v(str, str2);
            }
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void d(String str, String str2) {
            if (ApmBaseContext.isDebugMode()) {
                Log.d(str, str2);
            }
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void i(String str, String str2) {
            if (ApmBaseContext.isDebugMode()) {
                Log.i(str, str2);
            }
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void w(String str, String str2) {
            if (ApmBaseContext.isDebugMode()) {
                Log.w(str, str2);
            }
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void w(String str, String str2, Throwable th) {
            if (ApmBaseContext.isDebugMode()) {
                Log.w(str, str2, th);
            }
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void e(String str, String str2) {
            if (ApmBaseContext.isDebugMode()) {
                Log.e(str, str2);
            }
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void e(String str, String str2, Throwable th) {
            if (ApmBaseContext.isDebugMode()) {
                Log.e(str, str2, th);
            }
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void wtf(String str, String str2) {
            if (ApmBaseContext.isDebugMode()) {
                Log.wtf(str, str2);
            }
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void wtf(String str, String str2, Throwable th) {
            if (ApmBaseContext.isDebugMode()) {
                Log.e(str, str2, th);
            }
        }
    }

    private Logger() {
    }

    public static void setLoggerImpl(ILogger iLogger) {
        sApmLogImp = iLogger;
    }

    public static void v(String str, String str2) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.v(str, str2);
        }
    }

    public static void d(String str, String str2) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.w(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.w(str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.e(str, str2, th);
        }
    }

    public static void wtf(String str, String str2) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.e(str, str2);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.e(str, str2, th);
        }
    }
}
