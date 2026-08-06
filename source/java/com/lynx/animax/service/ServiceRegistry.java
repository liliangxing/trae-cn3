package com.lynx.animax.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class ServiceRegistry {
    private static final String TAG = "ServiceRegistry";
    private final Map<Class<? extends IAnimaXService>, IAnimaXService> mInstanceServices = new ConcurrentHashMap();
    private final ServiceScope mScope;

    public ServiceRegistry(ServiceScope serviceScope) {
        this.mScope = serviceScope;
    }

    public <T extends IAnimaXService> T getService(Class<T> cls) {
        IAnimaXService iAnimaXService = this.mInstanceServices.get(cls);
        if (iAnimaXService != null) {
            return cls.cast(iAnimaXService);
        }
        return (T) AnimaXServiceCenter.inst().getService(this.mScope, cls);
    }

    public <T extends IAnimaXService> void registerService(Class<T> cls, T t) {
        this.mInstanceServices.put(cls, t);
    }

    public <T extends IAnimaXService> void unregisterService(Class<T> cls) {
        this.mInstanceServices.remove(cls);
    }

    public void unregisterAllServices() {
        this.mInstanceServices.clear();
    }

    public void release() {
        unregisterAllServices();
    }
}
