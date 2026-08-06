package com.bytedance.news.common.settings.api.model;

import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class DiffSettingsData {
    private JSONObject appSettings;
    private JSONObject appSettingsDiffTime;
    private List<JSONObject> appSettingsLastList;
    private List<JSONObject> appSettingsList;
    private List<JSONObject> appSettingsTimeList;
    private long timestamp;

    public DiffSettingsData(JSONObject jSONObject, JSONObject jSONObject2, long j) {
        this.appSettings = jSONObject;
        this.appSettingsDiffTime = jSONObject2;
        this.timestamp = j;
    }

    public DiffSettingsData(List<JSONObject> list, List<JSONObject> list2, List<JSONObject> list3) {
        this.appSettingsList = list;
        this.appSettingsTimeList = list2;
        this.appSettingsLastList = list3;
    }

    @Deprecated
    public JSONObject getAppSettings() {
        return this.appSettings;
    }

    @Deprecated
    public JSONObject getAppSettingsDiffTime() {
        return this.appSettingsDiffTime;
    }

    @Deprecated
    public long getTimestamp() {
        return this.timestamp;
    }

    public List<JSONObject> getAppSettingsList() {
        return this.appSettingsList;
    }

    public List<JSONObject> getAppSettingsTimeList() {
        return this.appSettingsTimeList;
    }

    public List<JSONObject> getAppSettingsLastList() {
        return this.appSettingsLastList;
    }
}
