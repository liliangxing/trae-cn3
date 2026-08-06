package com.vivo.push.p017h;

import com.vivo.push.AbstractC1400v;
import com.vivo.push.C1306m;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.p010b.C1211h;
import com.vivo.push.p010b.C1218o;
import com.vivo.push.util.C1373ah;
import com.vivo.push.util.C1393t;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnMessageReceiveTask.java */
/* renamed from: com.vivo.push.h.t */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1294t extends AbstractC1266ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1294t(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
    }

    @Override // com.vivo.push.AbstractRunnableC1352s
    /* renamed from: a */
    protected final void mo702a(AbstractC1400v abstractC1400v) {
        C1218o c1218o = (C1218o) abstractC1400v;
        UnvarnishedMessage m608f = c1218o.m608f();
        if (m608f != null && m608f.isTransMsgArrive()) {
            C1306m.m762a().m776a(new C1211h(String.valueOf(c1218o.m632h())));
        }
        if (C1306m.m762a().m792g() && !m707a(C1373ah.m965c(this.f625a), c1218o.m607e(), c1218o.m633k())) {
            super.m705a(1021);
            return;
        }
        if (m608f != null) {
            if (m608f.isTransMsgExpired()) {
                C1393t.m1048d("OnMessageTask", "tragetType is Expired msg =" + m608f.getMsgId());
                this.f454b.onTransmissionMessageExpired(m608f);
                super.m705a(0);
                return;
            } else {
                C1393t.m1048d("OnMessageTask", "tragetType is " + m608f.getTargetType() + " ; messageId is " + m608f.getMsgId());
                this.f454b.onTransmissionMessage(this.f625a, m608f);
                super.m705a(0);
                return;
            }
        }
        super.m705a(2807);
        C1393t.m1034a("OnMessageTask", " message is null");
    }
}
