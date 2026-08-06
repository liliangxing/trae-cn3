package com.bytedance.applog.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import android.os.Looper;
import com.bytedance.applog.BDInstallInitHook;
import com.bytedance.applog.bdinstall.BdInstallImpl;
import com.bytedance.applog.manager.ConfigManager;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.IBDInstallApi;
import com.bytedance.bdinstall.IExtraParams;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.OnResetListener;
import com.bytedance.bdinstall.service.NUApi;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IBdInstallService {
    void addDataObserver();

    void addHeaderAndInstallFinishListener(BdInstallImpl.OnHeaderAndInstallInfoCallback onHeaderAndInstallInfoCallback);

    String addNetCommonParams(Context context, StringBuilder sb, boolean z, Level level);

    void addRegisterCustomHeader(Context context, JSONObject jSONObject);

    void clearAndSetEnv(Env env);

    void clearInstallInfoWhenSwitchChildMode(Env env);

    IBDInstallApi getBDInstallApi();

    String getClientUdid();

    boolean getCurrentHeader(JSONObject jSONObject);

    String getDid();

    String getIid();

    InstallInfo getInstallInfo();

    InstallOptions getInstallOptions();

    String getOpenUdid();

    Map<String, String> getRequestHeader();

    String getSsid();

    void init(ConfigManager configManager, Env env, Looper looper, BDInstallInitHook bDInstallInitHook);

    boolean isNewUserAvailable();

    boolean isNewUserFirstLaunch();

    boolean isNewUserMode(Context context);

    boolean isValidDidAndIid();

    boolean manualActivate();

    NUApi newUserMode(Context context);

    void putCommonParams(Context context, Map<String, String> map, boolean z, Level level);

    void removeHeaderInfo(String str);

    void resetAndReInstall(Context context, Env env, long j, OnResetListener onResetListener);

    void resetInstallInfoWhenSwitchChildMode(Context context, Env env, long j, OnResetListener onResetListener);

    void setAccount(Account account);

    void setAppTrack(Context context, JSONObject jSONObject);

    void setCommonExtraParam(IExtraParams iExtraParams);

    void setHeaderInfo(HashMap<String, Object> hashMap);

    void setNewUserMode(Context context, boolean z);

    void setUriRuntime(Env env);

    void setUserAgent(Context context, String str);

    void start();

    void updateLanguageAndRegion(Context context, String str, String str2);

    void updateUserUniqueId(Application application, String str);
}
