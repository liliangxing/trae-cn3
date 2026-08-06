package com.bytedance.sdk.account;

import com.bytedance.sdk.account.impl.BaseAccountApi;

/* loaded from: classes5.dex */
public class AccountSdkHandler {
    private final BaseAccountApi api;

    public AccountSdkHandler(BaseAccountApi baseAccountApi) {
        this.api = baseAccountApi;
    }

    public void cancel() {
        this.api.cancel();
    }
}
