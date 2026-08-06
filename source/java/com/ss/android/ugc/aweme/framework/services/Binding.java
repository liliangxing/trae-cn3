package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes7.dex */
public final class Binding<T> {
    Class<T> klass;
    ServiceProvider<T> serviceProvider;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Binding(Class<T> cls, ServiceProvider<T> serviceProvider) {
        this.klass = cls;
        this.serviceProvider = serviceProvider;
        Set<ServiceProvider<?>> set = DynamicBindServiceManager.classServiceProviderConcurrentHashMap.get(cls);
        if (set == null) {
            Set<ServiceProvider<?>> synchronizedSet = Collections.synchronizedSet(new LinkedHashSet());
            synchronizedSet.add(serviceProvider);
            DynamicBindServiceManager.classServiceProviderConcurrentHashMap.put(cls, synchronizedSet);
            return;
        }
        set.add(serviceProvider);
    }

    public Binding<T> asSingleton() {
        Set set = DynamicBindServiceManager.classServiceProviderConcurrentHashMap.get(this.klass);
        ServiceProvider<T> serviceProvider = this.serviceProvider;
        if (!(serviceProvider instanceof SingletonProvider)) {
            set.remove(serviceProvider);
            SingletonProvider singletonProvider = new SingletonProvider(this.serviceProvider);
            this.serviceProvider = singletonProvider;
            set.add(singletonProvider);
        }
        return this;
    }
}
