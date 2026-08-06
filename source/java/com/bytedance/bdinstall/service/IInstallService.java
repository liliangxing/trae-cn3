package com.bytedance.bdinstall.service;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.OnResetListener;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IInstallService {
    boolean activeManually();

    void changeUriRuntimeAndReInstall(Env env);

    void clearAndSetEnv(Env env);

    Env getCurEnv();

    String getDid();

    boolean getHeader(JSONObject jSONObject);

    InstallInfo getInstallInfo();

    void init(InstallOptions installOptions, Env env);

    boolean isNewUserFirstLaunch();

    JSONObject loadOrGetHeader();

    void registerLifeCycleListener(Application application);

    void resetAndReInstall(Context context, Env env, long j, OnResetListener onResetListener);

    void setAccount(Account account);

    void setInstallInfo(InstallInfo installInfo);

    void start();

    void updateHeader(Context context, Map<String, String> map, boolean z, boolean z2);

    void updateMemoryHeader(Context context, Map<String, Object> map);
}
