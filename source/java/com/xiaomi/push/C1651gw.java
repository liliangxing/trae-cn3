package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.gw */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1651gw implements InterfaceC1671hp<C1651gw, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public int f2377a;

    /* renamed from: a */
    private BitSet f2378a = new BitSet(2);

    /* renamed from: b */
    public int f2379b;

    /* renamed from: a */
    private static final C1687ie f2375a = new C1687ie("XmPushActionCheckClientInfo");

    /* renamed from: a */
    private static final C1678hw f2374a = new C1678hw("", (byte) 8, 1);

    /* renamed from: b */
    private static final C1678hw f2376b = new C1678hw("", (byte) 8, 2);

    /* renamed from: a */
    public void m2951a() {
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public C1651gw m2950a(int i) {
        this.f2377a = i;
        m2952a(true);
        return this;
    }

    /* renamed from: a */
    public boolean m2953a() {
        return this.f2378a.get(0);
    }

    /* renamed from: a */
    public void m2952a(boolean z) {
        this.f2378a.set(0, z);
    }

    /* renamed from: b */
    public C1651gw m2955b(int i) {
        this.f2379b = i;
        m2956b(true);
        return this;
    }

    /* renamed from: b */
    public boolean m2957b() {
        return this.f2378a.get(1);
    }

    /* renamed from: b */
    public void m2956b(boolean z) {
        this.f2378a.set(1, z);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1651gw)) {
            return m2954a((C1651gw) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2954a(C1651gw c1651gw) {
        return c1651gw != null && this.f2377a == c1651gw.f2377a && this.f2379b == c1651gw.f2379b;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1651gw c1651gw) {
        int m3315a;
        int m3315a2;
        if (!getClass().equals(c1651gw.getClass())) {
            return getClass().getName().compareTo(c1651gw.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2953a()).compareTo(Boolean.valueOf(c1651gw.m2953a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2953a() && (m3315a2 = C1672hq.m3315a(this.f2377a, c1651gw.f2377a)) != 0) {
            return m3315a2;
        }
        int compareTo2 = Boolean.valueOf(m2957b()).compareTo(Boolean.valueOf(c1651gw.m2957b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!m2957b() || (m3315a = C1672hq.m3315a(this.f2379b, c1651gw.f2379b)) == 0) {
            return 0;
        }
        return m3315a;
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
                if (s == 2) {
                    if (mo3340a.f2770a == 8) {
                        this.f2379b = abstractC1681hz.mo3338a();
                        m2956b(true);
                    } else {
                        C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                    }
                } else {
                    C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                }
            } else if (mo3340a.f2770a == 8) {
                this.f2377a = abstractC1681hz.mo3338a();
                m2952a(true);
            } else {
                C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
            }
            abstractC1681hz.mo3369g();
        }
        abstractC1681hz.mo3368f();
        if (!m2953a()) {
            throw new C1683ia("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        }
        if (!m2957b()) {
            throw new C1683ia("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
        m2951a();
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2951a();
        abstractC1681hz.mo3356a(f2375a);
        abstractC1681hz.mo3353a(f2374a);
        abstractC1681hz.mo3351a(this.f2377a);
        abstractC1681hz.mo3362b();
        abstractC1681hz.mo3353a(f2376b);
        abstractC1681hz.mo3351a(this.f2379b);
        abstractC1681hz.mo3362b();
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f2377a + ", pluginConfigVersion:" + this.f2379b + ")";
    }
}
