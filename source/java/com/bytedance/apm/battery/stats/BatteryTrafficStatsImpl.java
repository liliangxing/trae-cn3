package com.bytedance.apm.battery.stats;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.traffic.TrafficStatisticWrapper;
import com.bytedance.services.apm.api.EnsureManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryTrafficStatsImpl extends AbsBatteryValueStats {
    private volatile long mLastBackBytes;
    private volatile long mLastFrontBytes;
    private TrafficStatisticWrapper mTrafficStatisticWrapper;

    public BatteryTrafficStatsImpl() {
        super("traffic");
        this.mLastFrontBytes = -1L;
        this.mLastBackBytes = -1L;
        this.mTrafficStatisticWrapper = TrafficStatisticWrapper.getInstance();
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryValueStats
    protected void computeValue(boolean z, boolean z2) {
        if (isMainProcess()) {
            try {
                handleTrafficMonitor(z2);
            } catch (Throwable th) {
                if (ApmContext.isDebugMode()) {
                    Logger.m88i(DebugLogger.TAG_BATTERY, "handleTrafficMonitor error: " + th.getCause());
                }
                EnsureManager.ensureNotReachHere(th, "BatteryTrafficStatsImpl");
            }
        }
    }

    private void handleTrafficMonitor(boolean z) {
        long frontBytes = this.mTrafficStatisticWrapper.getFrontBytes();
        long backBytes = this.mTrafficStatisticWrapper.getBackBytes();
        if (this.mLastBackBytes > -1 && this.mLastFrontBytes > -1 && z) {
            String curSceneSetStr = BatteryCollector.getInstance().getCurSceneSetStr();
            saveData(true, frontBytes - this.mLastFrontBytes, curSceneSetStr);
            saveData(false, backBytes - this.mLastBackBytes, curSceneSetStr);
        }
        this.mLastFrontBytes = frontBytes;
        this.mLastBackBytes = backBytes;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet batteryStatsRet, BatteryLogEntity batteryLogEntity) {
        if (batteryLogEntity.isFront()) {
            batteryStatsRet.addFrontTrafficBytes(batteryLogEntity.getAccumulation());
        } else {
            batteryStatsRet.addBackTrafficBytes(batteryLogEntity.getAccumulation());
        }
    }
}
