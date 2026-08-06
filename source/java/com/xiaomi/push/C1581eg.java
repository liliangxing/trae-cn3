package com.xiaomi.push;

import java.util.Map;

/* renamed from: com.xiaomi.push.eg */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1581eg implements InterfaceC1579ee {

    /* renamed from: a */
    private InterfaceC1579ee f1524a;

    /* renamed from: com.xiaomi.push.eg$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class a {

        /* renamed from: a */
        private static C1581eg f1525a = new C1581eg();
    }

    /* renamed from: a */
    public static C1581eg m2343a() {
        return a.f1525a;
    }

    private C1581eg() {
    }

    @Override // com.xiaomi.push.InterfaceC1579ee
    /* renamed from: a */
    public void mo2341a(InterfaceC1578ed interfaceC1578ed) {
        InterfaceC1579ee interfaceC1579ee = this.f1524a;
        if (interfaceC1579ee != null) {
            interfaceC1579ee.mo2341a(interfaceC1578ed);
        }
    }

    @Override // com.xiaomi.push.InterfaceC1579ee
    /* renamed from: a */
    public void mo2342a(String str, Map<String, Object> map) {
        InterfaceC1579ee interfaceC1579ee = this.f1524a;
        if (interfaceC1579ee != null) {
            interfaceC1579ee.mo2342a(str, map);
        }
    }
}
