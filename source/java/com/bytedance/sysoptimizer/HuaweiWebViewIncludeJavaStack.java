package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.android.bytehook.ByteHook;

/* loaded from: classes5.dex */
public class HuaweiWebViewIncludeJavaStack {
    private static native int nStart();

    public static int start(Context context) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return -1;
        }
        ByteHook.init();
        return nStart();
    }
}
