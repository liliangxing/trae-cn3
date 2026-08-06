package com.apm.lite.p023k;

import java.util.Map;

/* renamed from: com.apm.lite.k.r */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0795r {

    /* renamed from: a */
    private static int f598a;

    /* renamed from: a */
    public static Float m894a(Map<? super String, Float> map) {
        float f = 0.0f;
        for (Float f2 : map.values()) {
            if (f2 != null) {
                f += f2.floatValue();
            }
        }
        return Float.valueOf(f);
    }

    /* renamed from: a */
    public static Long m895a(Map<? super String, Long> map, String str, Long l) {
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

    /* renamed from: a */
    public static boolean m896a(int i) {
        return false;
    }

    /* renamed from: b */
    public static int m897b(int i) {
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
