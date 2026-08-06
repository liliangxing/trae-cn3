package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* loaded from: classes5.dex */
public class RenderNodeLeakFixer {
    private static boolean sInited;

    private static native void fixRenderNodeLeak();

    public static void fixAndroidN(Context context) {
        if (Build.VERSION.SDK_INT == 24 || Build.VERSION.SDK_INT == 25) {
            fix(context);
        }
    }

    public static void fix(Context context) {
        if (sInited) {
            return;
        }
        sInited = true;
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            fixRenderNodeLeak();
        }
    }
}
