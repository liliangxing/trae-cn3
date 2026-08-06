package com.vivo.push.p010b;

import com.vivo.push.AbstractC1400v;
import com.vivo.push.C1232d;

/* compiled from: PushModeCommand.java */
/* renamed from: com.vivo.push.b.x */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1227x extends AbstractC1400v {

    /* renamed from: a */
    private int f384a;

    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final boolean mo634d() {
        return true;
    }

    @Override // com.vivo.push.AbstractC1400v
    public final String toString() {
        return "PushModeCommand";
    }

    public C1227x() {
        super(2011);
        this.f384a = 0;
    }

    /* renamed from: e */
    public final int m635e() {
        return this.f384a;
    }

    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: c */
    protected final void mo582c(C1232d c1232d) {
        c1232d.m651a("com.bbk.push.ikey.MODE_TYPE", this.f384a);
    }

    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: d */
    protected final void mo583d(C1232d c1232d) {
        this.f384a = c1232d.m658b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
