package com.bytedance.vmsdk.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.dataplatform.config.ExperimentKey;
import com.caverock.androidsvg.SVGParser;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SettingsManager {
    private static final String SETTINGS_FLAG = "VMSDK";
    private static final String SETTINGS_KEY = "vmsdk_settings";
    private static final String SETTINGS_TIME_KEY = "vmsdk_settings_time";
    private static final String SP_SETTINGS_KEY = "vmsdk_settings_manager_sp";
    private static final String TAG = "VmSdkSettingsManager";
    private static final String VMSDK_SETTINGS_NAME = "vmsdk_common";
    private static volatile SettingsManager sInstance;
    private SharedPreferences mSP = null;
    private Integer mSettingsTime = 0;
    private HashMap<String, Object> mSettingsCache = null;
    private HashMap<String, Object> mExperimentKeyCache = new HashMap<>();
    private Context mContext = null;

    public static SettingsManager inst() {
        if (sInstance == null) {
            synchronized (SettingsManager.class) {
                if (sInstance == null) {
                    sInstance = new SettingsManager();
                }
            }
        }
        return sInstance;
    }

    public HashMap<String, Object> initSettings(Context context) {
        HashMap<String, Object> tryLoadSettingsCache;
        synchronized (this) {
            if (context != null) {
                this.mSP = initCacheSP(context);
            }
            tryLoadSettingsCache = tryLoadSettingsCache();
            this.mSettingsCache = tryLoadSettingsCache;
        }
        return tryLoadSettingsCache;
    }

    private SharedPreferences initCacheSP(Context context) {
        this.mContext = context;
        SharedPreferences sharedPreferences = this.mSP;
        return sharedPreferences != null ? sharedPreferences : context.getSharedPreferences(SP_SETTINGS_KEY, 0);
    }

    public Integer getSettingsTime() {
        return this.mSettingsTime;
    }

    private HashMap<String, Object> tryLoadSettingsCache() {
        SharedPreferences sharedPreferences = this.mSP;
        if (sharedPreferences == null) {
            Log.e(TAG, "please call initSettings first");
            return null;
        }
        if (!sharedPreferences.contains(SETTINGS_KEY)) {
            Log.i(TAG, "load local cached settings: no cached.");
            return null;
        }
        String string = this.mSP.getString(SETTINGS_KEY, "");
        if (this.mSP.contains(SETTINGS_TIME_KEY)) {
            this.mSettingsTime = Integer.valueOf(this.mSP.getInt(SETTINGS_TIME_KEY, 0));
        } else {
            this.mSettingsTime = 0;
        }
        try {
            Gson gson = new Gson();
            JsonElement jsonElement = (JsonElement) gson.fromJson(string, JsonElement.class);
            if (jsonElement != null) {
                JsonObject asJsonObject = jsonElement.getAsJsonObject();
                Log.i(TAG, "tryLoadSettingsCache success: " + string);
                return (HashMap) gson.fromJson((JsonElement) asJsonObject, HashMap.class);
            }
        } catch (Throwable th) {
            Log.i(TAG, "tryLoadSettingsCache exception: " + th.toString());
        }
        return null;
    }

    public void setSettingsWithTime(String str, Integer num, Context context) {
        Log.i(TAG, "setSettingsWithTime " + str);
        try {
            Gson gson = new Gson();
            JsonElement jsonElement = (JsonElement) gson.fromJson(str, JsonElement.class);
            if (jsonElement != null) {
                this.mSettingsCache = (HashMap) gson.fromJson((JsonElement) jsonElement.getAsJsonObject(), HashMap.class);
            }
        } catch (Throwable th) {
            Log.e(TAG, "setSettingsWithTime exception " + th.toString());
        }
        if (this.mContext == null && context != null) {
            this.mContext = context;
        }
        if (this.mContext == null) {
            return;
        }
        synchronized (this) {
            this.mSettingsTime = num;
            if (this.mSP == null) {
                this.mSP = initCacheSP(this.mContext);
            }
            this.mSP.edit().putString(SETTINGS_KEY, str).apply();
            this.mSP.edit().putInt(SETTINGS_TIME_KEY, this.mSettingsTime.intValue()).apply();
        }
    }

    public boolean getSettingsFromCache(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Object obj = null;
        try {
            obj = this.mExperimentKeyCache.getOrDefault(str, null);
            if (obj == null) {
                obj = new ExperimentKey(str, "".getClass(), "").getValue(true);
                if (obj == null) {
                    obj = "";
                }
                this.mExperimentKeyCache.put(str, obj);
            }
        } catch (Throwable th) {
            Log.e(TAG, "experiment may not be initialized,failed to get experimentValue: " + th);
        }
        if (obj == null || obj.equals("")) {
            HashMap<String, Object> hashMap = this.mSettingsCache;
            if (hashMap == null) {
                return false;
            }
            try {
                Map map = (Map) hashMap.get(VMSDK_SETTINGS_NAME);
                if (map != null) {
                    Object obj2 = map.get(str);
                    Log.i(TAG, "getSettingsFromCache success, key: " + str + " , value: " + obj2);
                    if (obj2 != null) {
                        if (!SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL.equalsIgnoreCase(obj2.toString()) && !"true".equalsIgnoreCase(obj2.toString())) {
                            z = false;
                            obj = z;
                        }
                        z = true;
                        obj = z;
                    }
                }
            } catch (Throwable th2) {
                Log.e(TAG, "getSettingsFromCache error " + th2.toString());
            }
        }
        if (obj == null || obj.equals("")) {
            return false;
        }
        return "true".equalsIgnoreCase(obj.toString());
    }

    public int getSettingsFlag() {
        int i;
        Integer num = 0;
        try {
            i = ((Integer) new ExperimentKey(SETTINGS_FLAG, num.getClass(), num).getValue(true)).intValue();
        } catch (Throwable th) {
            Log.e(TAG, "experiment may not be initialized,failed to get experimentValue: " + th);
            i = 0;
        }
        if (i != 0) {
            return i;
        }
        HashMap<String, Object> hashMap = this.mSettingsCache;
        if (hashMap == null) {
            return 0;
        }
        try {
            Map map = (Map) hashMap.get(VMSDK_SETTINGS_NAME);
            if (map == null) {
                return i;
            }
            Object obj = map.get(SETTINGS_FLAG);
            Log.i(TAG, "getSettingsFlag success, key: VMSDK , value: " + obj);
            return obj != null ? ((Integer) obj).intValue() : i;
        } catch (Throwable th2) {
            Log.e(TAG, "getSettingsFlag error " + th2.toString());
            return i;
        }
    }
}
