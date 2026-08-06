package com.unicom.online.account.kernel;

import android.content.Context;

/* loaded from: classes7.dex */
public final class v {
    private static boolean a;

    public static boolean a(Context context) {
        if (a) {
            return true;
        }
        Long a2 = ad.a(context, "success_limit_time");
        long currentTimeMillis = System.currentTimeMillis();
        if (a2 == null) {
            ad.a(context, "success_limit_time", Long.valueOf(currentTimeMillis));
            return true;
        }
        if (currentTimeMillis - a2.longValue() > 600000) {
            ad.a(context, "success_limit_time", Long.valueOf(currentTimeMillis));
            ad.a(context, "success_limit_count", 0L);
            return true;
        }
        Long a3 = ad.a(context, "success_limit_count");
        if (a3 != null) {
            return a3.longValue() <= 50;
        }
        ad.a(context, "success_limit_count", 0L);
        return true;
    }

    public static void b(Context context) {
        Long a2 = ad.a(context, "success_limit_count");
        ad.a(context, "success_limit_count", Long.valueOf(a2 == null ? 0L : a2.longValue() + 1));
    }

    public static boolean c(Context context) {
        if (a) {
            return true;
        }
        Long a2 = ad.a(context, "failed_limit_time");
        long currentTimeMillis = System.currentTimeMillis();
        if (a2 == null) {
            ad.a(context, "failed_limit_time", Long.valueOf(currentTimeMillis));
            return true;
        }
        if (currentTimeMillis - a2.longValue() > 600000) {
            ad.a(context, "failed_limit_time", Long.valueOf(currentTimeMillis));
            ad.a(context, "count_limit_count", 0L);
            return true;
        }
        Long a3 = ad.a(context, "count_limit_count");
        if (a3 != null) {
            return a3.longValue() <= 50;
        }
        ad.a(context, "count_limit_count", 0L);
        return true;
    }

    public static void d(Context context) {
        Long a2 = ad.a(context, "count_limit_count");
        ad.a(context, "count_limit_count", Long.valueOf(a2 == null ? 0L : a2.longValue() + 1));
    }
}
