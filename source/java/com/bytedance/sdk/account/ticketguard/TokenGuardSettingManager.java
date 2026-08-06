package com.bytedance.sdk.account.ticketguard;

import com.bytedance.sdk.account.utils.SettingsListEntity;
import com.ss.android.token.TTTokenManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TokenGuardSettingManager {
    private static final boolean DEFAULT_ENABLE = false;
    private static final boolean DEFAULT_ENABLE_FULL_LOG = false;
    private static final boolean DEFAULT_ENABLE_TOKEN_LAUNCH = false;
    private static final boolean DEFAULT_ENABLE_WAITING_INIT = false;
    private static final int DEFAULT_WAITING_TIMEOUT = 1000;
    private static final String KEY_ACCOUNT_TOKEN_GUARD_CONFIG = "token_guard_config";
    private static final String KEY_ENABLE_FULL_LOG = "enable_full_path_track";
    private static final String KEY_ENABLE_TOKEN_GUARD = "enable_token_guard";
    private static final String KEY_ENABLE_TOKEN_LAUNCH = "enable_token_launch";
    private static final String KEY_ENABLE_WAITING_INIT = "enable_waiting_init";
    private static final String KEY_EXCLUDE_GET_TOKEN_DOMAINS = "exclude_get_token_domains";
    private static final String KEY_EXCLUDE_GET_TOKEN_PATHS = "exclude_get_token_paths";
    private static final String KEY_EXCLUDE_GET_TOKEN_PREFIX = "exclude_get_token_prefix";
    private static final String KEY_EXCLUDE_TOKEN_GUARD_PATHS = "exclude_token_guard_paths";
    private static final String KEY_TOKEN_GUARD_PATHS = "token_guard_paths";
    private static final String KEY_TOKEN_GUARD_PATH_PREFIX = "token_guard_path_prefix";
    private static final String KEY_WAITING_TIMEOUT = "waiting_timeout";
    private static final String TAG = "TokenGuardSettingManage";
    private static JSONObject cacheSetting = null;
    private static boolean enable = false;
    private static boolean enableFullLog = false;
    private static boolean enableTokenLaunch = false;
    private static boolean enableWaitingInit = false;
    private static int waitingTimeout = 1000;
    public static final SettingsListEntity pathEntity = new SettingsListEntity(new HashSet(Arrays.asList("/passport/account/info/v2/", "/passport/token/beat/v2/")), true);
    public static final SettingsListEntity prefixEntity = new SettingsListEntity(null, false);
    public static final SettingsListEntity excludeEntity = new SettingsListEntity(null, true);
    public static final SettingsListEntity excludeGetTokenDomain = new SettingsListEntity(null, true);
    public static final SettingsListEntity excludeGetTokenPaths = new SettingsListEntity(null, true);
    public static final SettingsListEntity excludeGetTokenPrefixes = new SettingsListEntity(null, false);

    public static boolean isEnableTokenGuard() {
        checkAndUpdateSettings();
        return enable;
    }

    public static boolean isEnableFullLog() {
        checkAndUpdateSettings();
        return enableFullLog;
    }

    public static boolean isEnableTokenLaunch() {
        checkAndUpdateSettings();
        return enableTokenLaunch;
    }

    public static boolean isEnableWaitingInit() {
        checkAndUpdateSettings();
        return enableWaitingInit;
    }

    public static int getWaitingTimeout() {
        checkAndUpdateSettings();
        return waitingTimeout;
    }

    public static boolean isPathGetToken(String str, String str2) {
        TTTokenManager.log(TAG, "isPathGetToken: domain=" + str + ", path=" + str2);
        checkAndUpdateSettings();
        if (excludeGetTokenDomain.getTotal().contains(str)) {
            TTTokenManager.log(TAG, "isPathGetToken: exclude domain");
            return false;
        }
        if (excludeGetTokenPaths.getTotal().contains(str2)) {
            TTTokenManager.log(TAG, "isPathGetToken: exclude paths");
            return false;
        }
        Iterator<String> it = excludeGetTokenPrefixes.getTotal().iterator();
        while (it.hasNext()) {
            if (str2.startsWith(it.next())) {
                TTTokenManager.log(TAG, "isPathGetToken: exclude prefix");
                return false;
            }
        }
        return true;
    }

    public static boolean isPathNeedGuard(String str) {
        TTTokenManager.log(TAG, "isPathNeedGuard: path=" + str);
        checkAndUpdateSettings();
        if (excludeEntity.getTotal().contains(str)) {
            TTTokenManager.log(TAG, "isPathNeedGuard: exclude contains");
            return false;
        }
        if (pathEntity.getTotal().contains(str)) {
            TTTokenManager.log(TAG, "isPathNeedGuard: path contains");
            return true;
        }
        Iterator<String> it = prefixEntity.getTotal().iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                TTTokenManager.log(TAG, "isPathNeedGuard: prefix contains");
                return true;
            }
        }
        return false;
    }

    private static boolean checkAndUpdateSettings() {
        JSONObject tokenGuardConfig = getTokenGuardConfig();
        boolean z = cacheSetting != tokenGuardConfig;
        if (z) {
            cacheSetting = tokenGuardConfig;
            TTTokenManager.log(TAG, "settings=" + cacheSetting);
            JSONObject jSONObject = cacheSetting;
            if (jSONObject != null) {
                pathEntity.updateSettings(jSONObject.optJSONArray(KEY_TOKEN_GUARD_PATHS));
                prefixEntity.updateSettings(cacheSetting.optJSONArray(KEY_TOKEN_GUARD_PATH_PREFIX));
                excludeEntity.updateSettings(cacheSetting.optJSONArray(KEY_EXCLUDE_TOKEN_GUARD_PATHS));
                enable = cacheSetting.optBoolean(KEY_ENABLE_TOKEN_GUARD, false);
                excludeGetTokenDomain.updateSettings(cacheSetting.optJSONArray(KEY_EXCLUDE_GET_TOKEN_DOMAINS));
                excludeGetTokenPaths.updateSettings(cacheSetting.optJSONArray(KEY_EXCLUDE_GET_TOKEN_PATHS));
                excludeGetTokenPrefixes.updateSettings(cacheSetting.optJSONArray(KEY_EXCLUDE_GET_TOKEN_PREFIX));
                enableFullLog = cacheSetting.optBoolean(KEY_ENABLE_FULL_LOG, false);
                enableTokenLaunch = cacheSetting.optBoolean(KEY_ENABLE_TOKEN_LAUNCH, false);
                enableWaitingInit = cacheSetting.optBoolean(KEY_ENABLE_WAITING_INIT, false);
                waitingTimeout = cacheSetting.optInt(KEY_WAITING_TIMEOUT, 1000);
            } else {
                pathEntity.updateSettings(null);
                prefixEntity.updateSettings(null);
                excludeEntity.updateSettings(null);
                enable = false;
                excludeGetTokenDomain.updateSettings(null);
                excludeGetTokenPaths.updateSettings(null);
                excludeGetTokenPrefixes.updateSettings(null);
                enableFullLog = false;
                enableTokenLaunch = false;
                enableWaitingInit = false;
                waitingTimeout = 1000;
            }
        }
        return z;
    }

    private static JSONObject getTokenGuardConfig() {
        JSONObject settings = TTTokenManager.getSettings();
        if (settings != null) {
            return settings.optJSONObject(KEY_ACCOUNT_TOKEN_GUARD_CONFIG);
        }
        return null;
    }

    public static String getConfigString() {
        return String.valueOf(cacheSetting);
    }
}
