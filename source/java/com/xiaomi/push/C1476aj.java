package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;

/* renamed from: com.xiaomi.push.aj */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class C1476aj {

    /* renamed from: a */
    private static volatile boolean f973a;

    /* renamed from: a */
    private static void m1496a(Class<?> cls, Context context) {
        if (f973a) {
            return;
        }
        try {
            f973a = true;
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            AbstractC1417b.m1089a("mdid:load lib error " + th);
        }
    }

    /* renamed from: a */
    public static boolean m1497a(Context context) {
        try {
            Class<?> m3463a = C1702q.m3463a(context, "com.bun.miitmdid.core.JLibrary");
            if (m3463a == null) {
                return false;
            }
            m1496a(m3463a, context);
            return true;
        } catch (Throwable th) {
            AbstractC1417b.m1089a("mdid:check error " + th);
            return false;
        }
    }
}
