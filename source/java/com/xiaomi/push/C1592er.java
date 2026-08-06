package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1595eu;

/* renamed from: com.xiaomi.push.er */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class C1592er {

    /* renamed from: a */
    private static final boolean f1655a = Log.isLoggable("BCompressed", 3);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static byte[] m2458a(C1591eq c1591eq, byte[] bArr) {
        try {
            byte[] m2476a = C1595eu.a.m2476a(bArr);
            if (f1655a) {
                AbstractC1417b.m1090a("BCompressed", "decompress " + bArr.length + " to " + m2476a.length + " for " + c1591eq);
                if (c1591eq.f1649a == 1) {
                    AbstractC1417b.m1090a("BCompressed", "decompress not support upStream");
                }
            }
            return m2476a;
        } catch (Exception e) {
            AbstractC1417b.m1090a("BCompressed", "decompress error " + e);
            return bArr;
        }
    }
}
