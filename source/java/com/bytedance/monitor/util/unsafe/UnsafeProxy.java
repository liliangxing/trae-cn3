package com.bytedance.monitor.util.unsafe;

import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class UnsafeProxy {
    private static Object sUnsafe;
    private static Class sUnsafeClass;
    private static ReflectUtils sUtils;

    static {
        try {
            sUtils = ReflectUtils.getInstance();
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            sUnsafeClass = cls;
            sUnsafe = sUtils.getUnsafe(cls);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static long objectFieldOffset(Field field) {
        Object invokeMethod = sUtils.invokeMethod(sUtils.getMethod(sUnsafeClass, "objectFieldOffset", Field.class), sUnsafe, field);
        if (invokeMethod == null) {
            return 0L;
        }
        return ((Long) invokeMethod).longValue();
    }

    public static long putObject(Object obj, long j, Object obj2) {
        Object invokeMethod = sUtils.invokeMethod(sUtils.getMethod(sUnsafeClass, "putObject", Object.class, Long.TYPE, Object.class), sUnsafe, obj, Long.valueOf(j), obj2);
        if (invokeMethod == null) {
            return 0L;
        }
        return ((Long) invokeMethod).longValue();
    }
}
