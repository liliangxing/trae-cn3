package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.gm */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1641gm implements InterfaceC1671hp<C1641gm, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f2134a;

    /* renamed from: a */
    public EnumC1635gg f2135a;

    /* renamed from: a */
    public String f2136a;

    /* renamed from: a */
    private BitSet f2137a = new BitSet(1);

    /* renamed from: a */
    private static final C1687ie f2131a = new C1687ie("DataCollectionItem");

    /* renamed from: a */
    private static final C1678hw f2130a = new C1678hw("", (byte) 10, 1);

    /* renamed from: b */
    private static final C1678hw f2132b = new C1678hw("", (byte) 8, 2);

    /* renamed from: c */
    private static final C1678hw f2133c = new C1678hw("", (byte) 11, 3);

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public C1641gm m2765a(long j) {
        this.f2134a = j;
        m2770a(true);
        return this;
    }

    /* renamed from: a */
    public boolean m2771a() {
        return this.f2137a.get(0);
    }

    /* renamed from: a */
    public void m2770a(boolean z) {
        this.f2137a.set(0, z);
    }

    /* renamed from: a */
    public C1641gm m2766a(EnumC1635gg enumC1635gg) {
        this.f2135a = enumC1635gg;
        return this;
    }

    /* renamed from: b */
    public boolean m2773b() {
        return this.f2135a != null;
    }

    /* renamed from: a */
    public String m2768a() {
        return this.f2136a;
    }

    /* renamed from: a */
    public C1641gm m2767a(String str) {
        this.f2136a = str;
        return this;
    }

    /* renamed from: c */
    public boolean m2774c() {
        return this.f2136a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1641gm)) {
            return m2772a((C1641gm) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2772a(C1641gm c1641gm) {
        if (c1641gm == null || this.f2134a != c1641gm.f2134a) {
            return false;
        }
        boolean m2773b = m2773b();
        boolean m2773b2 = c1641gm.m2773b();
        if ((m2773b || m2773b2) && !(m2773b && m2773b2 && this.f2135a.equals(c1641gm.f2135a))) {
            return false;
        }
        boolean m2774c = m2774c();
        boolean m2774c2 = c1641gm.m2774c();
        if (m2774c || m2774c2) {
            return m2774c && m2774c2 && this.f2136a.equals(c1641gm.f2136a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1641gm c1641gm) {
        int m3318a;
        int m3317a;
        int m3316a;
        if (!getClass().equals(c1641gm.getClass())) {
            return getClass().getName().compareTo(c1641gm.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2771a()).compareTo(Boolean.valueOf(c1641gm.m2771a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2771a() && (m3316a = C1672hq.m3316a(this.f2134a, c1641gm.f2134a)) != 0) {
            return m3316a;
        }
        int compareTo2 = Boolean.valueOf(m2773b()).compareTo(Boolean.valueOf(c1641gm.m2773b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2773b() && (m3317a = C1672hq.m3317a(this.f2135a, c1641gm.f2135a)) != 0) {
            return m3317a;
        }
        int compareTo3 = Boolean.valueOf(m2774c()).compareTo(Boolean.valueOf(c1641gm.m2774c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!m2774c() || (m3318a = C1672hq.m3318a(this.f2136a, c1641gm.f2136a)) == 0) {
            return 0;
        }
        return m3318a;
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
                        if (mo3340a.f2770a == 11) {
                            this.f2136a = abstractC1681hz.mo3345a();
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                        }
                    } else {
                        C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                    }
                } else if (mo3340a.f2770a == 8) {
                    this.f2135a = EnumC1635gg.m2716a(abstractC1681hz.mo3338a());
                } else {
                    C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                }
            } else if (mo3340a.f2770a == 10) {
                this.f2134a = abstractC1681hz.mo3339a();
                m2770a(true);
            } else {
                C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
            }
            abstractC1681hz.mo3369g();
        }
        abstractC1681hz.mo3368f();
        if (!m2771a()) {
            throw new C1683ia("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
        }
        m2769a();
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2769a();
        abstractC1681hz.mo3356a(f2131a);
        abstractC1681hz.mo3353a(f2130a);
        abstractC1681hz.mo3352a(this.f2134a);
        abstractC1681hz.mo3362b();
        if (this.f2135a != null) {
            abstractC1681hz.mo3353a(f2132b);
            abstractC1681hz.mo3351a(this.f2135a.m2717a());
            abstractC1681hz.mo3362b();
        }
        if (this.f2136a != null) {
            abstractC1681hz.mo3353a(f2133c);
            abstractC1681hz.mo3357a(this.f2136a);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(collectedAt:");
        sb.append(this.f2134a);
        sb.append(", ");
        sb.append("collectionType:");
        EnumC1635gg enumC1635gg = this.f2135a;
        if (enumC1635gg == null) {
            sb.append("null");
        } else {
            sb.append(enumC1635gg);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f2136a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m2769a() {
        if (this.f2135a == null) {
            throw new C1683ia("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.f2136a == null) {
            throw new C1683ia("Required field 'content' was not present! Struct: " + toString());
        }
    }
}
