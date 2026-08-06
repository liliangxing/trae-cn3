package com.bytedance.sdk.account.platform.onekey;

import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IAccountSettingsService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class OnekeySettingManager {
    public static final long DEFAULT_OVER_TIME_SEC = 4;
    public static final String KEY_CM_CONFIG = "cm_config";
    public static final String KEY_CT_CONFIG = "ct_config";
    public static final String KEY_CU_CONFIG = "cu_config";
    private static final String KEY_DATA_MOBILE_ENABLE = "need_data_mobile";
    private static final String KEY_ENABLE = "is_enable";
    private static final String KEY_GLOBAL_CONFIG = "global_config";
    private static final String KEY_PHONE_PERMISSION_ENABLE = "need_read_phone_permission";
    private static final String KEY_REQUEST_ABOVE_4G = "request_above_4g";
    private static final String KEY_SCENE_TIMEOUT = "scene_timeout";
    private static final String KEY_TIMEOUT = "timeout_sec";
    private static volatile OnekeySettingManager sInstance;
    private final IAccountSettingsService mSettingsService = (IAccountSettingsService) AuthorizeFramework.getService(IAccountSettingsService.class);

    private OnekeySettingManager() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OnekeySettingManager instance() {
        if (sInstance == null) {
            synchronized (OnekeySettingManager.class) {
                if (sInstance == null) {
                    sInstance = new OnekeySettingManager();
                }
            }
        }
        return sInstance;
    }

    public boolean requestAbove4GEnable() {
        JSONObject mobileConfig = getMobileConfig("global_config");
        if (mobileConfig == null) {
            return false;
        }
        return mobileConfig.optBoolean(KEY_REQUEST_ABOVE_4G);
    }

    public long getSceneTimeOut(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return getTimeout(str2);
        }
        JSONObject mobileConfig = getMobileConfig("global_config");
        if (mobileConfig == null) {
            return getTimeout(str2);
        }
        JSONObject optJSONObject = mobileConfig.optJSONObject(KEY_SCENE_TIMEOUT);
        if (optJSONObject == null) {
            return getTimeout(str2);
        }
        if (optJSONObject.has(str)) {
            return optJSONObject.optLong(str);
        }
        return getTimeout(str2);
    }

    public boolean needReadPhonePermission(String str) {
        JSONObject mobileConfig;
        return TextUtils.equals("1", str) && (mobileConfig = getMobileConfig(str)) != null && mobileConfig.optInt(KEY_PHONE_PERMISSION_ENABLE, 0) == 1;
    }

    public boolean needDataMobile(String str, boolean z) {
        JSONObject mobileConfig = getMobileConfig(str);
        return mobileConfig != null ? mobileConfig.optInt(KEY_DATA_MOBILE_ENABLE, 1) == 1 : z;
    }

    public long getTimeout(String str) {
        JSONObject mobileConfig;
        return (TextUtils.isEmpty(str) || (mobileConfig = getMobileConfig(str)) == null) ? OnekeyLoginConfig.OVER_TIME : mobileConfig.optLong(KEY_TIMEOUT, 4L) * 1000;
    }

    public boolean isEnable(String str) {
        JSONObject mobileConfig = getMobileConfig(str);
        return mobileConfig == null || mobileConfig.optInt(KEY_ENABLE, 1) == 1;
    }

    private JSONObject getMobileConfig(String str) {
        JSONObject onekeyLoginConfig;
        IAccountSettingsService iAccountSettingsService = this.mSettingsService;
        if (iAccountSettingsService == null || (onekeyLoginConfig = iAccountSettingsService.getOnekeyLoginConfig()) == null) {
            return null;
        }
        return onekeyLoginConfig.optJSONObject(str);
    }
}
