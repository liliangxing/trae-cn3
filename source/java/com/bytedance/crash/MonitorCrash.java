package com.bytedance.crash;

import android.content.Context;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.monitor.SdkMonitor;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MonitorCrash {

    @Deprecated
    private final Config mConfig = new Config(this);
    private final CrashListener mCrashListener;

    private MonitorCrash(CrashListener crashListener) {
        this.mCrashListener = crashListener;
    }

    public static MonitorCrash initApp(Context context, String str, long j, String str2) {
        return new MonitorCrash(MonitorManager.createAppMonitor(context, str, str2, j));
    }

    @Deprecated
    public static MonitorCrash init(Context context, String str, long j, String str2) {
        return initApp(context, str, j, str2);
    }

    public static MonitorCrash initSDK(Context context, String str, long j, String str2, String str3, String[] strArr) {
        return new MonitorCrash(MonitorManager.createSdkMonitor(context, str, str2, j, new String[]{str3}, strArr));
    }

    public static MonitorCrash initSDK(Context context, String str, long j, String str2, String str3) {
        return initSDK(context, str, j, str2, str3, null);
    }

    public void setChannel(String str) {
        this.mCrashListener.setChannel(str);
    }

    public void setDeviceId(String str) {
        this.mCrashListener.setDeviceId(str);
    }

    public void setUserId(long j) {
        this.mCrashListener.setUserId(j);
    }

    public void setSoList(String[] strArr) {
        CrashListener crashListener = this.mCrashListener;
        if (crashListener instanceof SdkMonitor) {
            ((SdkMonitor) crashListener).setSoList(strArr);
        }
    }

    public void setPackageName(String str) {
        CrashListener crashListener = this.mCrashListener;
        if (crashListener instanceof SdkMonitor) {
            ((SdkMonitor) crashListener).setPackageName(new String[]{str});
        }
    }

    public UserDataCenter getUserDataCenter() {
        return this.mCrashListener.getUserDataCenter();
    }

    public void reportCustomErr(String str, Throwable th) {
        this.mCrashListener.reportEnsure(str, th);
    }

    @Deprecated
    public void reportCustomErr(String str, String str2, Throwable th) {
        this.mCrashListener.reportEnsure(str, th);
    }

    public void reportEvent(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        this.mCrashListener.reportEvent(str, i, jSONObject, jSONObject2);
    }

    @Deprecated
    public Config config() {
        return this.mConfig;
    }

    @Deprecated
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class Config {
        private final MonitorCrash mMonitorCrash;

        Config(MonitorCrash monitorCrash) {
            this.mMonitorCrash = monitorCrash;
        }

        public Config setSoList(String[] strArr) {
            this.mMonitorCrash.setSoList(strArr);
            return this;
        }

        public Config setChannel(String str) {
            this.mMonitorCrash.setChannel(str);
            return this;
        }

        public Config setPackageName(String str) {
            this.mMonitorCrash.setPackageName(str);
            return this;
        }

        public Config setDeviceId(String str) {
            this.mMonitorCrash.setDeviceId(str);
            return this;
        }

        public Config setUID(long j) {
            this.mMonitorCrash.setUserId(j);
            return this;
        }
    }
}
