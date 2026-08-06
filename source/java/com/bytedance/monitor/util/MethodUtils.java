package com.bytedance.monitor.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class MethodUtils {
    private static Map<String, Method> sMethodCache = new HashMap();

    private static Method getAccessibleMethodFromSuperclass(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (Modifier.isPublic(superclass.getModifiers())) {
                try {
                    return superclass.getMethod(str, clsArr);
                } catch (Exception unused) {
                    return null;
                }
            }
        }
        return null;
    }

    private static String getKey(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString());
        sb.append("#");
        sb.append(str);
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.toString()).append("#");
            }
        } else {
            sb.append(Void.class.toString());
        }
        return sb.toString();
    }

    private static Method getAccessibleMethodFromInterfaces(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            Class<?>[] interfaces = cls.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                if (Modifier.isPublic(interfaces[i].getModifiers())) {
                    try {
                        return interfaces[i].getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                        Method accessibleMethodFromInterfaces = getAccessibleMethodFromInterfaces(interfaces[i], str, clsArr);
                        if (accessibleMethodFromInterfaces != null) {
                            return accessibleMethodFromInterfaces;
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static Method getAccessibleMethod(Method method) {
        if (!MemberUtils.isAccessible(method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (Modifier.isPublic(declaringClass.getModifiers())) {
            return method;
        }
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Method accessibleMethodFromInterfaces = getAccessibleMethodFromInterfaces(declaringClass, name, parameterTypes);
        return accessibleMethodFromInterfaces == null ? getAccessibleMethodFromSuperclass(declaringClass, name, parameterTypes) : accessibleMethodFromInterfaces;
    }

    private static Method getCacheMethod(String str) {
        Method method;
        synchronized (sMethodCache) {
            method = sMethodCache.get(str);
        }
        if (method == null) {
            return null;
        }
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        return method;
    }

    private static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        String key = getKey(cls, str, clsArr);
        Method cacheMethod = getCacheMethod(key);
        if (cacheMethod != null) {
            return cacheMethod;
        }
        try {
            Method method = cls.getMethod(str, clsArr);
            MemberUtils.setAccessible(method);
            synchronized (sMethodCache) {
                sMethodCache.put(key, method);
            }
            return method;
        } catch (NoSuchMethodException unused) {
            return getBestMatchMethod(cls, key, str, clsArr);
        }
    }

    private static Method getBestMatchMethod(Class<?> cls, String str, String str2, Class<?>... clsArr) {
        Method accessibleMethod;
        Method method = null;
        for (Method method2 : cls.getMethods()) {
            if (method2.getName().equals(str2) && MemberUtils.isAssignable(clsArr, method2.getParameterTypes(), true) && (accessibleMethod = getAccessibleMethod(method2)) != null && (method == null || MemberUtils.compareParameterTypes(accessibleMethod.getParameterTypes(), method.getParameterTypes(), clsArr) < 0)) {
                method = accessibleMethod;
            }
        }
        if (method != null) {
            MemberUtils.setAccessible(method);
        }
        synchronized (sMethodCache) {
            sMethodCache.put(str, method);
        }
        return method;
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeStaticMethod(cls, str, InnerUtils.nullToEmpty(objArr), InnerUtils.toClass(objArr));
    }

    public static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, clsArr);
        if (matchingAccessibleMethod == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + cls.getName());
        }
        return matchingAccessibleMethod.invoke(null, InnerUtils.nullToEmpty(objArr));
    }
}
