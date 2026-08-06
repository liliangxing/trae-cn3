package com.vivo.push.restructure.p019a.p020a;

import android.content.Context;
import com.vivo.push.C1306m;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.restructure.p019a.InterfaceC1314a;
import com.vivo.push.util.C1393t;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InitNode.java */
/* renamed from: com.vivo.push.restructure.a.a.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1322h extends AbstractC1315a<InterfaceC1314a> {
    @Override // com.vivo.push.restructure.p019a.p020a.AbstractC1315a
    /* renamed from: a */
    protected final /* synthetic */ int mo834a(InterfaceC1314a interfaceC1314a) {
        Context m812b = C1313a.m810a().m812b();
        C1306m.m762a().m774a(m812b);
        C1393t.m1048d("InitNode", "PushMessageReceiver " + m812b.getPackageName() + " ; requestId = " + interfaceC1314a.mo821c());
        return 0;
    }

    public C1322h(InterfaceC1314a interfaceC1314a, C1324j c1324j) {
        super("InitNode", interfaceC1314a, c1324j);
    }
}
