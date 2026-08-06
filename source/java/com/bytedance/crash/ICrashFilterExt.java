package com.bytedance.crash;

/* loaded from: classes3.dex */
public interface ICrashFilterExt extends ICrashFilter {
    boolean onAnrFilter(String str, String str2);

    boolean onExitReasonFilter(String str);
}
