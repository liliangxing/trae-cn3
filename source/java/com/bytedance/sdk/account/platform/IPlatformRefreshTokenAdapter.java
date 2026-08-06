package com.bytedance.sdk.account.platform;

import com.bytedance.sdk.account.api.response.UpdateAuthorizeInfoResponse;

/* loaded from: classes5.dex */
public interface IPlatformRefreshTokenAdapter {
    void onRefreshTokenError(UpdateAuthorizeInfoResponse updateAuthorizeInfoResponse);

    void onRefreshTokenSuccess(UpdateAuthorizeInfoResponse updateAuthorizeInfoResponse);
}
