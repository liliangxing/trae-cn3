package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;

/* loaded from: classes5.dex */
public class VivoPerfFrameInfoManagerImplOptimizer {
    private static final String TAG = "VivoPerfDebugDump";
    private static boolean sOptimized;

    private static native boolean optimize();

    public static synchronized void fix(Context context) {
        synchronized (VivoPerfFrameInfoManagerImplOptimizer.class) {
            if (sOptimized) {
                return;
            }
            String trim = Build.MODEL.toLowerCase().trim();
            if (Build.VERSION.SDK_INT >= 27 && ((trim.contains("vivo") || trim.contains("oppo")) && SysOptimizer.loadOptimizerLibrary(context))) {
                try {
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
