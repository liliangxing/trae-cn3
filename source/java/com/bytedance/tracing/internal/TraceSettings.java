package com.bytedance.tracing.internal;

import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class TraceSettings implements IConfigListener {
    private static volatile TraceSettings singleton;
    private JSONObject allowJsonList;
    private boolean enable = true;
    private JSONObject errorJsonList;
    private boolean settingReady;

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
    }

    private TraceSettings() {
    }

    public static TraceSettings getInstance() {
        if (singleton == null) {
            synchronized (TraceSettings.class) {
                if (singleton == null) {
                    singleton = new TraceSettings();
                    ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(singleton);
                }
            }
        }
        return singleton;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject jSONObject, boolean z) {
        this.enable = JsonUtils.optBoolean(jSONObject, "tracing", SlardarSettingsConsts.SETTING_TRACING_ENABLE, true);
        if (this.settingReady) {
            return;
        }
        this.allowJsonList = JsonUtils.optJSONObject(jSONObject, "tracing", SlardarSettingsConsts.SETTING_TRACING_ALLOW_LIST);
        this.errorJsonList = JsonUtils.optJSONObject(jSONObject, "tracing", SlardarSettingsConsts.SETTING_TRACING_ERROR_LIST);
        this.settingReady = true;
    }

    public int isErrorOrSampleHit(boolean z, String str) {
        JSONObject jSONObject;
        int i = 0;
        if (!this.enable) {
            return 0;
        }
        if (z && ((jSONObject = this.errorJsonList) == null || jSONObject.optDouble(str, -1.0d) > 0.0d)) {
            i = 16;
        }
        JSONObject jSONObject2 = this.allowJsonList;
        return (jSONObject2 == null || jSONObject2.optDouble(str, -1.0d) <= 0.0d) ? i : i | 1;
    }

    public double getSampleRate(String str) {
        JSONObject jSONObject = this.allowJsonList;
        if (jSONObject == null) {
            return 0.0d;
        }
        double optDouble = jSONObject.optDouble(str);
        if (Double.isNaN(optDouble)) {
            return 0.0d;
        }
        return optDouble;
    }
}
