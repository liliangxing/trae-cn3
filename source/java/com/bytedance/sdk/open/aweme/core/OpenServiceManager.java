package com.bytedance.sdk.open.aweme.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class OpenServiceManager {
    private static final String TAG = "OpenServiceManager";
    private final Map<String, Object> serviceInstanceMap;

    /* loaded from: classes5.dex */
    static class b {
        static final OpenServiceManager a = new OpenServiceManager();

        b() {
        }
    }

    private OpenServiceManager() {
        this.serviceInstanceMap = new ConcurrentHashMap();
    }

    public static OpenServiceManager getInst() {
        return b.a;
    }

    public <T extends IOpenService> T getService(Class<T> cls) {
        Object obj;
        if (cls != null && (obj = this.serviceInstanceMap.get(cls.getName())) != null) {
            try {
                return (T) obj;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public <T extends IOpenService> void registerService(Class<T> cls, T t) {
        if (cls == null || t == null) {
            return;
        }
        this.serviceInstanceMap.put(cls.getName(), t);
    }
}
