package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;
import com.bytedance.android.bytehook.ByteHook;

/* loaded from: classes5.dex */
public class AcodecHandler {
    private static final String TAG = "AcodecHandler";
    private static volatile boolean mInit;

    private static native void fixAcodecMessage();

    private static boolean inAndroid4x() {
        return false;
    }

    private static boolean inAndroid5x() {
        return false;
    }

    public static synchronized void fixAcodecMessage(Context context) {
        synchronized (AcodecHandler.class) {
            if ((inAndroid4x() || inAndroid5x()) && SysOptimizer.loadOptimizerLibrary(context)) {
                Log.i(TAG, "handlerAcodecMessage");
                ByteHook.init();
                fixAcodecMessage();
            }
        }
    }
}
