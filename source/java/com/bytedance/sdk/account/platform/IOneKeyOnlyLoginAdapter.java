package com.bytedance.sdk.account.platform;

import com.bytedance.sdk.account.api.response.LoginByTicketResponse;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;

/* loaded from: classes5.dex */
public interface IOneKeyOnlyLoginAdapter extends AuthorizeCallback {
    void onLoginError(AuthorizeErrorResponse authorizeErrorResponse);

    void onLoginSuccess(LoginByTicketResponse loginByTicketResponse);
}
