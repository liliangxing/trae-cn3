package com.ss.android.ugc.aweme.framework.services;

import androidx.collection.MutableOrderedSetWrapper;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class DynamicBindServiceManager {
    protected static final ConcurrentHashMap<Class<?>, Set<ServiceProvider<?>>> classServiceProviderConcurrentHashMap = new ConcurrentHashMap<>();
    protected static final Map<Class<?>, Map<String, Set<ServiceProvider<?>>>> typeServiceProviderConcurrentHashMap = Collections.synchronizedMap(new HashMap());

    public static <T> T getDynamicService(Class<T> cls) {
        T t;
        Set<ServiceProvider<?>> set = classServiceProviderConcurrentHashMap.get(cls);
        if (set != null && !set.isEmpty()) {
            Object[] array = set.toArray();
            if (array.length > 0) {
                t = (T) ((ServiceProvider) array[0]).get();
                Map<String, Set<ServiceProvider<?>>> map = typeServiceProviderConcurrentHashMap.get(cls);
                if (t != null && map != null) {
                    for (Object obj : map.keySet().toArray()) {
                        Object[] array2 = map.get(obj).toArray();
                        if (array2.length > 0) {
                            return (T) ((ServiceProvider) array2[0]).get();
                        }
                    }
                    return t;
                }
            }
        }
        t = null;
        Map<String, Set<ServiceProvider<?>>> map2 = typeServiceProviderConcurrentHashMap.get(cls);
        return t != null ? t : t;
    }

    public static <T> T getDynamicService(Class<T> cls, String str) {
        Set<ServiceProvider<?>> set;
        Map<String, Set<ServiceProvider<?>>> map = typeServiceProviderConcurrentHashMap.get(cls);
        if (map == null || (set = map.get(str)) == null) {
            return null;
        }
        Object[] array = set.toArray();
        if (array.length > 0) {
            return (T) ((ServiceProvider) array[0]).get();
        }
        return null;
    }

    public static <T> Set<T> getDynamicServices(Class<T> cls) {
        Set set;
        Set<ServiceProvider<?>> set2 = classServiceProviderConcurrentHashMap.get(cls);
        if (set2 == null || set2.isEmpty()) {
            set = null;
        } else {
            set = Collections.synchronizedSet(new LinkedHashSet());
            for (Object obj : set2.toArray()) {
                set.add(((ServiceProvider) obj).get());
            }
        }
        Map<String, Set<ServiceProvider<?>>> map = typeServiceProviderConcurrentHashMap.get(cls);
        if (map != null && !map.isEmpty()) {
            if (set == null) {
                set = Collections.synchronizedSet(new LinkedHashSet());
            }
            for (Object obj2 : map.keySet().toArray()) {
                for (Object obj3 : map.get(obj2).toArray()) {
                    set.add(((ServiceProvider) obj3).get());
                }
            }
        }
        return set;
    }

    public static <T> Set<T> getDynamicServices(Class<T> cls, String str) {
        Set<ServiceProvider<?>> set;
        Map<String, Set<ServiceProvider<?>>> map = typeServiceProviderConcurrentHashMap.get(cls);
        if (map == null || (set = map.get(str)) == null) {
            return null;
        }
        MutableOrderedSetWrapper mutableOrderedSetWrapper = (Set<T>) Collections.synchronizedSet(new LinkedHashSet());
        for (Object obj : set.toArray()) {
            mutableOrderedSetWrapper.add(((ServiceProvider) obj).get());
        }
        return mutableOrderedSetWrapper;
    }

    public static <T> Set<T> getDynamicServices(Class<T> cls, ServiceTypeFilter serviceTypeFilter) {
        Map<String, Set<ServiceProvider<?>>> map = typeServiceProviderConcurrentHashMap.get(cls);
        if (map == null || map.isEmpty()) {
            return null;
        }
        MutableOrderedSetWrapper mutableOrderedSetWrapper = (Set<T>) Collections.synchronizedSet(new LinkedHashSet());
        for (Object obj : map.keySet().toArray()) {
            if (serviceTypeFilter.filter((String) obj)) {
                for (Object obj2 : map.get(obj).toArray()) {
                    mutableOrderedSetWrapper.add(((ServiceProvider) obj2).get());
                }
            }
        }
        return mutableOrderedSetWrapper;
    }
}
