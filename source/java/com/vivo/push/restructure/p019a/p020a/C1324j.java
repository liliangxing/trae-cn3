package com.vivo.push.restructure.p019a.p020a;

import com.vivo.push.restructure.p019a.InterfaceC1314a;
import com.vivo.push.restructure.p022c.InterfaceC1337a;
import com.vivo.push.util.C1393t;

/* compiled from: NodeListenerImpl.java */
/* renamed from: com.vivo.push.restructure.a.a.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1324j implements InterfaceC1323i<InterfaceC1314a> {

    /* renamed from: a */
    private AbstractC1315a f574a;

    /* renamed from: b */
    private InterfaceC1328n f575b;

    /* renamed from: c */
    private InterfaceC1325k f576c;

    /* renamed from: d */
    private InterfaceC1337a f577d;

    @Override // com.vivo.push.restructure.p019a.p020a.InterfaceC1323i
    /* renamed from: a */
    public final /* synthetic */ void mo844a(AbstractC1315a abstractC1315a, InterfaceC1314a interfaceC1314a, int i) {
        InterfaceC1314a interfaceC1314a2 = interfaceC1314a;
        if (interfaceC1314a2 == null) {
            C1393t.m1039a("onNodeError() receivedMsg is null ");
            return;
        }
        C1393t.m1039a("onNodeError() , msgID = " + interfaceC1314a2.mo819a() + ", nodeName = " + abstractC1315a.mo838b());
        InterfaceC1337a interfaceC1337a = this.f577d;
        if (interfaceC1337a != null) {
            interfaceC1337a.mo881a(i, interfaceC1314a2.mo819a());
        }
        a2(interfaceC1314a2);
    }

    @Override // com.vivo.push.restructure.p019a.p020a.InterfaceC1323i
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo846a(InterfaceC1314a interfaceC1314a) {
        InterfaceC1314a interfaceC1314a2 = interfaceC1314a;
        if (interfaceC1314a2 == null) {
            C1393t.m1039a("onAllNodeExecuteComplete, receivedMsg is null");
        } else if (this.f574a == null) {
            C1393t.m1039a("onAllNodeExecuteComplete, mFirstNode is null");
        } else {
            a2(interfaceC1314a2);
        }
    }

    public C1324j(InterfaceC1328n interfaceC1328n, InterfaceC1325k interfaceC1325k, InterfaceC1337a interfaceC1337a) {
        this.f575b = interfaceC1328n;
        this.f576c = interfaceC1325k;
        this.f577d = interfaceC1337a;
    }

    @Override // com.vivo.push.restructure.p019a.p020a.InterfaceC1323i
    /* renamed from: a */
    public final void mo845a(C1321g c1321g) {
        this.f574a = c1321g;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(InterfaceC1314a interfaceC1314a) {
        if (interfaceC1314a == null) {
            return;
        }
        if (!interfaceC1314a.mo823e()) {
            C1393t.m1039a("core is not support monitor report");
            return;
        }
        C1393t.m1039a("reportNodeMonitorInfo() , isNeedCollectNodeMonitor: " + interfaceC1314a.mo824f());
        if (interfaceC1314a.mo824f()) {
            InterfaceC1328n interfaceC1328n = this.f575b;
            if (interfaceC1328n != null) {
                interfaceC1328n.mo849a(interfaceC1314a, this.f574a);
            }
            InterfaceC1325k interfaceC1325k = this.f576c;
            if (interfaceC1325k != null) {
                interfaceC1325k.mo847a(interfaceC1314a, this.f574a.m839c().toString());
                C1393t.m1039a("reportNodeMonitorInfo() , report client NodeInfo！！！");
            } else {
                C1393t.m1039a("onNodeError , mReporter is null， can not report");
            }
        }
    }
}
