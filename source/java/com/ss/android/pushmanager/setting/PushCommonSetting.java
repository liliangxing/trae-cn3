package com.ss.android.pushmanager.setting;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.push.utils.Logger;
import com.ss.android.common.applog.TeaAgent;
import com.ss.android.message.AppProvider;
import com.ss.android.pushmanager.PushCommonConstants;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PushCommonSetting {
    public static final String DEPTHS_DEVICE_ID = "depths_device_id";
    private static final String SP_CONFIG_NAME = "push_multi_process_config";
    public static final String SSIDS = "ssids";
    public static final String TAG = "PushCommonSetting";
    private static Map<String, Boolean> pushOnlineSettingsCache = new HashMap();
    private static PushCommonSetting sPushSetting;
    private SharedPreferences prefs = null;
    private PushMultiProcessSharedProvider.MultiProcessShared multiProcessShared = PushMultiProcessSharedProvider.getMultiprocessShared(AppProvider.getApp());

    public static synchronized void init(Context context) {
        synchronized (PushCommonSetting.class) {
            AppProvider.initApp((Application) context.getApplicationContext());
        }
    }

    public static synchronized PushCommonSetting getInstance() {
        PushCommonSetting pushCommonSetting;
        synchronized (PushCommonSetting.class) {
            if (sPushSetting == null) {
                synchronized (PushCommonSetting.class) {
                    if (sPushSetting == null) {
                        sPushSetting = new PushCommonSetting();
                    }
                }
            }
            pushCommonSetting = sPushSetting;
        }
        return pushCommonSetting;
    }

    private PushCommonSetting() {
    }

    public void saveSSIDs(Map<String, String> map) {
        if (map == null) {
            return;
        }
        if (Logger.debug()) {
            Logger.d("PushService", "saveSSIDs start");
        }
        try {
            this.multiProcessShared.edit().putString(SSIDS, StringUtils.mapToString(map)).apply();
        } catch (Exception unused) {
        }
    }

    public String getSsids() {
        return this.multiProcessShared.getString(SSIDS, "");
    }

    public void getSSIDs(Map<String, String> map) {
        if (map == null) {
            return;
        }
        if (Logger.debug()) {
            Logger.d("PushService", "getSSIDs start");
        }
        try {
            String ssids = getSsids();
            Logger.d("PushService", "getSSIDs result is " + ssids);
            if (StringUtils.isEmpty(ssids)) {
                try {
                    Logger.d("PushService", "backup getSSIDs by TeaAgent");
                    TeaAgent.getSSIDs(map);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            StringUtils.stringToMap(ssids, map);
        } catch (Exception unused2) {
        }
    }

    public String getDeviceId() {
        HashMap hashMap = new HashMap();
        getSSIDs(hashMap);
        return hashMap.get("device_id");
    }

    public String getUserId() {
        HashMap hashMap = new HashMap();
        getSSIDs(hashMap);
        return hashMap.get("user_id");
    }

    public String getAlias() {
        HashMap hashMap = new HashMap();
        getSSIDs(hashMap);
        return hashMap.get(PushCommonConstants.KEY_ALIAS);
    }

    private SharedPreferences getSp() {
        if (this.prefs == null) {
            this.prefs = AppProvider.getApp().getSharedPreferences("push_multi_process_config", 4);
        }
        return this.prefs;
    }

    @Deprecated
    public void setPref(String str, boolean z) {
        SharedPreferences.Editor edit = getSp().edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    @Deprecated
    public void setPref(String str, String str2) {
        SharedPreferences.Editor edit = getSp().edit();
        edit.putString(str, str2);
        edit.apply();
    }

    @Deprecated
    public void setPref(String str, Set<String> set) {
        SharedPreferences.Editor edit = getSp().edit();
        edit.putStringSet(str, set);
        edit.apply();
    }

    @Deprecated
    public void setPref(String str, float f) {
        SharedPreferences.Editor edit = getSp().edit();
        edit.putFloat(str, f);
        edit.apply();
    }

    @Deprecated
    public void setPref(String str, int i) {
        SharedPreferences.Editor edit = getSp().edit();
        edit.putInt(str, i);
        edit.apply();
    }

    @Deprecated
    public void setPref(String str, long j) {
        SharedPreferences.Editor edit = getSp().edit();
        edit.putLong(str, j);
        edit.apply();
    }

    @Deprecated
    public boolean getPref(String str, Boolean bool) {
        return getSp().getBoolean(str, bool.booleanValue());
    }

    @Deprecated
    public String getPref(String str, String str2) {
        return getSp().getString(str, str2);
    }

    @Deprecated
    public Set<String> getPref(String str, Set<String> set) {
        return getSp().getStringSet(str, set);
    }

    @Deprecated
    public int getPref(String str, int i) {
        return getSp().getInt(str, i);
    }

    @Deprecated
    public long getPref(String str, long j) {
        return getSp().getLong(str, j);
    }

    @Deprecated
    public float getPref(String str, float f) {
        return getSp().getFloat(str, f);
    }

    @Deprecated
    public boolean hasPrefWithKey(String str) {
        return getSp().contains(str);
    }

    @Deprecated
    public boolean removePref(String str) {
        SharedPreferences.Editor edit = getSp().edit();
        edit.remove(str);
        return edit.commit();
    }

    @Deprecated
    public void clear() {
        SharedPreferences.Editor edit = getSp().edit();
        edit.clear();
        edit.commit();
    }

    public boolean isApplicationActive() {
        return this.multiProcessShared.isApplicationActive();
    }

    public boolean isAppForeground() {
        return this.multiProcessShared.isApplicationForeground();
    }

    private static boolean getValueFromPushOnlineSettingsSp(String str, boolean z) {
        try {
            Boolean bool = pushOnlineSettingsCache.get(str);
            if (bool != null) {
                Logger.d(TAG, "[getValueFromPushOnlineSettingsSp]return cache value for " + str);
                return bool.booleanValue();
            }
            Application app = AppProvider.getApp();
            if (app == null) {
                Logger.d(TAG, "[getValueFromPushOnlineSettingsSp]return defaultValue because context is null");
                return z;
            }
            boolean z2 = app.getSharedPreferences("push_multi_process_config", 4).getBoolean(str, z);
            pushOnlineSettingsCache.put(str, Boolean.valueOf(z2));
            Logger.d(TAG, "[getValueFromPushOnlineSettingsSp]return " + z2 + " for " + str);
            return z2;
        } catch (Throwable th) {
            Logger.e(TAG, "[getValueFromPushOnlineSettingsSp]return defaultValue because exception ", th);
            return z;
        }
    }

    public static boolean optSensitiveApiInvoke() {
        return getValueFromPushOnlineSettingsSp("opt_sensitive_api_invoke", false);
    }
}
