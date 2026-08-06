package com.bytedance.sdk.account.platform.onekey;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* loaded from: classes5.dex */
public class OnekeyResponseCallable<T> {
    public AuthorizeCallback mCallback;
    public final T response;

    public OnekeyResponseCallable(AuthorizeCallback authorizeCallback, T t) {
        this.mCallback = authorizeCallback;
        this.response = t;
    }
}
