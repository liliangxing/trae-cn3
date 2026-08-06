package com.bytedance.geckox;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.Resources;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AppSettingsManager {
    private int availableStorage;
    private boolean checkFileBrokenNew;
    private volatile Map<String, ArrayList<String>> cleanChannels;
    private volatile Map<String, String> cleanGroupMap;
    private boolean enableGkFSTidyUp;
    private volatile Map<String, List<String>> forbidRequestWhiteList;
    private boolean gkfsEnable;
    private Map<String, List<String>> gkfsTestChannels;
    private Boolean registerBySPI;
    private int sensitiveStorageAvailable;
    private IGeckoAppSettings settings;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IClientIntelligenceConfig {
        Map<String, List<String>> accessTarget2Parent();

        Map<String, Map<String, Long>> allowList();

        boolean optSwitch();

        Map<String, String> placeholderForAccessKey();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IGeckoAppSettings {
        IClientIntelligenceConfig getConfig();

        Map<String, List<String>> getGkFSTestChannels();

        Map<String, Resources> getOnDemandList();

        int getOnDemandPolicy();

        boolean isForbidRequest();

        boolean isGkFSEnable();

        boolean isGkFSTidyUpEnable();

        boolean isProbeEnable();

        boolean isRegisterBySPI();

        boolean isUseEncrypt();
    }

    private AppSettingsManager() {
        this.availableStorage = -1;
        this.sensitiveStorageAvailable = -1;
        this.checkFileBrokenNew = true;
        this.registerBySPI = true;
        this.gkfsEnable = false;
        this.enableGkFSTidyUp = false;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class SingletonHolder {
        private static AppSettingsManager instance = new AppSettingsManager();

        private SingletonHolder() {
        }
    }

    public static AppSettingsManager inst() {
        return SingletonHolder.instance;
    }

    public void setForbidRequestWhiteList(Map<String, List<String>> map) {
        this.forbidRequestWhiteList = map;
    }

    public boolean isInForbidRequestWhiteList(String str, List<String> list) {
        List<String> list2;
        if (this.forbidRequestWhiteList == null || (list2 = this.forbidRequestWhiteList.get(str)) == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (list2.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean getRegisterBySPI() {
        IGeckoAppSettings geckoAppSettings = getGeckoAppSettings();
        if (geckoAppSettings != null) {
            this.registerBySPI = Boolean.valueOf(geckoAppSettings.isRegisterBySPI());
        }
        GeckoLogger.m296d("getRegisterBySPI: " + this.registerBySPI);
        return this.registerBySPI.booleanValue();
    }

    public void setRegisterBySPI(boolean z) {
        GeckoLogger.m296d("setRegisterBySPI: " + z);
        this.registerBySPI = Boolean.valueOf(z);
    }

    public void setCleanGroupMap(Map<String, String> map) {
        this.cleanGroupMap = map;
    }

    public Map<String, String> getCleanGroupMap() {
        return this.cleanGroupMap;
    }

    public void setCheckFileBrokenNew(boolean z) {
        this.checkFileBrokenNew = z;
    }

    public boolean isCheckFileBrokenNew() {
        return this.checkFileBrokenNew;
    }

    public void setCleanChannels(Map<String, ArrayList<String>> map) {
        this.cleanChannels = map;
    }

    public Map<String, ArrayList<String>> getCleanChannels() {
        return this.cleanChannels;
    }

    public int getAvailableStorage() {
        return this.availableStorage;
    }

    public void setAvailableStorage(int i) {
        this.availableStorage = i;
    }

    public int getSensitiveStorageAvailable() {
        return this.sensitiveStorageAvailable;
    }

    public void setSensitiveStorageAvailable(int i) {
        this.sensitiveStorageAvailable = i;
    }

    public void setGkFSEnable(boolean z) {
        GeckoLogger.m296d("setGkFSEnable: " + z);
        this.gkfsEnable = z;
    }

    public boolean getGkFSEnable() {
        IGeckoAppSettings geckoAppSettings = getGeckoAppSettings();
        if (geckoAppSettings != null) {
            this.gkfsEnable = geckoAppSettings.isGkFSEnable();
        }
        GeckoLogger.m296d("getGkFSEnable: " + this.gkfsEnable);
        return this.gkfsEnable;
    }

    public void setGkFSTestChannels(Map<String, List<String>> map) {
        if (map == null) {
            GeckoLogger.m296d("setGkFSTestChannels: null");
        }
        this.gkfsTestChannels = map;
    }

    public Map<String, List<String>> getGkFSTestChannels() {
        IGeckoAppSettings geckoAppSettings = getGeckoAppSettings();
        if (geckoAppSettings != null) {
            this.gkfsTestChannels = geckoAppSettings.getGkFSTestChannels();
        }
        if (this.gkfsTestChannels == null) {
            GeckoLogger.m296d("getGkFSTestChannels: null");
        }
        return this.gkfsTestChannels;
    }

    public void setGkFSTidyUpEnable(boolean z) {
        GeckoLogger.m296d("setGkFSTidyUpEnable: " + z);
        this.enableGkFSTidyUp = z;
    }

    public boolean getGkFSTidyUpEnable() {
        IGeckoAppSettings geckoAppSettings = getGeckoAppSettings();
        if (geckoAppSettings != null) {
            this.enableGkFSTidyUp = geckoAppSettings.isGkFSTidyUpEnable();
        }
        GeckoLogger.m296d("enableGkFSTidyUp: " + this.enableGkFSTidyUp);
        return this.enableGkFSTidyUp;
    }

    public IGeckoAppSettings getGeckoAppSettings() {
        if (this.settings == null) {
            this.settings = (IGeckoAppSettings) ServiceManager.get().getServiceForReal(IGeckoAppSettings.class);
        }
        return this.settings;
    }

    public void setSettings(IGeckoAppSettings iGeckoAppSettings) {
        this.settings = iGeckoAppSettings;
    }
}
