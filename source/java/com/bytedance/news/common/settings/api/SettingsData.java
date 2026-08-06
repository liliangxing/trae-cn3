package com.bytedance.news.common.settings.api;

import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class SettingsData {
    private JSONObject appSettings;
    private boolean fromServer;
    private String token;
    private JSONObject userSettings;

    public SettingsData(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, UUID.randomUUID().toString(), true);
    }

    public SettingsData(JSONObject jSONObject, JSONObject jSONObject2, String str, boolean z) {
        this.appSettings = jSONObject;
        this.userSettings = jSONObject2;
        this.token = str;
        this.fromServer = z;
    }

    public JSONObject getAppSettings() {
        return this.appSettings;
    }

    public JSONObject getUserSettings() {
        return this.userSettings;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isFromServer() {
        return this.fromServer;
    }

    public void setAppSettings(JSONObject jSONObject) {
        this.appSettings = jSONObject;
    }

    public void setUserSettings(JSONObject jSONObject) {
        this.userSettings = jSONObject;
    }
}
