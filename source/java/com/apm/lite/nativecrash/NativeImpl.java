package com.apm.lite.nativecrash;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.apm.lite.k.o;
import com.apm.lite.k.u;
import com.apm.lite.k.x;
import java.io.File;

/* loaded from: classes2.dex */
public class NativeImpl {
    private static boolean sResendSigQuit = true;
    private static volatile boolean soLoaded;
    private static volatile boolean soLoadedSuccess;

    public static void closeFile(int i) {
        if (soLoadedSuccess) {
            try {
                doCloseFile(i);
            } catch (Throwable unused) {
            }
        }
    }

    public static int createCallbackThread() {
        if (soLoadedSuccess) {
            return doCreateCallbackThread();
        }
        return -1;
    }

    private static native boolean doCheckNativeCrash();

    private static native void doCloseFile(int i);

    private static native int doCreateCallbackThread();

    private static native void doDump(String str);

    public static void doDumpAllThread(String str) {
        if (soLoadedSuccess) {
            doDump(str);
        }
    }

    private static native void doDumpFds(String str);

    private static native void doDumpHprof(String str);

    private static native void doDumpLogcat(String str, String str2, String str3);

    private static native void doDumpMaps(String str);

    private static native void doDumpMemInfo(String str);

    private static native void doDumpThreads(String str);

    private static native long doGetAppCpuTime();

    private static native long doGetChildCpuTime();

    private static native String doGetCrashHeader(String str);

    private static native long doGetDeviceCpuTime();

    private static native int doGetFDCount();

    private static native String[] doGetFdDump(int i, int i2, int[] iArr, String[] strArr);

    private static native long doGetFreeMemory();

    private static native long doGetThreadCpuTime(int i);

    private static native int doGetThreadsCount();

    private static native long doGetTotalMemory();

    private static native long doGetVMSize();

    private static native void doInitThreadDump();

    public static int doLock(String str) {
        if (soLoadedSuccess && !TextUtils.isEmpty(str)) {
            try {
                return doLock(str, -1);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    private static native int doLock(String str, int i);

    private static native int doOpenFile(String str);

    private static native void doRebuildTombstone(String str, String str2, String str3);

    private static native void doSetAlogConfigPath(String str);

    private static native void doSetAlogFlushAddr(long j);

    private static native void doSetAlogLogDirAddr(long j);

    private static native void doSetResendSigQuit(int i);

    private static native void doSetUploadEnd();

    private static native void doSignalMainThread();

    private static native int doStart(int i, String str, String str2, String str3, int i2);

    private static native void doStartAnrMonitor(int i);

    private static native void doWriteFile(int i, String str, int i2);

    public static void dumpFds(String str) {
        if (soLoadedSuccess) {
            try {
                doDumpFds(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void dumpHprof(String str) {
        if (soLoadedSuccess) {
            doDumpHprof(str);
        }
    }

    public static void dumpLogcat(String str, String str2, String str3) {
        if (soLoadedSuccess) {
            try {
                doDumpLogcat(str, str2, str3);
            } catch (Throwable unused) {
            }
        }
    }

    public static void dumpMaps(String str) {
        if (soLoadedSuccess) {
            try {
                doDumpMaps(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void dumpMemInfo(String str) {
        if (soLoadedSuccess) {
            try {
                doDumpMemInfo(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void dumpThreads(String str) {
        if (soLoadedSuccess) {
            try {
                doDumpThreads(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean duringNativeCrash() {
        if (!soLoadedSuccess) {
            return false;
        }
        try {
            return doCheckNativeCrash();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static long getAppCpuTime() {
        if (soLoadedSuccess) {
            return doGetAppCpuTime();
        }
        return 0L;
    }

    public static long getChildCpuTime() {
        if (soLoadedSuccess) {
            return doGetChildCpuTime();
        }
        return 0L;
    }

    public static long getDeviceCpuTime() {
        if (soLoadedSuccess) {
            return doGetDeviceCpuTime();
        }
        return 0L;
    }

    public static int getFDCount() {
        if (soLoadedSuccess) {
            return doGetFDCount();
        }
        return 0;
    }

    public static String[] getFd(int i, int[] iArr, String[] strArr) {
        if (!soLoadedSuccess || iArr == null || strArr == null) {
            return null;
        }
        String[] strArr2 = new String[100];
        int[] iArr2 = new int[100];
        for (int i2 = 0; i2 < iArr.length; i2 += 100) {
            int length = iArr.length - i2 > 100 ? 100 : iArr.length - i2;
            for (int i3 = 0; i3 < length; i3++) {
                iArr2[i3] = iArr[i3 + i2];
            }
            doGetFdDump(i, length, iArr2, strArr2);
            for (int i4 = 0; i4 < length; i4++) {
                strArr[i4 + i2] = strArr2[i4];
            }
        }
        return strArr;
    }

    public static long getFreeMemory() {
        if (soLoadedSuccess) {
            return doGetFreeMemory();
        }
        return 0L;
    }

    public static String getNativeCrashHeader(String str) {
        if (soLoadedSuccess) {
            return doGetCrashHeader(str);
        }
        return null;
    }

    public static long getThreadCpuTime(int i) {
        if (soLoadedSuccess) {
            return doGetThreadCpuTime(i);
        }
        return 0L;
    }

    public static int getThreadsCount() {
        if (soLoadedSuccess) {
            return doGetThreadsCount();
        }
        return 0;
    }

    public static long getTotalMemory() {
        if (soLoadedSuccess) {
            return doGetTotalMemory();
        }
        return 0L;
    }

    public static long getVMSize() {
        if (soLoadedSuccess) {
            return doGetVMSize();
        }
        return 0L;
    }

    private static void handleNativeCrash(String str) {
        b.a(str);
    }

    public static void initPThreadDump() {
        if (soLoadedSuccess) {
            doInitThreadDump();
        }
    }

    private static native boolean is64Bit();

    public static boolean is64BitRuntime() {
        if (!soLoadedSuccess) {
            return false;
        }
        try {
            return is64Bit();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isResendSigQuit() {
        return sResendSigQuit;
    }

    public static boolean loadLibrary() {
        if (soLoaded) {
            return soLoadedSuccess;
        }
        soLoaded = true;
        if (!soLoadedSuccess) {
            soLoadedSuccess = u.a("apmlitea");
        }
        return soLoadedSuccess;
    }

    public static int openFile(String str) {
        if (!soLoadedSuccess) {
            return -1;
        }
        try {
            return doOpenFile(str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void rebuildTombstone(File file) {
        if (soLoadedSuccess) {
            doRebuildTombstone(o.c(file).getAbsolutePath(), o.b(file).getAbsolutePath(), o.d(file).getAbsolutePath());
        }
    }

    public static void registerSignalMainThread() {
        if (soLoadedSuccess) {
            doSignalMainThread();
        }
    }

    private static void reportEventForAnrMonitor() {
        try {
            com.apm.lite.b.c.b();
            com.apm.lite.b.d.e();
        } catch (Throwable unused) {
        }
    }

    public static void setAlogFlushAddr(long j) {
    }

    public static void setAlogFlushV2Addr(long j) {
        if (soLoadedSuccess) {
            try {
                doSetAlogFlushAddr(j);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setAlogLogDirAddr(long j) {
        if (soLoadedSuccess) {
            try {
                doSetAlogLogDirAddr(j);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setAlogLogFilePathToNative() {
        if (soLoadedSuccess) {
            try {
                String f = com.apm.lite.e.f();
                File i = o.i(com.apm.lite.e.g());
                i.mkdirs();
                doSetAlogConfigPath(i.getPath() + "/native_" + f + ".atmp");
            } catch (Throwable unused) {
            }
        }
    }

    public static void setResendSigQuit(boolean z) {
        sResendSigQuit = z;
        if (soLoadedSuccess) {
            doSetResendSigQuit(z ? 1 : 0);
        }
    }

    public static void setUploadEnd() {
        if (soLoadedSuccess) {
            doSetUploadEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startAnrMonitor() {
        if (soLoadedSuccess) {
            try {
                doStartAnrMonitor(Build.VERSION.SDK_INT);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean startMonitorNativeCrash(Context context) {
        String a;
        boolean loadLibrary = loadLibrary();
        if (loadLibrary) {
            String str = o.j(context) + "/apmlite";
            new File(str).mkdirs();
            if (new File(context.getApplicationInfo().nativeLibraryDir, "libapmliteb.so").exists()) {
                a = context.getApplicationInfo().nativeLibraryDir;
            } else {
                a = com.apm.lite.f.b.a();
                com.apm.lite.f.b.b("apmliteb");
            }
            doStart(Build.VERSION.SDK_INT, a, str, com.apm.lite.e.f(), com.apm.lite.e.l());
        }
        return loadLibrary;
    }

    public static void startThreadForAnrMonitor() {
        x.a(new Runnable() { // from class: com.apm.lite.nativecrash.NativeImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    NativeImpl.startAnrMonitor();
                } catch (Throwable th) {
                    try {
                        com.apm.lite.c.a(th, "NPTH_ANR_MONITOR_ERROR");
                    } catch (Throwable unused) {
                    }
                }
            }
        }, "NPTH-AnrMonitor");
    }

    public static int unLock(int i) {
        if (soLoadedSuccess && i >= 0) {
            try {
                return doLock("", i);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public static void writeFile(int i, String str) {
        if (soLoadedSuccess && !TextUtils.isEmpty(str)) {
            try {
                doWriteFile(i, str, str.length());
            } catch (Throwable unused) {
            }
        }
    }
}
