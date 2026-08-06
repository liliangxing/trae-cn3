package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.C1702q;

/* renamed from: com.xiaomi.push.service.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1778g {

    /* renamed from: a */
    private static a f3148a;

    /* renamed from: a */
    private static b f3149a;

    /* renamed from: com.xiaomi.push.service.g$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface a {
        /* renamed from: a */
        boolean m3848a(C1659hd c1659hd);
    }

    /* renamed from: com.xiaomi.push.service.g$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface b {
    }

    /* renamed from: a */
    public static void m3846a(b bVar) {
        f3149a = bVar;
    }

    /* renamed from: a */
    public static boolean m3847a(C1659hd c1659hd) {
        if (f3148a == null || c1659hd == null) {
            AbstractC1417b.m1089a("rc params is null, not cpra");
            return false;
        }
        if (!C1694j.m3427a(C1702q.m3462a())) {
            AbstractC1417b.m1089a("rc app not permission to cpra");
            return false;
        }
        return f3148a.m3848a(c1659hd);
    }
}
