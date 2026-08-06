package com.lynx.tasm.behavior.utils;

import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class LynxUIMethodsCache {
    static HashMap<Class, HashMap<String, Method>> CLASS_METHODS_CACHE = new HashMap<>();

    public static HashMap<String, Method> getNativeMethodsForLynxUIClass(Class<? extends LynxBaseUI> cls) {
        if (cls == null) {
            return null;
        }
        return extractNativeMethodsForLynxUIClass(cls);
    }

    private static HashMap<String, Method> extractNativeMethodsForLynxUIClass(Class<?> cls) {
        if (CLASS_METHODS_CACHE.containsKey(cls)) {
            return CLASS_METHODS_CACHE.get(cls);
        }
        HashMap<String, Method> hashMap = new HashMap<>();
        for (Method method : cls.getDeclaredMethods()) {
            if (((LynxUIMethod) method.getAnnotation(LynxUIMethod.class)) != null) {
                hashMap.put(method.getName(), method);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            hashMap.putAll(extractNativeMethodsForLynxUIClass(superclass));
        }
        CLASS_METHODS_CACHE.put(cls, hashMap);
        return hashMap;
    }
}
