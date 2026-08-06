package com.bytedance.platform.settingsx.internal;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class InstanceCache {
    private static final ConcurrentHashMap<Class, Object> CACHE = new ConcurrentHashMap<>();

    public static <T> T obtain(Class<T> cls, InstanceCreator instanceCreator) {
        ConcurrentHashMap<Class, Object> concurrentHashMap = CACHE;
        Object obj = (T) concurrentHashMap.get(cls);
        if (obj == null) {
            synchronized (InstanceCache.class) {
                obj = concurrentHashMap.get(cls);
                if (obj == null) {
                    Object create = instanceCreator.create(cls);
                    if (create != null) {
                        concurrentHashMap.put(cls, create);
                    }
                    obj = (T) create;
                }
            }
        }
        return (T) obj;
    }
}
