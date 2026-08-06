package com.huawei.hms.hatool;

import android.content.Context;
import com.heytap.mcssdk.constant.C0879b;

/* renamed from: com.huawei.hms.hatool.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class C1160m {

    /* renamed from: b */
    private static C1160m f1514b;

    /* renamed from: c */
    private static final Object f1515c = new Object();

    /* renamed from: a */
    private Context f1516a;

    private C1160m() {
    }

    /* renamed from: a */
    public static C1160m m1621a() {
        if (f1514b == null) {
            m1622b();
        }
        return f1514b;
    }

    /* renamed from: b */
    private static synchronized void m1622b() {
        synchronized (C1160m.class) {
            if (f1514b == null) {
                f1514b = new C1160m();
            }
        }
    }

    /* renamed from: a */
    public void m1623a(Context context) {
        synchronized (f1515c) {
            if (this.f1516a != null) {
                C1182v.m1786f("hmsSdk", "DataManager already initialized.");
                return;
            }
            this.f1516a = context;
            C1176s.m1722c().m1727b().m1511a(this.f1516a);
            C1176s.m1722c().m1727b().m1530j(context.getPackageName());
            C1151j.m1564a().m1567a(context);
        }
    }

    /* renamed from: a */
    public void m1624a(String str) {
        C1182v.m1775a("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.f1516a;
        if (context == null) {
            C1182v.m1785e("hmsSdk", "sdk is not init");
        } else {
            C1176s.m1722c().m1727b().m1528i(C1138e1.m1491a(C0879b.f577u, str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
        }
    }
}
