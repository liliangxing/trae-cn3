package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.CoroutineLiveDataKt;
import coil3.disk.DiskLruCache;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.scene.data.SceneDbContract;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.frameworks.core.sdkmonitor.BuildConfig;
import com.bytedance.framwork.core.sdklib.MonitorCommonConstants;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.framwork.core.sdklib.apm6.LogReportController;
import com.bytedance.framwork.core.sdklib.apm6.LogReporter;
import com.bytedance.framwork.core.sdklib.apm6.Monitor;
import com.bytedance.framwork.core.sdklib.apm6.NetworkHelper;
import com.bytedance.framwork.core.sdklib.apm6.SDKContext;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeController;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeInfo;
import com.bytedance.framwork.core.sdklib.apm6.safety.CustomExceptionHelper;
import com.bytedance.framwork.core.sdklib.apm6.safety.EnhancedLogger;
import com.bytedance.framwork.core.sdklib.apm6.safety.Logger;
import com.bytedance.framwork.core.sdklib.thread.AsyncEventManager;
import com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask;
import com.bytedance.framwork.core.sdklib.util.DebugHelper;
import com.bytedance.framwork.core.sdklib.util.JsonUtil;
import com.bytedance.framwork.core.sdklib.util.ListUtils;
import com.bytedance.framwork.core.sdklib.util.ProcessUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class SDKMonitor implements IMonitorTimeTask {
    private static final int BIT_API_ALL_SAMPLE = 1;
    private static final String KEY_DEBUG_UUID = "_debug_uuid";
    private static final String KEY_SELF_DEBUG_MESSAGE = "_debug_self";
    private static final int SDK_VERSION = 400;
    static AtomicLong atomicLong = new AtomicLong(0);
    private static volatile String hostAid;
    private static volatile IHttpService hostHttpService;
    private static long sid;
    private volatile long lastCalculateTimestamp;
    private volatile long lastFullCalculateTimestamp;
    private String mAid;
    private volatile JSONObject mAllowLogType;
    private volatile List<String> mAllowReportList;
    private volatile List<Pattern> mAllowReportPatterns;
    private volatile JSONObject mAllowService;
    private volatile List<String> mBlockReportList;
    private volatile List<Pattern> mBlockReportPatterns;
    private Map<String, String> mCommonParams;
    private Context mContext;
    private volatile JSONObject mCustomAllowLogType;
    private volatile int mDisableReportApiError;
    private volatile long mFetchSettingInterval;
    private volatile boolean mHasInit;
    private JSONObject mHeaderInfo;
    private volatile IHttpService mHttpService;
    private IGetExtendParams mIGetExtendParams;
    private boolean mOversea;
    private volatile int mReportCount;
    private volatile int mReportInterval;
    private volatile int mReportSLA;
    final int SETTINGS_CODE_FULL_MODIFIED = 0;
    final int SETTINGS_CODE_FAIL = -1;
    final int SETTINGS_CODE_NOT_MODIFIED = 1;
    final int SETTINGS_CODE_INCREMENT_MODIFIED = 2;
    private volatile long mLastFetchSettingTime = 0;
    private List<String> mConfigUrls = new LinkedList();
    private volatile boolean mIsEncrypt = true;
    private volatile boolean mConfigExit = false;
    private CacheData mCacheData = new CacheData();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface ICallback {
        void callback(boolean z);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface IGetCommonParams {
        String getSessionId();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface IGetExtendParams {
        Map<String, String> getCommonParams();

        String getSessionId();
    }

    public void flushBuffer() {
    }

    public void flushBuffer(ICallback iCallback) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SDKMonitor(String str) {
        this.mAid = str;
    }

    public boolean init(Context context, JSONObject jSONObject, final IGetCommonParams iGetCommonParams) {
        if (iGetCommonParams == null) {
            return init(context, jSONObject, new IGetExtendParams() { // from class: com.bytedance.framwork.core.sdkmonitor.SDKMonitor.1
                @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
                public Map<String, String> getCommonParams() {
                    return null;
                }

                @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
                public String getSessionId() {
                    return null;
                }
            });
        }
        return init(context, jSONObject, new IGetExtendParams() { // from class: com.bytedance.framwork.core.sdkmonitor.SDKMonitor.2
            @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
            public Map<String, String> getCommonParams() {
                return null;
            }

            @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
            public String getSessionId() {
                return iGetCommonParams.getSessionId();
            }
        });
    }

    public boolean init(final Context context, final JSONObject jSONObject, final IGetExtendParams iGetExtendParams) {
        if (this.mHasInit) {
            return true;
        }
        this.mHasInit = true;
        sid = System.currentTimeMillis();
        Logger.setLoggerImpl(EnhancedLogger.getInstance());
        AsyncEventManager.getInstance().postDelay(new Runnable() { // from class: com.bytedance.framwork.core.sdkmonitor.SDKMonitor.3
            @Override // java.lang.Runnable
            public void run() {
                SDKMonitor.this.initMonitor(context, jSONObject, iGetExtendParams);
                if (SDKMonitor.this.mConfigExit) {
                    SDKMonitor.this.mCacheData.handleCacheData(SDKMonitor.this);
                }
            }
        }, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isHasInit() {
        return this.mHasInit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setHttpService(IHttpService iHttpService) {
        synchronized (SDKMonitor.class) {
            hostHttpService = iHttpService;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setHostAid(String str) {
        hostAid = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMonitor(Context context, JSONObject jSONObject, IGetExtendParams iGetExtendParams) {
        PackageInfo packageInfo;
        if (context == null || jSONObject == null) {
            return;
        }
        this.mHasInit = true;
        this.mContext = context.getApplicationContext();
        this.mHeaderInfo = jSONObject;
        try {
            jSONObject.put(MonitorConstants.KEY_AID, this.mAid);
            this.mHeaderInfo.put("os", "Android");
            this.mHeaderInfo.put("device_platform", "android");
            this.mHeaderInfo.put("os_version", Build.VERSION.RELEASE);
            this.mHeaderInfo.put("os_api", Build.VERSION.SDK_INT);
            this.mHeaderInfo.put("device_model", Build.MODEL);
            this.mHeaderInfo.put("device_brand", Build.BRAND);
            this.mHeaderInfo.put("device_manufacturer", Build.MANUFACTURER);
            this.mHeaderInfo.put(MonitorConstants.KEY_MONITOR_VERSION, BuildConfig.VERSION_NAME);
            this.mHeaderInfo.put(MonitorConstants.KEY_MONITOR_FROM, MonitorConstants.MONITOR_FROM_SDK);
            if (TextUtils.isEmpty(this.mHeaderInfo.optString(MonitorConstants.HOST_APP_PACKAGE_NAME))) {
                this.mHeaderInfo.put(MonitorConstants.HOST_APP_PACKAGE_NAME, context.getPackageName());
            }
            if (TextUtils.isEmpty(this.mHeaderInfo.optString("version_name"))) {
                packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
                this.mHeaderInfo.put("version_name", packageInfo.versionName);
            } else {
                packageInfo = null;
            }
            if (TextUtils.isEmpty(this.mHeaderInfo.optString("version_code"))) {
                if (packageInfo == null) {
                    packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
                }
                this.mHeaderInfo.put("version_code", packageInfo.versionCode);
            }
            this.mIGetExtendParams = iGetExtendParams;
            if (iGetExtendParams == null) {
                this.mIGetExtendParams = new IGetExtendParams() { // from class: com.bytedance.framwork.core.sdkmonitor.SDKMonitor.4
                    @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
                    public Map<String, String> getCommonParams() {
                        return null;
                    }

                    @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
                    public String getSessionId() {
                        return null;
                    }
                };
            }
            Map<String, String> commonParams = this.mIGetExtendParams.getCommonParams();
            this.mCommonParams = commonParams;
            if (commonParams == null) {
                this.mCommonParams = new HashMap();
            }
            this.mOversea = TextUtils.equals(this.mCommonParams.get("oversea"), DiskLruCache.VERSION);
            this.mCommonParams.put(MonitorConstants.KEY_AID, this.mAid);
            this.mCommonParams.put("device_id", this.mHeaderInfo.optString("device_id"));
            this.mCommonParams.put("device_platform", "android");
            this.mCommonParams.put("os", "Android");
            this.mCommonParams.put(MonitorConstants.HOST_APP_PACKAGE_NAME, this.mHeaderInfo.optString(MonitorConstants.HOST_APP_PACKAGE_NAME));
            this.mCommonParams.put("channel", this.mHeaderInfo.optString("channel"));
            this.mCommonParams.put("app_version", this.mHeaderInfo.optString("app_version"));
            this.mCommonParams.put(MonitorConstants.KEY_MONITOR_VERSION, BuildConfig.VERSION_NAME);
            this.mCommonParams.put(MonitorConstants.KEY_QUERY_MINOR_VERSION, DiskLruCache.VERSION);
            this.mCommonParams.put(MonitorConstants.HOST_APP_ID, this.mHeaderInfo.optString(MonitorConstants.HOST_APP_ID));
            if (SDKContext.isDebugMode()) {
                Logger.m1305d(Constants.TAG, "initSDK:" + this.mAid + " " + this.mCommonParams);
                Logger.m1305d(Constants.TAG, "headerInfo:" + this.mAid + " " + this.mHeaderInfo);
            }
            SDKContext.setContext(context);
            SDKContext.setCommonParams(this.mCommonParams);
            SDKContext.setHeader(this.mAid, JsonUtil.deepCopy(this.mHeaderInfo));
            this.mHttpService = (IHttpService) ServiceManager.getService(IHttpService.class);
            initConfig();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IHttpService getHttpService() {
        IHttpService iHttpService;
        if (this.mHttpService == null) {
            this.mHttpService = (IHttpService) ServiceManager.getService(IHttpService.class);
        }
        if (this.mHttpService != null) {
            return this.mHttpService;
        }
        synchronized (this) {
            iHttpService = hostHttpService;
        }
        return iHttpService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetConfigUrls(List<String> list) {
        if (list == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.mConfigUrls.clear();
        this.mConfigUrls.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetReportUrls(List<String> list) {
        if (list == null || ListUtils.isEmpty(list)) {
            return;
        }
        LogReportController.getInstance().setReportUrlList(this.mAid, list);
    }

    private void initConfig() {
        SharedPreferences sp = getSp();
        String string = sp.getString(MonitorConstants.MONITOR_NET_CONFIG, null);
        this.mLastFetchSettingTime = sp.getLong(MonitorConstants.MONITOR_CONFIG_REFRESH_TIME, 0L);
        this.lastCalculateTimestamp = sp.getLong(MonitorConstants.MONITOR_CONFIG_CALCULATE_TIME, 0L);
        this.lastFullCalculateTimestamp = sp.getLong(MonitorConstants.MONITOR_CONFIG_FULL_CALCULATE_TIME, 0L);
        boolean z = sp.getInt(MonitorConstants.MONITOR_CONFIG_UPDATE, 0) == 1;
        AsyncEventManager.getInstance().addTimeTask(this);
        if (!TextUtils.isEmpty(string)) {
            try {
                this.mConfigExit = true;
                if (SDKContext.isDebugMode()) {
                    Logger.m1308i(Constants.TAG, "local_config:" + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                if (!z) {
                    jSONObject.remove("report_host_new");
                }
                updateConfig(jSONObject);
            } catch (Exception unused) {
                Log.e(MonitorConstants.MONITOR_CONFIG, "config error");
            }
        }
        IConfigManager iConfigManager = (IConfigManager) ServiceManager.getService(IConfigManager.class);
        if (iConfigManager != null) {
            iConfigManager.registerConfigListener(new IConfigListener() { // from class: com.bytedance.framwork.core.sdkmonitor.SDKMonitor.5
                public void onReady() {
                }

                public void onRefresh(JSONObject jSONObject2, boolean z2) {
                    NetworkHelper.getInstance().setCompressType(JsonUtils.optJSONObject(jSONObject2, MonitorConstants.SETTING_GENERAL, MonitorConstants.SETTING_GENERAL_API, MonitorConstants.SETTING_GENERAL_API_REPORT).optInt(MonitorConstants.COMPRESS_TYPE, 2));
                }
            });
        }
        updateConfigFromNet(false);
        DowngradeController.getInstance().init(SDKContext.getContext());
    }

    private SharedPreferences getSp() {
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        return this.mContext.getSharedPreferences(MonitorConstants.MONITOR_CONFIG + this.mAid + MonitorHelper.getShortProcessName(context), 0);
    }

    void updateConfigFromNet(boolean z) {
        if (this.mFetchSettingInterval < 600) {
            this.mFetchSettingInterval = 600L;
        }
        if (SDKContext.isDebugMode()) {
            Logger.m1305d(Constants.TAG, "updateConfigFromNet:" + ((z || needUpdateConfigFromNet()) && MonitorNetUtil.isNetworkAvailable(this.mContext)));
        }
        if ((z || needUpdateConfigFromNet()) && MonitorNetUtil.isNetworkAvailable(this.mContext)) {
            synchronized (SDKMonitor.class) {
                this.mLastFetchSettingTime = System.currentTimeMillis();
            }
            try {
                AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.framwork.core.sdkmonitor.SDKMonitor.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (SDKMonitor.this.mCommonParams != null) {
                                for (String str : SDKMonitor.this.mConfigUrls) {
                                    JSONObject retrieveSettingsParams = SDKMonitor.this.retrieveSettingsParams();
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("Content-Type", "application/json; charset=utf-8");
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put(SDKMonitor.this.mAid, retrieveSettingsParams);
                                    byte[] compress = SDKMonitor.compress(jSONObject.toString().getBytes(), hashMap);
                                    if (SDKContext.isDebugMode()) {
                                        Logger.m1305d(Constants.TAG, "url:" + str);
                                    }
                                    try {
                                        byte[] responseBytes = SDKMonitor.this.getHttpService() != null ? SDKMonitor.this.getHttpService().doPost(str, compress, hashMap).getResponseBytes() : MonitorNetUtil.excuteRequest(str, compress, "application/json; charset=utf-8", "gzip", "POST", true, SDKMonitor.this.mIsEncrypt).getResponseBytes();
                                        if (responseBytes != null) {
                                            JSONObject jSONObject2 = new JSONObject(new String(responseBytes));
                                            if (SDKContext.isDebugMode()) {
                                                Logger.m1305d(Constants.TAG, "resultJSON:" + jSONObject2);
                                            }
                                            JSONObject optJSONObject = jSONObject2.optJSONObject(SDKMonitor.this.mAid);
                                            if (optJSONObject == null) {
                                                return;
                                            }
                                            SDKMonitor.this.updateWithSpecificAidResult(optJSONObject);
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th) {
                                        EnsureManager.ensureNotReachHere(th, "SDKMonitor->updateConfigFromNet");
                                        th.printStackTrace();
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            EnsureManager.ensureNotReachHere(th2, "SDKMonitor->updateConfigFromNet tag2");
                            if (!SDKMonitor.this.mConfigExit) {
                                SDKMonitor.this.mConfigExit = true;
                                SDKMonitor.this.mCacheData.handleCacheData(SDKMonitor.this);
                            }
                            th2.printStackTrace();
                        }
                    }
                });
            } catch (Throwable th) {
                EnsureManager.ensureNotReachHere(th, "SDKMonitor->updateConfigFromNet tag3");
            }
        }
    }

    public JSONObject retrieveSettingsParams() {
        HashMap hashMap;
        if (this.mCommonParams != null) {
            hashMap = new HashMap(this.mCommonParams);
        } else {
            hashMap = new HashMap();
        }
        if (!TextUtils.isEmpty(hostAid)) {
            hashMap.put(MonitorConstants.HOST_APP_ID, hostAid);
        }
        hashMap.put("sdk_version", String.valueOf(400));
        hashMap.put("encrypt", "close");
        if (System.currentTimeMillis() - this.lastCalculateTimestamp >= 604800000) {
            hashMap.put("force_refresh", String.valueOf(1));
        }
        hashMap.put("last_calculate_timestamp", String.valueOf(this.lastCalculateTimestamp / 1000));
        hashMap.put("last_full_calculate_timestamp", String.valueOf(this.lastFullCalculateTimestamp / 1000));
        return new JSONObject(hashMap);
    }

    public boolean updateWithSpecificAidResult(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("code", -1);
        if (optInt == -1) {
            return false;
        }
        SharedPreferences sp = getSp();
        SharedPreferences.Editor edit = sp.edit();
        if (optInt == 1) {
            edit.putLong(MonitorConstants.MONITOR_CONFIG_REFRESH_TIME, System.currentTimeMillis());
            edit.putInt(MonitorConstants.MONITOR_CONFIG_UPDATE, 1);
            edit.apply();
            return true;
        }
        if (optInt == 0 || optInt == 2) {
            JSONObject optJSONObject = jSONObject.optJSONObject(Constants.KEY_DATA);
            if (optJSONObject == null) {
                String string = sp.getString(MonitorConstants.MONITOR_NET_CONFIG, "");
                if (TextUtils.isEmpty(string)) {
                    string = "{}";
                }
                try {
                    optJSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    EnsureManager.ensureNotReachHere(e, "SDKMonitor->updateWithSpecificAidResult");
                    optJSONObject = null;
                }
            }
            if (optJSONObject == null) {
                return false;
            }
            try {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("data_to_merge");
                if (optJSONObject2 != null) {
                    JsonUtils.mergeNestedData(optJSONObject, optJSONObject2);
                }
            } catch (JSONException e2) {
                EnsureManager.ensureNotReachHere(e2, "SDKMonitor->updateWithSpecificAidResult 2");
                if (SDKContext.isDebugMode()) {
                    com.bytedance.apm6.util.log.Logger.e(Constants.TAG, "error nested data: dataToMerge");
                }
            }
            try {
                JSONObject optJSONObject3 = jSONObject.optJSONObject("data_to_delete");
                if (optJSONObject3 != null) {
                    JsonUtils.deleteNestedData(optJSONObject, optJSONObject3);
                }
            } catch (JSONException e3) {
                EnsureManager.ensureNotReachHere(e3, "SDKMonitor->updateWithSpecificAidResult 3");
                if (SDKContext.isDebugMode()) {
                    com.bytedance.apm6.util.log.Logger.e(Constants.TAG, "error nested data: dataToDelete");
                }
            }
            this.lastCalculateTimestamp = jSONObject.optInt("last_calculate_timestamp", 0) * 1000;
            this.lastFullCalculateTimestamp = jSONObject.optInt("last_full_calculate_timestamp", 0) * 1000;
            updateConfig(optJSONObject);
            edit.putLong(MonitorConstants.MONITOR_CONFIG_REFRESH_TIME, System.currentTimeMillis());
            edit.putString(MonitorConstants.MONITOR_NET_CONFIG, optJSONObject.toString());
            edit.putLong(MonitorConstants.MONITOR_CONFIG_CALCULATE_TIME, this.lastCalculateTimestamp);
            edit.putLong(MonitorConstants.MONITOR_CONFIG_FULL_CALCULATE_TIME, this.lastFullCalculateTimestamp);
            edit.putInt(MonitorConstants.MONITOR_CONFIG_UPDATE, 1);
            if (!this.mConfigExit) {
                this.mConfigExit = true;
                this.mCacheData.handleCacheData(this);
            }
            edit.apply();
        }
        return true;
    }

    public static byte[] compress(byte[] bArr, Map<String, String> map) throws IOException {
        if (bArr.length <= 128) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                map.put(MonitorNetUtil.KEY_CONTENT_ENCODING, "gzip");
                return byteArray;
            } catch (IOException e) {
                EnsureManager.ensureNotReachHere(e, "SDKMonitor->compress");
                throw e;
            }
        } catch (Throwable th) {
            gZIPOutputStream.close();
            throw th;
        }
    }

    private boolean needUpdateConfigFromNet() {
        return System.currentTimeMillis() - this.mLastFetchSettingTime > this.mFetchSettingInterval * 1000;
    }

    synchronized void updateConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = JsonUtils.optJSONObject(jSONObject, MonitorConstants.SETTING_GENERAL, MonitorConstants.SETTING_GENERAL_API);
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(MonitorConstants.SETTING_GENERAL_API_FETCH);
            if (optJSONObject2 != null) {
                this.mFetchSettingInterval = optJSONObject2.optLong(MonitorConstants.SETTING_GENERAL_API_FETCH_INTERVAL, MonitorConstants.FETCH_SETTING_INTERVAL);
            }
            if (this.mFetchSettingInterval < 600) {
                this.mFetchSettingInterval = 600L;
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject(MonitorConstants.SETTING_GENERAL_API_REPORT);
            boolean z = true;
            if (optJSONObject3 != null) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray optJSONArray = optJSONObject3.optJSONArray("hosts");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String string = optJSONArray.getString(i);
                            if (this.mOversea && (string.contains(".snssdk.") || string.contains(".toutiao."))) {
                                arrayList.clear();
                                break;
                            }
                            if (!TextUtils.isEmpty(string) && string.indexOf(46) > 0) {
                                arrayList.add(string);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
                if (!arrayList.isEmpty()) {
                    LogReportController.getInstance().setReportUrlList(this.mAid, arrayList);
                }
                int i2 = 60;
                this.mReportInterval = optJSONObject3.optInt("uploading_interval", 60);
                if (this.mReportInterval >= 0) {
                    i2 = this.mReportInterval;
                }
                this.mReportInterval = i2;
                LogReporter.getInstance().setLoopInterval(this.mReportInterval * 1000);
                int i3 = 100;
                this.mReportCount = optJSONObject3.optInt("once_max_count", 100);
                if (this.mReportCount >= 0) {
                    i3 = this.mReportCount;
                }
                this.mReportCount = i3;
                this.mIsEncrypt = optJSONObject3.optBoolean("enable_encrypt", true);
                LogReportController.getInstance().setEncrypt(this.mAid, this.mIsEncrypt);
            }
            if (JsonUtils.optInt(jSONObject, MonitorConstants.SETTING_GENERAL, MonitorConstants.SETTING_GENERAL_ENABLE_REPORT_INTERNAL_EXCEPTION) != 1) {
                z = false;
            }
            CustomExceptionHelper.setEnableReport(z);
        }
        if (jSONObject.length() <= 0) {
            return;
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject(MonitorConstants.SETTING_CUSTOM_EVENT);
        if (optJSONObject4 != null) {
            this.mAllowService = optJSONObject4.optJSONObject("allow_service_name");
            this.mAllowLogType = optJSONObject4.optJSONObject("allow_log_type");
            this.mCustomAllowLogType = optJSONObject4.optJSONObject("custom_allow_log_type");
        }
        JSONObject optJSONObject5 = JsonUtils.optJSONObject(jSONObject, MonitorConstants.SETTING_NETWORK_IMAGE_MODULES, MonitorConstants.SETTING_NETWORK);
        if (optJSONObject5 != null) {
            this.mDisableReportApiError = optJSONObject5.optInt("enable_api_error_upload", 0);
            this.mReportSLA = optJSONObject5.optInt("enable_api_all_upload", 0);
            this.mBlockReportList = ListUtils.parseList(optJSONObject5, "api_block_list");
            this.mBlockReportPatterns = ListUtils.parsePatterns(optJSONObject5, "api_block_list");
            this.mAllowReportList = ListUtils.parseMapList(optJSONObject5, "api_allow_list");
            this.mAllowReportPatterns = ListUtils.parseMapPatterns(optJSONObject5, "api_allow_list");
        }
    }

    public boolean getServiceSwitch(String str) {
        return (this.mAllowService == null || TextUtils.isEmpty(str) || this.mAllowService.optInt(str) != 1) ? false : true;
    }

    @Deprecated
    public boolean getLogTypeSwitch(String str) {
        return (this.mAllowLogType == null || TextUtils.isEmpty(str) || this.mAllowLogType.optInt(str) != 1) ? false : true;
    }

    public boolean getLogTypeSwitch(String str, JSONObject jSONObject) {
        if (this.mAllowLogType == null || TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z = this.mAllowLogType.optInt(str) == 1;
        if (z && this.mCustomAllowLogType != null) {
            String optString = this.mCustomAllowLogType.optString(str);
            if (!StringUtils.isEmpty(optString)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object obj = jSONObject2.get(next);
                        if (next.startsWith("$.data.")) {
                            String[] split = next.replace("$.data.", "").split("\\.");
                            Object obj2 = jSONObject;
                            int i = 0;
                            boolean z2 = false;
                            while (true) {
                                if (i < split.length) {
                                    if (obj2 == null) {
                                        z2 = true;
                                        break;
                                    }
                                    if (obj2 instanceof JSONObject) {
                                        obj2 = ((JSONObject) obj2).opt(split[i]);
                                    } else {
                                        z2 = true;
                                    }
                                    i++;
                                } else {
                                    break;
                                }
                            }
                            if (!z2 && obj2 != null && (obj instanceof JSONObject)) {
                                if (!(((JSONObject) obj).optInt(obj2.toString(), 1) == 1)) {
                                    return false;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        }
        return z;
    }

    public int getNetWorkType() {
        return NetworkUtils.getNetworkType(this.mContext).getValue();
    }

    @Override // com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask
    public void onTimeEvent(long j) {
        if (this.mFetchSettingInterval <= 0) {
            return;
        }
        updateConfigFromNet(false);
    }

    public JSONObject reportJsonHeaderInfo() {
        return this.mHeaderInfo;
    }

    private StringBuilder appendUrlParam(StringBuilder sb, String str, String str2) {
        if (sb.charAt(sb.length() - 1) != '?') {
            sb.append("&");
        }
        sb.append(encode(str, UrlUtils.UTF_8)).append('=').append(encode(str2, UrlUtils.UTF_8));
        return sb;
    }

    private static String encode(String str, String str2) {
        if (str2 == null) {
            str2 = UrlUtils.UTF_8;
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private String getSessionId() {
        IGetExtendParams iGetExtendParams = this.mIGetExtendParams;
        if (iGetExtendParams != null) {
            return iGetExtendParams.getSessionId();
        }
        return null;
    }

    public void monitorStatusAndDuration(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (!this.mConfigExit) {
                this.mCacheData.insertServiceMonitorData(new ServiceMonitorData(str, i, jSONObject, null, null, jSONObject2, System.currentTimeMillis()));
            } else {
                monitorServiceAsync(str, i, jSONObject, null, null, jSONObject2, System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    public void monitorStatusRate(String str, int i, JSONObject jSONObject) {
        monitorStatusAndDuration(str, i, null, jSONObject);
    }

    public void monitorDuration(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        monitorStatusAndDuration(str, 0, jSONObject, jSONObject2);
    }

    public void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        try {
            if (!this.mConfigExit) {
                this.mCacheData.insertServiceMonitorData(new ServiceMonitorData(str, 0, null, jSONObject, jSONObject2, jSONObject3, System.currentTimeMillis()));
            } else {
                monitorServiceAsync(str, 0, null, jSONObject, jSONObject2, jSONObject3, System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    public void monitorStatusAndEvent(String str, int i, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        try {
            if (!this.mConfigExit) {
                this.mCacheData.insertServiceMonitorData(new ServiceMonitorData(str, i, null, jSONObject, jSONObject2, jSONObject3, System.currentTimeMillis()));
            } else {
                monitorServiceAsync(str, i, null, jSONObject, jSONObject2, jSONObject3, System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    public void monitorSLA(final long j, final long j2, final String str, final String str2, final String str3, final int i, final JSONObject jSONObject) {
        try {
            if (!this.mConfigExit) {
                this.mCacheData.insertApiData(new ApiData(MonitorConstants.MONITOR_TYPE_API_ALL, j, j2, str, str2, str3, i, jSONObject));
            } else {
                AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.framwork.core.sdkmonitor.SDKMonitor.7
                    @Override // java.lang.Runnable
                    public void run() {
                        SDKMonitor.this.handleNetSLA(j, j2, str, str2, str3, i, jSONObject);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public void monitorApiError(final long j, final long j2, final String str, final String str2, final String str3, final int i, final JSONObject jSONObject) {
        try {
            if (!this.mConfigExit) {
                this.mCacheData.insertApiData(new ApiData(MonitorConstants.MONITOR_TYPE_API_ALL, j, j2, str, str2, str3, i, jSONObject));
            } else {
                AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.framwork.core.sdkmonitor.SDKMonitor.8
                    @Override // java.lang.Runnable
                    public void run() {
                        SDKMonitor.this.handleApiError(j, j2, str, str2, str3, i, jSONObject);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    void monitorServiceAsync(final String str, final int i, final JSONObject jSONObject, final JSONObject jSONObject2, final JSONObject jSONObject3, final JSONObject jSONObject4, final long j) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.framwork.core.sdkmonitor.SDKMonitor.9
            @Override // java.lang.Runnable
            public void run() {
                SDKMonitor.this.monitorService(str, i, jSONObject, jSONObject2, jSONObject3, jSONObject4, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void monitorService(String str, int i, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, long j) {
        if (jSONObject4 == null) {
            try {
                jSONObject4 = new JSONObject();
            } catch (Throwable unused) {
                return;
            }
        }
        jSONObject4.put("log_type", MonitorConstants.MONITOR_TYPE_SERVICE_MONITOR);
        jSONObject4.put("service", str);
        jSONObject4.put("status", i);
        jSONObject4.put(MonitorCommonConstants.KEY_NET_TYPE, getNetWorkType());
        jSONObject4.put(StrategyConstants.VALUE, jSONObject);
        if (jSONObject2 != null) {
            jSONObject4.put("category", jSONObject2);
        }
        if (jSONObject3 != null) {
            jSONObject4.put("metric", jSONObject3);
        }
        if (jSONObject4.isNull(SceneDbContract.Scenes.COLUMN_TIMESTAMP)) {
            jSONObject4.put(SceneDbContract.Scenes.COLUMN_TIMESTAMP, j);
        }
        if (!TextUtils.isEmpty(getSessionId())) {
            jSONObject4.put(MonitorCommonConstants.KEY_SESSION_ID, getSessionId());
        }
        if (getServiceSwitch(str)) {
            addDebugMessage(jSONObject4);
            Monitor.getInstance().record(Long.parseLong(this.mAid), jSONObject4);
        } else if (SDKContext.isDebugMode()) {
            Logger.m1308i(Constants.TAG, "aid:" + this.mAid + " " + str + " notSampled");
        }
    }

    public void monitorCommonLog(String str, JSONObject jSONObject) {
        try {
            if (!this.mConfigExit) {
                this.mCacheData.insertCommonLogData(new CommonLogData(str, jSONObject, System.currentTimeMillis()));
            } else {
                monitorCommonLogAsync(str, jSONObject, System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    public void flushReport() {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.framwork.core.sdkmonitor.SDKMonitor.10
            @Override // java.lang.Runnable
            public void run() {
                LogReporter.getInstance().forceReport();
            }
        });
    }

    public void flushReport(final ICallback iCallback) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.framwork.core.sdkmonitor.SDKMonitor.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    LogReporter.getInstance().forceReport();
                } finally {
                    iCallback.callback(false);
                }
            }
        });
    }

    void monitorCommonLogAsync(final String str, final JSONObject jSONObject, final long j) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.framwork.core.sdkmonitor.SDKMonitor.12
            @Override // java.lang.Runnable
            public void run() {
                SDKMonitor.this.monitorCommonLogInternal(str, jSONObject, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void monitorCommonLogInternal(String str, JSONObject jSONObject, long j) {
        try {
            jSONObject.put("log_type", str);
            jSONObject.put(MonitorCommonConstants.KEY_NET_TYPE, getNetWorkType());
            if (!TextUtils.isEmpty(getSessionId())) {
                jSONObject.put(MonitorCommonConstants.KEY_SESSION_ID, getSessionId());
            }
            if (jSONObject.isNull(SceneDbContract.Scenes.COLUMN_TIMESTAMP)) {
                jSONObject.put(SceneDbContract.Scenes.COLUMN_TIMESTAMP, j);
            }
            if (getLogTypeSwitch(str, jSONObject)) {
                addDebugMessage(jSONObject);
                Monitor.getInstance().record(Long.parseLong(this.mAid), jSONObject);
            } else if (SDKContext.isDebugMode()) {
                Logger.m1308i(Constants.TAG, "aid:" + this.mAid + " " + str + " notSampled");
            }
        } catch (Throwable unused) {
        }
    }

    void handleNetSLA(long j, long j2, String str, String str2, String str3, int i, JSONObject jSONObject) {
        if (isMatchBlackURI(str) || !MonitorNetUtil.isNetworkAvailable(this.mContext)) {
            if (SDKContext.isDebugMode()) {
                Logger.m1308i(Constants.TAG, "isMatchBlackURI or net not available:" + str);
                return;
            }
            return;
        }
        JSONObject packLog = packLog(MonitorConstants.MONITOR_TYPE_API_ALL, j, j2, str, str2, str3, i);
        combineJson(packLog, jSONObject);
        if ((packLog != null && isMatchAllowURI(str)) || this.mReportSLA != 0) {
            try {
                packLog.put(MonitorCommonConstants.KEY_HIT_RULES, 1);
                addDebugMessage(packLog);
                Monitor.getInstance().record(Long.parseLong(this.mAid), packLog);
            } catch (JSONException unused) {
            }
        } else if (SDKContext.isDebugMode()) {
            Logger.m1308i(Constants.TAG, "not sampled:" + str);
        }
    }

    void handleApiError(long j, long j2, String str, String str2, String str3, int i, JSONObject jSONObject) {
        if (this.mDisableReportApiError == 1 || isMatchBlackURI(str)) {
            if (SDKContext.isDebugMode()) {
                Logger.m1308i(Constants.TAG, "isMatchBlackURI or DisableReportApiError:" + str);
                return;
            }
            return;
        }
        JSONObject packLog = packLog(MonitorConstants.MONITOR_TYPE_API_ERROR, j, j2, str, str2, str3, i);
        combineJson(packLog, jSONObject);
        if (packLog == null || packLog.length() <= 0) {
            return;
        }
        addDebugMessage(packLog);
        Monitor.getInstance().record(Long.parseLong(this.mAid), packLog);
    }

    private boolean isMatchAllowURI(String str) {
        return isMatch(str, this.mAllowReportList, this.mAllowReportPatterns);
    }

    private boolean isMatchBlackURI(String str) {
        return isMatch(str, this.mBlockReportList, this.mBlockReportPatterns);
    }

    private boolean isMatch(String str, List<String> list, List<Pattern> list2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!ListUtils.isEmpty(list)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return true;
                }
            }
        }
        try {
            String path = new URI(str).getPath();
            if (!ListUtils.isEmpty(list2)) {
                Iterator<Pattern> it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (it2.next().matcher(path).matches()) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private void combineJson(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null || jSONObject2.length() <= 0) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.get(next));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private JSONObject packLog(String str, long j, long j2, String str2, String str3, String str4, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", str);
            jSONObject.put(DowngradeInfo.FIELD_DURATION, j);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("uri", Uri.parse(str2));
            }
            if (j2 > 0) {
                jSONObject.put(SceneDbContract.Scenes.COLUMN_TIMESTAMP, j2);
            }
            jSONObject.put("status", i);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("ip", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("trace_code", str4);
            } else {
                jSONObject.put("trace_code", "");
            }
            jSONObject.put(MonitorCommonConstants.KEY_NET_TYPE, getNetWorkType());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private void addDebugMessage(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MonitorConstants.KEY_AID, this.mAid);
            DebugHelper.addSeqNum(jSONObject2);
            jSONObject2.put("process_name", ProcessUtils.getCurProcessName(this.mContext));
            jSONObject2.put(KEY_DEBUG_UUID, sid + "_" + atomicLong.getAndAdd(1L));
            jSONObject.put(KEY_SELF_DEBUG_MESSAGE, jSONObject2);
        } catch (Exception unused) {
        }
    }
}
