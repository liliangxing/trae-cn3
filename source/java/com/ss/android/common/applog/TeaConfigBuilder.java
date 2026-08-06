package com.ss.android.common.applog;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.applog.BDInstallInitHook;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.ss.android.common.AppContext;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.LogTrace;
import com.ss.android.common.applog.task.TaskCallback;
import com.ss.android.deviceregister.MacAddressApiCallback;
import com.ss.android.deviceregister.PreInstallChannelCallback;
import com.ss.android.deviceregister.SensitiveApiCallback;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TeaConfigBuilder {
    private boolean anonymous;
    private AppContext appContext;
    IAppTraitCallback appTraitCallback;
    private boolean autoActiveUser;
    BDInstallInitHook bDInstallInitHook;
    private boolean childMode;
    private Context context;
    private Bundle customerHeader;
    private AppLog.ILogEncryptConfig encryptConfig;
    private GlobalConfig globalConfig;
    boolean isOpenBpea;
    boolean isTouristMode;
    private boolean mActiveOnce;
    private LogTrace.LogRequestTraceCallback mLogTraceCallback;
    MacAddressApiCallback mMacAddressApiCallback;
    private PreInstallChannelCallback mPreInstallChannelCallback;
    SensitiveApiCallback mSensitiveApiCallback;
    private String releaseBuild;
    private TeaStorageConfig storageConfig;
    private TaskCallback taskCallback;
    private UrlConfig urlConfig;
    private boolean needAntiCheating = false;
    int retryCount = -1;
    boolean enableListenNetChange = true;

    private TeaConfigBuilder() {
    }

    public static TeaConfigBuilder create(Context context, boolean z, UrlConfig urlConfig, AppContext appContext) {
        TeaConfigBuilder teaConfigBuilder = new TeaConfigBuilder();
        teaConfigBuilder.context = context;
        teaConfigBuilder.urlConfig = urlConfig;
        teaConfigBuilder.autoActiveUser = z;
        teaConfigBuilder.appContext = appContext;
        return teaConfigBuilder;
    }

    public TeaConfigBuilder setLogRequestTraceCallback(LogTrace.LogRequestTraceCallback logRequestTraceCallback) {
        this.mLogTraceCallback = logRequestTraceCallback;
        return this;
    }

    public TeaConfigBuilder setStorageConfig(TeaStorageConfig teaStorageConfig) {
        this.storageConfig = teaStorageConfig;
        return this;
    }

    public TeaConfigBuilder setRetryCount(int i) {
        this.retryCount = i;
        return this;
    }

    public TeaConfigBuilder setReleaseBuild(String str) {
        this.releaseBuild = str;
        return this;
    }

    public TeaConfigBuilder setCustomerHeader(Bundle bundle) {
        this.customerHeader = bundle;
        return this;
    }

    public TeaConfigBuilder setAppTraitCallback(IAppTraitCallback iAppTraitCallback) {
        this.appTraitCallback = iAppTraitCallback;
        return this;
    }

    public TeaConfigBuilder setEncryptConfig(AppLog.ILogEncryptConfig iLogEncryptConfig) {
        this.encryptConfig = iLogEncryptConfig;
        return this;
    }

    public TeaConfigBuilder setNeedAntiCheating(boolean z) {
        this.needAntiCheating = z;
        return this;
    }

    public TeaConfigBuilder setTaskCallback(TaskCallback taskCallback) {
        this.taskCallback = taskCallback;
        return this;
    }

    public TeaConfigBuilder setGlobalConfig(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
        return this;
    }

    public TeaConfigBuilder setChildMode(boolean z) {
        this.childMode = z;
        return this;
    }

    public TeaConfigBuilder setTouristMode(boolean z) {
        this.isTouristMode = z;
        return this;
    }

    public TeaConfigBuilder setPreInstallChannelCallback(PreInstallChannelCallback preInstallChannelCallback) {
        this.mPreInstallChannelCallback = preInstallChannelCallback;
        return this;
    }

    public TeaConfigBuilder setSensitiveApiCallback(SensitiveApiCallback sensitiveApiCallback) {
        this.mSensitiveApiCallback = sensitiveApiCallback;
        return this;
    }

    public TeaConfigBuilder setMacAddressApiCallback(MacAddressApiCallback macAddressApiCallback) {
        this.mMacAddressApiCallback = macAddressApiCallback;
        return this;
    }

    public TeaConfigBuilder setActiveOnce(boolean z) {
        this.mActiveOnce = z;
        return this;
    }

    public TeaConfig build() {
        TeaUtils.ensureNonNull(this.context, "context");
        TeaUtils.ensureNonNull(this.urlConfig, "urlConfig");
        TeaUtils.ensureNonNull(this.appContext, "appContext");
        return new TeaConfig(this.appContext, this.storageConfig, this.releaseBuild, this.customerHeader, this.encryptConfig, this.needAntiCheating, this.context, this.autoActiveUser, this.urlConfig, this.globalConfig, this.mLogTraceCallback, this.taskCallback, this.anonymous, this.mPreInstallChannelCallback, this.childMode, this.mActiveOnce, this);
    }

    public TeaConfigBuilder setAnonymous(boolean z) {
        this.anonymous = z;
        return this;
    }

    public TeaConfigBuilder setBDInstallInitHook(BDInstallInitHook bDInstallInitHook) {
        this.bDInstallInitHook = bDInstallInitHook;
        return this;
    }

    public TeaConfigBuilder setOpeaBpea(boolean z) {
        this.isOpenBpea = z;
        return this;
    }

    public TeaConfigBuilder setEnableListenNetChange(boolean z) {
        this.enableListenNetChange = z;
        return this;
    }
}
