package com.bytedance.apm;

import com.bytedance.apm.block.EvilMethodSwitchManager;
import com.bytedance.apm.block.FluencyMonitor;
import com.bytedance.apm.block.StackThread;
import com.bytedance.apm.config.FluencyConfig;
import com.bytedance.apm.config.FluencyConfigService;
import com.bytedance.apm6.service.ServiceManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FluencyMonitorManager {
    private FluencyMonitorManager() {
        ServiceManager.getService(FluencyConfigService.class);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static final class SingletonHolder {
        private static final FluencyMonitorManager instance = new FluencyMonitorManager();

        private SingletonHolder() {
        }
    }

    public static FluencyMonitorManager getInstance() {
        return SingletonHolder.instance;
    }

    public void init() {
        ServiceManager.getService(FluencyConfigService.class);
    }

    public void updateConfig(FluencyConfig fluencyConfig) {
        if (fluencyConfig == null) {
            return;
        }
        StackThread.setEvilThresholdMs(fluencyConfig.getSlowMethodDropThreshold());
        FluencyMonitor.getInstance().onReady();
        FluencyMonitor.getInstance().onRefresh(fluencyConfig.getBlockMonitorMode(), false);
        FluencySwitchManager.notify(fluencyConfig);
        EvilMethodSwitchManager.notify(fluencyConfig.isDropSlowMethodSwitch(), fluencyConfig.getSlowMethodDropThreshold());
    }
}
