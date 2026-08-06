package com.bytedance.sysoptimizer.fd;

import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class DefaultFdSetExpandHelper {
    private static final String TAG = "DefaultFdSetExpand";

    public static boolean applyJavaCryptoExpandFdSet() {
        return true;
    }

    private static native boolean hookJniMethods(Method method, Method method2, Method method3);

    private static native boolean hookLibc();

    private static native boolean hookQtiBoostFramework();

    public static boolean applyLibcExpand() {
        return hookLibc();
    }

    public static boolean applyQtiBoostFrameworkExpand() {
        return hookQtiBoostFramework();
    }
}
