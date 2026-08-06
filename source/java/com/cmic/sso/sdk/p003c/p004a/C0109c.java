package com.cmic.sso.sdk.p003c.p004a;

import android.text.TextUtils;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.p003c.C0111b;
import com.cmic.sso.sdk.p003c.p006c.C0123c;
import com.cmic.sso.sdk.p003c.p007d.C0126a;
import com.cmic.sso.sdk.p003c.p007d.C0127b;
import com.cmic.sso.sdk.p003c.p007d.InterfaceC0128c;
import com.cmic.sso.sdk.p009e.C0133c;

/* compiled from: RetryAndRedirectInterceptor.java */
/* renamed from: com.cmic.sso.sdk.c.a.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0109c implements InterfaceC0108b {

    /* renamed from: a */
    private InterfaceC0108b f172a;

    /* renamed from: b */
    private InterfaceC0128c f173b;

    /* renamed from: c */
    private final C0111b f174c = new C0111b();

    @Override // com.cmic.sso.sdk.p003c.p004a.InterfaceC0108b
    /* renamed from: a */
    public void mo183a(C0123c c0123c, InterfaceC0128c interfaceC0128c, C0088a c0088a) {
        m186b(c0123c, interfaceC0128c, c0088a);
    }

    /* renamed from: a */
    public void m185a(InterfaceC0108b interfaceC0108b) {
        this.f172a = interfaceC0108b;
    }

    /* renamed from: b */
    public void m186b(final C0123c c0123c, final InterfaceC0128c interfaceC0128c, final C0088a c0088a) {
        if (this.f172a != null) {
            this.f173b = new InterfaceC0128c() { // from class: com.cmic.sso.sdk.c.a.c.1
                @Override // com.cmic.sso.sdk.p003c.p007d.InterfaceC0128c
                /* renamed from: a */
                public void mo188a(C0127b c0127b) {
                    if (c0127b.m283d()) {
                        C0109c.this.m186b(C0109c.this.f174c.m193a(c0123c, c0127b, c0088a), interfaceC0128c, c0088a);
                    } else if (!TextUtils.isEmpty(C0109c.this.f174c.m194a())) {
                        C0109c.this.m186b(C0109c.this.f174c.m195b(c0123c, c0127b, c0088a), interfaceC0128c, c0088a);
                    } else {
                        interfaceC0128c.mo188a(c0127b);
                    }
                }

                @Override // com.cmic.sso.sdk.p003c.p007d.InterfaceC0128c
                /* renamed from: a */
                public void mo187a(C0126a c0126a) {
                    if (c0123c.m275j()) {
                        C0133c.m326a("RetryAndRedirectInterceptor", "retry: " + c0123c.m262a());
                        C0109c.this.m186b(c0123c, interfaceC0128c, c0088a);
                    } else {
                        interfaceC0128c.mo187a(c0126a);
                    }
                }
            };
            if (c0123c.m272g()) {
                this.f172a.mo183a(c0123c, this.f173b, c0088a);
            } else {
                interfaceC0128c.mo187a(C0126a.m277a(200025));
            }
        }
    }
}
