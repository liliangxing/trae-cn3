package com.bytedance.apm.battery.stats;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.traffic.TrafficStatisticWrapper;
import com.bytedance.services.apm.api.EnsureManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryPacketsStatsImpl extends AbsBatteryValueStats {
    private volatile long mLastBackPackets;
    private volatile long mLastFrontPackets;
    private TrafficStatisticWrapper mTrafficStatisticWrapper;

    public BatteryPacketsStatsImpl() {
        super(BatteryTypeInf.BATTERY_PACKETS);
        this.mLastFrontPackets = -1L;
        this.mLastBackPackets = -1L;
        this.mTrafficStatisticWrapper = TrafficStatisticWrapper.getInstance();
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryValueStats
    protected void computeValue(boolean z, boolean z2) {
        if (isMainProcess()) {
            try {
                handlePacketsMonitor(z2);
            } catch (Throwable th) {
                if (ApmContext.isDebugMode()) {
                    Logger.m88i(DebugLogger.TAG_BATTERY, "handleTrafficMonitor error: " + th.getCause());
                }
                EnsureManager.ensureNotReachHere(th, "BatteryPacketsStatsImpl");
            }
        }
    }

    private void handlePacketsMonitor(boolean z) {
        long frontPackets = this.mTrafficStatisticWrapper.getFrontPackets();
        long backPackets = this.mTrafficStatisticWrapper.getBackPackets();
        if (this.mLastBackPackets > -1 && this.mLastFrontPackets > -1 && z) {
            String curSceneSetStr = BatteryCollector.getInstance().getCurSceneSetStr();
            saveData(true, frontPackets - this.mLastFrontPackets, curSceneSetStr);
            saveData(false, backPackets - this.mLastBackPackets, curSceneSetStr);
        }
        this.mLastFrontPackets = frontPackets;
        this.mLastBackPackets = backPackets;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet batteryStatsRet, BatteryLogEntity batteryLogEntity) {
        if (batteryLogEntity.isFront()) {
            batteryStatsRet.addFrontTrafficPackets(batteryLogEntity.getAccumulation());
        } else {
            batteryStatsRet.addBackTrafficPackets(batteryLogEntity.getAccumulation());
        }
    }
}
