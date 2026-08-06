package com.bytedance.sdk.account;

import com.bytedance.sdk.account.AccountSdkResponseData;

/* loaded from: classes5.dex */
public interface AccountSdkCallback<D extends AccountSdkResponseData> {
    void onError(AccountSdkResponse<D> accountSdkResponse);

    void onSuccess(AccountSdkResponse<D> accountSdkResponse);
}
