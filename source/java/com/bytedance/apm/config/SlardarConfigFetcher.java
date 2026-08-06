package com.bytedance.apm.config;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.block.FluencyMonitor;
import com.bytedance.apm.constant.CommonConsts;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.apm.constant.ReportUrl;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.core.MonitorSharedPreferences;
import com.bytedance.apm.doctor.DoctorConstants;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.entity.UploadInfo;
import com.bytedance.apm.impl.HttpRequest;
import com.bytedance.apm.internal.FunctionSwitcher;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.apm.util.ProcessUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.ies.argus.bean.ArgusConstants;
import com.bytedance.monitor.collector.LooperMonitor;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.GZIPOutputStream;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SlardarConfigFetcher implements AsyncEventManager.IMonitorTimeTask {
    private static final long DEFAULT_FAILED_INTERVAL = 60000;
    private static final String PROCESS_NAME = "PROCESS_NAME";
    private static final String TAG = "SlardarConfigFetcher";
    private static final String UPDATE_SETTING_ACTION = "com.apm.setting.update.action";
    private boolean isMultiProcessUpdateSetting;
    private volatile long lastCalculateTimestamp;
    private volatile long lastFullCalculateTimestamp;
    private volatile JSONObject mAllowLogType;
    private volatile JSONObject mAllowService;
    private JSONObject mConfigData;
    private boolean mConfigFromLocal;
    private List<IConfigListener> mConfigListeners;
    private boolean mIsMainProcess;
    private volatile JSONObject mMetricType;
    private IQueryParams mQueryParams;
    private volatile boolean mReady;
    private volatile SharedPreferences mSharedPreferences;
    private volatile boolean mExceptionEnableUpload = false;
    private List<String> mQueryUrls = ReportUrl.FETCH_SETTING_LIST;
    private volatile long mFetchSettingInterval = SlardarConfigConsts.FETCH_SETTING_INTERVAL_SECONDS;
    private long mLastFetchSettingTime = -1;
    private long mConfigNetRefreshFailedInterval = 60000;
    private long mConfigNetFetchTimeTs = -1;
    private volatile boolean mInitRegister = false;

    public void initParams(boolean z, IQueryParams iQueryParams, List<String> list) {
        this.isMultiProcessUpdateSetting = z;
        this.mIsMainProcess = ApmContext.isMainProcess();
        initSharedPreferences();
        this.mQueryParams = iQueryParams;
        if (!ListUtils.isEmpty(list)) {
            this.mQueryUrls = convertHost(list);
        }
        initRegister();
    }

    private List<String> convertHost(List<String> list) {
        try {
            if (!ListUtils.isEmpty(list)) {
                ArrayList arrayList = new ArrayList(2);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    String host = new URL(list.get(i)).getHost();
                    if (!TextUtils.isEmpty(host) && host.indexOf(46) > 0) {
                        arrayList.add("https://" + host + ReportConsts.SETTING_PATH);
                    }
                }
                return arrayList;
            }
        } catch (MalformedURLException unused) {
        }
        return Collections.emptyList();
    }

    public void forceUpdateFromRemote(IQueryParams iQueryParams, List<String> list) {
        updateFromLocal();
        if (iQueryParams != null) {
            this.mQueryParams = iQueryParams;
        }
        if (!ListUtils.isEmpty(list)) {
            this.mQueryUrls = new ArrayList(list);
        }
        queryFromNet(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initConfig() {
        boolean updateFromLocal = updateFromLocal();
        if (ApmContext.isMainProcess()) {
            if (this.mLastFetchSettingTime > System.currentTimeMillis()) {
                updateFromLocal = true;
            }
            queryFromNet(updateFromLocal);
        }
    }

    private void initRegister() {
        if (this.mInitRegister) {
            return;
        }
        this.mInitRegister = true;
        if (isCurrentProcessSupportRequestSetting()) {
            AsyncEventManager.getInstance().addTimeTask(this);
        }
        registerBroadUpdateSetting();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean updateFromLocal() {
        JSONObject jSONObject;
        int i;
        boolean z;
        String queryFromLocal = queryFromLocal();
        if (ApmAlogHelper.getInnerLogger() != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("updateFromLocal", TextUtils.isEmpty(queryFromLocal));
                ApmAlogHelper.getInnerLogger().m78d(TAG, jSONObject2.toString());
            } catch (Exception unused) {
            }
        }
        if (ApmContext.isDebugMode()) {
            Logger.m119d(TAG, "configStr:" + queryFromLocal);
        }
        if (ApmContext.isDebugMode()) {
            com.bytedance.apm.logging.Logger.m88i("apm_initializing", "SlardarConfigFetcher.updateFromLocal, configStr=" + queryFromLocal);
        }
        if (!TextUtils.isEmpty(queryFromLocal)) {
            try {
                jSONObject = new JSONObject(queryFromLocal);
                this.mConfigFromLocal = true;
                i = this.mSharedPreferences.getInt(SlardarConfigConsts.MONITOR_NET_CONFIG_VERSION, 0);
                if (ApmContext.isDebugMode()) {
                    com.bytedance.apm.logging.Logger.m88i("apm_initializing", "SlardarConfigFetcher.updateFromLocal, settingVersion=" + i);
                }
            } catch (Exception unused2) {
                com.bytedance.apm.logging.Logger.m87e(DebugLogger.TAG_SETTING, "config read error");
            }
            if (i == 5) {
                this.mLastFetchSettingTime = queryLastRefreshTime();
                this.lastCalculateTimestamp = this.mSharedPreferences.getLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, 0L);
                this.lastFullCalculateTimestamp = this.mSharedPreferences.getLong(SlardarConfigConsts.MONITOR_CONFIG_FULL_CALCULATE_TIME, 0L);
                if (ApmContext.isDebugMode()) {
                    Logger.m119d(TAG, "lastCalculateTimestamp:" + this.lastCalculateTimestamp);
                }
                ApmContext.extendHeader(Constants.KEY_CONFIG_TIME, this.mLastFetchSettingTime + "");
                com.bytedance.apm6.foundation.context.ApmContext.setConfigTime(this.mLastFetchSettingTime);
                updateCurrentConfig(jSONObject);
                notifyListenerRefresh(jSONObject, true);
                notifyListenerReady();
                z = false;
                if (ApmContext.isDebugMode()) {
                    com.bytedance.apm.logging.Logger.m88i("apm_initializing", "SlardarConfigFetcher.updateFromLocal, isForceRefreshFromNet=" + z);
                    DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_LOCAL, "needForceRefreshFromNet:" + z + " localConfig:" + queryFromLocal);
                }
                return z;
            }
        }
        z = true;
        if (ApmContext.isDebugMode()) {
        }
        return z;
    }

    private void registerBroadUpdateSetting() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UPDATE_SETTING_ACTION);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.bytedance.apm.config.SlardarConfigFetcher.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    try {
                        String stringExtra = intent.getStringExtra(SlardarConfigFetcher.PROCESS_NAME);
                        String curProcessName = ProcessUtils.getCurProcessName(ApmContext.getContext());
                        if (ApmContext.isDebugMode()) {
                            com.bytedance.apm.logging.Logger.m88i("apm_initializing", "BroadcastReceiver.onReceive, processName:", stringExtra, "currentProcessName:", curProcessName);
                        }
                        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(curProcessName) || stringExtra.equals(curProcessName)) {
                            return;
                        }
                        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.config.SlardarConfigFetcher.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    SlardarConfigFetcher.this.updateFromLocal();
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    } catch (Throwable unused) {
                    }
                }
            }
        };
        if (ApmContext.getContext() != null) {
            try {
                if (Build.VERSION.SDK_INT > 33) {
                    m74x32ff4428(ApmContext.getContext(), broadcastReceiver, intentFilter, 2);
                } else {
                    m73x32ff4428(ApmContext.getContext(), broadcastReceiver, intentFilter);
                }
            } catch (Throwable th) {
                Logger.m121e(TAG, "registerBroadUpdateSetting", th);
            }
        }
    }

    private void sendBroadUpdateSetting() {
        AsyncEventManager.getInstance().postDelay(new Runnable() { // from class: com.bytedance.apm.config.SlardarConfigFetcher.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(SlardarConfigFetcher.UPDATE_SETTING_ACTION);
                    intent.putExtra(SlardarConfigFetcher.PROCESS_NAME, ProcessUtils.getCurProcessName(ApmContext.getContext()));
                    ApmContext.getContext().sendBroadcast(intent);
                    if (ApmContext.isDebugMode()) {
                        com.bytedance.apm.logging.Logger.m88i("apm_initializing", "BroadcastReceiver.sendBroadUpdateSetting");
                    }
                } catch (Exception unused) {
                }
            }
        }, 1000L);
    }

    public boolean getLogTypeSwitch(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.equals(str, "block_monitor")) {
            str = "caton_monitor";
        }
        if (TextUtils.equals(str, "core_exception_monitor")) {
            return this.mExceptionEnableUpload;
        }
        return this.mAllowLogType != null && this.mAllowLogType.optInt(str) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getMetricTypeSwitch(String str) {
        return (this.mMetricType == null || TextUtils.isEmpty(str) || this.mMetricType.optInt(str) != 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getServiceSwitch(String str) {
        return (this.mAllowService == null || TextUtils.isEmpty(str) || this.mAllowService.optInt(str) != 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getSwitch(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str) || (jSONObject = this.mConfigData) == null) {
            return false;
        }
        return jSONObject.optBoolean(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject getJson(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str) || (jSONObject = this.mConfigData) == null) {
            return new JSONObject();
        }
        return jSONObject.optJSONObject(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getInt(String str, int i) {
        JSONObject jSONObject;
        return (TextUtils.isEmpty(str) || (jSONObject = this.mConfigData) == null) ? i : jSONObject.optInt(str, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isReady() {
        return this.mReady;
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public void onTimeEvent(long j) {
        queryFromNet(false);
    }

    private boolean isNeedRefreshFromNet(long j) {
        long j2 = this.mConfigNetRefreshFailedInterval;
        return j2 > 60000 ? j - this.mConfigNetFetchTimeTs > j2 : j - this.mLastFetchSettingTime > this.mFetchSettingInterval * 1000;
    }

    private long queryLastRefreshTime() {
        return this.mSharedPreferences.getLong(SlardarConfigConsts.MONITOR_CONFIG_REFRESH_TIME, 0L);
    }

    private void initSharedPreferences() {
        if (this.mSharedPreferences == null) {
            synchronized (this) {
                if (this.mSharedPreferences == null) {
                    this.mSharedPreferences = MonitorSharedPreferences.getSharedPreferences(ApmContext.getContext(), SlardarConfigConsts.MONITOR_CONFIG);
                }
            }
        }
    }

    private void queryFromNet(boolean z) {
        if (ApmContext.isDebugMode()) {
            com.bytedance.apm.logging.Logger.m88i("apm_initializing", "SlardarConfigFetcher.queryFromNet." + isCurrentProcessSupportRequestSetting() + " " + isNeedRefreshFromNet(System.currentTimeMillis()));
            DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_NET, "queryFromNet:" + z);
        }
        if (isCurrentProcessSupportRequestSetting() && (z || isNeedRefreshFromNet(System.currentTimeMillis()))) {
            if (!NetUtils.isNetworkAvailable(ApmContext.getContext())) {
                if (ApmContext.isDebugMode()) {
                    com.bytedance.apm.logging.Logger.m88i("apm_initializing", "SlardarConfigFetcher.queryFromNet.NetworkUnavailable");
                    DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_NET_ERROR, "network not available");
                    return;
                }
                return;
            }
            IQueryParams iQueryParams = this.mQueryParams;
            if (iQueryParams == null || iQueryParams.getQueryParams() == null || this.mQueryParams.getQueryParams().isEmpty()) {
                if (ApmContext.isDebugMode()) {
                    com.bytedance.apm.logging.Logger.m88i("apm_initializing", "SlardarConfigFetcher.queryFromNet.ParamsEmpty");
                    DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_NET_ERROR, "mQueryParams not available");
                    return;
                }
                return;
            }
            if (this.lastCalculateTimestamp == 0) {
                this.lastCalculateTimestamp = this.mSharedPreferences.getLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, 0L);
            }
            if (this.lastFullCalculateTimestamp == 0) {
                this.lastFullCalculateTimestamp = this.mSharedPreferences.getLong(SlardarConfigConsts.MONITOR_CONFIG_FULL_CALCULATE_TIME, 0L);
            }
            this.mConfigNetFetchTimeTs = System.currentTimeMillis();
            boolean z2 = false;
            for (String str : this.mQueryUrls) {
                try {
                    JSONObject retrieveSettingsParams = retrieveSettingsParams();
                    String optString = ApmContext.getHeader().optString("aid");
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json; charset=utf-8");
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(optString) && !optString.equals("0")) {
                        jSONObject.put(optString, retrieveSettingsParams);
                    }
                    HttpRequest httpRequest = new HttpRequest(str, hashMap, compress(jSONObject.toString().getBytes(), hashMap));
                    HttpResponse doPost = ApmContext.doPost(httpRequest.url, httpRequest.data, httpRequest.headerMap);
                    if (ApmContext.isDebugMode()) {
                        DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_NET_REQUEST, httpRequest.url);
                    }
                    z2 = handleFetchResult(doPost);
                    if (ApmContext.isDebugMode()) {
                        com.bytedance.apm.logging.Logger.m88i("apm_initializing", "SlardarConfigFetcher.queryFromNet.fetchResult: " + doPost.getResponseBytes().length + " " + z2);
                    }
                } catch (Throwable th) {
                    if (ApmContext.isDebugMode()) {
                        DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_NET_ERROR, "queFromNetError:" + th);
                    }
                }
                if (z2) {
                    break;
                }
            }
            if (!z2) {
                this.mConfigNetRefreshFailedInterval = Math.min(this.mConfigNetRefreshFailedInterval * 2, UploadInfo.DEFAULT_SEND_DURATION);
            } else {
                this.mConfigNetRefreshFailedInterval = 60000L;
            }
        }
    }

    private boolean isCurrentProcessSupportRequestSetting() {
        return this.mIsMainProcess || this.isMultiProcessUpdateSetting;
    }

    public JSONObject getConfigData() {
        return this.mConfigData;
    }

    public JSONObject retrieveSettingsParams() {
        HashMap hashMap;
        IQueryParams iQueryParams = this.mQueryParams;
        Map<String, String> queryParams = (iQueryParams == null || iQueryParams.getQueryParams() == null) ? null : this.mQueryParams.getQueryParams();
        if (queryParams != null) {
            hashMap = new HashMap(queryParams);
        } else {
            hashMap = new HashMap();
        }
        hashMap.put("last_calculate_timestamp", String.valueOf(this.lastCalculateTimestamp / 1000));
        hashMap.put("last_full_calculate_timestamp", String.valueOf(this.lastFullCalculateTimestamp / 1000));
        if (System.currentTimeMillis() - this.lastCalculateTimestamp >= 345600000) {
            hashMap.put("force_refresh", String.valueOf(1));
        }
        hashMap.put(SlardarSettingsConsts.KEY_QUERY_MINOR_VERSION, "1");
        return new JSONObject(hashMap);
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
                map.put("Content-Encoding", "gzip");
                return byteArray;
            } catch (IOException e) {
                EnsureManager.ensureNotReachHere(e, "SlardarConfigFetcher->compress");
                throw e;
            }
        } catch (Throwable th) {
            gZIPOutputStream.close();
            throw th;
        }
    }

    private boolean handleFetchResult(HttpResponse httpResponse) throws JSONException {
        if (httpResponse != null && httpResponse.getStatusCode() == 200) {
            byte[] responseBytes = httpResponse.getResponseBytes();
            if (responseBytes == null) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(new String(responseBytes));
            if (ApmContext.isDebugMode()) {
                Logger.m119d(TAG, "resultJSON:" + jSONObject);
                DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_NET_RESULT, jSONObject.toString());
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(ApmContext.getHeader().optString("aid"));
            if (optJSONObject == null) {
                return false;
            }
            return updateWithSpecificAidResult(optJSONObject);
        }
        if (ApmContext.isDebugMode()) {
            DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_NET_ERROR, "statusCode error:" + (httpResponse == null ? ArgusConstants.NULL_PLACE_HOLDER : Integer.valueOf(httpResponse.getStatusCode())));
        }
        return false;
    }

    public boolean updateWithSpecificAidResult(JSONObject jSONObject) {
        int optInt = jSONObject.optInt(AlogMonitor.ALOG_RESULT_CODE, -1);
        if (optInt == -1) {
            return false;
        }
        if (optInt == 1) {
            this.mLastFetchSettingTime = System.currentTimeMillis();
            this.lastCalculateTimestamp = jSONObject.optInt("last_calculate_timestamp", 0) * 1000;
            this.lastFullCalculateTimestamp = jSONObject.optInt("last_full_calculate_timestamp", 0) * 1000;
            SharedPreferences.Editor edit = this.mSharedPreferences.edit();
            edit.putLong(SlardarConfigConsts.MONITOR_CONFIG_REFRESH_TIME, this.mLastFetchSettingTime);
            edit.putLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, this.lastCalculateTimestamp);
            edit.putLong(SlardarConfigConsts.MONITOR_CONFIG_FULL_CALCULATE_TIME, this.lastFullCalculateTimestamp);
            edit.commit();
            return true;
        }
        if (optInt != 0 && optInt != 2) {
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            String queryFromLocal = queryFromLocal();
            if (TextUtils.isEmpty(queryFromLocal)) {
                queryFromLocal = "{}";
            }
            try {
                optJSONObject = new JSONObject(queryFromLocal);
            } catch (JSONException e) {
                EnsureManager.ensureNotReachHere(e, "SlardarConfigFetcher->updateWithSpecificAidResult");
                if (ApmContext.isDebugMode()) {
                    Logger.m120e(TAG, "error parse configStr:" + queryFromLocal);
                }
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
            EnsureManager.ensureNotReachHere(e2, "SlardarConfigFetcher->updateWithSpecificAidResult 2");
            if (ApmContext.isDebugMode()) {
                Logger.m120e(TAG, "error nested data: dataToMerge");
            }
        }
        try {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("data_to_delete");
            if (optJSONObject3 != null) {
                JsonUtils.deleteNestedData(optJSONObject, optJSONObject3);
            }
        } catch (JSONException e3) {
            EnsureManager.ensureNotReachHere(e3, "SlardarConfigFetcher->updateWithSpecificAidResult 3");
            if (ApmContext.isDebugMode()) {
                Logger.m120e(TAG, "error nested data: dataToDelete");
            }
        }
        this.lastCalculateTimestamp = jSONObject.optInt("last_calculate_timestamp", 0) * 1000;
        this.lastFullCalculateTimestamp = jSONObject.optInt("last_full_calculate_timestamp", 0) * 1000;
        this.mLastFetchSettingTime = System.currentTimeMillis();
        this.mConfigFromLocal = false;
        updateCurrentConfig(optJSONObject);
        saveLocalSwitch(optJSONObject);
        SharedPreferences.Editor edit2 = this.mSharedPreferences.edit();
        edit2.putString(SlardarConfigConsts.MONITOR_NET_CONFIG, optJSONObject.toString());
        edit2.putInt(SlardarConfigConsts.MONITOR_NET_CONFIG_VERSION, 5);
        edit2.putLong(SlardarConfigConsts.MONITOR_CONFIG_REFRESH_TIME, this.mLastFetchSettingTime);
        edit2.putLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, this.lastCalculateTimestamp);
        edit2.putLong(SlardarConfigConsts.MONITOR_CONFIG_FULL_CALCULATE_TIME, this.lastFullCalculateTimestamp);
        edit2.commit();
        notifyListenerRefresh(optJSONObject, false);
        notifyListenerReady();
        ApmContext.extendHeader(Constants.KEY_CONFIG_TIME, this.mLastFetchSettingTime + "");
        com.bytedance.apm6.foundation.context.ApmContext.setConfigTime(this.mLastFetchSettingTime);
        sendBroadUpdateSetting();
        ApmAlogHelper.m77i("apm_debug", DoctorConstants.APM_SETTING_READY);
        return true;
    }

    private void updateCurrentConfig(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (com.bytedance.apm.util.JsonUtils.isEmpty(jSONObject)) {
            return;
        }
        JSONObject optJSONObject2 = com.bytedance.apm.util.JsonUtils.optJSONObject(jSONObject, "general", "slardar_api_settings");
        if (optJSONObject2 != null) {
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject(SlardarSettingsConsts.SETTING_GENERAL_API_FETCH);
            if (optJSONObject3 != null) {
                this.mFetchSettingInterval = optJSONObject3.optLong(SlardarSettingsConsts.SETTING_GENERAL_API_FETCH_INTERVAL, SlardarConfigConsts.FETCH_SETTING_INTERVAL_SECONDS);
            }
            if (this.mFetchSettingInterval < 600) {
                this.mFetchSettingInterval = 600L;
            }
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("custom_event_settings");
        if (optJSONObject4 != null) {
            this.mAllowLogType = optJSONObject4.optJSONObject("allow_log_type");
            this.mMetricType = optJSONObject4.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_METRIC_TYPE);
            this.mAllowService = optJSONObject4.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_SERVICE_NAME);
        }
        this.mConfigData = jSONObject;
        JSONObject json = getJson("exception_modules");
        if (json != null && (optJSONObject = json.optJSONObject("exception")) != null) {
            this.mExceptionEnableUpload = optJSONObject.optInt("enable_upload") == 1;
        }
        if (getServiceSwitch("apm_cost")) {
            LooperMonitor.setReporter(new LooperMonitor.IReporter() { // from class: com.bytedance.apm.config.SlardarConfigFetcher.3
                public void reportCost(final long j) {
                    AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.config.SlardarConfigFetcher.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(CommonConsts.APM_INNER_LOOPER_COST, j);
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("is_main_process", SlardarConfigFetcher.this.mIsMainProcess);
                                ApmAgent.monitorEvent("apm_cost", jSONObject3, jSONObject2, null);
                            } catch (JSONException unused) {
                            }
                        }
                    });
                }
            });
            LooperMonitor.enableLooperCostMonitor(true);
        }
    }

    private void saveLocalSwitch(JSONObject jSONObject) {
        if (jSONObject.optJSONObject("general") != null) {
            FunctionSwitcher.updateSwitch(32, !r0.optBoolean(SlardarSettingsConsts.ENABLE_SALVAGE_LOG, true));
        }
        JSONObject optJSONObject = com.bytedance.apm.util.JsonUtils.optJSONObject(jSONObject, "performance_modules", SlardarSettingsConsts.PERF_KEY_SMOOTH);
        if (optJSONObject != null) {
            FunctionSwitcher.updateSwitch(1, optJSONObject.optInt(SlardarSettingsConsts.PERF_SMOOTH_BLOCK_ENABLE_UPLOAD, 0) == 1);
            FunctionSwitcher.updateSwitch(2, optJSONObject.optInt(SlardarSettingsConsts.PERF_TRACE_ENABLE, 0) == 1);
            FunctionSwitcher.updateSwitch(64, optJSONObject.optInt(SlardarSettingsConsts.PERF_SMOOTH_STACK_SAMPLING, 0) == 1);
            FunctionSwitcher.updateAtraceFlags(optJSONObject.optLong(SlardarSettingsConsts.PERF_ATRACE_TAG, 0L));
            FunctionSwitcher.updateSwitch(SlardarConfigConsts.MONITOR_RUN_MODE_MASK, FluencyMonitor.getMode(jSONObject) << 29);
        }
        JSONObject optJSONObject2 = com.bytedance.apm.util.JsonUtils.optJSONObject(jSONObject, "performance_modules", "start_trace");
        if (optJSONObject2 != null) {
            FunctionSwitcher.updateSwitch(4, optJSONObject2.optInt(SlardarSettingsConsts.PERF_KEY_PERF_DATA_COLLECT, 0) == 1);
            FunctionSwitcher.updateSwitch(8, optJSONObject2.optInt(SlardarSettingsConsts.PERF_KEY_LOCK_DATA_COLLECT, 0) == 1);
            FunctionSwitcher.updateSwitch(16, optJSONObject2.optInt(SlardarSettingsConsts.PERF_KEY_LONG_SLEEP_DATA_COLLECT, 0) == 1);
            FunctionSwitcher.updateSwitch(128, optJSONObject2.optInt(SlardarSettingsConsts.PERF_KEY_THREAD_CPU_COLLECT, 0) == 1);
            FunctionSwitcher.updateLaunchThreadInfoCount(optJSONObject2.optInt(SlardarSettingsConsts.PERF_KEY_THREAD_CPU_COLLECT_COUNT, 0));
        }
        if (optJSONObject == null && optJSONObject2 == null) {
            return;
        }
        FunctionSwitcher.saveToSp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String queryFromLocal() {
        initSharedPreferences();
        return this.mSharedPreferences.getString(SlardarConfigConsts.MONITOR_NET_CONFIG, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addConfigListener(IConfigListener iConfigListener) {
        if (iConfigListener == null) {
            return;
        }
        if (this.mConfigListeners == null) {
            this.mConfigListeners = new CopyOnWriteArrayList();
        }
        if (!this.mConfigListeners.contains(iConfigListener)) {
            this.mConfigListeners.add(iConfigListener);
        }
        if (ApmContext.isDebugMode()) {
            com.bytedance.apm.logging.Logger.m88i("apm_initializing", "addConfigListener, mReady=" + this.mReady);
        }
        if (this.mReady) {
            iConfigListener.onRefresh(this.mConfigData, this.mConfigFromLocal);
            iConfigListener.onReady();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeConfigListener(IConfigListener iConfigListener) {
        List<IConfigListener> list;
        if (iConfigListener == null || (list = this.mConfigListeners) == null) {
            return;
        }
        list.remove(iConfigListener);
    }

    private void notifyListenerRefresh(JSONObject jSONObject, boolean z) {
        List<IConfigListener> list = this.mConfigListeners;
        if (list != null) {
            Iterator<IConfigListener> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onRefresh(jSONObject, z);
                } catch (Throwable th) {
                    if (ApmContext.isDebugMode()) {
                        th.printStackTrace();
                    }
                    EnsureManager.ensureNotReachHere(th);
                }
            }
        }
    }

    private void notifyListenerReady() {
        if (this.mReady) {
            return;
        }
        this.mReady = true;
        List<IConfigListener> list = this.mConfigListeners;
        if (list != null) {
            Iterator<IConfigListener> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onReady();
                } catch (Throwable th) {
                    if (ApmContext.isDebugMode()) {
                        th.printStackTrace();
                    }
                    EnsureManager.ensureNotReachHere(th);
                }
            }
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_apm_config_SlardarConfigFetcher_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m73x32ff4428(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_apm_config_SlardarConfigFetcher_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m74x32ff4428(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, i);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter, i);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, i);
        }
    }
}
