package com.bytedance.tobshadow.bdtracker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class y5 {
    public static final x5 a = new x5();
    public static final Map<String, String> b = new ConcurrentHashMap();

    public static String a(String str) {
        Map<String, String> map = b;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String a2 = a.a(str);
        if (a2 != null) {
            map.put(str, a2);
        }
        return a2;
    }
}
