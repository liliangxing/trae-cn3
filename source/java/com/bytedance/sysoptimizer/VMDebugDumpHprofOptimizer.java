package com.bytedance.sysoptimizer;

import android.content.Context;

/* loaded from: classes5.dex */
public class VMDebugDumpHprofOptimizer {
    private static final String TAG = "VMDebugDump";
    private static boolean sOptimized;

    private static native boolean optimize();

    public static synchronized void fix(Context context) {
        synchronized (VMDebugDumpHprofOptimizer.class) {
            if (sOptimized) {
            }
        }
    }
}
