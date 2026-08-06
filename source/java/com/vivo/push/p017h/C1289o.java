package com.vivo.push.p017h;

import com.vivo.push.AbstractC1400v;
import com.vivo.push.p010b.C1215l;
import com.vivo.push.util.C1369ad;
import com.vivo.push.util.C1393t;

/* compiled from: OnDispatcherReceiveTask.java */
/* renamed from: com.vivo.push.h.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1289o extends AbstractC1266ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1289o(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
    }

    @Override // com.vivo.push.AbstractRunnableC1352s
    /* renamed from: a */
    protected final void mo702a(AbstractC1400v abstractC1400v) {
        C1215l c1215l = (C1215l) abstractC1400v;
        int m598e = c1215l.m598e();
        int m599f = c1215l.m599f();
        C1369ad.m941c().m984a("key_dispatch_environment", m598e);
        C1369ad.m941c().m984a("key_dispatch_area", m599f);
        C1393t.m1048d("OnDispatcherReceiveTask", "environment  and area=" + m598e + "  ; " + m599f);
    }
}
