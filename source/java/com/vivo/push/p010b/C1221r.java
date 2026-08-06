package com.vivo.push.p010b;

import com.vivo.push.C1232d;

/* compiled from: OnNotifyGuideDialogResultCommand.java */
/* renamed from: com.vivo.push.b.r */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1221r extends C1223t {

    /* renamed from: a */
    private static String f374a = "notify_guide_dialog_result";

    /* renamed from: b */
    private int f375b;

    public C1221r() {
        super(2023);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public final void mo582c(C1232d c1232d) {
        super.mo582c(c1232d);
        c1232d.m651a(f374a, this.f375b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final void mo583d(C1232d c1232d) {
        super.mo583d(c1232d);
        this.f375b = c1232d.m658b(f374a, -1);
    }

    /* renamed from: e */
    public final int m625e() {
        return this.f375b;
    }
}
