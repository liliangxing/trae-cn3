package com.bytedance.apm6;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm6.hub.config.MemoryConfigManager;
import com.bytedance.apm6.memory.config.MemoryConfig;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
class DefaultMemoryConfigService extends MemoryConfigManager {
    @Override // com.bytedance.apm6.hub.config.MemoryConfigManager, com.bytedance.apm6.memory.config.MemoryConfigService
    public MemoryConfig getConfig() {
        MemoryConfig config = super.getConfig();
        if (config != null) {
            config.setRealTimeMemEnable(ApmContext.isDeviceInfoOnPerfDataEnabled());
            config.setStopWhenBackground(ApmContext.isStopWhenBackground());
        }
        return config;
    }
}
