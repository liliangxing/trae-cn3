package com.bytedance.sdk.account.platform.onekey.carrier;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* loaded from: classes5.dex */
public interface ICarrierService {
    void cancel();

    void getAuthToken(int i, AuthorizeCallback authorizeCallback);

    void getPhoneInfo(String str, String str2, int i, boolean z, AuthorizeCallback authorizeCallback);

    void getValidateToken(int i, AuthorizeCallback authorizeCallback);
}
