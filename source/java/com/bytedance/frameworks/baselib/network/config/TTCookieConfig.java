package com.bytedance.frameworks.baselib.network.config;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TTCookieConfig {
    private static final String COOKIE_BACKUP_ASYNC_SAVE_ENABLED_KEY = "cookie_backup_async_save_enabled";
    private static final String COOKIE_BATCH_ENABLED_KEY = "cookie_batch";
    private static final String COOKIE_SAVE_V2_ENABLED_KEY = "cookie_save_v2_enabled";
    private static final String DISABLE_COOKIE_SHARE_HOST_MATCH_FIX = "disable_cookie_share_host_match_fix";
    private static final String DISABLE_SHARE_COOKIE_KEYS = "disable_share_cookie_keys";
    private static final String ENABLE_COOKIE_FLUSH_FOR_REGION = "enable_flush_cookie_for_region";
    private static final String ENABLE_SHARE_COOKIE_BATCH = "enable_share_cookie_batch";
    private static volatile boolean sCookieBackupAsyncSaveEnabled;
    private static volatile boolean sCookieBatchSaveEnabled;
    private static volatile boolean sCookieSaveV2Enabled;
    private static volatile boolean sDisableCookieShareHostMatchFix;
    private static final Set<String> sDisableShareCookieKeys = new CopyOnWriteArraySet();
    private static volatile boolean sEnableCookieShareBatch;
    private static volatile boolean sEnableFlushCookieForRegion;

    public static boolean isCookieSaveV2Enabled() {
        return sCookieSaveV2Enabled;
    }

    public static boolean isCookieBackupAsyncSaveEnabled() {
        return sCookieBackupAsyncSaveEnabled;
    }

    public static boolean isCookieBatchSaveEnabled() {
        return sCookieBatchSaveEnabled;
    }

    public static boolean isDisableCookieHostMatchFix() {
        return sDisableCookieShareHostMatchFix;
    }

    public static boolean isEnableFlushCookieForRegion() {
        return sEnableFlushCookieForRegion;
    }

    public static boolean isEnableCookieShareBatch() {
        return sEnableCookieShareBatch;
    }

    public static boolean isDisableCookieShare(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.trim();
        int indexOf = trim.indexOf(59);
        if (indexOf != -1) {
            trim = trim.substring(0, indexOf);
        }
        Iterator<String> it = sDisableShareCookieKeys.iterator();
        while (it.hasNext()) {
            if (trim.startsWith(it.next() + ContainerUtils.KEY_VALUE_DELIMITER)) {
                return true;
            }
        }
        return false;
    }

    public static void onServerConfigChanged(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        resetTncConfig();
        sCookieSaveV2Enabled = jSONObject.optInt(COOKIE_SAVE_V2_ENABLED_KEY, 0) > 0;
        sCookieBackupAsyncSaveEnabled = jSONObject.optInt(COOKIE_BACKUP_ASYNC_SAVE_ENABLED_KEY, 0) > 0;
        sCookieBatchSaveEnabled = jSONObject.optInt(COOKIE_BATCH_ENABLED_KEY, 0) > 0;
        sDisableCookieShareHostMatchFix = jSONObject.optInt(DISABLE_COOKIE_SHARE_HOST_MATCH_FIX, 0) > 0;
        sEnableFlushCookieForRegion = jSONObject.optInt(ENABLE_COOKIE_FLUSH_FOR_REGION, 0) > 0;
        sEnableCookieShareBatch = jSONObject.optInt(ENABLE_SHARE_COOKIE_BATCH, 0) > 0;
        JSONArray optJSONArray = jSONObject.optJSONArray(DISABLE_SHARE_COOKIE_KEYS);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < optJSONArray.length(); i++) {
            String optString = optJSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                hashSet.add(optString);
            }
        }
        sDisableShareCookieKeys.addAll(hashSet);
    }

    private static void resetTncConfig() {
        sCookieSaveV2Enabled = false;
        sCookieBackupAsyncSaveEnabled = false;
        sCookieBatchSaveEnabled = false;
        sDisableCookieShareHostMatchFix = false;
        sEnableFlushCookieForRegion = false;
        sEnableCookieShareBatch = false;
        sDisableShareCookieKeys.clear();
    }
}
