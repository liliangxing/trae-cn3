package com.bytedance.sysoptimizer.javahook;

import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class ProxyClass {
    private static final String TAG = "ProxyClass";

    private Method getMethod(String str, Class<?>[] clsArr, boolean z) throws NoSuchMethodException {
        Log.d(TAG, "getMethod() called with: name = [" + str + "], parameterTypes = [" + clsArr + "], recursivePublicMethods = [" + z + "]");
        try {
            return (Method) AHook.callOrigin("getMethod(Ljava/lang/String;[Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", this, str, clsArr, Boolean.valueOf(z));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
