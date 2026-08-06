package com.ss.alive.monitor.reflect;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class FieldUtils {
    private static final Map<String, Field> sFieldMap = new HashMap();

    private static String getFiledKey(Class<?> cls, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString()).append("#").append(str);
        return sb.toString();
    }

    private static Field getFiledWithAccessible(Class<?> cls, String str) {
        Field field;
        Validate.throwsIfTrue(cls == null, "cls can not be null", new Object[0]);
        Validate.throwsIfTrue(TextUtils.isEmpty(str), "fieldName can not be null or empty", new Object[0]);
        String filedKey = getFiledKey(cls, str);
        Map<String, Field> map = sFieldMap;
        synchronized (map) {
            field = map.get(filedKey);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                if (!Modifier.isPublic(declaredField.getModifiers())) {
                    declaredField.setAccessible(true);
                }
                Map<String, Field> map2 = sFieldMap;
                synchronized (map2) {
                    continue;
                    map2.put(filedKey, declaredField);
                }
                return declaredField;
            } catch (Throwable unused) {
            }
        }
        List<Class<?>> interfacesOfClass = Utils.getInterfacesOfClass(cls);
        Field field2 = null;
        if (interfacesOfClass != null) {
            Iterator<Class<?>> it = interfacesOfClass.iterator();
            while (it.hasNext()) {
                try {
                    Field field3 = it.next().getField(str);
                    Validate.throwsIfTrue(field2 != null, "field %s on %s is ambiguous, more than one interface have the field", str, cls);
                    field2 = field3;
                } catch (Throwable unused2) {
                }
            }
        }
        Map<String, Field> map3 = sFieldMap;
        synchronized (map3) {
            if (field2 != null) {
                map3.put(filedKey, field2);
            }
        }
        return field2;
    }

    private static Object getField(Field field, Object obj, boolean z) throws IllegalAccessException {
        Validate.throwsIfTrue(field == null, "field can not be null", new Object[0]);
        if (z && !field.isAccessible()) {
            field.setAccessible(true);
        } else {
            MemberUtils.setMemberAccessible(field);
        }
        return field.get(obj);
    }

    private static void writeField(Field field, Object obj, Object obj2, boolean z) throws IllegalAccessException {
        Validate.throwsIfTrue(field == null, "field can not be null", new Object[0]);
        if (z && !field.isAccessible()) {
            field.setAccessible(true);
        } else {
            MemberUtils.setMemberAccessible(field);
        }
        field.set(obj, obj2);
    }

    public static Field getField(Class<?> cls, String str) {
        return getFiledWithAccessible(cls, str);
    }

    public static Object readField(Object obj, String str) throws IllegalAccessException {
        Validate.throwsIfTrue(obj == null, "target can not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field filedWithAccessible = getFiledWithAccessible(cls, str);
        Validate.throwsIfTrue(filedWithAccessible == null, "field: %s is null on %s", str, cls);
        return getField(filedWithAccessible, obj, false);
    }

    public static void writeField(Object obj, String str, Object obj2) throws IllegalAccessException {
        writeField(obj, str, obj2, true);
    }

    private static void writeField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        Validate.throwsIfTrue(obj == null, "target can not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field filedWithAccessible = getFiledWithAccessible(cls, str);
        Validate.throwsIfTrue(filedWithAccessible == null, "field: %s is null on %s", str, cls.getName());
        writeField(filedWithAccessible, obj, obj2, z);
    }
}
