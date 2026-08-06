package com.bytedance.sysoptimizer;

/* loaded from: classes5.dex */
public class LogVerbosityUtil {
    private static native void nOpen();

    public static void open() {
        if (SysOptimizer.loadOptimizerLibrary(null)) {
            nOpen();
        }
    }
}
