package com.vivo.push.p010b;

import com.vivo.push.C1232d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OnTagsReceiveCommand.java */
/* renamed from: com.vivo.push.b.u */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1224u extends C1223t {

    /* renamed from: a */
    private ArrayList<String> f378a;

    /* renamed from: b */
    private ArrayList<String> f379b;

    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    public final String toString() {
        return "OnSetTagsCommand";
    }

    public C1224u(int i) {
        super(i);
        this.f378a = null;
        this.f379b = null;
    }

    /* renamed from: e */
    public final ArrayList<String> m628e() {
        return this.f378a;
    }

    /* renamed from: f */
    public final List<String> m629f() {
        return this.f379b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public final void mo582c(C1232d c1232d) {
        super.mo582c(c1232d);
        c1232d.m655a("content", this.f378a);
        c1232d.m655a("error_msg", this.f379b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final void mo583d(C1232d c1232d) {
        super.mo583d(c1232d);
        this.f378a = c1232d.m662c("content");
        this.f379b = c1232d.m662c("error_msg");
    }
}
