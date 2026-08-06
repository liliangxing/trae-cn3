package com.bytedance.apm.battery.stats;

import android.os.BatteryManager;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.services.apm.api.EnsureManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryConsumeStatsImpl extends AbsBatteryValueStats {
    private boolean hasFirstData;
    private final BatteryManager mBatterManager;
    private int mLastBatteryCapacity;

    public BatteryConsumeStatsImpl() {
        super(BatteryTypeInf.BATTERY_CONSUME);
        this.hasFirstData = false;
        this.mLastBatteryCapacity = -1;
        this.mBatterManager = (BatteryManager) ApmContext.getContext().getSystemService("batterymanager");
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryValueStats
    protected void computeValue(boolean z, boolean z2) {
        boolean z3;
        if (isMainProcess()) {
            if (z) {
                try {
                    if (!this.mIsCharging) {
                        z3 = false;
                        handleBatteryConsumeMonitor(z2, z3);
                    }
                } catch (Throwable th) {
                    if (ApmContext.isDebugMode()) {
                        Logger.m88i(DebugLogger.TAG_BATTERY, "BatteryConsumeStatsImpl error: " + th.getCause());
                    }
                    EnsureManager.ensureNotReachHere("BatteryConsumeStatsImpl");
                    return;
                }
            }
            z3 = true;
            handleBatteryConsumeMonitor(z2, z3);
        }
    }

    private void handleBatteryConsumeMonitor(boolean z, boolean z2) {
        int intProperty = this.mBatterManager.getIntProperty(1);
        if (!z2 && z && this.hasFirstData) {
            saveData(true, Math.abs(intProperty - this.mLastBatteryCapacity), BatteryCollector.getInstance().getCurSceneSetStr());
        }
        this.mLastBatteryCapacity = intProperty;
        this.hasFirstData = true;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet batteryStatsRet, BatteryLogEntity batteryLogEntity) {
        batteryStatsRet.addBatteryConsume(batteryLogEntity.getAccumulation() / 1000);
    }
}
