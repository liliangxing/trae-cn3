package com.bytedance.push.settings.client.intelligence;

import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.common.push.BaseJson;
import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ClientIntelligenceSettingsConverter extends BaseJson implements ITypeConverter<ClientIntelligenceSettingsModel>, IDefaultValueProvider<ClientIntelligenceSettingsModel> {
    private final String KEY_ENABLE_FEATURE_REPORT = "enable_feature_report";
    private final String KEY_ALLOW_COLLECT_CLIENT_FEATURE = "allow_collect_client_feature";
    private final String KEY_ENABLE_CLIENT_INTELLIGENCE_PUSH_SHOW = "enable_client_intelligence_push_show";
    private final String KEY_FEATURE_COLLECT_TIME_OUT_IN_MILL = "feature_collect_time_out_in_mill";
    private final String KEY_CHECK_CLIENT_FEATURE_INTERVAL_IN_MILL = "check_client_feature_interval_in_mill";
    private final String KEY_MAX_SHOW_DELAY_TIME_IN_MILL = "max_show_delay_time_in_mill";
    private final String KEY_MIN_MESSAGE_SHOW_INTERVAL_IN_MILL = "min_message_show_interval_in_mill";
    private final String KEY_MAX_NUMBER_OF_MESSAGE_SHOW_AT_THE_SAME_TIME = "max_number_of_message_show_at_the_same_time";
    private final String KEY_CLIENT_INTELLIGENCE_PUSH_SHOW_MODE = "client_intelligence_push_show_mode";
    private final String KEY_CLIENT_INTELLIGENCE_PUSH_SHOW_SUB_MODE = "client_intelligence_push_show_sub_mode";
    private final String KEY_MAX_NUMBER_OF_ALLOW_CACHE = "max_number_of_allow_cache";
    private final String KEY_IMPROVE_PUSH_ARRIVAL_RATE = "improve_push_arrival_rate";
    private final String KEY_MIN_INTERVAL_FROM_LAUNCH_IN_MILL = "min_interval_from_launch_in_mill";
    private final String KEY_ALLOW_COLLECT_FEATURE_SCENE = "allow_collect_feature_scene";
    private final String KEY_LOCAL_PUSH = IAllianceService.CONTENT_TYPE_LOCAL_PUSH;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public ClientIntelligenceSettingsModel to(String str) {
        ClientIntelligenceSettingsModel create = create();
        try {
            JSONObject jSONObject = new JSONObject(str);
            create.enableClientFeatureReport = jSONObject.optBoolean("enable_feature_report");
            create.allowCollectClientFeature = jSONObject.optBoolean("allow_collect_client_feature");
            create.enableClientIntelligencePushShow = jSONObject.optBoolean("enable_client_intelligence_push_show");
            create.featureCollectTimeOutInMill = jSONObject.optLong("feature_collect_time_out_in_mill");
            create.checkClientFeatureIntervalInMill = jSONObject.optLong("check_client_feature_interval_in_mill");
            create.maxShowDelayTimeInMill = jSONObject.optLong("max_show_delay_time_in_mill");
            create.minMessageShowIntervalInMill = jSONObject.optLong("min_message_show_interval_in_mill");
            create.minIntervalFromLaunchInMill = jSONObject.optLong("min_interval_from_launch_in_mill");
            create.maxNumberOfMessageShowAtTheSameTime = jSONObject.optInt("max_number_of_message_show_at_the_same_time");
            create.clientIntelligencePushShowMode = jSONObject.optInt("client_intelligence_push_show_mode", 1);
            create.clientIntelligencePushShowSubMode = jSONObject.optInt("client_intelligence_push_show_sub_mode", 0);
            create.maxNumberOfAllowCache = jSONObject.optInt("max_number_of_allow_cache");
            create.improvePushArrivalRate = jSONObject.optBoolean("improve_push_arrival_rate");
            JSONArray optJSONArray = jSONObject.optJSONArray("allow_collect_feature_scene");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    create.allowFeatureCollectScene.add(optJSONArray.getString(i));
                }
            }
            create.localPushClientIntelligenceSettingsModel = new LocalPushClientIntelligenceSettingsModel(jSONObject.optJSONObject(IAllianceService.CONTENT_TYPE_LOCAL_PUSH));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return create;
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(ClientIntelligenceSettingsModel clientIntelligenceSettingsModel) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enable_feature_report", clientIntelligenceSettingsModel.enableClientFeatureReport);
            jSONObject.put("allow_collect_client_feature", clientIntelligenceSettingsModel.allowCollectClientFeature);
            jSONObject.put("enable_client_intelligence_push_show", clientIntelligenceSettingsModel.enableClientIntelligencePushShow);
            jSONObject.put("feature_collect_time_out_in_mill", clientIntelligenceSettingsModel.featureCollectTimeOutInMill);
            jSONObject.put("check_client_feature_interval_in_mill", clientIntelligenceSettingsModel.checkClientFeatureIntervalInMill);
            jSONObject.put("max_show_delay_time_in_mill", clientIntelligenceSettingsModel.maxShowDelayTimeInMill);
            jSONObject.put("min_message_show_interval_in_mill", clientIntelligenceSettingsModel.minMessageShowIntervalInMill);
            jSONObject.put("max_number_of_message_show_at_the_same_time", clientIntelligenceSettingsModel.maxNumberOfMessageShowAtTheSameTime);
            jSONObject.put("client_intelligence_push_show_mode", clientIntelligenceSettingsModel.clientIntelligencePushShowMode);
            jSONObject.put("client_intelligence_push_show_sub_mode", clientIntelligenceSettingsModel.clientIntelligencePushShowSubMode);
            jSONObject.put("max_number_of_allow_cache", clientIntelligenceSettingsModel.maxNumberOfAllowCache);
            jSONObject.put("improve_push_arrival_rate", clientIntelligenceSettingsModel.improvePushArrivalRate);
            jSONObject.put("min_interval_from_launch_in_mill", clientIntelligenceSettingsModel.minIntervalFromLaunchInMill);
            jSONObject.put(IAllianceService.CONTENT_TYPE_LOCAL_PUSH, clientIntelligenceSettingsModel.localPushClientIntelligenceSettingsModel.toJson());
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = clientIntelligenceSettingsModel.allowFeatureCollectScene.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("allow_collect_feature_scene", jSONArray);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public ClientIntelligenceSettingsModel create() {
        return new ClientIntelligenceSettingsModel();
    }
}
