package com.bytedance.sdk.account.platform;

import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.mobile.query.OneBindMobileQueryObj;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OneLoginCallback;

/* loaded from: classes5.dex */
public interface IOnekeyBindAdapter extends OneLoginCallback {
    void onBindError(AuthorizeErrorResponse authorizeErrorResponse);

    void onBindSuccess(MobileApiResponse<OneBindMobileQueryObj> mobileApiResponse);
}
