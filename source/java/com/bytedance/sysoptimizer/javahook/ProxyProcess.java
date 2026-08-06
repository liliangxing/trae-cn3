package com.bytedance.sysoptimizer.javahook;

/* loaded from: classes5.dex */
public class ProxyProcess {
    private static final String TAG = "ProxyProcess";

    public static final void killProcess(int i) throws Throwable {
        AHook.getCallback().e(TAG, "killProcess() called with: pid = [" + i + "]", new Throwable());
        AHook.callOrigin(OriginMethodKey.KEY_PROCESS_KILLPROCESS, null, Integer.valueOf(i));
    }
}
