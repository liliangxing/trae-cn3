package com.vivo.push.p017h;

import com.vivo.push.AbstractC1400v;
import com.vivo.push.AbstractRunnableC1352s;
import com.vivo.push.C1306m;
import com.vivo.push.model.C1307a;
import com.vivo.push.p009a.C1200a;
import com.vivo.push.p010b.C1206c;
import com.vivo.push.p010b.C1208e;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.util.C1366aa;
import com.vivo.push.util.C1398y;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BindAppSendCommandTask.java */
/* renamed from: com.vivo.push.h.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1264a extends AbstractRunnableC1352s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1264a(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
    }

    @Override // com.vivo.push.AbstractRunnableC1352s
    /* renamed from: a */
    protected final void mo702a(AbstractC1400v abstractC1400v) {
        C1206c c1206c = (C1206c) abstractC1400v;
        C1307a m924a = C1366aa.m924a(this.f625a, C1313a.m810a().m816f());
        if (m924a == null) {
            C1306m.m762a().m779a(c1206c.m592g(), 1005, new Object[0]);
            return;
        }
        String m802a = m924a.m802a();
        if (m924a.m808c()) {
            C1306m.m762a().m779a(c1206c.m592g(), 1004, new Object[0]);
            abstractC1400v = new C1208e();
        } else {
            int m1057a = C1398y.m1057a(c1206c);
            if (m1057a != 0) {
                C1306m.m762a().m779a(c1206c.m592g(), m1057a, new Object[0]);
                return;
            }
        }
        C1200a.m577a(this.f625a, m802a, abstractC1400v);
    }
}
