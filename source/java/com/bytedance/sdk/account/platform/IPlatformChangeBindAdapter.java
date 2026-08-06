package com.bytedance.sdk.account.platform;

import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.platform.IPlatformBindAdapter;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* loaded from: classes5.dex */
public interface IPlatformChangeBindAdapter extends AuthorizeCallback {

    /* loaded from: classes5.dex */
    public interface BindController {
        void doNext();
    }

    void onBindExist(UserApiResponse userApiResponse, String str, String str2, String str3, IPlatformBindAdapter.BindController bindController);

    void onChangeBindError(UserApiResponse userApiResponse);

    void onChangeBindSuccess(UserApiResponse userApiResponse);
}
