package com.bytedance.crash;

/* loaded from: classes3.dex */
public interface ICrashCallback {
    void onCrash(CrashType crashType, String str, Thread thread);
}
