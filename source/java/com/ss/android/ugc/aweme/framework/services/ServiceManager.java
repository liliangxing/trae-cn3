package com.ss.android.ugc.aweme.framework.services;

import android.text.TextUtils;
import com.ss.android.ugc.aweme.framework.services.plugin.PluginInstaller;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class ServiceManager {
    public volatile boolean enableDynamicProxyDefault;
    final Set<String> legacyServiceSet;
    final Set<Class<?>> resolvedClasses;

    public void setDynamicProxyEnableDefault(boolean z) {
        this.enableDynamicProxyDefault = z;
    }

    public void addLegacyService(Set<String> set) {
        this.legacyServiceSet.addAll(set);
    }

    public void addLegacyService(String str) {
        this.legacyServiceSet.add(str);
    }

    public <T> T getService(Class<T> cls) {
        return (T) getService((Class) cls, false);
    }

    public <T> T getService(Class<T> cls, boolean z) {
        return (T) getService(cls, z, this.enableDynamicProxyDefault);
    }

    public <T> T getService(Class<T> cls, boolean z, boolean z2) {
        return (T) getService((Class) cls, z, z2, false);
    }

    public <T> T getService(Class<T> cls, boolean z, boolean z2, boolean z3) {
        boolean z4;
        T t;
        if (z3 || !DowngradeImplManager.getInstance().isServiceForceDowngrade(cls)) {
            z4 = false;
            t = null;
        } else {
            t = (T) DowngradeImplManager.getInstance().getDowngradeImpl(cls);
            if (t != null) {
                return t;
            }
            z4 = true;
        }
        if (!z) {
            t = (T) DynamicBindServiceManager.getDynamicService(cls);
        }
        if (t != null) {
            markResolved(cls);
            return t;
        }
        T t2 = (T) StaticServiceImplManager.getInstance().getStaticServiceImpl(cls);
        if (t2 != null) {
            markResolved(cls);
            return t2;
        }
        if (z3) {
            return null;
        }
        T t3 = (T) getLegacyService(cls);
        if (t3 != null) {
            markResolved(cls);
            return t3;
        }
        if (!z4) {
            t3 = (T) DowngradeImplManager.getInstance().getDowngradeImpl(cls);
        }
        if (t3 != null || !z2) {
            return t3;
        }
        new DynamicProxy();
        return (T) DynamicProxy.get(cls);
    }

    public <T> T getServiceForReal(Class<T> cls) {
        return (T) getService((Class) cls, false, this.enableDynamicProxyDefault, true);
    }

    public <T> T getService(Class<T> cls, String str) {
        return (T) getService((Class) cls, str, false);
    }

    public <T> T getService(Class<T> cls, String str, boolean z) {
        return (T) getService((Class) cls, str, z, true);
    }

    public <T> T getService(Class<T> cls, String str, boolean z, boolean z2) {
        boolean z3;
        T t;
        if (z2 || !DowngradeImplManager.getInstance().isServiceForceDowngrade(cls)) {
            z3 = false;
        } else {
            T t2 = (T) DowngradeImplManager.getInstance().getDowngradeImpl(cls);
            if (t2 != null) {
                return t2;
            }
            z3 = true;
        }
        if (!z && (t = (T) DynamicBindServiceManager.getDynamicService(cls, str)) != null) {
            return t;
        }
        Set<T> staticServiceImplSet = StaticServiceImplManager.getInstance().getStaticServiceImplSet(cls, str);
        if (staticServiceImplSet != null && !staticServiceImplSet.isEmpty()) {
            return (T) staticServiceImplSet.toArray()[0];
        }
        if (z2 || z3) {
            return null;
        }
        return (T) DowngradeImplManager.getInstance().getDowngradeImpl(cls);
    }

    public void markResolved(Class cls) {
        this.resolvedClasses.add(cls);
    }

    public <T> void bindDowngradeImpl(Class<T> cls, ServiceProvider<T> serviceProvider) {
        bindDowngradeImpl(cls, serviceProvider, true);
    }

    public <T> void bindDowngradeImpl(Class<T> cls, ServiceProvider<T> serviceProvider, boolean z) {
        if (z) {
            serviceProvider = new SingletonProvider(serviceProvider);
        }
        DowngradeImplManager.getInstance().bindDowngradeImpl(cls, serviceProvider);
    }

    public boolean downgradeComponent(String str) {
        return downgradeComponent(str, false);
    }

    public boolean downgradeComponent(String str, boolean z) {
        if (!z) {
            Map<String, String> map = DowngradeImplManager.getInstance().componentsMap;
            for (String str2 : map.keySet()) {
                if (this.resolvedClasses.contains(str2) && TextUtils.equals(map.get(str2), str)) {
                    return false;
                }
            }
        }
        DowngradeImplManager.getInstance().downgradeComponent(str);
        return true;
    }

    private <T> T getLegacyService(Class<T> cls) {
        if (!this.legacyServiceSet.contains(cls.getName())) {
            return null;
        }
        Iterator it = ConfigLoader.iterator(cls);
        if (it.hasNext()) {
            return (T) it.next();
        }
        return null;
    }

    public ConcurrentHashMap getServiceProviderMap() {
        return DynamicBindServiceManager.classServiceProviderConcurrentHashMap;
    }

    public <T> Set<T> getServices(Class<T> cls) {
        return getServices((Class) cls, false);
    }

    public <T> Set<T> getServices(Class<T> cls, boolean z) {
        Set<T> staticServiceImplSet;
        Set<T> dynamicServices = DynamicBindServiceManager.getDynamicServices(cls);
        if (dynamicServices == null || dynamicServices.isEmpty()) {
            Set<T> staticServiceImplSet2 = StaticServiceImplManager.getInstance().getStaticServiceImplSet(cls);
            return (staticServiceImplSet2 == null || staticServiceImplSet2.isEmpty()) ? getLegacyServices(cls) : staticServiceImplSet2;
        }
        if (z && (staticServiceImplSet = StaticServiceImplManager.getInstance().getStaticServiceImplSet(cls)) != null && !staticServiceImplSet.isEmpty()) {
            dynamicServices.addAll(staticServiceImplSet);
        }
        return dynamicServices;
    }

    public <T> Set<T> getServices(Class<T> cls, String str) {
        return getServices((Class) cls, str, false);
    }

    public <T> Set<T> getServices(Class<T> cls, String str, boolean z) {
        Set<T> staticServiceImplSet;
        Set<T> dynamicServices = DynamicBindServiceManager.getDynamicServices(cls, str);
        if (dynamicServices != null) {
            if (z && (staticServiceImplSet = StaticServiceImplManager.getInstance().getStaticServiceImplSet(cls, str)) != null && !staticServiceImplSet.isEmpty()) {
                dynamicServices.addAll(staticServiceImplSet);
            }
            return dynamicServices;
        }
        return StaticServiceImplManager.getInstance().getStaticServiceImplSet(cls, str);
    }

    public <T> Set<T> getServices(Class<T> cls, ServiceTypeFilter serviceTypeFilter) {
        return getServices((Class) cls, false, serviceTypeFilter);
    }

    public <T> Set<T> getServices(Class<T> cls, boolean z, ServiceTypeFilter serviceTypeFilter) {
        Set<T> staticServiceImplSet;
        Set<T> dynamicServices = DynamicBindServiceManager.getDynamicServices(cls, serviceTypeFilter);
        if (dynamicServices != null) {
            if (z && (staticServiceImplSet = StaticServiceImplManager.getInstance().getStaticServiceImplSet(cls, serviceTypeFilter)) != null && !staticServiceImplSet.isEmpty()) {
                dynamicServices.addAll(staticServiceImplSet);
            }
            if (dynamicServices.isEmpty()) {
                return null;
            }
            return dynamicServices;
        }
        return StaticServiceImplManager.getInstance().getStaticServiceImplSet(cls, serviceTypeFilter);
    }

    public <T> Set<T> getLegacyServices(Class<T> cls) {
        NavigableSet navigableSet = (Set<T>) Collections.synchronizedSet(new LinkedHashSet());
        if (!this.legacyServiceSet.contains(cls.getName())) {
            return navigableSet;
        }
        Iterator it = ConfigLoader.iterator(cls);
        while (it.hasNext()) {
            navigableSet.add(it.next());
        }
        return navigableSet;
    }

    public void onPluginInstall(String str) {
        PluginInstaller.INSTANCE.onPluginInstall(str);
    }

    public <T> Binding bind(Class<T> cls, ServiceProvider<T> serviceProvider) {
        return new Binding(cls, serviceProvider);
    }

    public <T> TypeServiceBinding bind(Class<T> cls, String str, ServiceProvider<T> serviceProvider) {
        return new TypeServiceBinding(cls, new String[]{str}, serviceProvider);
    }

    public <T> TypeServiceBinding bind(Class<T> cls, String[] strArr, ServiceProvider<T> serviceProvider) {
        return new TypeServiceBinding(cls, strArr, serviceProvider);
    }

    public static ServiceManager get() {
        return Holder.INSTANCE;
    }

    private ServiceManager() {
        this.legacyServiceSet = Collections.synchronizedSet(new HashSet());
        this.enableDynamicProxyDefault = true;
        this.resolvedClasses = Collections.synchronizedSet(new HashSet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Holder {
        private static final ServiceManager INSTANCE = new ServiceManager();

        private Holder() {
        }
    }
}
