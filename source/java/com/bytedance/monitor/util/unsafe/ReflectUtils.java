package com.bytedance.monitor.util.unsafe;

import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class ReflectUtils {
    private static ReflectUtils sInstance;

    private ReflectUtils() {
    }

    public static ReflectUtils getInstance() {
        if (sInstance == null) {
            sInstance = new ReflectUtils();
        }
        return sInstance;
    }

    public Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method declaredMethod;
        try {
            if (clsArr != null) {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            } else {
                declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            }
            return declaredMethod;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invokeStaticMethod(Method method, Object... objArr) {
        return invokeMethod(method, null, objArr);
    }

    public Object invokeMethod(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object getUnsafe(Class<?> cls) {
        return invokeStaticMethod(getMethod(cls, "getUnsafe", new Class[0]), new Object[0]);
    }
}
