package com.bytedance.apm6.cpu.collect;

import android.os.Process;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm.util.Pair;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.collect.CpuCacheItem;
import com.bytedance.apm6.cpu.config.CpuConfig;
import com.bytedance.apm6.cpu.exception.ThreadCpuExceptionUtils;
import com.bytedance.apm6.cpu.exception.ThreadExceptionItem;
import com.bytedance.apm6.cpu.service.CurrentCpuDataHolder;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.lifecycle.DummyLifecycleListener;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.watson.assist.api.IAssistStat;
import com.ss.thor.ThorUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CpuDataCollector extends DummyLifecycleListener {
    private static final long POLL_INTERVAL = 30000;
    private static final String TAG = "MonitorCpu";
    private IAssistStat assistStat;
    private CpuConfig cpuConfig;
    private CpuDataAssembler mAssembler;
    private AsyncTask mCollectAsyncTask;
    private long mCollectInterval;
    private long mCollectThreadInterval;
    private long mLastThreadWorkTimestamp;
    private long mLastWorkTimestamp;
    private boolean isFirstCollect = true;
    private AtomicBoolean mIsStart = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public CpuDataCollector(CpuDataAssembler cpuDataAssembler, IAssistStat iAssistStat) {
        this.mAssembler = cpuDataAssembler;
        this.assistStat = iAssistStat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start(CpuConfig cpuConfig) {
        if (this.mIsStart.compareAndSet(false, true)) {
            this.cpuConfig = cpuConfig;
            initAsyncTask();
            if (this.mCollectAsyncTask != null) {
                AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(this.mCollectAsyncTask);
            }
            try {
                this.assistStat.start();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        if (!this.mIsStart.compareAndSet(true, false) || this.mCollectAsyncTask == null) {
            return;
        }
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.mCollectAsyncTask);
        try {
            this.assistStat.end();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        if (this.mIsStart.compareAndSet(false, true)) {
            initAsyncTask();
            if (this.mCollectAsyncTask != null) {
                AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(this.mCollectAsyncTask);
            }
            try {
                this.assistStat.start();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshConfig(boolean z) {
        CpuConfig cpuConfig = this.cpuConfig;
        this.mCollectInterval = z ? cpuConfig.getFrontCollectInterval() : cpuConfig.getBackCollectInterval();
        this.mCollectThreadInterval = z ? this.cpuConfig.getFrontThreadCollectInterval() : this.cpuConfig.getBackThreadCollectInterval();
    }

    private void initAsyncTask() {
        if (this.mCollectAsyncTask == null) {
            this.mCollectAsyncTask = new AsyncTask(30000L, 30000L) { // from class: com.bytedance.apm6.cpu.collect.CpuDataCollector.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ApmContext.isDebugMode()) {
                        Logger.m119d(Constants.TAG, "run: " + CpuDataCollector.this.mCollectInterval);
                    }
                    CpuDataCollector.this.refreshConfig(CpuCollectManager.getInstance().isFront());
                    if (!CpuDataCollector.this.isFirstCollect) {
                        CpuDataCollector.this.doCollectProcess();
                        CpuDataCollector.this.doCollectThread();
                    }
                    CpuDataCollector.this.isFirstCollect = false;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCollectThread() {
        boolean z;
        IAssistStat.CpuFactorTag cpuFactorTag;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastThreadWorkTimestamp < this.mCollectThreadInterval) {
            return;
        }
        this.mLastThreadWorkTimestamp = currentTimeMillis;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ThreadCpuExceptionUtils.getThreadInfo(Process.myPid(), hashMap);
        try {
            Thread.sleep(100L);
            z = false;
        } catch (InterruptedException e) {
            Logger.m121e(Constants.TAG, "InterruptedException", e);
            z = true;
        }
        if (z) {
            return;
        }
        ThreadCpuExceptionUtils.getThreadInfo(Process.myPid(), hashMap2);
        try {
            cpuFactorTag = this.assistStat.getCpuFactorTag();
        } catch (Exception unused) {
            cpuFactorTag = null;
        }
        doCollectThreadAndReport(0L, hashMap, hashMap2, cpuFactorTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCollectProcess() {
        boolean z;
        double d;
        IAssistStat.CpuFactorTag cpuFactorTag;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastWorkTimestamp < this.mCollectInterval) {
            return;
        }
        this.mLastWorkTimestamp = currentTimeMillis;
        int cpuCoreNum = CommonMonitorUtil.getCpuCoreNum();
        if (cpuCoreNum <= 0) {
            return;
        }
        long dumpAppCPUTime = PerfMonitorManager.getInstance().dumpAppCPUTime();
        long dumpTotalCPUTimeByTimeInStat = PerfMonitorManager.getInstance().dumpTotalCPUTimeByTimeInStat(cpuCoreNum);
        try {
            Thread.sleep(360L);
            z = false;
        } catch (InterruptedException unused) {
            z = true;
        }
        if (z) {
            return;
        }
        long dumpAppCPUTime2 = PerfMonitorManager.getInstance().dumpAppCPUTime();
        long dumpTotalCPUTimeByTimeInStat2 = PerfMonitorManager.getInstance().dumpTotalCPUTimeByTimeInStat(cpuCoreNum) - dumpTotalCPUTimeByTimeInStat;
        if (dumpTotalCPUTimeByTimeInStat2 > 0) {
            d = (((float) dumpAppCPUTime2) - ((float) dumpAppCPUTime)) / ((float) dumpTotalCPUTimeByTimeInStat2);
            ApmAlogHelper.feedbackI(TAG, "appCpuRate -> " + d);
        } else {
            d = -1.0d;
        }
        double d2 = (dumpAppCPUTime2 - dumpAppCPUTime) * 1000.0d;
        double currentTimeMillis2 = (d2 / (System.currentTimeMillis() - currentTimeMillis)) / CommonMonitorUtil.getScClkTck(100L);
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, String.valueOf(d2) + " " + (System.currentTimeMillis() - currentTimeMillis) + " " + CommonMonitorUtil.getScClkTck(100L));
        }
        if (ApmContext.isDebugMode()) {
            ApmAlogHelper.feedbackI(TAG, "appCpuSpeed -> " + currentTimeMillis2);
            Logger.m119d(Constants.TAG, "collect cpu data, rate: " + d + " speed: " + currentTimeMillis2);
        }
        try {
            this.assistStat.refreshCpuStat();
            cpuFactorTag = this.assistStat.getCpuFactorTag();
        } catch (Throwable unused2) {
            cpuFactorTag = null;
        }
        if (this.mAssembler.isStart()) {
            this.mAssembler.addCacheData(d, currentTimeMillis2);
            this.mAssembler.triggerAssemble(cpuFactorTag);
        }
        CurrentCpuDataHolder.getInstance().refreshData(d, currentTimeMillis2);
        ApmCpuManager.ICpuDataListener dataListener = CpuCollectManager.getInstance().getDataListener();
        if (dataListener != null) {
            dataListener.onCpuData(currentTimeMillis2, d, PerfFilterManager.getInstance().getSceneString(), cpuFactorTag, NetworkUtils.getNetworkTypeFast(ApmContext.getContext()));
        }
    }

    private void doCollectThreadAndReport(long j, Map<Integer, ThreadExceptionItem> map, Map<Integer, ThreadExceptionItem> map2, IAssistStat.CpuFactorTag cpuFactorTag) {
        ThreadExceptionItem threadExceptionItem;
        if (map.isEmpty() || map2.isEmpty()) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList<ICpuDataService.ThreadCpuItem> linkedList2 = new LinkedList<>();
        for (Map.Entry<Integer, ThreadExceptionItem> entry : map.entrySet()) {
            ThreadExceptionItem value = entry.getValue();
            if (value != null && (threadExceptionItem = map2.get(entry.getKey())) != null && threadExceptionItem.getThreadName().equals(value.getThreadName())) {
                long threadCpuTime = threadExceptionItem.getThreadCpuTime() - value.getThreadCpuTime();
                if (threadCpuTime != 0) {
                    Logger.m119d(Constants.TAG, "cpu_thread=" + threadExceptionItem.getThreadName() + " thread_time=" + threadCpuTime + " app_time=" + j);
                    if (j == 0) {
                        double d = threadCpuTime;
                        linkedList.add(new Pair(threadExceptionItem.getThreadName(), Double.valueOf(d)));
                        linkedList2.add(new ICpuDataService.ThreadCpuItem(threadExceptionItem.getThreadName(), d, threadExceptionItem.getThreadId()));
                    } else {
                        double d2 = threadCpuTime / j;
                        if (d2 > 9.0E-4d) {
                            linkedList.add(new Pair(threadExceptionItem.getThreadName(), Double.valueOf(String.format("%.3f", Double.valueOf(d2)))));
                            linkedList2.add(new ICpuDataService.ThreadCpuItem(threadExceptionItem.getThreadName(), Double.valueOf(String.format("%.3f", Double.valueOf(d2))).doubleValue(), threadExceptionItem.getThreadId()));
                        }
                    }
                }
            }
        }
        if (linkedList.isEmpty()) {
            return;
        }
        Collections.sort(linkedList2, new Comparator<ICpuDataService.ThreadCpuItem>() { // from class: com.bytedance.apm6.cpu.collect.CpuDataCollector.2
            @Override // java.util.Comparator
            public int compare(ICpuDataService.ThreadCpuItem threadCpuItem, ICpuDataService.ThreadCpuItem threadCpuItem2) {
                return (int) ((threadCpuItem2.getCpuUsage() * 100.0d) - (threadCpuItem.getCpuUsage() * 100.0d));
            }
        });
        CurrentCpuDataHolder.getInstance().refreshTopThreadData(linkedList2);
        if (this.cpuConfig.isEnableUpload()) {
            CpuReportEvent cpuReportEvent = new CpuReportEvent(CpuCollectManager.getInstance().isFront() ? CpuCacheItem.CpuDataType.FRONT : CpuCacheItem.CpuDataType.BACK, PerfFilterManager.getInstance().getSceneString(), linkedList, cpuFactorTag);
            cpuReportEvent.setBatteryCurrent(ThorUtils.getGalvanicNow(ApmContext.getContext()));
            try {
                cpuReportEvent.setNormalSampleState(this.assistStat.isCpuSampleEnvironment());
            } catch (Throwable unused) {
            }
            Monitor.record(cpuReportEvent);
        }
    }
}
