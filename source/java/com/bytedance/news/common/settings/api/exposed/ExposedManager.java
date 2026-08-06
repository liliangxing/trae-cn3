package com.bytedance.news.common.settings.api.exposed;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.news.common.settings.api.DebugTeller;
import com.bytedance.news.common.settings.api.SettingsReportingService;
import com.bytedance.news.common.settings.internal.IConfig;
import com.bytedance.platform.settingsx.api.GlobalConfig;
import com.bytedance.platform.settingsx.api.exposed.ExposedManagerX;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ExposedManager {
    private static final String KET_VID_INFO = "key_vid_info";
    private static final String KEY_UPDATE_VERSION_CODE = "key_update_version_code";
    private static final String TAG = "ExposedManager";
    public static final String TAG_SETTINGS_AUTO_TEST = "settings_auto_test";
    private static ExposedManagerX exposedManagerX = null;
    private static volatile long initSystemTime = -1;
    private static volatile boolean isReportSettingsStack = false;
    private static IConfig mIconfig = null;
    public static volatile DebugTeller sDebugTeller = null;
    private static volatile ExposedManager sInstance = null;
    private static ConcurrentHashMap sReprotedKeys = new ConcurrentHashMap();
    private static ConcurrentHashMap sUsedKeys = new ConcurrentHashMap();
    private static volatile long settingsUsingTime = -1;
    private static volatile boolean useOneSpForAppSettings;
    private volatile boolean isSetUpdateVersionCode;
    private SharedPreferences.Editor mExposedEditor;
    private SharedPreferences mExposedSp;
    private SharedPreferences.Editor mLocalClientVidInfoEditor;
    private SharedPreferences mLocalClientVidInfoSp;
    private JSONObject mVidInfo;
    private SharedPreferences mVidInfoSp;

    public static void enableSettingsX(boolean z) {
    }

    public static boolean isReportSettingsStack() {
        return false;
    }

    public static ExposedManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (ExposedManager.class) {
                if (sInstance == null) {
                    sInstance = new ExposedManager(context);
                }
            }
        }
        return sInstance;
    }

    private ExposedManager(Context context) {
        this.mVidInfoSp = context.getSharedPreferences("__ab_vid_info.sp", 0);
        this.mExposedSp = context.getSharedPreferences("__ab_exposed_info.sp", 0);
        SharedPreferences sharedPreferences = context.getSharedPreferences("__ab_local_exposed_info.sp", 0);
        this.mLocalClientVidInfoSp = sharedPreferences;
        this.mLocalClientVidInfoEditor = sharedPreferences.edit();
        this.mExposedEditor = this.mExposedSp.edit();
        String string = this.mVidInfoSp.getString(KET_VID_INFO, "");
        if (!TextUtils.isEmpty(string)) {
            try {
                this.mVidInfo = new JSONObject(string);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (GlobalConfig.isManagerInit()) {
            exposedManagerX = ExposedManagerX.getInstance(context);
        }
    }

    public static void setDebugTeller(DebugTeller debugTeller) {
        if (sDebugTeller == null) {
            sDebugTeller = debugTeller;
        }
    }

    public synchronized void updateVidInfo(JSONObject jSONObject) {
        this.mVidInfo = jSONObject;
        this.mVidInfoSp.edit().putString(KET_VID_INFO, jSONObject.toString()).apply();
        for (String str : this.mExposedSp.getAll().keySet()) {
            if (!this.mVidInfo.has(str)) {
                this.mExposedEditor.remove(str);
            } else {
                try {
                    if (this.mVidInfo.optLong(str) != Long.parseLong(this.mExposedSp.getString(str, ViewVisibleBridge.INVISIBLE))) {
                        this.mExposedEditor.remove(str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.mExposedEditor.apply();
        ExposedManagerX exposedManagerX2 = exposedManagerX;
        if (exposedManagerX2 != null) {
            exposedManagerX2.updateVidInfo(jSONObject);
        }
    }

    public void markExposed(String str) {
        IConfig iConfig;
        SettingsReportingService settingsReportingService;
        sUsedKeys.put(str, Long.valueOf(System.currentTimeMillis()));
        if (sDebugTeller != null && sDebugTeller.isDebug().booleanValue() && (iConfig = mIconfig) != null && (settingsReportingService = iConfig.getSettingsReportingService()) != null) {
            settingsReportingService.m140i(TAG_SETTINGS_AUTO_TEST, str);
        }
        if (this.mVidInfo != null) {
            synchronized (this) {
                JSONObject jSONObject = this.mVidInfo;
                if (jSONObject != null) {
                    long optLong = jSONObject.optLong(str);
                    if (optLong > 0) {
                        if (!this.mExposedSp.contains(str)) {
                            this.mExposedEditor.putString(str, String.valueOf(optLong)).apply();
                        } else {
                            try {
                                if (optLong != Long.parseLong(this.mExposedSp.getString(str, ViewVisibleBridge.INVISIBLE))) {
                                    this.mExposedEditor.putString(str, String.valueOf(optLong)).apply();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public void markLocalClientExposed(String str) {
        if (TextUtils.isEmpty(str) || this.mLocalClientVidInfoSp == null) {
            return;
        }
        synchronized (this) {
            SharedPreferences sharedPreferences = this.mLocalClientVidInfoSp;
            if (sharedPreferences != null && !sharedPreferences.contains(str)) {
                this.mLocalClientVidInfoSp.edit().putString(str, str).apply();
            }
        }
    }

    public String getExposedVids() {
        if (this.mVidInfo == null && this.mLocalClientVidInfoSp == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (this.mVidInfo != null) {
            getExposedAppSettingsVids(sb);
        }
        if (this.mLocalClientVidInfoSp != null) {
            getExposedLocalSettingsVids(sb);
        }
        return sb.toString();
    }

    public String getExposedAppSettingsVids() {
        return getExposedAppSettingsVids(null);
    }

    private String getExposedAppSettingsVids(StringBuilder sb) {
        String exposedVids;
        if (this.mVidInfo == null) {
            return null;
        }
        if (sb == null) {
            sb = new StringBuilder();
        }
        try {
            for (Object obj : this.mExposedSp.getAll().values()) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ExposedManagerX exposedManagerX2 = exposedManagerX;
        if (exposedManagerX2 != null && (exposedVids = exposedManagerX2.getExposedVids()) != null && exposedVids.length() > 1) {
            if (sb.length() > 1) {
                sb.append(",");
            }
            sb.append(exposedVids);
        }
        return sb.toString();
    }

    public String getExposedLocalSettingsVids() {
        return getExposedLocalSettingsVids(null);
    }

    private String getExposedLocalSettingsVids(StringBuilder sb) {
        if (this.mLocalClientVidInfoSp == null) {
            return null;
        }
        if (sb == null) {
            sb = new StringBuilder();
        }
        try {
            for (Map.Entry<String, ?> entry : this.mLocalClientVidInfoSp.getAll().entrySet()) {
                if (!TextUtils.equals(entry.getKey(), KEY_UPDATE_VERSION_CODE)) {
                    Object value = entry.getValue();
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void setUpdateVersionCode(String str) {
        if (this.isSetUpdateVersionCode) {
            return;
        }
        this.isSetUpdateVersionCode = true;
        SharedPreferences sharedPreferences = this.mLocalClientVidInfoSp;
        if (sharedPreferences != null && this.mLocalClientVidInfoEditor != null) {
            String string = sharedPreferences.getString(KEY_UPDATE_VERSION_CODE, "");
            if (TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty(str)) {
                    this.mLocalClientVidInfoEditor.putString(KEY_UPDATE_VERSION_CODE, "").apply();
                } else {
                    this.mLocalClientVidInfoEditor.putString(KEY_UPDATE_VERSION_CODE, str).apply();
                }
            } else if (!TextUtils.equals(string, str)) {
                this.mLocalClientVidInfoEditor.clear().apply();
            }
        }
        ExposedManagerX exposedManagerX2 = exposedManagerX;
        if (exposedManagerX2 != null) {
            exposedManagerX2.setUpdateVersionCode(str);
        }
    }

    public static boolean needsReporting(String str) {
        if (!isReportSettingsStack || sReprotedKeys.containsKey(str)) {
            return false;
        }
        sReprotedKeys.put(str, "");
        return true;
    }

    public static boolean isUseOneSpForAppSettingsStatic() {
        return useOneSpForAppSettings;
    }

    public static void setUseOneSpForAppSettingsStatic(boolean z) {
        useOneSpForAppSettings = z;
    }

    public boolean isUseOneSpForAppSettings() {
        return useOneSpForAppSettings;
    }

    public static void setReportSettingsStack(boolean z) {
        isReportSettingsStack = z;
    }

    public static void setInitSystemTime(long j) {
        initSystemTime = j;
    }

    public static long getSettingsUsingTime() {
        if (initSystemTime < 0) {
            initSystemTime = System.currentTimeMillis();
        }
        settingsUsingTime = System.currentTimeMillis() - initSystemTime;
        return settingsUsingTime;
    }

    public static void setIconfig(IConfig iConfig) {
        mIconfig = iConfig;
    }

    public static ConcurrentHashMap<String, Long> getUsedKeys() {
        return sUsedKeys;
    }
}
