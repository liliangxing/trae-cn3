package com.ss.android.common.applog;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.bdinstall.Level;
import com.bytedance.common.utility.NetClientChecker;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.LogTrace;
import com.ss.android.common.applog.NetUtil;
import com.ss.android.common.applog.task.TaskCallback;
import com.ss.android.common.applog.task.TaskPresenter;
import com.ss.android.deviceregister.DeviceRegisterManager;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TeaAgentHelper {
    public static void addOnDeviceConfigUpdateListener(DeviceRegisterManager.OnDeviceConfigUpdateListener onDeviceConfigUpdateListener) {
        DeviceRegisterManager.addOnDeviceConfigUpdateListener(onDeviceConfigUpdateListener);
    }

    @Deprecated
    public static String addNetCommonParams(String str, boolean z) {
        return NetUtil.addCommonParams(str, z);
    }

    @Deprecated
    public static void addNetCommonParams(StringBuilder sb, boolean z) {
        NetUtil.appendCommonParams(sb, z);
    }

    public static void appendCommonParamsWithLevel(StringBuilder sb, boolean z, Level level) {
        NetUtil.appendCommonParamsWithLevel(sb, z, level);
    }

    public static String addNetCommonParamsWithLevel(String str, boolean z, Level level) {
        return NetUtil.addCommonParamsWithLevel(str, z, level);
    }

    public static void addCustomParamsWithLevel(String str, String str2, Level level) {
        NetUtil.addCustomParamsWithLevel(str, str2, level);
    }

    public static void putCommonParamsWithLevel(Map<String, String> map, boolean z, Level level) {
        NetUtil.putCommonParamsWithLevel(map, z, level);
    }

    public static void setExtraParams(NetUtil.IExtraParams iExtraParams) {
        NetUtil.setExtraparams(iExtraParams);
    }

    private static void initStorageConfig(TeaStorageConfig teaStorageConfig, Context context) {
        if (teaStorageConfig != null) {
            String spName = teaStorageConfig.getSpName();
            if (!TextUtils.isEmpty(spName)) {
                AppLog.setSPName(spName);
            }
            String dbName = teaStorageConfig.getDbName();
            if (!TextUtils.isEmpty(dbName)) {
                AppLog.setDBNamme(dbName);
            }
            Account account = teaStorageConfig.getAccount();
            if (account != null) {
                AppLog.setAccount(context, account);
            }
            String encryptCountSPName = teaStorageConfig.getEncryptCountSPName();
            if (TextUtils.isEmpty(encryptCountSPName)) {
                return;
            }
            AppLog.setEncryptCountSPName(encryptCountSPName);
        }
    }

    private static void initGlobalConfig(GlobalConfig globalConfig) {
        if (globalConfig != null) {
            String googleId = globalConfig.getGoogleId();
            if (!TextUtils.isEmpty(googleId)) {
                AppLog.setGoogleAId(googleId);
            }
            AppLog.setAppLanguageAndRegion(globalConfig.getLanguage(), globalConfig.getRegion());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(TeaConfig teaConfig) {
        TeaUtils.ensureNonNull(teaConfig, "config");
        if (!NetClientChecker.isNetworkClientSet()) {
            throw new IllegalArgumentException("net work client is not set");
        }
        AppLog.setAppContext(teaConfig.getAppContext());
        initStorageConfig(teaConfig.getStorageConfig(), teaConfig.getContext());
        initGlobalConfig(teaConfig.getGlobalConfig());
        String releaseBuild = teaConfig.getReleaseBuild();
        if (!TextUtils.isEmpty(releaseBuild)) {
            AppLog.setReleaseBuild(releaseBuild);
        }
        Bundle customerHeader = teaConfig.getCustomerHeader();
        if (customerHeader != null) {
            AppLog.setCustomerHeader(customerHeader);
        }
        AppLog.ILogEncryptConfig encryptConfig = teaConfig.getEncryptConfig();
        if (encryptConfig != null) {
            AppLog.setLogEncryptConfig(encryptConfig);
        }
        String channel = teaConfig.getAppContext().getChannel();
        if (!TextUtils.isEmpty(channel)) {
            AppLog.setChannel(channel);
            if (TextUtils.isEmpty(teaConfig.getContext().getPackageName())) {
                throw new IllegalArgumentException("packageName from context can not be empty");
            }
            if (TextUtils.isEmpty(teaConfig.getAppContext().getVersion())) {
                throw new IllegalArgumentException("getVersion from appContext can not be empty");
            }
            AppLog.setNeedAntiCheating(teaConfig.isNeedAntiCheating());
            LogTrace.LogRequestTraceCallback logRequestTraceCallback = teaConfig.getLogRequestTraceCallback();
            if (logRequestTraceCallback != null) {
                AppLog.registerLogRequestCallback(logRequestTraceCallback);
            }
            AppLog.setTouristMode(teaConfig.isTouristMode());
            AppLog.setAnonymous(teaConfig.isAnonymous());
            AppLog.setActiveOnce(teaConfig.activeOnce());
            TaskCallback taskCallback = teaConfig.getTaskCallback();
            if (taskCallback != null) {
                TaskPresenter.registerTaskCallback(taskCallback);
            }
            TeaThread.getInst();
            TaskPresenter.inst(teaConfig.getContext());
            AppLog.setPreInstallChannelCallback(teaConfig.getPreInstallChannelCallback());
            AppLog.setSensitiveApiCallback(teaConfig.getSensitiveApiCallback());
            AppLog.setMacAddressApiCallback(teaConfig.getMacAddressApiCallback());
            AppLog.setOpenBpea(teaConfig.isOpenBpea());
            AppLog.setWaitDid(30000L);
            AppLog.setRetryCount(teaConfig.getRetryCount());
            AppLog.setChildModeBeforeInit(teaConfig.isChildMode());
            DeviceRegisterManager.setAppTraitCallback(teaConfig.getAppTraitCallback());
            if (teaConfig.getBDInstallInitHook() != null) {
                AppLog.setBDInstallInitHook(teaConfig.getBDInstallInitHook());
            }
            AppLog.setEnableListenNetChange(teaConfig.isEnableListenNetChange());
            AppLog.init(teaConfig.getContext(), teaConfig.isAutoActiveUser(), teaConfig.getUrlConfig());
            return;
        }
        throw new IllegalArgumentException("channel in appContext can not be empty");
    }
}
