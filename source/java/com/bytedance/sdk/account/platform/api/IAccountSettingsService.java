package com.bytedance.sdk.account.platform.api;

import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface IAccountSettingsService extends IAuthorizeService {

    /* loaded from: classes5.dex */
    public interface SettingsService {
        JSONObject getSettings();
    }

    JSONObject getAccountSettingsConfig();

    JSONObject getLoginInfoConfig();

    JSONObject getOnekeyLoginConfig();

    JSONObject getThirdPartyConfig();

    void setSettingsService(SettingsService settingsService);

    void updateSettings(JSONObject jSONObject);
}
