package com.bytedance.push.settings.statistics;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class StatisticsSettingsConverter implements ITypeConverter<StatisticsSettingsModel>, IDefaultValueProvider<StatisticsSettingsModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public StatisticsSettingsModel to(String str) {
        StatisticsSettingsModel create = create();
        try {
            JSONObject jSONObject = new JSONObject(str);
            create.isEnableStatistics = jSONObject.optBoolean("enable_statistics");
            create.fgLoopIntervalInSecond = jSONObject.optLong("fg_loop_interval", 300L);
            create.bgLoopIntervalInSecond = jSONObject.optLong("bg_loop_interval", 5L);
            create.minDozeDurationDetectIntervalInMill = jSONObject.optLong("min_doze_duration_detect_interval_in_mill", -1L);
            create.maxUndozeDuration = jSONObject.optLong("max_undoze_duration", 300L);
            create.maxAliveDuration = jSONObject.optLong("max_alive_duration", 300L);
            create.dozeDurationDetectValidity = jSONObject.optLong("doze_duration_detect_validity", 604800L);
            create.smpMinDozeDurationDetectIntervalInMill = jSONObject.optLong("smp_min_doze_duration_detect_interval_in_mill", -1L);
            create.smpMaxUndozeDuration = jSONObject.optLong("smp_max_undoze_duration", 300L);
            create.smpMaxAliveDuration = jSONObject.optLong("smp_max_alive_duration", 300L);
            create.smpDozeDurationDetectValidity = jSONObject.optLong("smp_doze_duration_detect_validity", 604800L);
            create.networkDetectMode = jSONObject.optInt("network_detect_mode");
            create.smpNetworkDetectMode = jSONObject.optInt("smp_network_detect_mode", create.networkDetectMode);
            create.maxSpFileCount = jSONObject.optInt("max_sp_count", 15);
            create.apiRequestTimeoutInMill = jSONObject.optLong("api_request_timeout_in_mill", 3000L);
            create.loopGapInMill = jSONObject.optLong("loop_gap_in_mill", OnekeyLoginConfig.OVER_TIME);
            JSONArray optJSONArray = jSONObject.optJSONArray("enable_statistics_process");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add((String) optJSONArray.get(i));
                }
                create.enableStatisticsProcess = arrayList;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return create;
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(StatisticsSettingsModel statisticsSettingsModel) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enable_statistics", statisticsSettingsModel.isEnableStatistics);
            jSONObject.put("fg_loop_interval", statisticsSettingsModel.fgLoopIntervalInSecond);
            jSONObject.put("bg_loop_interval", statisticsSettingsModel.bgLoopIntervalInSecond);
            jSONObject.put("min_doze_duration_detect_interval", statisticsSettingsModel.minDozeDurationDetectIntervalInMill);
            jSONObject.put("max_undoze_duration", statisticsSettingsModel.maxUndozeDuration);
            jSONObject.put("max_alive_duration", statisticsSettingsModel.maxAliveDuration);
            jSONObject.put("doze_duration_detect_validity", statisticsSettingsModel.dozeDurationDetectValidity);
            jSONObject.put("smp_min_doze_duration_detect_interval", statisticsSettingsModel.smpMinDozeDurationDetectIntervalInMill);
            jSONObject.put("smp_max_undoze_duration", statisticsSettingsModel.smpMaxUndozeDuration);
            jSONObject.put("smp_max_alive_duration", statisticsSettingsModel.smpMaxAliveDuration);
            jSONObject.put("smp_doze_duration_detect_validity", statisticsSettingsModel.smpDozeDurationDetectValidity);
            jSONObject.put("network_detect_mode", statisticsSettingsModel.networkDetectMode);
            jSONObject.put("smp_network_detect_mode", statisticsSettingsModel.smpNetworkDetectMode);
            jSONObject.put("max_sp_count", statisticsSettingsModel.maxSpFileCount);
            jSONObject.put("api_request_timeout_in_mill", statisticsSettingsModel.apiRequestTimeoutInMill);
            jSONObject.put("loop_gap_in_mill", statisticsSettingsModel.loopGapInMill);
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = statisticsSettingsModel.enableStatisticsProcess.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("enable_statistics_process", jSONArray.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public StatisticsSettingsModel create() {
        return new StatisticsSettingsModel();
    }
}
