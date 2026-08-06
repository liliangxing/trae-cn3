package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import java.util.Locale;

/* loaded from: classes5.dex */
public class MTKArcDispatcherOptimizer {
    private static final String TAG = "OppoMTKArcDispatcher";
    private static boolean sOptimized;

    private static native void banMTKArcDispatcher();

    public static void fix(Context context) {
        if (Build.VERSION.SDK_INT == 28 && !sOptimized && Build.BRAND.toLowerCase(Locale.ROOT).contains("oppo") && Process.is64Bit() && SysOptimizer.loadOptimizerLibrary(context)) {
            try {
                banMTKArcDispatcher();
                sOptimized = true;
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
    }
}
