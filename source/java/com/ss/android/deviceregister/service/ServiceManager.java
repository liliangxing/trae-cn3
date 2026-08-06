package com.ss.android.deviceregister.service;

import android.util.Log;
import com.ss.android.deviceregister.INewUserModeManager;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class ServiceManager {
    private static final String TAG = "ServiceManager ";
    private static final ConcurrentHashMap<Class, Object> sServices = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Class, ServiceCreator> sServiceCreators = new ConcurrentHashMap<>();

    public static <T> void registerService(Class<T> cls, T t) {
        ConcurrentHashMap<Class, Object> concurrentHashMap = sServices;
        if (concurrentHashMap.containsKey(INewUserModeManager.class)) {
            return;
        }
        concurrentHashMap.put(cls, t);
        Log.d(TAG, "register service: " + cls.getName());
    }

    public static <T> T getService(Class<T> cls) {
        ConcurrentHashMap<Class, ServiceCreator> concurrentHashMap;
        ServiceCreator serviceCreator;
        ConcurrentHashMap<Class, Object> concurrentHashMap2 = sServices;
        Object obj = (T) concurrentHashMap2.get(cls);
        if (obj == null) {
            synchronized (concurrentHashMap2) {
                obj = concurrentHashMap2.get(cls);
                if (obj == null && (serviceCreator = (concurrentHashMap = sServiceCreators).get(cls)) != null) {
                    obj = (T) serviceCreator.create(cls);
                    if (obj != null) {
                        concurrentHashMap2.put(cls, obj);
                    }
                    concurrentHashMap.remove(cls);
                    Log.d(TAG, "create service: " + cls.getName());
                }
            }
        }
        return (T) obj;
    }

    public static <T> void unregisterService(Class<T> cls, T t) {
        sServices.remove(cls, t);
    }
}
