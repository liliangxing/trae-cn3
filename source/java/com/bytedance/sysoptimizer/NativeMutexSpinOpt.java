package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes5.dex */
public class NativeMutexSpinOpt {
    private static native void nStart(int i, int i2, int i3);

    public static void start(Context context, int i, int i2) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
            nStart(i, i2, Build.VERSION.SDK_INT);
        }
    }
}
