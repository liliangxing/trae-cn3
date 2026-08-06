package com.bytedance.sysoptimizer;

import android.content.Context;

/* loaded from: classes5.dex */
public class DvmGlesOptimizer {
    private static final String TAG = "DvmGlesOptimizer";
    private static boolean mOptimized;

    private static native boolean optimize();

    public static synchronized void fix(Context context) {
        synchronized (DvmGlesOptimizer.class) {
            if (mOptimized) {
            }
        }
    }
}
