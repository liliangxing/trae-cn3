package com.bytedance.sysoptimizer.heap;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class HeapExpandV2 {
    private static final int SHADOWHOOK_ERRNO_OK = 0;
    private static final int SHADOWHOOK_ERRNO_UNINIT = 2;
    private static final String TAG = "HeapExpand";
    private static final AtomicBoolean mInitFlag = new AtomicBoolean(false);

    private static native boolean applyNative(long j, boolean z, boolean z2);

    private static native boolean initNative();

    private static native boolean is64BitNative();

    private static native boolean triggerCopyGcNative();

    public static synchronized boolean apply(Context context, long j, boolean z, boolean z2) {
        synchronized (HeapExpandV2.class) {
            if (j <= 0) {
                Log.e(TAG, "invalid targetHeapSizeByte:" + j);
                return false;
            }
            AtomicBoolean atomicBoolean = mInitFlag;
            if (atomicBoolean.get()) {
                return true;
            }
            try {
                if (SysOptimizer.loadOptimizerLibrary(context)) {
                    int init = ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                    if (init != 0) {
                        Log.e(TAG, "shadowhook errno=" + init);
                        return false;
                    }
                    try {
                        if (!is64BitNative()) {
                            Log.e(TAG, "only support 64bit");
                            return false;
                        }
                        if (Build.VERSION.SDK_INT > 25) {
                            Log.e(TAG, "only support api 23-25(android 6.0-7.1.2)");
                            return false;
                        }
                        if (!initNative()) {
                            return false;
                        }
                        atomicBoolean.set(true);
                        return applyNative(j, z, z2);
                    } catch (Throwable th) {
                        Log.e(TAG, "apply fail", th);
                        return false;
                    }
                }
                Log.e(TAG, "load sysopt native lib fail.");
                return false;
            } catch (Throwable th2) {
                Log.e(TAG, "init shadowhook fail", th2);
                return false;
            }
        }
    }

    private static void triggerSuspendByPeer() {
        Thread thread = new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.heap.HeapExpandV2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Thread.sleep(5000L);
            }
        }, "suspend_stub");
        thread.start();
        thread.getStackTrace();
    }

    public static boolean triggerCopyGc() {
        Log.d(TAG, "triggerCopyGc");
        return triggerCopyGcNative();
    }
}
