package com.bytedance.apm.battery;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.AppUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryWidget {
    public static void initBatteryEnergy() {
        if (AppUtils.isMainProcess(ApmContext.getContext())) {
            BatteryEnergyCollector.getInstance().init();
        }
        new BatteryEnergyTimerCollector().init();
    }

    public static void initBatteryCollector(boolean z) {
        BatteryCollector.getInstance().init(z);
    }

    public static void initPower() {
        if (AppUtils.isMainProcess(ApmContext.getContext())) {
            ProcessEnergyCollector.getInstance().init();
        }
    }

    public static void initBatteryTemperature(boolean z) {
        if (AppUtils.isMainProcess(ApmContext.getContext())) {
            BatteryTemperatureCollector.getInstance().init(z);
        }
    }
}
