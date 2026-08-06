package com.vivo.push.restructure;

import android.content.Context;
import com.vivo.push.C1404z;
import com.vivo.push.InterfaceC1304k;
import com.vivo.push.p011c.C1231a;
import com.vivo.push.restructure.p019a.p020a.C1318d;
import com.vivo.push.restructure.p021b.C1334d;
import com.vivo.push.restructure.p021b.C1336f;
import com.vivo.push.restructure.p021b.InterfaceC1331a;
import com.vivo.push.restructure.p021b.InterfaceC1332b;
import com.vivo.push.restructure.p022c.C1338b;
import com.vivo.push.restructure.p022c.InterfaceC1337a;
import com.vivo.push.util.C1399z;

/* compiled from: PushClientController.java */
/* renamed from: com.vivo.push.restructure.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1313a {

    /* renamed from: a */
    private Context f551a;

    /* renamed from: b */
    private InterfaceC1337a f552b;

    /* renamed from: c */
    private C1318d f553c;

    /* renamed from: d */
    private InterfaceC1331a f554d;

    /* renamed from: e */
    private InterfaceC1332b f555e;

    /* renamed from: f */
    private C1231a f556f;

    /* renamed from: g */
    private InterfaceC1304k f557g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PushClientController.java */
    /* renamed from: com.vivo.push.restructure.a$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        static C1313a f558a = new C1313a(0);
    }

    /* synthetic */ C1313a(byte b) {
        this();
    }

    private C1313a() {
    }

    /* renamed from: a */
    public static C1313a m810a() {
        return a.f558a;
    }

    /* renamed from: a */
    public final synchronized void m811a(Context context) {
        if (context == null) {
            return;
        }
        if (this.f551a == null) {
            if (context != null) {
                this.f551a = context;
            }
            this.f554d = new C1334d(new C1399z(context));
            this.f552b = new C1338b(this.f554d);
            this.f553c = new C1318d();
            this.f555e = new C1336f();
            this.f556f = new C1231a(context);
            this.f557g = new C1404z(this.f556f, m815e());
        }
    }

    /* renamed from: b */
    public final synchronized Context m812b() {
        return this.f551a;
    }

    /* renamed from: c */
    public final InterfaceC1337a m813c() {
        return this.f552b;
    }

    /* renamed from: d */
    public final C1318d m814d() {
        return this.f553c;
    }

    /* renamed from: e */
    public final synchronized InterfaceC1331a m815e() {
        return this.f554d;
    }

    /* renamed from: f */
    public final InterfaceC1332b m816f() {
        return this.f555e;
    }

    /* renamed from: g */
    public final C1231a m817g() {
        return this.f556f;
    }

    /* renamed from: h */
    public final InterfaceC1304k m818h() {
        return this.f557g;
    }
}
