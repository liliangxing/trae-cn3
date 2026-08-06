package com.bytedance.apm.perf;

import android.content.Context;
import android.os.Debug;
import android.os.Process;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.perf.entity.CpuInfo;
import com.bytedance.apm.perf.entity.MemoryInfo;
import com.bytedance.apm.util.CommonMonitorUtil;

/* loaded from: classes3.dex */
public class PerfCollectUtils {
    public static MemoryInfo getMemory(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        try {
            long j = Runtime.getRuntime().totalMemory();
            long freeMemory = Runtime.getRuntime().freeMemory();
            memoryInfo.javaTotalMemory = j;
            memoryInfo.javaFreeMemory = freeMemory;
            memoryInfo.javaUsedMemory = j - freeMemory;
            Debug.MemoryInfo pidMemoryInfo = CommonMonitorUtil.getPidMemoryInfo(Process.myPid(), context);
            if (pidMemoryInfo != null) {
                int i = pidMemoryInfo.dalvikPss;
                int i2 = pidMemoryInfo.nativePss;
                int totalPss = pidMemoryInfo.getTotalPss();
                try {
                    memoryInfo.graphics = Integer.parseInt(pidMemoryInfo.getMemoryStat(PerfConsts.GRAPHICS_MEM)) * 1024;
                    memoryInfo.javaHeap = Integer.parseInt(pidMemoryInfo.getMemoryStat(PerfConsts.MEM_JAVA_HEAP)) * 1024;
                    memoryInfo.nativeHeap = Integer.parseInt(pidMemoryInfo.getMemoryStat(PerfConsts.MEM_NATIVE_HEAP)) * 1024;
                    memoryInfo.code = Integer.parseInt(pidMemoryInfo.getMemoryStat(PerfConsts.MEM_CODE)) * 1024;
                    memoryInfo.stack = Integer.parseInt(pidMemoryInfo.getMemoryStat(PerfConsts.MEM_STACK)) * 1024;
                    memoryInfo.privateOther = Integer.parseInt(pidMemoryInfo.getMemoryStat(PerfConsts.MEM_PRIVATE_OTHER)) * 1024;
                    memoryInfo.system = Integer.parseInt(pidMemoryInfo.getMemoryStat(PerfConsts.MEM_SYSTEM)) * 1024;
                    memoryInfo.totalPss = Integer.parseInt(pidMemoryInfo.getMemoryStat(PerfConsts.MEM_TOTAL_PSS)) * 1024;
                    memoryInfo.totalSwap = Integer.parseInt(pidMemoryInfo.getMemoryStat(PerfConsts.MEM_TOTAL_SWAP)) * 1024;
                } catch (Exception unused) {
                }
                memoryInfo.pssDalvik = i * 1024;
                memoryInfo.pssNative = i2 * 1024;
                memoryInfo.pssTotal = totalPss * 1024;
                memoryInfo.dalvikPrivateDirty = pidMemoryInfo.dalvikPrivateDirty * 1024;
                memoryInfo.dalvikSharedDirty = pidMemoryInfo.dalvikSharedDirty * 1024;
                memoryInfo.otherPss = pidMemoryInfo.otherPss * 1024;
                memoryInfo.otherPrivateDirty = pidMemoryInfo.otherPrivateDirty * 1024;
                memoryInfo.otherSharedDirty = pidMemoryInfo.otherSharedDirty * 1024;
                memoryInfo.totalSwappablePss = pidMemoryInfo.getTotalSwappablePss() * 1024;
                memoryInfo.totalPrivateDirty = pidMemoryInfo.getTotalPrivateDirty() * 1024;
                memoryInfo.totalSharedClean = pidMemoryInfo.getTotalSharedClean() * 1024;
            }
            memoryInfo.vmSize = CommonMonitorUtil.getVmSize() * 1024;
        } catch (Exception unused2) {
        }
        return memoryInfo;
    }

    public static CpuInfo getCpuRate() {
        long currentTimeMillis;
        long appCPUTime;
        boolean isProcStatCanRead;
        long totalCPUTime;
        long appCPUTime2;
        double d;
        CpuInfo cpuInfo = new CpuInfo();
        try {
            currentTimeMillis = System.currentTimeMillis();
            appCPUTime = CommonMonitorUtil.getAppCPUTime();
            isProcStatCanRead = CommonMonitorUtil.isProcStatCanRead();
            totalCPUTime = isProcStatCanRead ? CommonMonitorUtil.getTotalCPUTime() : 0L;
            try {
                Thread.sleep(360L);
            } catch (InterruptedException unused) {
            }
            appCPUTime2 = CommonMonitorUtil.getAppCPUTime();
        } catch (Exception unused2) {
        }
        if (isProcStatCanRead) {
            long totalCPUTime2 = CommonMonitorUtil.getTotalCPUTime() - totalCPUTime;
            if (totalCPUTime2 > 0) {
                d = (((float) appCPUTime2) - ((float) appCPUTime)) / ((float) totalCPUTime2);
                cpuInfo.cpuAppRate = d;
                cpuInfo.cpuAppSpeed = (((appCPUTime2 - appCPUTime) * 1000.0d) / (System.currentTimeMillis() - currentTimeMillis)) / CommonMonitorUtil.getScClkTck(100L);
                return cpuInfo;
            }
        }
        d = 0.0d;
        cpuInfo.cpuAppRate = d;
        cpuInfo.cpuAppSpeed = (((appCPUTime2 - appCPUTime) * 1000.0d) / (System.currentTimeMillis() - currentTimeMillis)) / CommonMonitorUtil.getScClkTck(100L);
        return cpuInfo;
    }
}
