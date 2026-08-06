package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.monitor.collector.PerfMonitorManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CpuLoadCollector {
    public static double collectRate() {
        long totalCPUTime = CommonMonitorUtil.getTotalCPUTime();
        long dumpAppCPUTime = PerfMonitorManager.getInstance().dumpAppCPUTime();
        try {
            Thread.sleep(360L);
        } catch (InterruptedException unused) {
        }
        long dumpAppCPUTime2 = PerfMonitorManager.getInstance().dumpAppCPUTime();
        if (CommonMonitorUtil.getTotalCPUTime() - totalCPUTime > 0) {
            return (((float) dumpAppCPUTime2) - ((float) dumpAppCPUTime)) / ((float) r6);
        }
        return -1.0d;
    }

    public static double collectSpeed() {
        long currentTimeMillis = System.currentTimeMillis();
        long dumpAppCPUTime = PerfMonitorManager.getInstance().dumpAppCPUTime();
        try {
            Thread.sleep(360L);
        } catch (InterruptedException unused) {
        }
        return (((PerfMonitorManager.getInstance().dumpAppCPUTime() - dumpAppCPUTime) * 1000.0d) / (System.currentTimeMillis() - currentTimeMillis)) / CommonMonitorUtil.getScClkTck(100L);
    }
}
