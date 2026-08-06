package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;

/* loaded from: classes5.dex */
public class ClearCacheOpt {
    private static final String TAG = "ClearCacheOpt";
    private static boolean sOptimized;

    private static native boolean optimize();

    public static synchronized void fix(Context context) {
        synchronized (ClearCacheOpt.class) {
            if (sOptimized) {
                return;
            }
            if (Build.VERSION.SDK_INT == 24 && SysOptimizer.loadOptimizerLibrary(context)) {
                try {
                    Log.d(TAG, "opt ret = " + optimize());
                    optimize();
                    sOptimized = true;
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                }
            }
        }
    }
}
