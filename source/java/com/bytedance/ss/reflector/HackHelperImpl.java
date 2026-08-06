package com.bytedance.ss.reflector;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class HackHelperImpl {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ReflectorHolder {
        private static final IReflector INSTANCE = ReflectorFactory.getReflector();

        private ReflectorHolder() {
        }
    }

    private static IReflector getReflector() {
        return ReflectorHolder.INSTANCE;
    }

    public static AccessibleObject toAccssible(AccessibleObject accessibleObject) {
        if (accessibleObject != null && !accessibleObject.isAccessible()) {
            accessibleObject.setAccessible(true);
        }
        return accessibleObject;
    }

    public static Field getField(Class<?> cls, String str) throws NoSuchFieldException {
        return (Field) toAccssible(getReflector().getField(cls, str));
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        return (Method) toAccssible(getReflector().getMethod(cls, str, clsArr));
    }

    public static Constructor getConstructor(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException {
        return (Constructor) toAccssible(getReflector().getConstructor(cls, clsArr));
    }

    public static Class<?> getClass(String str) throws ClassNotFoundException {
        return getReflector().getClass(str);
    }
}
