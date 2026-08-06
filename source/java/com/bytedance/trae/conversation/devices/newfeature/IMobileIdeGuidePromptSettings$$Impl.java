package com.bytedance.trae.conversation.devices.newfeature;

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
public class IMobileIdeGuidePromptSettings$$Impl implements IMobileIdeGuidePromptSettings {
    private static final Gson GSON = new Gson();
    private static final int VERSION = -505058951;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings$$Impl.1
        public <T> T create(Class<T> cls) {
            return null;
        }
    };
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public void updateSettings() {
    }

    public IMobileIdeGuidePromptSettings$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    @Override // com.bytedance.trae.conversation.devices.newfeature.IMobileIdeGuidePromptSettings
    public String getMobileIdeGuidePrompt() {
        this.mExposedManager.markExposed("mobile_ide_guide_prompt");
        if (ExposedManager.needsReporting("mobile_ide_guide_prompt") && this.iEnsure != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("settings_key", "mobile_ide_guide_prompt");
            hashMap.put(C0130f.f138k, String.valueOf(ExposedManager.getSettingsUsingTime()));
            hashMap.put("settings_thread_name", Thread.currentThread().getName());
            this.iEnsure.ensureNotReachHere("get settings key = mobile_ide_guide_prompt", hashMap);
        }
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("mobile_ide_guide_prompt")) ? "" : this.mStorage.getString("mobile_ide_guide_prompt");
    }

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
}
