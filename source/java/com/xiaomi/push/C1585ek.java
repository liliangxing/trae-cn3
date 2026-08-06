package com.xiaomi.push;

import com.xiaomi.push.C1586el;
import com.xiaomi.push.service.C1755am;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.ek */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1585ek implements C1755am.b.a {

    /* renamed from: a */
    private int f1614a;

    /* renamed from: a */
    private AbstractC1600ez f1615a;

    /* renamed from: a */
    private XMPushService f1616a;

    /* renamed from: a */
    private C1755am.b f1617a;

    /* renamed from: a */
    private boolean f1619a = false;

    /* renamed from: a */
    private C1755am.c f1618a = C1755am.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1585ek(XMPushService xMPushService, C1755am.b bVar) {
        this.f1616a = xMPushService;
        this.f1617a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2387a() {
        this.f1617a.m3729a(this);
        this.f1615a = this.f1616a.m3542a();
    }

    @Override // com.xiaomi.push.service.C1755am.b.a
    /* renamed from: a */
    public void mo2388a(C1755am.c cVar, C1755am.c cVar2, int i) {
        if (!this.f1619a && cVar == C1755am.c.binding) {
            this.f1618a = cVar2;
            this.f1614a = i;
            this.f1619a = true;
        }
        this.f1616a.m3548a(new XMPushService.AbstractC1731j(4) { // from class: com.xiaomi.push.ek.1
            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public String mo2389a() {
                return "Handling bind stats";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public void mo2390a() {
                C1585ek.this.m2386c();
            }
        });
    }

    /* renamed from: b */
    private void m2385b() {
        this.f1617a.m3731b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m2386c() {
        m2385b();
        if (this.f1619a && this.f1614a != 11) {
            C1583ei m2405a = C1588en.m2403a().m2405a();
            int i = AnonymousClass2.f1621a[this.f1618a.ordinal()];
            if (i == 1) {
                int i2 = this.f1614a;
                if (i2 == 17) {
                    m2405a.f1597a = EnumC1582eh.BIND_TCP_READ_TIMEOUT.m2346a();
                } else if (i2 == 21) {
                    m2405a.f1597a = EnumC1582eh.BIND_TIMEOUT.m2346a();
                } else {
                    try {
                        C1586el.a m2394c = C1586el.m2394c(C1588en.m2402a().m2398a());
                        m2405a.f1597a = m2394c.f1622a.m2346a();
                        m2405a.m2362c(m2394c.f1623a);
                    } catch (NullPointerException unused) {
                        m2405a = null;
                    }
                }
            } else if (i == 3) {
                m2405a.f1597a = EnumC1582eh.BIND_SUCCESS.m2346a();
            }
            if (m2405a != null) {
                m2405a.m2357b(this.f1615a.mo2505a());
                m2405a.m2366d(this.f1617a.f2999b);
                m2405a.f1600b = 1;
                try {
                    m2405a.m2348a((byte) Integer.parseInt(this.f1617a.f3005g));
                } catch (NumberFormatException unused2) {
                }
                C1588en.m2403a().m2408a(m2405a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.ek$2, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a */
        static final /* synthetic */ int[] f1621a;

        static {
            int[] iArr = new int[C1755am.c.values().length];
            f1621a = iArr;
            try {
                iArr[C1755am.c.unbind.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1621a[C1755am.c.binding.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1621a[C1755am.c.binded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
