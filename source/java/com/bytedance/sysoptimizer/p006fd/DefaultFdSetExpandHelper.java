package com.bytedance.sysoptimizer.p006fd;

import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
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
