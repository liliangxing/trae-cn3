package com.bytedance.sdk.account.impl;

import android.content.Context;
import com.bytedance.sdk.account.AccountSdkCallback;
import com.bytedance.sdk.account.AccountSdkHandler;
import com.bytedance.sdk.account.AccountSdkResponse;
import com.bytedance.sdk.account.api.IBDAccountCommonApi;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.mobile.query.SendCodeQueryObj;
import com.bytedance.sdk.account.mobile.query.UserPasswordLoginQueryObj;
import com.bytedance.sdk.account.mobile.thread.SendCodeApiThread;
import com.bytedance.sdk.account.mobile.thread.UserPasswordLoginApiThread;
import com.bytedance.sdk.account.mobile.thread.call.SendCodeCallback;
import com.bytedance.sdk.account.mobile.thread.call.UserPasswordLoginQueryCallback;
import com.bytedance.sdk.account.param.SendCodeParam;
import com.bytedance.sdk.account.param.UserLoginParam;
import com.bytedance.sdk.account.response.SendCodeResponseData;
import com.bytedance.sdk.account.response.UserLoginResponseData;
import com.ss.android.account.TTAccountInit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAccountCommonApiImpl implements IBDAccountCommonApi {
    private static volatile IBDAccountCommonApi sInstance;
    private Context mContext = TTAccountInit.getConfig().getApplicationContext();

    private BDAccountCommonApiImpl() {
    }

    public static IBDAccountCommonApi instance() {
        if (sInstance == null) {
            synchronized (BDAccountCommonApiImpl.class) {
                if (sInstance == null) {
                    sInstance = new BDAccountCommonApiImpl();
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountCommonApi
    public AccountSdkHandler sendCode(SendCodeParam sendCodeParam, final AccountSdkCallback<SendCodeResponseData> accountSdkCallback) {
        SendCodeApiThread sendCode = SendCodeApiThread.sendCode(this.mContext, sendCodeParam, new SendCodeCallback() { // from class: com.bytedance.sdk.account.impl.BDAccountCommonApiImpl.1
            @Override // com.bytedance.sdk.account.NeedCaptchaCallBack, com.bytedance.sdk.account.CommonCallBack
            public void onSuccess(MobileApiResponse<SendCodeQueryObj> mobileApiResponse) {
                accountSdkCallback.onSuccess(new AccountSdkResponse(mobileApiResponse, new SendCodeResponseData(mobileApiResponse.mobileObj)));
            }

            @Override // com.bytedance.sdk.account.NeedCaptchaCallBack, com.bytedance.sdk.account.CommonCallBack
            public void onError(MobileApiResponse<SendCodeQueryObj> mobileApiResponse, int i) {
                accountSdkCallback.onError(new AccountSdkResponse(mobileApiResponse, new SendCodeResponseData(mobileApiResponse.mobileObj)));
            }
        });
        sendCode.start();
        return new AccountSdkHandler(sendCode);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountCommonApi
    public AccountSdkHandler accountLogin(UserLoginParam userLoginParam, final AccountSdkCallback<UserLoginResponseData> accountSdkCallback) {
        UserPasswordLoginApiThread userLogin = UserPasswordLoginApiThread.userLogin(this.mContext, userLoginParam, new UserPasswordLoginQueryCallback() { // from class: com.bytedance.sdk.account.impl.BDAccountCommonApiImpl.2
            @Override // com.bytedance.sdk.account.NeedCaptchaCallBack, com.bytedance.sdk.account.CommonCallBack
            public void onSuccess(MobileApiResponse<UserPasswordLoginQueryObj> mobileApiResponse) {
                accountSdkCallback.onSuccess(new AccountSdkResponse(mobileApiResponse, new UserLoginResponseData(mobileApiResponse.mobileObj)));
            }

            @Override // com.bytedance.sdk.account.NeedCaptchaCallBack, com.bytedance.sdk.account.CommonCallBack
            public void onError(MobileApiResponse<UserPasswordLoginQueryObj> mobileApiResponse, int i) {
                accountSdkCallback.onError(new AccountSdkResponse(mobileApiResponse, new UserLoginResponseData(mobileApiResponse.mobileObj)));
            }
        });
        userLogin.start();
        return new AccountSdkHandler(userLogin);
    }
}
