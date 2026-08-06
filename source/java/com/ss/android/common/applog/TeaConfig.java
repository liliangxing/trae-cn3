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
public class TeaConfig {
    private final boolean activeOnce;
    private final boolean anonymous;
    private AppContext appContext;
    private final IAppTraitCallback appTraitCallback;
    private boolean autoActiveUser;
    private final boolean childMode;
    private Context context;
    private Bundle customerHeader;
    private boolean enableListenNetChange;
    private AppLog.ILogEncryptConfig encryptConfig;
    private GlobalConfig globalConfig;
    private final boolean isOpenBpea;
    private boolean isTouristMode;
    private final BDInstallInitHook mBDInstallInitHook;
    private LogTrace.LogRequestTraceCallback mLogRequestTraceCallback;
    private final MacAddressApiCallback macAddressApiCallback;
    private boolean needAntiCheating;
    private final PreInstallChannelCallback preInstallChannelCallback;
    private String releaseBuild;
    private int retryCount;
    private final SensitiveApiCallback sensitiveApiCallback;
    private TeaStorageConfig storageConfig;
    private final TaskCallback taskCallback;
    private UrlConfig urlConfig;

    public LogTrace.LogRequestTraceCallback getLogRequestTraceCallback() {
        return this.mLogRequestTraceCallback;
    }

    public AppContext getAppContext() {
        return this.appContext;
    }

    public TeaStorageConfig getStorageConfig() {
        return this.storageConfig;
    }

    public String getReleaseBuild() {
        return this.releaseBuild;
    }

    public Bundle getCustomerHeader() {
        return this.customerHeader;
    }

    public AppLog.ILogEncryptConfig getEncryptConfig() {
        return this.encryptConfig;
    }

    public boolean isNeedAntiCheating() {
        return this.needAntiCheating;
    }

    public Context getContext() {
        return this.context;
    }

    public boolean isAutoActiveUser() {
        return this.autoActiveUser;
    }

    public UrlConfig getUrlConfig() {
        return this.urlConfig;
    }

    public TaskCallback getTaskCallback() {
        return this.taskCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TeaConfig(AppContext appContext, TeaStorageConfig teaStorageConfig, String str, Bundle bundle, AppLog.ILogEncryptConfig iLogEncryptConfig, boolean z, Context context, boolean z2, UrlConfig urlConfig, GlobalConfig globalConfig, LogTrace.LogRequestTraceCallback logRequestTraceCallback, TaskCallback taskCallback, boolean z3, PreInstallChannelCallback preInstallChannelCallback, boolean z4, boolean z5, TeaConfigBuilder teaConfigBuilder) {
        this.retryCount = -1;
        this.appContext = appContext;
        this.storageConfig = teaStorageConfig;
        this.releaseBuild = str;
        this.customerHeader = bundle;
        this.encryptConfig = iLogEncryptConfig;
        this.needAntiCheating = z;
        this.context = context;
        this.autoActiveUser = z2;
        this.urlConfig = urlConfig;
        this.globalConfig = globalConfig;
        this.mLogRequestTraceCallback = logRequestTraceCallback;
        this.taskCallback = taskCallback;
        this.anonymous = z3;
        this.preInstallChannelCallback = preInstallChannelCallback;
        this.childMode = z4;
        this.activeOnce = z5;
        this.isTouristMode = teaConfigBuilder.isTouristMode;
        this.appTraitCallback = teaConfigBuilder.appTraitCallback;
        this.mBDInstallInitHook = teaConfigBuilder.bDInstallInitHook;
        this.sensitiveApiCallback = teaConfigBuilder.mSensitiveApiCallback;
        this.macAddressApiCallback = teaConfigBuilder.mMacAddressApiCallback;
        this.isOpenBpea = teaConfigBuilder.isOpenBpea;
        this.retryCount = teaConfigBuilder.retryCount;
        this.enableListenNetChange = teaConfigBuilder.enableListenNetChange;
    }

    public GlobalConfig getGlobalConfig() {
        return this.globalConfig;
    }

    public boolean isAnonymous() {
        return this.anonymous;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public PreInstallChannelCallback getPreInstallChannelCallback() {
        return this.preInstallChannelCallback;
    }

    public SensitiveApiCallback getSensitiveApiCallback() {
        return this.sensitiveApiCallback;
    }

    public MacAddressApiCallback getMacAddressApiCallback() {
        return this.macAddressApiCallback;
    }

    public boolean isChildMode() {
        return this.childMode;
    }

    public boolean activeOnce() {
        return this.activeOnce;
    }

    public boolean isTouristMode() {
        return this.isTouristMode;
    }

    public boolean isOpenBpea() {
        return this.isOpenBpea;
    }

    public IAppTraitCallback getAppTraitCallback() {
        return this.appTraitCallback;
    }

    public BDInstallInitHook getBDInstallInitHook() {
        return this.mBDInstallInitHook;
    }

    public boolean isEnableListenNetChange() {
        return this.enableListenNetChange;
    }
}
