package com.vivo.push.restructure.p019a.p020a;

import android.text.TextUtils;
import com.vivo.push.restructure.p019a.InterfaceC1314a;
import com.vivo.push.util.C1393t;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: NodeSaveImpl.java */
/* renamed from: com.vivo.push.restructure.a.a.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1329o implements InterfaceC1328n {

    /* renamed from: a */
    private Map<String, C1327m> f580a = new ConcurrentHashMap();

    @Override // com.vivo.push.restructure.p019a.p020a.InterfaceC1328n
    /* renamed from: a */
    public final void mo849a(InterfaceC1314a interfaceC1314a, AbstractC1315a abstractC1315a) {
        if (interfaceC1314a == null) {
            C1393t.m1039a("addToCache error. msg is null");
        } else if (TextUtils.isEmpty(interfaceC1314a.mo819a())) {
            C1393t.m1039a("addToCache error. messageID is null");
        } else if (abstractC1315a == null) {
            C1393t.m1039a("addToCache error. firstNode is null");
        }
    }
}
