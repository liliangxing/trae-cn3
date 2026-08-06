package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.android.SystemUtils;

/* loaded from: classes5.dex */
public class EglCreateSurfaceFixer {
    private static final String TAG = "NJitCompileOptimizer";
    private static boolean sInited;

    private static native void fix(int i);

    public static synchronized void fixHuawei(Context context, int i) {
        synchronized (EglCreateSurfaceFixer.class) {
            if ((Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27) && (Build.MANUFACTURER.equalsIgnoreCase(SystemUtils.PRODUCT_HUAWEI) || Build.MANUFACTURER.equalsIgnoreCase("HONOR"))) {
                fix(context, i);
            }
        }
    }

    public static synchronized void fixOsOP(Context context, int i) {
        synchronized (EglCreateSurfaceFixer.class) {
            if (Build.VERSION.SDK_INT >= 26 && Build.VERSION.SDK_INT <= 28) {
                fix(context, i);
            }
        }
    }

    public static synchronized void fix(Context context, int i) {
        synchronized (EglCreateSurfaceFixer.class) {
            if (sInited) {
                return;
            }
            sInited = true;
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                fix(i);
            }
        }
    }
}
