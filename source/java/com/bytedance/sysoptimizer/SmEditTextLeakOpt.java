package com.bytedance.sysoptimizer;

import android.app.Application;
import android.os.Build;

/* loaded from: classes5.dex */
public class SmEditTextLeakOpt {
    public static final String SAMSUNG = "samsung";
    private static final String TAG = "com.bytedance.sysoptimizer.SmEditTextLeakOpt";

    public static void optimize(Application application) {
        try {
            "samsung".equalsIgnoreCase(Build.MANUFACTURER);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
