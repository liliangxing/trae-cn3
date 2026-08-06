package com.lynx.animax.service;

import com.lynx.animax.util.AnimaXLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class AnimaXServiceCenter {
    private static final String[] AUTO_REGISTER_SERVICE_CLASS_NAMES = {"com.lynx.animax.service.AnimaXFrescoImageService", "com.lynx.animax.monitor.common.AnimaXCommonMonitorService"};
    private static final String TAG = "AnimaXServiceCenter";
    private static volatile AnimaXServiceCenter sInstance;
    private final Map<ServiceScope, Map<Class<? extends IAnimaXService>, IAnimaXService>> mScopedServices = new ConcurrentHashMap();

    private AnimaXServiceCenter() {
        createScope(ServiceScope.DEFAULT);
        registerServicesReflective();
    }

    private void registerServicesReflective() {
        for (String str : AUTO_REGISTER_SERVICE_CLASS_NAMES) {
            try {
                Class<?> cls = Class.forName(str);
                if (!IAutoRegisterAnimaXService.class.isAssignableFrom(cls)) {
                    AnimaXLog.w(TAG, "Class " + str + " does not implement IAutoRegisterAnimaXService");
                } else {
                    IAutoRegisterAnimaXService iAutoRegisterAnimaXService = (IAutoRegisterAnimaXService) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    registerServiceInner(iAutoRegisterAnimaXService.getAutoRegisterServiceScope(), iAutoRegisterAnimaXService.getServiceClass(), iAutoRegisterAnimaXService);
                }
            } catch (Exception e) {
                AnimaXLog.e(TAG, "Failed to auto-register service " + str + ": " + e.toString());
            }
        }
    }

    public static AnimaXServiceCenter inst() {
        if (sInstance == null) {
            synchronized (AnimaXServiceCenter.class) {
                if (sInstance == null) {
                    sInstance = new AnimaXServiceCenter();
                }
            }
        }
        return sInstance;
    }

    public <T extends IAnimaXService> T getService(Class<T> cls) {
        return (T) getService(ServiceScope.DEFAULT, cls);
    }

    public <T extends IAnimaXService> T getService(ServiceScope serviceScope, Class<T> cls) {
        Map<Class<? extends IAnimaXService>, IAnimaXService> map = this.mScopedServices.get(serviceScope);
        if (map == null || !map.containsKey(cls)) {
            return null;
        }
        return (T) map.get(cls);
    }

    public <T extends IAnimaXService> void registerService(ServiceScope serviceScope, Class<T> cls, T t) {
        registerServiceInner(serviceScope, cls, t);
    }

    public <T extends IAnimaXService> void registerService(Class<T> cls, T t) {
        registerService(ServiceScope.DEFAULT, cls, t);
    }

    private void registerServiceInner(ServiceScope serviceScope, Class<? extends IAnimaXService> cls, IAnimaXService iAnimaXService) {
        Map<Class<? extends IAnimaXService>, IAnimaXService> map = this.mScopedServices.get(serviceScope);
        if (map == null) {
            map = createScope(serviceScope);
        }
        boolean containsKey = map.containsKey(cls);
        if (!containsKey) {
            map.put(cls, iAnimaXService);
        }
        AnimaXLog.i(TAG, String.format("Register service %s with instance %s in scope %s, result: %s", cls.getSimpleName(), iAnimaXService, serviceScope, Boolean.valueOf(!containsKey)));
    }

    public <T extends IAnimaXService> void unregisterService(Class<T> cls) {
        unregisterService(ServiceScope.DEFAULT, cls);
    }

    public <T extends IAnimaXService> void unregisterService(ServiceScope serviceScope, Class<T> cls) {
        Map<Class<? extends IAnimaXService>, IAnimaXService> map = this.mScopedServices.get(serviceScope);
        if (map != null) {
            map.remove(cls);
        }
    }

    public void unregisterAllServices() {
        unregisterAllServices(ServiceScope.DEFAULT);
    }

    public void unregisterAllServices(ServiceScope serviceScope) {
        Map<Class<? extends IAnimaXService>, IAnimaXService> map = this.mScopedServices.get(serviceScope);
        if (map != null) {
            map.clear();
        }
    }

    private Map<Class<? extends IAnimaXService>, IAnimaXService> createScope(ServiceScope serviceScope) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.mScopedServices.put(serviceScope, concurrentHashMap);
        return concurrentHashMap;
    }
}
