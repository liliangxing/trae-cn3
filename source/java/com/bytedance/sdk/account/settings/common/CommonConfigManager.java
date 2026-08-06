package com.bytedance.sdk.account.settings.common;

import com.ss.android.token.TTTokenManager;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CommonConfigManager {
    public static final int DEFAULT_COMMON_REQUEST_PARSE_USER_INFO_DECISION = 1;
    public static final String KEY_COMMON_REQUEST_PARSE_USER_INFO_DECISION = "common_request_parse_user_info_decision";
    private static final String KEY_CONFIG = "common_config";
    private static final String TAG = "CommonConfigManager";
    private static JSONObject cacheSetting = null;
    private static int commonRequestParseUserInfoDecision = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    public static JSONObject getConfig() {
        JSONObject settings = TTTokenManager.getSettings();
        if (settings != null) {
            return settings.optJSONObject(KEY_CONFIG);
        }
        return null;
    }

    public static int getCommonRequestParseUserInfoDecision() {
        checkAndUpdateSettings();
        return commonRequestParseUserInfoDecision;
    }

    private static boolean checkAndUpdateSettings() {
        JSONObject config = getConfig();
        boolean z = cacheSetting != config;
        if (z) {
            cacheSetting = config;
            TTTokenManager.log(3, TAG, "common config settings = " + cacheSetting);
            if (config == null) {
                config = new JSONObject();
            }
            commonRequestParseUserInfoDecision = config.optInt(KEY_COMMON_REQUEST_PARSE_USER_INFO_DECISION, 1);
        }
        return z;
    }
}
