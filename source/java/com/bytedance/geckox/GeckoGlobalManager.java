package com.bytedance.geckox;

import android.content.Context;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.listener.ListenerManager;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.geckox.strategy.OccasionManager;
import com.bytedance.iesgurd.core.GeckoStore;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.core.RegisterManager;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.settings.GlobalSettingsManager;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class GeckoGlobalManager {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class SingletonHolder {
        private static GeckoGlobalManager instance = new GeckoGlobalManager();

        private SingletonHolder() {
        }
    }

    public static GeckoGlobalManager inst() {
        return SingletonHolder.instance;
    }

    @Deprecated
    public void registerGeckoForPlugin(String str, String str2, Map<String, OptionCheckUpdateParams.CustomValue> map) {
        RegisterManager.INSTANCE.registerGecko(str, str2, map);
    }

    @Deprecated
    public void registerGecko(String str, String str2, Map<String, OptionCheckUpdateParams.CustomValue> map, int i) {
        RegisterManager.INSTANCE.registerGecko(str, str2, map);
    }

    public void registerGecko(IGeckoRegister iGeckoRegister) {
        if (iGeckoRegister == null) {
            return;
        }
        GlobalManager.INSTANCE.registerGecko(iGeckoRegister);
    }

    @Deprecated
    public void registerGecko(IGeckoRegister iGeckoRegister, int i) {
        registerGecko(iGeckoRegister);
    }

    public void registerAccessKey2Dir(String str, String str2) {
        GlobalManager.INSTANCE.registerAccessKey2Dir(str, str2);
    }

    public void registerAccessKey2DirOverride(String str, String str2) {
        GlobalManager.INSTANCE.registerAccessKey2DirOverride(str, str2);
    }

    public Map<String, String> getAccessKeyDirs() {
        return GlobalManager.INSTANCE.getAccessKeyDirs();
    }

    public void init(GeckoGlobalConfig geckoGlobalConfig) {
        GlobalManager.INSTANCE.init(geckoGlobalConfig);
    }

    public void addCustomValueParams(Map<String, Map<String, OptionCheckUpdateParams.CustomValue>> map) {
        RegisterManager.INSTANCE.addParams(map);
    }

    public void registerCustomParams(String str, Map<String, OptionCheckUpdateParams.CustomValue> map) {
        if (str == null || str.isEmpty()) {
            return;
        }
        RegisterManager.INSTANCE.addParams(str, map);
    }

    public GeckoGlobalConfig getGlobalConfig() {
        return GlobalManager.INSTANCE.getGlobalConfig();
    }

    public Context getContext() {
        return GlobalManager.INSTANCE.getContext();
    }

    public GlobalConfigSettings getGlobalSettings() {
        return GlobalManager.INSTANCE.getSettingsEnsureInit();
    }

    public void syncGlobalSettings() {
        GlobalSettingsManager.INSTANCE.fetchGlobalSettings(ReqType.NORMAL, (String) null);
    }

    public boolean isGeckoEnable() {
        return GlobalManager.INSTANCE.isGeckoEnable();
    }

    public void resetDeviceId(String str) {
        GlobalManager.INSTANCE.resetDeviceId(str);
    }

    public void registerGroupUpdateOccasion(String str, String str2, List<String> list) {
        OccasionManager.INSTANCE.registerGroupUpdateOccasion(str, str2, list);
    }

    public void registerChannelUpdateOccasion(String str, String str2, List<String> list) {
        OccasionManager.INSTANCE.registerChannelUpdateOccasion(str, str2, list);
    }

    public boolean triggerUpdateByOccasionLately(String str) {
        return OccasionManager.INSTANCE.triggerUpdateOccasionLately(str);
    }

    public void cancelTriggerUpdate(String str) {
        OccasionManager.INSTANCE.cancelTriggerUpdate(str);
    }

    @Deprecated
    public static void registerGeckoUpdateListener(GeckoUpdateListener geckoUpdateListener) {
        ListenerManager.INSTANCE.register(geckoUpdateListener);
    }

    @Deprecated
    public static void unregisterGeckoUpdateListener(GeckoUpdateListener geckoUpdateListener) {
        ListenerManager.INSTANCE.unregister(geckoUpdateListener);
    }

    public void pauseAllUpdate(long... jArr) {
        GlobalManager.INSTANCE.pauseAllUpdate(jArr);
    }

    public void resumeAllUpdate() {
        GlobalManager.INSTANCE.resumeAllUpdate();
    }

    public void registerPrefetchConfigs(String str, Map<String, List<String>> map) {
        GeckoStore.INSTANCE.registerPrefetchConfigs(str, map);
    }

    public void addLowStorageWhiteList(String str, String[] strArr, String[] strArr2) {
        GeckoStore.INSTANCE.addLowStorageWhiteList(str, strArr, strArr2);
    }

    public void addSensitiveStorageBlockList(String str, String[] strArr, String[] strArr2) {
        GeckoStore.INSTANCE.addSensitiveStorageBlockList(str, strArr, strArr2);
    }
}
