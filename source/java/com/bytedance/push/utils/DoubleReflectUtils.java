package com.bytedance.push.utils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class DoubleReflectUtils {
    private static final String TAG = "DoubleReflector";
    private static Class<?>[] TYPES;
    private static final Map<Class<?>, Class<?>> boxing2PrimitiveMap;
    private static Method mForNameMethod;
    private static Method mGetDeclaredConstructorMethod;
    private static Method mGetDeclaredFieldMethod;
    private static Method mGetDeclaredMethod;
    private static Method mGetDeclaredMethods;
    private static final Map<Class<?>, Class<?>> primitive2BoxingMap;
    private static final HashMap<String, Method> methodCacheMap = new HashMap<>();
    public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];

    static {
        HashMap hashMap = new HashMap();
        primitive2BoxingMap = hashMap;
        boxing2PrimitiveMap = new HashMap();
        TYPES = new Class[]{Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
        try {
            mGetDeclaredFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            mGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            mGetDeclaredMethods = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);
            mGetDeclaredConstructorMethod = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            mForNameMethod = Class.class.getDeclaredMethod("forName", String.class);
            hashMap.put(Boolean.TYPE, Boolean.class);
            hashMap.put(Byte.TYPE, Byte.class);
            hashMap.put(Character.TYPE, Character.class);
            hashMap.put(Short.TYPE, Short.class);
            hashMap.put(Integer.TYPE, Integer.class);
            hashMap.put(Long.TYPE, Long.class);
            hashMap.put(Double.TYPE, Double.class);
            hashMap.put(Float.TYPE, Float.class);
            hashMap.put(Void.TYPE, Void.TYPE);
            for (Map.Entry entry : hashMap.entrySet()) {
                Class<?> cls = (Class) entry.getKey();
                Class<?> cls2 = (Class) entry.getValue();
                if (!cls.equals(cls2)) {
                    boxing2PrimitiveMap.put(cls2, cls);
                }
            }
        } catch (Throwable th) {
            com.bytedance.common.utility.Logger.e(TAG, "DoubleReflectorinit failed", th);
        }
    }

    public static Field getAccessibleField(Class<?> cls, String str) {
        return (Field) toAccessible(getField(cls, str));
    }

    public static Object getFieldValue(Object obj, String str) {
        try {
            Field accessibleField = getAccessibleField(obj.getClass(), str);
            if (accessibleField != null) {
                return accessibleField.get(obj);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Field getField(Class<?> cls, String str) {
        checkNotNull(cls, "The class must not be null !!!");
        Method method = mGetDeclaredFieldMethod;
        if (method != null) {
            try {
                return (Field) method.invoke(cls, str);
            } catch (Throwable th) {
                com.bytedance.common.utility.Logger.e(TAG, TAG + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            }
        }
        return null;
    }

    public static Field getFieldAll(Class<?> cls, String str) {
        checkNotNull(cls, "The class must not be null !!!");
        while (cls != null) {
            try {
                return (Field) mGetDeclaredFieldMethod.invoke(cls, str);
            } catch (Throwable th) {
                com.bytedance.common.utility.Logger.e(TAG, "DoubleReflectorgetFieldAll failed", th);
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static boolean setFieldValue(Object obj, String str, Object obj2) {
        try {
            Field field = getField(obj.getClass(), str);
            field.setAccessible(true);
            field.set(obj, obj2);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static <T extends AccessibleObject> T toAccessible(T t) {
        if (t != null && !t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        return (Method) toAccessible(getMethod(cls, str, clsArr));
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        checkNotNull(cls, "The class must not be null !!!");
        Method method = mGetDeclaredMethod;
        if (method != null) {
            try {
                return (Method) method.invoke(cls, str, clsArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Method[] getMethods(Class<?> cls) {
        checkNotNull(cls, "The class must not be null !!!");
        Method method = mGetDeclaredMethods;
        if (method != null) {
            try {
                return (Method[]) method.invoke(cls, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.common.utility.Logger.e(TAG, TAG + String.format("getMethods %s#%s failed !!!", cls.getName()), th);
            }
        }
        return null;
    }

    public static Constructor getConstructor(Class<?> cls, Class<?>... clsArr) {
        checkNotNull(cls, "The class must not be null !!!");
        Method method = mGetDeclaredConstructorMethod;
        if (method != null) {
            try {
                return (Constructor) method.invoke(cls, clsArr);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder(TAG);
                Object[] objArr = new Object[2];
                objArr[0] = cls.getName();
                objArr[1] = Integer.valueOf(clsArr != null ? clsArr.length : 0);
                com.bytedance.common.utility.Logger.e(TAG, sb.append(String.format("getConstructor %s<init>%s failed !!!", objArr)).toString(), th);
            }
        }
        return null;
    }

    public static Class<?> getClass(String str) {
        checkNotNull(str, "The class name can not be null !!!");
        Method method = mForNameMethod;
        if (method == null) {
            return null;
        }
        try {
            return (Class) method.invoke(null, str);
        } catch (Throwable th) {
            com.bytedance.common.utility.Logger.e(TAG, TAG + String.format("getClass %s failed !!!", str), th);
            return null;
        }
    }

    private static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(str);
    }

    public static Object callInstanceMethod(Object obj, String str, Object... objArr) {
        try {
            return findBestMatchMethod(obj.getClass(), str, objArr).invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new IllegalStateException(e3.getCause());
        }
    }

    private static Method findBestMatchMethodFromCache(String str) {
        HashMap<String, Method> hashMap = methodCacheMap;
        if (!hashMap.containsKey(str)) {
            return null;
        }
        Method method = hashMap.get(str);
        if (method != null) {
            return method;
        }
        throw new NoSuchMethodError(str);
    }

    private static Method findExactMethodAndPutToCache(String str, Class<?> cls, String str2, Class<?>... clsArr) {
        try {
            Method findExactMethod = findExactMethod(cls, str2, clsArr);
            methodCacheMap.put(str, findExactMethod);
            return findExactMethod;
        } catch (NoSuchMethodError unused) {
            return null;
        }
    }

    private static Method tryFindBestMatchMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method method = null;
        boolean z = true;
        while (true) {
            for (Method method2 : getMethods(cls)) {
                if ((z || !Modifier.isPrivate(method2.getModifiers())) && method2.getName().equals(str) && isAssignableWithAutoBoxing(clsArr, method2.getParameterTypes()) && (method == null || compareCost(method2.getParameterTypes(), method.getParameterTypes(), clsArr) < 0)) {
                    method = method2;
                }
            }
            cls = cls.getSuperclass();
            if (cls == null) {
                return method;
            }
            z = false;
        }
    }

    public static Method findBestMatchMethod(Class<?> cls, String str, Class<?>... clsArr) {
        String str2 = cls.getName() + '#' + str + getParametersString(clsArr) + "#best";
        Method findBestMatchMethodFromCache = findBestMatchMethodFromCache(str2);
        if (findBestMatchMethodFromCache != null) {
            return findBestMatchMethodFromCache;
        }
        Method findExactMethodAndPutToCache = findExactMethodAndPutToCache(str2, cls, str, clsArr);
        if (findExactMethodAndPutToCache != null) {
            return findExactMethodAndPutToCache;
        }
        Method tryFindBestMatchMethod = tryFindBestMatchMethod(cls, str, clsArr);
        if (tryFindBestMatchMethod != null) {
            tryFindBestMatchMethod.setAccessible(true);
            methodCacheMap.put(str2, tryFindBestMatchMethod);
            return tryFindBestMatchMethod;
        }
        NoSuchMethodError noSuchMethodError = new NoSuchMethodError(str2);
        methodCacheMap.put(str2, null);
        throw noSuchMethodError;
    }

    private static Method findBestMatchMethod(Class<?> cls, String str, Object... objArr) {
        return findBestMatchMethod(cls, str, getParameterTypes(objArr));
    }

    private static Class<?>[] getParameterTypes(Object... objArr) {
        if (objArr == null) {
            return EMPTY_CLASS_ARRAY;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj != null ? obj.getClass() : null;
        }
        return clsArr;
    }

    private static Method findExactMethod(Class<?> cls, String str, Class<?>... clsArr) {
        String str2 = cls.getName() + '#' + str + getParametersString(clsArr) + "#exact";
        HashMap<String, Method> hashMap = methodCacheMap;
        if (hashMap.containsKey(str2)) {
            Method method = hashMap.get(str2);
            if (method != null) {
                return method;
            }
            throw new NoSuchMethodError(str2);
        }
        Method method2 = getMethod(cls, str, clsArr);
        method2.setAccessible(true);
        hashMap.put(str2, method2);
        return method2;
    }

    private static String getParametersString(Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder("(");
        boolean z = true;
        for (Class<?> cls : clsArr) {
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            if (cls != null) {
                sb.append(cls.getCanonicalName());
            } else {
                sb.append("null");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public static boolean isAssignableWithAutoBoxing(Class<?> cls, Class<?> cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z) {
            if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = primitive2Boxing(cls)) == null) {
                return false;
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = boxing2Primitive(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (cls.isPrimitive()) {
            if (!cls2.isPrimitive()) {
                return false;
            }
            if (Integer.TYPE.equals(cls)) {
                return Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            if (Long.TYPE.equals(cls)) {
                return Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
                return false;
            }
            if (Float.TYPE.equals(cls)) {
                return Double.TYPE.equals(cls2);
            }
            if (Character.TYPE.equals(cls)) {
                return Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            if (Short.TYPE.equals(cls)) {
                return Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            if (Byte.TYPE.equals(cls)) {
                return Short.TYPE.equals(cls2) || Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            return false;
        }
        return cls2.isAssignableFrom(cls);
    }

    public static boolean isAssignableWithAutoBoxing(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (!isSameLength(clsArr, clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_ARRAY;
        }
        if (clsArr2 == null) {
            clsArr2 = EMPTY_CLASS_ARRAY;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!isAssignableWithAutoBoxing(clsArr[i], clsArr2[i], true)) {
                return false;
            }
        }
        return true;
    }

    public static Class<?> primitive2Boxing(Class<?> cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : primitive2BoxingMap.get(cls);
    }

    public static Class<?> boxing2Primitive(Class<?> cls) {
        return boxing2PrimitiveMap.get(cls);
    }

    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        return (objArr != null || objArr2 == null || objArr2.length <= 0) && (objArr2 != null || objArr == null || objArr.length <= 0) && (objArr == null || objArr2 == null || objArr.length == objArr2.length);
    }

    private static int compareCost(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        return Float.compare(getTransformCost(clsArr3, clsArr), getTransformCost(clsArr3, clsArr2));
    }

    private static float getTransformCost(Class<?>[] clsArr, Class<?>[] clsArr2) {
        int length = clsArr.length;
        float f = 0.0f;
        for (int i = 0; i < length; i++) {
            f += getTransformCost(clsArr[i], clsArr2[i]);
        }
        return f;
    }

    private static float getTransformCost(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return getPrimitiveCost(cls, cls2);
        }
        float f = 0.0f;
        while (true) {
            if (cls != null && !cls2.equals(cls)) {
                if (cls2.isInterface() && isAssignableWithAutoBoxing(cls, cls2, true)) {
                    f += 0.25f;
                    break;
                }
                f += 1.0f;
                cls = cls.getSuperclass();
            } else {
                break;
            }
        }
        return cls == null ? f + 1.5f : f;
    }

    private static float getPrimitiveCost(Class<?> cls, Class<?> cls2) {
        float f;
        if (cls.isPrimitive()) {
            f = 0.0f;
        } else {
            cls = boxing2Primitive(cls);
            f = 0.1f;
        }
        int i = 0;
        while (cls != cls2) {
            Class<?>[] clsArr = TYPES;
            if (i >= clsArr.length) {
                break;
            }
            if (cls == clsArr[i]) {
                f += 0.1f;
                if (i < clsArr.length - 1) {
                    cls = clsArr[i + 1];
                }
            }
            i++;
        }
        return f;
    }
}
