package com.xiaomi.push;

import android.app.NotificationChannel;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1677hv;
import com.xiaomi.push.C1688if;
import com.xiaomi.push.service.C1748af;

/* renamed from: com.xiaomi.push.ho */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1670ho {
    /* renamed from: a */
    public static <T extends InterfaceC1671hp<T, ?>> byte[] m3313a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new C1676hu(new C1677hv.a()).m3334a(t);
        } catch (C1675ht e) {
            AbstractC1417b.m1091a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }

    /* renamed from: a */
    public static <T extends InterfaceC1671hp<T, ?>> void m3312a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new C1675ht("the message byte is empty.");
        }
        new C1674hs(new C1688if.a(true, true, bArr.length)).m3333a(t, bArr);
    }

    /* renamed from: a */
    public static short m3309a(Context context, C1656ha c1656ha) {
        C1646gr m3010a = c1656ha.m3010a();
        return m3311a(context, c1656ha.f2444b, (m3010a == null || m3010a.m2843a() == null) ? null : m3010a.m2843a().get("channel_id"));
    }

    /* renamed from: a */
    public static short m3310a(Context context, String str) {
        return m3311a(context, str, (String) null);
    }

    /* renamed from: a */
    public static short m3311a(Context context, String str, String str2) {
        return (short) (C1628g.m2681a(context, str, false).m2696a() + 0 + (C1469ac.m1442b(context) ? 4 : 0) + (C1469ac.m1441a(context) ? 8 : 0) + (C1748af.m3633a(context) ? 16 : 0) + m3308a(context, str, str2));
    }

    /* renamed from: a */
    private static int m3308a(Context context, String str, String str2) {
        C1748af m3625a;
        NotificationChannel m3637a;
        if (Build.VERSION.SDK_INT < 26 || context == null || TextUtils.isEmpty(str) || (m3625a = C1748af.m3625a(context, str)) == null || (m3637a = m3625a.m3637a(m3625a.m3640a(str2))) == null) {
            return 0;
        }
        return m3637a.getImportance() != 0 ? 32 : 64;
    }
}
