package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;

/* loaded from: classes5.dex */
public class StageFrightAndroid4Optimizer {
    private static final String TAG = "StageFrightOptimizer";
    private static boolean mOptimized;

    private static native boolean optimize();

    private static boolean loadOptimizerOnNeed(Context context) {
        return SysOptimizer.loadOptimizerLibrary(context);
    }

    public static void fixStageFrightAndroid4(Context context) {
        if (!mOptimized && Build.VERSION.SDK_INT < 26 && loadOptimizerOnNeed(context)) {
            try {
                optimize();
                mOptimized = true;
            } catch (UnsatisfiedLinkError e) {
                Log.e(TAG, "UnsatisfiedLinkError", e);
            }
        }
    }
}
