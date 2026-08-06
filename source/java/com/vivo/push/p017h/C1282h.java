package com.vivo.push.p017h;

import com.vivo.push.AbstractC1400v;
import com.vivo.push.C1306m;
import com.vivo.push.C1357t;
import com.vivo.push.p010b.C1212i;
import com.vivo.push.util.C1393t;

/* compiled from: OnBindAppReceiveTask.java */
/* renamed from: com.vivo.push.h.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1282h extends AbstractC1266ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1282h(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
    }

    @Override // com.vivo.push.AbstractRunnableC1352s
    /* renamed from: a */
    protected final void mo702a(AbstractC1400v abstractC1400v) {
        C1212i c1212i = (C1212i) abstractC1400v;
        String m595f = c1212i.m595f();
        C1393t.m1048d("OnBindTask", "doTask,订阅APP结果 = " + c1212i.m627j() + " clientToken= " + m595f);
        C1306m.m762a().m779a(c1212i.m626i(), c1212i.m627j(), m595f);
        C1357t.m916a(new RunnableC1283i(this, m595f, c1212i));
    }
}
