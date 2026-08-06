package com.vivo.push.p010b;

import com.vivo.push.C1232d;

/* compiled from: OnVerifyReceiveCommand.java */
/* renamed from: com.vivo.push.b.w */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1226w extends C1223t {

    /* renamed from: a */
    private String f382a;

    /* renamed from: b */
    private long f383b;

    public AbstractC1226w(int i) {
        super(i);
    }

    /* renamed from: h */
    public final long m632h() {
        return this.f383b;
    }

    /* renamed from: k */
    public final String m633k() {
        return this.f382a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public void mo582c(C1232d c1232d) {
        super.mo582c(c1232d);
        c1232d.m654a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f382a);
        c1232d.m652a("notify_id", this.f383b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public void mo583d(C1232d c1232d) {
        super.mo583d(c1232d);
        this.f382a = c1232d.m650a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f383b = c1232d.m659b("notify_id", -1L);
    }
}
