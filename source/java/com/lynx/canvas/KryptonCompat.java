package com.lynx.canvas;

/* loaded from: classes6.dex */
public class KryptonCompat {
    private static native long nativeEnsureTaskRunnerForCurrentThread();

    public static long EnsureTaskRunnerForCurrentThread() {
        return nativeEnsureTaskRunnerForCurrentThread();
    }
}
