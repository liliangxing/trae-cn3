package com.vivo.push;

import android.content.Intent;
import com.vivo.push.p010b.C1212i;
import com.vivo.push.p010b.C1213j;
import com.vivo.push.p010b.C1214k;
import com.vivo.push.p010b.C1215l;
import com.vivo.push.p010b.C1216m;
import com.vivo.push.p010b.C1217n;
import com.vivo.push.p010b.C1218o;
import com.vivo.push.p010b.C1219p;
import com.vivo.push.p010b.C1220q;
import com.vivo.push.p010b.C1221r;
import com.vivo.push.p010b.C1222s;
import com.vivo.push.p010b.C1224u;
import com.vivo.push.p010b.C1225v;
import com.vivo.push.p017h.AbstractC1266ab;
import com.vivo.push.p017h.C1273ai;
import com.vivo.push.util.C1393t;

/* compiled from: PushClientFactory.java */
/* renamed from: com.vivo.push.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1305l implements IPushClientFactory {

    /* renamed from: a */
    private C1273ai f509a = new C1273ai();

    @Override // com.vivo.push.IPushClientFactory
    public final AbstractC1400v createReceiverCommand(Intent intent) {
        AbstractC1400v c1225v;
        AbstractC1400v c1224u;
        int intExtra = intent.getIntExtra("command", -1);
        if (intExtra < 0) {
            intExtra = intent.getIntExtra("method", -1);
        }
        if (intExtra == 20) {
            c1225v = new C1225v();
        } else if (intExtra == 2016) {
            c1225v = new C1215l();
        } else if (intExtra != 2023) {
            switch (intExtra) {
                case 1:
                case 2:
                    c1224u = new C1224u(intExtra);
                    c1225v = c1224u;
                    break;
                case 3:
                    c1225v = new C1218o();
                    break;
                case 4:
                    c1225v = new C1220q();
                    break;
                case 5:
                    c1225v = new C1219p();
                    break;
                case 6:
                    c1225v = new C1222s();
                    break;
                case 7:
                    c1225v = new C1217n();
                    break;
                case 8:
                    c1225v = new C1216m();
                    break;
                case 9:
                    c1225v = new C1214k();
                    break;
                case 10:
                case 11:
                    c1224u = new C1212i(intExtra);
                    c1225v = c1224u;
                    break;
                case 12:
                    c1225v = new C1213j();
                    break;
                default:
                    c1225v = null;
                    break;
            }
        } else {
            c1225v = new C1221r();
        }
        if (c1225v != null) {
            C1232d m648a = C1232d.m648a(intent);
            if (m648a == null) {
                C1393t.m1041b("PushCommand", "bundleWapper is null");
            } else {
                c1225v.m1069b(m648a);
            }
        }
        return c1225v;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final AbstractRunnableC1352s createTask(AbstractC1400v abstractC1400v) {
        return C1273ai.m713a(abstractC1400v);
    }

    @Override // com.vivo.push.IPushClientFactory
    public final AbstractC1266ab createReceiveTask(AbstractC1400v abstractC1400v) {
        return C1273ai.m714b(abstractC1400v);
    }
}
