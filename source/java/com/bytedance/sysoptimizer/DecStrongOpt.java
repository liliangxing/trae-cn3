package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes5.dex */
public class DecStrongOpt {
    private static native int nStart();

    public static int start(Context context) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return -1;
        }
        ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
        return nStart();
    }
}
