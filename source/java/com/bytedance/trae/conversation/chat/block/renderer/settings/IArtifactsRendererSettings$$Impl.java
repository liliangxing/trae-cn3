package com.bytedance.trae.conversation.chat.block.renderer.settings;

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
public class IArtifactsRendererSettings$$Impl implements IArtifactsRendererSettings {
    private static final Gson GSON = new Gson();
    private static final int VERSION = 152955228;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings$$Impl.1
        public <T> T create(Class<T> cls) {
            return null;
        }
    };
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public void updateSettings() {
    }

    public IArtifactsRendererSettings$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.settings.IArtifactsRendererSettings
    public String getSettings() {
        this.mExposedManager.markExposed("im_artifacts_renderer");
        if (ExposedManager.needsReporting("im_artifacts_renderer") && this.iEnsure != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("settings_key", "im_artifacts_renderer");
            hashMap.put(C0130f.f138k, String.valueOf(ExposedManager.getSettingsUsingTime()));
            hashMap.put("settings_thread_name", Thread.currentThread().getName());
            this.iEnsure.ensureNotReachHere("get settings key = im_artifacts_renderer", hashMap);
        }
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("im_artifacts_renderer")) ? "" : this.mStorage.getString("im_artifacts_renderer");
    }

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
}
