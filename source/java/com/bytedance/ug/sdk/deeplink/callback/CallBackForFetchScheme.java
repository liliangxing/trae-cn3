package com.bytedance.ug.sdk.deeplink.callback;

/* loaded from: classes4.dex */
public interface CallBackForFetchScheme {
    void onFailure(Throwable th);

    void onSuccess(int i, String str);
}
