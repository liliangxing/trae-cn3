package com.bytedance.sysoptimizer;

import android.content.Context;

/* loaded from: classes5.dex */
public class MaliGpuExtIsSupportOptimizer {
    private static final String TAG = "MaliGpuExtIsSupportOpt";
    private static boolean sOptimized;

    private static native boolean optimize();

    public static synchronized void fix(Context context) {
        synchronized (MaliGpuExtIsSupportOptimizer.class) {
            if (sOptimized) {
            }
        }
    }
}
