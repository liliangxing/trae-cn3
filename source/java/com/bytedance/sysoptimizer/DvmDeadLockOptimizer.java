package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;

/* loaded from: classes5.dex */
public class DvmDeadLockOptimizer {
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized;

    private static boolean loadOptimizerOnNeed(Context context) {
        return false;
    }

    private static native boolean optimize();

    private DvmDeadLockOptimizer() {
    }

    public static synchronized boolean optimize(Context context) {
        synchronized (DvmDeadLockOptimizer.class) {
            if (mOptimized) {
                return true;
            }
            if (loadOptimizerOnNeed(context)) {
                try {
                    boolean optimize = optimize();
                    mOptimized = optimize;
                    return optimize;
                } catch (UnsatisfiedLinkError e) {
                    Log.e(TAG, "failed to optimize, UnsatisfiedLinkError", e);
                }
            }
            return false;
        }
    }
}
