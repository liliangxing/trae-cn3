package com.bytedance.reparo.core;

import android.util.Log;

/* loaded from: classes4.dex */
public class PatchLogger {
    private static final ILogger DEFAULT;
    private static final String TAG_PREFIX = "reparo-core/";
    private static ILogger logger;

    /* loaded from: classes4.dex */
    public interface ILogger {
        void d(String str, String str2);

        void e(String str, String str2);

        void e(String str, String str2, Throwable th);

        void i(String str, String str2);

        void logForCollideMethod(String str, String str2);

        void logForSymbolNotFound(String str);

        void w(String str, String str2);

        void w(String str, String str2, Throwable th);
    }

    static {
        ILogger iLogger = new ILogger() { // from class: com.bytedance.reparo.core.PatchLogger.1
            @Override // com.bytedance.reparo.core.PatchLogger.ILogger
            public void d(String str, String str2) {
                Log.d(str, str2);
            }

            @Override // com.bytedance.reparo.core.PatchLogger.ILogger
            public void i(String str, String str2) {
                Log.i(str, str2);
            }

            @Override // com.bytedance.reparo.core.PatchLogger.ILogger
            public void w(String str, String str2) {
                Log.e(str, str2);
            }

            @Override // com.bytedance.reparo.core.PatchLogger.ILogger
            public void w(String str, String str2, Throwable th) {
                Log.w(str, str2, th);
            }

            @Override // com.bytedance.reparo.core.PatchLogger.ILogger
            public void e(String str, String str2) {
                Log.e(str, str2);
            }

            @Override // com.bytedance.reparo.core.PatchLogger.ILogger
            public void e(String str, String str2, Throwable th) {
                Log.e(str, str2, th);
            }

            @Override // com.bytedance.reparo.core.PatchLogger.ILogger
            public void logForCollideMethod(String str, String str2) {
                Log.e(PatchLogger.TAG_PREFIX, "check for collide method " + str2);
            }

            @Override // com.bytedance.reparo.core.PatchLogger.ILogger
            public void logForSymbolNotFound(String str) {
                Log.e(PatchLogger.TAG_PREFIX, "logForSymbolNotFound " + str);
            }
        };
        DEFAULT = iLogger;
        logger = iLogger;
    }

    public static void setLogger(ILogger iLogger) {
        logger = iLogger;
    }

    public static ILogger getLogger() {
        return logger;
    }

    public static void d(String str, String str2) {
        logger.d(TAG_PREFIX + str, str2);
    }

    public static void i(String str, String str2) {
        logger.i(TAG_PREFIX + str, str2);
    }

    public static void w(String str, String str2) {
        logger.w(TAG_PREFIX + str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        logger.w(TAG_PREFIX + str, str2, th);
    }

    public static void e(String str, String str2) {
        logger.e(TAG_PREFIX + str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        logger.e(TAG_PREFIX + str, str2, th);
    }

    public static void logForCollideMethod(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str2 == null) {
                return;
            }
            logger.logForCollideMethod(str, str2);
        }
    }

    public static void logForSymbolNotFound(String[] strArr) {
        for (String str : strArr) {
            if (str == null) {
                return;
            }
            logger.logForSymbolNotFound(str);
        }
    }
}
