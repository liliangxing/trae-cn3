package com.vivo.push.p010b;

import com.vivo.push.AbstractC1400v;
import com.vivo.push.C1232d;

/* compiled from: OnReceiveCommand.java */
/* renamed from: com.vivo.push.b.t */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1223t extends AbstractC1400v {

    /* renamed from: a */
    private String f376a;

    /* renamed from: b */
    private int f377b;

    @Override // com.vivo.push.AbstractC1400v
    public String toString() {
        return "OnReceiveCommand";
    }

    public C1223t(int i) {
        super(i);
        this.f376a = null;
        this.f377b = 0;
    }

    /* renamed from: i */
    public final String m626i() {
        return this.f376a;
    }

    /* renamed from: j */
    public final int m627j() {
        return this.f377b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public void mo582c(C1232d c1232d) {
        c1232d.m654a("req_id", this.f376a);
        c1232d.m651a("status_msg_code", this.f377b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public void mo583d(C1232d c1232d) {
        this.f376a = c1232d.m650a("req_id");
        this.f377b = c1232d.m658b("status_msg_code", this.f377b);
    }
}
