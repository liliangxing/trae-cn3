package com.bytedance.news.common.settings;

import com.bytedance.android.monitorV2.settings.IMonitorSettings;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.ies.bullet.base.settings.AnnieXRedirectSettingsConfig;
import com.bytedance.ies.bullet.base.settings.ArgusSecuritySettings;
import com.bytedance.ies.bullet.base.settings.ClientAiConfig;
import com.bytedance.ies.bullet.base.settings.ForestSettingsConfig;
import com.bytedance.ies.bullet.base.settings.MixConfig;
import com.bytedance.ies.bullet.base.settings.SecuritySettingConfig;
import com.bytedance.ies.bullet.base.settings.WebConfig;
import com.bytedance.ies.bullet.interaction.predefine.converter.MetaConverter;
import com.bytedance.ies.bullet.interaction.predefine.converter.PredefineConfigConverter;
import com.bytedance.ies.bullet.interaction.predefine.model.MetaModelConfig;
import com.bytedance.ies.bullet.interaction.predefine.model.WasmDisableListConfig;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.MonitorSettingsConfig;
import com.bytedance.ies.bullet.service.base.settings.PineappleConfig;
import com.bytedance.ies.bullet.service.base.settings.ResourceLoaderSettingsConfig;
import com.bytedance.ies.bullet.settings.data.IBulletSettings;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.Storage;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.exposed.ExposedManager;
import com.bytedance.news.common.settings.internal.GlobalConfig;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.news.common.settings.internal.InstanceCache;
import com.bytedance.news.common.settings.internal.InstanceCreator;
import com.bytedance.news.common.settings.internal.LocalCache;
import com.bytedance.news.common.settings.internal.MetaInfo;
import com.bytedance.pia.core.setting.PIAConfig;
import com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings;
import com.bytedance.services.apm.api.IEnsure;
import com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings;
import com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings;
import com.bytedance.trae.conversation.network.IBrainstormingSettings;
import com.bytedance.trae.conversation.network.IModelListSettings;
import com.bytedance.trae.conversation.network.IPluginSettings;
import com.bytedance.trae.conversation.network.ITaskPinSettings;
import com.bytedance.trae.conversation.products.IHtmlShareSettings;
import com.bytedance.trae.conversation.settings.ICNBusinessSettings;
import com.bytedance.trae.conversation.settings.IConversationListSettings;
import com.bytedance.trae.conversation.settings.IQuerySettings;
import com.bytedance.trae.conversation.settings.IReportAlogSettings;
import com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings;
import com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings;
import com.bytedance.trae.home.solo.task.IFixCrashSettings;
import com.bytedance.trae.praise.IPraiseSettings;
import com.bytedance.trae.settings.impl.feature.IFeatureCapabilitySettings;
import com.bytedance.trae.update.settings.IUpdateSdkSettings;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class SettingsIndexManager {
    public static ISettings getISettings(String str, final Storage storage) {
        if ("com.bytedance.android.monitorV2.settings.IMonitorSettings".equals(str)) {
            return new IMonitorSettings(storage) { // from class: com.bytedance.android.monitorV2.settings.IMonitorSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = 1649816078;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.android.monitorV2.settings.IMonitorSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.android.monitorV2.settings.IMonitorSettings
                public WebBlankConfig getWebBlankConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("web_blank_config") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = web_blank_config time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("web_blank_config")) {
                        return (WebBlankConfig) this.mCachedSettings.get("web_blank_config");
                    }
                    Storage storage2 = this.mStorage;
                    WebBlankConfig webBlankConfig = null;
                    if (storage2 != null && storage2.contains("web_blank_config")) {
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

                @Override // com.bytedance.android.monitorV2.settings.IMonitorSettings
                public MonitorConfig getMonitorConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("monitor_config") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = monitor_config time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("monitor_config")) {
                        return (MonitorConfig) this.mCachedSettings.get("monitor_config");
                    }
                    Storage storage2 = this.mStorage;
                    MonitorConfig monitorConfig = null;
                    if (storage2 != null && storage2.contains("monitor_config")) {
                        try {
                            monitorConfig = (MonitorConfig) GSON.fromJson(this.mStorage.getString("monitor_config"), new TypeToken<MonitorConfig>() { // from class: com.bytedance.android.monitorV2.settings.IMonitorSettings$$Impl.3
                            }.getType());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (monitorConfig != null) {
                        this.mCachedSettings.put("monitor_config", monitorConfig);
                    }
                    return monitorConfig;
                }

                @Override // com.bytedance.android.monitorV2.settings.IMonitorSettings
                public LynxBlankConfig getLynxBlankConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("lynx_blank_config") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = lynx_blank_config time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("lynx_blank_config")) {
                        return (LynxBlankConfig) this.mCachedSettings.get("lynx_blank_config");
                    }
                    Storage storage2 = this.mStorage;
                    LynxBlankConfig lynxBlankConfig = null;
                    if (storage2 != null && storage2.contains("lynx_blank_config")) {
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

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
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
                        if (appSettings.has("monitor_config")) {
                            this.mStorage.putString("monitor_config", appSettings.optString("monitor_config"));
                            this.mCachedSettings.remove("monitor_config");
                        }
                        if (appSettings.has("lynx_blank_config")) {
                            this.mStorage.putString("lynx_blank_config", appSettings.optString("lynx_blank_config"));
                            this.mCachedSettings.remove("lynx_blank_config");
                        }
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("hybrid_monitor_com.bytedance.android.monitorV2.settings.IMonitorSettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.ies.bullet.settings.data.IBulletSettings".equals(str)) {
            return new IBulletSettings(storage) { // from class: com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = 1516787273;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        if (cls == MetaConverter.class) {
                            return (T) new MetaConverter();
                        }
                        if (cls == PredefineConfigConverter.class) {
                            return (T) new PredefineConfigConverter();
                        }
                        if (cls == ArgusSecuritySettings.class) {
                            return (T) new ArgusSecuritySettings();
                        }
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public ResourceLoaderSettingsConfig getResourceLoaderConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("resourceloader") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = resourceloader time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("resourceloader")) {
                        return (ResourceLoaderSettingsConfig) this.mCachedSettings.get("resourceloader");
                    }
                    Storage storage2 = this.mStorage;
                    ResourceLoaderSettingsConfig resourceLoaderSettingsConfig = null;
                    if (storage2 != null && storage2.contains("resourceloader")) {
                        try {
                            resourceLoaderSettingsConfig = (ResourceLoaderSettingsConfig) GSON.fromJson(this.mStorage.getString("resourceloader"), new TypeToken<ResourceLoaderSettingsConfig>() { // from class: com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl.2
                            }.getType());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (resourceLoaderSettingsConfig != null) {
                        this.mCachedSettings.put("resourceloader", resourceLoaderSettingsConfig);
                    }
                    return resourceLoaderSettingsConfig;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public CommonConfig getCommonConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting(SettingsManager.COMMON_SERVICE) && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = common time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey(SettingsManager.COMMON_SERVICE)) {
                        return (CommonConfig) this.mCachedSettings.get(SettingsManager.COMMON_SERVICE);
                    }
                    Storage storage2 = this.mStorage;
                    CommonConfig commonConfig = null;
                    if (storage2 != null && storage2.contains(SettingsManager.COMMON_SERVICE)) {
                        try {
                            commonConfig = (CommonConfig) GSON.fromJson(this.mStorage.getString(SettingsManager.COMMON_SERVICE), new TypeToken<CommonConfig>() { // from class: com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl.3
                            }.getType());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (commonConfig != null) {
                        this.mCachedSettings.put(SettingsManager.COMMON_SERVICE, commonConfig);
                    }
                    return commonConfig;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public WebConfig getWebConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("web_config") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = web_config time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("web_config")) {
                        return (WebConfig) this.mCachedSettings.get("web_config");
                    }
                    Storage storage2 = this.mStorage;
                    WebConfig webConfig = null;
                    if (storage2 != null && storage2.contains("web_config")) {
                        try {
                            webConfig = (WebConfig) GSON.fromJson(this.mStorage.getString("web_config"), new TypeToken<WebConfig>() { // from class: com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl.4
                            }.getType());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (webConfig != null) {
                        this.mCachedSettings.put("web_config", webConfig);
                    }
                    return webConfig;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public MonitorSettingsConfig getMonitorConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("monitor") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = monitor time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("monitor")) {
                        return (MonitorSettingsConfig) this.mCachedSettings.get("monitor");
                    }
                    Storage storage2 = this.mStorage;
                    MonitorSettingsConfig monitorSettingsConfig = null;
                    if (storage2 != null && storage2.contains("monitor")) {
                        try {
                            monitorSettingsConfig = (MonitorSettingsConfig) GSON.fromJson(this.mStorage.getString("monitor"), new TypeToken<MonitorSettingsConfig>() { // from class: com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl.5
                            }.getType());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (monitorSettingsConfig != null) {
                        this.mCachedSettings.put("monitor", monitorSettingsConfig);
                    }
                    return monitorSettingsConfig;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public PineappleConfig getPineappleConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("pineapple") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = pineapple time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("pineapple")) {
                        return (PineappleConfig) this.mCachedSettings.get("pineapple");
                    }
                    Storage storage2 = this.mStorage;
                    PineappleConfig pineappleConfig = null;
                    if (storage2 != null && storage2.contains("pineapple")) {
                        try {
                            pineappleConfig = (PineappleConfig) GSON.fromJson(this.mStorage.getString("pineapple"), new TypeToken<PineappleConfig>() { // from class: com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl.6
                            }.getType());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (pineappleConfig != null) {
                        this.mCachedSettings.put("pineapple", pineappleConfig);
                    }
                    return pineappleConfig;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public MixConfig getMixConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("mix") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = mix time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("mix")) {
                        return (MixConfig) this.mCachedSettings.get("mix");
                    }
                    Storage storage2 = this.mStorage;
                    MixConfig mixConfig = null;
                    if (storage2 != null && storage2.contains("mix")) {
                        try {
                            mixConfig = (MixConfig) GSON.fromJson(this.mStorage.getString("mix"), new TypeToken<MixConfig>() { // from class: com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl.7
                            }.getType());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (mixConfig != null) {
                        this.mCachedSettings.put("mix", mixConfig);
                    }
                    return mixConfig;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public SccConfig getSccSettingsConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("scc_config") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = scc_config time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("scc_config")) {
                        return (SccConfig) this.mCachedSettings.get("scc_config");
                    }
                    Storage storage2 = this.mStorage;
                    SccConfig sccConfig = null;
                    if (storage2 != null && storage2.contains("scc_config")) {
                        try {
                            sccConfig = (SccConfig) GSON.fromJson(this.mStorage.getString("scc_config"), new TypeToken<SccConfig>() { // from class: com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl.8
                            }.getType());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (sccConfig != null) {
                        this.mCachedSettings.put("scc_config", sccConfig);
                    }
                    return sccConfig;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public SecuritySettingConfig getSecuritySettingConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("SecuritySetting") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = SecuritySetting time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("SecuritySetting")) {
                        return (SecuritySettingConfig) this.mCachedSettings.get("SecuritySetting");
                    }
                    Storage storage2 = this.mStorage;
                    SecuritySettingConfig securitySettingConfig = null;
                    if (storage2 != null && storage2.contains("SecuritySetting")) {
                        try {
                            securitySettingConfig = (SecuritySettingConfig) GSON.fromJson(this.mStorage.getString("SecuritySetting"), new TypeToken<SecuritySettingConfig>() { // from class: com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl.9
                            }.getType());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (securitySettingConfig != null) {
                        this.mCachedSettings.put("SecuritySetting", securitySettingConfig);
                    }
                    return securitySettingConfig;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public ForestSettingsConfig getForestSettingConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("forest") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = forest time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("forest")) {
                        return (ForestSettingsConfig) this.mCachedSettings.get("forest");
                    }
                    Storage storage2 = this.mStorage;
                    ForestSettingsConfig forestSettingsConfig = null;
                    if (storage2 != null && storage2.contains("forest")) {
                        try {
                            forestSettingsConfig = (ForestSettingsConfig) GSON.fromJson(this.mStorage.getString("forest"), new TypeToken<ForestSettingsConfig>() { // from class: com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl.10
                            }.getType());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (forestSettingsConfig != null) {
                        this.mCachedSettings.put("forest", forestSettingsConfig);
                    }
                    return forestSettingsConfig;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public PIAConfig getPIAConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("piasdk") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = piasdk time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("piasdk")) {
                        return (PIAConfig) this.mCachedSettings.get("piasdk");
                    }
                    Storage storage2 = this.mStorage;
                    PIAConfig pIAConfig = null;
                    if (storage2 != null && storage2.contains("piasdk")) {
                        try {
                            pIAConfig = (PIAConfig) GSON.fromJson(this.mStorage.getString("piasdk"), new TypeToken<PIAConfig>() { // from class: com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl.11
                            }.getType());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (pIAConfig != null) {
                        this.mCachedSettings.put("piasdk", pIAConfig);
                    }
                    return pIAConfig;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public AnnieXRedirectSettingsConfig getAnnieXRedirectConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting(ReportConsts.RESPONSE_REDIRECT) && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = redirect time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey(ReportConsts.RESPONSE_REDIRECT)) {
                        return (AnnieXRedirectSettingsConfig) this.mCachedSettings.get(ReportConsts.RESPONSE_REDIRECT);
                    }
                    Storage storage2 = this.mStorage;
                    AnnieXRedirectSettingsConfig annieXRedirectSettingsConfig = null;
                    if (storage2 != null && storage2.contains(ReportConsts.RESPONSE_REDIRECT)) {
                        try {
                            annieXRedirectSettingsConfig = (AnnieXRedirectSettingsConfig) GSON.fromJson(this.mStorage.getString(ReportConsts.RESPONSE_REDIRECT), new TypeToken<AnnieXRedirectSettingsConfig>() { // from class: com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl.12
                            }.getType());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (annieXRedirectSettingsConfig != null) {
                        this.mCachedSettings.put(ReportConsts.RESPONSE_REDIRECT, annieXRedirectSettingsConfig);
                    }
                    return annieXRedirectSettingsConfig;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public MetaModelConfig getAnnieXPredefineConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("predefine_config") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = predefine_config time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("predefine_config")) {
                        return (MetaModelConfig) this.mCachedSettings.get("predefine_config");
                    }
                    Storage storage2 = this.mStorage;
                    MetaModelConfig metaModelConfig = (storage2 == null || !storage2.contains("predefine_config")) ? null : ((MetaConverter) InstanceCache.obtain(MetaConverter.class, this.mInstanceCreator)).to(this.mStorage.getString("predefine_config"));
                    if (metaModelConfig != null) {
                        this.mCachedSettings.put("predefine_config", metaModelConfig);
                    }
                    return metaModelConfig;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public WasmDisableListConfig getAnnieXPredefineWasmConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("predefine_wasm_disable_config") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = predefine_wasm_disable_config time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("predefine_wasm_disable_config")) {
                        return (WasmDisableListConfig) this.mCachedSettings.get("predefine_wasm_disable_config");
                    }
                    Storage storage2 = this.mStorage;
                    WasmDisableListConfig wasmDisableListConfig = (storage2 == null || !storage2.contains("predefine_wasm_disable_config")) ? null : ((PredefineConfigConverter) InstanceCache.obtain(PredefineConfigConverter.class, this.mInstanceCreator)).to(this.mStorage.getString("predefine_wasm_disable_config"));
                    if (wasmDisableListConfig != null) {
                        this.mCachedSettings.put("predefine_wasm_disable_config", wasmDisableListConfig);
                    }
                    return wasmDisableListConfig;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public ArgusSecuritySettings getArgusSecuritySettingConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("argus_security") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = argus_security time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("argus_security")) {
                        return (ArgusSecuritySettings) this.mCachedSettings.get("argus_security");
                    }
                    Storage storage2 = this.mStorage;
                    ArgusSecuritySettings argusSecuritySettings = (storage2 == null || !storage2.contains("argus_security")) ? null : ((ArgusSecuritySettings) InstanceCache.obtain(ArgusSecuritySettings.class, this.mInstanceCreator)).to(this.mStorage.getString("argus_security"));
                    if (argusSecuritySettings != null) {
                        this.mCachedSettings.put("argus_security", argusSecuritySettings);
                    }
                    return argusSecuritySettings;
                }

                @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
                public ClientAiConfig getClientAiConfig() {
                    IEnsure iEnsure;
                    if (ExposedManager.needsReporting("annie_client_ai") && (iEnsure = this.iEnsure) != null) {
                        iEnsure.ensureNotReachHere("get settings key = annie_client_ai time = " + ExposedManager.getSettingsUsingTime() + " thread name = " + Thread.currentThread().getName());
                    }
                    if (this.mCachedSettings.containsKey("annie_client_ai")) {
                        return (ClientAiConfig) this.mCachedSettings.get("annie_client_ai");
                    }
                    Storage storage2 = this.mStorage;
                    ClientAiConfig clientAiConfig = null;
                    if (storage2 != null && storage2.contains("annie_client_ai")) {
                        try {
                            clientAiConfig = (ClientAiConfig) GSON.fromJson(this.mStorage.getString("annie_client_ai"), new TypeToken<ClientAiConfig>() { // from class: com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl.13
                            }.getType());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (clientAiConfig != null) {
                        this.mCachedSettings.put("annie_client_ai", clientAiConfig);
                    }
                    return clientAiConfig;
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("bullet_com.bytedance.ies.bullet.settings.data.IBulletSettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("Bullet");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("bullet_com.bytedance.ies.bullet.settings.data.IBulletSettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("bullet_com.bytedance.ies.bullet.settings.data.IBulletSettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("bullet_com.bytedance.ies.bullet.settings.data.IBulletSettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("bullet_com.bytedance.ies.bullet.settings.data.IBulletSettings", "Bullet")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("Bullet");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("bullet_com.bytedance.ies.bullet.settings.data.IBulletSettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("Bullet");
                                    metaInfo.setOneSpMigrateDone("bullet_com.bytedance.ies.bullet.settings.data.IBulletSettings");
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
                        if (appSettings.has("resourceloader")) {
                            this.mStorage.putString("resourceloader", appSettings.optString("resourceloader"));
                            this.mCachedSettings.remove("resourceloader");
                        }
                        if (appSettings.has(SettingsManager.COMMON_SERVICE)) {
                            this.mStorage.putString(SettingsManager.COMMON_SERVICE, appSettings.optString(SettingsManager.COMMON_SERVICE));
                            this.mCachedSettings.remove(SettingsManager.COMMON_SERVICE);
                        }
                        if (appSettings.has("web_config")) {
                            this.mStorage.putString("web_config", appSettings.optString("web_config"));
                            this.mCachedSettings.remove("web_config");
                        }
                        if (appSettings.has("monitor")) {
                            this.mStorage.putString("monitor", appSettings.optString("monitor"));
                            this.mCachedSettings.remove("monitor");
                        }
                        if (appSettings.has("pineapple")) {
                            this.mStorage.putString("pineapple", appSettings.optString("pineapple"));
                            this.mCachedSettings.remove("pineapple");
                        }
                        if (appSettings.has("mix")) {
                            this.mStorage.putString("mix", appSettings.optString("mix"));
                            this.mCachedSettings.remove("mix");
                        }
                        if (appSettings.has("scc_config")) {
                            this.mStorage.putString("scc_config", appSettings.optString("scc_config"));
                            this.mCachedSettings.remove("scc_config");
                        }
                        if (appSettings.has("SecuritySetting")) {
                            this.mStorage.putString("SecuritySetting", appSettings.optString("SecuritySetting"));
                            this.mCachedSettings.remove("SecuritySetting");
                        }
                        if (appSettings.has("forest")) {
                            this.mStorage.putString("forest", appSettings.optString("forest"));
                            this.mCachedSettings.remove("forest");
                        }
                        if (appSettings.has("piasdk")) {
                            this.mStorage.putString("piasdk", appSettings.optString("piasdk"));
                            this.mCachedSettings.remove("piasdk");
                        }
                        if (appSettings.has(ReportConsts.RESPONSE_REDIRECT)) {
                            this.mStorage.putString(ReportConsts.RESPONSE_REDIRECT, appSettings.optString(ReportConsts.RESPONSE_REDIRECT));
                            this.mCachedSettings.remove(ReportConsts.RESPONSE_REDIRECT);
                        }
                        if (appSettings.has("predefine_config")) {
                            this.mStorage.putString("predefine_config", appSettings.optString("predefine_config"));
                            this.mCachedSettings.remove("predefine_config");
                        }
                        if (appSettings.has("predefine_wasm_disable_config")) {
                            this.mStorage.putString("predefine_wasm_disable_config", appSettings.optString("predefine_wasm_disable_config"));
                            this.mCachedSettings.remove("predefine_wasm_disable_config");
                        }
                        if (appSettings.has("argus_security")) {
                            this.mStorage.putString("argus_security", appSettings.optString("argus_security"));
                            this.mCachedSettings.remove("argus_security");
                        }
                        if (appSettings.has("annie_client_ai")) {
                            this.mStorage.putString("annie_client_ai", appSettings.optString("annie_client_ai"));
                            this.mCachedSettings.remove("annie_client_ai");
                        }
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("bullet_com.bytedance.ies.bullet.settings.data.IBulletSettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings".equals(str)) {
            return new MobiusAOPCheckSettings(storage) { // from class: com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = -1946464161;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        if (cls == DefaultSettings.class) {
                            return (T) new DefaultSettings();
                        }
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = (IEnsure) ServiceManager.getService(IEnsure.class);

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings
                public SettingsModel getSettingModel() {
                    SettingsModel create;
                    SettingsModel settingsModel;
                    if (this.mCachedSettings.containsKey("security_aop_settings")) {
                        create = (SettingsModel) this.mCachedSettings.get("security_aop_settings");
                        if (create == null) {
                            create = ((DefaultSettings) InstanceCache.obtain(DefaultSettings.class, this.mInstanceCreator)).create();
                            IEnsure iEnsure = this.iEnsure;
                            if (iEnsure != null) {
                                iEnsure.ensureNotReachHere("value == null security_aop_settings");
                            }
                        }
                    } else {
                        Storage storage2 = this.mStorage;
                        if (storage2 != null && storage2.contains("security_aop_settings")) {
                            String string = this.mStorage.getString("security_aop_settings");
                            try {
                                settingsModel = (SettingsModel) GSON.fromJson(string, new TypeToken<SettingsModel>() { // from class: com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings$$Impl.2
                                }.getType());
                            } catch (Exception e) {
                                SettingsModel create2 = ((DefaultSettings) InstanceCache.obtain(DefaultSettings.class, this.mInstanceCreator)).create();
                                IEnsure iEnsure2 = this.iEnsure;
                                if (iEnsure2 != null) {
                                    iEnsure2.ensureNotReachHere(e, "gson from json error" + string);
                                }
                                e.printStackTrace();
                                settingsModel = create2;
                            }
                            create = settingsModel;
                        } else {
                            create = ((DefaultSettings) InstanceCache.obtain(DefaultSettings.class, this.mInstanceCreator)).create();
                        }
                        if (create != null) {
                            this.mCachedSettings.put("security_aop_settings", create);
                        } else {
                            create = ((DefaultSettings) InstanceCache.obtain(DefaultSettings.class, this.mInstanceCreator)).create();
                            IEnsure iEnsure3 = this.iEnsure;
                            if (iEnsure3 != null) {
                                iEnsure3.ensureNotReachHere("value == null key = security_aop_settings");
                            }
                        }
                    }
                    return create;
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("aop_check_settings_com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("setting_id");
                            try {
                                if (!this.mExposedManager.isUseOneSpForAppSettings()) {
                                    metaInfo.setSettingsVersion("aop_check_settings_com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("aop_check_settings_com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("aop_check_settings_com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettings error");
                                }
                            }
                        } else if (metaInfo.needUpdate("aop_check_settings_com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings", "setting_id")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("setting_id");
                        } else if (settingsData == null) {
                            try {
                                if (this.mExposedManager.isUseOneSpForAppSettings() && !metaInfo.isOneSpMigrateDone("aop_check_settings_com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("setting_id");
                                    metaInfo.setOneSpMigrateDone("aop_check_settings_com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings");
                                }
                            } catch (Throwable th2) {
                                IEnsure iEnsure2 = this.iEnsure;
                                if (iEnsure2 != null) {
                                    iEnsure2.ensureNotReachHere(th2, "isUseOneSpForAppSettings error");
                                }
                            }
                        }
                    }
                    if (settingsData == null || this.mStorage == null) {
                        return;
                    }
                    JSONObject appSettings = settingsData.getAppSettings();
                    if (appSettings != null && appSettings.has("security_aop_settings")) {
                        this.mStorage.putString("security_aop_settings", appSettings.optString("security_aop_settings"));
                        this.mCachedSettings.remove("security_aop_settings");
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("aop_check_settings_com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings".equals(str)) {
            return new IHomeCmpPageSettings(storage) { // from class: com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = -2131189809;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.home.solo.setting.platform.IHomeCmpPageSettings
                public JsonObject getEnableCmpPages() {
                    this.mExposedManager.markExposed("enable_cmp_pages");
                    if (ExposedManager.needsReporting("enable_cmp_pages") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "enable_cmp_pages");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = enable_cmp_pages", hashMap);
                    }
                    if (this.mCachedSettings.containsKey("enable_cmp_pages")) {
                        return (JsonObject) this.mCachedSettings.get("enable_cmp_pages");
                    }
                    Storage storage2 = this.mStorage;
                    JsonObject jsonObject = null;
                    if (storage2 != null && storage2.contains("enable_cmp_pages")) {
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

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
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
            };
        }
        if ("com.bytedance.trae.home.solo.task.IFixCrashSettings".equals(str)) {
            return new IFixCrashSettings(storage) { // from class: com.bytedance.trae.home.solo.task.IFixCrashSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = 279135857;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.home.solo.task.IFixCrashSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.home.solo.task.IFixCrashSettings
                public String getFixSuspendByPeerCrash() {
                    this.mExposedManager.markExposed("fix_crash_opt");
                    if (ExposedManager.needsReporting("fix_crash_opt") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "fix_crash_opt");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = fix_crash_opt", hashMap);
                    }
                    Storage storage2 = this.mStorage;
                    return (storage2 == null || !storage2.contains("fix_crash_opt")) ? "" : this.mStorage.getString("fix_crash_opt");
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("fix_crash_settings_com.bytedance.trae.home.solo.task.IFixCrashSettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("fix_crash_settings_com.bytedance.trae.home.solo.task.IFixCrashSettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("fix_crash_settings_com.bytedance.trae.home.solo.task.IFixCrashSettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("fix_crash_settings_com.bytedance.trae.home.solo.task.IFixCrashSettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("fix_crash_settings_com.bytedance.trae.home.solo.task.IFixCrashSettings", "")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("fix_crash_settings_com.bytedance.trae.home.solo.task.IFixCrashSettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                                    metaInfo.setOneSpMigrateDone("fix_crash_settings_com.bytedance.trae.home.solo.task.IFixCrashSettings");
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
                    if (appSettings != null && appSettings.has("fix_crash_opt")) {
                        this.mStorage.putString("fix_crash_opt", appSettings.optString("fix_crash_opt"));
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("fix_crash_settings_com.bytedance.trae.home.solo.task.IFixCrashSettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings".equals(str)) {
            return new IArtifactsRendererSettings(storage) { // from class: com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = 152955228;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings
                public String getSettings() {
                    this.mExposedManager.markExposed("im_artifacts_renderer");
                    if (ExposedManager.needsReporting("im_artifacts_renderer") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "im_artifacts_renderer");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = im_artifacts_renderer", hashMap);
                    }
                    Storage storage2 = this.mStorage;
                    return (storage2 == null || !storage2.contains("im_artifacts_renderer")) ? "" : this.mStorage.getString("im_artifacts_renderer");
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("im_artifacts_renderer_com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("im_artifacts_renderer_com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("im_artifacts_renderer_com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("im_artifacts_renderer_com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("im_artifacts_renderer_com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings", "")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("im_artifacts_renderer_com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                                    metaInfo.setOneSpMigrateDone("im_artifacts_renderer_com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings");
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
                    if (appSettings != null && appSettings.has("im_artifacts_renderer")) {
                        this.mStorage.putString("im_artifacts_renderer", appSettings.optString("im_artifacts_renderer"));
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("im_artifacts_renderer_com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings".equals(str)) {
            return new IMobileIdeGuidePromptSettings(storage) { // from class: com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = -505058951;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings
                public String getMobileIdeGuidePrompt() {
                    this.mExposedManager.markExposed("mobile_ide_guide_prompt");
                    if (ExposedManager.needsReporting("mobile_ide_guide_prompt") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "mobile_ide_guide_prompt");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = mobile_ide_guide_prompt", hashMap);
                    }
                    Storage storage2 = this.mStorage;
                    return (storage2 == null || !storage2.contains("mobile_ide_guide_prompt")) ? "" : this.mStorage.getString("mobile_ide_guide_prompt");
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("mobile_ide_guide_prompt_com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("mobile_ide_guide_prompt_com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("mobile_ide_guide_prompt_com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("mobile_ide_guide_prompt_com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("mobile_ide_guide_prompt_com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings", "")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("mobile_ide_guide_prompt_com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                                    metaInfo.setOneSpMigrateDone("mobile_ide_guide_prompt_com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings");
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
                    if (appSettings != null && appSettings.has("mobile_ide_guide_prompt")) {
                        this.mStorage.putString("mobile_ide_guide_prompt", appSettings.optString("mobile_ide_guide_prompt"));
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("mobile_ide_guide_prompt_com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.trae.conversation.network.IBrainstormingSettings".equals(str)) {
            return new IBrainstormingSettings(storage) { // from class: com.bytedance.trae.conversation.network.IBrainstormingSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = -69563326;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.network.IBrainstormingSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.conversation.network.IBrainstormingSettings
                public String getCliBrainstormingV2MinIdeVersion() {
                    this.mExposedManager.markExposed("cli_brainstorming_v2_min_ide_version");
                    if (ExposedManager.needsReporting("cli_brainstorming_v2_min_ide_version") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "cli_brainstorming_v2_min_ide_version");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = cli_brainstorming_v2_min_ide_version", hashMap);
                    }
                    Storage storage2 = this.mStorage;
                    return (storage2 == null || !storage2.contains("cli_brainstorming_v2_min_ide_version")) ? "" : this.mStorage.getString("cli_brainstorming_v2_min_ide_version");
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.IBrainstormingSettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.IBrainstormingSettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.IBrainstormingSettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.IBrainstormingSettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("nova_settings_com.bytedance.trae.conversation.network.IBrainstormingSettings", "")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.network.IBrainstormingSettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                                    metaInfo.setOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.network.IBrainstormingSettings");
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
                    if (appSettings != null && appSettings.has("cli_brainstorming_v2_min_ide_version")) {
                        this.mStorage.putString("cli_brainstorming_v2_min_ide_version", appSettings.optString("cli_brainstorming_v2_min_ide_version"));
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("nova_settings_com.bytedance.trae.conversation.network.IBrainstormingSettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.trae.conversation.network.IModelListSettings".equals(str)) {
            return new IModelListSettings(storage) { // from class: com.bytedance.trae.conversation.network.IModelListSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = 2022382090;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.network.IModelListSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.conversation.network.IModelListSettings
                public String getCliModelListMinIdeVersion() {
                    this.mExposedManager.markExposed("cli_model_list_min_ide_version");
                    if (ExposedManager.needsReporting("cli_model_list_min_ide_version") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "cli_model_list_min_ide_version");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = cli_model_list_min_ide_version", hashMap);
                    }
                    Storage storage2 = this.mStorage;
                    return (storage2 == null || !storage2.contains("cli_model_list_min_ide_version")) ? "" : this.mStorage.getString("cli_model_list_min_ide_version");
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.IModelListSettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.IModelListSettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.IModelListSettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.IModelListSettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("nova_settings_com.bytedance.trae.conversation.network.IModelListSettings", "")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.network.IModelListSettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                                    metaInfo.setOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.network.IModelListSettings");
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
                    if (appSettings != null && appSettings.has("cli_model_list_min_ide_version")) {
                        this.mStorage.putString("cli_model_list_min_ide_version", appSettings.optString("cli_model_list_min_ide_version"));
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("nova_settings_com.bytedance.trae.conversation.network.IModelListSettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.trae.conversation.network.IPluginSettings".equals(str)) {
            return new IPluginSettings(storage) { // from class: com.bytedance.trae.conversation.network.IPluginSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = 992655909;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.network.IPluginSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.conversation.network.IPluginSettings
                public String getCliTaskPluginMinIdeVersion() {
                    this.mExposedManager.markExposed("cli_task_plugin_min_ide_version");
                    if (ExposedManager.needsReporting("cli_task_plugin_min_ide_version") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "cli_task_plugin_min_ide_version");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = cli_task_plugin_min_ide_version", hashMap);
                    }
                    Storage storage2 = this.mStorage;
                    return (storage2 == null || !storage2.contains("cli_task_plugin_min_ide_version")) ? "" : this.mStorage.getString("cli_task_plugin_min_ide_version");
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.IPluginSettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.IPluginSettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.IPluginSettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.IPluginSettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("nova_settings_com.bytedance.trae.conversation.network.IPluginSettings", "")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.network.IPluginSettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                                    metaInfo.setOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.network.IPluginSettings");
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
                    if (appSettings != null && appSettings.has("cli_task_plugin_min_ide_version")) {
                        this.mStorage.putString("cli_task_plugin_min_ide_version", appSettings.optString("cli_task_plugin_min_ide_version"));
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("nova_settings_com.bytedance.trae.conversation.network.IPluginSettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.trae.conversation.network.ITaskPinSettings".equals(str)) {
            return new ITaskPinSettings(storage) { // from class: com.bytedance.trae.conversation.network.ITaskPinSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = -389624911;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.network.ITaskPinSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.conversation.network.ITaskPinSettings
                public String getCliTaskPinMinIdeVersion() {
                    this.mExposedManager.markExposed("cli_task_pin_min_ide_version");
                    if (ExposedManager.needsReporting("cli_task_pin_min_ide_version") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "cli_task_pin_min_ide_version");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = cli_task_pin_min_ide_version", hashMap);
                    }
                    Storage storage2 = this.mStorage;
                    return (storage2 == null || !storage2.contains("cli_task_pin_min_ide_version")) ? "" : this.mStorage.getString("cli_task_pin_min_ide_version");
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.ITaskPinSettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.ITaskPinSettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.ITaskPinSettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.network.ITaskPinSettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("nova_settings_com.bytedance.trae.conversation.network.ITaskPinSettings", "")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.network.ITaskPinSettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                                    metaInfo.setOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.network.ITaskPinSettings");
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
                    if (appSettings != null && appSettings.has("cli_task_pin_min_ide_version")) {
                        this.mStorage.putString("cli_task_pin_min_ide_version", appSettings.optString("cli_task_pin_min_ide_version"));
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("nova_settings_com.bytedance.trae.conversation.network.ITaskPinSettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.trae.conversation.products.IHtmlShareSettings".equals(str)) {
            return new IHtmlShareSettings(storage) { // from class: com.bytedance.trae.conversation.products.IHtmlShareSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = -994687320;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.products.IHtmlShareSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.conversation.products.IHtmlShareSettings
                public String getHtmlShareMinIdeVersion() {
                    this.mExposedManager.markExposed("cli_share_html_control");
                    if (ExposedManager.needsReporting("cli_share_html_control") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "cli_share_html_control");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = cli_share_html_control", hashMap);
                    }
                    Storage storage2 = this.mStorage;
                    return (storage2 == null || !storage2.contains("cli_share_html_control")) ? "" : this.mStorage.getString("cli_share_html_control");
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("nova_settings_com.bytedance.trae.conversation.products.IHtmlShareSettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.products.IHtmlShareSettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.products.IHtmlShareSettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.products.IHtmlShareSettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("nova_settings_com.bytedance.trae.conversation.products.IHtmlShareSettings", "")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.products.IHtmlShareSettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                                    metaInfo.setOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.products.IHtmlShareSettings");
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
                    if (appSettings != null && appSettings.has("cli_share_html_control")) {
                        this.mStorage.putString("cli_share_html_control", appSettings.optString("cli_share_html_control"));
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("nova_settings_com.bytedance.trae.conversation.products.IHtmlShareSettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.trae.conversation.settings.ICNBusinessSettings".equals(str)) {
            return new ICNBusinessSettings(storage) { // from class: com.bytedance.trae.conversation.settings.ICNBusinessSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = -1354403686;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.settings.ICNBusinessSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.conversation.settings.ICNBusinessSettings
                public String getSettings() {
                    this.mExposedManager.markExposed("cn_buisness_settings");
                    if (ExposedManager.needsReporting("cn_buisness_settings") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "cn_buisness_settings");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = cn_buisness_settings", hashMap);
                    }
                    Storage storage2 = this.mStorage;
                    return (storage2 == null || !storage2.contains("cn_buisness_settings")) ? "" : this.mStorage.getString("cn_buisness_settings");
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
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
            };
        }
        if ("com.bytedance.trae.conversation.settings.IConversationListSettings".equals(str)) {
            return new IConversationListSettings(storage) { // from class: com.bytedance.trae.conversation.settings.IConversationListSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = 2091651212;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.settings.IConversationListSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.conversation.settings.IConversationListSettings
                public String getConversationListPageSize() {
                    this.mExposedManager.markExposed("conversation_list_page_size");
                    if (ExposedManager.needsReporting("conversation_list_page_size") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "conversation_list_page_size");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = conversation_list_page_size", hashMap);
                    }
                    Storage storage2 = this.mStorage;
                    return (storage2 == null || !storage2.contains("conversation_list_page_size")) ? "" : this.mStorage.getString("conversation_list_page_size");
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("nova_settings_com.bytedance.trae.conversation.settings.IConversationListSettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.settings.IConversationListSettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.settings.IConversationListSettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.settings.IConversationListSettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("nova_settings_com.bytedance.trae.conversation.settings.IConversationListSettings", "")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.settings.IConversationListSettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                                    metaInfo.setOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.settings.IConversationListSettings");
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
                    if (appSettings != null && appSettings.has("conversation_list_page_size")) {
                        this.mStorage.putString("conversation_list_page_size", appSettings.optString("conversation_list_page_size"));
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("nova_settings_com.bytedance.trae.conversation.settings.IConversationListSettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.trae.conversation.settings.IQuerySettings".equals(str)) {
            return new IQuerySettings(storage) { // from class: com.bytedance.trae.conversation.settings.IQuerySettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = 29918982;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.settings.IQuerySettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.conversation.settings.IQuerySettings
                public String getWorkAttachmentSettings() {
                    this.mExposedManager.markExposed("input_limit");
                    if (ExposedManager.needsReporting("input_limit") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "input_limit");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = input_limit", hashMap);
                    }
                    Storage storage2 = this.mStorage;
                    return (storage2 == null || !storage2.contains("input_limit")) ? "" : this.mStorage.getString("input_limit");
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("im_query_settings_com.bytedance.trae.conversation.settings.IQuerySettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("im_query_settings_com.bytedance.trae.conversation.settings.IQuerySettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("im_query_settings_com.bytedance.trae.conversation.settings.IQuerySettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("im_query_settings_com.bytedance.trae.conversation.settings.IQuerySettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("im_query_settings_com.bytedance.trae.conversation.settings.IQuerySettings", "")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("im_query_settings_com.bytedance.trae.conversation.settings.IQuerySettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                                    metaInfo.setOneSpMigrateDone("im_query_settings_com.bytedance.trae.conversation.settings.IQuerySettings");
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
                    if (appSettings != null && appSettings.has("input_limit")) {
                        this.mStorage.putString("input_limit", appSettings.optString("input_limit"));
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("im_query_settings_com.bytedance.trae.conversation.settings.IQuerySettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.trae.conversation.settings.IReportAlogSettings".equals(str)) {
            return new IReportAlogSettings(storage) { // from class: com.bytedance.trae.conversation.settings.IReportAlogSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = -247120018;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.settings.IReportAlogSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.conversation.settings.IReportAlogSettings
                public String getReportAlogConfig() {
                    this.mExposedManager.markExposed("report_alog");
                    if (ExposedManager.needsReporting("report_alog") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "report_alog");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = report_alog", hashMap);
                    }
                    Storage storage2 = this.mStorage;
                    return (storage2 == null || !storage2.contains("report_alog")) ? "" : this.mStorage.getString("report_alog");
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("nova_settings_com.bytedance.trae.conversation.settings.IReportAlogSettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.settings.IReportAlogSettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.settings.IReportAlogSettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.conversation.settings.IReportAlogSettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("nova_settings_com.bytedance.trae.conversation.settings.IReportAlogSettings", "")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.settings.IReportAlogSettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                                    metaInfo.setOneSpMigrateDone("nova_settings_com.bytedance.trae.conversation.settings.IReportAlogSettings");
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
                    if (appSettings != null && appSettings.has("report_alog")) {
                        this.mStorage.putString("report_alog", appSettings.optString("report_alog"));
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("nova_settings_com.bytedance.trae.conversation.settings.IReportAlogSettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings".equals(str)) {
            return new IUpgradeReminderSettings(storage) { // from class: com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = -648480971;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.conversation.upgrade.IUpgradeReminderSettings
                public JsonObject getUpgradeReminderConfig() {
                    JsonObject jsonObject;
                    this.mExposedManager.markExposed("upgrade_reminder");
                    if (ExposedManager.needsReporting("upgrade_reminder") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "upgrade_reminder");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = upgrade_reminder", hashMap);
                    }
                    if (this.mStickySettings.containsKey("upgrade_reminder")) {
                        return (JsonObject) this.mStickySettings.get("upgrade_reminder");
                    }
                    if (this.mCachedSettings.containsKey("upgrade_reminder")) {
                        jsonObject = (JsonObject) this.mCachedSettings.get("upgrade_reminder");
                    } else {
                        Storage storage2 = this.mStorage;
                        JsonObject jsonObject2 = null;
                        if (storage2 != null && storage2.contains("upgrade_reminder")) {
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

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
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
            };
        }
        if ("com.bytedance.trae.settings.impl.feature.IFeatureCapabilitySettings".equals(str)) {
            return new IFeatureCapabilitySettings(storage) { // from class: com.bytedance.trae.settings.impl.feature.IFeatureCapabilitySettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = -934100160;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.settings.impl.feature.IFeatureCapabilitySettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.settings.impl.feature.IFeatureCapabilitySettings
                public String getConfig() {
                    this.mExposedManager.markExposed("feature_capability_config");
                    if (ExposedManager.needsReporting("feature_capability_config") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "feature_capability_config");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = feature_capability_config", hashMap);
                    }
                    Storage storage2 = this.mStorage;
                    return (storage2 == null || !storage2.contains("feature_capability_config")) ? "" : this.mStorage.getString("feature_capability_config");
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("feature_capability_com.bytedance.trae.settings.impl.feature.IFeatureCapabilitySettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("feature_capability_com.bytedance.trae.settings.impl.feature.IFeatureCapabilitySettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("feature_capability_com.bytedance.trae.settings.impl.feature.IFeatureCapabilitySettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("feature_capability_com.bytedance.trae.settings.impl.feature.IFeatureCapabilitySettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("feature_capability_com.bytedance.trae.settings.impl.feature.IFeatureCapabilitySettings", "")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("feature_capability_com.bytedance.trae.settings.impl.feature.IFeatureCapabilitySettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                                    metaInfo.setOneSpMigrateDone("feature_capability_com.bytedance.trae.settings.impl.feature.IFeatureCapabilitySettings");
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
                    if (appSettings != null && appSettings.has("feature_capability_config")) {
                        this.mStorage.putString("feature_capability_config", appSettings.optString("feature_capability_config"));
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("feature_capability_com.bytedance.trae.settings.impl.feature.IFeatureCapabilitySettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.trae.praise.IPraiseSettings".equals(str)) {
            return new IPraiseSettings(storage) { // from class: com.bytedance.trae.praise.IPraiseSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = 867768815;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.praise.IPraiseSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.praise.IPraiseSettings
                public JsonObject getAndroidAppRating() {
                    JsonObject jsonObject;
                    this.mExposedManager.markExposed("android_app_rating_v1");
                    if (ExposedManager.needsReporting("android_app_rating_v1") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "android_app_rating_v1");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = android_app_rating_v1", hashMap);
                    }
                    if (this.mStickySettings.containsKey("android_app_rating_v1")) {
                        return (JsonObject) this.mStickySettings.get("android_app_rating_v1");
                    }
                    if (this.mCachedSettings.containsKey("android_app_rating_v1")) {
                        jsonObject = (JsonObject) this.mCachedSettings.get("android_app_rating_v1");
                    } else {
                        Storage storage2 = this.mStorage;
                        JsonObject jsonObject2 = null;
                        if (storage2 != null && storage2.contains("android_app_rating_v1")) {
                            try {
                                jsonObject2 = (JsonObject) GSON.fromJson(this.mStorage.getString("android_app_rating_v1"), new TypeToken<JsonObject>() { // from class: com.bytedance.trae.praise.IPraiseSettings$$Impl.2
                                }.getType());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (jsonObject2 != null) {
                            this.mCachedSettings.put("android_app_rating_v1", jsonObject2);
                        }
                        jsonObject = jsonObject2;
                    }
                    if (jsonObject == null) {
                        return jsonObject;
                    }
                    this.mStickySettings.put("android_app_rating_v1", jsonObject);
                    return jsonObject;
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("praise_settings_com.bytedance.trae.praise.IPraiseSettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("praise_settings_com.bytedance.trae.praise.IPraiseSettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("praise_settings_com.bytedance.trae.praise.IPraiseSettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("praise_settings_com.bytedance.trae.praise.IPraiseSettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("praise_settings_com.bytedance.trae.praise.IPraiseSettings", "")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("praise_settings_com.bytedance.trae.praise.IPraiseSettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                                    metaInfo.setOneSpMigrateDone("praise_settings_com.bytedance.trae.praise.IPraiseSettings");
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
                    if (appSettings != null && appSettings.has("android_app_rating_v1")) {
                        this.mStorage.putString("android_app_rating_v1", appSettings.optString("android_app_rating_v1"));
                        this.mCachedSettings.remove("android_app_rating_v1");
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("praise_settings_com.bytedance.trae.praise.IPraiseSettings", settingsData.getToken());
                }
            };
        }
        if ("com.bytedance.trae.update.settings.IUpdateSdkSettings".equals(str)) {
            return new IUpdateSdkSettings(storage) { // from class: com.bytedance.trae.update.settings.IUpdateSdkSettings$$Impl
                private static final Gson GSON = new Gson();
                private static final int VERSION = 1671090750;
                private Storage mStorage;
                private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
                private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.update.settings.IUpdateSdkSettings$$Impl.1
                    @Override // com.bytedance.news.common.settings.internal.InstanceCreator
                    public <T> T create(Class<T> cls) {
                        return null;
                    }
                };
                private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
                private IEnsure iEnsure = IEnsureWrapper.getInstance();

                public void updateSettings() {
                }

                {
                    this.mStorage = storage;
                }

                @Override // com.bytedance.trae.update.settings.IUpdateSdkSettings
                public JsonObject getUpdateSdkConfig() {
                    JsonObject jsonObject;
                    this.mExposedManager.markExposed("update_sdk_settings");
                    if (ExposedManager.needsReporting("update_sdk_settings") && this.iEnsure != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("settings_key", "update_sdk_settings");
                        hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
                        hashMap.put("settings_thread_name", Thread.currentThread().getName());
                        this.iEnsure.ensureNotReachHere("get settings key = update_sdk_settings", hashMap);
                    }
                    if (this.mStickySettings.containsKey("update_sdk_settings")) {
                        return (JsonObject) this.mStickySettings.get("update_sdk_settings");
                    }
                    if (this.mCachedSettings.containsKey("update_sdk_settings")) {
                        jsonObject = (JsonObject) this.mCachedSettings.get("update_sdk_settings");
                    } else {
                        Storage storage2 = this.mStorage;
                        JsonObject jsonObject2 = null;
                        if (storage2 != null && storage2.contains("update_sdk_settings")) {
                            try {
                                jsonObject2 = (JsonObject) GSON.fromJson(this.mStorage.getString("update_sdk_settings"), new TypeToken<JsonObject>() { // from class: com.bytedance.trae.update.settings.IUpdateSdkSettings$$Impl.2
                                }.getType());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (jsonObject2 != null) {
                            this.mCachedSettings.put("update_sdk_settings", jsonObject2);
                        }
                        jsonObject = jsonObject2;
                    }
                    if (jsonObject == null) {
                        return jsonObject;
                    }
                    this.mStickySettings.put("update_sdk_settings", jsonObject);
                    return jsonObject;
                }

                @Override // com.bytedance.news.common.settings.api.annotation.ISettings
                public void updateSettings(SettingsData settingsData) {
                    MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
                    if (settingsData == null) {
                        if (VERSION != metaInfo.getSettingsVersion("nova_settings_com.bytedance.trae.update.settings.IUpdateSdkSettings")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                            try {
                                if (!ExposedManager.isUseOneSpForAppSettingsStatic()) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.update.settings.IUpdateSdkSettings", VERSION);
                                } else if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.update.settings.IUpdateSdkSettings", VERSION);
                                }
                            } catch (Throwable th) {
                                if (settingsData != null) {
                                    metaInfo.setSettingsVersion("nova_settings_com.bytedance.trae.update.settings.IUpdateSdkSettings", VERSION);
                                }
                                IEnsure iEnsure = this.iEnsure;
                                if (iEnsure != null) {
                                    iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                                }
                            }
                        } else if (metaInfo.needUpdate("nova_settings_com.bytedance.trae.update.settings.IUpdateSdkSettings", "")) {
                            settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        } else if (settingsData == null) {
                            try {
                                if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("nova_settings_com.bytedance.trae.update.settings.IUpdateSdkSettings")) {
                                    settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                                    metaInfo.setOneSpMigrateDone("nova_settings_com.bytedance.trae.update.settings.IUpdateSdkSettings");
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
                    if (appSettings != null && appSettings.has("update_sdk_settings")) {
                        this.mStorage.putString("update_sdk_settings", appSettings.optString("update_sdk_settings"));
                        this.mCachedSettings.remove("update_sdk_settings");
                    }
                    this.mStorage.apply();
                    metaInfo.setStorageKeyUpdateToken("nova_settings_com.bytedance.trae.update.settings.IUpdateSdkSettings", settingsData.getToken());
                }
            };
        }
        return null;
    }
}
