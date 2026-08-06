package com.unicom.online.account.kernel;

import android.content.Context;

/* renamed from: com.unicom.online.account.kernel.v */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1190v {

    /* renamed from: a */
    private static boolean f315a;

    /* renamed from: a */
    public static boolean m558a(Context context) {
        if (f315a) {
            return true;
        }
        Long m495a = C1168ad.m495a(context, "success_limit_time");
        long currentTimeMillis = System.currentTimeMillis();
        if (m495a == null) {
            C1168ad.m496a(context, "success_limit_time", Long.valueOf(currentTimeMillis));
            return true;
        }
        if (currentTimeMillis - m495a.longValue() > 600000) {
            C1168ad.m496a(context, "success_limit_time", Long.valueOf(currentTimeMillis));
            C1168ad.m496a(context, "success_limit_count", 0L);
            return true;
        }
        Long m495a2 = C1168ad.m495a(context, "success_limit_count");
        if (m495a2 != null) {
            return m495a2.longValue() <= 50;
        }
        C1168ad.m496a(context, "success_limit_count", 0L);
        return true;
    }

    /* renamed from: b */
    public static void m559b(Context context) {
        Long m495a = C1168ad.m495a(context, "success_limit_count");
        C1168ad.m496a(context, "success_limit_count", Long.valueOf(m495a == null ? 0L : m495a.longValue() + 1));
    }

    /* renamed from: c */
    public static boolean m560c(Context context) {
        if (f315a) {
            return true;
        }
        Long m495a = C1168ad.m495a(context, "failed_limit_time");
        long currentTimeMillis = System.currentTimeMillis();
        if (m495a == null) {
            C1168ad.m496a(context, "failed_limit_time", Long.valueOf(currentTimeMillis));
            return true;
        }
        if (currentTimeMillis - m495a.longValue() > 600000) {
            C1168ad.m496a(context, "failed_limit_time", Long.valueOf(currentTimeMillis));
            C1168ad.m496a(context, "count_limit_count", 0L);
            return true;
        }
        Long m495a2 = C1168ad.m495a(context, "count_limit_count");
        if (m495a2 != null) {
            return m495a2.longValue() <= 50;
        }
        C1168ad.m496a(context, "count_limit_count", 0L);
        return true;
    }

    /* renamed from: d */
    public static void m561d(Context context) {
        Long m495a = C1168ad.m495a(context, "count_limit_count");
        C1168ad.m496a(context, "count_limit_count", Long.valueOf(m495a == null ? 0L : m495a.longValue() + 1));
    }
}
