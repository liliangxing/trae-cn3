package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.service.NUApi;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IBDInstallApi {
    boolean activeManually();

    void addCustomParamsWithLevel(String str, String str2, Level level);

    void addHeaderChangeListener(boolean z, HeaderUpdateListener headerUpdateListener);

    void addInstallListener(boolean z, IInstallListener iInstallListener);

    String addNetCommonParams(Context context, String str, boolean z, Level level);

    String addNetCommonParams(Context context, StringBuilder sb, String str, boolean z, Level level);

    String addNetCommonParams(Context context, StringBuilder sb, boolean z, Level level);

    void addOaidObserver(boolean z, IOaidObserver iOaidObserver);

    void addOnDataObserver(IDataObserver iDataObserver);

    void addRegisterCustomHeader(Context context, JSONObject jSONObject);

    void changeUriRuntimeAndReInstall(Env env);

    void clearAndSetEnv(Env env);

    void clearInstallInfoWhenSwitchChildMode(Env env);

    IAdIdConfig getAdIdConfig();

    AppContext getAppContext();

    BDInstallConfig getBDInstallConfig();

    Env getCurrentEnv();

    boolean getCurrentHeader(JSONObject jSONObject);

    String getDid();

    InstallInfo getInstallInfo();

    InstallOptions getInstallOptions();

    IParamFilter getParamsFilter();

    Map<String, String> getRequestHeader();

    void getSSIDs(Map<String, String> map);

    void init(InstallOptions installOptions);

    void init(InstallOptions installOptions, Env env);

    boolean isNewUserFirstLaunch();

    boolean isNewUserMode();

    boolean isNewUserModeAvailable();

    JSONObject loadOrGetHeader();

    NUApi newUserMode();

    void putCommonParams(Context context, Map<String, String> map, boolean z, Level level);

    void registerLifeCycleListener(Application application);

    void removeCustomParamsWithLevel(String str, Level level);

    void removeHeaderChangeListener(HeaderUpdateListener headerUpdateListener);

    void removeInstallListener(IInstallListener iInstallListener);

    void removeOaidObserver(IOaidObserver iOaidObserver);

    void removeOnDataObserver(IDataObserver iDataObserver);

    void resetAndReInstall(Context context, Env env, long j, OnResetListener onResetListener);

    void resetInstallInfoWhenSwitchChildMode(Context context, Env env, long j, OnResetListener onResetListener);

    void setAccount(Account account);

    void setAdIdConfig(IAdIdConfig iAdIdConfig);

    void setAppContext(AppContext appContext);

    void setAppTrack(Context context, JSONObject jSONObject);

    void setCommonExtraParam(IExtraParams iExtraParams);

    void setCustomHeader(Context context, JSONObject jSONObject);

    void setExecutor(ExecutorOptions executorOptions, String str);

    void setInstallInfo(InstallInfo installInfo);

    void setParamsFilter(IParamFilter iParamFilter);

    void setUserAgent(Context context, String str);

    void setUserUniqueId(Context context, String str);

    void start();

    void stopNetCommOpt(Context context);

    InstallInfo tryGetFallbackInstallInfo(AppContext appContext);

    void updateLanguageAndRegion(Context context, String str, String str2);

    InstallInfo waitingForInstallFinish(long j) throws InterruptedException;

    InstallInfo waitingForInstallFinishWithOldWay();
}
