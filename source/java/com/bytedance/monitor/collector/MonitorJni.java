package com.bytedance.monitor.collector;

import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class MonitorJni {
    public static native void clearAllocateInfo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void disableBinderHook();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void disableLock();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void doCollect();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void doDestroy();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void doDisableAtrace();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String doDumpAtrace();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String doDumpAtraceRange(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void doDumpAtraceRangeToALog(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String doDumpNativeStack(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void doEnableAtrace(int i, long j);

    public static native long doGetAppCpuTime();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long doGetCpuTime(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String doGetSchedInfo(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void doInit();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void doSetDebugMode(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void doStart();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void doStop();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void dumpProcInfoTimeRangeToALog(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void enableBinderHook();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void enableLock(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void enableLockAll(long j, boolean z);

    public static native ByteBuffer getAllocReportInfo();

    public static native long getBlockGCCount();

    public static native long getBlockGCTime();

    public static native long getBytesAllocatedEver();

    public static native long getGCCount();

    public static native long getGCTime();

    public static native long getMajorFaults();

    public static native long getMinorFaults();

    public static native long getObjectsAllocatedEver();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getProcCGroup(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String getProcInfoTimeRange(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String getProcInfos();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native ThreadStatInfo getThreadStatInfo(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long getTotalCPUTimeByTimeInStat(int i);

    public static native boolean initJavaMem();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void keepProcHyperOpen(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean readProcFile(String str, int[] iArr, Object[] objArr, long[] jArr, float[] fArr);

    public static native void releaseByteBuffer(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setAlogInstance(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setBufferSize(int i);

    public static native boolean setEnableAllocatedMonitor(boolean z, int i, int i2, int i3, long j, ClassLoader classLoader);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void startHyperMonitor();

    public static native boolean startOrStopAllocatedMonitor(boolean z, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void stopHyperMonitor();
}
