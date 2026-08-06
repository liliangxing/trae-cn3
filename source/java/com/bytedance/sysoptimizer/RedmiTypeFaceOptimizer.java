package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;

/* loaded from: classes5.dex */
public class RedmiTypeFaceOptimizer {
    private static final String TAG = "RedmiTypeFaceOptimizer";
    private static boolean mOptimized;

    private static native boolean optimize(boolean z);

    private static boolean loadOptimizerOnNeed(Context context) {
        return SysOptimizer.loadOptimizerLibrary(context);
    }

    public static void fixOnAndroidQ(Context context) {
        fixOnAndroidQ(context, false);
    }

    public static void fixOnAndroidQ(Context context, boolean z) {
        if (!mOptimized && Build.VERSION.SDK_INT == 29 && loadOptimizerOnNeed(context)) {
            try {
                optimize(z);
                mOptimized = true;
            } catch (UnsatisfiedLinkError e) {
                Log.e(TAG, "UnsatisfiedLinkError", e);
            }
        }
    }
}
