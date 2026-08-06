package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.android.bytehook.ByteHook;

/* loaded from: classes5.dex */
public class JitCodeCacheShrinker {
    private static String TAG = "OPTIMIZER-JitCodeCacheShrinker";
    private static boolean mOptimized;

    private static native boolean native_shrink(int i, int i2);

    private static boolean loadOptimizerOnNeed(Context context) {
        return SysOptimizer.loadOptimizerLibrary(context);
    }

    public static synchronized void shrink(Context context, int i) {
        synchronized (JitCodeCacheShrinker.class) {
            if (Build.VERSION.SDK_INT >= 29 && Build.VERSION.SDK_INT <= 33) {
                if (mOptimized) {
                    return;
                }
                if (loadOptimizerOnNeed(context)) {
                    try {
                        ByteHook.init();
                        mOptimized = native_shrink(Build.VERSION.SDK_INT, i);
                    } catch (UnsatisfiedLinkError e) {
                        Log.e(TAG, "UnsatisfiedLinkError", e);
                    }
                }
            }
        }
    }
}
