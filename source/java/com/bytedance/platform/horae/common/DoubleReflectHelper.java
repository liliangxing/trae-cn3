package com.bytedance.platform.horae.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class DoubleReflectHelper {
    private DoubleReflectHelper() {
    }

    public static Field getField(Class<?> cls, String str) {
        if (OSUtil.isAndroidPHigher()) {
            try {
                return DoubleReflectTool.getField(cls, str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return FieldUtils.getField(cls, str);
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (OSUtil.isAndroidPHigher()) {
            try {
                return DoubleReflectTool.getMethod(cls, str, clsArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        return MethodUtils.getAccessibleMethod(cls, str, clsArr);
    }
}
