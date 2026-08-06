package com.bytedance.crash;

/* loaded from: classes3.dex */
public interface IOOMCallback {
    void onCrash(CrashType crashType, Throwable th, Thread thread, long j);
}
