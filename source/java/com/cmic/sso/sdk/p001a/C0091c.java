package com.cmic.sso.sdk.p001a;

import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.p001a.C0090b;
import com.cmic.sso.sdk.p009e.C0133c;
import com.cmic.sso.sdk.p009e.C0141k;

/* compiled from: UmcConfigManager.java */
/* renamed from: com.cmic.sso.sdk.a.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0091c implements C0090b.a {

    /* renamed from: a */
    private static C0091c f116a;

    /* renamed from: b */
    private C0089a f117b;

    /* renamed from: c */
    private C0089a f118c;

    /* renamed from: d */
    private C0090b f119d;

    /* renamed from: e */
    private Context f120e;

    private C0091c(Context context) {
        this.f120e = context;
        m131b();
    }

    /* renamed from: b */
    private void m131b() {
        String m374b = C0141k.m374b("sdk_config_version", "");
        if (!TextUtils.isEmpty(m374b) && AuthnHelper.SDK_VERSION.equals(m374b)) {
            C0090b m111a = C0090b.m111a(false);
            this.f119d = m111a;
            this.f117b = m111a.m125b();
        } else {
            C0090b m111a2 = C0090b.m111a(true);
            this.f119d = m111a2;
            this.f117b = m111a2.m122a();
            if (!TextUtils.isEmpty(m374b)) {
                m132c();
            }
        }
        this.f119d.m123a(this);
        this.f118c = this.f119d.m122a();
    }

    /* renamed from: a */
    public static C0091c m130a(Context context) {
        if (f116a == null) {
            synchronized (C0091c.class) {
                if (f116a == null) {
                    f116a = new C0091c(context);
                }
            }
        }
        return f116a;
    }

    /* renamed from: a */
    public C0089a m133a() {
        try {
            return this.f117b.clone();
        } catch (CloneNotSupportedException unused) {
            return this.f118c;
        }
    }

    @Override // com.cmic.sso.sdk.p001a.C0090b.a
    /* renamed from: a */
    public void mo129a(C0089a c0089a) {
        this.f117b = c0089a;
    }

    /* renamed from: a */
    public void m134a(C0088a c0088a) {
        this.f119d.m124a(c0088a);
    }

    /* renamed from: c */
    private void m132c() {
        C0133c.m328b("UmcConfigManager", "delete localConfig");
        this.f119d.m126c();
    }
}
