package com.bytedance.pia.core.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes4.dex */
public class ReflectUtils {
    public static Class<?> getTypeArgument(Object obj, Class<?> cls, int i) {
        ParameterizedType parameterizedType;
        if (obj == null || cls == null || i < 0 || !cls.isInstance(obj)) {
            return null;
        }
        try {
            Type[] genericInterfaces = obj.getClass().getGenericInterfaces();
            int length = genericInterfaces.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    parameterizedType = null;
                    break;
                }
                Type type = genericInterfaces[i2];
                if ((type instanceof ParameterizedType) && ((ParameterizedType) type).getRawType() == cls) {
                    parameterizedType = (ParameterizedType) type;
                    break;
                }
                i2++;
            }
            if (parameterizedType == null) {
                Type genericSuperclass = obj.getClass().getGenericSuperclass();
                if ((genericSuperclass instanceof ParameterizedType) && ((ParameterizedType) genericSuperclass).getRawType() == cls) {
                    parameterizedType = (ParameterizedType) genericSuperclass;
                }
            }
        } catch (Throwable unused) {
        }
        if (parameterizedType == null) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i < actualTypeArguments.length) {
            return (Class) actualTypeArguments[i];
        }
        return null;
    }

    public static Class<?> getTypeArgument(Object obj, Class<?> cls) {
        return getTypeArgument(obj, cls, 0);
    }
}
