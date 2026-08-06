package com.bytedance.ug.sdk.share.api.callback;

/* loaded from: classes4.dex */
public interface OnDownloadListener {
    void onCanceled();

    void onFailed(Throwable th);

    void onProgress(int i);

    void onStart();

    void onSuccessed();
}
