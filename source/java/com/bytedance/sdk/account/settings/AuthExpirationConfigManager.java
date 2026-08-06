package com.bytedance.sdk.account.settings;

import com.bytedance.sdk.account.impl.BDAccountDelegateInner;
import com.ss.android.LogHelper;
import com.ss.android.account.TTAccountInit;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AuthExpirationConfigManager {
    public static final String CONFIG_NAME = "auth_expiation_config";
    public static final boolean DEFAULT_ENABLE = false;
    public static final String KEY_ENABLE = "enable";
    private static final String TAG = "AuthExpirationConfigMan";
    private static JSONObject cacheSetting;
    private static Config config;
    private static GetLocalConfig localConfig;
    private static final Config settingsConfig;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class Config {
        public boolean enable = false;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface GetLocalConfig {
        Config getConfig();
    }

    static {
        Config config2 = new Config();
        settingsConfig = config2;
        config = config2;
    }

    public static void setLocalConfig(GetLocalConfig getLocalConfig) {
        localConfig = getLocalConfig;
    }

    private static JSONObject getAuthExpirationConfig() {
        JSONObject accountSettingsConfig = BDAccountDelegateInner.getSettingsInstance(TTAccountInit.getConfig().getApplicationContext()).getAccountSettingsConfig();
        if (accountSettingsConfig != null) {
            return accountSettingsConfig.optJSONObject(CONFIG_NAME);
        }
        return null;
    }

    private static void checkAndUpdateSettings() {
        GetLocalConfig getLocalConfig = localConfig;
        if (getLocalConfig != null) {
            config = getLocalConfig.getConfig();
            return;
        }
        Config config2 = settingsConfig;
        config = config2;
        JSONObject authExpirationConfig = getAuthExpirationConfig();
        if (cacheSetting != authExpirationConfig) {
            cacheSetting = authExpirationConfig;
            LogHelper.d(TAG, "auth_expiation_config = " + cacheSetting);
            JSONObject jSONObject = cacheSetting;
            if (jSONObject != null) {
                config2.enable = jSONObject.optBoolean("enable", false);
            } else {
                config2.enable = false;
            }
        }
    }

    public static boolean isEnable() {
        checkAndUpdateSettings();
        return config.enable;
    }
}
