package com.bytedance.news.common.settings;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.news.common.settings.api.Response;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.SettingsLogService;
import com.bytedance.news.common.settings.api.cache.CtxInfoManager;
import com.bytedance.news.common.settings.api.model.SettingsByteSyncModel;
import com.bytedance.news.common.settings.api.model.SettingsRequestModel;
import com.bytedance.news.common.settings.api.model.SettingsRequestParamsModel;
import com.bytedance.news.common.settings.api.request.RequestV3Service;
import com.bytedance.news.common.settings.internal.GlobalConfig;
import com.bytedance.news.common.settings.internal.LocalCache;
import com.bytedance.news.common.settings.internal.LocalSettingsCache;
import com.bytedance.news.common.settings.internal.SettingsCache;
import com.bytedance.news.common.settings.internal.SettingsNetworkUtils;
import com.bytedance.platform.settingsx.api.ILocalSettings;
import com.bytedance.platform.settingsx.api.ISettings;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class IndividualManager {
    private static final String TAG = "IndividualManager";
    private com.bytedance.platform.settingsx.manager.IndividualManager innerManager;
    private volatile SettingsConfig mSettingsConfig;
    private String mSettingsId;
    private volatile LazyConfig sLazyConfig;
    private static final ConcurrentMap<String, IndividualManager> MANAGER_CACHE = new ConcurrentHashMap();
    public static ConcurrentHashMap<String, Long> requestTimeMap = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, Boolean> firstRequestServerMap = new ConcurrentHashMap<>();
    private final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private final ConcurrentHashMap<SettingsUpdateListener, Boolean> LISTENERS = new ConcurrentHashMap<>();
    private final SettingsCache mSettingsCache = new SettingsCache();
    private final LocalSettingsCache mLocalSettingsCache = new LocalSettingsCache();
    private SettingsByteSyncModel settingsByteSyncModel = null;
    private long sLastUpdateTime = 0;
    private long sLastTryUpdateTime = 0;
    private volatile boolean sIsUpdating = false;

    public static IndividualManager obtainManager(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("settingsId不能为空");
        }
        ConcurrentMap<String, IndividualManager> concurrentMap = MANAGER_CACHE;
        IndividualManager individualManager = concurrentMap.get(str);
        if (individualManager == null) {
            synchronized (IndividualManager.class) {
                individualManager = concurrentMap.get(str);
                if (individualManager == null) {
                    individualManager = new IndividualManager(str);
                    concurrentMap.putIfAbsent(str, individualManager);
                }
            }
        }
        return individualManager;
    }

    private IndividualManager(String str) {
        this.mSettingsId = str;
        firstRequestServerMap.put(str, true);
        if (com.bytedance.platform.settingsx.manager.SettingsManager.isInit()) {
            this.innerManager = com.bytedance.platform.settingsx.manager.IndividualManager.obtainManager(str);
        }
    }

    public <T> T obtain(Class<T> cls) {
        if (com.bytedance.platform.settingsx.manager.SettingsManager.isInit() && this.innerManager != null && (ISettings.class.isAssignableFrom(cls) || ILocalSettings.class.isAssignableFrom(cls))) {
            return (T) this.innerManager.obtain(cls);
        }
        return (T) obtain2(cls);
    }

    public <T> T obtain2(Class<T> cls) {
        checkConfig();
        if (com.bytedance.news.common.settings.api.annotation.ISettings.class.isAssignableFrom(cls)) {
            return (T) this.mSettingsCache.obtain(cls, this.mSettingsConfig, this.mSettingsId);
        }
        if (com.bytedance.news.common.settings.api.annotation.ILocalSettings.class.isAssignableFrom(cls)) {
            return (T) this.mLocalSettingsCache.obtain(cls, this.mSettingsConfig, this.mSettingsId);
        }
        throw new IllegalArgumentException("tClass必须是ISettings或ILocalSettings的子类");
    }

    public void init(LazyConfig lazyConfig) {
        this.sLazyConfig = lazyConfig;
    }

    public void registerListener(SettingsUpdateListener settingsUpdateListener, boolean z) {
        this.LISTENERS.put(settingsUpdateListener, Boolean.valueOf(z));
    }

    public void unregisterListener(SettingsUpdateListener settingsUpdateListener) {
        this.LISTENERS.remove(settingsUpdateListener);
    }

    public void updateSettings(final boolean z) {
        checkConfig();
        if (this.sIsUpdating) {
            return;
        }
        this.mSettingsConfig.getExecutor().execute(new Runnable() { // from class: com.bytedance.news.common.settings.IndividualManager.1
            @Override // java.lang.Runnable
            public void run() {
                IndividualManager.this.doUpdateSettings(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpdateSettings(boolean z) {
        SettingsRequestModel settingsRequestModel;
        boolean isMainProcess = this.mSettingsConfig.isMainProcess();
        SettingsLogService settingsLogService = this.mSettingsConfig.getSettingsLogService();
        if (settingsLogService != null) {
            settingsLogService.m133w(TAG, "isMainProcess = " + isMainProcess);
        }
        StringBuilder sb = new StringBuilder();
        SettingsRequestParamsModel requestParamsModel = this.mSettingsConfig.getRequestParamsModel();
        if (requestParamsModel != null) {
            if (requestParamsModel.appId != 0) {
                sb.append("&aid=").append(requestParamsModel.appId);
            }
            if (requestParamsModel.iid != 0) {
                sb.append("&iid=").append(requestParamsModel.iid);
            }
            sb.append("&device_id=").append(requestParamsModel.deviceId);
            sb.append("&channel=").append(requestParamsModel.channel);
            sb.append("&device_platform=").append(requestParamsModel.devicePlatform);
            if (!TextUtils.isEmpty(requestParamsModel.callerName)) {
                sb.append("&caller_name=").append(requestParamsModel.callerName);
            }
            if (!TextUtils.isEmpty(requestParamsModel.region)) {
                sb.append("&region=").append(requestParamsModel.region);
            }
            if (!TextUtils.isEmpty(requestParamsModel.language)) {
                sb.append("&language=").append(requestParamsModel.language);
            }
        }
        Response response = null;
        if (this.settingsByteSyncModel != null) {
            sb.append("&pull_task_data=").append(this.settingsByteSyncModel.taskData);
            sb.append("&pull_task_ids=").append(this.settingsByteSyncModel.taskId);
            this.settingsByteSyncModel = null;
        } else {
            String sdkCtxInfo = CtxInfoManager.getInstance(GlobalConfig.getContext()).getSdkCtxInfo(this.mSettingsId);
            if (!TextUtils.isEmpty(sdkCtxInfo)) {
                sb.append("&ctx_infos=").append(sdkCtxInfo);
            }
        }
        sb.append("&settings_time=").append(Long.valueOf(CtxInfoManager.getInstance(GlobalConfig.getContext()).geSdkSettingsTime(this.mSettingsId)));
        String sb2 = sb.toString();
        if (!isMainProcess) {
            if (settingsLogService != null) {
                settingsLogService.m130e(TAG, "settings 请求不可以在非主进程请求，否则会出现子进程请求覆盖主进程的结果");
                if (settingsLogService.debug()) {
                    throw new IllegalStateException("settings 请求不可以在非主进程请求，否则会出现子进程请求覆盖主进程的结果");
                }
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (z || (currentTimeMillis - this.sLastUpdateTime > this.mSettingsConfig.getUpdateInterval() && SettingsNetworkUtils.isNetworkAvailable(this.mSettingsConfig.getContext()))) {
            if (z || currentTimeMillis - this.sLastTryUpdateTime > this.mSettingsConfig.getRetryInterval()) {
                boolean z2 = true;
                this.sIsUpdating = true;
                this.sLastTryUpdateTime = currentTimeMillis;
                if (TextUtils.isEmpty(sb2)) {
                    z2 = false;
                    settingsRequestModel = null;
                } else {
                    settingsRequestModel = new SettingsRequestModel();
                    settingsRequestModel.urlParams = sb2;
                    if (sb2.contains("pull_task_data")) {
                        settingsRequestModel.isReturnCtxInfo = false;
                    } else {
                        settingsRequestModel.isReturnCtxInfo = true;
                        z2 = false;
                    }
                }
                RequestV3Service requestV3Service = this.mSettingsConfig.getRequestV3Service();
                if (z2) {
                    if (requestV3Service != null) {
                        response = requestV3Service.requestV3(settingsRequestModel);
                    }
                } else if (requestV3Service != null) {
                    response = requestV3Service.requestV3(settingsRequestModel);
                } else {
                    response = this.mSettingsConfig.getRequestService().request();
                }
                if (response != null && response.success) {
                    notifySettingsUpdate(response);
                    this.sLastUpdateTime = currentTimeMillis;
                }
                requestTimeMap.put(this.mSettingsId, Long.valueOf(System.currentTimeMillis()));
                firstRequestServerMap.put(this.mSettingsId, false);
                this.sIsUpdating = false;
            }
        }
    }

    private void notifySettingsUpdate(Response response) {
        if (response.settingsData != null) {
            this.mSettingsCache.updateSettingsData(response.settingsData, this.mSettingsConfig, firstRequestServerMap.get(this.mSettingsId).booleanValue());
            com.bytedance.platform.settingsx.manager.IndividualManager individualManager = this.innerManager;
            if (individualManager != null) {
                individualManager.updateSettings(response.settingsData.getAppSettings());
            }
        }
        CtxInfoManager.getInstance(GlobalConfig.getContext()).updateSdkCtxInfo(this.mSettingsId, response.ctxInfos);
        CtxInfoManager.getInstance(GlobalConfig.getContext()).updateSdkSettingsTime(this.mSettingsId, response.settingsTime);
        SettingsData localSettingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData(this.mSettingsConfig.getId());
        if (localSettingsData != null) {
            onUpdateSettings(localSettingsData);
        }
    }

    public void updateSettingKey(JSONObject jSONObject) {
        SettingsData localSettingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData(this.mSettingsConfig.getId());
        if (localSettingsData != null) {
            JSONObject appSettings = localSettingsData.getAppSettings();
            if (appSettings != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (appSettings.has(next)) {
                        try {
                            appSettings.put(next, jSONObject.opt(next));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.mSettingsCache.updateSettingsData(localSettingsData, this.mSettingsConfig, false);
            onUpdateSettings(localSettingsData);
        }
    }

    private void onUpdateSettings(final SettingsData settingsData) {
        for (final Map.Entry<SettingsUpdateListener, Boolean> entry : this.LISTENERS.entrySet()) {
            if (entry != null) {
                if (entry.getValue().booleanValue()) {
                    this.MAIN_HANDLER.post(new Runnable() { // from class: com.bytedance.news.common.settings.IndividualManager.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ((SettingsUpdateListener) entry.getKey()).onSettingsUpdate(settingsData);
                        }
                    });
                } else {
                    entry.getKey().onSettingsUpdate(settingsData);
                }
            }
        }
    }

    private void checkConfig() {
        if (this.sLazyConfig != null) {
            synchronized (this) {
                if (this.sLazyConfig != null) {
                    SettingsConfig create = this.sLazyConfig.create();
                    create.setId(this.mSettingsId);
                    GlobalConfig.init(create.getContext());
                    this.mSettingsConfig = create;
                }
                this.sLazyConfig = null;
            }
        }
        if (this.mSettingsConfig == null) {
            throw new IllegalStateException("IndividualManager尚未被配置");
        }
    }

    public boolean setSettingsByteSyncModel(SettingsByteSyncModel settingsByteSyncModel) {
        if (settingsByteSyncModel.timeStamp < Math.max(requestTimeMap.get(this.mSettingsId).longValue(), SettingsManager.requestTime)) {
            Log.e(TAG, "settingsByteSyncModel.timeStamp = " + settingsByteSyncModel.timeStamp + " initTime = " + SettingsManager.requestTime + " requestTime = " + requestTimeMap.get(this.mSettingsId));
            return false;
        }
        this.settingsByteSyncModel = settingsByteSyncModel;
        return true;
    }
}
