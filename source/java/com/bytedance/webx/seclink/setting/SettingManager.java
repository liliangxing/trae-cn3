package com.bytedance.webx.seclink.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.webx.addr.AddressParam;
import com.bytedance.webx.seclink.SecLinkFacade;
import com.bytedance.webx.seclink.config.AppSecConfig;
import com.bytedance.webx.seclink.setting.SettingConfig;
import com.bytedance.webx.seclink.setting.SettingUpdateTask;
import com.bytedance.webx.seclink.util.JsonParsUtil;
import com.bytedance.webx.seclink.util.Log;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.bytedance.webx.seclink.util.UrlBuilder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SettingManager {
    private static final int INDEX_INIT_VALUE = 0;
    private static final int INDEX_MAX_NUM = 100;
    private static final int MAX_RETRY_COUNT = 2;
    private static final String NEED_UPDATE_SETTING = "need_update_setting";
    private static final int RETRY_DELAY = 1000;
    private static final String SETTING_CACHE_KEY = "setting_config";
    private static final String SETTING_CONFIG = "sec_link_config";
    private static final String SETTING_HOST_INDEX = "setting_host_index";
    private static final long SYNC_CHECK_TIME_OUT = 500;
    private static final long SYN_CHECK_TIME_OUT_MAX_VALUE = 1500;
    private static final long SYN_CHECK_TIME_OUT_MIN_VALUE = 0;
    private static final String TAG = "SettingManager";
    private static final String VERIFY_HOST_INDEX = "verify_host_index";
    private static final int VERIFY_MAX_ERROR_NUM = 3;
    private static volatile SettingManager instance;
    private SettingConfig mCacheConfig;
    private Set<String> mDefaultScheme;
    private SettingConfig mRemoteConfig;
    private SharedPreferences sharedPreferences;
    private int verifyRequestErrorNum = 0;
    private int mSettingHostIndex = 0;
    private int mVerifyHostIndex = 0;
    private int mCurrentRetryNum = 0;
    private SettingConfig mDefaultConfig = DefaultSettings.INSTANCE.getSETTINGS();
    private Map<String, SettingConfig.SceneConfig> mCustomSceneConfig = new HashMap();
    private boolean initDone = false;
    private boolean isRunning = false;

    public static SettingManager getInstance() {
        if (instance == null) {
            synchronized (SettingManager.class) {
                if (instance == null) {
                    instance = new SettingManager();
                }
            }
        }
        return instance;
    }

    private SettingManager() {
        HashSet hashSet = new HashSet();
        this.mDefaultScheme = hashSet;
        hashSet.add("http");
        this.mDefaultScheme.add("https");
        initErrorConfig(this.mDefaultConfig);
    }

    public void init() {
        if (this.initDone) {
            return;
        }
        restoreConfig();
        this.initDone = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initErrorConfig(SettingConfig settingConfig) {
        if (customSettingFirst() || settingConfig == null || settingConfig.config == null) {
            return;
        }
        SecLinkFacade.setErrorConfig(settingConfig.config.error_overwhelming_count, settingConfig.config.error_overwhelming_duration * 1000, settingConfig.config.safe_duration_after_overwhelming * 1000);
    }

    public boolean customSettingFirst() {
        SettingConfig availableConfig = getAvailableConfig();
        if (availableConfig == null || availableConfig.config == null) {
            return false;
        }
        return availableConfig.config.custom_settings_biz_first;
    }

    public static boolean isSafeCheckEnable(String str) {
        SettingConfig availableConfig = getInstance().getAvailableConfig();
        if (availableConfig == null || availableConfig.config == null) {
            return true;
        }
        SettingConfig.SceneConfig sceneCfg = getInstance().getSceneCfg(str);
        if (sceneCfg != null) {
            return sceneCfg.enable;
        }
        return availableConfig.global.enable;
    }

    public SettingConfig.SceneConfig getSceneCfg(String str) {
        SettingConfig.SceneConfig sceneConfig;
        SettingConfig availableConfig;
        Map<String, SettingConfig.SceneConfig> map = this.mCustomSceneConfig;
        if (map == null || map.isEmpty()) {
            sceneConfig = null;
        } else {
            sceneConfig = this.mCustomSceneConfig.get(str);
            if (sceneConfig != null) {
                return sceneConfig;
            }
        }
        return (TextUtils.isEmpty(str) || (availableConfig = getAvailableConfig()) == null || availableConfig.sceneCfgMap == null || availableConfig.sceneCfgMap.isEmpty()) ? sceneConfig : availableConfig.sceneCfgMap.get(str);
    }

    public void setSceneConfig(SettingConfig.SceneConfig sceneConfig) {
        if (sceneConfig == null || TextUtils.isEmpty(sceneConfig.name)) {
            return;
        }
        this.mCustomSceneConfig.put(sceneConfig.name, sceneConfig);
    }

    private void restoreConfig() {
        SettingUpdateHandler.getInstance().postRunnable(new Runnable() { // from class: com.bytedance.webx.seclink.setting.SettingManager.1
            @Override // java.lang.Runnable
            public void run() {
                Context context;
                try {
                    if (SettingManager.this.sharedPreferences == null && (context = SecLinkFacade.getContext()) != null) {
                        SettingManager.this.sharedPreferences = context.getSharedPreferences(SettingManager.SETTING_CONFIG, 0);
                    }
                    if (SettingManager.this.sharedPreferences != null) {
                        String string = SettingManager.this.sharedPreferences.getString(SettingManager.SETTING_CACHE_KEY, "");
                        if (!TextUtils.isEmpty(string)) {
                            SettingManager.this.mCacheConfig = JsonParsUtil.parseSettings(string);
                            SettingManager settingManager = SettingManager.this;
                            settingManager.initErrorConfig(settingManager.mCacheConfig);
                        }
                        String string2 = SettingManager.this.sharedPreferences.getString(SettingManager.SETTING_HOST_INDEX, AddressParam.TYPE_DISAPPROVE);
                        String string3 = SettingManager.this.sharedPreferences.getString(SettingManager.VERIFY_HOST_INDEX, AddressParam.TYPE_DISAPPROVE);
                        SettingManager.this.mSettingHostIndex = Integer.parseInt(string2);
                        SettingManager.this.mVerifyHostIndex = Integer.parseInt(string3);
                        SettingManager.this.updateSettingByCacheState();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSettingByCacheState() {
        SettingConfig settingConfig;
        SharedPreferences sharedPreferences = this.sharedPreferences;
        boolean z = sharedPreferences != null ? sharedPreferences.getBoolean(NEED_UPDATE_SETTING, false) : false;
        if (!z && (settingConfig = this.mCacheConfig) != null) {
            if (settingConfig.global != null) {
                z = (this.mCacheConfig.global.enable && this.mCacheConfig.global.use_verify_mode_v2) ? false : true;
            }
            if (!z && this.mCacheConfig.sceneCfgMap != null && this.mCacheConfig.sceneCfgMap.size() > 0) {
                Iterator<String> it = this.mCacheConfig.sceneCfgMap.keySet().iterator();
                while (it.hasNext()) {
                    SettingConfig.SceneConfig sceneConfig = this.mCacheConfig.sceneCfgMap.get(it.next());
                    if (sceneConfig != null && (!sceneConfig.enable || !sceneConfig.use_verify_mode_v2)) {
                        z = true;
                        break;
                    }
                }
            }
        }
        if (z) {
            updateSetting();
        }
    }

    public Set<String> getSchemeSet(String str) {
        Set<String> set;
        SettingConfig.SceneConfig sceneCfg = getSceneCfg(str);
        if (sceneCfg != null && sceneCfg.scheme != null && !sceneCfg.scheme.isEmpty()) {
            set = sceneCfg.scheme;
        } else {
            SettingConfig availableConfig = getAvailableConfig();
            set = (availableConfig == null || availableConfig.global == null || availableConfig.global.scheme == null || availableConfig.global.scheme.isEmpty()) ? null : availableConfig.global.scheme;
        }
        if (set != null && !set.isEmpty()) {
            if (set.contains(SettingConfig.SPECIAL_SCHEME)) {
                return set;
            }
            set.addAll(this.mDefaultScheme);
            return set;
        }
        return this.mDefaultScheme;
    }

    public boolean useAsyncMode(String str) {
        SettingConfig.SceneConfig sceneCfg = getSceneCfg(str);
        if (sceneCfg != null) {
            return sceneCfg.async_mode;
        }
        SettingConfig availableConfig = getAvailableConfig();
        if (availableConfig == null || availableConfig.global == null) {
            return true;
        }
        return availableConfig.global.async_mode;
    }

    public boolean useVerifyModeV2(String str) {
        SettingConfig.SceneConfig sceneCfg = getSceneCfg(str);
        if (sceneCfg != null) {
            return sceneCfg.use_verify_mode_v2;
        }
        SettingConfig availableConfig = getAvailableConfig();
        if (availableConfig == null || availableConfig.global == null) {
            return true;
        }
        return availableConfig.global.use_verify_mode_v2;
    }

    public void updateSetting() {
        this.mCurrentRetryNum = 0;
        pullSetting();
    }

    private SettingConfig getAvailableConfig() {
        SettingConfig settingConfig = this.mRemoteConfig;
        if (settingConfig != null && settingConfig.config != null) {
            return this.mRemoteConfig;
        }
        SettingConfig settingConfig2 = this.mCacheConfig;
        if (settingConfig2 != null && settingConfig2.config != null) {
            return this.mCacheConfig;
        }
        return this.mDefaultConfig;
    }

    public String getSettingVersion() {
        SettingConfig availableConfig = getAvailableConfig();
        return (availableConfig == null || availableConfig.config == null) ? "" : availableConfig.config.seclink_settings_version;
    }

    private String getSettingHost() {
        List<String> list;
        SettingConfig availableConfig = getAvailableConfig();
        if (availableConfig == null || availableConfig.config == null || (list = availableConfig.config.settings_url_array) == null || list.isEmpty()) {
            return null;
        }
        return list.get(this.mSettingHostIndex % list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pullSetting() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        final String settingHost = getSettingHost();
        final long currentTimeMillis = System.currentTimeMillis();
        SettingUpdateHandler.getInstance().postRunnable(new SettingUpdateTask(settingHost, UrlBuilder.getCommonQueryParam(), new SettingUpdateTask.TaskCallBack() { // from class: com.bytedance.webx.seclink.setting.SettingManager.2
            @Override // com.bytedance.webx.seclink.setting.SettingUpdateTask.TaskCallBack
            public void onSuccess(String str) {
                Log.m48d(SettingManager.TAG, "updateSetting success:" + str);
                try {
                    SettingManager.this.isRunning = false;
                    SettingManager.this.mCurrentRetryNum = 0;
                    ReportUtil.setting(true, System.currentTimeMillis() - currentTimeMillis, settingHost, "");
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    SettingManager.this.mRemoteConfig = JsonParsUtil.parseSettings(str);
                    SettingManager.this.mVerifyHostIndex = 0;
                    SettingManager settingManager = SettingManager.this;
                    settingManager.initErrorConfig(settingManager.mRemoteConfig);
                    SettingManager.this.cacheConfig(SettingManager.VERIFY_HOST_INDEX, SettingManager.this.mVerifyHostIndex + "");
                    SettingManager.this.cacheConfig(SettingManager.SETTING_CACHE_KEY, str);
                    SettingManager.this.cacheConfig(SettingManager.NEED_UPDATE_SETTING, false);
                } catch (Exception e) {
                    e.printStackTrace();
                    SettingManager.this.cacheConfig(SettingManager.NEED_UPDATE_SETTING, true);
                }
            }

            @Override // com.bytedance.webx.seclink.setting.SettingUpdateTask.TaskCallBack
            public void onFail(String str) {
                SettingManager.this.isRunning = false;
                Log.m48d(SettingManager.TAG, "updateSetting fail:" + str);
                ReportUtil.setting(false, System.currentTimeMillis() - currentTimeMillis, settingHost, str);
                SettingManager.this.cacheConfig(SettingManager.NEED_UPDATE_SETTING, true);
                SettingManager.this.retryInNeed();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryInNeed() {
        int i = this.mCurrentRetryNum;
        if (i < 2) {
            this.mCurrentRetryNum = i + 1;
            SettingUpdateHandler.getInstance().postRunnableDelay(new Runnable() { // from class: com.bytedance.webx.seclink.setting.SettingManager.3
                @Override // java.lang.Runnable
                public void run() {
                    SettingManager.this.pullSetting();
                }
            }, this.mCurrentRetryNum * 1000);
            return;
        }
        int i2 = this.mSettingHostIndex + 1;
        this.mSettingHostIndex = i2;
        if (i2 > 100) {
            i2 = 0;
        }
        this.mSettingHostIndex = i2;
        ReportUtil.hostSchedule("setting", i2);
        cacheConfig(SETTING_HOST_INDEX, this.mSettingHostIndex + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cacheConfig(String str, Object obj) {
        try {
            if (this.sharedPreferences == null) {
                this.sharedPreferences = SecLinkFacade.getContext().getSharedPreferences(SETTING_CONFIG, 0);
            }
            if (this.sharedPreferences == null || obj == null || TextUtils.isEmpty(str)) {
                return;
            }
            SharedPreferences.Editor edit = this.sharedPreferences.edit();
            if (obj instanceof String) {
                edit.putString(str, (String) obj);
            } else if (obj instanceof Boolean) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                edit.putInt(str, ((Integer) obj).intValue());
            }
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getVerifyHost() {
        List<String> list;
        SettingConfig availableConfig = getAvailableConfig();
        String str = (availableConfig == null || availableConfig.config == null || (list = availableConfig.config.verify_host_array) == null || list.isEmpty()) ? null : list.get(this.mVerifyHostIndex % list.size());
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        AppSecConfig linkConfig = SecLinkFacade.getLinkConfig();
        return linkConfig != null ? linkConfig.getHost() : "";
    }

    public synchronized void updateVerifyHostIndex() {
        int i = this.verifyRequestErrorNum + 1;
        this.verifyRequestErrorNum = i;
        if (i % 3 == 0) {
            this.mVerifyHostIndex++;
            updateSettingInNeed();
            cacheConfig(VERIFY_HOST_INDEX, this.mVerifyHostIndex + "");
            ReportUtil.hostSchedule("verify", this.mVerifyHostIndex);
        }
    }

    private void updateSettingInNeed() {
        List<String> list;
        int i;
        SettingConfig availableConfig = getAvailableConfig();
        if (availableConfig == null || availableConfig.config == null || (list = availableConfig.config.verify_host_array) == null || list.size() <= 0 || (i = this.mVerifyHostIndex) <= 0 || i % list.size() != 0) {
            return;
        }
        Log.m51i(TAG, "trigger setting update by updateSettingInNeed");
        ReportUtil.startPullSetting("host_schedule", "");
        updateSetting();
    }

    public boolean useCache() {
        SettingConfig availableConfig = getAvailableConfig();
        if (availableConfig == null || availableConfig.config == null) {
            return false;
        }
        return availableConfig.config.use_cache;
    }

    public long getSyncTimeOut() {
        long j;
        if (SecLinkFacade.getLinkConfig() != null && customSettingFirst()) {
            j = SecLinkFacade.getLinkConfig().getTimeout();
        } else {
            SettingConfig availableConfig = getAvailableConfig();
            j = (availableConfig == null || availableConfig.config == null) ? SYNC_CHECK_TIME_OUT : (long) (availableConfig.config.sync_check_time_limit * 1000.0d);
        }
        return Math.min(Math.max(0L, j), SYN_CHECK_TIME_OUT_MAX_VALUE);
    }
}
