package com.bytedance.monitor.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class FieldUtils {
    private static final Map<String, Field> FIELD_CACHE = new HashMap();

    private FieldUtils() {
    }

    private static String getKey(Class<?> cls, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString()).append("#").append(str);
        return sb.toString();
    }

    public static Field getField(Class<?> cls, String str) {
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

    public static Object readField(Field field, Object obj) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        field.set(obj, obj2);
    }

    public static Object readField(Object obj, String str) throws IllegalAccessException {
        Field field = getField(obj.getClass(), str);
        if (field != null) {
            return readField(field, obj);
        }
        return null;
    }

    public static void writeField(Object obj, String str, Object obj2) throws IllegalAccessException {
        Field field = getField(obj.getClass(), str);
        if (field != null) {
            writeField(field, obj, obj2);
        }
    }

    public static Object readStaticField(Field field) throws IllegalAccessException {
        return readField(field, (Object) null);
    }

    public static Object readStaticField(Class<?> cls, String str) throws IllegalAccessException {
        Field field = getField(cls, str);
        if (field != null) {
            return readStaticField(field);
        }
        return null;
    }

    public static void writeStaticField(Field field, Object obj) throws IllegalAccessException {
        writeField(field, (Object) null, obj);
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        Field field = getField(cls, str);
        if (field != null) {
            writeStaticField(field, obj);
        }
    }
}
