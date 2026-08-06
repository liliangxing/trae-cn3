package com.lynx.base.log;

import android.util.Log;
import com.lynx.base.LynxBaseEnv;
import com.lynx.tasm.service.ILynxLogService;
import com.lynx.tasm.service.LynxServiceCenter;

/* loaded from: classes6.dex */
public class LynxLog {
    public static final int DEBUG = 1;
    public static final int ERROR = 4;
    public static final int INFO = 2;
    private static final String TAG = "LynxLog";
    public static final int VERBOSE = 0;
    public static final int WARN = 3;
    private static int sALogMinLogLevel = 2;
    private static AbsBaseLogDelegate sDebugLoggingDelegate;
    private static boolean sIsJSLogsFromExternalChannelsOpen;
    private static boolean sIsNativeLibLoad;
    private static ILynxLogService service;

    public static void DCHECK(boolean z) {
    }

    public static void DTHROW(RuntimeException runtimeException) {
    }

    private static native void nativeInitALogNative(long j);

    private static native void nativeInitLynxLoggingNative(boolean z);

    private static native void nativeInternalLog(int i, String str, String str2);

    private static native void nativeSetLogOutputByPlatform();

    private static native void nativeSetNativeMinLogLevel(int i);

    public static void initLynxLog(boolean z) {
        try {
            if (!sIsNativeLibLoad) {
                sIsNativeLibLoad = LynxBaseEnv.inst().isNativeLibraryLoaded();
            }
            if (sIsNativeLibLoad) {
                initLynxLogging(z);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Log.e("lynx", "init LynxLogging exception [ " + e.getMessage() + " ]");
        }
    }

    private static void initLynxLogging(boolean z) {
        nativeInitLynxLoggingNative(z);
        detectALogDependence();
        setLogOutputChannel();
    }

    public static void setDebugLoggingDelegate(AbsBaseLogDelegate absBaseLogDelegate) {
        sDebugLoggingDelegate = absBaseLogDelegate;
    }

    public static void setMinimumLoggingLevel(int i) {
        try {
            if (!sIsNativeLibLoad) {
                sIsNativeLibLoad = LynxBaseEnv.inst().isNativeLibraryLoaded();
            }
            if (sIsNativeLibLoad) {
                String[] strArr = {"VERBOSE", "DEBUG", "INFO", "WARN", "ERROR"};
                int i2 = sALogMinLogLevel;
                if (i2 < i) {
                    sALogMinLogLevel = i;
                    nativeSetNativeMinLogLevel(i);
                    Log.w("lynx", String.format("Reset minimum log level as %s", strArr[sALogMinLogLevel]));
                    return;
                }
                Log.w("lynx", String.format("Please set a log level higher than %s to filter lynx logs!", strArr[i2]));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Log.e("lynx", "Please check index, " + e.getMessage());
        }
    }

    public static int getMinimumLoggingLevel() {
        return sALogMinLogLevel;
    }

    public static void setJSLogsFromExternalChannels(boolean z) {
        sIsJSLogsFromExternalChannelsOpen = z;
    }

    public static void v(String str, String str2) {
        internalLog(0, str, str2);
    }

    public static void d(String str, String str2) {
        internalLog(1, str, str2);
    }

    public static void i(String str, String str2) {
        internalLog(2, str, str2);
    }

    public static void w(String str, String str2) {
        internalLog(3, str, str2);
    }

    public static void e(String str, String str2) {
        internalLog(4, str, str2);
    }

    private static void logByAndroidUtil(int i, String str, String str2) {
        if (i == 0) {
            Log.v(str, str2);
            return;
        }
        if (i == 1) {
            Log.d(str, str2);
            return;
        }
        if (i == 2) {
            Log.i(str, str2);
        } else if (i == 3) {
            Log.w(str, str2);
        } else {
            if (i != 4) {
                return;
            }
            Log.e(str, str2);
        }
    }

    private static void logByDebugLoggingDelegate(int i, String str, String str2) {
        AbsBaseLogDelegate absBaseLogDelegate = sDebugLoggingDelegate;
        if (absBaseLogDelegate == null) {
            return;
        }
        if (i == 0) {
            absBaseLogDelegate.v(str, str2);
            return;
        }
        if (i == 1) {
            absBaseLogDelegate.d(str, str2);
            return;
        }
        if (i == 2) {
            absBaseLogDelegate.i(str, str2);
        } else if (i == 3) {
            absBaseLogDelegate.w(str, str2);
        } else {
            if (i != 4) {
                return;
            }
            absBaseLogDelegate.e(str, str2);
        }
    }

    public static void internalLog(int i, String str, String str2) {
        if (str2 == null || str == null) {
            return;
        }
        logByDebugLoggingDelegate(i, str, str2);
        try {
            if (!sIsNativeLibLoad) {
                boolean isNativeLibraryLoaded = LynxBaseEnv.inst().isNativeLibraryLoaded();
                sIsNativeLibLoad = isNativeLibraryLoaded;
                if (!isNativeLibraryLoaded) {
                    logByAndroidUtil(i, str, str2);
                    return;
                }
            }
            if (i >= sALogMinLogLevel) {
                ILynxLogService iLynxLogService = service;
                if (iLynxLogService != null && iLynxLogService.isLogOutputByPlatform()) {
                    service.logByPlatform(i, str, str2);
                } else {
                    nativeInternalLog(i, str, str2);
                }
            }
        } catch (UnsatisfiedLinkError e) {
            Log.e("lynx", "load liblynxbase.so exception [ " + e.getMessage() + " ]");
        }
    }

    public static void DTHROW() {
        DTHROW(null);
    }

    private static void detectALogDependence() {
        ILynxLogService iLynxLogService = (ILynxLogService) LynxServiceCenter.inst().getService(ILynxLogService.class);
        service = iLynxLogService;
        long defaultWriteFunction = iLynxLogService != null ? iLynxLogService.getDefaultWriteFunction() : 0L;
        if (defaultWriteFunction != 0) {
            nativeInitALogNative(defaultWriteFunction);
            Log.i(TAG, "LynxLog dependency load successfully. function native address is " + defaultWriteFunction);
        } else {
            Log.i(TAG, "failed to load LynxLog dependency");
        }
    }

    private static void setLogOutputChannel() {
        ILynxLogService iLynxLogService = service;
        if (iLynxLogService == null || !iLynxLogService.isLogOutputByPlatform()) {
            return;
        }
        nativeSetLogOutputByPlatform();
    }

    private static void log(int i, String str, String str2, int i2, long j, int i3, int i4) {
        if (i > 4) {
            i = 4;
        }
        try {
            ILynxLogService iLynxLogService = service;
            if (iLynxLogService != null && iLynxLogService.isLogOutputByPlatform()) {
                service.logByPlatform(i, str, str2);
            }
            logByDebugLoggingDelegate(i, str, str2);
        } catch (Throwable th) {
            Log.e("lynx", "" + th.getMessage());
        }
    }

    private static void logByte(int i, String str, byte[] bArr, int i2, long j, int i3, int i4) {
        log(i, str, new String(bArr), i2, j, i3, i4);
    }
}
