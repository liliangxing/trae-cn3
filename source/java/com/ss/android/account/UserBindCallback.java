package com.ss.android.account;

import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.UserApiResponse;

/* loaded from: classes7.dex */
public abstract class UserBindCallback extends AbsApiCall<UserApiResponse> {
    public abstract void onBindError(UserApiResponse userApiResponse);

    public abstract void onBindExist(UserApiResponse userApiResponse, String str, String str2, String str3);

    public abstract void onBindSuccess(UserApiResponse userApiResponse);

    @Override // com.bytedance.sdk.account.api.call.AbsApiCall
    public void onResponse(UserApiResponse userApiResponse) {
        if (userApiResponse.success) {
            onBindSuccess(userApiResponse);
            return;
        }
        if (userApiResponse.isBindExist()) {
            if (userApiResponse.authToken != null) {
                onBindExist(userApiResponse, userApiResponse.errorTip, userApiResponse.confirmTip, userApiResponse.authToken);
                return;
            } else {
                onBindError(userApiResponse);
                return;
            }
        }
        onBindError(userApiResponse);
    }
}
