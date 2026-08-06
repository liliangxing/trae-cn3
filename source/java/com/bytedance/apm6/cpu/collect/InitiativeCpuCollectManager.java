package com.bytedance.apm6.cpu.collect;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm6.cpu.collect.CpuCacheItem;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.ss.thor.ThorUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class InitiativeCpuCollectManager {
    private static Map<String, CacheDataItem> sCacheCollectData = new HashMap();
    private static List<CpuReportEvent> sCacheReportData = new LinkedList();
    private static volatile boolean isConfigReady = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class CacheDataItem {
        public long appCpuTime;
        public long startTime;
        public long totalCpuTime;

        private CacheDataItem() {
        }
    }

    public static synchronized void onConfigReady() {
        synchronized (InitiativeCpuCollectManager.class) {
            isConfigReady = true;
            if (!sCacheReportData.isEmpty()) {
                Iterator<CpuReportEvent> it = sCacheReportData.iterator();
                while (it.hasNext()) {
                    Monitor.record(it.next());
                }
                sCacheReportData.clear();
            }
        }
    }

    public static synchronized void startCollect(String str) {
        synchronized (InitiativeCpuCollectManager.class) {
            CacheDataItem cacheDataItem = new CacheDataItem();
            cacheDataItem.startTime = System.currentTimeMillis();
            cacheDataItem.appCpuTime = PerfMonitorManager.getInstance().dumpAppCPUTime();
            cacheDataItem.totalCpuTime = PerfMonitorManager.getInstance().dumpTotalCPUTimeByTimeInStat(CommonMonitorUtil.getCpuCoreNum());
            sCacheCollectData.put(str, cacheDataItem);
        }
    }

    public static synchronized void stopCollect(String str, boolean z) {
        synchronized (InitiativeCpuCollectManager.class) {
            CacheDataItem cacheDataItem = sCacheCollectData.get(str);
            if (cacheDataItem == null) {
                return;
            }
            if (cacheDataItem.appCpuTime >= 0 || cacheDataItem.totalCpuTime >= 0) {
                long dumpAppCPUTime = PerfMonitorManager.getInstance().dumpAppCPUTime();
                sCacheCollectData.remove(str);
                sendData(str, PerfMonitorManager.getInstance().dumpTotalCPUTimeByTimeInStat(CommonMonitorUtil.getCpuCoreNum()) - cacheDataItem.totalCpuTime > 0 ? (dumpAppCPUTime - cacheDataItem.appCpuTime) / (r6 - cacheDataItem.totalCpuTime) : -1.0d, (((dumpAppCPUTime - cacheDataItem.appCpuTime) * 1000.0d) / (System.currentTimeMillis() - cacheDataItem.startTime)) / CommonMonitorUtil.getScClkTck(100L), z);
            }
        }
    }

    private static void sendData(final String str, final double d, final double d2, final boolean z) {
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(new AsyncTask() { // from class: com.bytedance.apm6.cpu.collect.InitiativeCpuCollectManager.1
            @Override // java.lang.Runnable
            public void run() {
                CpuReportEvent cpuReportEvent = new CpuReportEvent(!z ? CpuCacheItem.CpuDataType.FRONT : CpuCacheItem.CpuDataType.BACK, str, d, 0.0d, d2, 0.0d, null);
                cpuReportEvent.setBatteryCurrent(ThorUtils.getGalvanicNow(ApmContext.getContext()));
                cpuReportEvent.setIsAutoSample(false);
                if (!InitiativeCpuCollectManager.isConfigReady) {
                    InitiativeCpuCollectManager.sCacheReportData.add(cpuReportEvent);
                } else {
                    Monitor.record(cpuReportEvent);
                }
            }
        });
    }
}
