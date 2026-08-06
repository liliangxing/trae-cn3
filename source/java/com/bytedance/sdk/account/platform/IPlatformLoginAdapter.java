package com.bytedance.sdk.account.platform;

import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* loaded from: classes5.dex */
public interface IPlatformLoginAdapter extends AuthorizeCallback {
    void onLoginError(UserApiResponse userApiResponse);

    void onLoginSuccess(UserApiResponse userApiResponse);
}
