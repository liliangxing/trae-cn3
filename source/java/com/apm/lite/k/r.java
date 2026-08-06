package com.apm.lite.k;

import java.util.Map;

/* loaded from: classes2.dex */
public class r {
    private static int a;

    public static Float a(Map<? super String, Float> map) {
        float f = 0.0f;
        for (Float f2 : map.values()) {
            if (f2 != null) {
                f += f2.floatValue();
            }
        }
        return Float.valueOf(f);
    }

    public static Long a(Map<? super String, Long> map, String str, Long l) {
        if (str == null || map == null) {
            return -1L;
        }
        Long l2 = map.get(str);
        if (l2 != null) {
            l = Long.valueOf(l2.longValue() + l.longValue());
        }
        map.put(str, l);
        return l;
    }

    public static boolean a(int i) {
        return false;
    }

    public static int b(int i) {
        if (i == 0) {
            return 4;
        }
        if (i == 1) {
            return 8;
        }
        if (i == 2) {
            return 16;
        }
        if (i == 3) {
            return 32;
        }
        if (i != 4) {
            return i != 5 ? 0 : 128;
        }
        return 64;
    }
}
