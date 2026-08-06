package com.bytedance.platform.godzilla.utils;

import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class MethodUtils {
    private static final HashMap<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_MAP;
    private static Map<String, Method> sMethodCache = new HashMap();

    static {
        HashMap<Class<?>, Class<?>> hashMap = new HashMap<>();
        PRIMITIVE_TO_WRAPPER_MAP = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        hashMap.put(Byte.TYPE, Byte.class);
        hashMap.put(Character.TYPE, Character.class);
        hashMap.put(Short.TYPE, Short.class);
        hashMap.put(Integer.TYPE, Integer.class);
        hashMap.put(Long.TYPE, Long.class);
        hashMap.put(Double.TYPE, Double.class);
        hashMap.put(Float.TYPE, Float.class);
        hashMap.put(Void.TYPE, Void.class);
    }

    private MethodUtils() {
    }

    private static String getCachedKey(Class<?> cls, String str, Class... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString()).append("#").append(str);
        if (clsArr != null && clsArr.length > 0) {
            for (Class cls2 : clsArr) {
                sb.append(cls2.toString()).append("#");
            }
        } else {
            sb.append(Void.class.toString());
        }
        return sb.toString();
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class... clsArr) {
        Method method;
        Method[] declaredMethods;
        Preconditions.checkNotNull(cls, "The class must not be null");
        Preconditions.checkTrue(!TextUtils.isEmpty(str), "The method name must not be blank");
        String cachedKey = getCachedKey(cls, str, clsArr);
        synchronized (sMethodCache) {
            method = sMethodCache.get(cachedKey);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        while (cls != null) {
            try {
                if (OSUtil.isAndroidPHigher() && HackHelper.getInstance() != null) {
                    method = HackHelper.getInstance().getMethod(cls, str, clsArr);
                    if (method == null) {
                        method = cls.getDeclaredMethod(str, clsArr);
                    }
                } else {
                    method = cls.getDeclaredMethod(str, clsArr);
                }
            } catch (NoSuchMethodException unused) {
            }
            if (method == null && (declaredMethods = cls.getDeclaredMethods()) != null) {
                for (Method method2 : declaredMethods) {
                    if (method2 != null && TextUtils.equals(method2.getName(), str)) {
                        Class<?>[] parameterTypes = method2.getParameterTypes();
                        if (clsArr != null && clsArr.length == parameterTypes.length) {
                            boolean z = true;
                            for (int i = 0; i < clsArr.length; i++) {
                                if (!isAssignableFrom(clsArr[i], parameterTypes[i])) {
                                    z = false;
                                }
                            }
                            if (z) {
                                method = method2;
                            }
                        }
                    }
                }
            }
            if (method != null) {
                method.setAccessible(true);
                synchronized (sMethodCache) {
                    sMethodCache.put(cachedKey, method);
                }
                return method;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static boolean isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            cls = PRIMITIVE_TO_WRAPPER_MAP.get(cls);
        }
        if (cls2.isPrimitive() && !cls.isPrimitive()) {
            cls2 = PRIMITIVE_TO_WRAPPER_MAP.get(cls2);
        }
        return cls2.isAssignableFrom(cls);
    }

    private static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] nullToEmpty = GUtils.nullToEmpty(clsArr);
        Object[] nullToEmpty2 = GUtils.nullToEmpty(objArr);
        Method accessibleMethod = getAccessibleMethod(cls, str, nullToEmpty);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(null, nullToEmpty2);
        }
        return null;
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = GUtils.nullToEmpty(objArr);
        return invokeStaticMethod(cls, str, nullToEmpty, GUtils.toClass(nullToEmpty));
    }
}
