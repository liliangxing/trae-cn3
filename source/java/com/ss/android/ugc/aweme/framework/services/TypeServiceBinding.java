package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public final class TypeServiceBinding<T> {
    Map<Class<?>, Map<String, Set<ServiceProvider<?>>>> classProviderMaps;
    Class<T> klass;
    ServiceProvider<T> serviceProvider;
    String[] types;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeServiceBinding(Class<T> cls, String[] strArr, ServiceProvider<T> serviceProvider) {
        Map<Class<?>, Map<String, Set<ServiceProvider<?>>>> map = DynamicBindServiceManager.typeServiceProviderConcurrentHashMap;
        this.classProviderMaps = map;
        this.types = strArr;
        this.klass = cls;
        this.serviceProvider = serviceProvider;
        Map<String, Set<ServiceProvider<?>>> map2 = map.get(cls);
        if (map2 == null) {
            synchronized ((cls.getName() + getClass().getName())) {
                map2 = this.classProviderMaps.get(this.klass);
                if (map2 == null) {
                    map2 = Collections.synchronizedMap(new HashMap());
                    this.classProviderMaps.put(cls, map2);
                }
            }
        }
        for (String str : strArr) {
            Set<ServiceProvider<?>> set = map2.get(str);
            if (set == null) {
                synchronized ((cls.getName() + str)) {
                    set = map2.get(str);
                    if (set == null) {
                        set = Collections.synchronizedSet(new HashSet());
                        map2.put(str, set);
                    }
                }
            }
            set.add(serviceProvider);
        }
    }

    public TypeServiceBinding<T> asSingleton() {
        if (!(this.serviceProvider instanceof SingletonProvider)) {
            Map<String, Set<ServiceProvider<?>>> map = this.classProviderMaps.get(this.klass);
            ServiceProvider<T> serviceProvider = this.serviceProvider;
            this.serviceProvider = new SingletonProvider(this.serviceProvider);
            for (String str : this.types) {
                Set set = map.get(str);
                set.remove(serviceProvider);
                set.add(this.serviceProvider);
            }
        }
        return this;
    }
}
