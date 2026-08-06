package com.cmic.sso.sdk.p003c.p006c;

import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.p003c.p005b.AbstractC0112a;
import com.cmic.sso.sdk.p003c.p005b.C0116e;
import com.cmic.sso.sdk.p009e.C0133c;
import com.cmic.sso.sdk.p009e.C0146p;

/* compiled from: HttpGetPrephoneRequest.java */
/* renamed from: com.cmic.sso.sdk.c.c.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0122b extends C0123c {

    /* renamed from: b */
    private final C0116e f253b;

    /* renamed from: c */
    private boolean f254c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0122b(String str, C0116e c0116e, String str2, String str3) {
        super(str, c0116e, str2, str3);
        this.f254c = false;
        this.f253b = c0116e;
    }

    /* renamed from: a */
    public void m260a(C0088a c0088a) {
        String[] strArr;
        AbstractC0112a m234c = this.f253b.m234c();
        m234c.m217u(c0088a.m67b("socketip"));
        C0133c.m328b("GetPrePhonescripParam", "socket socketip = " + c0088a.m67b("socketip"));
        if (!this.f254c) {
            if (c0088a.m69b("isCloseIpv4", false)) {
                strArr = null;
            } else {
                strArr = C0146p.m394a(true);
                m234c.m213q(strArr[0]);
            }
            if (!c0088a.m69b("isCloseIpv6", false)) {
                if (strArr == null) {
                    strArr = C0146p.m394a(true);
                }
                m234c.m214r(strArr[1]);
            }
            this.f254c = true;
        }
        m234c.m210n(m234c.m250v(c0088a.m67b("appkey")));
        this.f253b.m229a(m234c);
        this.f253b.m230a(true);
        this.f255a = this.f253b.mo219b().toString();
    }
}
