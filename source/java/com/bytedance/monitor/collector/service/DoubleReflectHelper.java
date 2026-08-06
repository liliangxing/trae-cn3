package com.bytedance.monitor.collector.service;

import android.os.Build;
import com.bytedance.monitor.util.FieldUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class DoubleReflectHelper {
    private DoubleReflectHelper() {
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
        } catch (IllegalAccessException e) {
            e.printStackTrace();
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
        return FieldUtils.getField(cls, str);
    }
}
