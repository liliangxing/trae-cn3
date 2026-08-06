package com.bytedance.apm.battery.stats;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.internal.BatteryDataManager;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbsBatteryValueStats implements IBatteryStats {
    private final String mType;
    private final boolean mainProcess = ApmContext.isMainProcess();
    volatile boolean mIsFront = ActivityLifeObserver.getInstance().isForeground();
    volatile boolean mIsCharging = BatteryUtils.isCharging(ApmContext.getContext());

    protected abstract void computeValue(boolean z, boolean z2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsBatteryValueStats(String str) {
        this.mType = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isMainProcess() {
        return this.mainProcess;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onFront(boolean z) {
        computeValue(this.mIsFront, z);
        this.mIsFront = true;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onBack(boolean z) {
        computeValue(this.mIsFront, z);
        this.mIsFront = false;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onTimer(boolean z) {
        computeValue(this.mIsFront, z);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onChargeStatusChange(boolean z, boolean z2) {
        computeValue(this.mIsFront, z2);
        this.mIsCharging = z;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void startSceneMonitor(String str, boolean z) {
        computeValue(this.mIsFront, z);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void stopSceneMonitor(String str, boolean z) {
        computeValue(this.mIsFront, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveData(boolean z, long j, String str) {
        if (j < 0) {
            if (ApmContext.isDebugMode()) {
                Logger.m88i(DebugLogger.TAG_BATTERY, "AbsBatteryValueStats value error: " + j + " type:" + this.mType);
            }
            ApmAlogHelper.m77i(Constants.TAG_BATTERY, "AbsBatteryValueStats value error: " + j + " type:" + this.mType);
            return;
        }
        BatteryDataManager.getInstance().record(new BatteryLogEntity(z, System.currentTimeMillis(), this.mType, this.mIsCharging, j, str));
    }
}
