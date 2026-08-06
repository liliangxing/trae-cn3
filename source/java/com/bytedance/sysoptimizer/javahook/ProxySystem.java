package com.bytedance.sysoptimizer.javahook;

/* loaded from: classes5.dex */
public class ProxySystem {
    private static final String TAG = "ProxySystem";

    public static void exit(int i) throws Throwable {
        AHook.getCallback().e(TAG, "exit() called with: status = [" + i + "]", new Throwable());
        AHook.callOrigin(OriginMethodKey.KEY_SYSTEM_EXIT, null, Integer.valueOf(i));
    }
}
