package com.ss.bduploader;

import android.util.Log;

/* loaded from: classes7.dex */
public class BDUploadLog {
    public static final String FORMAT = "<%s>%s";
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_PRINT_BOTH = 3;
    public static final int LOG_PRINT_CALL_BACK = 2;
    public static final int LOG_PRINT_LOCAL = 1;
    public static final int LOG_PRINT_NONE = 0;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    public static int LogTurnOn = 112;
    private static final String TAG = "BDUploadLog";
    private static ALogCallback sALogCallback;

    /* loaded from: classes7.dex */
    public interface ALogCallback {
        void onLogPrint(int i, String str, String str2);
    }

    private static native void _setLogPrintType(int i);

    public static final void turnOn(int i, int i2) {
        LogTurnOn = (i2 << i) | ((~(1 << i)) & LogTurnOn);
    }

    public static final void i(String str, String str2) {
        if (((LogTurnOn >> 2) & 1) == 1) {
            Log.i(TAG, String.format("<%s>%s", str, str2));
        }
    }

    public static final void d(String str, String str2) {
        if (((LogTurnOn >> 1) & 1) == 1) {
            Log.d(TAG, String.format("<%s>%s", str, str2));
        }
    }

    public static final void w(String str, String str2) {
        if (((LogTurnOn >> 5) & 1) == 1) {
            Log.w(TAG, String.format("<%s>%s", str, str2));
        }
    }

    public static final void t(String str, String str2) {
        if (((LogTurnOn >> 3) & 1) == 1) {
            Log.i(TAG, String.format("<%s>%s", str, str2));
        }
    }

    public static final void k(String str, String str2) {
        if (((LogTurnOn >> 4) & 1) == 1) {
            Log.i(TAG, String.format("<%s>%s", str, str2));
        }
    }

    public static void e(String str, String str2) {
        if (((LogTurnOn >> 6) & 1) == 1) {
            Log.e(TAG, String.format("<%s>%s", str, str2));
        }
    }

    public static void setLogPrintType(int i) {
        BDUploadUtil.initInternal(new StringBuffer());
        _setLogPrintType(i);
    }

    public static void setALogCallback(ALogCallback aLogCallback) {
        sALogCallback = aLogCallback;
    }

    private static void onALogCallback(int i, String str, String str2) {
        ALogCallback aLogCallback = sALogCallback;
        if (aLogCallback != null) {
            aLogCallback.onLogPrint(i, str, str2);
        }
    }
}
