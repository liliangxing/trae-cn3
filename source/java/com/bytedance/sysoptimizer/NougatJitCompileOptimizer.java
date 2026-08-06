package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;

/* loaded from: classes5.dex */
public class NougatJitCompileOptimizer {
    private static final String TAG = "NJitCompileOptimizer";
    private static boolean sOptimized;

    private static native void optimize();

    public static synchronized void fix(Context context) {
        synchronized (NougatJitCompileOptimizer.class) {
            if (sOptimized) {
                return;
            }
            if (Build.VERSION.SDK_INT != 24) {
                return;
            }
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                try {
                    try {
                        optimize();
                        sOptimized = true;
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
