package com.bytedance.applog.util;

import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class ReflectUtils {
    public static Class<?> getClassByName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static boolean hasClass(String str) {
        return getClassByName(str) != null;
    }

    public static boolean isInstance(Object obj, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                Class<?> classByName = getClassByName(str);
                if (classByName != null && classByName.isInstance(obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Class<?> getCurrentClass(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                Class<?> classByName = getClassByName(str);
                if (classByName != null) {
                    return classByName;
                }
            }
        }
        return null;
    }

    public static Object getFieldValue(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void setFieldValue(Object obj, String str, Object obj2) {
        if (obj == null) {
            return;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (Throwable unused) {
        }
    }
}
