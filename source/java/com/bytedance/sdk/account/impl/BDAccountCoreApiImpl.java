package com.bytedance.sdk.account.impl;

import android.content.Context;
import com.bytedance.sdk.account.ApiLogoutThread;
import com.bytedance.sdk.account.api.IBDAccountCoreApi;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.LogoutApiResponse;
import com.bytedance.sdk.account.api.callback.GetAccountInfoCallback;
import com.bytedance.sdk.account.api.callback.LoginInfoCallback;
import com.bytedance.sdk.account.job.GetAccountInfoJob;
import com.bytedance.sdk.account.job.GetLoginInfoJob;
import com.bytedance.sdk.account.save.entity.InfoType;
import com.ss.android.TTAccountConfig;
import com.ss.android.account.TTAccountInit;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAccountCoreApiImpl implements IBDAccountCoreApi {
    private static volatile BDAccountCoreApiImpl sInstance;
    Context mContext;

    private BDAccountCoreApiImpl(Context context) {
        TTAccountConfig configMayNull = TTAccountInit.getConfigMayNull();
        if (configMayNull == null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = configMayNull.getApplicationContext();
        }
    }

    public static IBDAccountCoreApi instance() {
        return instance(TTAccountInit.getConfig().getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBDAccountCoreApi instance(Context context) {
        if (sInstance == null) {
            synchronized (BDAccountCoreApiImpl.class) {
                if (sInstance == null) {
                    sInstance = new BDAccountCoreApiImpl(context);
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountCoreApi
    public void logout(String str, Map map, AbsApiCall<LogoutApiResponse> absApiCall) {
        ApiLogoutThread.logout(this.mContext, str, map, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountCoreApi
    public void getNewAccountInfo(String str, GetAccountInfoCallback getAccountInfoCallback) {
        GetAccountInfoJob.getNewAccountInfo(this.mContext, str, getAccountInfoCallback).start();
    }

    private void getMatchDBDeviceLoginInfo(boolean z, int i, int i2, LoginInfoCallback loginInfoCallback) {
        GetLoginInfoJob.getDeviceLoginInfo(this.mContext, z, i, i2, loginInfoCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountCoreApi
    public void getDeviceLoginInfo(boolean z, List<InfoType> list, int i, LoginInfoCallback loginInfoCallback) {
        getMatchDBDeviceLoginInfo(z, InfoType.getValue(list), i, loginInfoCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountCoreApi
    public void getRecentLoginInfo(LoginInfoCallback loginInfoCallback) {
        getMatchDBDeviceLoginInfo(false, InfoType.INFO_TYPE_1.getValue(), 0, loginInfoCallback);
    }
}
