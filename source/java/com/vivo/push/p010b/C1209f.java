package com.vivo.push.p010b;

import com.vivo.push.AbstractC1400v;
import com.vivo.push.C1232d;

/* compiled from: DefaultCommand.java */
/* renamed from: com.vivo.push.b.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1209f extends AbstractC1400v {

    /* renamed from: a */
    private int f346a;

    @Override // com.vivo.push.AbstractC1400v
    public final String toString() {
        return "DefaultCommand";
    }

    public C1209f() {
        super(0);
    }

    /* renamed from: a */
    public final void m593a(int i) {
        this.f346a = i;
    }

    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: c */
    protected final void mo582c(C1232d c1232d) {
        if (c1232d != null) {
            c1232d.m651a("APP_CLIENT_SWITCH_FLAG", this.f346a);
        }
    }

    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: d */
    protected final void mo583d(C1232d c1232d) {
        if (c1232d != null) {
            this.f346a = c1232d.m658b("APP_CLIENT_SWITCH_FLAG", 0);
        }
    }
}
