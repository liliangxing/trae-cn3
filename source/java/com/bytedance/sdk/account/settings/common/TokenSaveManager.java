package com.bytedance.sdk.account.settings.common;

import android.text.TextUtils;
import com.bytedance.sdk.account.utils.SettingsListEntity;
import com.ss.android.token.TTTokenManager;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TokenSaveManager {
    private static final boolean DEFAULT_ENABLE = false;
    private static final String KEY_CONFIG = "xtoken_safe_save_config";
    private static final String KEY_ENABLE = "enable";
    private static final String KEY_EXCLUDE_DOMAIN_SUFFIX = "exclude_domain_suffix";
    private static final String KEY_EXCLUDE_PATH_PREFIX = "exclude_path_prefix";
    private static final String KEY_PATH_PREFIX = "path_prefix";
    private static final String TAG = "TokenSaveManager";
    private static JSONObject cacheSetting;
    private static boolean enable;
    private static final SettingsListEntity excludeDomainSuffixes = new SettingsListEntity(null, false);
    private static final SettingsListEntity pathPrefixes = new SettingsListEntity(Collections.singletonList("/passport/"), false);
    private static final SettingsListEntity excludePathPrefixes = new SettingsListEntity(null, false);

    private static JSONObject getConfig() {
        JSONObject config = CommonConfigManager.getConfig();
        if (config != null) {
            return config.optJSONObject(KEY_CONFIG);
        }
        return null;
    }

    private static boolean checkAndUpdateSettings() {
        JSONObject config = getConfig();
        boolean z = cacheSetting != config;
        if (z) {
            cacheSetting = config;
            TTTokenManager.log(TAG, "settings=" + cacheSetting);
            JSONObject jSONObject = cacheSetting;
            if (jSONObject != null) {
                enable = jSONObject.optBoolean("enable", false);
                excludeDomainSuffixes.updateSettings(cacheSetting.optJSONArray(KEY_EXCLUDE_DOMAIN_SUFFIX));
                pathPrefixes.updateSettings(cacheSetting.optJSONArray(KEY_PATH_PREFIX));
                excludePathPrefixes.updateSettings(cacheSetting.optJSONArray(KEY_EXCLUDE_PATH_PREFIX));
            } else {
                enable = false;
                excludeDomainSuffixes.updateSettings(null);
                pathPrefixes.updateSettings(null);
                excludePathPrefixes.updateSettings(null);
            }
        }
        return z;
    }

    public static boolean check(String str, String str2) {
        checkAndUpdateSettings();
        if (!enable) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<String> it = excludeDomainSuffixes.getTotal().iterator();
            while (it.hasNext()) {
                if (str.endsWith(it.next())) {
                    return false;
                }
            }
            Iterator<String> it2 = excludePathPrefixes.getTotal().iterator();
            while (it2.hasNext()) {
                if (str2.startsWith(it2.next())) {
                    return false;
                }
            }
            Iterator<String> it3 = pathPrefixes.getTotal().iterator();
            while (it3.hasNext()) {
                if (str2.startsWith(it3.next())) {
                    return true;
                }
            }
        }
        return false;
    }
}
