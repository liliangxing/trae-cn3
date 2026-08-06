package com.bytedance.sysoptimizer.perflock;

import android.os.Build;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public final class DoubleReflectUtils {
    private static final Map<String, Field> FIELD_CACHE = new HashMap();

    private DoubleReflectUtils() {
    }

    public static Constructor getConstructor(Class<?> cls, Class<?>... clsArr) throws Exception {
        Method declaredMethod;
        Constructor constructor = (Build.VERSION.SDK_INT < 29 || (declaredMethod = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class)) == null) ? null : (Constructor) declaredMethod.invoke(cls, clsArr);
        return constructor == null ? cls.getDeclaredConstructor(clsArr) : constructor;
    }

    public static boolean isAndroidPHigher() {
        return Build.VERSION.SDK_INT >= 28 || (Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0);
    }

    public static Field getFieldInner(Class<?> cls, String str) {
        try {
            Field field = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(cls, str);
            field.setAccessible(true);
            return field;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Method getMethodInner(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        try {
            Method method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class).invoke(cls, str, clsArr);
            method.setAccessible(true);
            return method;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Object readField(Object obj, String str) {
        try {
            return getField(obj.getClass(), str).get(obj);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Field getField(Class<?> cls, String str) {
        if (isAndroidPHigher()) {
            try {
                return getFieldInner(cls, str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return getRealField(cls, str);
    }

    private static String getKey(Class<?> cls, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString()).append("#").append(str);
        return sb.toString();
    }

    public static Field getRealField(Class<?> cls, String str) {
        Field field;
        String key = getKey(cls, str);
        Map<String, Field> map = FIELD_CACHE;
        synchronized (map) {
            field = map.get(key);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Map<String, Field> map2 = FIELD_CACHE;
                synchronized (map2) {
                    continue;
                    map2.put(key, declaredField);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }
}
