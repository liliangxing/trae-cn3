package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IAccountSettingsService;
import com.ss.android.TTAccountConfig;
import com.ss.android.account.TTAccountInit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAccountSettingsManager implements IAccountSettingsService {
    public static final String KEY_ACCOUNT_CONFIG = "sdk_key_accountSDK";
    private static final String KEY_ACCOUNT_LOGIN_INFO_CONFIG = "login_info_config";
    private static final String KEY_ACCOUNT_ONEKEY_LOGIN_CONFIG = "onekey_login_config";
    private static final String KEY_ACCOUNT_SETTINGS = "account_sdk_settings";
    private static final String KEY_ACCOUNT_SETTINGS_SP_NAME = "account_sdk_settings_sp";
    private static final String KEY_ACCOUNT_THIRD_PARTY_CONFIG = "third_party_config";
    private static final String KEY_SETTING_APP = "app";
    private static final String KEY_SETTING_DATA = "data";
    private static final String KEY_SETTING_SETTINGS = "settings";
    private static JSONObject mCacheSettings;
    private static volatile IAccountSettingsService sInstance;
    private final Context mContext;
    private IAccountSettingsService.SettingsService mSettingService;
    private SharedPreferences mSettingsSp;

    private BDAccountSettingsManager(Context context) {
        TTAccountConfig configMayNull = TTAccountInit.getConfigMayNull();
        if (configMayNull == null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = configMayNull.getApplicationContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IAccountSettingsService instance(Context context) {
        if (sInstance == null) {
            synchronized (BDAccountSettingsManager.class) {
                if (sInstance == null) {
                    sInstance = new BDAccountSettingsManager(context);
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.sdk.account.platform.api.IAccountSettingsService
    public void updateSettings(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("data")) {
                    jSONObject = jSONObject.optJSONObject("data");
                }
                if (jSONObject != null) {
                    if (jSONObject.has(KEY_SETTING_APP)) {
                        jSONObject = jSONObject.optJSONObject(KEY_SETTING_APP);
                    } else if (jSONObject.has(KEY_SETTING_SETTINGS)) {
                        jSONObject = jSONObject.optJSONObject(KEY_SETTING_SETTINGS);
                    }
                }
                if (jSONObject == null || !jSONObject.has(KEY_ACCOUNT_CONFIG) || (optJSONObject = jSONObject.optJSONObject(KEY_ACCOUNT_CONFIG)) == null) {
                    return;
                }
                mCacheSettings = optJSONObject;
                String jSONObject2 = optJSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                saveAccountSettings(jSONObject2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.sdk.account.platform.api.IAccountSettingsService
    public void setSettingsService(IAccountSettingsService.SettingsService settingsService) {
        this.mSettingService = settingsService;
    }

    private SharedPreferences getSharedPreferences(Context context) {
        if (this.mSettingsSp == null && context != null) {
            this.mSettingsSp = context.getSharedPreferences(KEY_ACCOUNT_SETTINGS_SP_NAME, 0);
        }
        return this.mSettingsSp;
    }

    private SharedPreferences.Editor getSharedPreferencesEditor(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.edit();
    }

    private void saveAccountSettings(String str) {
        SharedPreferences.Editor sharedPreferencesEditor = getSharedPreferencesEditor(this.mContext);
        if (sharedPreferencesEditor == null) {
            return;
        }
        sharedPreferencesEditor.putString(KEY_ACCOUNT_SETTINGS, str);
        sharedPreferencesEditor.apply();
    }

    @Override // com.bytedance.sdk.account.platform.api.IAccountSettingsService
    public JSONObject getAccountSettingsConfig() {
        IAccountSettingsService.SettingsService settingsService = this.mSettingService;
        if (settingsService != null) {
            return settingsService.getSettings();
        }
        JSONObject jSONObject = mCacheSettings;
        if (jSONObject != null) {
            return jSONObject;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(this.mContext);
        if (sharedPreferences != null) {
            try {
                mCacheSettings = new JSONObject(sharedPreferences.getString(KEY_ACCOUNT_SETTINGS, "{}"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return mCacheSettings;
    }

    @Override // com.bytedance.sdk.account.platform.api.IAccountSettingsService
    public JSONObject getOnekeyLoginConfig() {
        try {
            JSONObject accountSettingsConfig = getAccountSettingsConfig();
            if (accountSettingsConfig != null) {
                return accountSettingsConfig.optJSONObject(KEY_ACCOUNT_ONEKEY_LOGIN_CONFIG);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.sdk.account.platform.api.IAccountSettingsService
    public JSONObject getThirdPartyConfig() {
        try {
            JSONObject accountSettingsConfig = getAccountSettingsConfig();
            if (accountSettingsConfig != null) {
                return accountSettingsConfig.optJSONObject(KEY_ACCOUNT_THIRD_PARTY_CONFIG);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.sdk.account.platform.api.IAccountSettingsService
    public JSONObject getLoginInfoConfig() {
        try {
            JSONObject accountSettingsConfig = getAccountSettingsConfig();
            if (accountSettingsConfig != null) {
                return accountSettingsConfig.optJSONObject(KEY_ACCOUNT_LOGIN_INFO_CONFIG);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
