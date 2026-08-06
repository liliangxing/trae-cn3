package com.xiaomi.push;

import android.content.Context;

/* renamed from: com.xiaomi.push.al */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class C1478al {

    /* renamed from: a */
    static int f981a;

    /* renamed from: a */
    public static InterfaceC1474ah m1500a(Context context) {
        if (C1694j.m3426a()) {
            f981a = 1;
            return new C1477ak(context);
        }
        if (C1473ag.m1479a(context)) {
            f981a = 2;
            return new C1473ag(context);
        }
        if (C1480an.m1517a(context)) {
            f981a = 4;
            return new C1480an(context);
        }
        if (C1482ap.m1522a(context)) {
            f981a = 5;
            return new C1482ap(context);
        }
        if (C1476aj.m1497a(context)) {
            f981a = 3;
            return new C1475ai(context);
        }
        f981a = 0;
        return new C1481ao();
    }
}
