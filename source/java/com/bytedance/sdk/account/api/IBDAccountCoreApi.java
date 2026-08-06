package com.bytedance.sdk.account.api;

import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.LogoutApiResponse;
import com.bytedance.sdk.account.api.callback.GetAccountInfoCallback;
import com.bytedance.sdk.account.api.callback.LoginInfoCallback;
import com.bytedance.sdk.account.save.entity.InfoType;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public interface IBDAccountCoreApi {
    void getDeviceLoginInfo(boolean z, List<InfoType> list, int i, LoginInfoCallback loginInfoCallback);

    void getNewAccountInfo(String str, GetAccountInfoCallback getAccountInfoCallback);

    void getRecentLoginInfo(LoginInfoCallback loginInfoCallback);

    void logout(String str, Map map, AbsApiCall<LogoutApiResponse> absApiCall);
}
