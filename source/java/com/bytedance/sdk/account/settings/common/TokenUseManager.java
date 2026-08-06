package com.bytedance.sdk.account.settings.common;

import com.ss.android.token.TTTokenManager;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TokenUseManager {
    private static final boolean DEFAULT_ENABLE_HTTP_FORBID = false;
    private static final boolean DEFAULT_ENABLE_HTTP_REQUEST_TRACK = false;
    public static final String KEY_CONFIG = "xtoken_safe_use_config";
    private static final String KEY_ENABLE_HTTP_FORBID = "enable_http_forbid";
    private static final String KEY_ENABLE_HTTP_REQUEST_TRACK = "enable_http_request_track";
    private static final String TAG = "TokenUseSettingsManager";
    private static JSONObject cacheSetting;
    private static boolean enableHttpForbid;
    private static boolean enableHttpRequestTrack;

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
                enableHttpForbid = jSONObject.optBoolean(KEY_ENABLE_HTTP_FORBID, false);
                enableHttpRequestTrack = cacheSetting.optBoolean(KEY_ENABLE_HTTP_REQUEST_TRACK, false);
            } else {
                enableHttpForbid = false;
                enableHttpRequestTrack = false;
            }
        }
        return z;
    }

    public static boolean isEnableHttpForbid() {
        checkAndUpdateSettings();
        return enableHttpForbid;
    }

    public static boolean isEnableHttpRequestTrack() {
        checkAndUpdateSettings();
        return enableHttpRequestTrack;
    }
}
