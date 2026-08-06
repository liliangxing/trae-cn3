package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes5.dex */
public class PIMutexOpt {
    public static native void nStart();

    public static void start(Context context) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
            nStart();
        }
    }
}
