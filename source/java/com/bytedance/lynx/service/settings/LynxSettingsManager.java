package com.bytedance.lynx.service.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.lynx.service.trace.TraceEventDef;
import com.bytedance.vmsdk.settings.SettingsManager;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LynxSettingsManager {
    private static final String SETTINGS_KEY = "settings";
    private static final String SETTINGS_TIME_KEY = "settings_time";
    private static final String SP_SETTINGS_KEY = "lynx_settings_manager_sp";
    private static final String TAG = "LynxSettingsManager";
    private static final Gson sGson = new Gson();
    private static volatile LynxSettingsManager sInstance;
    private SharedPreferences mSP = null;
    private HashMap<String, Object> mSettingsMap = null;
    private final ReadWriteLock sExperimentSettingsLock = new ReentrantReadWriteLock();
    private Context mContext = null;
    private ILynxSettingsManagerDelegate mDelegate = null;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ILynxSettingsManagerDelegate {
        void willUpdateSettings(Context context);
    }

    public static LynxSettingsManager inst() {
        if (sInstance == null) {
            synchronized (LynxSettingsManager.class) {
                if (sInstance == null) {
                    sInstance = new LynxSettingsManager();
                }
            }
        }
        return sInstance;
    }

    public void initialize(Context context) {
        String str;
        if (context != null && this.mSP == null) {
            TraceEvent.beginSection(TraceEventDef.SETTINGS_INIT_MESSAGE);
            synchronized (this) {
                if (this.mSP == null) {
                    this.mContext = context;
                    this.mSP = context.getSharedPreferences(SP_SETTINGS_KEY, 0);
                    str = tryToLoadLocalCachedSettingsString();
                } else {
                    str = null;
                }
            }
            HashMap<String, Object> convertCachedStringToMap = convertCachedStringToMap(str);
            if (convertCachedStringToMap != null) {
                updateSettings(convertCachedStringToMap);
            }
            TraceEvent.endSection(TraceEventDef.SETTINGS_INIT_MESSAGE);
        }
    }

    public long getSettingsTime() {
        try {
            return this.mSP.getLong("settings_time", 0L);
        } catch (ClassCastException e) {
            LLog.e(TAG, "Lynx load local cached settings time exception " + e);
            return 0L;
        }
    }

    private String tryToLoadLocalCachedSettingsString() {
        SharedPreferences sharedPreferences = this.mSP;
        if (sharedPreferences == null) {
            LLog.e(TAG, "please call initialize first");
            return null;
        }
        if (!sharedPreferences.contains("settings")) {
            LLog.i(TAG, "Lynx load local cached settings: no cached.");
            return null;
        }
        try {
            return this.mSP.getString("settings", "");
        } catch (ClassCastException e) {
            LLog.e(TAG, "Lynx load local cached settings exception " + e);
            return null;
        }
    }

    private HashMap<String, Object> convertCachedStringToMap(String str) {
        Object th;
        HashMap<String, Object> hashMap;
        IllegalStateException e;
        Gson gson;
        JsonElement jsonElement;
        if (str == null) {
            return null;
        }
        try {
            gson = sGson;
            jsonElement = (JsonElement) gson.fromJson(str, JsonElement.class);
        } catch (JsonParseException e2) {
            e = e2;
            e = e;
            hashMap = null;
            LLog.e(TAG, "Lynx settings initialize exception " + e);
            return hashMap;
        } catch (IllegalStateException e3) {
            e = e3;
            e = e;
            hashMap = null;
            LLog.e(TAG, "Lynx settings initialize exception " + e);
            return hashMap;
        } catch (Throwable th2) {
            th = th2;
            hashMap = null;
        }
        if (jsonElement == null) {
            return null;
        }
        hashMap = (HashMap) gson.fromJson(jsonElement.getAsJsonObject(), HashMap.class);
        try {
            LLog.i(TAG, "Lynx load local cached settings success");
        } catch (IllegalStateException e4) {
            e = e4;
            LLog.e(TAG, "Lynx settings initialize exception " + e);
            return hashMap;
        } catch (JsonParseException e5) {
            e = e5;
            LLog.e(TAG, "Lynx settings initialize exception " + e);
            return hashMap;
        } catch (Throwable th3) {
            th = th3;
            LLog.e(TAG, "Lynx settings unexpected exception " + th);
            return hashMap;
        }
        return hashMap;
    }

    public void setSettingsWithTime(String str, long j) {
        LLog.i(TAG, "Lynx setSettings " + str);
        try {
            JsonObject jsonObject = (JsonObject) sGson.fromJson(str, JsonObject.class);
            if (jsonObject == null || !jsonObject.isJsonObject()) {
                return;
            }
            setSettingsJsonObjectWithTime(jsonObject, j);
        } catch (JsonParseException e) {
            LLog.e(TAG, "Lynx set settings exception " + e);
        } catch (Throwable th) {
            LLog.e(TAG, "Lynx settings unexpected exception " + th);
        }
    }

    @Deprecated
    public void setSettingsWithContent(String str) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        long currentTimeMillis;
        TraceEvent.beginSection(TraceEventDef.SETTINGS_UPDATE_MESSAGE);
        try {
            JsonElement jsonElement3 = (JsonElement) sGson.fromJson(str, JsonElement.class);
            if (jsonElement3 != null && (jsonElement = jsonElement3.getAsJsonObject().get("data")) != null && (jsonElement2 = jsonElement.getAsJsonObject().get("settings")) != null) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonObject().getAsJsonPrimitive("settings_time");
                if (asJsonPrimitive != null && asJsonPrimitive.isString() && !asJsonPrimitive.getAsString().isEmpty()) {
                    currentTimeMillis = Long.parseLong(asJsonPrimitive.getAsString());
                } else {
                    currentTimeMillis = System.currentTimeMillis() / 1000;
                }
                setSettingsJsonObjectWithTime(jsonElement2.getAsJsonObject(), currentTimeMillis);
            }
        } catch (IllegalArgumentException e) {
            e = e;
            LLog.e(TAG, "Lynx settings setSettingsWithContent exception " + e);
        } catch (JsonParseException e2) {
            e = e2;
            LLog.e(TAG, "Lynx settings setSettingsWithContent exception " + e);
        } catch (IllegalStateException e3) {
            e = e3;
            LLog.e(TAG, "Lynx settings setSettingsWithContent exception " + e);
        } catch (Throwable th) {
            LLog.e(TAG, "Lynx settings unexpected exception " + th);
        }
        TraceEvent.endSection(TraceEventDef.SETTINGS_UPDATE_MESSAGE);
    }

    private void setSettingsJsonObjectWithTime(JsonObject jsonObject, long j) {
        String jsonObject2 = jsonObject.toString();
        if (LynxLiteConfigs.enablePrimJSTrail()) {
            SettingsManager.inst().setSettingsWithTime(jsonObject2, Integer.valueOf((int) j), this.mContext);
        }
        synchronized (this) {
            SharedPreferences sharedPreferences = this.mSP;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("settings", jsonObject2).putLong("settings_time", j).apply();
            }
        }
        updateSettings((HashMap) sGson.fromJson(jsonObject, HashMap.class));
    }

    private void updateSettings(HashMap<String, Object> hashMap) {
        this.sExperimentSettingsLock.readLock().lock();
        HashMap<String, Object> hashMap2 = this.mSettingsMap;
        boolean z = hashMap2 == null || !hashMap2.equals(hashMap);
        this.sExperimentSettingsLock.readLock().unlock();
        if (z) {
            this.sExperimentSettingsLock.writeLock().lock();
            this.mSettingsMap = hashMap;
            this.sExperimentSettingsLock.writeLock().unlock();
            ILynxSettingsManagerDelegate iLynxSettingsManagerDelegate = this.mDelegate;
            if (iLynxSettingsManagerDelegate != null) {
                iLynxSettingsManagerDelegate.willUpdateSettings(this.mContext);
            }
            LynxEnv.inst().setSettings(this.mSettingsMap);
            return;
        }
        LLog.i(TAG, "settings hash not changed");
    }

    public HashMap<String, Object> getSettingsCopy() {
        return convertCachedStringToMap(tryToLoadLocalCachedSettingsString());
    }

    public Object getObjectFromSettings(String str) {
        if (this.mSettingsMap != null) {
            this.sExperimentSettingsLock.readLock().lock();
            Object obj = this.mSettingsMap.get("lynx_common");
            this.sExperimentSettingsLock.readLock().unlock();
            if (obj instanceof Map) {
                return ((Map) obj).get(str);
            }
        }
        return null;
    }

    public String getStringFromSettings(String str) {
        if (this.mSettingsMap != null) {
            this.sExperimentSettingsLock.readLock().lock();
            Object obj = this.mSettingsMap.get("lynx_common");
            this.sExperimentSettingsLock.readLock().unlock();
            if (obj instanceof Map) {
                Object obj2 = ((Map) obj).get(str);
                if (obj2 instanceof String) {
                    return (String) obj2;
                }
                if ((obj2 instanceof Integer) || (obj2 instanceof Boolean)) {
                    return obj2.toString();
                }
                LLog.e(TAG, "Unknown value type: " + obj2);
            }
        }
        return null;
    }
}
