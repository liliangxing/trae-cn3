package com.ss.android.ug.bus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class UgBusFramework {
    private static Map<Class, IUgBusService> serviceHashMap = new ConcurrentHashMap();

    public static <T extends IUgBusService> void registerService(Class<T> cls, IUgBusService iUgBusService) {
        if (iUgBusService != null) {
            serviceHashMap.put(cls, iUgBusService);
        }
    }

    public static <T extends IUgBusService> void unregisterService(Class<T> cls) {
        serviceHashMap.remove(cls);
    }

    public static <T extends IUgBusService> T getService(Class<T> cls) {
        return (T) serviceHashMap.get(cls);
    }
}
