package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.hb */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1657hb implements InterfaceC1671hp<C1657hb, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public List<C1644gp> f2448a;

    /* renamed from: a */
    private static final C1687ie f2447a = new C1687ie("XmPushActionCustomConfig");

    /* renamed from: a */
    private static final C1678hw f2446a = new C1678hw("", (byte) 15, 1);

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public List<C1644gp> m3036a() {
        return this.f2448a;
    }

    /* renamed from: a */
    public boolean m3038a() {
        return this.f2448a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1657hb)) {
            return m3039a((C1657hb) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3039a(C1657hb c1657hb) {
        if (c1657hb == null) {
            return false;
        }
        boolean m3038a = m3038a();
        boolean m3038a2 = c1657hb.m3038a();
        if (m3038a || m3038a2) {
            return m3038a && m3038a2 && this.f2448a.equals(c1657hb.f2448a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1657hb c1657hb) {
        int m3320a;
        if (!getClass().equals(c1657hb.getClass())) {
            return getClass().getName().compareTo(c1657hb.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3038a()).compareTo(Boolean.valueOf(c1657hb.m3038a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m3038a() || (m3320a = C1672hq.m3320a(this.f2448a, c1657hb.f2448a)) == 0) {
            return 0;
        }
        return m3320a;
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: a */
    public void mo2352a(AbstractC1681hz abstractC1681hz) {
        abstractC1681hz.mo3344a();
        while (true) {
            C1678hw mo3340a = abstractC1681hz.mo3340a();
            if (mo3340a.f2770a != 0) {
                if (mo3340a.f2772a == 1) {
                    if (mo3340a.f2770a == 15) {
                        C1679hx mo3341a = abstractC1681hz.mo3341a();
                        this.f2448a = new ArrayList(mo3341a.f2774a);
                        for (int i = 0; i < mo3341a.f2774a; i++) {
                            C1644gp c1644gp = new C1644gp();
                            c1644gp.mo2352a(abstractC1681hz);
                            this.f2448a.add(c1644gp);
                        }
                        abstractC1681hz.mo3371i();
                    } else {
                        C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                    }
                } else {
                    C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                }
                abstractC1681hz.mo3369g();
            } else {
                abstractC1681hz.mo3368f();
                m3037a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m3037a();
        abstractC1681hz.mo3356a(f2447a);
        if (this.f2448a != null) {
            abstractC1681hz.mo3353a(f2446a);
            abstractC1681hz.mo3354a(new C1679hx((byte) 12, this.f2448a.size()));
            Iterator<C1644gp> it = this.f2448a.iterator();
            while (it.hasNext()) {
                it.next().mo2358b(abstractC1681hz);
            }
            abstractC1681hz.mo3367e();
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(customConfigs:");
        List<C1644gp> list = this.f2448a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m3037a() {
        if (this.f2448a == null) {
            throw new C1683ia("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }
}
