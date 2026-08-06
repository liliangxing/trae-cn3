package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;

/* loaded from: classes5.dex */
public class WmOverFlowOptimizer {
    private static final String TAG = "WmOverFlowOptimizer";
    private static boolean mOptimized;

    private static native boolean optimize();

    public static synchronized void fix(Context context) {
        synchronized (WmOverFlowOptimizer.class) {
            if (mOptimized) {
                return;
            }
            if (Build.VERSION.SDK_INT > 25) {
                return;
            }
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                try {
                    try {
                        optimize();
                        mOptimized = true;
                    } catch (UnsatisfiedLinkError e) {
                        Log.e(TAG, "UnsatisfiedLinkError", e);
                    }
                } catch (NoSuchMethodError e2) {
                    Log.e(TAG, "NoSuchMethodError", e2);
                }
            }
        }
    }
}
