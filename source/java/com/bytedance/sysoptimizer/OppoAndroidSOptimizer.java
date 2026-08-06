package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import java.util.Locale;

/* loaded from: classes5.dex */
public class OppoAndroidSOptimizer {
    private static final String TAG = "OppoAndroidSOptimizer";
    private static boolean sOptimized;

    private static native void optimizeConfigOplusVppType();

    private static native void optimizeInitAudioSchedBoost();

    public static synchronized void fix(Context context, boolean z, boolean z2) {
        synchronized (OppoAndroidSOptimizer.class) {
            if (z || z2) {
                if (sOptimized) {
                    return;
                }
                if (Build.VERSION.SDK_INT == 31 || Build.VERSION.SDK_INT == 32) {
                    String lowerCase = Build.BRAND.toLowerCase(Locale.ROOT);
                    if (lowerCase.contains("oppo") || lowerCase.contains("realme")) {
                        if (Process.is64Bit()) {
                            if (SysOptimizer.loadOptimizerLibrary(context)) {
                                if (z) {
                                    try {
                                        try {
                                            optimizeInitAudioSchedBoost();
                                        } catch (NoSuchMethodError e) {
                                            Log.e(TAG, "NoSuchMethodError", e);
                                        }
                                    } catch (UnsatisfiedLinkError e2) {
                                        Log.e(TAG, "UnsatisfiedLinkError", e2);
                                    }
                                }
                                if (z2) {
                                    optimizeConfigOplusVppType();
                                }
                                sOptimized = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
