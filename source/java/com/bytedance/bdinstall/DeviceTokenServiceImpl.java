package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class DeviceTokenServiceImpl extends AbsDeviceTokenService {
    private final Context mContext;
    private volatile Env mEnv;
    private volatile InstallOptions mOptions;

    public DeviceTokenServiceImpl(InstallOptions installOptions, Env env) {
        this.mOptions = installOptions;
        this.mContext = installOptions.getContext();
        this.mEnv = env;
    }

    @Override // com.bytedance.bdinstall.DeviceTokenService
    public void updateToken(String str, Env env) {
        SharedPreferences envIsolateSp;
        this.mEnv = env;
        if (env != null && (envIsolateSp = env.getEnvIsolateSp(this.mOptions)) != null) {
            envIsolateSp.edit().putString("device_token", str).apply();
        }
        SubpSyncManager.inst(this.mContext).sendSubpEvent(this.mOptions.getAidString(), "device_token", str);
    }

    @Override // com.bytedance.bdinstall.AbsDeviceTokenService
    protected String getDeviceToken() {
        return this.mEnv.getEnvIsolateSp(this.mContext).getString("device_token", null);
    }
}
