package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;

/* loaded from: classes5.dex */
public class JitGetMethodHashOptimizer {
    private static final String TAG = "JitGetMethodHashOptimizer";
    private static boolean mOptimized;

    private static native boolean optimize();

    private static boolean loadOptimizerOnNeed(Context context) {
        return SysOptimizer.loadOptimizerLibrary(context);
    }

    public static void fix(Context context) {
        if (!mOptimized && loadOptimizerOnNeed(context)) {
            try {
                optimize();
                mOptimized = true;
            } catch (UnsatisfiedLinkError e) {
                Log.e(TAG, "UnsatisfiedLinkError", e);
            }
        }
    }
}
