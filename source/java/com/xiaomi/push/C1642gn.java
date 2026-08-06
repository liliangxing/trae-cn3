package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.gn */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1642gn implements InterfaceC1671hp<C1642gn, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public int f2142a;

    /* renamed from: a */
    public EnumC1639gk f2143a;

    /* renamed from: a */
    private BitSet f2144a = new BitSet(1);

    /* renamed from: a */
    public List<C1644gp> f2145a;

    /* renamed from: a */
    private static final C1687ie f2139a = new C1687ie("NormalConfig");

    /* renamed from: a */
    private static final C1678hw f2138a = new C1678hw("", (byte) 8, 1);

    /* renamed from: b */
    private static final C1678hw f2140b = new C1678hw("", (byte) 15, 2);

    /* renamed from: c */
    private static final C1678hw f2141c = new C1678hw("", (byte) 8, 3);

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public int m2775a() {
        return this.f2142a;
    }

    /* renamed from: a */
    public boolean m2780a() {
        return this.f2144a.get(0);
    }

    /* renamed from: a */
    public void m2779a(boolean z) {
        this.f2144a.set(0, z);
    }

    /* renamed from: b */
    public boolean m2782b() {
        return this.f2145a != null;
    }

    /* renamed from: a */
    public EnumC1639gk m2777a() {
        return this.f2143a;
    }

    /* renamed from: c */
    public boolean m2783c() {
        return this.f2143a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1642gn)) {
            return m2781a((C1642gn) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2781a(C1642gn c1642gn) {
        if (c1642gn == null || this.f2142a != c1642gn.f2142a) {
            return false;
        }
        boolean m2782b = m2782b();
        boolean m2782b2 = c1642gn.m2782b();
        if ((m2782b || m2782b2) && !(m2782b && m2782b2 && this.f2145a.equals(c1642gn.f2145a))) {
            return false;
        }
        boolean m2783c = m2783c();
        boolean m2783c2 = c1642gn.m2783c();
        if (m2783c || m2783c2) {
            return m2783c && m2783c2 && this.f2143a.equals(c1642gn.f2143a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1642gn c1642gn) {
        int m3317a;
        int m3320a;
        int m3315a;
        if (!getClass().equals(c1642gn.getClass())) {
            return getClass().getName().compareTo(c1642gn.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2780a()).compareTo(Boolean.valueOf(c1642gn.m2780a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2780a() && (m3315a = C1672hq.m3315a(this.f2142a, c1642gn.f2142a)) != 0) {
            return m3315a;
        }
        int compareTo2 = Boolean.valueOf(m2782b()).compareTo(Boolean.valueOf(c1642gn.m2782b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2782b() && (m3320a = C1672hq.m3320a(this.f2145a, c1642gn.f2145a)) != 0) {
            return m3320a;
        }
        int compareTo3 = Boolean.valueOf(m2783c()).compareTo(Boolean.valueOf(c1642gn.m2783c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!m2783c() || (m3317a = C1672hq.m3317a(this.f2143a, c1642gn.f2143a)) == 0) {
            return 0;
        }
        return m3317a;
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: a */
    public void mo2352a(AbstractC1681hz abstractC1681hz) {
        abstractC1681hz.mo3344a();
        while (true) {
            C1678hw mo3340a = abstractC1681hz.mo3340a();
            if (mo3340a.f2770a == 0) {
                break;
            }
            short s = mo3340a.f2772a;
            if (s != 1) {
                if (s != 2) {
                    if (s == 3) {
                        if (mo3340a.f2770a == 8) {
                            this.f2143a = EnumC1639gk.m2761a(abstractC1681hz.mo3338a());
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                        }
                    } else {
                        C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                    }
                } else if (mo3340a.f2770a == 15) {
                    C1679hx mo3341a = abstractC1681hz.mo3341a();
                    this.f2145a = new ArrayList(mo3341a.f2774a);
                    for (int i = 0; i < mo3341a.f2774a; i++) {
                        C1644gp c1644gp = new C1644gp();
                        c1644gp.mo2352a(abstractC1681hz);
                        this.f2145a.add(c1644gp);
                    }
                    abstractC1681hz.mo3371i();
                } else {
                    C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                }
            } else if (mo3340a.f2770a == 8) {
                this.f2142a = abstractC1681hz.mo3338a();
                m2779a(true);
            } else {
                C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
            }
            abstractC1681hz.mo3369g();
        }
        abstractC1681hz.mo3368f();
        if (!m2780a()) {
            throw new C1683ia("Required field 'version' was not found in serialized data! Struct: " + toString());
        }
        m2778a();
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2778a();
        abstractC1681hz.mo3356a(f2139a);
        abstractC1681hz.mo3353a(f2138a);
        abstractC1681hz.mo3351a(this.f2142a);
        abstractC1681hz.mo3362b();
        if (this.f2145a != null) {
            abstractC1681hz.mo3353a(f2140b);
            abstractC1681hz.mo3354a(new C1679hx((byte) 12, this.f2145a.size()));
            Iterator<C1644gp> it = this.f2145a.iterator();
            while (it.hasNext()) {
                it.next().mo2358b(abstractC1681hz);
            }
            abstractC1681hz.mo3367e();
            abstractC1681hz.mo3362b();
        }
        if (this.f2143a != null && m2783c()) {
            abstractC1681hz.mo3353a(f2141c);
            abstractC1681hz.mo3351a(this.f2143a.m2762a());
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(version:");
        sb.append(this.f2142a);
        sb.append(", ");
        sb.append("configItems:");
        List<C1644gp> list = this.f2145a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        if (m2783c()) {
            sb.append(", ");
            sb.append("type:");
            EnumC1639gk enumC1639gk = this.f2143a;
            if (enumC1639gk == null) {
                sb.append("null");
            } else {
                sb.append(enumC1639gk);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m2778a() {
        if (this.f2145a == null) {
            throw new C1683ia("Required field 'configItems' was not present! Struct: " + toString());
        }
    }
}
