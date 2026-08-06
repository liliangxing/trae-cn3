package com.bytedance.ug.sdk.deeplink;

import com.bytedance.ug.sdk.deeplink.interfaces.IExecutor;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class ZlinkProviderManager {
    private static final String DEFAULT_KEY = "DEFAULT_KEY";
    private static final HashMap<String, HashMap<Object, ?>> providerManagerGroup = new HashMap<>();

    static {
        register(IExecutor.class, IExecutor.DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, K extends T> void register(Class<T> cls, K k) {
        register(DEFAULT_KEY, cls, k);
    }

    private static <T, K extends T> void register(Object obj, Class<T> cls, K k) {
        if (cls == null || k == null) {
            return;
        }
        HashMap<String, HashMap<Object, ?>> hashMap = providerManagerGroup;
        synchronized (hashMap) {
            String name = cls.getName();
            HashMap<Object, ?> hashMap2 = hashMap.get(name);
            if (hashMap2 == null) {
                hashMap2 = new HashMap<>();
                hashMap.put(name, hashMap2);
            }
            hashMap2.put(obj, k);
        }
    }

    public static <T> T getProvider(Class<T> cls) {
        return (T) getProvider(cls, DEFAULT_KEY);
    }

    private static <T> T getProvider(Class<T> cls, Object obj) {
        HashMap<String, HashMap<Object, ?>> hashMap = providerManagerGroup;
        synchronized (hashMap) {
            HashMap<Object, ?> hashMap2 = hashMap.get(cls.getName());
            if (hashMap2 == null) {
                return null;
            }
            return (T) hashMap2.get(obj);
        }
    }
}
