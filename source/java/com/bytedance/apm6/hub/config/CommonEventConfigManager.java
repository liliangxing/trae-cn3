package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.commonevent.config.CommonEventConfig;
import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.util.log.Logger;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CommonEventConfigManager implements CommonEventConfigService {
    private static final String BASE_KEY_ALLOW_SERVICE_NAME = "allow_service_name";
    private volatile CommonEventConfig config;

    public CommonEventConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new IConfigChangeListener() { // from class: com.bytedance.apm6.hub.config.CommonEventConfigManager.1
            @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
            public void onConfigChanged(JSONObject jSONObject, boolean z) {
                CommonEventConfigManager.this.parseConfig(jSONObject, z);
            }
        });
    }

    @Override // com.bytedance.apm6.commonevent.config.CommonEventConfigService
    public CommonEventConfig getConfig() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseConfig(JSONObject jSONObject, boolean z) {
        JSONObject optJSONObject = jSONObject.optJSONObject("custom_event_settings");
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("allow_service_name");
            HashSet hashSet = new HashSet();
            if (optJSONObject2 != null) {
                Iterator<String> keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    hashSet.add(keys.next());
                }
            }
            HashSet hashSet2 = new HashSet();
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("allow_log_type");
            if (optJSONObject3 != null) {
                Iterator<String> keys2 = optJSONObject3.keys();
                while (keys2.hasNext()) {
                    String next = keys2.next();
                    if (optJSONObject3.optInt(next) == 1) {
                        hashSet2.add(next);
                    }
                }
            }
            this.config = new CommonEventConfig(hashSet, hashSet2);
            if (ApmContext.isDebugMode()) {
                Logger.m119d(ConfigConstants.LOG_TAG, "received customEventSettings=" + optJSONObject);
                Logger.m119d(ConfigConstants.LOG_TAG, "parsed CommonEventConfig=" + this.config);
            }
            CommonEventDeliverer.updateConfig(getConfig());
        }
    }
}
