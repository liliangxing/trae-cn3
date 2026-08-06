package com.bytedance.apm6.hub.config;

import com.bytedance.apm.entity.UploadInfo;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.p005fd.Constants;
import com.bytedance.apm6.p005fd.FdCollector;
import com.bytedance.apm6.p005fd.config.FdConfig;
import com.bytedance.apm6.p005fd.config.IFdConfigService;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FdConfigManager implements IFdConfigService {
    private static final String PERF_FD_KEY_COUNT_THRESHOLD = "fd_count_threshold";
    private static final String PERF_KEY_FD = "fd";
    private FdConfig config;

    public FdConfigManager() {
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "FdConfigManager:");
        }
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new IConfigChangeListener() { // from class: com.bytedance.apm6.hub.config.FdConfigManager.1
            @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
            public void onConfigChanged(JSONObject jSONObject, boolean z) {
                FdConfigManager.this.parseConfig(jSONObject, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseConfig(JSONObject jSONObject, boolean z) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("performance_modules");
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "parseConfig:" + optJSONObject2);
        }
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("fd")) == null) {
            return;
        }
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "parseConfig:" + optJSONObject);
        }
        boolean z2 = optJSONObject.optInt("enable_upload", 0) == 1;
        long optInt = optJSONObject.optInt("fd_count_threshold", FdConfig.DEFAULT_FD_COUNT_THRESHOLD);
        long optLong = optJSONObject.optLong("collect_interval", 10L) * 60000;
        if (optLong < 10) {
            optLong = UploadInfo.DEFAULT_SEND_DURATION;
        }
        FdConfig fdConfig = new FdConfig(optInt, optLong, z2);
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "parseConfig:" + fdConfig);
        }
        this.config = fdConfig;
        FdCollector.getInstance().updateConfig(fdConfig);
    }

    @Override // com.bytedance.apm6.p005fd.config.IFdConfigService
    public FdConfig getConfig() {
        return this.config;
    }
}
