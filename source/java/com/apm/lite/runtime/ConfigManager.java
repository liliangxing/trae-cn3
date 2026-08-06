package com.apm.lite.runtime;

import android.content.Context;
import android.text.TextUtils;
import com.apm.lite.C0749e;
import com.apm.lite.ICommonParams;
import com.apm.lite.p021i.C0763b;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0787j;
import com.apm.lite.p023k.C0793p;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class ConfigManager {
    private static final String ALOG_UPLOAD_URL = "https://apmplus.volces.com/monitor/collect/c/cloudcontrol/file";
    public static final String ALOG_URL_SUFFIX = "/monitor/collect/c/cloudcontrol/file";
    public static final long BLOCK_MONITOR_INTERVAL = 1000;
    private static final long BLOCK_MONITOR_MIN_INTERVAL = 10;
    private static final String CONFIG_URL = "https://apmplus.volces.com/settings/get";
    public static final String CONFIG_URL_SUFFIX = "/settings/get";
    private static final String EXCEPTION_URL = "https://apmplus.volces.com/monitor/collect/c/exception";
    public static final String EXCEPTION_URL_SUFFIX = "/monitor/collect/c/exception";
    private static final String FILE_UPLOAD_URL = "https://apmplus.volces.com/monitor/collect/c/logcollect";
    public static final String FILE_UPLOAD_URL_SUFFIX = "/monitor/collect/c/logcollect";
    private static final String JAVA_CRASH_URL = "https://apmplus.volces.com/monitor/collect/c/crash";
    public static final String JAVA_URL_SUFFIX = "/monitor/collect/c/crash";
    private static final long LAUNCH_CRASH_INTERVAL = 8000;
    private static final String LAUNCH_CRASH_URL = "https://apmplus.volces.com/monitor/collect/c/exception/dump_collection";
    public static final String LAUNCH_URL_SUFFIX = "/monitor/collect/c/exception/dump_collection";
    private static final String NATIVE_CRASH_URL = "https://apmplus.volces.com/monitor/collect/c/native_bin_crash";
    public static final String NATIVE_URL_SUFFIX = "/monitor/collect/c/native_bin_crash";
    private static final String PAGEVIEW_URL = "https://apmplus.volces.com/monitor/collect/c/session";
    public static final String PAGEVIEW_URL_SUFFIX = "/monitor/collect/c/session";
    private ThreadPoolExecutor mThreadPoolExecutor;
    private boolean reportErrorEnable = true;
    private String mJavaCrashUploadUrl = JAVA_CRASH_URL;
    private String mLaunchCrashUploadUrl = LAUNCH_CRASH_URL;
    private String mExceptionUploadUrl = EXCEPTION_URL;
    private String mPageViewUrl = PAGEVIEW_URL;
    private String mConfigUrl = CONFIG_URL;
    private String mNativeCrashUploadUrl = NATIVE_CRASH_URL;
    private String mAlogUploadUrl = ALOG_UPLOAD_URL;
    private String mFileUploadUrl = FILE_UPLOAD_URL;
    private long mLaunchCrashInterval = LAUNCH_CRASH_INTERVAL;
    private int mLogcatDumpCount = 512;
    private int mLogcatLevel = 1;
    private boolean mNativeCrashMiniDump = true;
    private boolean mEnsureEnable = true;
    private boolean mIsDebugMode = false;
    private boolean mRegisterJavaCrash = false;
    private boolean mJavaCrashEnable = true;
    private boolean mNativeCrashEnable = true;
    private boolean mANREnable = true;
    private boolean mSigQuitEnable = true;

    public static void setDefaultCommonParams(ICommonParams iCommonParams, Context context) {
        C0749e.m556a(new C0823d(context, iCommonParams));
    }

    public static void updateDid(final String str) {
        C0832m.m1190b().m1238a(new Runnable() { // from class: com.apm.lite.runtime.ConfigManager.1
            @Override // java.lang.Runnable
            public void run() {
                C0749e.m560c().m1227a(str);
                C0763b.m645d();
            }
        });
    }

    public String getAlogUploadUrl() {
        return this.mAlogUploadUrl;
    }

    public String getConfigUrl() {
        return this.mConfigUrl;
    }

    public String getExceptionUploadUrl() {
        return this.mExceptionUploadUrl;
    }

    public String getFileUploadUrl() {
        return this.mFileUploadUrl;
    }

    public Set<String> getFilterThreadSet() {
        return C0787j.m812a();
    }

    public String getJavaCrashUploadUrl() {
        return this.mJavaCrashUploadUrl;
    }

    public long getLaunchCrashInterval() {
        return this.mLaunchCrashInterval;
    }

    public String getLaunchCrashUploadUrl() {
        return this.mLaunchCrashUploadUrl;
    }

    public int getLogcatDumpCount() {
        return this.mLogcatDumpCount;
    }

    public int getLogcatLevel() {
        return this.mLogcatLevel;
    }

    public String getNativeCrashUploadUrl() {
        return this.mNativeCrashUploadUrl;
    }

    public String getPageViewUrl() {
        return this.mPageViewUrl;
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return this.mThreadPoolExecutor;
    }

    public boolean isAnrEnable() {
        return this.mANREnable;
    }

    public boolean isCrashIgnored(final String str) {
        try {
            C0825f c0825f = new C0825f() { // from class: com.apm.lite.runtime.ConfigManager.2
                @Override // com.apm.lite.runtime.C0825f
                /* renamed from: a */
                public Object mo1013a(String str2) {
                    return str2.equals("md5") ? str : super.mo1013a(str2);
                }
            };
            if (C0830k.m1153a("java_crash_ignore", c0825f)) {
                return true;
            }
            if (C0793p.m885b(C0749e.m565g())) {
                return C0830k.m1153a("java_crash_ignore", c0825f);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isDebugMode() {
        return this.mIsDebugMode;
    }

    public boolean isEnsureEnable() {
        return this.mEnsureEnable;
    }

    public boolean isJavaCrashEnable() {
        return this.mJavaCrashEnable;
    }

    public boolean isNativeCrashEnable() {
        return this.mNativeCrashEnable;
    }

    public boolean isNativeCrashMiniDump() {
        return this.mNativeCrashMiniDump;
    }

    public boolean isRegisterJavaCrashEnable() {
        return this.mRegisterJavaCrash;
    }

    public boolean isReportErrorEnable() {
        return this.reportErrorEnable;
    }

    public boolean isSigQuitEnable() {
        return this.mSigQuitEnable;
    }

    public void setAlogUploadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mAlogUploadUrl = str;
    }

    public void setAnrEnable(boolean z) {
        this.mANREnable = z;
    }

    public void setConfigUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mConfigUrl = str;
    }

    public void setCurrentProcessName(String str) {
        C0778a.m740a(str);
    }

    public void setDebugMode(boolean z) {
        this.mIsDebugMode = z;
    }

    public void setEnsureEnable(boolean z) {
        this.mEnsureEnable = z;
    }

    public void setFileUploadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mFileUploadUrl = str;
    }

    public void setJavaCrashEnable(boolean z) {
        this.mJavaCrashEnable = z;
    }

    public void setJavaCrashUploadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mJavaCrashUploadUrl = str;
    }

    public void setLaunchCrashUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mExceptionUploadUrl = str;
        int indexOf = str.indexOf("//");
        this.mLaunchCrashUploadUrl = (indexOf == -1 ? new StringBuilder().append(str.substring(0, str.indexOf("/") + 1)) : new StringBuilder().append(str.substring(0, str.indexOf("/", indexOf + 2) + 1))).append("monitor/collect/c/exception/dump_collection").toString();
    }

    public void setLogcatDumpCount(int i) {
        if (i > 0) {
            this.mLogcatDumpCount = i;
        }
    }

    public void setLogcatLevel(int i) {
        if (i < 0 || i > 4) {
            return;
        }
        this.mLogcatLevel = i;
    }

    public void setNativeCrashEnable(boolean z) {
        this.mNativeCrashEnable = z;
    }

    public void setNativeCrashUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mNativeCrashUploadUrl = str;
    }

    public void setPageViewUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mPageViewUrl = str;
    }

    public void setRegisterJavaCrashEnable(boolean z) {
        this.mRegisterJavaCrash = z;
    }

    public void setReportErrorEnable(boolean z) {
        this.reportErrorEnable = z;
    }

    public void setSigQuitEnable(boolean z) {
        this.mSigQuitEnable = z;
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.mThreadPoolExecutor = threadPoolExecutor;
    }
}
