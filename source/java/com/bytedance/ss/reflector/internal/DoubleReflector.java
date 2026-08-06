package com.bytedance.ss.reflector.internal;

import com.bytedance.ss.reflector.IReflector;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class DoubleReflector extends Reflector {
    private static final boolean sDebug = false;
    private Method mForNameMethod;
    private Method mGetDeclaredConstructorMethod;
    private Method mGetDeclaredFieldMethod;
    private Method mGetDeclaredMethod;

    /* loaded from: classes5.dex */
    private static class LazyHolder {
        private static final IReflector INSTANCE = new DoubleReflector();

        private LazyHolder() {
        }
    }

    public static IReflector getInstance() {
        return LazyHolder.INSTANCE;
    }

    private DoubleReflector() {
        try {
            this.mGetDeclaredConstructorMethod = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            this.mGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            this.mGetDeclaredFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            this.mForNameMethod = Class.class.getDeclaredMethod("forName", String.class);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // com.bytedance.ss.reflector.internal.Reflector, com.bytedance.ss.reflector.IReflector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Field getField(Class<?> cls, String str) throws NoSuchFieldException {
        Field field;
        Method method = this.mGetDeclaredFieldMethod;
        if (method != null) {
            try {
                field = (Field) method.invoke(cls, str);
            } catch (Exception unused) {
            }
            return field == null ? field : super.getField(cls, str);
        }
        field = null;
        if (field == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // com.bytedance.ss.reflector.internal.Reflector, com.bytedance.ss.reflector.IReflector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Method getMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method method;
        Method method2 = this.mGetDeclaredMethod;
        if (method2 != null) {
            try {
                method = (Method) method2.invoke(cls, str, clsArr);
            } catch (Exception unused) {
            }
            return method == null ? method : super.getMethod(cls, str, clsArr);
        }
        method = null;
        if (method == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // com.bytedance.ss.reflector.internal.Reflector, com.bytedance.ss.reflector.IReflector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Constructor getConstructor(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException {
        Constructor constructor;
        Method method = this.mGetDeclaredConstructorMethod;
        if (method != null) {
            try {
                constructor = (Constructor) method.invoke(cls, clsArr);
            } catch (Exception unused) {
            }
            return constructor == null ? constructor : super.getConstructor(cls, clsArr);
        }
        constructor = null;
        if (constructor == null) {
        }
    }

    @Override // com.bytedance.ss.reflector.internal.Reflector, com.bytedance.ss.reflector.IReflector
    public Class<?> getClass(String str) throws ClassNotFoundException {
        Method method = this.mForNameMethod;
        Class<?> cls = null;
        if (method != null) {
            try {
                cls = (Class) method.invoke(null, str);
            } catch (Exception unused) {
            }
        }
        return cls != null ? cls : super.getClass(str);
    }
}
