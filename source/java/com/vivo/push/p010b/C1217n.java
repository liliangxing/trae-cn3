package com.vivo.push.p010b;

import com.vivo.push.C1232d;

/* compiled from: OnLogReceiveCommand.java */
/* renamed from: com.vivo.push.b.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1217n extends C1223t {

    /* renamed from: a */
    private String f358a;

    /* renamed from: b */
    private int f359b;

    /* renamed from: c */
    private boolean f360c;

    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    public final String toString() {
        return "OnLogCommand";
    }

    public C1217n() {
        super(7);
        this.f359b = 0;
        this.f360c = false;
    }

    /* renamed from: e */
    public final String m603e() {
        return this.f358a;
    }

    /* renamed from: b */
    public final void m602b(String str) {
        this.f358a = str;
    }

    /* renamed from: f */
    public final int m604f() {
        return this.f359b;
    }

    /* renamed from: a */
    public final void m601a(int i) {
        this.f359b = i;
    }

    /* renamed from: g */
    public final boolean m605g() {
        return this.f360c;
    }

    /* renamed from: h */
    public final void m606h() {
        this.f360c = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public final void mo582c(C1232d c1232d) {
        super.mo582c(c1232d);
        c1232d.m654a("content", this.f358a);
        c1232d.m651a("log_level", this.f359b);
        c1232d.m656a("is_server_log", this.f360c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final void mo583d(C1232d c1232d) {
        super.mo583d(c1232d);
        this.f358a = c1232d.m650a("content");
        this.f359b = c1232d.m658b("log_level", 0);
        this.f360c = c1232d.m664e("is_server_log");
    }
}
