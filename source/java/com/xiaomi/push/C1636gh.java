package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.gh */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1636gh implements InterfaceC1671hp<C1636gh, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public List<C1637gi> f1963a;

    /* renamed from: a */
    private static final C1687ie f1962a = new C1687ie("ClientUploadData");

    /* renamed from: a */
    private static final C1678hw f1961a = new C1678hw("", (byte) 15, 1);

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public int m2718a() {
        List<C1637gi> list = this.f1963a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: a */
    public void m2721a(C1637gi c1637gi) {
        if (this.f1963a == null) {
            this.f1963a = new ArrayList();
        }
        this.f1963a.add(c1637gi);
    }

    /* renamed from: a */
    public boolean m2722a() {
        return this.f1963a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1636gh)) {
            return m2723a((C1636gh) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2723a(C1636gh c1636gh) {
        if (c1636gh == null) {
            return false;
        }
        boolean m2722a = m2722a();
        boolean m2722a2 = c1636gh.m2722a();
        if (m2722a || m2722a2) {
            return m2722a && m2722a2 && this.f1963a.equals(c1636gh.f1963a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1636gh c1636gh) {
        int m3320a;
        if (!getClass().equals(c1636gh.getClass())) {
            return getClass().getName().compareTo(c1636gh.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2722a()).compareTo(Boolean.valueOf(c1636gh.m2722a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m2722a() || (m3320a = C1672hq.m3320a(this.f1963a, c1636gh.f1963a)) == 0) {
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
                        this.f1963a = new ArrayList(mo3341a.f2774a);
                        for (int i = 0; i < mo3341a.f2774a; i++) {
                            C1637gi c1637gi = new C1637gi();
                            c1637gi.mo2352a(abstractC1681hz);
                            this.f1963a.add(c1637gi);
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
                m2720a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2720a();
        abstractC1681hz.mo3356a(f1962a);
        if (this.f1963a != null) {
            abstractC1681hz.mo3353a(f1961a);
            abstractC1681hz.mo3354a(new C1679hx((byte) 12, this.f1963a.size()));
            Iterator<C1637gi> it = this.f1963a.iterator();
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
        StringBuilder sb = new StringBuilder("ClientUploadData(uploadDataItems:");
        List<C1637gi> list = this.f1963a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m2720a() {
        if (this.f1963a == null) {
            throw new C1683ia("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }
}
