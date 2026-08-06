package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.hi */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1664hi implements InterfaceC1671hp<C1664hi, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public C1648gt f2637a;

    /* renamed from: a */
    public String f2638a;

    /* renamed from: a */
    public List<String> f2639a;

    /* renamed from: b */
    public String f2640b;

    /* renamed from: c */
    public String f2641c;

    /* renamed from: d */
    public String f2642d;

    /* renamed from: e */
    public String f2643e;

    /* renamed from: f */
    public String f2644f;

    /* renamed from: a */
    private static final C1687ie f2629a = new C1687ie("XmPushActionSubscription");

    /* renamed from: a */
    private static final C1678hw f2628a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f2630b = new C1678hw("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1678hw f2631c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2632d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2633e = new C1678hw("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1678hw f2634f = new C1678hw("", (byte) 11, 6);

    /* renamed from: g */
    private static final C1678hw f2635g = new C1678hw("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1678hw f2636h = new C1678hw("", (byte) 15, 8);

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m3209a() {
        return this.f2638a != null;
    }

    /* renamed from: b */
    public boolean m3212b() {
        return this.f2637a != null;
    }

    /* renamed from: a */
    public C1664hi m3207a(String str) {
        this.f2640b = str;
        return this;
    }

    /* renamed from: c */
    public boolean m3214c() {
        return this.f2640b != null;
    }

    /* renamed from: b */
    public C1664hi m3211b(String str) {
        this.f2641c = str;
        return this;
    }

    /* renamed from: d */
    public boolean m3216d() {
        return this.f2641c != null;
    }

    /* renamed from: c */
    public C1664hi m3213c(String str) {
        this.f2642d = str;
        return this;
    }

    /* renamed from: e */
    public boolean m3218e() {
        return this.f2642d != null;
    }

    /* renamed from: d */
    public C1664hi m3215d(String str) {
        this.f2643e = str;
        return this;
    }

    /* renamed from: f */
    public boolean m3219f() {
        return this.f2643e != null;
    }

    /* renamed from: e */
    public C1664hi m3217e(String str) {
        this.f2644f = str;
        return this;
    }

    /* renamed from: g */
    public boolean m3220g() {
        return this.f2644f != null;
    }

    /* renamed from: h */
    public boolean m3221h() {
        return this.f2639a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1664hi)) {
            return m3210a((C1664hi) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3210a(C1664hi c1664hi) {
        if (c1664hi == null) {
            return false;
        }
        boolean m3209a = m3209a();
        boolean m3209a2 = c1664hi.m3209a();
        if ((m3209a || m3209a2) && !(m3209a && m3209a2 && this.f2638a.equals(c1664hi.f2638a))) {
            return false;
        }
        boolean m3212b = m3212b();
        boolean m3212b2 = c1664hi.m3212b();
        if ((m3212b || m3212b2) && !(m3212b && m3212b2 && this.f2637a.m2884a(c1664hi.f2637a))) {
            return false;
        }
        boolean m3214c = m3214c();
        boolean m3214c2 = c1664hi.m3214c();
        if ((m3214c || m3214c2) && !(m3214c && m3214c2 && this.f2640b.equals(c1664hi.f2640b))) {
            return false;
        }
        boolean m3216d = m3216d();
        boolean m3216d2 = c1664hi.m3216d();
        if ((m3216d || m3216d2) && !(m3216d && m3216d2 && this.f2641c.equals(c1664hi.f2641c))) {
            return false;
        }
        boolean m3218e = m3218e();
        boolean m3218e2 = c1664hi.m3218e();
        if ((m3218e || m3218e2) && !(m3218e && m3218e2 && this.f2642d.equals(c1664hi.f2642d))) {
            return false;
        }
        boolean m3219f = m3219f();
        boolean m3219f2 = c1664hi.m3219f();
        if ((m3219f || m3219f2) && !(m3219f && m3219f2 && this.f2643e.equals(c1664hi.f2643e))) {
            return false;
        }
        boolean m3220g = m3220g();
        boolean m3220g2 = c1664hi.m3220g();
        if ((m3220g || m3220g2) && !(m3220g && m3220g2 && this.f2644f.equals(c1664hi.f2644f))) {
            return false;
        }
        boolean m3221h = m3221h();
        boolean m3221h2 = c1664hi.m3221h();
        if (m3221h || m3221h2) {
            return m3221h && m3221h2 && this.f2639a.equals(c1664hi.f2639a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1664hi c1664hi) {
        int m3320a;
        int m3318a;
        int m3318a2;
        int m3318a3;
        int m3318a4;
        int m3318a5;
        int m3317a;
        int m3318a6;
        if (!getClass().equals(c1664hi.getClass())) {
            return getClass().getName().compareTo(c1664hi.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3209a()).compareTo(Boolean.valueOf(c1664hi.m3209a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3209a() && (m3318a6 = C1672hq.m3318a(this.f2638a, c1664hi.f2638a)) != 0) {
            return m3318a6;
        }
        int compareTo2 = Boolean.valueOf(m3212b()).compareTo(Boolean.valueOf(c1664hi.m3212b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3212b() && (m3317a = C1672hq.m3317a(this.f2637a, c1664hi.f2637a)) != 0) {
            return m3317a;
        }
        int compareTo3 = Boolean.valueOf(m3214c()).compareTo(Boolean.valueOf(c1664hi.m3214c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3214c() && (m3318a5 = C1672hq.m3318a(this.f2640b, c1664hi.f2640b)) != 0) {
            return m3318a5;
        }
        int compareTo4 = Boolean.valueOf(m3216d()).compareTo(Boolean.valueOf(c1664hi.m3216d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3216d() && (m3318a4 = C1672hq.m3318a(this.f2641c, c1664hi.f2641c)) != 0) {
            return m3318a4;
        }
        int compareTo5 = Boolean.valueOf(m3218e()).compareTo(Boolean.valueOf(c1664hi.m3218e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3218e() && (m3318a3 = C1672hq.m3318a(this.f2642d, c1664hi.f2642d)) != 0) {
            return m3318a3;
        }
        int compareTo6 = Boolean.valueOf(m3219f()).compareTo(Boolean.valueOf(c1664hi.m3219f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3219f() && (m3318a2 = C1672hq.m3318a(this.f2643e, c1664hi.f2643e)) != 0) {
            return m3318a2;
        }
        int compareTo7 = Boolean.valueOf(m3220g()).compareTo(Boolean.valueOf(c1664hi.m3220g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3220g() && (m3318a = C1672hq.m3318a(this.f2644f, c1664hi.f2644f)) != 0) {
            return m3318a;
        }
        int compareTo8 = Boolean.valueOf(m3221h()).compareTo(Boolean.valueOf(c1664hi.m3221h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!m3221h() || (m3320a = C1672hq.m3320a(this.f2639a, c1664hi.f2639a)) == 0) {
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
                switch (mo3340a.f2772a) {
                    case 1:
                        if (mo3340a.f2770a == 11) {
                            this.f2638a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2637a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2640b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2641c = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 11) {
                            this.f2642d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                        if (mo3340a.f2770a == 11) {
                            this.f2643e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f2644f = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 15) {
                            C1679hx mo3341a = abstractC1681hz.mo3341a();
                            this.f2639a = new ArrayList(mo3341a.f2774a);
                            for (int i = 0; i < mo3341a.f2774a; i++) {
                                this.f2639a.add(abstractC1681hz.mo3345a());
                            }
                            abstractC1681hz.mo3371i();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    default:
                        C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                        break;
                }
                abstractC1681hz.mo3369g();
            } else {
                abstractC1681hz.mo3368f();
                m3208a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m3208a();
        abstractC1681hz.mo3356a(f2629a);
        if (this.f2638a != null && m3209a()) {
            abstractC1681hz.mo3353a(f2628a);
            abstractC1681hz.mo3357a(this.f2638a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2637a != null && m3212b()) {
            abstractC1681hz.mo3353a(f2630b);
            this.f2637a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2640b != null) {
            abstractC1681hz.mo3353a(f2631c);
            abstractC1681hz.mo3357a(this.f2640b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2641c != null) {
            abstractC1681hz.mo3353a(f2632d);
            abstractC1681hz.mo3357a(this.f2641c);
            abstractC1681hz.mo3362b();
        }
        if (this.f2642d != null) {
            abstractC1681hz.mo3353a(f2633e);
            abstractC1681hz.mo3357a(this.f2642d);
            abstractC1681hz.mo3362b();
        }
        if (this.f2643e != null && m3219f()) {
            abstractC1681hz.mo3353a(f2634f);
            abstractC1681hz.mo3357a(this.f2643e);
            abstractC1681hz.mo3362b();
        }
        if (this.f2644f != null && m3220g()) {
            abstractC1681hz.mo3353a(f2635g);
            abstractC1681hz.mo3357a(this.f2644f);
            abstractC1681hz.mo3362b();
        }
        if (this.f2639a != null && m3221h()) {
            abstractC1681hz.mo3353a(f2636h);
            abstractC1681hz.mo3354a(new C1679hx((byte) 11, this.f2639a.size()));
            Iterator<String> it = this.f2639a.iterator();
            while (it.hasNext()) {
                abstractC1681hz.mo3357a(it.next());
            }
            abstractC1681hz.mo3367e();
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = false;
        if (m3209a()) {
            sb.append("debug:");
            String str = this.f2638a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m3212b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1648gt c1648gt = this.f2637a;
            if (c1648gt == null) {
                sb.append("null");
            } else {
                sb.append(c1648gt);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f2640b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f2641c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f2642d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (m3219f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f2643e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m3220g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f2644f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m3221h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f2639a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m3208a() {
        if (this.f2640b == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f2641c == null) {
            throw new C1683ia("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f2642d == null) {
            throw new C1683ia("Required field 'topic' was not present! Struct: " + toString());
        }
    }
}
