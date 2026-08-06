package com.bytedance.apm.battery.stats;

import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.util.CommonMonitorUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryCpuStatsImpl extends AbsBatteryValueStats {
    private long mLastCpuActiveTime;

    public BatteryCpuStatsImpl() {
        super(BatteryTypeInf.BATTERY_CPU_ACTIVE);
        this.mLastCpuActiveTime = 0L;
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryValueStats
    protected void computeValue(boolean z, boolean z2) {
        long appCPUTime = CommonMonitorUtil.getAppCPUTime();
        long j = this.mLastCpuActiveTime;
        if (j > 0 && z2) {
            long j2 = appCPUTime - j;
            if (j2 > 0) {
                saveData(z, j2, BatteryCollector.getInstance().getCurSceneSetStr());
            } else {
                ApmAlogHelper.m77i(Constants.TAG_BATTERY, "CPU Value:" + j2);
            }
        }
        this.mLastCpuActiveTime = appCPUTime;
    }

    private long getJiffyHz() {
        return CommonMonitorUtil.getScClkTck(100L);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet batteryStatsRet, BatteryLogEntity batteryLogEntity) {
        if (batteryLogEntity.isFront()) {
            batteryStatsRet.addFrontCpuMs((long) ((batteryLogEntity.getAccumulation() / getJiffyHz()) * 1000.0d));
        } else {
            batteryStatsRet.addBackCpuMs((long) ((batteryLogEntity.getAccumulation() / getJiffyHz()) * 1000.0d));
        }
    }
}
