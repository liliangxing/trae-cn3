package com.bytedance.ss.reflector;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public interface IReflector {
    Class<?> getClass(String str) throws ClassNotFoundException;

    Constructor getConstructor(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException;

    Field getField(Class<?> cls, String str) throws NoSuchFieldException;

    Method getMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException;
}
