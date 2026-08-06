package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.java_alloc.JavaAllocCollector;
import com.bytedance.apm6.java_alloc.JavaAllocConfig;
import com.bytedance.apm6.java_alloc.JavaAllocConfigService;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class JavaAllocConfigManager implements JavaAllocConfigService {
    private JavaAllocConfig config;

    public JavaAllocConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new IConfigChangeListener() { // from class: com.bytedance.apm6.hub.config.JavaAllocConfigManager.1
            @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
            public void onConfigChanged(JSONObject jSONObject, boolean z) {
                JavaAllocConfigManager.this.parseConfig(jSONObject, z);
            }
        });
    }

    @Override // com.bytedance.apm6.java_alloc.JavaAllocConfigService
    public JavaAllocConfig getConfig() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseConfig(JSONObject jSONObject, boolean z) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("performance_modules");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("memory")) == null) {
            return;
        }
        this.config = new JavaAllocConfig(optJSONObject.optInt(JavaAllocConfig.KEY_CONF_COLLECT, 0) == 1, optJSONObject.optInt(JavaAllocConfig.KEY_CONF_UPLOAD, 0) == 1, optJSONObject.optInt(JavaAllocConfig.KEY_CONF_COLLECT_PER_THOUSAND_ALLOC, 0), optJSONObject.optInt(JavaAllocConfig.KEY_CONF_DUMP_PER_THOUSAND_COLLECT, 0), optJSONObject.optInt(JavaAllocConfig.KEY_CONF_THRESHOLD_ALLOC_FREQ, 0), optJSONObject.optLong(JavaAllocConfig.KEY_CONF_THRESHOLD_ALLOC_SIZE, 0L));
        if (ApmContext.isDebugMode()) {
            Logger.m119d(ConfigConstants.LOG_TAG, "parsed JavaAllocConfig=" + this.config);
        }
        JavaAllocCollector.getInstance().updateConfig(getConfig());
    }
}
