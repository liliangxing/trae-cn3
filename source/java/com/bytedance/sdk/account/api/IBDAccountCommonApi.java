package com.bytedance.sdk.account.api;

import com.bytedance.sdk.account.AccountSdkCallback;
import com.bytedance.sdk.account.AccountSdkHandler;
import com.bytedance.sdk.account.param.SendCodeParam;
import com.bytedance.sdk.account.param.UserLoginParam;
import com.bytedance.sdk.account.response.SendCodeResponseData;
import com.bytedance.sdk.account.response.UserLoginResponseData;

/* loaded from: classes5.dex */
public interface IBDAccountCommonApi {
    AccountSdkHandler accountLogin(UserLoginParam userLoginParam, AccountSdkCallback<UserLoginResponseData> accountSdkCallback);

    AccountSdkHandler sendCode(SendCodeParam sendCodeParam, AccountSdkCallback<SendCodeResponseData> accountSdkCallback);
}
