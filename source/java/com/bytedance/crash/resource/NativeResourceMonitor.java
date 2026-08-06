package com.bytedance.crash.resource;

import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.NpthLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NativeResourceMonitor {
    private static native void nDumpNativeInfoThreads(String str);

    private static native int nFakeOpen(String str);

    private static native int nFdTrackDoCommand(int i);

    private static native int nFdTrackDumpNative(int i, String str);

    private static native int nFdTrackGetFdCount(int i);

    private static native int nNativeBridgeInit(int i, int i2, String str, String str2, String str3, String str4);

    private static native int nNativeDoCommnad(int i);

    private static native long nNativeGetHeapLeakSize();

    private static native long nNativeGetHeapSize();

    private static native void nNativeNeedDumpMemInfo(int i);

    private static native void nNativeSetDumpThreshold(long j);

    private static native void nNativeSetMinSizeByte(long j);

    private static native int nVmMonitorDoCommand(int i, int i2);

    private static native void nVmMonitorDumpMaps(String str);

    private static native int nVmMonitorDumpNative(int i, int i2, String str);

    private static native int nXasanInit(int i, String str, String str2);

    public static boolean isSoLoaded() {
        return NativeBridge.isSoLoaded();
    }

    public static int LoadNativeBridgeSoInit(int i, int i2, String str, String str2, String str3, String str4) {
        if (!isSoLoaded()) {
            NpthLog.m229e("NativeBridgeInit fail", "monitorType:" + i2 + " soName:" + str);
            return -1;
        }
        return nNativeBridgeInit(i, i2, str, str2, str3, str4);
    }

    public static int nativeDoCommnad(int i) {
        if (isSoLoaded()) {
            return nNativeDoCommnad(i);
        }
        return -1;
    }

    public static long nativeGetHeapSize() {
        if (isSoLoaded()) {
            return nNativeGetHeapSize();
        }
        return -1L;
    }

    public static long nativeGetHeapLeakSize() {
        if (isSoLoaded()) {
            return nNativeGetHeapLeakSize();
        }
        return -1L;
    }

    public static void nativeNeedDumpMemInfo(int i) {
        if (isSoLoaded()) {
            nNativeNeedDumpMemInfo(i);
        }
    }

    public static void nativeSetMinSizeByte(int i) {
        if (isSoLoaded()) {
            nNativeSetMinSizeByte(i);
        }
    }

    public static void nativeSetDumpThreshold(long j) {
        if (isSoLoaded()) {
            nNativeSetDumpThreshold(j);
        }
    }

    public static int vmMonitorDoCommand(int i, int i2) {
        if (isSoLoaded()) {
            return nVmMonitorDoCommand(i, i2);
        }
        return -1;
    }

    public static int vmMonitorDumpNative(int i, int i2, String str) {
        if (isSoLoaded()) {
            return nVmMonitorDumpNative(i, i2, str);
        }
        return -1;
    }

    public static void vmMonitorDumpMaps(String str) {
        if (isSoLoaded()) {
            nVmMonitorDumpMaps(str);
        }
    }

    public static int fdTrackDoCommand(int i) {
        if (isSoLoaded()) {
            return nFdTrackDoCommand(i);
        }
        return -1;
    }

    public static int fdTrackGetFdCount(int i) {
        if (isSoLoaded()) {
            return nFdTrackGetFdCount(i);
        }
        return -1;
    }

    public static int fdTrackDumpNative(int i, String str) {
        if (isSoLoaded()) {
            return nFdTrackDumpNative(i, str);
        }
        return -1;
    }

    public static int fakeOpen(String str) {
        if (isSoLoaded()) {
            return nFakeOpen(str);
        }
        return -1;
    }

    public static int StartXasanInit(int i, String str, String str2) {
        if (!isSoLoaded()) {
            NpthLog.m229e("NPTH", "xasan load so failed");
            return -1;
        }
        return nXasanInit(i, str, str2);
    }

    public static void dumpNativeInfoThreads(String str) {
        if (isSoLoaded()) {
            nDumpNativeInfoThreads(str);
        }
    }
}
