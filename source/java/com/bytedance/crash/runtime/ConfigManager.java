package com.bytedance.crash.runtime;

import com.bytedance.crash.IEncrypt;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.App;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ConfigManager {
    private boolean mEnsureEnable = true;

    public void setLaunchCrashUrl(String str) {
        NetConfig.get().setLaunchCrashUrl(str);
    }

    public void setNativeCrashUrl(String str) {
        NetConfig.get().setNativeCrashUrl(str);
    }

    public void setDefaultAnrCheckInterval(long j) {
        RuntimeConfig.setAnrCheckInterval(j);
    }

    public long getDefaultAnrCheckInterval() {
        return RuntimeConfig.getAnrCheckInterval();
    }

    public void setAlogUploadUrl(String str) {
        NetConfig.get().setAlogUploadUrl(str);
    }

    public void setConfigGetUrl(String str) {
        NetConfig.get().setConfigGetUrl(str);
    }

    public boolean isReportErrorEnable() {
        return RuntimeConfig.isReportErrorEnable();
    }

    public void setReportErrorEnable(boolean z) {
        RuntimeConfig.setReportErrorEnable(z);
    }

    public void setJavaCrashUploadUrl(String str) {
        NetConfig.get().setJavaCrashUploadUrl(str);
    }

    public void setLaunchCrashInterval(long j) {
        RuntimeConfig.setLaunchCrashInterval(j);
    }

    public void setEnsureEnable(boolean z) {
        RuntimeConfig.setEnsureEnable(z);
    }

    public void setCurrentProcessName(String str) {
        App.setCurProcessName(str);
    }

    public void setEncryptImpl(IEncrypt iEncrypt) {
        if (iEncrypt != null) {
            RuntimeConfig.setEncryptImpl(iEncrypt);
        }
    }

    public boolean isDebugMode() {
        return RuntimeConfig.isDebugMode();
    }

    public void setDebugMode(boolean z) {
        RuntimeConfig.setDebugMode(z);
    }

    public boolean isEnsureEnable() {
        AppMonitor appMonitor;
        if (RuntimeConfig.isEnsureEnable() && (appMonitor = MonitorManager.getAppMonitor()) != null) {
            return appMonitor.getEnsureDeliver().isEnsureEnable();
        }
        return false;
    }

    public String getAlogUploadUrl() {
        NetConfig.get();
        return NetConfig.getAlogUploadUrl();
    }

    public String getNativeCrashUploadUrl() {
        return NetConfig.getNativeCrashUploadUrl();
    }
}
