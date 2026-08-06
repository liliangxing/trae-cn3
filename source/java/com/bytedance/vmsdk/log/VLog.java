package com.bytedance.vmsdk.log;

import android.os.Build;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes6.dex */
public class VLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final String TAG = "VLog";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static long alogNativePtr = 0;
    private static final int sDefaultLogLevel = 6;
    private static final int sDetectALogDependencyInterval = 500;
    private static final int sMaxTryCounts = 120;
    private static int[] sNativeLevelMap = null;
    private static int sNativeMinLogLevel = 6;
    private static int sTryCounts;

    private static native void nativeInitALogNative(long j, boolean z);

    private static native void nativeInternalLog(int i, String str, String str2);

    private static native void nativeSetNativeMinLogLevel(int i);

    static /* synthetic */ boolean access$000() {
        return detectALogDependence();
    }

    public static void setMinimumLoggingLevel(int i) {
        try {
            initNativeLogLevelMap();
            nativeSetNativeMinLogLevel(sNativeLevelMap[i]);
            if (sNativeMinLogLevel != i) {
                sNativeMinLogLevel = i;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Log.e("vmsdk", "Please check index, " + e.getMessage());
            sNativeMinLogLevel = 6;
            nativeSetNativeMinLogLevel(sNativeLevelMap[6]);
        }
    }

    public static void onEnvReady() {
        setMinimumLoggingLevel(4);
    }

    public static void v(String str, String str2) {
        internalLog(2, str, str2);
    }

    public static void d(String str, String str2) {
        internalLog(3, str, str2);
    }

    public static void i(String str, String str2) {
        internalLog(4, str, str2);
    }

    public static void w(String str, String str2) {
        internalLog(5, str, str2);
    }

    public static void e(String str, String str2) {
        internalLog(6, str, str2);
    }

    public static void internalLog(int i, String str, String str2) {
        try {
            nativeInternalLog(i, str, str2);
        } catch (Throwable th) {
            Log.e(TAG, th.getMessage());
        }
    }

    private static void initNativeLogLevelMap() {
        if (sNativeLevelMap == null) {
            sNativeLevelMap = r0;
            int[] iArr = {0, 0, -1, 0, 0, 1, 2, 3};
        }
    }

    private static void loadALogDependency() {
        if (detectALogDependence()) {
            return;
        }
        new Timer().schedule(new TimerTask() { // from class: com.bytedance.vmsdk.log.VLog.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (VLog.access$000()) {
                    cancel();
                }
            }
        }, 0L, 500L);
    }

    private static boolean detectALogDependence() {
        long aLogNativeAddress = ALogReflect.getALogNativeAddress();
        if (aLogNativeAddress != 0) {
            initALog(aLogNativeAddress);
            Log.i(TAG, "ALog dependency load successfully");
            return true;
        }
        int i = sTryCounts + 1;
        sTryCounts = i;
        if (i != 120) {
            return false;
        }
        Log.e(TAG, "Get ALog dependency failed");
        return true;
    }

    public static void initALog(long j) {
        boolean z = Build.VERSION.SDK_INT > 24;
        alogNativePtr = j;
        nativeInitALogNative(j, z);
    }

    public static void init() {
        try {
            onEnvReady();
            long aLogNativeAddress = ALogReflect.getALogNativeAddress();
            if (aLogNativeAddress != 0) {
                initALog(aLogNativeAddress);
            }
        } catch (Throwable unused) {
            Log.e(TAG, "vmsdk alog init fail");
        }
    }

    private static long getALogPtr() {
        return alogNativePtr;
    }

    private static void initALogLazy() {
        loadALogDependency();
    }
}
