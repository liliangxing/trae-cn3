package com.bytedance.bdinstall.service;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class ServiceManager {
    private static HashMap<Class, HashMap<String, ?>> gServices;
    public static final ConcurrentHashMap<String, ServiceManager> sManagerMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Class, Object> sServices = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Class, ServiceCreator> sServiceCreators = new ConcurrentHashMap<>();

    public static <T> T getService(Class<T> cls, String str) {
        ServiceManager serviceManager = sManagerMap.get(str);
        if (serviceManager != null) {
            return (T) serviceManager.sServices.get(cls);
        }
        return null;
    }

    public static <T> void registerService(Class<T> cls, T t, String str) {
        ConcurrentHashMap<String, ServiceManager> concurrentHashMap = sManagerMap;
        ServiceManager serviceManager = concurrentHashMap.get(str);
        if (serviceManager == null) {
            serviceManager = new ServiceManager();
            concurrentHashMap.put(str, serviceManager);
        }
        serviceManager.sServices.put(cls, t);
    }

    public static synchronized <T> void unregisterService(Class<T> cls, T t, String str) {
        synchronized (ServiceManager.class) {
            HashMap<Class, HashMap<String, ?>> hashMap = gServices;
            if (hashMap != null && t != null) {
                HashMap<String, ?> hashMap2 = hashMap.get(cls);
                if (hashMap2 != null) {
                    hashMap2.remove(str);
                }
            }
        }
    }
}
