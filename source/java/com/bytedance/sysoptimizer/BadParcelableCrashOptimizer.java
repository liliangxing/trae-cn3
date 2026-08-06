package com.bytedance.sysoptimizer;

import android.content.Context;

/* loaded from: classes5.dex */
public class BadParcelableCrashOptimizer {
    private static Context sContext;

    public static void fix(Context context) {
        sContext = context;
    }

    public static Context getContext() {
        return sContext;
    }
}
