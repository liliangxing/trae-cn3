package com.vivo.push.restructure.p022c;

import android.text.TextUtils;
import com.vivo.push.C1306m;
import com.vivo.push.p010b.C1228y;
import com.vivo.push.restructure.p021b.InterfaceC1331a;
import com.vivo.push.util.C1393t;
import java.util.HashMap;

/* compiled from: ReportImpl.java */
/* renamed from: com.vivo.push.restructure.c.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1338b implements InterfaceC1337a {

    /* renamed from: a */
    private InterfaceC1331a f596a;

    public C1338b(InterfaceC1331a interfaceC1331a) {
        this.f596a = interfaceC1331a;
    }

    @Override // com.vivo.push.restructure.p022c.InterfaceC1337a
    /* renamed from: a */
    public final void mo881a(int i, String str) {
        C1393t.m1048d("ReportImpl", "reportIntercepted() , msgID = " + str + ", code = " + i);
        if (i <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        C1228y c1228y = new C1228y(i);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("messageID", str);
        InterfaceC1331a interfaceC1331a = this.f596a;
        if (interfaceC1331a != null) {
            String mo854a = interfaceC1331a.mo854a();
            if (!TextUtils.isEmpty(mo854a)) {
                hashMap.put("remoteAppId", mo854a);
            }
        }
        c1228y.m636a(hashMap);
        C1306m.m762a().m776a(c1228y);
    }
}
