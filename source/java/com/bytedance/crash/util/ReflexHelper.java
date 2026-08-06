package com.bytedance.crash.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class ReflexHelper {
    public static Field getField(String str, String str2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object getObject(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int getStaticInt(String str, String str2) throws Exception {
        return Class.forName(str).getField(str2).getInt(null);
    }

    public static Object getStaticObject(String str, String str2) throws Exception {
        return Class.forName(str).getField(str2).get(null);
    }

    public static Method getMethod(String str, String str2, Class<?>... clsArr) throws Exception {
        return Class.forName(str).getMethod(str2, clsArr);
    }

    public static Method getMethod(Object obj, String str, Class<?>... clsArr) throws Exception {
        return obj.getClass().getMethod(str, clsArr);
    }
}
