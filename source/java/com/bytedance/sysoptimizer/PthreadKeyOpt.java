package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes5.dex */
public class PthreadKeyOpt {
    private static native int nStart(int i, boolean z, String str);

    public static int start(Context context, int i, boolean z, String str) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return -1;
        }
        ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
        return nStart(i, z, str);
    }
}
