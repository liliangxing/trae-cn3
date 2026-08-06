package com.bytedance.apm6.cpu.collect;

import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.collect.CpuCacheItem;
import com.bytedance.apm6.cpu.config.CpuConfig;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.lifecycle.DummyLifecycleListener;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.watson.assist.api.IAssistStat;
import com.ss.thor.ThorUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CpuDataAssembler extends DummyLifecycleListener {
    private IAssistStat assistStat;
    private CpuConfig mConfig;
    private AtomicBoolean mIsStart = new AtomicBoolean(false);
    private HashMap<String, CpuCacheItem> mTimerInfoBack;
    private HashMap<String, CpuCacheItem> mTimerInfoFore;
    private HashMap<String, CpuCacheItem> mTimerInfoMix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CpuDataAssembler(IAssistStat iAssistStat) {
        this.assistStat = iAssistStat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start(CpuConfig cpuConfig) {
        if (this.mIsStart.compareAndSet(false, true)) {
            this.mTimerInfoMix = new HashMap<>();
            this.mTimerInfoFore = new HashMap<>();
            this.mTimerInfoBack = new HashMap<>();
            this.mConfig = cpuConfig;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        if (this.mIsStart.compareAndSet(false, true)) {
            this.mTimerInfoMix = new HashMap<>();
            this.mTimerInfoFore = new HashMap<>();
            this.mTimerInfoBack = new HashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        if (this.mIsStart.compareAndSet(true, false)) {
            synchronized (CpuDataAssembler.class) {
                this.mTimerInfoFore.clear();
                this.mTimerInfoBack.clear();
                this.mTimerInfoMix.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStart() {
        return this.mIsStart.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addCacheData(double d, double d2) {
        if (this.mIsStart.get()) {
            String str = PerfFilterManager.getInstance().getSceneString();
            if (ApmContext.isDebugMode()) {
                Logger.m119d(Constants.TAG, str);
            }
            synchronized (CpuDataAssembler.class) {
                CpuCacheItem.CpuDataType cpuDataType = CpuCollectManager.getInstance().isFront() ? CpuCacheItem.CpuDataType.FRONT : CpuCacheItem.CpuDataType.BACK;
                CpuCacheItem refreshCpuCacheItem = refreshCpuCacheItem(cpuDataType, getCacheItem(cpuDataType, str), d, d2);
                addCacheItem(cpuDataType, str, refreshCpuCacheItem);
                if (ApmContext.isDebugMode()) {
                    Logger.m119d(Constants.TAG, "after add cache data: " + refreshCpuCacheItem);
                }
                addCacheItem(CpuCacheItem.CpuDataType.MIX, str, refreshCpuCacheItem(CpuCacheItem.CpuDataType.MIX, getCacheItem(CpuCacheItem.CpuDataType.MIX, str), d, d2));
            }
        }
    }

    private static CpuCacheItem refreshCpuCacheItem(CpuCacheItem.CpuDataType cpuDataType, CpuCacheItem cpuCacheItem, double d, double d2) {
        if (cpuCacheItem == null) {
            cpuCacheItem = new CpuCacheItem(cpuDataType, System.currentTimeMillis());
            cpuCacheItem.injectScene(PerfFilterManager.getInstance().getSceneString());
        }
        if (d >= 0.0d || d2 >= 0.0d) {
            cpuCacheItem.addTimes();
        }
        cpuCacheItem.addSpeed(d2);
        cpuCacheItem.addRate(d);
        cpuCacheItem.refreshMaxRate(d);
        cpuCacheItem.refreshMaxSpeed(d2);
        return cpuCacheItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.apm6.cpu.collect.CpuDataAssembler$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static /* synthetic */ class C03371 {

        /* renamed from: $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType */
        static final /* synthetic */ int[] f46x79a0b75b;

        static {
            int[] iArr = new int[CpuCacheItem.CpuDataType.values().length];
            f46x79a0b75b = iArr;
            try {
                iArr[CpuCacheItem.CpuDataType.MIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46x79a0b75b[CpuCacheItem.CpuDataType.BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46x79a0b75b[CpuCacheItem.CpuDataType.FRONT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void addCacheItem(CpuCacheItem.CpuDataType cpuDataType, String str, CpuCacheItem cpuCacheItem) {
        int i = C03371.f46x79a0b75b[cpuDataType.ordinal()];
        if (i == 1) {
            this.mTimerInfoMix.put(str, cpuCacheItem);
        } else if (i == 2) {
            this.mTimerInfoBack.put(str, cpuCacheItem);
        } else {
            if (i != 3) {
                return;
            }
            this.mTimerInfoFore.put(str, cpuCacheItem);
        }
    }

    private CpuCacheItem getCacheItem(CpuCacheItem.CpuDataType cpuDataType, String str) {
        int i = C03371.f46x79a0b75b[cpuDataType.ordinal()];
        if (i == 1) {
            return this.mTimerInfoMix.get(str);
        }
        if (i == 2) {
            return this.mTimerInfoBack.get(str);
        }
        if (i != 3) {
            return null;
        }
        return this.mTimerInfoFore.get(str);
    }

    public void triggerAssemble(IAssistStat.CpuFactorTag cpuFactorTag) {
        if (this.mIsStart.get()) {
            synchronized (CpuDataAssembler.class) {
                doAssemble(CpuCacheItem.CpuDataType.FRONT, cpuFactorTag);
                doAssemble(CpuCacheItem.CpuDataType.BACK, cpuFactorTag);
                doAssemble(CpuCacheItem.CpuDataType.MIX, cpuFactorTag);
            }
        }
    }

    private void doAssemble(CpuCacheItem.CpuDataType cpuDataType, IAssistStat.CpuFactorTag cpuFactorTag) {
        Iterator<Map.Entry<String, CpuCacheItem>> it;
        long currentTimeMillis = System.currentTimeMillis();
        int i = C03371.f46x79a0b75b[cpuDataType.ordinal()];
        if (i == 1) {
            it = this.mTimerInfoMix.entrySet().iterator();
        } else if (i == 2) {
            it = this.mTimerInfoBack.entrySet().iterator();
        } else {
            it = i != 3 ? null : this.mTimerInfoFore.entrySet().iterator();
        }
        Iterator<Map.Entry<String, CpuCacheItem>> it2 = it;
        if (it2 == null) {
            return;
        }
        while (it2.hasNext()) {
            CpuCacheItem value = it2.next().getValue();
            if (currentTimeMillis - value.getFirstTs() > this.mConfig.getMonitorInterval()) {
                it2.remove();
                double metricRate = value.getMetricRate() / value.getTimes();
                double metricMaxRate = value.getMetricMaxRate();
                double metricCpuSpeed = value.getMetricCpuSpeed() / value.getTimes();
                double metricMaxCpuSpeed = value.getMetricMaxCpuSpeed();
                if (ApmContext.isDebugMode()) {
                    Logger.m119d(Constants.TAG, "cpu cache item: " + value);
                    Logger.m119d(Constants.TAG, "assemble cpu data, type: " + cpuDataType + " rate: " + metricRate + " maxRate: " + metricMaxRate + " speed: " + metricCpuSpeed + " maxSpeed: " + metricMaxCpuSpeed);
                }
                doReport(cpuDataType, value.getSceneString(), metricRate, metricMaxRate, metricCpuSpeed, metricMaxCpuSpeed, cpuFactorTag);
            }
        }
    }

    private void doReport(CpuCacheItem.CpuDataType cpuDataType, String str, double d, double d2, double d3, double d4, IAssistStat.CpuFactorTag cpuFactorTag) {
        CpuReportEvent cpuReportEvent = new CpuReportEvent(cpuDataType, str, d, d2, d3, d4, cpuFactorTag);
        cpuReportEvent.setBatteryCurrent(ThorUtils.getGalvanicNow(ApmContext.getContext()));
        try {
            cpuReportEvent.setNormalSampleState(this.assistStat.isCpuSampleEnvironment());
        } catch (Throwable unused) {
        }
        Monitor.record(cpuReportEvent);
    }
}
