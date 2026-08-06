package com.bytedance.platform.horae.common;

import android.text.TextUtils;
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
        Field declaredField;
        Class cls2 = (Class) Preconditions.checkNotNull(cls, "The class must not be null");
        Preconditions.checkTrue(!TextUtils.isEmpty(str), "The field name must not be blank");
        String key = getKey(cls2, str);
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
        while (cls2 != null) {
            try {
                if (OSUtil.isAndroidPHigher()) {
                    declaredField = DoubleReflectHelper.getField(cls2, str);
                    if (declaredField == null) {
                        declaredField = cls2.getDeclaredField(str);
                    }
                } else {
                    declaredField = cls2.getDeclaredField(str);
                }
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
                cls2 = cls2.getSuperclass();
            }
        }
        return null;
    }

    public static Object readField(Field field, Object obj) throws IllegalAccessException {
        Preconditions.checkArgument(field != null, "The field must not be null");
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        Field field2 = (Field) Preconditions.checkNotNull(field, "The field must not be null");
        if (!field2.isAccessible()) {
            field2.setAccessible(true);
        }
        field2.set(obj, obj2);
    }

    public static Object readField(Object obj, String str) throws IllegalAccessException {
        Object checkNotNull = Preconditions.checkNotNull(obj, "target object must not be null");
        Field field = getField(checkNotNull.getClass(), str);
        if (field != null) {
            return readField(field, checkNotNull);
        }
        return null;
    }

    public static void writeField(Object obj, String str, Object obj2) throws IllegalAccessException {
        Object checkNotNull = Preconditions.checkNotNull(obj, "target object must not be null");
        Field field = getField(checkNotNull.getClass(), str);
        if (field != null) {
            writeField(field, checkNotNull, obj2);
        }
    }

    public static Object readStaticField(Field field) throws IllegalAccessException {
        return readField((Field) Preconditions.checkNotNull(field, "The field must not be null"), (Object) null);
    }

    public static Object readStaticField(Class<?> cls, String str) throws IllegalAccessException {
        Field field = getField(cls, str);
        if (field != null) {
            return readStaticField(field);
        }
        return null;
    }

    public static void writeStaticField(Field field, Object obj) throws IllegalAccessException {
        writeField((Field) Preconditions.checkNotNull(field, "The field must not be null"), (Object) null, obj);
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        Field field = getField(cls, str);
        if (field != null) {
            writeStaticField(field, obj);
        }
    }
}
