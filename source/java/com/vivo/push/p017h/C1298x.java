package com.vivo.push.p017h;

import com.vivo.push.AbstractC1400v;
import com.vivo.push.util.C1366aa;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnNotificationClickTask.java */
/* renamed from: com.vivo.push.h.x */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1298x extends AbstractC1266ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1298x(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
    }

    @Override // com.vivo.push.AbstractRunnableC1352s
    /* renamed from: a */
    protected final void mo702a(AbstractC1400v abstractC1400v) {
        if (C1366aa.m931c(this.f625a, this.f625a.getPackageName())) {
            C1279e c1279e = new C1279e(abstractC1400v);
            c1279e.m706a(this.f454b);
            c1279e.mo702a(abstractC1400v);
        } else {
            C1278d c1278d = new C1278d(abstractC1400v);
            c1278d.m706a(this.f454b);
            c1278d.mo702a(abstractC1400v);
        }
    }
}
