package com.bytedance.crash.config;

import android.os.FileObserver;
import android.text.TextUtils;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.crash.Global;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.Net;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ConfigManager implements Runnable {
    public static final String CONFIG_SUFFIX = ".config";
    private static final long FETCH_SETTING_INTERVAL_SECONDS = 1200;
    private static final long MIN_FETCH_SETTING_INTERVAL_SECONDS = 600;
    private static final String MONITOR_CONFIG_REFRESH_TIME = "monitor_configure_refresh_time";
    private static final String SETTING_GENERAL = "general";
    private static final String SETTING_GENERAL_API = "slardar_api_settings";
    private static final String SETTING_GENERAL_API_FETCH = "fetch_setting";
    private static final String SETTING_GENERAL_API_FETCH_INTERVAL = "fetch_setting_interval";
    private static final String TAG = "ConfigManager";
    private static final ConcurrentHashMap<EventMonitor, ConfigManager> mManagers = new ConcurrentHashMap<>();
    private File configFile;
    private JSONObject mConfigData;
    private final EventMonitor mMonitor;
    private boolean mReady;
    private ConfigFileObserver observer;
    private long mFetchSettingIntervalSeconds = 1200;
    private volatile boolean inited = false;
    private long mConfigNetFetchSuccessTs = -1;
    private long mConfigNetRefreshFailedIntervalSeconds = 60000;
    private List<IConfigChangeListener> mConfigListeners = new CopyOnWriteArrayList();

    public ConfigManager(EventMonitor eventMonitor) {
        this.mMonitor = eventMonitor;
        mManagers.put(eventMonitor, this);
    }

    public synchronized void init() {
        if (this.inited) {
            return;
        }
        this.inited = true;
        NpthLog.m234i(TAG, "init：" + this.mMonitor.getAppId());
        DefaultWorkThread.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.mMonitor.getAppId()) || TextUtils.isEmpty(this.mMonitor.getDeviceId(""))) {
            NpthLog.m234i(TAG, "app id isEmpty：");
            if (this.mMonitor instanceof AppMonitor) {
                DefaultWorkThread.postDelayed(this, 200L);
                return;
            } else {
                DefaultWorkThread.postDelayed(this, 500L);
                return;
            }
        }
        DefaultWorkThread.removeCallbacks(this);
        initConfig();
    }

    public void registerConfigListener(IConfigChangeListener iConfigChangeListener) {
        if (iConfigChangeListener == null) {
            return;
        }
        if (this.mConfigListeners == null) {
            this.mConfigListeners = new CopyOnWriteArrayList();
        }
        if (!this.mConfigListeners.contains(iConfigChangeListener)) {
            this.mConfigListeners.add(iConfigChangeListener);
        }
        if (this.mReady) {
            iConfigChangeListener.onConfigChanged(this.mConfigData);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initConfig() {
        updateFromLocal();
        if (App.isMainProcess()) {
            long currentTimeMillis = System.currentTimeMillis() - this.mConfigNetFetchSuccessTs;
            long j = this.mFetchSettingIntervalSeconds * 1000;
            if (currentTimeMillis > j || currentTimeMillis < 0) {
                queryConfigFromRemote();
                return;
            } else {
                DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.config.ConfigManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ConfigManager.this.queryConfigFromRemote();
                    }
                }, j - currentTimeMillis);
                return;
            }
        }
        ConfigFileObserver configFileObserver = new ConfigFileObserver(getConfigFile());
        this.observer = configFileObserver;
        configFileObserver.start();
    }

    protected void updateFromLocal() {
        String queryFromLocal = queryFromLocal();
        if (TextUtils.isEmpty(queryFromLocal)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(queryFromLocal);
            this.mConfigNetFetchSuccessTs = jSONObject.optLong("monitor_configure_refresh_time");
            if (RuntimeConfig.isLocalDebug()) {
                NpthLog.m234i(TAG, "updateFromLocal:" + this.mMonitor.getAppId() + " " + this.mConfigNetFetchSuccessTs);
            }
            updateCurrentConfig(jSONObject);
            notifyListenerRefresh(jSONObject, true);
        } catch (Exception e) {
            NpthLog.m230e(TAG, "updateFromLocal", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean saveConfig(JSONObject jSONObject) {
        try {
            if (RuntimeConfig.isLocalDebug()) {
                NpthLog.m234i(TAG, "saveConfig :" + jSONObject);
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.mConfigNetFetchSuccessTs = currentTimeMillis;
            jSONObject.put("monitor_configure_refresh_time", currentTimeMillis);
            FileUtils.writeFile(getConfigFile(), jSONObject, false);
            updateCurrentConfig(jSONObject);
            notifyListenerRefresh(jSONObject, false);
            return true;
        } catch (Exception e) {
            NpthLog.m230e(TAG, "saveConfig", e);
            return false;
        }
    }

    private void notifyListenerRefresh(JSONObject jSONObject, boolean z) {
        this.mReady = true;
        List<IConfigChangeListener> list = this.mConfigListeners;
        if (list != null) {
            Iterator<IConfigChangeListener> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onConfigChanged(jSONObject);
                } catch (Throwable th) {
                    NpthLog.m230e(TAG, "notifyListenerRefresh", th);
                }
            }
        }
    }

    private String queryFromLocal() {
        File configFile = getConfigFile();
        try {
            return FileUtils.readFile(configFile);
        } catch (Exception unused) {
            if (configFile == null) {
                return null;
            }
            configFile.delete();
            return null;
        }
    }

    private void updateCurrentConfig(JSONObject jSONObject) {
        if (JSONUtils.isEmpty(jSONObject)) {
            return;
        }
        this.mConfigData = jSONObject;
        JSONObject optJSONObject = JSONUtils.optJSONObject(jSONObject, "general", "slardar_api_settings");
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("fetch_setting");
            if (optJSONObject2 != null) {
                this.mFetchSettingIntervalSeconds = optJSONObject2.optLong("fetch_setting_interval", 1200L);
            }
            if (this.mFetchSettingIntervalSeconds < 600) {
                this.mFetchSettingIntervalSeconds = 600L;
            }
            if (RuntimeConfig.isLocalDebug()) {
                NpthLog.m234i(TAG, "updateCurrentConfig:" + this.mFetchSettingIntervalSeconds);
            }
        }
    }

    protected void queryConfigFromRemote() {
        long min;
        if (!Net.isNetworkAvailable()) {
            DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.config.ConfigManager.2
                @Override // java.lang.Runnable
                public void run() {
                    ConfigManager.this.queryConfigFromRemote();
                }
            }, 300000L);
            return;
        }
        if (queryFromNet()) {
            min = this.mFetchSettingIntervalSeconds;
        } else {
            min = Math.min(this.mConfigNetRefreshFailedIntervalSeconds * 2, 600L);
            this.mConfigNetRefreshFailedIntervalSeconds = min;
        }
        if (RuntimeConfig.isLocalDebug()) {
            NpthLog.m234i(TAG, "queryConfigFromRemote:" + min);
        }
        DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.config.ConfigManager.3
            @Override // java.lang.Runnable
            public void run() {
                ConfigManager.this.queryFromNet();
            }
        }, min * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean queryFromNet() {
        JSONObject optJSONObject;
        try {
            String appendUrlParamsByMonitor = UploaderUrl.appendUrlParamsByMonitor(NetConfig.getApmConfigUrl(), this.mMonitor);
            if (RuntimeConfig.isLocalDebug()) {
                NpthLog.m234i(TAG, "queryFromNet:" + appendUrlParamsByMonitor);
            }
            byte[] doGet = CrashUploader.doGet(appendUrlParamsByMonitor);
            if (doGet != null && doGet.length > 0 && (optJSONObject = new JSONObject(new String(doGet)).optJSONObject(SlardarConfigConsts.CONFIG_RET)) != null) {
                return saveConfig(optJSONObject);
            }
        } catch (Throwable th) {
            NpthMonitor.reportInnerException(th);
        }
        return false;
    }

    private File getConfigFile() {
        File file = this.configFile;
        if (file != null) {
            return file;
        }
        File file2 = new File(Global.getRootDirectory(), "configs");
        if (!file2.exists()) {
            FileSystemUtils.createDirectory(file2);
        }
        File file3 = new File(file2, this.mMonitor.getAppId() + CONFIG_SUFFIX);
        this.configFile = file3;
        return file3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class ConfigFileObserver extends FileObserver {
        private final File configFile;

        public ConfigFileObserver(File file) {
            super(file.getAbsolutePath(), 264);
            this.configFile = file;
        }

        public void start() {
            if (!this.configFile.exists()) {
                try {
                    this.configFile.createNewFile();
                } catch (IOException unused) {
                    return;
                }
            }
            startWatching();
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if ((i & 8) != 0) {
                ConfigManager.this.updateFromLocal();
            }
        }
    }
}
