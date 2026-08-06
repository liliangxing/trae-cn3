package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;

/* loaded from: classes5.dex */
public class ONativeCryptoCRLOptimizer {
    private static final String TAG = "NativeCrypt";
    private static boolean sOptimized;

    private static native boolean optimize();

    public static synchronized void fix(Context context) {
        synchronized (ONativeCryptoCRLOptimizer.class) {
            if (sOptimized) {
                return;
            }
            if ((Build.VERSION.SDK_INT == 27 || Build.VERSION.SDK_INT == 26) && SysOptimizer.loadOptimizerLibrary(context)) {
                try {
                    if (optimize()) {
                        Log.e(TAG, "hook succ");
                    } else {
                        Log.e(TAG, "hook fail");
                    }
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
