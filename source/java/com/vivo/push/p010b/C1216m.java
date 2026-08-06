package com.vivo.push.p010b;

import com.vivo.push.C1232d;
import java.util.ArrayList;

/* compiled from: OnListTagReceiveCommand.java */
/* renamed from: com.vivo.push.b.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1216m extends C1223t {

    /* renamed from: a */
    private ArrayList<String> f357a;

    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    public final String toString() {
        return "OnListTagCommand";
    }

    public C1216m() {
        super(8);
    }

    /* renamed from: e */
    public final ArrayList<String> m600e() {
        return this.f357a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public final void mo582c(C1232d c1232d) {
        super.mo582c(c1232d);
        c1232d.m655a("tags_list", this.f357a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final void mo583d(C1232d c1232d) {
        super.mo583d(c1232d);
        this.f357a = c1232d.m662c("tags_list");
    }
}
