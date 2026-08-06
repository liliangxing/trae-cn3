package com.bytedance.vmsdk.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class VmSdkServiceManager {
    private final Map<String, Object> mServiceInstanceMap;

    /* loaded from: classes6.dex */
    static class Holder {
        static final VmSdkServiceManager sInstance = new VmSdkServiceManager();

        Holder() {
        }
    }

    private VmSdkServiceManager() {
        this.mServiceInstanceMap = new ConcurrentHashMap();
    }

    public static VmSdkServiceManager getInstance() {
        return Holder.sInstance;
    }

    public <T extends IService> void registerService(Class<T> cls, T t) {
        if (cls == null || t == null) {
            return;
        }
        this.mServiceInstanceMap.put(cls.getName(), t);
    }

    public <T extends IService> T getService(Class<T> cls) {
        Object obj = this.mServiceInstanceMap.get(cls.getName());
        if (obj != null) {
            return (T) obj;
        }
        return null;
    }
}
