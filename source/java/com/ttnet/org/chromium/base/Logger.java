package com.ttnet.org.chromium.base;

import com.bytedance.librarian.LibrarianImpl;
import com.ss.android.update.UpdateDialogNewBase;

/* loaded from: classes7.dex */
public class Logger {
    private static final String TAG = "Logger";
    static int mLevel = 4;

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
        if (str2 != null && mLevel <= 2) {
            android.util.Log.v(str, str2);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (!(str2 == null && th == null) && mLevel <= 2) {
            android.util.Log.v(str, str2, th);
        }
    }

    public static void d(String str) {
        d(TAG, str);
    }

    public static void d(String str, String str2) {
        if (str2 != null && mLevel <= 3) {
            android.util.Log.d(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (!(str2 == null && th == null) && mLevel <= 3) {
            android.util.Log.d(str, str2, th);
        }
    }

    public static void i(String str) {
        i(TAG, str);
    }

    public static void i(String str, String str2) {
        if (str2 != null && mLevel <= 4) {
            android.util.Log.i(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (!(str2 == null && th == null) && mLevel <= 4) {
            android.util.Log.i(str, str2, th);
        }
    }

    public static void w(String str) {
        w(TAG, str);
    }

    public static void w(String str, String str2) {
        if (str2 != null && mLevel <= 5) {
            android.util.Log.w(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (!(str2 == null && th == null) && mLevel <= 5) {
            android.util.Log.w(str, str2, th);
        }
    }

    public static void e(String str) {
        e(TAG, str);
    }

    public static void e(String str, String str2) {
        if (str2 != null && mLevel <= 6) {
            android.util.Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (!(str2 == null && th == null) && mLevel <= 6) {
            android.util.Log.e(str, str2, th);
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
}
