package com.ss.alive.monitor.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class MethodUtils {
    private static final Map<String, Method> sMethodMap = new HashMap();

    private static String getMethodKey(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString()).append("#").append(str);
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.toString()).append("#");
            }
        } else {
            sb.append(Void.class.toString());
        }
        return sb.toString();
    }

    private static Method getMethodFromSuperclass(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (Modifier.isPublic(superclass.getModifiers())) {
                try {
                    return superclass.getMethod(str, clsArr);
                } catch (Throwable unused) {
                    return null;
                }
            }
        }
        return null;
    }

    private static Method getMethodFromInterfaces(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (Modifier.isPublic(interfaces[i].getModifiers())) {
                    try {
                        return interfaces[i].getDeclaredMethod(str, clsArr);
                    } catch (Throwable unused) {
                        Method methodFromInterfaces = getMethodFromInterfaces(interfaces[i], str, clsArr);
                        if (methodFromInterfaces != null) {
                            return methodFromInterfaces;
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static Method getMethod(Method method) {
        if (!MemberUtils.isMemberAccessible(method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (Modifier.isPublic(declaringClass.getModifiers())) {
            return method;
        }
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Method methodFromInterfaces = getMethodFromInterfaces(declaringClass, name, parameterTypes);
        return methodFromInterfaces == null ? getMethodFromSuperclass(declaringClass, name, parameterTypes) : methodFromInterfaces;
    }

    public static Method getMethodWithAccessible(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method method;
        String methodKey = getMethodKey(cls, str, clsArr);
        Map<String, Method> map = sMethodMap;
        synchronized (map) {
            method = map.get(methodKey);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        Method method2 = getMethod(cls.getMethod(str, clsArr));
        synchronized (map) {
            if (method2 != null) {
                map.put(methodKey, method2);
            }
        }
        return method2;
    }

    private static Method getMatchMethodWithAccessible(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Method method2;
        String methodKey = getMethodKey(cls, str, clsArr);
        Map<String, Method> map = sMethodMap;
        synchronized (map) {
            method = map.get(methodKey);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method method3 = cls.getMethod(str, clsArr);
            MemberUtils.setMemberAccessible(method3);
            synchronized (map) {
                map.put(methodKey, method3);
            }
            return method3;
        } catch (Throwable unused) {
            Method method4 = null;
            for (Method method5 : cls.getMethods()) {
                if (method5.getName().equals(str) && MemberUtils.isAssignableWithAutoBoxing(clsArr, method5.getParameterTypes()) && (method2 = getMethod(method5)) != null && (method4 == null || MemberUtils.compareCost(method2.getParameterTypes(), method4.getParameterTypes(), clsArr) < 0)) {
                    method4 = method2;
                }
            }
            if (method4 != null) {
                MemberUtils.setMemberAccessible(method4);
            }
            Map<String, Method> map2 = sMethodMap;
            synchronized (map2) {
                if (method4 != null) {
                    map2.put(methodKey, method4);
                }
                return method4;
            }
        }
    }

    private static Object invokeMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] ensureClassArrayNotNull = Utils.ensureClassArrayNotNull(clsArr);
        Object[] ensureObjectArrayNoNull = Utils.ensureObjectArrayNoNull(objArr);
        Method matchMethodWithAccessible = getMatchMethodWithAccessible(cls, str, ensureClassArrayNotNull);
        if (matchMethodWithAccessible == null) {
            throw new NoSuchMethodException("no method: " + str + "() accessible on object: " + cls.getName());
        }
        return matchMethodWithAccessible.invoke(null, ensureObjectArrayNoNull);
    }

    public static Object invokeMethod(Class cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] ensureObjectArrayNoNull = Utils.ensureObjectArrayNoNull(objArr);
        return invokeMethod(cls, str, ensureObjectArrayNoNull, Utils.objectsToClassArray(ensureObjectArrayNoNull));
    }
}
