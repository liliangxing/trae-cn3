package com.bytedance.crash.jni;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.crash.Global;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.config.LogPathConfig;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.crash.NativeCrashSummary;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.runtime.NpthHandlerThread;
import com.bytedance.crash.terminate.CrashAccessibilityMonitor;
import com.bytedance.crash.util.SoUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class NativeBridge {
    private static final double NATIVE_CHECK_FACT = 1.4d;
    private static final long NATIVE_CHECK_INTERVAL_MAX = 3600000;
    private static final int TIMEOUT = 1000;
    private static final String UNKNOWN = "unknown";
    private static volatile boolean isSoLoaded = false;
    private static long sNativeCheckInterval = 100;

    private static native void doRegister(String str, String str2);

    private static native void doSetDropDataState(int i);

    private static native void nAnrDumpNativeInfo(long j);

    private static native long nAnrDumpNativeInit(String str);

    private static native void nAnrDumpNativeRelease(long j);

    private static native void nAnrDumpTrace(String str);

    private static native void nAnrEnterMonitorLooper();

    private static native void nAnrInitOnMainThread();

    public static native void nAnrNativeProfilerDump(long j, String str, long j2);

    public static native void nAnrNativeProfilerExit(long j);

    public static native void nAnrNativeProfilerFormat(String str, long[] jArr);

    public static native int nAnrNativeProfilerJvmStart(long j);

    public static native String nAnrNativeProfilerRunTest(String str);

    public static native long nAnrNativeProfilerStart();

    public static native void nAnrNativeProfilerStop(long j);

    private static native void nCheckSigHandler();

    private static native void nCoredumpNativeInit(String str);

    private static native long nCrashDumpNativeInfo(long j);

    private static native void nDumpLogcat(String str, int i);

    private static native void nDumpOsMemory(String str);

    private static native void nDumperLateInit();

    private static native void nEnablePrioriryParams(boolean z, boolean z2, int i);

    private static native int nFlock(String str);

    private static native int nGetApexVersion();

    private static native String nGetBuildID(String str);

    private static native int nGetFdCount(String str);

    private static native String nGetFdLeakReason(String str);

    private static native int nGetFdLimit();

    private static native int nGetJvmMonitorState();

    private static native String nGetMallocType();

    private static native String nGetNativePthreadKeyLeakLibrary(String str);

    private static native String[] nGetOOMReason(String str);

    private static native String nGetStackTrace(boolean z);

    private static native int nGetThreadCount(String str);

    private static native long nGetThreadCpuTimeMills(int i);

    private static native String nGetThreadLeakLibrary(String str);

    private static native String nGetThreadLeakName(String str);

    private static native long nGetVmRss(String str);

    private static native long nGetVmSize(String str, int i);

    private static native int nGetVmaCount(String str);

    private static native boolean nIncreaseFdLimit();

    private static native boolean nIs64BitRuntime();

    private static native String nLoadNativeCrashAbortReason(String str);

    private static native String nLoadNativeCrashBacktrace(String str);

    private static native NativeCrashSummary nLoadNativeCrashSummary(String str);

    private static native int nNativePthreadKeyCount(String str);

    private static native void nNotifyUploadDone();

    private static native void nParseSmaps(String str);

    private static native void nPriorityMonitorInit(String str);

    private static native void nRecoverSignalHandler();

    private static native void nResetNativeInfoLatches();

    private static native void nSet64Bit(boolean z);

    private static native void nSetAlogFlushAddr(long j);

    private static native void nSetAnrDumpAsync(boolean z);

    private static native void nSetAnrResendSigquit(boolean z);

    private static native void nSetAppVersion(String str);

    private static native void nSetDumpTraceTryCatch(boolean z);

    private static native boolean nSignalToProcess(int i, int i2);

    private static native void nStartDumperThread();

    private static native int nStartNativeCrashMonitor(int i, String str, String str2, String str3, String str4, String str5, int i2, long j, long j2, String str6);

    private static native void nStartProfilerJavaLockMonitor();

    private static native long nStringDumperCreate(String str, int i);

    private static native void nStringDumperDumpByteArray(long j, byte[] bArr, int i);

    private static native void nStringDumperDumpCharArray(long j, char[] cArr, int i);

    private static native void nStringDumperDumpString(long j, String str, int i);

    private static native void nStringDumperFlushBuffer(long j);

    private static native void nStringDumperRelease(long j);

    private static native void nUnFlock(int i);

    private static native int nativeDumpHprof(int i, String str);

    private static native void nativeDumpTags(String str);

    private static native String[] nativeGetFdListForAPM();

    private static native String[] nativeGetTags();

    private static native void unRegister(String str);

    public static void loadLibrary() {
        SoUtils.loadLib("npth");
    }

    public static boolean isSoLoaded() {
        return isSoLoaded;
    }

    public static void startNativeCrashMonitor(Context context, File file) {
        if (isSoLoaded()) {
            String absolutePath = file.getAbsolutePath();
            String str = context.getApplicationInfo().nativeLibraryDir;
            File coreDumpPath = LogPathConfig.getCoreDumpPath();
            if (!coreDumpPath.exists()) {
                coreDumpPath.mkdirs();
            }
            nStartNativeCrashMonitor(Build.VERSION.SDK_INT, str, absolutePath, new File(coreDumpPath, CrashManager.getProcessDirectoryName()).getAbsolutePath(), CrashAccessibilityMonitor.getExitDir(), Global.getRootDirectory(context).getAbsolutePath(), 4020260, Global.getAppStartTime(), Global.getAppStartUpTime(), Global.getNativeAppVersion());
            return;
        }
        NpthMonitor.reportInnerException("npth so load fail", new Exception());
    }

    public static void startDumperThread() {
        if (isSoLoaded()) {
            nStartDumperThread();
        }
    }

    public static void dumperLateInit() {
        if (isSoLoaded()) {
            nDumperLateInit();
        }
    }

    public static void resetNativeInfoLatches() {
        if (isSoLoaded()) {
            nResetNativeInfoLatches();
        }
    }

    public static long dumpCrashNativeInfo(long j) {
        if (isSoLoaded()) {
            return nCrashDumpNativeInfo(j);
        }
        return 0L;
    }

    public static void anrDumpNativeInfo(long j) {
        if (isSoLoaded()) {
            nAnrDumpNativeInfo(j);
        }
    }

    public static void anrDumpNativeRelease(long j) {
        if (isSoLoaded()) {
            nAnrDumpNativeRelease(j);
        }
    }

    public static long anrDumperNativeInit(String str) {
        if (isSoLoaded()) {
            return nAnrDumpNativeInit(str);
        }
        return 0L;
    }

    public static int fLock(String str) {
        if (isSoLoaded()) {
            return nFlock(str);
        }
        return -1;
    }

    public static void unFlock(int i) {
        if (isSoLoaded()) {
            nUnFlock(i);
        }
    }

    public static void setAlogFlushFunction(long j) {
        if (isSoLoaded()) {
            nSetAlogFlushAddr(j);
        }
    }

    public static void coredumpNativeInit(String str) {
        if (isSoLoaded()) {
            nCoredumpNativeInit(str);
        }
    }

    private static void handleCrashFromDumperThread(long j, int i) {
        CrashManager.handleNativeCrash(j, i);
    }

    private static void reportAnrEventFromNative(int i, int i2) {
        AnrManager.onSigquitDetected(i, i2);
    }

    public static void notifyUploadDone() {
        if (isSoLoaded()) {
            nNotifyUploadDone();
        }
    }

    public static void recoverSignalHandler() {
        if (isSoLoaded()) {
            nRecoverSignalHandler();
        }
    }

    public static NativeCrashSummary loadNativeCrashSummary(String str) {
        if (isSoLoaded()) {
            return nLoadNativeCrashSummary(str);
        }
        return null;
    }

    public static void dumpLogcat(String str, int i, boolean z) {
        if (isSoLoaded()) {
            nDumpLogcat(str, i);
            if (z) {
                SystemClock.sleep(1000L);
            }
        }
    }

    public static void dumpMeminfo(String str, boolean z) {
        if (isSoLoaded()) {
            nDumpOsMemory(str);
            if (z) {
                SystemClock.sleep(1000L);
            }
        }
    }

    public static int getThreadCount(String str) {
        if (isSoLoaded()) {
            return nGetThreadCount(str);
        }
        return 0;
    }

    public static int getFdCount(String str) {
        if (isSoLoaded()) {
            return nGetFdCount(str);
        }
        return 0;
    }

    public static long getVmSize(String str, boolean z) {
        if (isSoLoaded()) {
            return nGetVmSize(str, z ? 1 : 0);
        }
        return 0L;
    }

    public static long getVmRss(String str) {
        if (isSoLoaded()) {
            return nGetVmRss(str);
        }
        return 0L;
    }

    public static int getFdLimit() {
        if (isSoLoaded()) {
            return nGetFdLimit();
        }
        return Build.VERSION.SDK_INT > 27 ? 32768 : 1024;
    }

    public static String getFdLeakReason(File file) {
        String nGetFdLeakReason = isSoLoaded() ? nGetFdLeakReason(file.getAbsolutePath()) : null;
        return TextUtils.isEmpty(nGetFdLeakReason) ? "unknown" : nGetFdLeakReason;
    }

    public static String getPthreadKeyLeakLibrary(File file) {
        String nGetNativePthreadKeyLeakLibrary = isSoLoaded() ? nGetNativePthreadKeyLeakLibrary(file.getAbsolutePath()) : null;
        return TextUtils.isEmpty(nGetNativePthreadKeyLeakLibrary) ? "unknown" : nGetNativePthreadKeyLeakLibrary;
    }

    public static String getThreadLeakName(File file) {
        String nGetThreadLeakName = isSoLoaded() ? nGetThreadLeakName(file.getAbsolutePath()) : null;
        return TextUtils.isEmpty(nGetThreadLeakName) ? "unknown" : nGetThreadLeakName;
    }

    public static String getThreadLeakLibrary(File file) {
        String nGetThreadLeakLibrary = isSoLoaded() ? nGetThreadLeakLibrary(file.getAbsolutePath()) : null;
        return TextUtils.isEmpty(nGetThreadLeakLibrary) ? "unknown" : nGetThreadLeakLibrary;
    }

    public static String loadNativeCrashBacktrace(String str) {
        if (isSoLoaded()) {
            return nLoadNativeCrashBacktrace(str);
        }
        return null;
    }

    public static String loadNativeCrashAbortReason(String str) {
        if (isSoLoaded()) {
            return nLoadNativeCrashAbortReason(str);
        }
        return null;
    }

    public static String GetBuildID(String str) {
        if (isSoLoaded()) {
            return nGetBuildID(str);
        }
        return null;
    }

    public static boolean is64BitRuntime() {
        if (isSoLoaded()) {
            return nIs64BitRuntime();
        }
        return false;
    }

    public static boolean signalToProcess(int i, int i2) {
        if (isSoLoaded()) {
            return nSignalToProcess(i, i2);
        }
        return false;
    }

    public static long getThreadCpuTimeMills(int i) {
        if (isSoLoaded()) {
            return nGetThreadCpuTimeMills(i);
        }
        return -1L;
    }

    public static boolean increaseFdLimit() {
        if (isSoLoaded()) {
            return nIncreaseFdLimit();
        }
        return false;
    }

    public static void anrInitOnMainThread() {
        if (isSoLoaded()) {
            nAnrInitOnMainThread();
        }
    }

    public static void anrEnterMonitorLooper() {
        if (isSoLoaded()) {
            nAnrEnterMonitorLooper();
        }
    }

    public static void anrDumpTrace(String str) {
        if (isSoLoaded()) {
            nAnrDumpTrace(str);
        }
    }

    public static void stringDumperDumpCharArray(long j, char[] cArr, int i) {
        if (isSoLoaded()) {
            nStringDumperDumpCharArray(j, cArr, i);
        }
    }

    public static void stringDumperDumpByteArray(long j, byte[] bArr, int i) {
        if (isSoLoaded()) {
            nStringDumperDumpByteArray(j, bArr, i);
        }
    }

    public static void stringDumperDumpString(long j, String str, int i) {
        if (isSoLoaded()) {
            nStringDumperDumpString(j, str, i);
        }
    }

    public static long stringDumperCreate(String str, int i) {
        if (isSoLoaded()) {
            return nStringDumperCreate(str, i);
        }
        return 0L;
    }

    public static void stringDumperRelease(long j) {
        if (isSoLoaded()) {
            nStringDumperRelease(j);
        }
    }

    public static void stringDumperFlushBuffer(long j) {
        if (isSoLoaded()) {
            nStringDumperFlushBuffer(j);
        }
    }

    public static void setAppVersion(String str) {
        if (isSoLoaded()) {
            nSetAppVersion(str);
        }
    }

    @Deprecated
    public static void doSignalRecover() {
        if (isSoLoaded()) {
            NpthHandlerThread.getDefaultHandler().postDelayed(new Runnable() { // from class: com.bytedance.crash.jni.NativeBridge.1
                @Override // java.lang.Runnable
                public void run() {
                    long unused = NativeBridge.sNativeCheckInterval = (long) (NativeBridge.sNativeCheckInterval * NativeBridge.NATIVE_CHECK_FACT);
                    NativeBridge.checkSigHandler();
                    if (NativeBridge.sNativeCheckInterval > 3600000) {
                        return;
                    }
                    NpthHandlerThread.getDefaultHandler().postDelayed(this, NativeBridge.sNativeCheckInterval);
                }
            }, sNativeCheckInterval);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkSigHandler() {
        if (isSoLoaded()) {
            nCheckSigHandler();
        }
    }

    @Deprecated
    public static List<String> getFdListForAPM() {
        if (!isSoLoaded()) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            String[] nativeGetFdListForAPM = nativeGetFdListForAPM();
            if (nativeGetFdListForAPM != null) {
                arrayList.addAll(Arrays.asList(nativeGetFdListForAPM));
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void setDropDataState(int i) {
        if (isSoLoaded()) {
            doSetDropDataState(i);
        }
    }

    public static int PthreadKeyCount(String str) {
        if (isSoLoaded()) {
            return nNativePthreadKeyCount(str);
        }
        return 0;
    }

    public static int getVmaCount(String str) {
        if (isSoLoaded()) {
            return nGetVmaCount(str);
        }
        return 0;
    }

    public static String[] getOOMReason(String str) {
        if (isSoLoaded()) {
            return nGetOOMReason(str);
        }
        return null;
    }

    public static int dumpHprof(String str) {
        if (!isSoLoaded()) {
            return -1;
        }
        try {
            return nativeDumpHprof(Build.VERSION.SDK_INT, str);
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static HashMap<String, String> getTags() {
        String[] nativeGetTags = nativeGetTags();
        HashMap<String, String> hashMap = new HashMap<>();
        if (nativeGetTags == null) {
            return hashMap;
        }
        if (nativeGetTags.length < 1) {
            return hashMap;
        }
        for (int i = 0; i < nativeGetTags.length; i += 2) {
            hashMap.put(nativeGetTags[i], nativeGetTags[i + 1]);
        }
        return hashMap;
    }

    public static void priorityMonitorInit(String str) {
        if (!isSoLoaded() || str.length() <= 0) {
            return;
        }
        nPriorityMonitorInit(str);
    }

    public static void setPriorityParams(boolean z, boolean z2, int i) {
        if (isSoLoaded()) {
            nEnablePrioriryParams(z, z2, i);
        }
    }

    public static void parseSmaps(String str) {
        if (isSoLoaded()) {
            nParseSmaps(str);
        }
    }

    public static boolean register(String str, String str2) {
        if (!isSoLoaded()) {
            return false;
        }
        doRegister(str, str2);
        return true;
    }

    public static boolean remove(String str) {
        if (!isSoLoaded() || TextUtils.isEmpty(str)) {
            return false;
        }
        unRegister(str);
        return true;
    }

    public static void dumpTags(String str) {
        if (isSoLoaded()) {
            try {
                nativeDumpTags(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void startProfilerJavaLockMonitor() {
        if (isSoLoaded()) {
            nStartProfilerJavaLockMonitor();
        }
    }

    public static void set64Bit(boolean z) {
        if (isSoLoaded) {
            nSet64Bit(z);
        }
    }

    public static void setAnrDumpAsync(boolean z) {
        if (isSoLoaded) {
            nSetAnrDumpAsync(z);
        }
    }

    public static void setDumpTraceTryCatch(boolean z) {
        if (isSoLoaded) {
            nSetDumpTraceTryCatch(z);
        }
    }

    public static void setAnrResendSigquit(boolean z) {
        if (isSoLoaded) {
            nSetAnrResendSigquit(z);
        }
    }

    public static String getStackTrace(boolean z) {
        if (!isSoLoaded()) {
            return null;
        }
        try {
            return nGetStackTrace(z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getJvmMonitorState() {
        if (!isSoLoaded) {
            return -1;
        }
        try {
            return nGetJvmMonitorState();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int getApexVersion() {
        if (!isSoLoaded) {
            return -1;
        }
        try {
            return nGetApexVersion();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String getMallocType() {
        if (!isSoLoaded()) {
            return null;
        }
        try {
            return nGetMallocType();
        } catch (Throwable unused) {
            return null;
        }
    }
}
