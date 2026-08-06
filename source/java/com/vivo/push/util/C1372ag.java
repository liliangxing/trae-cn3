package com.vivo.push.util;

import java.util.Calendar;

/* compiled from: TimeUtils.java */
/* renamed from: com.vivo.push.util.ag */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1372ag {
    /* renamed from: a */
    public static long m950a() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            return calendar.getTimeInMillis();
        } catch (Exception e) {
            C1393t.m1035a("TimeUtils", "getTodayStartTime error", e);
            return 0L;
        }
    }
}
