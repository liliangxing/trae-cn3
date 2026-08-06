package com.hihonor.push.sdk;

/* loaded from: classes6.dex */
public interface HonorPushCallback<T> {
    void onFailure(int i, String str);

    void onSuccess(T t);
}
