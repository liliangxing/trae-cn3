package com.bytedance.trae.home.solo.setting.platform;

import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.Storage;
import com.bytedance.news.common.settings.api.exposed.ExposedManager;
import com.bytedance.news.common.settings.internal.GlobalConfig;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.news.common.settings.internal.InstanceCreator;
import com.bytedance.news.common.settings.internal.LocalCache;
import com.bytedance.news.common.settings.internal.MetaInfo;
import com.bytedance.sdk.open.douyin.settings.C0130f;
import com.bytedance.services.apm.api.IEnsure;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class IHomeCmpPageSettings$$Impl implements IHomeCmpPageSettings {
    private static final Gson GSON = new Gson();
    private static final int VERSION = -2131189809;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings$$Impl.1
        public <T> T create(Class<T> cls) {
            return null;
        }
    };
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public void updateSettings() {
    }

    public IHomeCmpPageSettings$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings$$Impl$2] */
    @Override // com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings
    public JsonObject getEnableCmpPages() {
        this.mExposedManager.markExposed("enable_cmp_pages");
        if (ExposedManager.needsReporting("enable_cmp_pages") && this.iEnsure != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("settings_key", "enable_cmp_pages");
            hashMap.put(C0130f.f138k, String.valueOf(ExposedManager.getSettingsUsingTime()));
            hashMap.put("settings_thread_name", Thread.currentThread().getName());
            this.iEnsure.ensureNotReachHere("get settings key = enable_cmp_pages", hashMap);
        }
        if (this.mCachedSettings.containsKey("enable_cmp_pages")) {
            return (JsonObject) this.mCachedSettings.get("enable_cmp_pages");
        }
        Storage storage = this.mStorage;
        JsonObject jsonObject = null;
        if (storage != null && storage.contains("enable_cmp_pages")) {
            try {
                jsonObject = (JsonObject) GSON.fromJson(this.mStorage.getString("enable_cmp_pages"), new TypeToken<JsonObject>() { // from class: com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings$$Impl.2
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JsonObject jsonObject2 = jsonObject;
        if (jsonObject2 == null) {
            return jsonObject2;
        }
        this.mCachedSettings.put("enable_cmp_pages", jsonObject2);
        return jsonObject2;
    }

    public void updateSettings(SettingsData settingsData) {
        MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
        if (settingsData == null) {
            if (VERSION != metaInfo.getSettingsVersion("nova_settings_com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                try {
                    if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                        metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings", VERSION);
                    } else if (settingsData != null) {
                        metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings", VERSION);
                    }
                } catch (Throwable th) {
                    if (settingsData != null) {
                        metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings", VERSION);
                    }
                    IEnsure iEnsure = this.iEnsure;
                    if (iEnsure != null) {
                        iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            } else if (metaInfo.needUpdate("nova_settings_com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings", "")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
            } else if (settingsData == null) {
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("nova_settings_com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings")) {
                        settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        metaInfo.setOneSpMigrateDone("nova_settings_com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings");
                    }
                } catch (Throwable th2) {
                    IEnsure iEnsure2 = this.iEnsure;
                    if (iEnsure2 != null) {
                        iEnsure2.ensureNotReachHere(th2, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            }
        }
        if (settingsData == null || this.mStorage == null) {
            return;
        }
        JSONObject appSettings = settingsData.getAppSettings();
        if (appSettings != null && appSettings.has("enable_cmp_pages")) {
            this.mStorage.putString("enable_cmp_pages", appSettings.optString("enable_cmp_pages"));
            this.mCachedSettings.remove("enable_cmp_pages");
        }
        this.mStorage.apply();
        metaInfo.setStorageKeyUpdateToken("nova_settings_com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings", settingsData.getToken());
    }
}
