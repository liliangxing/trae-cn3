package com.bytedance.sync.interfaze;

import com.bytedance.sync.exc.SyncException;

/* loaded from: classes5.dex */
public interface Callback<T> {
    void onFailed(SyncException syncException);

    void onSuccess(T t);
}
