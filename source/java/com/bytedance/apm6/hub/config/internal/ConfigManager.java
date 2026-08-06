package com.bytedance.apm6.hub.config.internal;

import android.text.TextUtils;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ConfigManager {
    private static volatile ConfigManager sInstance;
    private AsyncTask asyncTask;
    private IConfigManager configManager;
    private volatile boolean inited = false;
    private AsyncTask interceptorAsyncTask;
    private volatile JSONObject mConfigData;
    private boolean mConfigFromLocal;
    private List<IConfigChangeListener> mConfigListeners;
    private volatile boolean mReady;

    private ConfigManager() {
    }

    public static ConfigManager getInstance() {
        if (sInstance == null) {
            synchronized (ConfigManager.class) {
                if (sInstance == null) {
                    sInstance = new ConfigManager();
                }
            }
        }
        return sInstance;
    }

    public synchronized void init() {
        if (this.inited) {
            return;
        }
        this.inited = true;
        if (ApmContext.isMainProcess()) {
            this.asyncTask = new AsyncTask(500L, 1000L) { // from class: com.bytedance.apm6.hub.config.internal.ConfigManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!TextUtils.isEmpty(ApmContext.getDeviceId())) {
                        if (ConfigManager.this.mConfigData == null) {
                            if (ApmContext.isDebugMode()) {
                                Logger.m119d(ConfigConstants.LOG_TAG, "DeviceId ready. initConfig with device_id=" + ApmContext.getDeviceId());
                            }
                            ConfigManager.this.initConfig();
                        } else if (ApmContext.isDebugMode()) {
                            Logger.m119d(ConfigConstants.LOG_TAG, "config is ready");
                        }
                        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(ConfigManager.this.asyncTask);
                        return;
                    }
                    Logger.m119d(ConfigConstants.LOG_TAG, "DeviceId not ready. try again later.");
                }
            };
            AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.asyncTask);
        }
        IConfigManager iConfigManager = (IConfigManager) ServiceManager.getService(IConfigManager.class);
        this.configManager = iConfigManager;
        iConfigManager.registerConfigListener(new IConfigListener() { // from class: com.bytedance.apm6.hub.config.internal.ConfigManager.2
            public void onReady() {
            }

            public void onRefresh(JSONObject jSONObject, final boolean z) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    if (ApmContext.isDebugMode()) {
                        Logger.m119d(ConfigConstants.LOG_TAG, "onRefresh:" + z + " " + jSONObject);
                    }
                    if (ApmContext.isMainProcess() && ConfigManager.this.mConfigData != null && z) {
                        return;
                    }
                    final JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                    ConfigManager.this.interceptorAsyncTask = new AsyncTask() { // from class: com.bytedance.apm6.hub.config.internal.ConfigManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(ConfigManager.this.interceptorAsyncTask);
                                ConfigManager.this.interceptorAsyncTask = null;
                                ConfigManager.this.updateCurrentConfig(jSONObject2, z);
                                if (ApmContext.isDebugMode()) {
                                    Logger.m119d(ConfigConstants.LOG_TAG, "updateCurrentConfig:" + jSONObject2);
                                }
                            } catch (Exception e) {
                                Logger.m121e(ConfigConstants.LOG_TAG, "onConfigChanged", e);
                            }
                        }
                    };
                    AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(ConfigManager.this.interceptorAsyncTask);
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initConfig() {
        if (this.configManager == null) {
            this.configManager = (IConfigManager) ServiceManager.getService(IConfigManager.class);
        }
        IConfigManager iConfigManager = this.configManager;
        if (iConfigManager == null) {
            return;
        }
        String queryConfig = iConfigManager.queryConfig();
        if (ApmContext.isDebugMode()) {
            Logger.m119d(ConfigConstants.LOG_TAG, "initConfig:" + queryConfig);
        }
        try {
            if (TextUtils.isEmpty(queryConfig)) {
                return;
            }
            updateCurrentConfig(new JSONObject(queryConfig), true);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrentConfig(JSONObject jSONObject, boolean z) {
        if (JsonUtils.isEmpty(jSONObject)) {
            return;
        }
        this.mConfigData = jSONObject;
        this.mConfigFromLocal = z;
        notifyListenerRefresh(jSONObject, z);
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
            iConfigChangeListener.onConfigChanged(this.mConfigData, this.mConfigFromLocal);
        }
    }

    public void removeConfigListener(IConfigChangeListener iConfigChangeListener) {
        List<IConfigChangeListener> list;
        if (iConfigChangeListener == null || (list = this.mConfigListeners) == null) {
            return;
        }
        list.remove(iConfigChangeListener);
    }

    private void notifyListenerRefresh(JSONObject jSONObject, boolean z) {
        this.mReady = true;
        List<IConfigChangeListener> list = this.mConfigListeners;
        if (list != null) {
            Iterator<IConfigChangeListener> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onConfigChanged(jSONObject, z);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
