package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;

/* loaded from: classes5.dex */
public class CfiCheckOptimizer {
    private static final String TAG = "CfiCheckOptimizer";
    private static boolean mOptimized;

    private static native boolean disableCfiCheck();

    private CfiCheckOptimizer() {
    }

    private static boolean loadOptimizerOnNeed(Context context) {
        if (Build.VERSION.SDK_INT < 29 || Build.VERSION.SDK_INT > 30 || !Process.is64Bit()) {
            return false;
        }
        return SysOptimizer.loadOptimizerLibrary(context);
    }

    public static synchronized boolean optimize(Context context) {
        synchronized (CfiCheckOptimizer.class) {
            if (mOptimized) {
                return true;
            }
            if (loadOptimizerOnNeed(context)) {
                try {
                    boolean disableCfiCheck = disableCfiCheck();
                    mOptimized = disableCfiCheck;
                    return disableCfiCheck;
                } catch (UnsatisfiedLinkError e) {
                    Log.e(TAG, "failed to optimize, UnsatisfiedLinkError", e);
                }
            }
            return false;
        }
    }
}
