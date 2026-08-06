package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

/* compiled from: SystemCache.java */
/* renamed from: com.vivo.push.util.af */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1371af implements InterfaceC1378e {

    /* renamed from: a */
    private static final HashMap<String, Integer> f658a = new HashMap<>();

    /* renamed from: b */
    private static final HashMap<String, Long> f659b = new HashMap<>();

    /* renamed from: c */
    private static final HashMap<String, String> f660c = new HashMap<>();

    /* renamed from: d */
    private static C1371af f661d;

    /* renamed from: e */
    private Context f662e;

    /* renamed from: f */
    private InterfaceC1378e f663f;

    /* renamed from: g */
    private boolean f664g;

    private C1371af(Context context) {
        this.f664g = false;
        this.f662e = context;
        this.f664g = mo939a(context);
        C1393t.m1048d("SystemCache", "init status is " + this.f664g + ";  curCache is " + this.f663f);
    }

    /* renamed from: b */
    public static synchronized C1371af m948b(Context context) {
        C1371af c1371af;
        synchronized (C1371af.class) {
            if (f661d == null) {
                f661d = new C1371af(context.getApplicationContext());
            }
            c1371af = f661d;
        }
        return c1371af;
    }

    /* renamed from: a */
    public final void m949a() {
        C1370ae c1370ae = new C1370ae();
        if (c1370ae.mo939a(this.f662e)) {
            c1370ae.m947a();
            C1393t.m1048d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.InterfaceC1378e
    /* renamed from: a */
    public final boolean mo939a(Context context) {
        C1368ac c1368ac = new C1368ac();
        this.f663f = c1368ac;
        boolean mo939a = c1368ac.mo939a(context);
        if (!mo939a) {
            C1370ae c1370ae = new C1370ae();
            this.f663f = c1370ae;
            mo939a = c1370ae.mo939a(context);
        }
        if (!mo939a) {
            this.f663f = null;
        }
        return mo939a;
    }

    @Override // com.vivo.push.util.InterfaceC1378e
    /* renamed from: a */
    public final String mo938a(String str, String str2) {
        InterfaceC1378e interfaceC1378e;
        String str3 = f660c.get(str);
        return (str3 != null || (interfaceC1378e = this.f663f) == null) ? str3 : interfaceC1378e.mo938a(str, str2);
    }
}
