package com.bytedance.android.monitorV2.settings;

import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.Storage;
import com.bytedance.news.common.settings.api.exposed.ExposedManager;
import com.bytedance.news.common.settings.internal.GlobalConfig;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.news.common.settings.internal.InstanceCreator;
import com.bytedance.news.common.settings.internal.LocalCache;
import com.bytedance.news.common.settings.internal.MetaInfo;
import com.bytedance.services.apm.api.IEnsure;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class IMonitorSettings$$Impl implements IMonitorSettings {
    private static final Gson GSON = new Gson();
    private static final int VERSION = 1649816078;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.android.monitorV2.settings.IMonitorSettings$$Impl.1
        public <T> T create(Class<T> cls) {
            return null;
        }
    };
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public IMonitorSettings$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.android.monitorV2.settings.IMonitorSettings$$Impl$2] */
    @Override // com.bytedance.android.monitorV2.settings.IMonitorSettings
    public WebBlankConfig getWebBlankConfig() {
        IEnsure iEnsure;
        if (ExposedManager.needsReporting("web_blank_config") && (iEnsure = this.iEnsure) != null) {
            iEnsure.ensureNotReachHere("get settings key = web_blank_config time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
        }
        if (this.mCachedSettings.containsKey("web_blank_config")) {
            return (WebBlankConfig) this.mCachedSettings.get("web_blank_config");
        }
        Storage storage = this.mStorage;
        WebBlankConfig webBlankConfig = null;
        if (storage != null && storage.contains("web_blank_config")) {
            try {
                webBlankConfig = (WebBlankConfig) GSON.fromJson(this.mStorage.getString("web_blank_config"), new TypeToken<WebBlankConfig>() { // from class: com.bytedance.android.monitorV2.settings.IMonitorSettings$$Impl.2
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (webBlankConfig != null) {
            this.mCachedSettings.put("web_blank_config", webBlankConfig);
        }
        return webBlankConfig;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.android.monitorV2.settings.IMonitorSettings$$Impl$3] */
    @Override // com.bytedance.android.monitorV2.settings.IMonitorSettings
    public MonitorConfig getMonitorConfig() {
        IEnsure iEnsure;
        if (ExposedManager.needsReporting(SlardarConfigConsts.MONITOR_CONFIG) && (iEnsure = this.iEnsure) != null) {
            iEnsure.ensureNotReachHere("get settings key = monitor_config time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
        }
        if (this.mCachedSettings.containsKey(SlardarConfigConsts.MONITOR_CONFIG)) {
            return (MonitorConfig) this.mCachedSettings.get(SlardarConfigConsts.MONITOR_CONFIG);
        }
        Storage storage = this.mStorage;
        MonitorConfig monitorConfig = null;
        if (storage != null && storage.contains(SlardarConfigConsts.MONITOR_CONFIG)) {
            try {
                monitorConfig = (MonitorConfig) GSON.fromJson(this.mStorage.getString(SlardarConfigConsts.MONITOR_CONFIG), new TypeToken<MonitorConfig>() { // from class: com.bytedance.android.monitorV2.settings.IMonitorSettings$$Impl.3
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (monitorConfig != null) {
            this.mCachedSettings.put(SlardarConfigConsts.MONITOR_CONFIG, monitorConfig);
        }
        return monitorConfig;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.android.monitorV2.settings.IMonitorSettings$$Impl$4] */
    @Override // com.bytedance.android.monitorV2.settings.IMonitorSettings
    public LynxBlankConfig getLynxBlankConfig() {
        IEnsure iEnsure;
        if (ExposedManager.needsReporting("lynx_blank_config") && (iEnsure = this.iEnsure) != null) {
            iEnsure.ensureNotReachHere("get settings key = lynx_blank_config time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
        }
        if (this.mCachedSettings.containsKey("lynx_blank_config")) {
            return (LynxBlankConfig) this.mCachedSettings.get("lynx_blank_config");
        }
        Storage storage = this.mStorage;
        LynxBlankConfig lynxBlankConfig = null;
        if (storage != null && storage.contains("lynx_blank_config")) {
            try {
                lynxBlankConfig = (LynxBlankConfig) GSON.fromJson(this.mStorage.getString("lynx_blank_config"), new TypeToken<LynxBlankConfig>() { // from class: com.bytedance.android.monitorV2.settings.IMonitorSettings$$Impl.4
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (lynxBlankConfig != null) {
            this.mCachedSettings.put("lynx_blank_config", lynxBlankConfig);
        }
        return lynxBlankConfig;
    }

    public void updateSettings(SettingsData settingsData) {
        MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
        if (settingsData == null) {
            if (VERSION != metaInfo.getSettingsVersion("hybrid_monitor_com.bytedance.android.monitorV2.settings.IMonitorSettings")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("hybrid_monitor");
                try {
                    if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                        metaInfo.setSettingsVersion("hybrid_monitor_com.bytedance.android.monitorV2.settings.IMonitorSettings", VERSION);
                    } else if (settingsData != null) {
                        metaInfo.setSettingsVersion("hybrid_monitor_com.bytedance.android.monitorV2.settings.IMonitorSettings", VERSION);
                    }
                } catch (Throwable th) {
                    if (settingsData != null) {
                        metaInfo.setSettingsVersion("hybrid_monitor_com.bytedance.android.monitorV2.settings.IMonitorSettings", VERSION);
                    }
                    IEnsure iEnsure = this.iEnsure;
                    if (iEnsure != null) {
                        iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            } else if (metaInfo.needUpdate("hybrid_monitor_com.bytedance.android.monitorV2.settings.IMonitorSettings", "hybrid_monitor")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("hybrid_monitor");
            } else if (settingsData == null) {
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("hybrid_monitor_com.bytedance.android.monitorV2.settings.IMonitorSettings")) {
                        settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("hybrid_monitor");
                        metaInfo.setOneSpMigrateDone("hybrid_monitor_com.bytedance.android.monitorV2.settings.IMonitorSettings");
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
        if (appSettings != null) {
            if (appSettings.has("web_blank_config")) {
                this.mStorage.putString("web_blank_config", appSettings.optString("web_blank_config"));
                this.mCachedSettings.remove("web_blank_config");
            }
            if (appSettings.has(SlardarConfigConsts.MONITOR_CONFIG)) {
                this.mStorage.putString(SlardarConfigConsts.MONITOR_CONFIG, appSettings.optString(SlardarConfigConsts.MONITOR_CONFIG));
                this.mCachedSettings.remove(SlardarConfigConsts.MONITOR_CONFIG);
            }
            if (appSettings.has("lynx_blank_config")) {
                this.mStorage.putString("lynx_blank_config", appSettings.optString("lynx_blank_config"));
                this.mCachedSettings.remove("lynx_blank_config");
            }
        }
        this.mStorage.apply();
        metaInfo.setStorageKeyUpdateToken("hybrid_monitor_com.bytedance.android.monitorV2.settings.IMonitorSettings", settingsData.getToken());
    }
}
