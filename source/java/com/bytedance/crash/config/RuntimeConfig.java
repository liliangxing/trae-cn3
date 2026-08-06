package com.bytedance.crash.config;

import com.bytedance.crash.IEncrypt;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.EncryptUtils;

/* loaded from: classes3.dex */
public class RuntimeConfig {
    private static final long ANR_CHECK_INTERVAL = 500;
    private static final long LAUNCH_CRASH_INTERVAL = 8000;
    private static long sAnrCheckInterval = 500;
    private static boolean sDebugMode = false;
    private static long sLaunchCrashInterval = 8000;
    private static boolean sStopEnsure;
    private static boolean sStopUpload;
    private static IEncrypt sEncryptImpl = new DefaultEncrypt();
    private static boolean reportErrorEnable = true;
    private static boolean ensureEnable = true;

    public static boolean isEncrypt() {
        return true;
    }

    public static long getAnrCheckInterval() {
        return sAnrCheckInterval;
    }

    public static void setAnrCheckInterval(long j) {
        sAnrCheckInterval = j;
    }

    public static long getLaunchCrashInterval() {
        return sLaunchCrashInterval;
    }

    public static void setLaunchCrashInterval(long j) {
        sLaunchCrashInterval = j;
    }

    public static IEncrypt getEncryptImpl() {
        return sEncryptImpl;
    }

    public static void setEncryptImpl(IEncrypt iEncrypt) {
        if (iEncrypt != null) {
            sEncryptImpl = iEncrypt;
        }
    }

    public static boolean isDebugMode() {
        return sDebugMode;
    }

    public static void setDebugMode(boolean z) {
        sDebugMode = z;
    }

    public static boolean isStopUpload() {
        return sStopUpload;
    }

    public static void stopUpload() {
        sStopUpload = true;
    }

    public static boolean isStopEnsure() {
        return sStopEnsure;
    }

    public static void stopEnsure() {
        sStopEnsure = true;
    }

    public static boolean isLocalDebug() {
        return isDebugMode() && isLocalTest();
    }

    public static boolean isLocalTest() {
        String channel;
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        return (appMonitor == null || (channel = appMonitor.getChannel()) == null || !channel.contains("test_crash")) ? false : true;
    }

    /* loaded from: classes3.dex */
    static class DefaultEncrypt implements IEncrypt {
        DefaultEncrypt() {
        }

        @Override // com.bytedance.crash.IEncrypt
        public byte[] encrypt(byte[] bArr) {
            return EncryptUtils.encrypt(bArr);
        }
    }

    public static void setReportErrorEnable(boolean z) {
        reportErrorEnable = z;
    }

    public static boolean isReportErrorEnable() {
        return reportErrorEnable;
    }

    public static void setEnsureEnable(boolean z) {
        ensureEnable = z;
    }

    public static boolean isEnsureEnable() {
        return ensureEnable;
    }
}
