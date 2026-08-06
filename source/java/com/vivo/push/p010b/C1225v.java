package com.vivo.push.p010b;

import com.vivo.push.C1232d;

/* compiled from: OnUndoMsgReceiveCommand.java */
/* renamed from: com.vivo.push.b.v */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1225v extends AbstractC1226w {

    /* renamed from: a */
    private long f380a;

    /* renamed from: b */
    private int f381b;

    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    public final String toString() {
        return "OnUndoMsgCommand";
    }

    public C1225v() {
        super(20);
        this.f380a = -1L;
    }

    /* renamed from: e */
    public final long m630e() {
        return this.f380a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.AbstractC1226w, com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public final void mo582c(C1232d c1232d) {
        super.mo582c(c1232d);
        c1232d.m652a("undo_msg_v1", this.f380a);
        c1232d.m651a("undo_msg_type_v1", this.f381b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.AbstractC1226w, com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final void mo583d(C1232d c1232d) {
        super.mo583d(c1232d);
        this.f380a = c1232d.m659b("undo_msg_v1", this.f380a);
        this.f381b = c1232d.m658b("undo_msg_type_v1", 0);
    }

    /* renamed from: f */
    public final String m631f() {
        long j = this.f380a;
        if (j != -1) {
            return String.valueOf(j);
        }
        return null;
    }
}
