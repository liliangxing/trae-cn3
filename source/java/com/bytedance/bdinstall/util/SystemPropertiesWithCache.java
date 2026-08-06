package com.bytedance.bdinstall.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class SystemPropertiesWithCache {
    private static final SystemPropertiesProxy sGetSystemProperties = new SystemPropertiesProxy();
    private static final Map<String, Object> sCache = new ConcurrentHashMap();

    public static Object get(String str) throws IllegalArgumentException {
        Map<String, Object> map = sCache;
        Object obj = map.get(str);
        if (obj != null) {
            return obj;
        }
        String str2 = sGetSystemProperties.get(str);
        if (str2 != null) {
            map.put(str, str2);
        }
        return str2;
    }
}
