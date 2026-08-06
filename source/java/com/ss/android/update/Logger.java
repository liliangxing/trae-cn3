package com.ss.android.update;

import android.util.Log;

/* loaded from: classes7.dex */
public class Logger {
    private static IUpdateLogger logger = new IUpdateLogger() { // from class: com.ss.android.update.Logger.1
        @Override // com.ss.android.update.IUpdateLogger
        public void v(String str, String str2) {
            Log.v(str, str2);
        }

        @Override // com.ss.android.update.IUpdateLogger
        public void d(String str, String str2) {
            Log.d(str, str2);
        }

        @Override // com.ss.android.update.IUpdateLogger
        public void i(String str, String str2) {
            Log.i(str, str2);
        }

        @Override // com.ss.android.update.IUpdateLogger
        public void w(String str, String str2) {
            Log.w(str, str2);
        }

        @Override // com.ss.android.update.IUpdateLogger
        public void w(String str, String str2, Throwable th) {
            Log.w(str, str2, th);
        }

        @Override // com.ss.android.update.IUpdateLogger
        public void w(String str, Throwable th) {
            Log.w(str, th);
        }

        @Override // com.ss.android.update.IUpdateLogger
        public void e(String str, String str2) {
            Log.e(str, str2);
        }

        @Override // com.ss.android.update.IUpdateLogger
        public void e(String str, String str2, Throwable th) {
            Log.e(str, str2, th);
        }
    };

    public static void setUpLogger(IUpdateLogger iUpdateLogger) {
        logger = iUpdateLogger;
    }

    public static void v(String str, String str2) {
        logger.v(str, str2);
    }

    public static void d(String str, String str2) {
        logger.d(str, str2);
    }

    public static void i(String str, String str2) {
        logger.i(str, str2);
    }

    public static void w(String str, String str2) {
        logger.w(str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        logger.w(str, str2, th);
    }

    public static void w(String str, Throwable th) {
        logger.w(str, th);
    }

    public static void e(String str, String str2) {
        logger.e(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        logger.e(str, str2, th);
    }
}
