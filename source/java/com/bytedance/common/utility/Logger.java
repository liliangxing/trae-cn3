package com.bytedance.common.utility;

import android.util.Log;
import com.bytedance.android.standard.tools.logging.Logger;

@Deprecated
/* loaded from: classes3.dex */
public class Logger {
    private static final String TAG = "Logger";
    private static int mLevel = 4;
    private static ILogWritter sLogWriter = DefaultLogHandler.getInstance();

    public static void setLogLevel(int i) {
        com.bytedance.android.standard.tools.logging.Logger.setLogLevel(i);
    }

    public static int getLogLevel() {
        return com.bytedance.android.standard.tools.logging.Logger.getLogLevel();
    }

    public static boolean debug() {
        return com.bytedance.android.standard.tools.logging.Logger.debug();
    }

    public static void v(String str) {
        com.bytedance.android.standard.tools.logging.Logger.v(str);
    }

    public static void v(String str, String str2) {
        com.bytedance.android.standard.tools.logging.Logger.v(str, str2);
    }

    public static void v(String str, String str2, Throwable th) {
        com.bytedance.android.standard.tools.logging.Logger.v(str, str2, th);
    }

    public static void d(String str) {
        com.bytedance.android.standard.tools.logging.Logger.d(str);
    }

    public static void d(String str, String str2) {
        com.bytedance.android.standard.tools.logging.Logger.d(str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        com.bytedance.android.standard.tools.logging.Logger.d(str, str2, th);
    }

    public static void i(String str) {
        com.bytedance.android.standard.tools.logging.Logger.i(str);
    }

    public static void i(String str, String str2) {
        com.bytedance.android.standard.tools.logging.Logger.i(str, str2);
    }

    public static void i(String str, String str2, Throwable th) {
        com.bytedance.android.standard.tools.logging.Logger.i(str, str2, th);
    }

    public static void w(String str) {
        com.bytedance.android.standard.tools.logging.Logger.w(str);
    }

    public static void w(String str, String str2) {
        com.bytedance.android.standard.tools.logging.Logger.w(str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        com.bytedance.android.standard.tools.logging.Logger.w(str, str2, th);
    }

    public static void e(String str) {
        com.bytedance.android.standard.tools.logging.Logger.e(str);
    }

    public static void e(String str, String str2) {
        com.bytedance.android.standard.tools.logging.Logger.e(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        com.bytedance.android.standard.tools.logging.Logger.e(str, str2, th);
    }

    @Deprecated
    public static void k(String str) {
        com.bytedance.android.standard.tools.logging.Logger.k(str);
    }

    @Deprecated
    public static void k(String str, String str2) {
        com.bytedance.android.standard.tools.logging.Logger.k(str, str2);
    }

    public static void st(String str, int i) {
        com.bytedance.android.standard.tools.logging.Logger.st(str, i);
    }

    private static String getSimpleClassName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1);
    }

    public static void throwException(Throwable th) {
        com.bytedance.android.standard.tools.logging.Logger.throwException(th);
    }

    public static void alertErrorInfo(String str) {
        com.bytedance.android.standard.tools.logging.Logger.alertErrorInfo(str);
    }

    public static void registerLogHandler(ILogWritter iLogWritter) {
        com.bytedance.android.standard.tools.logging.Logger.registerLogHandler(iLogWritter);
    }

    /* loaded from: classes3.dex */
    public static abstract class ILogWritter extends Logger.ILogWritter {
        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logD(String str, String str2) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logD(String str, String str2, Throwable th) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logE(String str, String str2) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logE(String str, String str2, Throwable th) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logI(String str, String str2) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logI(String str, String str2, Throwable th) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logK(String str, String str2) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logV(String str, String str2) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logV(String str, String str2, Throwable th) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logW(String str, String str2) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logW(String str, String str2, Throwable th) {
        }

        @Override // com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public boolean isLoggable(int i) {
            return Logger.getLogLevel() <= i;
        }
    }

    /* loaded from: classes3.dex */
    private static final class DefaultLogHandler extends ILogWritter {
        private DefaultLogHandler() {
        }

        static DefaultLogHandler getInstance() {
            return SingletonHolder.INSTANCE;
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logV(String str, String str2) {
            Log.v(str, str2);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logV(String str, String str2, Throwable th) {
            Log.v(str, str2, th);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logD(String str, String str2) {
            Log.d(str, str2);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logD(String str, String str2, Throwable th) {
            Log.d(str, str2, th);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logI(String str, String str2) {
            Log.i(str, str2);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logI(String str, String str2, Throwable th) {
            Log.i(str, str2, th);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logE(String str, String str2, Throwable th) {
            Log.e(str, str2, th);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logE(String str, String str2) {
            Log.e(str, str2);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logW(String str, String str2) {
            Log.w(str, str2);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter, com.bytedance.android.standard.tools.logging.Logger.ILogWritter
        public void logW(String str, String str2, Throwable th) {
            Log.w(str, str2, th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static class SingletonHolder {
            private static final DefaultLogHandler INSTANCE = new DefaultLogHandler();

            private SingletonHolder() {
            }
        }
    }
}
