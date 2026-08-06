package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.gx */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1652gx implements InterfaceC1671hp<C1652gx, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public List<C1641gm> f2382a;

    /* renamed from: a */
    private static final C1687ie f2381a = new C1687ie("XmPushActionCollectData");

    /* renamed from: a */
    private static final C1678hw f2380a = new C1678hw("", (byte) 15, 1);

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public C1652gx m2959a(List<C1641gm> list) {
        this.f2382a = list;
        return this;
    }

    /* renamed from: a */
    public boolean m2961a() {
        return this.f2382a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1652gx)) {
            return m2962a((C1652gx) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2962a(C1652gx c1652gx) {
        if (c1652gx == null) {
            return false;
        }
        boolean m2961a = m2961a();
        boolean m2961a2 = c1652gx.m2961a();
        if (m2961a || m2961a2) {
            return m2961a && m2961a2 && this.f2382a.equals(c1652gx.f2382a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1652gx c1652gx) {
        int m3320a;
        if (!getClass().equals(c1652gx.getClass())) {
            return getClass().getName().compareTo(c1652gx.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2961a()).compareTo(Boolean.valueOf(c1652gx.m2961a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m2961a() || (m3320a = C1672hq.m3320a(this.f2382a, c1652gx.f2382a)) == 0) {
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
                        this.f2382a = new ArrayList(mo3341a.f2774a);
                        for (int i = 0; i < mo3341a.f2774a; i++) {
                            C1641gm c1641gm = new C1641gm();
                            c1641gm.mo2352a(abstractC1681hz);
                            this.f2382a.add(c1641gm);
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
                m2960a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2960a();
        abstractC1681hz.mo3356a(f2381a);
        if (this.f2382a != null) {
            abstractC1681hz.mo3353a(f2380a);
            abstractC1681hz.mo3354a(new C1679hx((byte) 12, this.f2382a.size()));
            Iterator<C1641gm> it = this.f2382a.iterator();
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
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(dataCollectionItems:");
        List<C1641gm> list = this.f2382a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m2960a() {
        if (this.f2382a == null) {
            throw new C1683ia("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }
}
