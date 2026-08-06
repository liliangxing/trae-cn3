package com.bytedance.trae.conversation.upgrade;

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
public class IUpgradeReminderSettings$$Impl implements IUpgradeReminderSettings {
    private static final Gson GSON = new Gson();
    private static final int VERSION = -648480971;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings$$Impl.1
        public <T> T create(Class<T> cls) {
            return null;
        }
    };
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public void updateSettings() {
    }

    public IUpgradeReminderSettings$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings$$Impl$2] */
    @Override // com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings
    public JsonObject getUpgradeReminderConfig() {
        JsonObject jsonObject;
        this.mExposedManager.markExposed("upgrade_reminder");
        if (ExposedManager.needsReporting("upgrade_reminder") && this.iEnsure != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("settings_key", "upgrade_reminder");
            hashMap.put(C0130f.f138k, String.valueOf(ExposedManager.getSettingsUsingTime()));
            hashMap.put("settings_thread_name", Thread.currentThread().getName());
            this.iEnsure.ensureNotReachHere("get settings key = upgrade_reminder", hashMap);
        }
        if (this.mStickySettings.containsKey("upgrade_reminder")) {
            return (JsonObject) this.mStickySettings.get("upgrade_reminder");
        }
        if (this.mCachedSettings.containsKey("upgrade_reminder")) {
            jsonObject = (JsonObject) this.mCachedSettings.get("upgrade_reminder");
        } else {
            Storage storage = this.mStorage;
            JsonObject jsonObject2 = null;
            if (storage != null && storage.contains("upgrade_reminder")) {
                try {
                    jsonObject2 = (JsonObject) GSON.fromJson(this.mStorage.getString("upgrade_reminder"), new TypeToken<JsonObject>() { // from class: com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings$$Impl.2
                    }.getType());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (jsonObject2 != null) {
                this.mCachedSettings.put("upgrade_reminder", jsonObject2);
            }
            jsonObject = jsonObject2;
        }
        if (jsonObject == null) {
            return jsonObject;
        }
        this.mStickySettings.put("upgrade_reminder", jsonObject);
        return jsonObject;
    }

    public void updateSettings(SettingsData settingsData) {
        MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
        if (settingsData == null) {
            if (VERSION != metaInfo.getSettingsVersion("nova_settings_com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                try {
                    if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                        metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings", VERSION);
                    } else if (settingsData != null) {
                        metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings", VERSION);
                    }
                } catch (Throwable th) {
                    if (settingsData != null) {
                        metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings", VERSION);
                    }
                    IEnsure iEnsure = this.iEnsure;
                    if (iEnsure != null) {
                        iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            } else if (metaInfo.needUpdate("nova_settings_com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings", "")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
            } else if (settingsData == null) {
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings")) {
                        settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        metaInfo.setOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings");
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
        if (appSettings != null && appSettings.has("upgrade_reminder")) {
            this.mStorage.putString("upgrade_reminder", appSettings.optString("upgrade_reminder"));
            this.mCachedSettings.remove("upgrade_reminder");
        }
        this.mStorage.apply();
        metaInfo.setStorageKeyUpdateToken("nova_settings_com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings", settingsData.getToken());
    }
}
