package com.bytedance.sdk.account.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.token.TTTokenManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CommonRequestCacheHelper {
    private static final String KEY_CACHE_VALUE = "cache_value";
    private static final String KEY_EXPIRE_TIMING = "expire_timing";
    private static final String SP_NAME = "com_bytedance_sdk_account_utils_common_request_cache_helper";
    private static CommonRequestCacheHelper sInstance;
    private SharedPreferences mSharedPreferences;

    private CommonRequestCacheHelper() {
    }

    public static CommonRequestCacheHelper getInstance() {
        if (sInstance == null) {
            synchronized (CommonRequestCacheHelper.class) {
                if (sInstance == null) {
                    sInstance = new CommonRequestCacheHelper();
                }
            }
        }
        return sInstance;
    }

    private SharedPreferences getSharedPreferences() {
        Context applicationContext;
        if (this.mSharedPreferences == null && (applicationContext = TTTokenManager.getApplicationContext()) != null) {
            this.mSharedPreferences = applicationContext.getSharedPreferences(SP_NAME, 0);
        }
        return this.mSharedPreferences;
    }

    private String getSpKey(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (map != null && !map.isEmpty()) {
            ArrayList arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str2 = map.get((String) it.next());
                if (str2 != null) {
                    sb.append(str2);
                }
            }
        }
        return sb.toString();
    }

    public void putCache(String str, Map<String, String> map, String str2, long j) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            String spKey = getSpKey(str, map);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_EXPIRE_TIMING, j);
            jSONObject.put(KEY_CACHE_VALUE, str2);
            SharedPreferences sharedPreferences = getSharedPreferences();
            if (sharedPreferences == null || System.currentTimeMillis() >= j) {
                return;
            }
            sharedPreferences.edit().putString(spKey, jSONObject.toString()).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCache(String str, Map<String, String> map) {
        SharedPreferences sharedPreferences;
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str) || (sharedPreferences = getSharedPreferences()) == null) {
            return null;
        }
        String spKey = getSpKey(str, map);
        String string = sharedPreferences.getString(spKey, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (System.currentTimeMillis() < jSONObject.optLong(KEY_EXPIRE_TIMING)) {
            return jSONObject.optString(KEY_CACHE_VALUE, "");
        }
        sharedPreferences.edit().putString(spKey, "").apply();
        return null;
    }

    public void clearCache() {
        SharedPreferences sharedPreferences = getSharedPreferences();
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().apply();
        }
    }

    public static String getPathFromUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new URL(str).getPath();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
