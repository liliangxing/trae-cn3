package com.bytedance.sdk.open.aweme.core;

/* loaded from: classes5.dex */
public interface OpenCallback<T> {
    void onFail(int i, String str);

    void onSuccess(T t);
}
