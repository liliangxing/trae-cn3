package com.bytedance.apm6.consumer.slardar.header;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.listener.INtpTimeService;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.SlardarProperties;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.foundation.context.ApmContextAdapter;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.RomUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.bdturing.utils.Consts;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class HeaderManager {
    private static volatile HeaderManager sInstance;
    private HeaderInfo currentHeaderInfo;
    private Map<String, HeaderInfo> headers = new ConcurrentHashMap();
    private long nptOffset = -1;
    private long nptTime = -1;
    private AsyncTask ntpAsyncTask;

    public static HeaderManager getInstance() {
        if (sInstance == null) {
            synchronized (HeaderManager.class) {
                if (sInstance == null) {
                    sInstance = new HeaderManager();
                }
            }
        }
        return sInstance;
    }

    public void init() {
        HeaderInfo headerInfo = new HeaderInfo();
        headerInfo.setOs("Android");
        headerInfo.setDevicePlatform(Consts.OS_NAME);
        headerInfo.setOsVersion(Build.VERSION.RELEASE);
        headerInfo.setApiVersion(Build.VERSION.SDK_INT);
        headerInfo.setDeviceModel(Build.MODEL);
        headerInfo.setDeviceBrand(Build.BRAND);
        headerInfo.setDeviceManufacturer(Build.MANUFACTURER);
        headerInfo.setProcessName(ApmContext.getCurrentProcessName());
        headerInfo.setSid(ApmContext.getStartId());
        headerInfo.setRomVersion(RomUtils.getRomInfo());
        headerInfo.setVerifyInfo(SlardarProperties.getReleaseBuild());
        headerInfo.setPhoneStartTime(ApmContext.getInitTimeStamp());
        headerInfo.setChannel(ApmContext.getChannel());
        headerInfo.setAid(ApmContext.getAid());
        headerInfo.setUid(ApmContext.getUserID());
        headerInfo.setUpdateVersionCode(String.valueOf(ApmContext.getUpdateVersionCode()));
        headerInfo.setVersionName(ApmContext.getVersionName());
        headerInfo.setVersionCode(String.valueOf(ApmContext.getVersionCode()));
        headerInfo.setAppVersion(ApmContext.getAppVersion());
        headerInfo.setReleaseBuild(ApmContext.getReleaseBuild());
        headerInfo.setPackageName(ApmContext.getContext().getPackageName());
        headerInfo.setCurrentUpdateVersionCode(headerInfo.getUpdateVersionCode());
        headerInfo.setManifestVersionCode(ApmContext.getManifestVersionCode());
        headerInfo.setConfigTime(ApmContext.getConfigTime());
        JSONObject jSONObject = new JSONObject();
        try {
            JsonUtils.copyJson2(jSONObject, ApmContext.getStableHeaderExtras());
            if (jSONObject.has("version_code")) {
                jSONObject.remove("version_code");
            }
            if (jSONObject.has("app_version")) {
                jSONObject.remove("app_version");
            }
            if (jSONObject.has("uid")) {
                jSONObject.remove("uid");
            }
            if (jSONObject.has("update_version_code")) {
                jSONObject.remove("update_version_code");
            }
            if (jSONObject.has("manifest_version_code")) {
                jSONObject.remove("manifest_version_code");
            }
        } catch (Exception e) {
            Logger.m120e("APM", "header json exception" + e.toString());
        }
        headerInfo.setStableExtra(jSONObject);
        headerInfo.setMonitorVersion("5.0.21.41");
        if (ApmContext.isMainProcess()) {
            HeaderStoreManager.getInstance().deleteExpireFile();
        }
        saveHeaderInfo(headerInfo);
    }

    public HeaderInfo getHeaderInfo(String str) {
        HeaderInfo headerInfo;
        if (this.headers.containsKey(str)) {
            headerInfo = this.headers.get(str);
        } else {
            HeaderInfo headerInfo2 = HeaderStoreManager.getInstance().getHeaderInfo(str);
            if (headerInfo2 != null) {
                this.headers.put(str, headerInfo2);
                headerInfo = headerInfo2;
            } else {
                return this.currentHeaderInfo;
            }
        }
        updateHeaderInfo(headerInfo);
        return headerInfo;
    }

    private void updateHeaderInfo(HeaderInfo headerInfo) {
        if (headerInfo == null) {
            return;
        }
        if (TextUtils.isEmpty(headerInfo.getDeviceId())) {
            headerInfo.setDeviceId(ApmContext.getDeviceId());
        }
        ApmContextAdapter apmContextAdapter = ApmContext.getApmContextAdapter();
        if (apmContextAdapter != null) {
            headerInfo.setDynamicExtra(apmContextAdapter.getDynamicHeaderExtras());
        }
        long j = this.nptTime;
        if (j != -1) {
            headerInfo.setNtpTime(j);
            headerInfo.setNtpOffset(this.nptOffset);
        } else {
            final INtpTimeService ntpTimeService = ApmContext.getNtpTimeService();
            if (ntpTimeService != null && this.ntpAsyncTask == null) {
                synchronized (HeaderManager.class) {
                    this.ntpAsyncTask = new AsyncTask() { // from class: com.bytedance.apm6.consumer.slardar.header.HeaderManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            long ntpTime = ntpTimeService.getNtpTime();
                            if (ntpTime != -1) {
                                HeaderManager.this.nptTime = ntpTime;
                                HeaderManager.this.nptOffset = System.currentTimeMillis() - ntpTime;
                            }
                            synchronized (HeaderManager.class) {
                                AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(HeaderManager.this.ntpAsyncTask);
                                HeaderManager.this.ntpAsyncTask = null;
                            }
                        }
                    };
                    AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.ntpAsyncTask);
                }
            }
        }
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "nptTime:" + this.nptTime + " nptOffset:" + this.nptOffset);
        }
        headerInfo.setUid(ApmContext.getUserID());
        headerInfo.setConfigTime(ApmContext.getConfigTime());
        HeaderInfo headerInfo2 = this.currentHeaderInfo;
        if (headerInfo2 != null) {
            headerInfo.setCurrentUpdateVersionCode(headerInfo2.getUpdateVersionCode());
        }
    }

    private void saveHeaderInfo(HeaderInfo headerInfo) {
        String valueOf = String.valueOf(HeaderUtils.getUniqueHeaderId());
        this.headers.put(valueOf, headerInfo);
        this.currentHeaderInfo = headerInfo;
        HeaderStoreManager.getInstance().saveHeaderInfo(valueOf, headerInfo);
    }
}
