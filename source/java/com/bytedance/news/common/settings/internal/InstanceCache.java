package com.bytedance.news.common.settings.internal;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class InstanceCache {
    private static final ConcurrentHashMap<Class, Object> CACHE = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Class, Object> CACHE_LOCKS = new ConcurrentHashMap<>();

    public static <T> T obtain(Class<T> cls, InstanceCreator instanceCreator) {
        Object obj;
        Object obj2;
        ConcurrentHashMap<Class, Object> concurrentHashMap = CACHE;
        T t = (T) concurrentHashMap.get(cls);
        if (t == null) {
            ConcurrentHashMap<Class, Object> concurrentHashMap2 = CACHE_LOCKS;
            synchronized (concurrentHashMap2) {
                obj = concurrentHashMap2.containsKey(cls) ? concurrentHashMap2.get(cls) : null;
                if (obj == null) {
                    obj = new Object();
                    concurrentHashMap2.put(cls, obj);
                }
            }
            synchronized (obj) {
                Object obj3 = concurrentHashMap.get(cls);
                if (obj3 == null) {
                    obj2 = instanceCreator.create(cls);
                    if (obj2 != null) {
                        concurrentHashMap.put(cls, obj2);
                    }
                } else {
                    obj2 = obj3;
                }
            }
            return (T) obj2;
        }
        ConcurrentHashMap<Class, Object> concurrentHashMap3 = CACHE_LOCKS;
        if (!concurrentHashMap3.containsKey(cls)) {
            return t;
        }
        concurrentHashMap3.remove(cls);
        return t;
    }
}
