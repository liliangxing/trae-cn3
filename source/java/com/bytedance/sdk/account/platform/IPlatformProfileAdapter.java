package com.bytedance.sdk.account.platform;

import com.bytedance.sdk.account.information.method.oauth_profile.OauthProfileResponse;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* loaded from: classes5.dex */
interface IPlatformProfileAdapter extends AuthorizeCallback {
    void onProfileError(OauthProfileResponse oauthProfileResponse);

    void onProfileSuccess(OauthProfileResponse oauthProfileResponse);
}
