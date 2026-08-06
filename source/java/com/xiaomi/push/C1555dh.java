package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import com.xiaomi.push.service.C1750ah;

/* renamed from: com.xiaomi.push.dh */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1555dh {
    /* renamed from: a */
    public static byte[] m2033a(String str, byte[] bArr) {
        byte[] m1586a = C1490ax.m1586a(str);
        try {
            m2031a(m1586a);
            return C1655h.m3006a(m1586a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m2034b(String str, byte[] bArr) {
        byte[] m1586a = C1490ax.m1586a(str);
        try {
            m2031a(m1586a);
            return C1655h.m3007b(m1586a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static void m2031a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    /* renamed from: a */
    public static boolean m2032a(Context context, String str, long j) {
        if (C1750ah.m3674a(context).m3686a(EnumC1638gj.DCJobMutualSwitch.m2760a(), false)) {
            return (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !C1468ab.m1439a(context, str, j);
        }
        return false;
    }
}
