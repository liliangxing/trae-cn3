package com.vivo.push.restructure.p019a.p020a;

import android.text.TextUtils;
import com.vivo.push.C1306m;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.restructure.p019a.InterfaceC1314a;
import com.vivo.push.restructure.request.C1349d;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.C1380g;
import com.vivo.push.util.C1393t;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DispatchNode.java */
/* renamed from: com.vivo.push.restructure.a.a.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1319e extends AbstractC1315a<InterfaceC1314a> {
    public C1319e(InterfaceC1314a interfaceC1314a, C1324j c1324j) {
        super("ClientDispatchNode", interfaceC1314a, c1324j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.vivo.push.restructure.p019a.p020a.AbstractC1315a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public int mo834a(InterfaceC1314a interfaceC1314a) {
        PushMessageCallback m843b = m843b(interfaceC1314a);
        if (m843b == null) {
            return 2804;
        }
        int i = 0;
        if (interfaceC1314a != null && interfaceC1314a.mo825g()) {
            C1349d.m901a().m904a(interfaceC1314a);
            return 0;
        }
        if (interfaceC1314a != null) {
            int mo830l = interfaceC1314a.mo830l();
            String mo831m = interfaceC1314a.mo831m();
            if (mo830l == 3) {
                String m794i = C1306m.m762a().m794i();
                if (TextUtils.isEmpty(m794i) || !TextUtils.equals(m794i, mo831m)) {
                    i = 2810;
                }
            } else if (mo830l == 4) {
                C1306m.m762a();
                if (!C1306m.m770c().contains(mo831m)) {
                    i = 2811;
                }
            }
            if (i != 0) {
                C1380g.m996a().execute(new RunnableC1320f(this, mo830l, mo831m));
                return i;
            }
        }
        try {
            return C1306m.m762a().m773a(interfaceC1314a.mo820b(), m843b);
        } catch (Exception unused) {
            return 2808;
        }
    }

    /* renamed from: b */
    private static PushMessageCallback m843b(InterfaceC1314a interfaceC1314a) {
        try {
            return (PushMessageCallback) Class.forName(C1313a.m810a().m815e().mo855a(C1313a.m810a().m812b(), interfaceC1314a.mo820b().getAction())).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            C1393t.m1042b("DispatchNode", "reflect e: ", e);
            return null;
        }
    }
}
