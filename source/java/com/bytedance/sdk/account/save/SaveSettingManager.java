package com.bytedance.sdk.account.save;

import com.bytedance.sdk.account.platform.api.IAccountSettingsService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class SaveSettingManager {
    public static String MAX_CACHE_NUMBER = "max_cache";

    public static int getMaxCacheNumber() {
        JSONObject loginInfoConfig = ((IAccountSettingsService) AuthorizeFramework.getService(IAccountSettingsService.class)).getLoginInfoConfig();
        int i = SaveConstants.CACHE_NUMBER;
        if (loginInfoConfig != null) {
            i = loginInfoConfig.optInt(MAX_CACHE_NUMBER, SaveConstants.CACHE_NUMBER);
        }
        if (i >= 0) {
            return i;
        }
        return 0;
    }
}
