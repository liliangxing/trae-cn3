package com.bytedance.mt.protector.impl;

import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.ThrowableDisposerResult;

/* loaded from: classes4.dex */
public class BaseProtector<T> {
    private static Class[] typeClasses = {Byte.class, Double.class, Float.class, Integer.class, Long.class, Short.class, String.class};

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> T tryProtect(ProtectorType protectorType, Throwable th, Class<?> cls) {
        ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(protectorType, th);
        if (disposeThrowable == null) {
            return null;
        }
        T t = (T) disposeThrowable.getResult();
        if (isReturnMatch(t, cls)) {
            return t;
        }
        return null;
    }

    private static boolean isReturnMatch(Object obj, Class<?> cls) {
        for (Class<?> cls2 : typeClasses) {
            if (cls2.isInstance(obj) && cls == cls2) {
                return true;
            }
        }
        return false;
    }
}
