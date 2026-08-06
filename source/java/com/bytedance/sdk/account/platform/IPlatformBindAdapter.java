package com.bytedance.sdk.account.platform;

import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* loaded from: classes5.dex */
public interface IPlatformBindAdapter extends AuthorizeCallback {

    /* loaded from: classes5.dex */
    public interface BindController {
        void doNext();
    }

    void onBindError(UserApiResponse userApiResponse);

    void onBindExist(UserApiResponse userApiResponse, String str, String str2, String str3, BindController bindController);

    void onBindSuccess(UserApiResponse userApiResponse);
}
