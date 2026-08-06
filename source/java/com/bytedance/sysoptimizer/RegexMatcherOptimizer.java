package com.bytedance.sysoptimizer;

import android.content.Context;

/* loaded from: classes5.dex */
public class RegexMatcherOptimizer {
    private static final String TAG = "RegexMatcherOptimizer";
    private static boolean sOptimized;

    private static native boolean optimize();

    public static synchronized void fix(Context context) {
        synchronized (RegexMatcherOptimizer.class) {
            if (sOptimized) {
            }
        }
    }
}
