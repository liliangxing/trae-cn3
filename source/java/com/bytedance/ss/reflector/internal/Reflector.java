package com.bytedance.ss.reflector.internal;

import com.bytedance.ss.reflector.IReflector;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class Reflector implements IReflector {

    /* loaded from: classes5.dex */
    private static class LazyHolder {
        private static final IReflector INSTANCE = new Reflector();

        private LazyHolder() {
        }
    }

    public static IReflector getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override // com.bytedance.ss.reflector.IReflector
    public Field getField(Class<?> cls, String str) throws NoSuchFieldException {
        return cls.getDeclaredField(str);
    }

    @Override // com.bytedance.ss.reflector.IReflector
    public Method getMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        return cls.getDeclaredMethod(str, clsArr);
    }

    @Override // com.bytedance.ss.reflector.IReflector
    public Constructor getConstructor(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException {
        return cls.getDeclaredConstructor(clsArr);
    }

    @Override // com.bytedance.ss.reflector.IReflector
    public Class<?> getClass(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }
}
