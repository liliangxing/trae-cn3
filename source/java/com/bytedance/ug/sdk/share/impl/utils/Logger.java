package com.bytedance.ug.sdk.share.impl.utils;

import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import com.ss.android.update.UpdateDialogNewBase;

/* loaded from: classes4.dex */
public class Logger {
    private static final String TAG = "Logger";
    private static int mLevel = 4;
    private static AbsLogWritter sLogWriter = DefaultLogHandler.getInstance();

    public static void setLogLevel(int i) {
        mLevel = i;
    }

    public static int getLogLevel() {
        return mLevel;
    }

    public static boolean debug() {
        return mLevel <= 3;
    }

    public static void v(String str) {
        v(TAG, str);
    }

    public static void v(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (sLogWriter.isLoggable(2)) {
            sLogWriter.logV(str, str2);
        }
        ALog.v(str, str2);
    }

    public static void v(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (sLogWriter.isLoggable(2)) {
            sLogWriter.logV(str, str2, th);
        }
        ALog.v(str, str2);
    }

    public static void d(String str) {
        d(TAG, str);
    }

    public static void d(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (sLogWriter.isLoggable(3)) {
            sLogWriter.logD(str, str2);
        }
        ALog.d(str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (sLogWriter.isLoggable(3)) {
            sLogWriter.logD(str, str2, th);
        }
        ALog.d(str, str2);
    }

    public static void i(String str) {
        i(TAG, str);
    }

    public static void i(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (sLogWriter.isLoggable(4)) {
            sLogWriter.logI(str, str2);
        }
        ALog.i(str, str2);
    }

    public static void i(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (sLogWriter.isLoggable(4)) {
            sLogWriter.logI(str, str2, th);
        }
        ALog.i(str, str2);
    }

    public static void w(String str) {
        w(TAG, str);
    }

    public static void w(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (sLogWriter.isLoggable(5)) {
            sLogWriter.logW(str, str2);
        }
        ALog.w(str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (sLogWriter.isLoggable(5)) {
            sLogWriter.logW(str, str2, th);
        }
        ALog.w(str, str2);
    }

    public static void e(String str) {
        e(TAG, str);
    }

    public static void e(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (sLogWriter.isLoggable(6)) {
            sLogWriter.logE(str, str2);
        }
        ALog.e(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (sLogWriter.isLoggable(6)) {
            sLogWriter.logE(str, str2, th);
        }
        ALog.e(str, str2);
    }

    @Deprecated
    public static void k(String str) {
        k(TAG, str);
    }

    @Deprecated
    public static void k(String str, String str2) {
        if (sLogWriter.isLoggable(3)) {
            sLogWriter.logK(str, str2);
        }
    }

    public static void st(String str, int i) {
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 1; i2 < Math.min(i, stackTrace.length); i2++) {
                if (i2 > 1) {
                    sb.append(UpdateDialogNewBase.TYPE);
                }
                sb.append(getSimpleClassName(stackTrace[i2].getClassName()));
                sb.append(LibrarianImpl.Constants.DOT);
                sb.append(stackTrace[i2].getMethodName());
            }
            v(str, sb.toString());
        }
    }

    private static String getSimpleClassName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1);
    }

    public static void throwException(Throwable th) {
        if (th == null) {
            return;
        }
        th.printStackTrace();
        if (debug()) {
            throw new RuntimeException("Error! Now in debug, we alert to you to correct it !", th);
        }
    }

    public static void alertErrorInfo(String str) {
        if (debug()) {
            throw new IllegalStateException(str);
        }
    }

    public static void registerLogHandler(AbsLogWritter absLogWritter) {
        sLogWriter = absLogWritter;
    }

    /* loaded from: classes4.dex */
    public static abstract class AbsLogWritter {
        public void logD(String str, String str2) {
        }

        public void logD(String str, String str2, Throwable th) {
        }

        public void logE(String str, String str2) {
        }

        public void logE(String str, String str2, Throwable th) {
        }

        public void logI(String str, String str2) {
        }

        public void logI(String str, String str2, Throwable th) {
        }

        public void logK(String str, String str2) {
        }

        public void logV(String str, String str2) {
        }

        public void logV(String str, String str2, Throwable th) {
        }

        public void logW(String str, String str2) {
        }

        public void logW(String str, String str2, Throwable th) {
        }

        public boolean isLoggable(int i) {
            return Logger.getLogLevel() < i;
        }
    }

    /* loaded from: classes4.dex */
    private static class DefaultLogHandler extends AbsLogWritter {
        private DefaultLogHandler() {
        }

        static DefaultLogHandler getInstance() {
            return SingletonHolder.INSTANCE;
        }

        @Override // com.bytedance.ug.sdk.share.impl.utils.Logger.AbsLogWritter
        public void logV(String str, String str2) {
            Log.v(str, str2);
        }

        @Override // com.bytedance.ug.sdk.share.impl.utils.Logger.AbsLogWritter
        public void logV(String str, String str2, Throwable th) {
            Log.v(str, str2, th);
        }

        @Override // com.bytedance.ug.sdk.share.impl.utils.Logger.AbsLogWritter
        public void logD(String str, String str2) {
            Log.d(str, str2);
        }

        @Override // com.bytedance.ug.sdk.share.impl.utils.Logger.AbsLogWritter
        public void logD(String str, String str2, Throwable th) {
            Log.d(str, str2, th);
        }

        @Override // com.bytedance.ug.sdk.share.impl.utils.Logger.AbsLogWritter
        public void logI(String str, String str2) {
            Log.i(str, str2);
        }

        @Override // com.bytedance.ug.sdk.share.impl.utils.Logger.AbsLogWritter
        public void logI(String str, String str2, Throwable th) {
            Log.i(str, str2, th);
        }

        @Override // com.bytedance.ug.sdk.share.impl.utils.Logger.AbsLogWritter
        public void logE(String str, String str2, Throwable th) {
            Log.e(str, str2, th);
        }

        @Override // com.bytedance.ug.sdk.share.impl.utils.Logger.AbsLogWritter
        public void logE(String str, String str2) {
            Log.e(str, str2);
        }

        @Override // com.bytedance.ug.sdk.share.impl.utils.Logger.AbsLogWritter
        public void logW(String str, String str2) {
            Log.w(str, str2);
        }

        @Override // com.bytedance.ug.sdk.share.impl.utils.Logger.AbsLogWritter
        public void logW(String str, String str2, Throwable th) {
            Log.w(str, str2, th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static class SingletonHolder {
            private static final DefaultLogHandler INSTANCE = new DefaultLogHandler();

            private SingletonHolder() {
            }
        }
    }
}
