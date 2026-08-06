package com.bytedance.trae.conversation.settings;

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
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ICNBusinessSettings$$Impl implements ICNBusinessSettings {
    private static final Gson GSON = new Gson();
    private static final int VERSION = -1354403686;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.settings.ICNBusinessSettings$$Impl.1
        public <T> T create(Class<T> cls) {
            return null;
        }
    };
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public void updateSettings() {
    }

    public ICNBusinessSettings$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    @Override // com.bytedance.trae.conversation.settings.ICNBusinessSettings
    public String getSettings() {
        this.mExposedManager.markExposed("cn_buisness_settings");
        if (ExposedManager.needsReporting("cn_buisness_settings") && this.iEnsure != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("settings_key", "cn_buisness_settings");
            hashMap.put(C0130f.f138k, String.valueOf(ExposedManager.getSettingsUsingTime()));
            hashMap.put("settings_thread_name", Thread.currentThread().getName());
            this.iEnsure.ensureNotReachHere("get settings key = cn_buisness_settings", hashMap);
        }
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("cn_buisness_settings")) ? "" : this.mStorage.getString("cn_buisness_settings");
    }

    public void updateSettings(SettingsData settingsData) {
        MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
        if (settingsData == null) {
            if (VERSION != metaInfo.getSettingsVersion("cn_buisness_settings_com.bytedance.trae.conversation.settings.ICNBusinessSettings")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                try {
                    if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                        metaInfo.setSettingsVersion("cn_buisness_settings_com.bytedance.trae.conversation.settings.ICNBusinessSettings", VERSION);
                    } else if (settingsData != null) {
                        metaInfo.setSettingsVersion("cn_buisness_settings_com.bytedance.trae.conversation.settings.ICNBusinessSettings", VERSION);
                    }
                } catch (Throwable th) {
                    if (settingsData != null) {
                        metaInfo.setSettingsVersion("cn_buisness_settings_com.bytedance.trae.conversation.settings.ICNBusinessSettings", VERSION);
                    }
                    IEnsure iEnsure = this.iEnsure;
                    if (iEnsure != null) {
                        iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            } else if (metaInfo.needUpdate("cn_buisness_settings_com.bytedance.trae.conversation.settings.ICNBusinessSettings", "")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
            } else if (settingsData == null) {
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("cn_buisness_settings_com.bytedance.trae.conversation.settings.ICNBusinessSettings")) {
                        settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        metaInfo.setOneSpMigrateDone("cn_buisness_settings_com.bytedance.trae.conversation.settings.ICNBusinessSettings");
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
        if (appSettings != null && appSettings.has("cn_buisness_settings")) {
            this.mStorage.putString("cn_buisness_settings", appSettings.optString("cn_buisness_settings"));
        }
        this.mStorage.apply();
        metaInfo.setStorageKeyUpdateToken("cn_buisness_settings_com.bytedance.trae.conversation.settings.ICNBusinessSettings", settingsData.getToken());
    }
}
