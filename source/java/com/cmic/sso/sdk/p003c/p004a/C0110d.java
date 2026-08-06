package com.cmic.sso.sdk.p003c.p004a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.p003c.p006c.C0123c;
import com.cmic.sso.sdk.p003c.p007d.C0126a;
import com.cmic.sso.sdk.p003c.p007d.C0127b;
import com.cmic.sso.sdk.p003c.p007d.InterfaceC0128c;
import com.cmic.sso.sdk.p009e.C0133c;
import com.cmic.sso.sdk.p009e.C0144n;
import com.cmic.sso.sdk.p009e.C0148r;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: WifiChangeInterceptor.java */
/* renamed from: com.cmic.sso.sdk.c.a.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0110d implements InterfaceC0108b {

    /* renamed from: a */
    private InterfaceC0108b f179a;

    @Override // com.cmic.sso.sdk.p003c.p004a.InterfaceC0108b
    /* renamed from: a */
    public void mo183a(final C0123c c0123c, final InterfaceC0128c interfaceC0128c, final C0088a c0088a) {
        if (!c0123c.m267b()) {
            m190b(c0123c, interfaceC0128c, c0088a);
        } else {
            final C0148r m405a = C0148r.m405a((Context) null);
            m405a.m407a(new C0148r.a() { // from class: com.cmic.sso.sdk.c.a.d.1

                /* renamed from: f */
                private final AtomicBoolean f185f = new AtomicBoolean(false);

                @Override // com.cmic.sso.sdk.p009e.C0148r.a
                /* renamed from: a */
                public void mo191a(final Network network, final ConnectivityManager.NetworkCallback networkCallback) {
                    if (this.f185f.getAndSet(true)) {
                        return;
                    }
                    C0144n.m391a(new C0144n.a(null, c0088a) { // from class: com.cmic.sso.sdk.c.a.d.1.1
                        @Override // com.cmic.sso.sdk.p009e.C0144n.a
                        /* renamed from: a */
                        protected void mo128a() {
                            if (network != null) {
                                C0133c.m328b("WifiChangeInterceptor", "onAvailable");
                                c0123c.m264a(network);
                                C0110d.this.m190b(c0123c, interfaceC0128c, c0088a);
                            } else {
                                interfaceC0128c.mo187a(C0126a.m277a(102508));
                            }
                            m405a.m406a(networkCallback);
                        }
                    });
                }
            });
        }
    }

    /* renamed from: b */
    public void m190b(C0123c c0123c, final InterfaceC0128c interfaceC0128c, C0088a c0088a) {
        InterfaceC0108b interfaceC0108b = this.f179a;
        if (interfaceC0108b != null) {
            interfaceC0108b.mo183a(c0123c, new InterfaceC0128c() { // from class: com.cmic.sso.sdk.c.a.d.2
                @Override // com.cmic.sso.sdk.p003c.p007d.InterfaceC0128c
                /* renamed from: a */
                public void mo188a(C0127b c0127b) {
                    interfaceC0128c.mo188a(c0127b);
                }

                @Override // com.cmic.sso.sdk.p003c.p007d.InterfaceC0128c
                /* renamed from: a */
                public void mo187a(C0126a c0126a) {
                    interfaceC0128c.mo187a(c0126a);
                }
            }, c0088a);
        }
    }

    /* renamed from: a */
    public void m189a(InterfaceC0108b interfaceC0108b) {
        this.f179a = interfaceC0108b;
    }
}
