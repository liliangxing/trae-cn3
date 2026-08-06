package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.ej */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1584ej implements InterfaceC1671hp<C1584ej, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public String f1611a;

    /* renamed from: a */
    public List<C1583ei> f1612a;

    /* renamed from: b */
    public String f1613b;

    /* renamed from: a */
    private static final C1687ie f1608a = new C1687ie("StatsEvents");

    /* renamed from: a */
    private static final C1678hw f1607a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f1609b = new C1678hw("", (byte) 11, 2);

    /* renamed from: c */
    private static final C1678hw f1610c = new C1678hw("", (byte) 15, 3);

    public int hashCode() {
        return 0;
    }

    public C1584ej() {
    }

    public C1584ej(String str, List<C1583ei> list) {
        this();
        this.f1611a = str;
        this.f1612a = list;
    }

    /* renamed from: a */
    public boolean m2380a() {
        return this.f1611a != null;
    }

    /* renamed from: a */
    public C1584ej m2378a(String str) {
        this.f1613b = str;
        return this;
    }

    /* renamed from: b */
    public boolean m2382b() {
        return this.f1613b != null;
    }

    /* renamed from: c */
    public boolean m2383c() {
        return this.f1612a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1584ej)) {
            return m2381a((C1584ej) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2381a(C1584ej c1584ej) {
        if (c1584ej == null) {
            return false;
        }
        boolean m2380a = m2380a();
        boolean m2380a2 = c1584ej.m2380a();
        if ((m2380a || m2380a2) && !(m2380a && m2380a2 && this.f1611a.equals(c1584ej.f1611a))) {
            return false;
        }
        boolean m2382b = m2382b();
        boolean m2382b2 = c1584ej.m2382b();
        if ((m2382b || m2382b2) && !(m2382b && m2382b2 && this.f1613b.equals(c1584ej.f1613b))) {
            return false;
        }
        boolean m2383c = m2383c();
        boolean m2383c2 = c1584ej.m2383c();
        if (m2383c || m2383c2) {
            return m2383c && m2383c2 && this.f1612a.equals(c1584ej.f1612a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1584ej c1584ej) {
        int m3320a;
        int m3318a;
        int m3318a2;
        if (!getClass().equals(c1584ej.getClass())) {
            return getClass().getName().compareTo(c1584ej.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2380a()).compareTo(Boolean.valueOf(c1584ej.m2380a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2380a() && (m3318a2 = C1672hq.m3318a(this.f1611a, c1584ej.f1611a)) != 0) {
            return m3318a2;
        }
        int compareTo2 = Boolean.valueOf(m2382b()).compareTo(Boolean.valueOf(c1584ej.m2382b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2382b() && (m3318a = C1672hq.m3318a(this.f1613b, c1584ej.f1613b)) != 0) {
            return m3318a;
        }
        int compareTo3 = Boolean.valueOf(m2383c()).compareTo(Boolean.valueOf(c1584ej.m2383c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!m2383c() || (m3320a = C1672hq.m3320a(this.f1612a, c1584ej.f1612a)) == 0) {
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
                short s = mo3340a.f2772a;
                if (s != 1) {
                    if (s != 2) {
                        if (s == 3) {
                            if (mo3340a.f2770a == 15) {
                                C1679hx mo3341a = abstractC1681hz.mo3341a();
                                this.f1612a = new ArrayList(mo3341a.f2774a);
                                for (int i = 0; i < mo3341a.f2774a; i++) {
                                    C1583ei c1583ei = new C1583ei();
                                    c1583ei.mo2352a(abstractC1681hz);
                                    this.f1612a.add(c1583ei);
                                }
                                abstractC1681hz.mo3371i();
                            } else {
                                C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            }
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                        }
                    } else if (mo3340a.f2770a == 11) {
                        this.f1613b = abstractC1681hz.mo3345a();
                    } else {
                        C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                    }
                } else if (mo3340a.f2770a == 11) {
                    this.f1611a = abstractC1681hz.mo3345a();
                } else {
                    C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                }
                abstractC1681hz.mo3369g();
            } else {
                abstractC1681hz.mo3368f();
                m2379a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2379a();
        abstractC1681hz.mo3356a(f1608a);
        if (this.f1611a != null) {
            abstractC1681hz.mo3353a(f1607a);
            abstractC1681hz.mo3357a(this.f1611a);
            abstractC1681hz.mo3362b();
        }
        if (this.f1613b != null && m2382b()) {
            abstractC1681hz.mo3353a(f1609b);
            abstractC1681hz.mo3357a(this.f1613b);
            abstractC1681hz.mo3362b();
        }
        if (this.f1612a != null) {
            abstractC1681hz.mo3353a(f1610c);
            abstractC1681hz.mo3354a(new C1679hx((byte) 12, this.f1612a.size()));
            Iterator<C1583ei> it = this.f1612a.iterator();
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
        StringBuilder sb = new StringBuilder("StatsEvents(uuid:");
        String str = this.f1611a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (m2382b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.f1613b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<C1583ei> list = this.f1612a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m2379a() {
        if (this.f1611a == null) {
            throw new C1683ia("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f1612a == null) {
            throw new C1683ia("Required field 'events' was not present! Struct: " + toString());
        }
    }
}
