package com.bytedance.ug.sdk.share.api.depend;

/* loaded from: classes4.dex */
public interface IShareAsyncThreadConfig {
    void execute(Runnable runnable);

    void executeWithSingleThread(Runnable runnable);
}
