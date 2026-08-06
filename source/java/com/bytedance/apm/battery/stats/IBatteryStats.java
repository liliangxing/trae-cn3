package com.bytedance.apm.battery.stats;

import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.entity.BatteryLogEntity;

/* loaded from: classes3.dex */
public interface IBatteryStats {
    void onBack(boolean z);

    void onChargeStatusChange(boolean z, boolean z2);

    void onFront(boolean z);

    void onTimer(boolean z);

    void startSceneMonitor(String str, boolean z);

    void stopSceneMonitor(String str, boolean z);

    void updateStatsRet(BatteryStatsRet batteryStatsRet, BatteryLogEntity batteryLogEntity);
}
