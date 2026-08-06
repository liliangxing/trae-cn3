package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.hc */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1658hc implements InterfaceC1671hp<C1658hc, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public List<C1642gn> f2451a;

    /* renamed from: a */
    private static final C1687ie f2450a = new C1687ie("XmPushActionNormalConfig");

    /* renamed from: a */
    private static final C1678hw f2449a = new C1678hw("", (byte) 15, 1);

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public List<C1642gn> m3041a() {
        return this.f2451a;
    }

    /* renamed from: a */
    public boolean m3043a() {
        return this.f2451a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1658hc)) {
            return m3044a((C1658hc) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3044a(C1658hc c1658hc) {
        if (c1658hc == null) {
            return false;
        }
        boolean m3043a = m3043a();
        boolean m3043a2 = c1658hc.m3043a();
        if (m3043a || m3043a2) {
            return m3043a && m3043a2 && this.f2451a.equals(c1658hc.f2451a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1658hc c1658hc) {
        int m3320a;
        if (!getClass().equals(c1658hc.getClass())) {
            return getClass().getName().compareTo(c1658hc.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3043a()).compareTo(Boolean.valueOf(c1658hc.m3043a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m3043a() || (m3320a = C1672hq.m3320a(this.f2451a, c1658hc.f2451a)) == 0) {
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
                        this.f2451a = new ArrayList(mo3341a.f2774a);
                        for (int i = 0; i < mo3341a.f2774a; i++) {
                            C1642gn c1642gn = new C1642gn();
                            c1642gn.mo2352a(abstractC1681hz);
                            this.f2451a.add(c1642gn);
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
                m3042a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m3042a();
        abstractC1681hz.mo3356a(f2450a);
        if (this.f2451a != null) {
            abstractC1681hz.mo3353a(f2449a);
            abstractC1681hz.mo3354a(new C1679hx((byte) 12, this.f2451a.size()));
            Iterator<C1642gn> it = this.f2451a.iterator();
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
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(normalConfigs:");
        List<C1642gn> list = this.f2451a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m3042a() {
        if (this.f2451a == null) {
            throw new C1683ia("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }
}
