package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.android.bytehook.ByteHook;

/* loaded from: classes5.dex */
public class ACodecGetPortFormatOptimizer {
    private static native void aCodecGetPortFormatOptimizer();

    private static native void aCodecGetPortFormatOptimizerByByteCode();

    public static void fixACodecGetPortFormat(Context context) {
        if (isUnderAndroidPAndAboveM() && SysOptimizer.loadOptimizerLibrary(context)) {
            ByteHook.init();
            aCodecGetPortFormatOptimizer();
            aCodecGetPortFormatOptimizerByByteCode();
        }
    }

    private static boolean isUnderAndroidPAndAboveM() {
        return Build.VERSION.SDK_INT < 28;
    }
}
