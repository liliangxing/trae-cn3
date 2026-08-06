package com.bytedance.sysoptimizer;

import android.content.Context;

/* loaded from: classes5.dex */
public class DvmOptimizer {
    private static boolean sOptimized;

    private static boolean loadOptimizerOnNeed(Context context) {
        return false;
    }

    private static native void optLinearAllocBuffer(int i);

    private static native void startHookDvmFunc();

    private DvmOptimizer() {
    }

    public static void optDvmLinearAllocBuffer(Context context) {
        optDvmLinearAllocBuffer(context, 67108864);
    }

    public static synchronized void optDvmLinearAllocBuffer(Context context, int i) {
        synchronized (DvmOptimizer.class) {
            if (sOptimized) {
                return;
            }
            if (loadOptimizerOnNeed(context)) {
                optLinearAllocBuffer(i);
                sOptimized = true;
            }
        }
    }

    public static void hookDvmLinearAllocFunc(Context context) {
        if (loadOptimizerOnNeed(context)) {
            startHookDvmFunc();
        }
    }
}
