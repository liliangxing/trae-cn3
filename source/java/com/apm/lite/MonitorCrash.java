package com.apm.lite;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.apm.lite.p016d.C0746b;
import com.apm.lite.p021i.C0763b;
import com.apm.lite.p022j.C0775j;
import com.apm.lite.p023k.C0794q;
import com.apm.lite.runtime.C0824e;
import com.apm.lite.runtime.C0831l;
import com.apm.lite.runtime.C0832m;
import com.apm.lite.runtime.ConfigManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class MonitorCrash {
    private static final String TAG = "MonitorCrash";
    C0731b mAppLog;
    Config mConfig;
    AttachUserData mCustomData;
    HashMap<String, String> mTagMap = new HashMap<>();
    HashMap<String, String> mPageViewTagMap = new HashMap<>();
    private volatile boolean isAppLogInit = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class Config {

        /* renamed from: a */
        String f324a;

        /* renamed from: b */
        String f325b;

        /* renamed from: c */
        String f326c;

        /* renamed from: d */
        long f327d;

        /* renamed from: e */
        String f328e;

        /* renamed from: f */
        String[] f329f;

        /* renamed from: g */
        String[] f330g;

        /* renamed from: h */
        AttachUserData f331h;

        /* renamed from: i */
        C0731b f332i;

        /* renamed from: j */
        boolean f333j;

        /* renamed from: k */
        String f334k;

        /* renamed from: l */
        Map<String, String> f335l;

        /* renamed from: m */
        private String f336m;

        /* renamed from: n */
        private IDynamicParams f337n;

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
        public interface IDynamicParams {
            String getDid();

            String getUserId();
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
        public static class SdkBuilder {

            /* renamed from: a */
            private Config f338a;

            private SdkBuilder(String str) {
                Config config = new Config();
                this.f338a = config;
                config.f324a = str;
            }

            public SdkBuilder acceptWithActivity(boolean z) {
                this.f338a.f333j = z;
                return this;
            }

            public Config build() {
                return this.f338a;
            }

            public SdkBuilder channel(String str) {
                this.f338a.f326c = str;
                return this;
            }

            public SdkBuilder debugMode(boolean z) {
                Npth.getConfigManager().setDebugMode(z);
                return this;
            }

            public SdkBuilder dynamicParams(IDynamicParams iDynamicParams) {
                this.f338a.f337n = iDynamicParams;
                return this;
            }

            public SdkBuilder enableAnrMonitor(boolean z) {
                Npth.getConfigManager().setAnrEnable(z);
                return this;
            }

            public SdkBuilder enableJavaCrash(boolean z) {
                Npth.getConfigManager().setJavaCrashEnable(z);
                return this;
            }

            public SdkBuilder enableNativeCrash(boolean z) {
                Npth.getConfigManager().setNativeCrashEnable(z);
                return this;
            }

            public SdkBuilder enableSigQuit(boolean z) {
                Npth.getConfigManager().setSigQuitEnable(z);
                return this;
            }

            public SdkBuilder keyWords(String... strArr) {
                this.f338a.f329f = strArr;
                return this;
            }

            public SdkBuilder pageViewTags(Map<String, String> map) {
                this.f338a.f335l = map;
                return this;
            }

            public SdkBuilder soList(String... strArr) {
                this.f338a.f330g = strArr;
                return this;
            }

            public SdkBuilder token(String str) {
                this.f338a.f325b = str;
                return this;
            }

            public SdkBuilder url(String str) {
                this.f338a.f334k = str;
                return this;
            }

            public SdkBuilder versionCode(long j) {
                this.f338a.f327d = j;
                return this;
            }

            public SdkBuilder versionName(String str) {
                this.f338a.f328e = str;
                return this;
            }
        }

        private Config() {
            this.f327d = -1L;
            this.f333j = false;
            this.f335l = null;
        }

        public static SdkBuilder sdk(String str) {
            return new SdkBuilder(str);
        }

        public String getDeviceId() {
            IDynamicParams iDynamicParams = this.f337n;
            return iDynamicParams == null ? this.f336m : iDynamicParams.getDid();
        }

        public String getUID() {
            IDynamicParams iDynamicParams = this.f337n;
            return iDynamicParams == null ? "" : iDynamicParams.getUserId();
        }

        public Config setChannel(String str) {
            this.f326c = str;
            C0731b c0731b = this.f332i;
            if (c0731b != null) {
                c0731b.m388b(str);
            }
            C0763b.m645d();
            return this;
        }

        @Deprecated
        public Config setDeviceId(String str) {
            return setDeviceId(str, true);
        }

        @Deprecated
        public Config setDeviceId(String str, boolean z) {
            this.f336m = str;
            C0731b c0731b = this.f332i;
            if (c0731b != null) {
                c0731b.m386a(str);
            }
            if (z) {
                C0763b.m645d();
            }
            return this;
        }

        public Config setPackageName(String str) {
            return setPackageName(str);
        }

        public Config setPackageName(String... strArr) {
            this.f329f = strArr;
            C0763b.m645d();
            return this;
        }

        public Config setSoList(String[] strArr) {
            this.f330g = strArr;
            C0763b.m645d();
            return this;
        }
    }

    private MonitorCrash(Config config) {
        this.mConfig = config;
        this.mCustomData = config.f331h;
    }

    private void initAppLog(Context context, boolean z) {
        initAppLogAsync(context, z);
    }

    private void initAppLogAsync(final Context context, final boolean z) {
        C0832m.m1190b().m1239a(new Runnable() { // from class: com.apm.lite.MonitorCrash.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap;
                if (MonitorCrash.this.isAppLogInit) {
                    return;
                }
                if (!C0775j.m726b()) {
                    C0775j.m727c();
                }
                if (C0824e.m1135g(MonitorCrash.this.mConfig.f324a)) {
                    MonitorCrash.this.isAppLogInit = true;
                    if (MonitorCrash.this.mAppLog == null) {
                        MonitorCrash.this.mAppLog = new C0731b();
                    }
                    if (z) {
                        hashMap = null;
                    } else {
                        String m501a = C0746b.m501a(C0744d.m450a());
                        hashMap = new HashMap();
                        hashMap.put("host_app_id", m501a);
                        hashMap.put("sdk_version", MonitorCrash.this.mConfig.f328e);
                    }
                    MonitorCrash.this.mAppLog.m385a(context, MonitorCrash.this.mConfig, hashMap);
                    MonitorCrash.this.mConfig.f332i = MonitorCrash.this.mAppLog;
                }
            }
        }, 5L);
    }

    public static synchronized MonitorCrash initSDK(Context context, Config config) {
        synchronized (MonitorCrash.class) {
            if (TextUtils.isEmpty(config.f325b)) {
                Log.e(TAG, config.f324a + " MonitorCrash init without token.");
            }
            MonitorCrash m449a = C0744d.m449a(config.f324a);
            if (m449a != null) {
                Log.e(TAG, "Duplicate init MonitorCrash with same aid.");
                return m449a;
            }
            MonitorCrash monitorCrash = new MonitorCrash(config);
            if (!TextUtils.isEmpty(config.f334k)) {
                monitorCrash.setReportUrl(config.f334k);
            }
            if (config.f335l != null) {
                monitorCrash.mPageViewTagMap.putAll(config.f335l);
                monitorCrash.mTagMap.putAll(monitorCrash.mPageViewTagMap);
            }
            C0831l.m1161a(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable(), 0L);
            monitorCrash.initAppLog(context, false);
            C0744d.m452a(monitorCrash);
            return monitorCrash;
        }
    }

    public static void reInitAppLog(String str) {
    }

    private MonitorCrash setReportUrl(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        int indexOf = str.indexOf("://");
        if (indexOf < 0) {
            str = "https://" + str;
            i = 8;
        } else {
            i = indexOf + 3;
        }
        int indexOf2 = str.indexOf("/", i);
        if (indexOf2 >= 0) {
            str = str.substring(0, indexOf2);
        }
        C0794q.m887a((Object) ("set url " + str));
        C0749e.m567i().setLaunchCrashUrl(str + "/monitor/collect/c/exception");
        C0749e.m567i().setJavaCrashUploadUrl(str + ConfigManager.JAVA_URL_SUFFIX);
        C0749e.m567i().setNativeCrashUrl(str + ConfigManager.NATIVE_URL_SUFFIX);
        C0749e.m567i().setConfigUrl(str + ConfigManager.CONFIG_URL_SUFFIX);
        C0749e.m567i().setAlogUploadUrl(str + ConfigManager.ALOG_URL_SUFFIX);
        C0749e.m567i().setFileUploadUrl(str + ConfigManager.FILE_UPLOAD_URL_SUFFIX);
        C0749e.m567i().setPageViewUrl(str + ConfigManager.PAGEVIEW_URL_SUFFIX);
        return this;
    }

    public MonitorCrash addPageViewTags(String str, String str2) {
        this.mPageViewTagMap.put(str, str2);
        this.mTagMap.put(str, str2);
        return this;
    }

    public MonitorCrash addTags(String str, String str2) {
        this.mTagMap.put(str, str2);
        return this;
    }

    public Config config() {
        return this.mConfig;
    }

    public void registerCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        C0831l.m1162a(iCrashCallback, crashType);
    }

    public void registerOOMCallback(IOOMCallback iOOMCallback) {
        C0831l.m1163a(iOOMCallback);
    }

    public void reportPageView(final IUploadCallback iUploadCallback) {
        C0832m.m1190b().m1239a(new Runnable() { // from class: com.apm.lite.MonitorCrash.2
            @Override // java.lang.Runnable
            public void run() {
                if (MonitorCrash.this.mAppLog != null) {
                    MonitorCrash.this.mAppLog.m387a(MonitorCrash.this.mPageViewTagMap, iUploadCallback);
                    return;
                }
                IUploadCallback iUploadCallback2 = iUploadCallback;
                if (iUploadCallback2 != null) {
                    iUploadCallback2.afterUpload(false);
                }
            }
        }, 10L);
    }

    public void unregisterCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        C0831l.m1167b(iCrashCallback, crashType);
    }

    public void unregisterOOMCallback(IOOMCallback iOOMCallback, CrashType crashType) {
        C0831l.m1164a(iOOMCallback, crashType);
    }
}
