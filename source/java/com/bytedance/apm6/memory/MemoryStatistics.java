package com.bytedance.apm6.memory;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.memory.config.MemoryConfig;
import com.bytedance.apm6.memory.monitorable.MemoryPerfDataEvent;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.log.Logger;
import java.math.BigDecimal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MemoryStatistics {
    private long lastBlockingGcCount;
    private long lastGcBlockingGcTime;
    private long lastGcCount;
    private long lastGcTime;

    MemoryStatistics() {
    }

    public static MemoryStatistics getInstance() {
        return InnerHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        getGcCount();
        getGcTime();
        getBlockingGcCount();
        getBlockingGcTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MemoryPerfDataEvent collectWithConfig(MemoryConfig memoryConfig) {
        Debug.MemoryInfo memoryInfo = getMemoryInfo();
        if (memoryInfo == null) {
            return null;
        }
        long dalvikUsedSize = getDalvikUsedSize(memoryInfo);
        if (dalvikUsedSize < 0) {
            return null;
        }
        ActivityLifecycleService activityLifecycleService = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        long freeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double javaUsedMemoryRate = getJavaUsedMemoryRate(freeMemory);
        return new MemoryPerfDataEvent(getGcCount(), getGcTime(), getBlockingGcCount(), getBlockingGcTime(), !activityLifecycleService.isForeground(), memoryInfo.nativePss * 1024, 1024 * memoryInfo.getTotalPss(), freeMemory, dalvikUsedSize, getGraphics(memoryInfo), getVmSize(), javaUsedMemoryRate, javaUsedMemoryRate > memoryConfig.memoryTopCheckThreshold(), memoryConfig.isRealTimeMemEnable());
    }

    private long getDalvikUsedSize(Debug.MemoryInfo memoryInfo) {
        return memoryInfo.dalvikPss * 1024;
    }

    private long getGcCount() {
        long parseLong = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_COUNT));
        long j = parseLong - this.lastGcCount;
        this.lastGcCount = parseLong;
        if (ApmContext.isDebugMode()) {
            Logger.m119d("APM-Memory", "gcCount:" + parseLong);
        }
        return j;
    }

    private long getGcTime() {
        long parseLong = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_TIME));
        long j = parseLong - this.lastGcTime;
        this.lastGcTime = parseLong;
        if (ApmContext.isDebugMode()) {
            Logger.m119d("APM-Memory", "gcTime:" + this.lastGcTime);
        }
        return j;
    }

    private long getBlockingGcCount() {
        long parseLong = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_COUNT));
        long j = parseLong - this.lastBlockingGcCount;
        this.lastBlockingGcCount = parseLong;
        if (ApmContext.isDebugMode()) {
            Logger.m119d("APM-Memory", "blockingGcCount:" + this.lastBlockingGcCount);
        }
        return j;
    }

    private long getBlockingGcTime() {
        long parseLong = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_TIME));
        long j = parseLong - this.lastGcBlockingGcTime;
        this.lastGcBlockingGcTime = parseLong;
        if (ApmContext.isDebugMode()) {
            Logger.m119d("APM-Memory", "blockingGcTime:" + this.lastGcBlockingGcTime);
        }
        return j;
    }

    private double getJavaUsedMemoryRate(long j) {
        if (j > 0) {
            return new BigDecimal(j).divide(new BigDecimal(Runtime.getRuntime().maxMemory()), 4, 4).doubleValue();
        }
        return -1.0d;
    }

    private long getGraphics(Debug.MemoryInfo memoryInfo) {
        if (TextUtils.isEmpty(memoryInfo.getMemoryStat(PerfConsts.GRAPHICS_MEM))) {
            return -1L;
        }
        try {
            return Integer.parseInt(r5) * 1024;
        } catch (Exception e) {
            Logger.m121e("APM-Memory", "getGraphics", e);
            e.printStackTrace();
            return -1L;
        }
    }

    private long getVmSize() {
        long vmSize = Tools.getVmSize() * 1024;
        if (vmSize > 0) {
            return vmSize;
        }
        return -1L;
    }

    public static Debug.MemoryInfo getMemoryInfo() {
        if (ApmContext.getContext() == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) ApmContext.getContext().getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            return activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})[0];
        } catch (Exception unused) {
            return null;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class InnerHolder {
        private static final MemoryStatistics instance = new MemoryStatistics();

        private InnerHolder() {
        }
    }
}
