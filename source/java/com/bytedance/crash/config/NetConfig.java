package com.bytedance.crash.config;

import android.text.TextUtils;
import com.bytedance.crash.runtime.AllDefaultUrls;

/* loaded from: classes3.dex */
public class NetConfig {
    static final String BIZ_EXCEPTION_URL = "/monitor/collect/c/biz_exception";
    static final String FILE_UPLOAD_URL = "/monitor/collect/c/logcollect";
    static final String PATH_ALOG_UPLOAD = "/monitor/collect/c/logcollect";
    static final String PATH_APM_CONFIG = "/monitor/appmonitor/v3/settings";
    static final String PATH_CORE_DUMP = "/monitor/collect/c/core_dump_collect";
    static final String PATH_EVENT = "/monitor/collect/batch/";
    public static final String PATH_EXCEPTION = "/monitor/collect/c/exception";
    public static final String PATH_JAVA_CRASH = "/monitor/collect/c/crash";
    static final String PATH_LAUNCH_CRASH = "/monitor/collect/c/exception/dump_collection";
    public static final String PATH_NATIVE_CRASH = "/monitor/collect/c/native_bin_crash";
    static final String PATH_NATIVE_EXCEPTION = "/monitor/collect/c/exception/dump_collection";
    static final String PATH_NATIVE_MEM = "/monitor/collect/c/rapheal_file_collect";
    static final String PATH_UPLOAD_CHECK_COREDUMP = "/monitor/collect/c/core_dump_upload_check";
    static final String QUOTA_STATUS_URL = "/monitor/collect/quota_status";
    private static final NetConfig sInstance = new NetConfig();
    private String mAlogUploadUrl;
    private String mApmConfigUrl;
    private String mBizExceptionUploadUrl;
    private String mCoreDumpUrl;
    private String mDomain = AllDefaultUrls.getDomainName();
    private String mEventUploadUrl;
    private String mExceptionUploadUrl;
    private String mExceptionZipUploadUrl;
    private String mJavaCrashUploadUrl;
    private String mLaunchCrashUploadUrl;
    private String mNativeCrashUploadUrl;
    private String mNativeMemUrl;
    private String mQuotaStatusURL;
    private String mUploadCheckCoreDumpUrl;
    private String mUploadFileURL;

    public static NetConfig get() {
        return sInstance;
    }

    private NetConfig() {
        updateURL();
    }

    public void setCustomDomain(String str) {
        this.mDomain = str;
        updateURL();
    }

    private void updateURL() {
        this.mNativeMemUrl = this.mDomain + PATH_NATIVE_MEM;
        this.mCoreDumpUrl = this.mDomain + PATH_CORE_DUMP;
        this.mUploadCheckCoreDumpUrl = this.mDomain + PATH_UPLOAD_CHECK_COREDUMP;
        this.mJavaCrashUploadUrl = this.mDomain + "/monitor/collect/c/crash";
        this.mLaunchCrashUploadUrl = this.mDomain + com.apm.lite.runtime.ConfigManager.LAUNCH_URL_SUFFIX;
        this.mExceptionUploadUrl = this.mDomain + "/monitor/collect/c/exception";
        this.mExceptionZipUploadUrl = this.mDomain + com.apm.lite.runtime.ConfigManager.LAUNCH_URL_SUFFIX;
        this.mEventUploadUrl = this.mDomain + "/monitor/collect/batch/";
        this.mNativeCrashUploadUrl = this.mDomain + "/monitor/collect/c/native_bin_crash";
        this.mAlogUploadUrl = this.mDomain + "/monitor/collect/c/logcollect";
        this.mApmConfigUrl = this.mDomain + PATH_APM_CONFIG;
        this.mQuotaStatusURL = this.mDomain + QUOTA_STATUS_URL;
        this.mUploadFileURL = this.mDomain + "/monitor/collect/c/logcollect";
        this.mBizExceptionUploadUrl = this.mDomain + BIZ_EXCEPTION_URL;
    }

    public void setLaunchCrashUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mExceptionUploadUrl = str;
        int indexOf = str.indexOf("//");
        if (indexOf == -1) {
            this.mLaunchCrashUploadUrl = str.substring(0, str.indexOf("/") + 1) + "monitor/collect/c/exception/dump_collection";
            this.mExceptionZipUploadUrl = str.substring(0, str.indexOf("/") + 1) + "monitor/collect/c/custom_exception/zip";
        } else {
            int i = indexOf + 2;
            this.mLaunchCrashUploadUrl = str.substring(0, str.indexOf("/", i) + 1) + "monitor/collect/c/exception/dump_collection";
            this.mExceptionZipUploadUrl = str.substring(0, str.indexOf("/", i) + 1) + "monitor/collect/c/custom_exception/zip";
        }
    }

    public void setNativeCrashUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mNativeCrashUploadUrl = str;
    }

    public void setAlogUploadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mAlogUploadUrl = str;
    }

    public void setJavaCrashUploadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mJavaCrashUploadUrl = str;
    }

    public void setConfigGetUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mApmConfigUrl = str;
    }

    public static String getQuotaStateUrl() {
        return sInstance.mQuotaStatusURL;
    }

    public static String getApmConfigUrl() {
        return sInstance.mApmConfigUrl;
    }

    public static String getNativeCrashUploadUrl() {
        return sInstance.mNativeCrashUploadUrl;
    }

    public static String getLaunchCrashUploadUrl() {
        return sInstance.mLaunchCrashUploadUrl;
    }

    public static String getExceptionUploadUrl() {
        return sInstance.mExceptionUploadUrl;
    }

    public static String getBizExceptionUploadUrl() {
        return sInstance.mBizExceptionUploadUrl;
    }

    public static String getExceptionZipUploadUrl() {
        return sInstance.mExceptionZipUploadUrl;
    }

    public static String getEventUploadUrl() {
        return sInstance.mEventUploadUrl;
    }

    public static String getJavaCrashUploadUrl() {
        return sInstance.mJavaCrashUploadUrl;
    }

    public static String getNativeMemUrl() {
        return sInstance.mNativeMemUrl;
    }

    public static String getCoreDumpUrl() {
        return sInstance.mCoreDumpUrl;
    }

    public static String getUploadCheckCoreDumpUrl() {
        return sInstance.mUploadCheckCoreDumpUrl;
    }

    public static String getAsanReportUploadUrl() {
        return getNativeCrashUploadUrl();
    }

    public static String getAlogUploadUrl() {
        return sInstance.mAlogUploadUrl;
    }

    public static String getUploadFileUrl() {
        return sInstance.mUploadFileURL;
    }
}
