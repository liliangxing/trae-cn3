package com.bytedance.apm6.service;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class ServiceManager {
    private static final ConcurrentHashMap<Class, Object> SERVICES = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Class, ServiceCreator<?>> SERVICE_CREATORS = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Class, ServiceLoadListener> SERVICE_LOAD_LISTENERS = new ConcurrentHashMap<>();

    public static <T> T getService(Class<T> cls) {
        T t = (T) SERVICES.get(cls);
        if (t == null) {
            synchronized (ServiceManager.class) {
                ConcurrentHashMap<Class, ServiceCreator<?>> concurrentHashMap = SERVICE_CREATORS;
                ServiceCreator<?> serviceCreator = concurrentHashMap.get(cls);
                if (serviceCreator != null) {
                    t = (T) serviceCreator.create();
                    concurrentHashMap.remove(cls);
                    if (t != null) {
                        putService(cls, t);
                        return t;
                    }
                }
            }
        }
        return t;
    }

    public static <T> void registerService(Class<T> cls, T t) {
        SERVICES.put(cls, t);
    }

    public static <T> void registerService(Class<T> cls, ServiceCreator<T> serviceCreator) {
        SERVICE_CREATORS.put(cls, serviceCreator);
    }

    public static <T> void unregisterService(Class<T> cls, T t) {
        SERVICES.remove(cls, t);
    }

    public static <T> void registerServiceLoadListener(Class<T> cls, ServiceLoadListener<T> serviceLoadListener) {
        SERVICE_LOAD_LISTENERS.put(cls, serviceLoadListener);
    }

    private static <T> void putService(Class<T> cls, T t) {
        SERVICES.put(cls, t);
        ConcurrentHashMap<Class, ServiceLoadListener> concurrentHashMap = SERVICE_LOAD_LISTENERS;
        ServiceLoadListener serviceLoadListener = concurrentHashMap.get(cls);
        if (serviceLoadListener != null) {
            serviceLoadListener.onServiceLoaded(t);
            concurrentHashMap.remove(cls);
        }
    }
}
