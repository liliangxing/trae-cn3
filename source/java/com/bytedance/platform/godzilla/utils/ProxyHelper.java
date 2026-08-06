package com.bytedance.platform.godzilla.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes4.dex */
public final class ProxyHelper {
    private ProxyHelper() {
    }

    public static Object createProxy(Object obj, InvocationHandler invocationHandler) {
        List<Class<?>> allInterfaces = getAllInterfaces(obj.getClass());
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), (allInterfaces == null || allInterfaces.size() <= 0) ? new Class[0] : (Class[]) allInterfaces.toArray(new Class[allInterfaces.size()]), invocationHandler);
    }

    private static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getAllInterfaces(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> hashSet) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    getAllInterfaces(cls2, hashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }
}
