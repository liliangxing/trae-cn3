package com.vivo.push.p017h;

import com.vivo.push.AbstractC1400v;
import com.vivo.push.util.C1371af;
import com.vivo.push.util.C1393t;

/* compiled from: OnClearCacheReceiveTask.java */
/* renamed from: com.vivo.push.h.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1285k extends AbstractC1266ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1285k(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
    }

    @Override // com.vivo.push.AbstractRunnableC1352s
    /* renamed from: a */
    protected final void mo702a(AbstractC1400v abstractC1400v) {
        C1393t.m1048d("OnClearCacheTask", "delete push info " + this.f625a.getPackageName());
        C1371af.m948b(this.f625a).m949a();
    }
}
