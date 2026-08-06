package com.bytedance.applog.exception;

/* loaded from: classes3.dex */
public interface UncaughtExceptionCallback {
    void onException(Thread thread, Throwable th);
}
