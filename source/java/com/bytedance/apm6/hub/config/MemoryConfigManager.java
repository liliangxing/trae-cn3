package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.memory.MemoryCollector;
import com.bytedance.apm6.memory.config.MemoryConfig;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MemoryConfigManager implements MemoryConfigService {
    private static final String PERF_KEY_COLLECT_INTERVAL = "collect_interval";
    private static final String PERF_MEMORY_REACHTOP_RATE = "reach_top_memory_rate";
    private MemoryConfig config;

    public MemoryConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new IConfigChangeListener() { // from class: com.bytedance.apm6.hub.config.MemoryConfigManager.1
            @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
            public void onConfigChanged(JSONObject jSONObject, boolean z) {
                MemoryConfigManager.this.parseConfig(jSONObject, z);
            }
        });
    }

    @Override // com.bytedance.apm6.memory.config.MemoryConfigService
    public MemoryConfig getConfig() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseConfig(JSONObject jSONObject, boolean z) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("performance_modules");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("memory")) == null) {
            return;
        }
        this.config = new MemoryConfig(optJSONObject.optLong("collect_interval", 120L), optJSONObject.optDouble("reach_top_memory_rate", 0.8d), false, false, optJSONObject.optInt("enable_upload", 0) == 1, optJSONObject.optInt(SlardarSettingsConstants.PERF_MEMORY_CLOSE_COLLECT) != 1);
        if (ApmContext.isDebugMode()) {
            Logger.m119d(ConfigConstants.LOG_TAG, "parsed MemoryConfig=" + this.config);
        }
        MemoryCollector.getInstance().updateConfig(getConfig());
    }
}
