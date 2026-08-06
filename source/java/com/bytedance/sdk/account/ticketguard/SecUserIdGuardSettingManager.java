package com.bytedance.sdk.account.ticketguard;

import com.bytedance.sdk.account.impl.BDAccountDelegateInner;
import com.bytedance.sdk.account.utils.SettingsListEntity;
import com.ss.android.account.TTAccountInit;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SecUserIdGuardSettingManager {
    private static final boolean DEFAULT_ENABLE = false;
    private static final String KEY_ACCOUNT_SEC_USER_ID_GUARD_CONFIG = "sec_user_id_guard_config";
    private static final String KEY_ENABLE_SEC_USER_ID_GUARD = "enable_sec_user_id_guard";
    private static final String KEY_SEC_USER_ID_GUARD_PATHS = "sec_user_id_guard_paths";
    private static JSONObject cacheSetting;
    private static boolean enable;
    public static final SettingsListEntity pathEntity = new SettingsListEntity(new HashSet(Arrays.asList("/passport/device/trust_users/", "/passport/device/one_login/")), true);

    public static boolean isEnable() {
        checkAndUpdateSettings();
        return enable;
    }

    public static boolean isPathNeedGuard(String str) {
        checkAndUpdateSettings();
        return pathEntity.getTotal().contains(str);
    }

    private static JSONObject getSecUserIdGuardConfig() {
        JSONObject accountSettingsConfig = BDAccountDelegateInner.getSettingsInstance(TTAccountInit.getConfig().getApplicationContext()).getAccountSettingsConfig();
        if (accountSettingsConfig != null) {
            return accountSettingsConfig.optJSONObject(KEY_ACCOUNT_SEC_USER_ID_GUARD_CONFIG);
        }
        return null;
    }

    private static boolean checkAndUpdateSettings() {
        JSONObject secUserIdGuardConfig = getSecUserIdGuardConfig();
        boolean z = cacheSetting != secUserIdGuardConfig;
        if (z) {
            cacheSetting = secUserIdGuardConfig;
            if (secUserIdGuardConfig != null) {
                enable = secUserIdGuardConfig.optBoolean(KEY_ENABLE_SEC_USER_ID_GUARD, false);
                pathEntity.updateSettings(cacheSetting.optJSONArray(KEY_SEC_USER_ID_GUARD_PATHS));
            } else {
                enable = false;
                pathEntity.updateSettings(null);
            }
        }
        return z;
    }
}
