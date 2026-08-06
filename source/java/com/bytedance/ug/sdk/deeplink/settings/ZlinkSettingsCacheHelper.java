package com.bytedance.ug.sdk.deeplink.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ZlinkSettingsCacheHelper {
    private static final String TAG = "ZlinkSettingsCacheHelper";
    private static volatile SharedPreferences mSharedPreferences;
    private static volatile JSONObject sSettingsDataCache;

    private static SharedPreferences getInstance(Context context) {
        if (mSharedPreferences == null) {
            synchronized (ZlinkSettingsCacheHelper.class) {
                if (mSharedPreferences == null && context != null) {
                    try {
                        mSharedPreferences = context.getSharedPreferences("deep_link_settings_id", 0);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return mSharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSettingsDataCache(Context context, JSONObject jSONObject) {
        JSONObject settingsDataCache = getSettingsDataCache(context);
        Iterator<String> keys = settingsDataCache.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                if (!jSONObject.has(next)) {
                    jSONObject.put(next, settingsDataCache.opt(next));
                }
            } catch (JSONException e) {
                Logger.e(TAG, "settings update error:", e);
            }
        }
        sSettingsDataCache = jSONObject;
        SharedPreferences zlinkSettingsCacheHelper = getInstance(context);
        if (zlinkSettingsCacheHelper != null) {
            SharedPreferences.Editor edit = zlinkSettingsCacheHelper.edit();
            edit.putString("deeplink_setting_data", jSONObject.toString());
            edit.apply();
        }
    }

    public static JSONObject getSettingsDataCache(Context context) {
        if (sSettingsDataCache != null) {
            return sSettingsDataCache;
        }
        SharedPreferences zlinkSettingsCacheHelper = getInstance(context);
        if (zlinkSettingsCacheHelper != null) {
            try {
                String string = zlinkSettingsCacheHelper.getString("deeplink_setting_data", "");
                if (!TextUtils.isEmpty(string)) {
                    sSettingsDataCache = new JSONObject(string);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (sSettingsDataCache == null) {
            sSettingsDataCache = new JSONObject();
        }
        return sSettingsDataCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasSettingsDataCache(Context context) {
        return getSettingsDataCache(context).length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getString(Context context, String str, String str2) {
        return getSettingsDataCache(context).optString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(Context context, String str, int i) {
        return getSettingsDataCache(context).optInt(str, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(Context context, String str, long j) {
        return getSettingsDataCache(context).optLong(str, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getBoolean(Context context, String str, boolean z) {
        return getSettingsDataCache(context).optBoolean(str, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> getList(Context context, String str, List<String> list) {
        return parseList(getSettingsDataCache(context).optString(str, ""), list);
    }

    private static List<String> parseList(String str, List<String> list) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            return list;
        }
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray == null || jSONArray.length() <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.optString(i));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> getMap(Context context, String str, Map<String, String> map) {
        return parseMap(getSettingsDataCache(context).optString(str, ""), map);
    }

    private static Map<String, String> parseMap(String str, Map<String, String> map) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        return (jSONArray == null || jSONArray.length() <= 0) ? map : new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLastestUpdateTime(Context context) {
        SharedPreferences zlinkSettingsCacheHelper = getInstance(context);
        if (zlinkSettingsCacheHelper != null) {
            zlinkSettingsCacheHelper.edit().putLong("key_settings_lastest_update_time", System.currentTimeMillis()).apply();
        }
    }

    public static long getLastestUpdateTime(Context context) {
        SharedPreferences zlinkSettingsCacheHelper = getInstance(context);
        if (zlinkSettingsCacheHelper != null) {
            return zlinkSettingsCacheHelper.getLong("key_settings_lastest_update_time", 0L);
        }
        return 0L;
    }
}
