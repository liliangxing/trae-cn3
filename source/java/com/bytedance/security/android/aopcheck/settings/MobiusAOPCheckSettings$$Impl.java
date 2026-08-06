package com.bytedance.security.android.aopcheck.settings;

import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.Storage;
import com.bytedance.news.common.settings.api.exposed.ExposedManager;
import com.bytedance.news.common.settings.internal.GlobalConfig;
import com.bytedance.news.common.settings.internal.InstanceCache;
import com.bytedance.news.common.settings.internal.InstanceCreator;
import com.bytedance.news.common.settings.internal.LocalCache;
import com.bytedance.news.common.settings.internal.MetaInfo;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.services.apm.api.IEnsure;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class MobiusAOPCheckSettings$$Impl implements MobiusAOPCheckSettings {
    private static final Gson GSON = new Gson();
    private static final int VERSION = -1946464161;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings$$Impl.1
        public <T> T create(Class<T> cls) {
            if (cls == DefaultSettings.class) {
                return (T) new DefaultSettings();
            }
            return null;
        }
    };
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = (IEnsure) ServiceManager.getService(IEnsure.class);

    public MobiusAOPCheckSettings$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings$$Impl$2] */
    @Override // com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings
    public SettingsModel getSettingModel() {
        SettingsModel m924create;
        SettingsModel settingsModel;
        if (this.mCachedSettings.containsKey("security_aop_settings")) {
            m924create = (SettingsModel) this.mCachedSettings.get("security_aop_settings");
            if (m924create == null) {
                m924create = ((DefaultSettings) InstanceCache.obtain(DefaultSettings.class, this.mInstanceCreator)).m924create();
                IEnsure iEnsure = this.iEnsure;
                if (iEnsure != null) {
                    iEnsure.ensureNotReachHere("value == null security_aop_settings");
                }
            }
        } else {
            Storage storage = this.mStorage;
            if (storage != null && storage.contains("security_aop_settings")) {
                String string = this.mStorage.getString("security_aop_settings");
                try {
                    settingsModel = (SettingsModel) GSON.fromJson(string, new TypeToken<SettingsModel>() { // from class: com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings$$Impl.2
                    }.getType());
                } catch (Exception e) {
                    SettingsModel m924create2 = ((DefaultSettings) InstanceCache.obtain(DefaultSettings.class, this.mInstanceCreator)).m924create();
                    IEnsure iEnsure2 = this.iEnsure;
                    if (iEnsure2 != null) {
                        iEnsure2.ensureNotReachHere(e, "gson from json error" + string);
                    }
                    e.printStackTrace();
                    settingsModel = m924create2;
                }
                m924create = settingsModel;
            } else {
                m924create = ((DefaultSettings) InstanceCache.obtain(DefaultSettings.class, this.mInstanceCreator)).m924create();
            }
            if (m924create != null) {
                this.mCachedSettings.put("security_aop_settings", m924create);
            } else {
                m924create = ((DefaultSettings) InstanceCache.obtain(DefaultSettings.class, this.mInstanceCreator)).m924create();
                IEnsure iEnsure3 = this.iEnsure;
                if (iEnsure3 != null) {
                    iEnsure3.ensureNotReachHere("value == null key = security_aop_settings");
                }
            }
        }
        return m924create;
    }

    public void updateSettings(SettingsData settingsData) {
        MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
        if (settingsData == null) {
            if (VERSION != metaInfo.getSettingsVersion("aop_check_settings_com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData(Constant.KEY_SETTING_ID);
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
            } else if (metaInfo.needUpdate("aop_check_settings_com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings", Constant.KEY_SETTING_ID)) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData(Constant.KEY_SETTING_ID);
            } else if (settingsData == null) {
                try {
                    if (this.mExposedManager.isUseOneSpForAppSettings() && !metaInfo.isOneSpMigrateDone("aop_check_settings_com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings")) {
                        settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData(Constant.KEY_SETTING_ID);
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
}
