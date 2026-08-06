package com.lynx.tasm.service;

import android.app.Application;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class LynxServiceCenter {
    private static final String TAG = "LynxServiceCenter";
    private static volatile LynxServiceCenter instance;
    private Application context;
    private final Map<Class<?>, ServiceHolder> serviceMap = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class ServiceHolder {
        boolean initialized;
        final IServiceProvider service;

        ServiceHolder(IServiceProvider iServiceProvider) {
            this(iServiceProvider, false);
        }

        ServiceHolder(IServiceProvider iServiceProvider, boolean z) {
            this.service = iServiceProvider;
            this.initialized = z;
        }
    }

    private LynxServiceCenter() {
    }

    public static LynxServiceCenter inst() {
        if (instance == null) {
            synchronized (LynxServiceCenter.class) {
                if (instance == null) {
                    instance = new LynxServiceCenter();
                }
            }
        }
        return instance;
    }

    public <T extends IServiceProvider> T getService(Class<T> cls) {
        ServiceHolder serviceHolder = this.serviceMap.get(cls);
        if (serviceHolder == null) {
            return null;
        }
        if (!serviceHolder.initialized) {
            Log.w(TAG, "Service " + cls + " hasn't been initialized");
            return null;
        }
        return (T) serviceHolder.service;
    }

    @Deprecated
    public <T extends IServiceProvider> void registerService(Class<? extends T> cls, T t) {
        if (!cls.isInstance(t)) {
            Log.e(TAG, "Incorrect service type: " + cls.getSimpleName());
            return;
        }
        ServiceHolder serviceHolder = new ServiceHolder(t);
        if (this.context != null) {
            serviceHolder.initialized = true;
            serviceHolder.service.onInitialize(this.context);
        }
        this.serviceMap.put(cls, serviceHolder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends IServiceProvider> void registerService(T t) {
        registerService(t.getServiceClass(), t);
    }

    public void unregisterService(Class<? extends IServiceProvider> cls) {
        this.serviceMap.remove(cls);
    }

    public void unregisterAllService() {
        this.serviceMap.clear();
    }

    public void initialize(Application application) {
        this.context = application;
        synchronized (ServiceHolder.class) {
            Iterator<Map.Entry<Class<?>, ServiceHolder>> it = this.serviceMap.entrySet().iterator();
            while (it.hasNext()) {
                ServiceHolder value = it.next().getValue();
                if (!value.initialized) {
                    value.initialized = true;
                    value.service.onInitialize(application);
                }
            }
        }
    }
}
