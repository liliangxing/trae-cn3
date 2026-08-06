package com.bytedance.news.common.settings;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.api.Response;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.SettingsLogService;
import com.bytedance.news.common.settings.api.Storage;
import com.bytedance.news.common.settings.api.StorageFactory;
import com.bytedance.news.common.settings.api.cache.CtxInfoManager;
import com.bytedance.news.common.settings.api.exposed.ExposedManager;
import com.bytedance.news.common.settings.api.model.DiffSettingsData;
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
import com.bytedance.platform.settingsx.monitor.SettingsXMonitor;
import com.service.middleware.applog.ApplogService;
import com.service.middleware.applog.IHeaderCustomTimelyCallback;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SettingsManager {
    private static final String TAG = "SettingsManager";
    public static long initTime;
    public static long requestTime;
    private static volatile boolean sHasInitialed;
    private static volatile LazyConfig sLazyConfig;
    private static volatile SettingsConfig sSettingsConfig;
    public static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private static final ConcurrentHashMap<SettingsUpdateListener, Boolean> LISTENERS = new ConcurrentHashMap<>();
    private static final SettingsCache SETTINGS_CACHE = new SettingsCache();
    private static final LocalSettingsCache LOCAL_SETTINGS_CACHE = new LocalSettingsCache();
    private static SettingsByteSyncModel settingsByteSyncModel = null;
    private static volatile boolean sFirstRequestServer = true;
    private static updateSettingsCallback callback = null;
    private static long sLastUpdateTime = 0;
    private static long sLastTryUpdateTime = 0;
    private static volatile boolean sIsUpdating = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface updateSettingsCallback {
        void onUpdateSettingsEnd(long j);

        void onUpdateSettingsStart(long j);
    }

    public static void setUpdateCallback(updateSettingsCallback updatesettingscallback) {
        callback = updatesettingscallback;
    }

    public static <T> T obtain(Class<T> cls) {
        if (com.bytedance.platform.settingsx.manager.SettingsManager.isInit() && (ISettings.class.isAssignableFrom(cls) || ILocalSettings.class.isAssignableFrom(cls))) {
            return (T) com.bytedance.platform.settingsx.manager.SettingsManager.obtain(cls);
        }
        return (T) obtain2(cls);
    }

    public static <T> T obtain2(Class<T> cls) {
        T t;
        long currentTimeMillis = System.currentTimeMillis();
        checkConfig();
        if (com.bytedance.news.common.settings.api.annotation.ISettings.class.isAssignableFrom(cls)) {
            t = (T) SETTINGS_CACHE.obtain(cls, sSettingsConfig, "");
        } else if (com.bytedance.news.common.settings.api.annotation.ILocalSettings.class.isAssignableFrom(cls)) {
            t = (T) LOCAL_SETTINGS_CACHE.obtain(cls, sSettingsConfig, "");
        } else {
            throw new IllegalArgumentException("tClass必须是ISettings或ILocalSettings的子类");
        }
        SettingsXMonitor.monitorDuration(cls.getName(), 0, 0, currentTimeMillis);
        return t;
    }

    public static SettingsData obtainSettingsFast(Context context) {
        if (context instanceof Application) {
            return LocalCache.getInstance(context).getLocalSettingsData("");
        }
        return LocalCache.getInstance(context.getApplicationContext()).getLocalSettingsData("");
    }

    @Deprecated
    public static void init(LazyConfig lazyConfig) {
        sLazyConfig = lazyConfig;
    }

    public static void registerListener(SettingsUpdateListener settingsUpdateListener, boolean z) {
        LISTENERS.put(settingsUpdateListener, Boolean.valueOf(z));
    }

    public static void unregisterListener(SettingsUpdateListener settingsUpdateListener) {
        LISTENERS.remove(settingsUpdateListener);
    }

    public static void updateSettings(final boolean z) {
        checkConfig();
        if (sIsUpdating) {
            return;
        }
        sSettingsConfig.getExecutor().execute(new Runnable() { // from class: com.bytedance.news.common.settings.SettingsManager.1
            @Override // java.lang.Runnable
            public void run() {
                SettingsManager.doUpdateSettings(z);
            }
        });
    }

    public static void clearSpFilesWhenLaunchCrash(Context context) {
        try {
            for (String str : new File(context.getFilesDir().getParent() + "/shared_prefs/").list()) {
                if (!TextUtils.isEmpty(str) && str.endsWith(".sp.xml")) {
                    context.getSharedPreferences(str.replace(".xml", ""), 0).edit().clear().commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Response updateSettingsWhenLaunchCrash() {
        checkConfig();
        if (sIsUpdating) {
            return null;
        }
        return doUpdateSettings(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Response doUpdateSettings(boolean z) {
        boolean z2;
        String str;
        SettingsLogService settingsLogService;
        SettingsRequestModel settingsRequestModel;
        updateSettingsCallback updatesettingscallback;
        updateSettingsCallback updatesettingscallback2;
        if (sFirstRequestServer && (updatesettingscallback2 = callback) != null) {
            updatesettingscallback2.onUpdateSettingsStart(System.currentTimeMillis());
        }
        SettingsConfigProvider settingsConfigProvider = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
        boolean z3 = true;
        Response response = null;
        if (settingsConfigProvider == null || settingsConfigProvider.getConfig() == null) {
            z2 = true;
            str = null;
        } else {
            z2 = settingsConfigProvider.getConfig().isMainProcess();
            SettingsLogService settingsLogService2 = settingsConfigProvider.getConfig().getSettingsLogService();
            if (settingsLogService2 != null) {
                settingsLogService2.m129d(TAG, "isMainProcess = " + z2);
            }
            StringBuilder sb = new StringBuilder();
            SettingsRequestParamsModel requestParamsModel = settingsConfigProvider.getConfig().getRequestParamsModel();
            if (requestParamsModel != null) {
                sb.append("&device_platform=").append(requestParamsModel.devicePlatform);
                if (requestParamsModel.appId != 0) {
                    sb.append("&aid=").append(requestParamsModel.appId);
                }
                if (requestParamsModel.iid != 0) {
                    sb.append("&iid=").append(requestParamsModel.iid);
                }
                sb.append("&channel=").append(requestParamsModel.channel);
                sb.append("&device_brand=").append(requestParamsModel.deviceBrand);
                sb.append("&device_id=").append(requestParamsModel.deviceId);
                sb.append("&device_type=").append(requestParamsModel.deviceType);
                sb.append("&os_api=").append(requestParamsModel.osApi);
                sb.append("&os_version=").append(requestParamsModel.osVersion);
                sb.append("&update_version_code=").append(requestParamsModel.updateVersionCode);
                sb.append("&version_code=").append(requestParamsModel.versionCode);
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
            if (settingsByteSyncModel != null) {
                sb.append("&pull_task_data=").append(settingsByteSyncModel.taskData);
                sb.append("&pull_task_ids=").append(settingsByteSyncModel.taskId);
                settingsByteSyncModel = null;
            } else {
                String ctxInfo = CtxInfoManager.getInstance(GlobalConfig.getContext()).getCtxInfo();
                if (!TextUtils.isEmpty(ctxInfo)) {
                    sb.append("&ctx_infos=").append(ctxInfo);
                }
            }
            sb.append("&settings_time=").append(Long.valueOf(CtxInfoManager.getInstance(GlobalConfig.getContext()).geSettingsTime()));
            str = sb.toString();
        }
        if (z2) {
            long currentTimeMillis = System.currentTimeMillis();
            if ((z || (currentTimeMillis - sLastUpdateTime > sSettingsConfig.getUpdateInterval() && SettingsNetworkUtils.isNetworkAvailable(sSettingsConfig.getContext()))) && (z || currentTimeMillis - sLastTryUpdateTime > sSettingsConfig.getRetryInterval())) {
                sIsUpdating = true;
                sLastTryUpdateTime = currentTimeMillis;
                if (TextUtils.isEmpty(str)) {
                    settingsRequestModel = null;
                } else {
                    settingsRequestModel = new SettingsRequestModel();
                    settingsRequestModel.urlParams = str;
                    if (str.contains("pull_task_data")) {
                        settingsRequestModel.isReturnCtxInfo = false;
                        RequestV3Service requestV3Service = sSettingsConfig.getRequestV3Service();
                        if (z3) {
                            if (requestV3Service != null) {
                                response = requestV3Service.requestV3(settingsRequestModel);
                            } else {
                                response = sSettingsConfig.getRequestService().request();
                            }
                        } else if (requestV3Service != null) {
                            response = requestV3Service.requestV3(settingsRequestModel);
                        }
                        if (response != null && response.success) {
                            notifySettingsUpdate(checkedBySafeMode(response));
                            sLastUpdateTime = currentTimeMillis;
                        }
                        requestTime = System.currentTimeMillis();
                        sIsUpdating = false;
                        if (sFirstRequestServer && (updatesettingscallback = callback) != null) {
                            updatesettingscallback.onUpdateSettingsEnd(System.currentTimeMillis());
                            sFirstRequestServer = false;
                        }
                        return response;
                    }
                    settingsRequestModel.isReturnCtxInfo = true;
                }
                z3 = false;
                RequestV3Service requestV3Service2 = sSettingsConfig.getRequestV3Service();
                if (z3) {
                }
                if (response != null) {
                    notifySettingsUpdate(checkedBySafeMode(response));
                    sLastUpdateTime = currentTimeMillis;
                }
                requestTime = System.currentTimeMillis();
                sIsUpdating = false;
                if (sFirstRequestServer) {
                    updatesettingscallback.onUpdateSettingsEnd(System.currentTimeMillis());
                    sFirstRequestServer = false;
                }
                return response;
            }
        } else if (settingsConfigProvider != null && settingsConfigProvider.getConfig() != null && (settingsLogService = settingsConfigProvider.getConfig().getSettingsLogService()) != null) {
            settingsLogService.m130e(TAG, "settings 请求不可以在非主进程请求，否则会出现子进程请求覆盖主进程的结果");
            if (settingsLogService.debug()) {
                throw new IllegalStateException("settings 请求不可以在非主进程请求，否则会出现子进程请求覆盖主进程的结果");
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[Catch: Exception -> 0x008d, TryCatch #0 {Exception -> 0x008d, blocks: (B:6:0x0005, B:8:0x0013, B:10:0x0029, B:14:0x0068, B:15:0x0074, B:18:0x0033, B:19:0x003d, B:21:0x0043, B:24:0x005f), top: B:5:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0074 A[Catch: Exception -> 0x008d, TRY_LEAVE, TryCatch #0 {Exception -> 0x008d, blocks: (B:6:0x0005, B:8:0x0013, B:10:0x0029, B:14:0x0068, B:15:0x0074, B:18:0x0033, B:19:0x003d, B:21:0x0043, B:24:0x005f), top: B:5:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Response checkedBySafeMode(Response response) {
        if (response.settingsData == null) {
            return response;
        }
        try {
            if (LocalCache.getInstance(GlobalConfig.getContext()).isInSafeMode()) {
                JSONObject fixedSettings = LocalCache.getInstance(GlobalConfig.getContext()).getFixedSettings();
                boolean z = false;
                boolean z2 = true;
                if (response.settingsData.getAppSettings() == null) {
                    if (fixedSettings.length() <= 0) {
                        fixedSettings = null;
                    } else if (!z) {
                        LocalCache.getInstance(GlobalConfig.getContext()).quitSafeMode();
                    } else {
                        response.settingsData = new SettingsData(fixedSettings, response.settingsData.getUserSettings(), response.settingsData.getToken(), response.settingsData.isFromServer());
                    }
                } else {
                    JSONObject appSettings = response.settingsData.getAppSettings();
                    Iterator<String> keys = fixedSettings.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object opt = fixedSettings.opt(next);
                        if (!TextUtils.equals(String.valueOf(opt), String.valueOf(appSettings.opt(next)))) {
                            appSettings.put(next, opt);
                            z2 = false;
                        }
                    }
                    fixedSettings = appSettings;
                }
                z = z2;
                if (!z) {
                }
            }
        } catch (Exception unused) {
        }
        return response;
    }

    public static void notifySettingsUpdate(Response response) {
        checkConfig();
        if (response.settingsData != null) {
            SETTINGS_CACHE.updateSettingsData(response.settingsData, sSettingsConfig, sFirstRequestServer);
            com.bytedance.platform.settingsx.manager.SettingsManager.updateAppSettingsAsync(LocalCache.getInstance(GlobalConfig.getContext()).getAppSettingsDataFromStorage(""));
        }
        if (response.vidInfo != null) {
            try {
                ExposedManager.getInstance(GlobalConfig.getContext()).updateVidInfo(response.vidInfo);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        CtxInfoManager.getInstance(GlobalConfig.getContext()).updateCtxInfo(response.ctxInfos);
        CtxInfoManager.getInstance(GlobalConfig.getContext()).updateSettingsTime(response.settingsTime);
        SettingsData localSettingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData(sSettingsConfig.getId());
        if (localSettingsData != null) {
            onUpdateSettings(localSettingsData);
        }
    }

    private static void onUpdateSettings(final SettingsData settingsData) {
        for (final Map.Entry<SettingsUpdateListener, Boolean> entry : LISTENERS.entrySet()) {
            if (entry != null) {
                if (entry.getValue().booleanValue()) {
                    MAIN_HANDLER.post(new Runnable() { // from class: com.bytedance.news.common.settings.SettingsManager.2
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

    public static void updateSettingKey(JSONObject jSONObject) {
        JSONArray optJSONArray;
        SettingsData localSettingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData(sSettingsConfig.getId());
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
                    } else if ("__null".equals(next) && (optJSONArray = jSONObject.optJSONArray(next)) != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            if (!optJSONArray.isNull(i)) {
                                String optString = optJSONArray.optString(i);
                                if (!TextUtils.isEmpty(optString) && appSettings.has(optString)) {
                                    appSettings.remove(optString);
                                }
                            }
                        }
                    }
                }
            }
            SETTINGS_CACHE.updateSettingsData(localSettingsData, sSettingsConfig, false);
            onUpdateSettings(localSettingsData);
        }
    }

    private static void checkConfig() {
        if (!sHasInitialed) {
            synchronized (SettingsManager.class) {
                if (!sHasInitialed) {
                    final SettingsConfigProvider settingsConfigProvider = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
                    SettingsConfig config = settingsConfigProvider != null ? settingsConfigProvider.getConfig() : null;
                    if (config == null) {
                        config = sLazyConfig != null ? sLazyConfig.create() : null;
                        sLazyConfig = null;
                    }
                    if (config != null) {
                        config.setId("");
                        GlobalConfig.init(config.getContext());
                        sSettingsConfig = config;
                        ExposedManager.setIconfig(config);
                        ExposedManager.setReportSettingsStack(config.isReportSettingsStack());
                        ExposedManager.setDebugTeller(config.getDebugTeller());
                        ExposedManager.setInitSystemTime(System.currentTimeMillis());
                        ApplogService applogService = (ApplogService) ServiceManager.getService(ApplogService.class);
                        if (applogService != null) {
                            applogService.registerHeaderCustomCallback(new IHeaderCustomTimelyCallback() { // from class: com.bytedance.news.common.settings.SettingsManager.3
                                public void updateHeader(JSONObject jSONObject) {
                                    String str;
                                    SettingsLazyConfig lazyConfig;
                                    SettingsConfigProvider settingsConfigProvider2 = SettingsConfigProvider.this;
                                    if (settingsConfigProvider2 != null && (lazyConfig = settingsConfigProvider2.getLazyConfig()) != null) {
                                        try {
                                            ExposedManager.getInstance(GlobalConfig.getContext()).setUpdateVersionCode(lazyConfig.getUpdateVersionCode());
                                        } catch (RuntimeException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    try {
                                        str = ExposedManager.getInstance(GlobalConfig.getContext()).getExposedVids();
                                    } catch (RuntimeException e2) {
                                        e2.printStackTrace();
                                        str = "";
                                    }
                                    if (TextUtils.isEmpty(str) || jSONObject == null) {
                                        return;
                                    }
                                    try {
                                        jSONObject.put("ab_sdk_version", str);
                                        SettingsConfigProvider settingsConfigProvider3 = SettingsConfigProvider.this;
                                        if (settingsConfigProvider3 == null || settingsConfigProvider3.getConfig() == null || SettingsConfigProvider.this.getConfig().getAbReportService() == null) {
                                            return;
                                        }
                                        SettingsConfigProvider.this.getConfig().getAbReportService().setAbSDKVersion(str);
                                    } catch (JSONException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            });
                        }
                        sHasInitialed = true;
                        initTime = System.currentTimeMillis();
                    }
                }
            }
        }
        if (sSettingsConfig == null) {
            throw new IllegalStateException("SettingsManager尚未被配置");
        }
    }

    public static synchronized DiffSettingsData getLocalDiffSettingsData(Context context) {
        DiffSettingsData localDiffSettingsData;
        synchronized (SettingsManager.class) {
            localDiffSettingsData = LocalCache.getInstance(context).getLocalDiffSettingsData();
        }
        return localDiffSettingsData;
    }

    public static synchronized ConcurrentHashMap<String, Long> getUsedKeysTimes() {
        ConcurrentHashMap<String, Long> usedKeys;
        synchronized (SettingsManager.class) {
            usedKeys = ExposedManager.getUsedKeys();
        }
        return usedKeys;
    }

    public static synchronized String updateAppSetting(JSONObject jSONObject) {
        String str;
        synchronized (SettingsManager.class) {
            str = "";
            if (ExposedManager.sDebugTeller != null && ExposedManager.sDebugTeller.isDebug().booleanValue()) {
                str = SETTINGS_CACHE.updateSingleAppSetting(jSONObject, sSettingsConfig);
                SettingsData localSettingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData(sSettingsConfig.getId());
                if (localSettingsData != null) {
                    onUpdateSettings(localSettingsData);
                }
            }
        }
        return str;
    }

    public static synchronized void setClientSetting(String str, int i) {
        Storage create;
        synchronized (SettingsManager.class) {
            if (ExposedManager.sDebugTeller != null && ExposedManager.sDebugTeller.isDebug().booleanValue()) {
                checkConfig();
                StorageFactory storageFactory = sSettingsConfig.getStorageFactory();
                if (storageFactory != null && (create = storageFactory.create(str, false)) != null) {
                    create.putInt(str, i);
                    create.apply();
                }
            }
        }
    }

    public static int getClientSettingNumber(String str) {
        return getClientSettingNumber(str, 0);
    }

    public static int getClientSettingNumber(String str, int i) {
        Storage create;
        checkConfig();
        StorageFactory storageFactory = sSettingsConfig.getStorageFactory();
        return (storageFactory == null || (create = storageFactory.create(str, false)) == null) ? i : create.getInt(str, i);
    }

    public static boolean isMatchTimeToByteSync(SettingsByteSyncModel settingsByteSyncModel2) {
        if (settingsByteSyncModel2.timeStamp >= Math.max(initTime, requestTime)) {
            return true;
        }
        Log.e(TAG, "settingsByteSyncModel.timeStamp = " + settingsByteSyncModel2.timeStamp + " initTime = " + initTime + " requestTime = " + requestTime);
        return false;
    }

    public static void setSettingsByteSyncModel(SettingsByteSyncModel settingsByteSyncModel2) {
        settingsByteSyncModel = settingsByteSyncModel2;
    }

    public static void clearSettingsCache() {
        SETTINGS_CACHE.clearCache();
    }

    public static String getExposedAppSettingsVids() {
        checkConfig();
        return ExposedManager.getInstance(GlobalConfig.getContext()).getExposedAppSettingsVids();
    }

    public static String getExposedLocalSettingsVids() {
        checkConfig();
        return ExposedManager.getInstance(GlobalConfig.getContext()).getExposedLocalSettingsVids();
    }
}
