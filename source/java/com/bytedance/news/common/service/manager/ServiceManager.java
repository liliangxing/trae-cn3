package com.bytedance.news.common.service.manager;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class ServiceManager {
    public static final ConcurrentHashMap<Class, Object> SERVICES = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Class, ServiceCreator<?>> SERVICE_CREATORS = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Class, ServiceLoadListener> SERVICE_LOAD_LISTENERS = new ConcurrentHashMap<>();

    public static <T> T getService(Class<T> cls) {
        ConcurrentHashMap<Class, Object> concurrentHashMap = SERVICES;
        T t = (T) concurrentHashMap.get(cls);
        if (t == null) {
            synchronized (cls) {
                T t2 = (T) concurrentHashMap.get(cls);
                if (t2 != null) {
                    return t2;
                }
                ConcurrentHashMap<Class, ServiceCreator<?>> concurrentHashMap2 = SERVICE_CREATORS;
                ServiceCreator<?> serviceCreator = concurrentHashMap2.get(cls);
                if (serviceCreator != null) {
                    T t3 = (T) serviceCreator.create();
                    concurrentHashMap2.remove(cls);
                    if (t3 != null) {
                        putService(cls, t3);
                        return t3;
                    }
                }
                try {
                    T t4 = (T) ServiceFinder.findService(cls);
                    if (t4 != null) {
                        putService(cls, t4);
                        return t4;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                t = (T) tryGetByReflect(cls);
                if (t != null) {
                    putService(cls, t);
                    return t;
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

    private static <T> T tryGetByReflect(Class<T> cls) {
        try {
            Object newInstance = Class.forName(String.format("%s__ServiceProxy", cls.getName())).newInstance();
            if (newInstance instanceof IServiceProxy) {
                return (T) ((IServiceProxy) newInstance).newInstance();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
