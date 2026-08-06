package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes5.dex */
public class GetUidOpt {
    private static native void nStart(int i);

    public static void start(Context context, int i) {
        if (!SysOptimizer.loadOptimizerLibrary(context) || i < 0 || i > 2) {
            return;
        }
        if (i == 0) {
            ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
        } else {
            ByteHook.init();
        }
        nStart(i);
    }
}
