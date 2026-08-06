package com.bytedance.apm6.cpu;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.perf.entity.CpuInfo;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm6.cpu.collect.CpuCollectManager;
import com.bytedance.apm6.cpu.collect.InitiativeCpuCollectManager;
import com.bytedance.apm6.cpu.exception.CpuExceptionManager;
import com.bytedance.apm6.cpu.service.CurrentCpuDataHolder;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.watson.assist.api.IAssistStat;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ApmCpuManager {
    private static volatile ApmCpuManager singleton;
    private CopyOnWriteArraySet<String> mSceneSet = new CopyOnWriteArraySet<>();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface ICpuDataListener {
        void onCpuData(double d, double d2, String str, IAssistStat.CpuFactorTag cpuFactorTag, NetworkUtils.NetworkType networkType);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface ICpuExceptionFilter {
        boolean needFilter();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface ICpuExceptionListener {
        void onException(double d);
    }

    private ApmCpuManager() {
    }

    public static ApmCpuManager getInstance() {
        if (singleton == null) {
            synchronized (ApmCpuManager.class) {
                if (singleton == null) {
                    singleton = new ApmCpuManager();
                }
            }
        }
        return singleton;
    }

    public void startScene(String str) {
        this.mSceneSet.add(str);
        PerfFilterManager.getInstance().startScene(str);
    }

    public void stopScene(String str) {
        this.mSceneSet.remove(str);
        PerfFilterManager.getInstance().stopScene(str);
    }

    public void startUsageDetect(String str) {
        InitiativeCpuCollectManager.startCollect(str);
    }

    public void stopUsageDetect(String str, boolean z) {
        InitiativeCpuCollectManager.stopCollect(str, z);
    }

    public void startExceptionDetectNoStack() {
        if (ApmContext.isInitFinish()) {
            CpuExceptionManager.getInstance().forceOpenNoStack();
        }
    }

    public void stopExceptionDetectNoStack() {
        if (ApmContext.isInitFinish()) {
            CpuExceptionManager.getInstance().stopForceOpenNoStack();
        }
    }

    public void setCpuExceptionFilter(ICpuExceptionFilter iCpuExceptionFilter) {
        CpuExceptionManager.getInstance().setCpuFilterListener(iCpuExceptionFilter);
    }

    @Deprecated
    public void tmpStartExceptionDetect() {
        CpuExceptionManager.getInstance().forceOpen();
    }

    public long getLastCpuExceptionTimestamp() {
        return CpuExceptionManager.getInstance().getLastExceptionTimestamp();
    }

    public void setExceptionListener(ICpuExceptionListener iCpuExceptionListener) {
        CpuExceptionManager.getInstance().setExceptionListener(iCpuExceptionListener);
    }

    public void setCpuDataListener(ICpuDataListener iCpuDataListener) {
        CpuCollectManager.getInstance().setDataListener(iCpuDataListener);
    }

    public double getCpuRate() {
        return CurrentCpuDataHolder.getInstance().getCpuRate();
    }

    public double getCpuSpeed() {
        return CurrentCpuDataHolder.getInstance().getCpuSpeed();
    }

    public CpuInfo getCurrentCpuRate() {
        return getCurrentCpuRateNew();
    }

    public CpuInfo getCurrentCpuRateNew() {
        int cpuCoreNum;
        CpuInfo cpuInfo = new CpuInfo();
        try {
            cpuCoreNum = CommonMonitorUtil.getCpuCoreNum();
        } catch (Exception unused) {
        }
        if (cpuCoreNum <= 0) {
            return cpuInfo;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long dumpAppCPUTime = PerfMonitorManager.getInstance().dumpAppCPUTime();
        long dumpTotalCPUTimeByTimeInStat = PerfMonitorManager.getInstance().dumpTotalCPUTimeByTimeInStat(cpuCoreNum);
        try {
            Thread.sleep(360L);
        } catch (InterruptedException unused2) {
        }
        long dumpAppCPUTime2 = PerfMonitorManager.getInstance().dumpAppCPUTime();
        double d = PerfMonitorManager.getInstance().dumpTotalCPUTimeByTimeInStat(cpuCoreNum) - dumpTotalCPUTimeByTimeInStat > 0 ? (((float) dumpAppCPUTime2) - ((float) dumpAppCPUTime)) / ((float) r10) : -1.0d;
        cpuInfo.cpuAppRate = d;
        cpuInfo.cpuAppSpeed = (((dumpAppCPUTime2 - dumpAppCPUTime) * 1000.0d) / (System.currentTimeMillis() - currentTimeMillis)) / CommonMonitorUtil.getScClkTck(100L);
        return cpuInfo;
    }

    public Pair<Long, LinkedList<ICpuDataService.ThreadCpuItem>> getThreadList() {
        return CurrentCpuDataHolder.getInstance().getThreadList();
    }

    public Pair<Long, LinkedList<ICpuDataService.ThreadCpuItem>> getExceptionThreadList() {
        return CurrentCpuDataHolder.getInstance().getExceptionThreadList();
    }

    public String getCpuSceneString() {
        String arrayToString = ListUtils.arrayToString(this.mSceneSet.toArray(), "#");
        return !TextUtils.isEmpty(arrayToString) ? arrayToString : "";
    }

    public CopyOnWriteArraySet<String> getCpuSceneSet() {
        return this.mSceneSet;
    }
}
