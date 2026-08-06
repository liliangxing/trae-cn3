package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes5.dex */
public class SuspendByPeerOptV0 {
    private static native int nStart(boolean z);

    public static int start(Context context, boolean z) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return -1;
        }
        ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
        int nStart = nStart(z);
        if (z) {
            mockTimeout();
        }
        return nStart;
    }

    private static void mockTimeout() {
        Thread thread = new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.SuspendByPeerOptV0.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    Thread.currentThread().setName("world");
                    Thread.getAllStackTraces();
                }
            }
        });
        thread.start();
        thread.setName("hello");
    }
}
