package com.bytedance.platform.horae;

/* loaded from: classes4.dex */
public interface OnEventOccur {
    void onAsyncDispatchComponents(String str, int i, long j);

    void onAsyncStart(int i);

    void onExceptionOccur(Throwable th);

    void onInitialFailedOccur(String str);

    void onInitialSuccessOccur();
}
