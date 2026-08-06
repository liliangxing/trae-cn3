package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* loaded from: classes5.dex */
public class TextureViewOptimizer {
    private static String TAG = "TextureViewOptimizer";
    private static Handler mMainLooperHandler = new Handler(Looper.getMainLooper());
    private static boolean mOptimized;

    private static native boolean optimize(int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void pushLayerNative(long j, long j2);

    private TextureViewOptimizer() {
    }

    private static boolean loadOptimizerOnNeed(Context context) {
        if (Build.VERSION.SDK_INT < 26 || Build.VERSION.SDK_INT > 33) {
            return false;
        }
        return SysOptimizer.loadOptimizerLibrary(context);
    }

    public static boolean optimize(Context context) {
        return optimize(context, true);
    }

    public static synchronized boolean optimize(Context context, boolean z) {
        synchronized (TextureViewOptimizer.class) {
            if (mOptimized) {
                return true;
            }
            if (loadOptimizerOnNeed(context)) {
                try {
                    boolean optimize = optimize(Build.VERSION.SDK_INT, z);
                    mOptimized = optimize;
                    return optimize;
                } catch (Throwable th) {
                    Log.e(TAG, "failed to optimize: ", th);
                }
            }
            return false;
        }
    }

    private static boolean postOnUiThread(final long j, final long j2) {
        final Object obj = new Object();
        synchronized (obj) {
            mMainLooperHandler.post(new Runnable() { // from class: com.bytedance.sysoptimizer.TextureViewOptimizer.1
                @Override // java.lang.Runnable
                public void run() {
                    TextureViewOptimizer.pushLayerNative(j, j2);
                    synchronized (obj) {
                        obj.notify();
                    }
                }
            });
            try {
                obj.wait();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return true;
    }
}
