package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import com.bytedance.bdinstall.appstate.AppLifeCycleListener;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.service.NUApi;
import com.bytedance.bdinstall.util.Constants;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class BDInstall {
    private static final AppLifeCycleListener sAppLifeCycleListener = new AppLifeCycleListener();
    private static IBDInstallApi sDefaultInstance = new BdInstallInstance();

    public static final boolean isSupportMultiInstance() {
        return true;
    }

    public static IBDInstallApi getInstance() {
        return sDefaultInstance;
    }

    public static boolean isMainInstance(IBDInstallApi iBDInstallApi) {
        return iBDInstallApi == sDefaultInstance;
    }

    public static boolean isMainInstance(String str) {
        return BdInstallInstance.getInstance(str) == sDefaultInstance;
    }

    public static IBDInstallApi getInstance(String str) {
        return BdInstallInstance.getInstance(str);
    }

    public static IBDInstallApi newInstance() {
        return new BdInstallInstance();
    }

    public static AppLifeCycleListener getAppLifeCycleListener() {
        return sAppLifeCycleListener;
    }

    public static void init(InstallOptions installOptions) {
        getInstance().init(installOptions, Env.DEFAULT);
    }

    public static void init(InstallOptions installOptions, Env env) {
        getInstance().init(installOptions, env);
    }

    public static void start() {
        getInstance().start();
    }

    public static Map<String, String> getRequestHeader() {
        return getInstance().getRequestHeader();
    }

    public static Env getCurrentEnv() {
        return getInstance().getCurrentEnv();
    }

    public static void changeUriRuntimeAndReInstall(Env env) {
        getInstance().changeUriRuntimeAndReInstall(env);
    }

    public static void setExecutor(ExecutorOptions executorOptions, String str) {
        getInstance().setExecutor(executorOptions, str);
    }

    public static String addNetCommonParams(Context context, String str, boolean z, Level level) {
        return getInstance().addNetCommonParams(context, str, z, level);
    }

    public static String addNetCommonParams(Context context, StringBuilder sb, boolean z, Level level) {
        return getInstance().addNetCommonParams(context, sb, null, z, level);
    }

    public static String addNetCommonParams(Context context, StringBuilder sb, String str, boolean z, Level level) {
        return getInstance().addNetCommonParams(context, sb, str, z, level);
    }

    public static void putCommonParams(Context context, Map<String, String> map, boolean z, Level level) {
        getInstance().putCommonParams(context, map, z, level);
    }

    public static void setCommonExtraParam(IExtraParams iExtraParams) {
        getInstance().setCommonExtraParam(iExtraParams);
    }

    public static void addCustomParamsWithLevel(String str, String str2, Level level) {
        getInstance().addCustomParamsWithLevel(str, str2, level);
    }

    public static void removeCustomParamsWithLevel(String str, Level level) {
        getInstance().removeCustomParamsWithLevel(str, level);
    }

    public static void addInstallListener(boolean z, IInstallListener iInstallListener) {
        getInstance().addInstallListener(z, iInstallListener);
    }

    public static void removeInstallListener(IInstallListener iInstallListener) {
        getInstance().removeInstallListener(iInstallListener);
    }

    public static void addHeaderChangeListener(boolean z, HeaderUpdateListener headerUpdateListener) {
        getInstance().addHeaderChangeListener(z, headerUpdateListener);
    }

    public static void removeHeaderChangeListener(HeaderUpdateListener headerUpdateListener) {
        getInstance().removeHeaderChangeListener(headerUpdateListener);
    }

    public static void addOaidObserver(boolean z, IOaidObserver iOaidObserver) {
        getInstance().addOaidObserver(z, iOaidObserver);
    }

    public static void removeOaidObserver(IOaidObserver iOaidObserver) {
        getInstance().removeOaidObserver(iOaidObserver);
    }

    public static void addOnDataObserver(IDataObserver iDataObserver) {
        getInstance().addOnDataObserver(iDataObserver);
    }

    public static void removeOnDataObserver(IDataObserver iDataObserver) {
        getInstance().removeOnDataObserver(iDataObserver);
    }

    public static void setUserUniqueId(Context context, String str) {
        getInstance().setUserUniqueId(context, str);
    }

    public static void setCustomHeader(Context context, JSONObject jSONObject) {
        getInstance().setCustomHeader(context, jSONObject);
    }

    public static void updateLanguageAndRegion(Context context, String str, String str2) {
        getInstance().updateLanguageAndRegion(context, str, str2);
    }

    public static void setUserAgent(Context context, String str) {
        getInstance().setUserAgent(context, str);
    }

    public static void setAppTrack(Context context, JSONObject jSONObject) {
        getInstance().setAppTrack(context, jSONObject);
    }

    public static void setAccount(Account account) {
        getInstance().setAccount(account);
    }

    public static JSONObject loadOrGetHeader() {
        return getInstance().loadOrGetHeader();
    }

    public static boolean getCurrentHeader(JSONObject jSONObject) {
        return getInstance().getCurrentHeader(jSONObject);
    }

    public static void getSSIDs(Map<String, String> map) {
        getInstance().getSSIDs(map);
    }

    public static InstallInfo getInstallInfo() {
        return getInstance().getInstallInfo();
    }

    public static String getDid() {
        return getInstance().getDid();
    }

    private static InstallInfo tryGetFallbackInstallInfo(AppContext appContext) {
        return getInstance().tryGetFallbackInstallInfo(appContext);
    }

    public static InstallInfo waitingForInstallFinish(long j) throws InterruptedException {
        return getInstance().waitingForInstallFinish(j);
    }

    public static InstallInfo waitingForInstallFinishWithOldWay() throws InterruptedException {
        return getInstance().waitingForInstallFinishWithOldWay();
    }

    public static boolean activeManually() {
        return getInstance().activeManually();
    }

    public static void setLogger(ILogger iLogger) {
        DrLog.setLogger(iLogger);
    }

    public static void setDebuggable(Boolean bool) {
        DrLog.DEBUG = bool.booleanValue();
    }

    public static NUApi newUserMode() {
        return getInstance().newUserMode();
    }

    public static boolean isNewUserMode() {
        return getInstance().isNewUserMode();
    }

    public static boolean isNewUserModeAvailable() {
        try {
            return Class.forName(Constants.NAME_NEW_USER_IMPL) != null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Deprecated
    public static boolean isNewUserFirstLaunch() {
        return getInstance().isNewUserFirstLaunch();
    }

    public static void setAppContext(AppContext appContext) {
        getInstance().setAppContext(appContext);
    }

    public static AppContext getAppContext() {
        return getInstance().getAppContext();
    }

    @Deprecated
    public static void setParamsFilter(IParamFilter iParamFilter) {
        getInstance().setParamsFilter(iParamFilter);
    }

    public static IParamFilter getParamsFilter() {
        return getInstance().getParamsFilter();
    }

    public static void setAdIdConfig(IAdIdConfig iAdIdConfig) {
        getInstance().setAdIdConfig(iAdIdConfig);
    }

    public static IAdIdConfig getAdIdConfig() {
        return getInstance().getAdIdConfig();
    }

    static InstallOptions getInstallOptions() {
        return getInstance().getInstallOptions();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void registerLifeCycleListener(Application application) {
        application.registerActivityLifecycleCallbacks(sAppLifeCycleListener);
    }

    public static void setInstallInfo(InstallInfo installInfo) {
        getInstance().setInstallInfo(installInfo);
    }

    public static void clearAndSetEnv(Env env) {
        getInstance().clearInstallInfoWhenSwitchChildMode(env);
    }

    public static void resetAndReInstall(Context context, Env env, long j, OnResetListener onResetListener) {
        getInstance().resetInstallInfoWhenSwitchChildMode(context, env, j, onResetListener);
    }

    public static void clearInstallInfoWhenSwitchChildMode(Env env) {
        getInstance().clearInstallInfoWhenSwitchChildMode(env);
    }

    public static void resetInstallInfoWhenSwitchChildMode(Context context, Env env, long j, OnResetListener onResetListener) {
        getInstance().resetInstallInfoWhenSwitchChildMode(context, env, j, onResetListener);
    }

    public static void stopNetCommOpt(Context context) {
        getInstance().stopNetCommOpt(context);
    }

    public static BDInstallConfig getBDInstallConfig() {
        return getInstance().getBDInstallConfig();
    }

    public static void addRegisterCustomHeader(Context context, JSONObject jSONObject) {
        getInstance().addRegisterCustomHeader(context, jSONObject);
    }
}
