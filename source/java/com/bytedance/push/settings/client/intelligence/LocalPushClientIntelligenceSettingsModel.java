package com.bytedance.push.settings.client.intelligence;

import com.bytedance.common.push.BaseJson;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class LocalPushClientIntelligenceSettingsModel extends BaseJson {
    private final String KEY_CHECK_CLIENT_FEATURE_INTERVAL_IN_MILL;
    private final String KEY_ENABLE_CLIENT_INTELLIGENCE_LOCAL_PUSH;
    private final String KEY_MAX_TRY_PULL_TIMES;
    public int checkClientFeatureIntervalInMill;
    public boolean enableClientIntelligenceLocalPush;
    public int maxTryPullTimes;

    public LocalPushClientIntelligenceSettingsModel() {
        this.KEY_ENABLE_CLIENT_INTELLIGENCE_LOCAL_PUSH = "enable_client_intelligence_local_push";
        this.KEY_MAX_TRY_PULL_TIMES = "max_try_pull_times";
        this.KEY_CHECK_CLIENT_FEATURE_INTERVAL_IN_MILL = "check_client_feature_interval_in_mill";
        this.enableClientIntelligenceLocalPush = false;
        this.maxTryPullTimes = 5;
        this.checkClientFeatureIntervalInMill = 5000;
    }

    public LocalPushClientIntelligenceSettingsModel(JSONObject jSONObject) {
        this.KEY_ENABLE_CLIENT_INTELLIGENCE_LOCAL_PUSH = "enable_client_intelligence_local_push";
        this.KEY_MAX_TRY_PULL_TIMES = "max_try_pull_times";
        this.KEY_CHECK_CLIENT_FEATURE_INTERVAL_IN_MILL = "check_client_feature_interval_in_mill";
        if (jSONObject == null) {
            this.enableClientIntelligenceLocalPush = false;
            this.maxTryPullTimes = 5;
            this.checkClientFeatureIntervalInMill = 5000;
        } else {
            this.enableClientIntelligenceLocalPush = jSONObject.optBoolean("enable_client_intelligence_local_push", false);
            this.maxTryPullTimes = jSONObject.optInt("max_try_pull_times", 5);
            this.checkClientFeatureIntervalInMill = jSONObject.optInt("check_client_feature_interval_in_mill", 5000);
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "enable_client_intelligence_local_push", this.enableClientIntelligenceLocalPush);
        add(jSONObject, "max_try_pull_times", this.maxTryPullTimes);
        add(jSONObject, "check_client_feature_interval_in_mill", this.checkClientFeatureIntervalInMill);
        return jSONObject;
    }
}
