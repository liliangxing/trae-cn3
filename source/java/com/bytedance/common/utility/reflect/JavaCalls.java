package com.bytedance.common.utility.reflect;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class JavaCalls {
    private static final String LOG_TAG = "JavaCalls";
    private static final Map<Class<?>, Class<?>> PRIMITIVE_MAP;

    static {
        HashMap hashMap = new HashMap();
        PRIMITIVE_MAP = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        hashMap.put(Byte.class, Byte.TYPE);
        hashMap.put(Character.class, Character.TYPE);
        hashMap.put(Short.class, Short.TYPE);
        hashMap.put(Integer.class, Integer.TYPE);
        hashMap.put(Float.class, Float.TYPE);
        hashMap.put(Long.class, Long.TYPE);
        hashMap.put(Double.class, Double.TYPE);
        hashMap.put(Boolean.TYPE, Boolean.TYPE);
        hashMap.put(Byte.TYPE, Byte.TYPE);
        hashMap.put(Character.TYPE, Character.TYPE);
        hashMap.put(Short.TYPE, Short.TYPE);
        hashMap.put(Integer.TYPE, Integer.TYPE);
        hashMap.put(Float.TYPE, Float.TYPE);
        hashMap.put(Long.TYPE, Long.TYPE);
        hashMap.put(Double.TYPE, Double.TYPE);
    }

    /* loaded from: classes3.dex */
    public static class JavaParam<T> {
        public final Class<? extends T> clazz;
        public final T obj;

        public JavaParam(Class<? extends T> cls, T t) {
            this.clazz = cls;
            this.obj = t;
        }
    }

    public static <T> T getField(Object obj, String str) {
        try {
            return (T) getFieldOrThrow(obj, str);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static <T> T getFieldOrThrow(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    public static void setField(Object obj, String str, Object obj2) {
        try {
            setFieldOrThrow(obj, str, obj2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    public static void setFieldOrThrow(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        field.set(obj, obj2);
    }

    public static <T> T callMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) callMethodOrThrow(obj, str, objArr);
        } catch (Exception e) {
            Log.w(LOG_TAG, "Meet exception when call Method '" + str + "' in " + obj, e);
            return null;
        }
    }

    public static <T> T callMethodOrThrow(Object obj, String str, Object... objArr) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return (T) getDeclaredMethod(obj.getClass(), str, getParameterTypes(objArr)).invoke(obj, getParameters(objArr));
    }

    public static <T> T callStaticMethod(String str, String str2, Object... objArr) {
        try {
            return (T) callStaticMethodOrThrow(Class.forName(str), str2, objArr);
        } catch (Exception e) {
            Log.w(LOG_TAG, "Meet exception when call Method '" + str2 + "' in " + str, e);
            return null;
        }
    }

    private static Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        Method findMethodByName = findMethodByName(cls.getDeclaredMethods(), str, clsArr);
        if (findMethodByName == null) {
            if (cls.getSuperclass() != null) {
                return getDeclaredMethod(cls.getSuperclass(), str, clsArr);
            }
            throw new NoSuchMethodException();
        }
        findMethodByName.setAccessible(true);
        return findMethodByName;
    }

    private static Method findMethodByName(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str) && compareClassLists(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    private static boolean compareClassLists(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            return clsArr.length == 0;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!clsArr[i].isAssignableFrom(clsArr2[i])) {
                Map<Class<?>, Class<?>> map = PRIMITIVE_MAP;
                if (!map.containsKey(clsArr[i]) || !map.get(clsArr[i]).equals(map.get(clsArr2[i]))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static <T> T callStaticMethodOrThrow(String str, String str2, Object... objArr) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        return (T) getDeclaredMethod(Class.forName(str), str2, getParameterTypes(objArr)).invoke(null, getParameters(objArr));
    }

    public static <T> T callStaticMethodOrThrow(Class<?> cls, String str, Object... objArr) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return (T) getDeclaredMethod(cls, str, getParameterTypes(objArr)).invoke(null, getParameters(objArr));
    }

    public static <T> T newInstance(Class<?> cls, Object... objArr) {
        try {
            return (T) newInstanceOrThrow(cls, objArr);
        } catch (Exception e) {
            Log.w(LOG_TAG, "Meet exception when make instance as a " + cls.getSimpleName(), e);
            return null;
        }
    }

    public static <T> T newEmptyInstance(Class<?> cls) {
        try {
            return (T) newEmptyInstanceOrThrow(cls);
        } catch (Exception e) {
            Log.w(LOG_TAG, "Meet exception when make instance as a " + cls.getSimpleName(), e);
            return null;
        }
    }

    public static <T> T newEmptyInstanceOrThrow(Class<?> cls) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors == null || declaredConstructors.length == 0) {
            throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
        }
        Constructor<?> constructor = declaredConstructors[0];
        constructor.setAccessible(true);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length == 0) {
            return (T) constructor.newInstance(new Object[0]);
        }
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            objArr[i] = getDefaultValue(parameterTypes[i]);
        }
        return (T) constructor.newInstance(objArr);
    }

    private static Object getDefaultValue(Class<?> cls) {
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls) || Byte.TYPE.equals(cls) || Byte.class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return 0;
        }
        if (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) {
            return false;
        }
        return (Character.TYPE.equals(cls) || Character.class.equals(cls)) ? (char) 0 : null;
    }

    public static <T> T newInstanceOrThrow(Class<?> cls, Object... objArr) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return (T) cls.getConstructor(getParameterTypes(objArr)).newInstance(getParameters(objArr));
    }

    public static Object newInstance(String str, Object... objArr) {
        try {
            return newInstanceOrThrow(str, objArr);
        } catch (Exception e) {
            Log.w(LOG_TAG, "Meet exception when make instance as a " + str, e);
            return null;
        }
    }

    public static Object newInstanceOrThrow(String str, Object... objArr) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        return newInstanceOrThrow(Class.forName(str), getParameters(objArr));
    }

    private static Class<?>[] getParameterTypes(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null && (obj instanceof JavaParam)) {
                clsArr[i] = ((JavaParam) obj).clazz;
            } else {
                clsArr[i] = obj == null ? null : obj.getClass();
            }
        }
        return clsArr;
    }

    private static Object[] getParameters(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null && (obj instanceof JavaParam)) {
                objArr2[i] = ((JavaParam) obj).obj;
            } else {
                objArr2[i] = obj;
            }
        }
        return objArr2;
    }
}
