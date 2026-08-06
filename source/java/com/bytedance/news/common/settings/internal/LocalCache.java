package com.bytedance.news.common.settings.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.SettingsConfig;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.SettingsReportingService;
import com.bytedance.news.common.settings.api.exposed.ExposedManager;
import com.bytedance.news.common.settings.api.model.DiffSettingsData;
import com.bytedance.platform.settingsx.manager.SettingsManager;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LocalCache {
    public static final String DIFF_SETTINGS_REPORT_TAG = "diff_setting_report_tag";
    private static final long DIFF_TIMESTAMP_EXPIRE_TIME = 259200000;
    private static volatile LocalCache INSTANCE = null;
    private static final String KEY_DIFF_APP_SETTINGS_TIMESTAMP = "key_diff_app_settings_timestamp";
    private static final String KEY_LAST_UPDATE_TOKEN = "key_last_update_token";
    private static final String KEY_LOCAL_APP_SETTINGS_DATA = "key_local_app_settings_data";
    private static final String KEY_LOCAL_SETTINGS_DFF_LAST = "key_local_settings_dff_last";
    private static final String KEY_LOCAL_USER_SETTINGS_DATA = "key_local_user_settings_data";
    private static final String KEY_SAFE_MODE_EXPIRING_TIME = "key_safe_mode_expiring_time";
    private static final String KEY_SAFE_MODE_FIXED_SETTINGS = "key_safe_mode_fixed_settings";
    private static final String KEY_SAFE_MODE_FIXING_TIMESTAMP = "key_safe_mode_fixing_timestamp";
    private static final String KEY_TIMESTAMP = "settings_sdk_timestamp";
    private static final String SP_DIFF_SETTINGS = "diff_settings.sp";
    public static boolean sEnableOptDiff;
    public static boolean sEnableOptDiffCheck;
    private Context mContext;
    private SharedPreferences mDiffSharedP;
    private SharedPreferences mSharedP;
    private Executor singleExecutor;
    private Map<String, SettingsData> mCache = new ConcurrentHashMap();
    private final SettingsData EMPTY = new SettingsData(null, null, "", false);

    public static LocalCache getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (LocalCache.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalCache(context);
                }
            }
        }
        return INSTANCE;
    }

    private LocalCache(Context context) {
        this.singleExecutor = null;
        this.mContext = context;
        SettingsConfigProvider settingsConfigProvider = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
        if (settingsConfigProvider != null && settingsConfigProvider.getConfig() != null) {
            this.mSharedP = settingsConfigProvider.getConfig().getSharedPreferences(context, "__local_settings_data.sp", 0, false);
        }
        if (this.mSharedP == null) {
            this.mSharedP = context.getSharedPreferences("__local_settings_data.sp", 0);
        }
        this.singleExecutor = Executors.newSingleThreadExecutor();
    }

    public synchronized SettingsData getLocalSettingsData(String str) {
        JSONObject jSONObject;
        SettingsData settingsData = this.mCache.get(str);
        if (settingsData != null) {
            if (settingsData == this.EMPTY) {
                settingsData = null;
            }
            return settingsData;
        }
        String string = this.mSharedP.getString(convertKey(KEY_LOCAL_APP_SETTINGS_DATA, str), "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject2 = new JSONObject(string);
                String string2 = this.mSharedP.getString(convertKey(KEY_LOCAL_USER_SETTINGS_DATA, str), "");
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject = new JSONObject(string2);
                } else {
                    jSONObject = new JSONObject();
                }
                SettingsData settingsData2 = new SettingsData(jSONObject2, jSONObject, this.mSharedP.getString(convertKey(KEY_LAST_UPDATE_TOKEN, str), ""), false);
                this.mCache.put(str, settingsData2);
                return settingsData2;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.mCache.put(str, this.EMPTY);
        return null;
    }

    public JSONObject getAppSettingsDataFromStorage(String str) {
        String string = this.mSharedP.getString(convertKey(KEY_LOCAL_APP_SETTINGS_DATA, str), "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public synchronized void updateSingleSettingsData(JSONObject jSONObject, String str) {
        if (ExposedManager.sDebugTeller != null && ExposedManager.sDebugTeller.isDebug().booleanValue()) {
            String next = jSONObject.keys().next();
            SettingsData localSettingsData = getLocalSettingsData(str);
            if (localSettingsData != null) {
                JSONObject appSettings = localSettingsData.getAppSettings();
                try {
                    appSettings.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                SettingsManager.updateAppSettingsForDebug(appSettings);
                this.mCache.put(str, localSettingsData);
                SharedPreferences.Editor edit = this.mSharedP.edit();
                try {
                    edit.putString(convertKey(KEY_LOCAL_APP_SETTINGS_DATA, str), appSettings.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                edit.apply();
            }
        }
    }

    public synchronized void setLocalSettingsData(final SettingsData settingsData, final SettingsConfig settingsConfig, final boolean z) {
        final SettingsData localSettingsData = getLocalSettingsData(settingsConfig.getId());
        if (localSettingsData != null) {
            if (settingsConfig.isLocalSettingsDataAsync()) {
                if (this.singleExecutor == null) {
                    this.singleExecutor = Executors.newSingleThreadExecutor();
                }
                this.singleExecutor.execute(new Runnable() { // from class: com.bytedance.news.common.settings.internal.LocalCache.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            LocalCache.this.markDiffSettings(settingsData, settingsConfig, z, localSettingsData);
                        } catch (ConcurrentModificationException unused) {
                        }
                    }
                });
            } else {
                try {
                    markDiffSettings(settingsData, settingsConfig, z, localSettingsData);
                } catch (ConcurrentModificationException unused) {
                }
            }
        } else {
            this.mCache.put(settingsConfig.getId(), settingsData);
            SharedPreferences.Editor edit = this.mSharedP.edit();
            try {
                edit.putString(convertKey(KEY_LAST_UPDATE_TOKEN, settingsConfig.getId()), settingsData.getToken());
            } catch (Exception e) {
                e.printStackTrace();
            }
            JSONObject appSettings = settingsData.getAppSettings();
            JSONObject userSettings = settingsData.getUserSettings();
            try {
                edit.putString(convertKey(KEY_LOCAL_APP_SETTINGS_DATA, settingsConfig.getId()), appSettings != null ? appSettings.toString() : "");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                edit.putString(convertKey(KEY_LOCAL_USER_SETTINGS_DATA, settingsConfig.getId()), userSettings != null ? userSettings.toString() : "");
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            edit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markDiffSettings(SettingsData settingsData, SettingsConfig settingsConfig, boolean z, SettingsData settingsData2) {
        if (settingsData2 == null) {
            return;
        }
        JSONObject appSettings = settingsData2.getAppSettings();
        JSONObject userSettings = settingsData2.getUserSettings();
        if (appSettings == null) {
            appSettings = new JSONObject();
        }
        JSONObject jSONObject = appSettings;
        JSONObject jSONObject2 = userSettings == null ? new JSONObject() : userSettings;
        JSONObject appSettings2 = settingsData.getAppSettings();
        JSONObject jSONObject3 = new JSONObject();
        if (appSettings2 != null) {
            Iterator<String> keys = appSettings2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    Object opt = appSettings2.opt(next);
                    Object opt2 = jSONObject.opt(next);
                    if ((opt instanceof JSONObject) && (opt2 instanceof JSONObject)) {
                        try {
                            if (compareJson((JSONObject) opt2, (JSONObject) opt)) {
                                updateOldSettings(jSONObject3, jSONObject, next, opt);
                            }
                        } catch (Exception unused) {
                            if (!TextUtils.equals(String.valueOf(opt), String.valueOf(opt2))) {
                                updateOldSettings(jSONObject3, jSONObject, next, opt);
                            }
                        }
                    } else if (!TextUtils.equals(String.valueOf(opt), String.valueOf(opt2))) {
                        updateOldSettings(jSONObject3, jSONObject, next, opt);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        JSONObject userSettings2 = settingsData.getUserSettings();
        if (userSettings2 != null) {
            Iterator<String> keys2 = userSettings2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                try {
                    Object opt3 = userSettings2.opt(next2);
                    Object opt4 = jSONObject2.opt(next2);
                    if ((opt3 instanceof JSONObject) && (opt4 instanceof JSONObject)) {
                        try {
                            if (compareJson((JSONObject) opt4, (JSONObject) opt3)) {
                                updateOldSettings(jSONObject3, jSONObject, next2, opt3);
                            }
                        } catch (Exception unused2) {
                            if (!TextUtils.equals(String.valueOf(opt3), String.valueOf(opt4))) {
                                updateOldSettings(jSONObject3, jSONObject2, next2, opt3);
                            }
                        }
                    } else if (!TextUtils.equals(String.valueOf(opt3), String.valueOf(opt4))) {
                        updateOldSettings(jSONObject3, jSONObject2, next2, opt3);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        saveToSp(settingsData, settingsConfig, z, settingsData2, jSONObject, jSONObject2, appSettings2, jSONObject3, userSettings2);
    }

    private synchronized void saveToSp(SettingsData settingsData, SettingsConfig settingsConfig, boolean z, SettingsData settingsData2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        settingsData2.setAppSettings(jSONObject);
        settingsData2.setUserSettings(jSONObject2);
        this.mCache.put(settingsConfig.getId(), settingsData2);
        SharedPreferences.Editor edit = this.mSharedP.edit();
        try {
            edit.putString(convertKey(KEY_LAST_UPDATE_TOKEN, settingsConfig.getId()), settingsData.getToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            edit.putString(convertKey(KEY_LOCAL_APP_SETTINGS_DATA, settingsConfig.getId()), jSONObject3 != null ? jSONObject.toString() : "");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            edit.putString(convertKey(KEY_LOCAL_USER_SETTINGS_DATA, settingsConfig.getId()), jSONObject5 != null ? jSONObject2.toString() : "");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        edit.apply();
        saveDiffContent(jSONObject4, settingsConfig, z);
    }

    private void updateOldSettings(JSONObject jSONObject, JSONObject jSONObject2, String str, Object obj) throws JSONException {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put(str, obj);
        jSONObject2.put(str, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0106 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void saveDiffContent(JSONObject jSONObject, SettingsConfig settingsConfig, boolean z) {
        Exception exc;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        boolean isReportSettingDiff;
        String string;
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        if (this.mDiffSharedP == null) {
            this.mDiffSharedP = context.getSharedPreferences(SP_DIFF_SETTINGS, 0);
        }
        SharedPreferences.Editor edit = this.mDiffSharedP.edit();
        if (z) {
            try {
                String string2 = this.mDiffSharedP.getString(convertKey(KEY_LOCAL_APP_SETTINGS_DATA, settingsConfig.getId()), "");
                if (!TextUtils.isEmpty(string2)) {
                    edit.putString(convertKey(KEY_LOCAL_SETTINGS_DFF_LAST, settingsConfig.getId()), string2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            edit.apply();
            return;
        }
        JSONObject jSONObject4 = null;
        try {
            string = this.mDiffSharedP.getString(convertKey(KEY_DIFF_APP_SETTINGS_TIMESTAMP, settingsConfig.getId()), "");
            jSONObject3 = new JSONObject();
        } catch (Exception e2) {
            exc = e2;
            jSONObject2 = null;
        }
        try {
            if (!TextUtils.isEmpty(string)) {
                jSONObject4 = new JSONObject(string);
            } else {
                jSONObject4 = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            long currentTimeMillis = System.currentTimeMillis();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject3.put(next, jSONObject.opt(next));
                jSONObject4.put(next, currentTimeMillis);
            }
            Iterator<String> keys2 = jSONObject4.keys();
            ArrayList arrayList = new ArrayList();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (currentTimeMillis - jSONObject4.optLong(next2, currentTimeMillis) > DIFF_TIMESTAMP_EXPIRE_TIME) {
                    arrayList.add(next2);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONObject4.remove((String) it.next());
            }
        } catch (Exception e3) {
            exc = e3;
            jSONObject2 = jSONObject4;
            jSONObject4 = jSONObject3;
            exc.printStackTrace();
            jSONObject3 = jSONObject4;
            jSONObject4 = jSONObject2;
            if (jSONObject3 != null) {
            }
            if (jSONObject4 != null) {
            }
            edit.apply();
            isReportSettingDiff = settingsConfig.isReportSettingDiff();
            SettingsReportingService settingsReportingService = settingsConfig.getSettingsReportingService();
            if (isReportSettingDiff) {
                return;
            } else {
                return;
            }
        }
        if (jSONObject3 != null) {
            try {
                jSONObject3.put(KEY_TIMESTAMP, System.currentTimeMillis());
                edit.putString(convertKey(KEY_LOCAL_APP_SETTINGS_DATA, settingsConfig.getId()), jSONObject3.toString());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (jSONObject4 != null) {
            try {
                edit.putString(convertKey(KEY_DIFF_APP_SETTINGS_TIMESTAMP, settingsConfig.getId()), jSONObject4.toString());
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        edit.apply();
        isReportSettingDiff = settingsConfig.isReportSettingDiff();
        SettingsReportingService settingsReportingService2 = settingsConfig.getSettingsReportingService();
        if (isReportSettingDiff || settingsReportingService2 == null || jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        settingsReportingService2.m140i(DIFF_SETTINGS_REPORT_TAG, jSONObject.toString());
    }

    public synchronized DiffSettingsData getLocalDiffSettingsData() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        CopyOnWriteArrayList copyOnWriteArrayList3;
        if (this.mDiffSharedP == null) {
            this.mDiffSharedP = this.mContext.getSharedPreferences(SP_DIFF_SETTINGS, 0);
        }
        copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        copyOnWriteArrayList3 = new CopyOnWriteArrayList();
        for (Map.Entry<String, ?> entry : this.mDiffSharedP.getAll().entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                if (key.contains(KEY_LOCAL_APP_SETTINGS_DATA)) {
                    String valueOf = String.valueOf(entry.getValue());
                    if (!TextUtils.isEmpty(valueOf)) {
                        try {
                            copyOnWriteArrayList.add(new JSONObject(valueOf));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (key.contains(KEY_DIFF_APP_SETTINGS_TIMESTAMP)) {
                    String valueOf2 = String.valueOf(entry.getValue());
                    if (!TextUtils.isEmpty(valueOf2)) {
                        try {
                            copyOnWriteArrayList3.add(new JSONObject(valueOf2));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (key.contains(KEY_LOCAL_SETTINGS_DFF_LAST)) {
                    String valueOf3 = String.valueOf(entry.getValue());
                    if (!TextUtils.isEmpty(valueOf3)) {
                        try {
                            copyOnWriteArrayList2.add(new JSONObject(valueOf3));
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        }
        return new DiffSettingsData(copyOnWriteArrayList, copyOnWriteArrayList3, copyOnWriteArrayList2);
    }

    private static String convertKey(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : str + RomVersionParamHelper.SEPARATOR + str2;
    }

    public boolean isInSafeMode() {
        if (this.mSharedP.contains(KEY_SAFE_MODE_FIXING_TIMESTAMP) && this.mSharedP.contains(KEY_SAFE_MODE_EXPIRING_TIME)) {
            r2 = System.currentTimeMillis() - this.mSharedP.getLong(KEY_SAFE_MODE_FIXING_TIMESTAMP, 0L) <= this.mSharedP.getLong(KEY_SAFE_MODE_EXPIRING_TIME, 0L);
            if (!r2) {
                quitSafeMode();
            }
        }
        return r2;
    }

    public JSONObject getFixedSettings() {
        try {
            return new JSONObject(this.mSharedP.getString(KEY_SAFE_MODE_FIXED_SETTINGS, "{}"));
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    public void quitSafeMode() {
        this.mSharedP.edit().remove(KEY_SAFE_MODE_FIXING_TIMESTAMP).remove(KEY_SAFE_MODE_EXPIRING_TIME).remove(KEY_SAFE_MODE_FIXED_SETTINGS).apply();
    }

    public static boolean compareJson(JSONObject jSONObject, JSONObject jSONObject2) {
        if (sEnableOptDiff) {
            return !JSONSimilarUtil.similar(jSONObject2, jSONObject);
        }
        if (sEnableOptDiffCheck) {
            boolean z = !JSONSimilarUtil.similar(jSONObject2, jSONObject);
            String valueOf = String.valueOf(jSONObject2);
            String valueOf2 = String.valueOf(jSONObject);
            JsonObject parse = new JsonParser().parse(valueOf);
            boolean z2 = (parse == null || parse.equals(new JsonParser().parse(valueOf2))) ? false : true;
            System.out.println("LocalCache markdiff opt result: " + z + ", check result: " + z2);
            if (z2 != z) {
                HashMap hashMap = new HashMap();
                hashMap.put("old_value", jSONObject.toString());
                hashMap.put("new_value", jSONObject2.toString());
                EnsureManager.ensureNotReachHere(new Exception("LocalCache markdiff opt result: " + z + ", check result: " + z2), "local_cache_diff", hashMap);
            }
            return z2;
        }
        String valueOf3 = String.valueOf(jSONObject2);
        String valueOf4 = String.valueOf(jSONObject);
        JsonObject parse2 = new JsonParser().parse(valueOf3);
        return (parse2 == null || parse2.equals(new JsonParser().parse(valueOf4))) ? false : true;
    }
}
