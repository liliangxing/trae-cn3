package com.bytedance.common.push.interfaze;

import com.bytedance.common.model.Result;

/* loaded from: classes3.dex */
public interface ApiCallback<T> {
    void onFailed(Result result);

    void onSuccess(T t);
}
