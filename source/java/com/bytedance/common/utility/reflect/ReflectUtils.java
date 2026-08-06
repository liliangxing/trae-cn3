package com.bytedance.common.utility.reflect;

import java.lang.reflect.Method;

@Deprecated
/* loaded from: classes3.dex */
public final class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    private ReflectUtils() {
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        return com.bytedance.android.standard.tools.reflect.ReflectUtils.getMethod(cls, str, clsArr);
    }

    public static Object invokeMethod(Class<?> cls, String str, Object... objArr) {
        return com.bytedance.android.standard.tools.reflect.ReflectUtils.invokeMethod(cls, str, objArr);
    }

    public static Object invokeMethod(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr, Object... objArr2) {
        return com.bytedance.android.standard.tools.reflect.ReflectUtils.invokeMethod(cls, str, clsArr, objArr, objArr2);
    }

    public static Object getFiledValue(Object obj, Class<?> cls) {
        return com.bytedance.android.standard.tools.reflect.ReflectUtils.getFiledValue(obj, cls);
    }
}
