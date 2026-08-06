package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.hm */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1668hm implements InterfaceC1671hp<C1668hm, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public C1648gt f2720a;

    /* renamed from: a */
    public String f2721a;

    /* renamed from: a */
    public List<String> f2722a;

    /* renamed from: b */
    public String f2723b;

    /* renamed from: c */
    public String f2724c;

    /* renamed from: d */
    public String f2725d;

    /* renamed from: e */
    public String f2726e;

    /* renamed from: f */
    public String f2727f;

    /* renamed from: a */
    private static final C1687ie f2712a = new C1687ie("XmPushActionUnSubscription");

    /* renamed from: a */
    private static final C1678hw f2711a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f2713b = new C1678hw("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1678hw f2714c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2715d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2716e = new C1678hw("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1678hw f2717f = new C1678hw("", (byte) 11, 6);

    /* renamed from: g */
    private static final C1678hw f2718g = new C1678hw("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1678hw f2719h = new C1678hw("", (byte) 15, 8);

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m3279a() {
        return this.f2721a != null;
    }

    /* renamed from: b */
    public boolean m3282b() {
        return this.f2720a != null;
    }

    /* renamed from: a */
    public C1668hm m3277a(String str) {
        this.f2723b = str;
        return this;
    }

    /* renamed from: c */
    public boolean m3284c() {
        return this.f2723b != null;
    }

    /* renamed from: b */
    public C1668hm m3281b(String str) {
        this.f2724c = str;
        return this;
    }

    /* renamed from: d */
    public boolean m3286d() {
        return this.f2724c != null;
    }

    /* renamed from: c */
    public C1668hm m3283c(String str) {
        this.f2725d = str;
        return this;
    }

    /* renamed from: e */
    public boolean m3288e() {
        return this.f2725d != null;
    }

    /* renamed from: d */
    public C1668hm m3285d(String str) {
        this.f2726e = str;
        return this;
    }

    /* renamed from: f */
    public boolean m3289f() {
        return this.f2726e != null;
    }

    /* renamed from: e */
    public C1668hm m3287e(String str) {
        this.f2727f = str;
        return this;
    }

    /* renamed from: g */
    public boolean m3290g() {
        return this.f2727f != null;
    }

    /* renamed from: h */
    public boolean m3291h() {
        return this.f2722a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1668hm)) {
            return m3280a((C1668hm) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3280a(C1668hm c1668hm) {
        if (c1668hm == null) {
            return false;
        }
        boolean m3279a = m3279a();
        boolean m3279a2 = c1668hm.m3279a();
        if ((m3279a || m3279a2) && !(m3279a && m3279a2 && this.f2721a.equals(c1668hm.f2721a))) {
            return false;
        }
        boolean m3282b = m3282b();
        boolean m3282b2 = c1668hm.m3282b();
        if ((m3282b || m3282b2) && !(m3282b && m3282b2 && this.f2720a.m2884a(c1668hm.f2720a))) {
            return false;
        }
        boolean m3284c = m3284c();
        boolean m3284c2 = c1668hm.m3284c();
        if ((m3284c || m3284c2) && !(m3284c && m3284c2 && this.f2723b.equals(c1668hm.f2723b))) {
            return false;
        }
        boolean m3286d = m3286d();
        boolean m3286d2 = c1668hm.m3286d();
        if ((m3286d || m3286d2) && !(m3286d && m3286d2 && this.f2724c.equals(c1668hm.f2724c))) {
            return false;
        }
        boolean m3288e = m3288e();
        boolean m3288e2 = c1668hm.m3288e();
        if ((m3288e || m3288e2) && !(m3288e && m3288e2 && this.f2725d.equals(c1668hm.f2725d))) {
            return false;
        }
        boolean m3289f = m3289f();
        boolean m3289f2 = c1668hm.m3289f();
        if ((m3289f || m3289f2) && !(m3289f && m3289f2 && this.f2726e.equals(c1668hm.f2726e))) {
            return false;
        }
        boolean m3290g = m3290g();
        boolean m3290g2 = c1668hm.m3290g();
        if ((m3290g || m3290g2) && !(m3290g && m3290g2 && this.f2727f.equals(c1668hm.f2727f))) {
            return false;
        }
        boolean m3291h = m3291h();
        boolean m3291h2 = c1668hm.m3291h();
        if (m3291h || m3291h2) {
            return m3291h && m3291h2 && this.f2722a.equals(c1668hm.f2722a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1668hm c1668hm) {
        int m3320a;
        int m3318a;
        int m3318a2;
        int m3318a3;
        int m3318a4;
        int m3318a5;
        int m3317a;
        int m3318a6;
        if (!getClass().equals(c1668hm.getClass())) {
            return getClass().getName().compareTo(c1668hm.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3279a()).compareTo(Boolean.valueOf(c1668hm.m3279a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3279a() && (m3318a6 = C1672hq.m3318a(this.f2721a, c1668hm.f2721a)) != 0) {
            return m3318a6;
        }
        int compareTo2 = Boolean.valueOf(m3282b()).compareTo(Boolean.valueOf(c1668hm.m3282b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3282b() && (m3317a = C1672hq.m3317a(this.f2720a, c1668hm.f2720a)) != 0) {
            return m3317a;
        }
        int compareTo3 = Boolean.valueOf(m3284c()).compareTo(Boolean.valueOf(c1668hm.m3284c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3284c() && (m3318a5 = C1672hq.m3318a(this.f2723b, c1668hm.f2723b)) != 0) {
            return m3318a5;
        }
        int compareTo4 = Boolean.valueOf(m3286d()).compareTo(Boolean.valueOf(c1668hm.m3286d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3286d() && (m3318a4 = C1672hq.m3318a(this.f2724c, c1668hm.f2724c)) != 0) {
            return m3318a4;
        }
        int compareTo5 = Boolean.valueOf(m3288e()).compareTo(Boolean.valueOf(c1668hm.m3288e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3288e() && (m3318a3 = C1672hq.m3318a(this.f2725d, c1668hm.f2725d)) != 0) {
            return m3318a3;
        }
        int compareTo6 = Boolean.valueOf(m3289f()).compareTo(Boolean.valueOf(c1668hm.m3289f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3289f() && (m3318a2 = C1672hq.m3318a(this.f2726e, c1668hm.f2726e)) != 0) {
            return m3318a2;
        }
        int compareTo7 = Boolean.valueOf(m3290g()).compareTo(Boolean.valueOf(c1668hm.m3290g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3290g() && (m3318a = C1672hq.m3318a(this.f2727f, c1668hm.f2727f)) != 0) {
            return m3318a;
        }
        int compareTo8 = Boolean.valueOf(m3291h()).compareTo(Boolean.valueOf(c1668hm.m3291h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!m3291h() || (m3320a = C1672hq.m3320a(this.f2722a, c1668hm.f2722a)) == 0) {
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
                            this.f2721a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2720a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2723b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2724c = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 11) {
                            this.f2725d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                        if (mo3340a.f2770a == 11) {
                            this.f2726e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f2727f = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 15) {
                            C1679hx mo3341a = abstractC1681hz.mo3341a();
                            this.f2722a = new ArrayList(mo3341a.f2774a);
                            for (int i = 0; i < mo3341a.f2774a; i++) {
                                this.f2722a.add(abstractC1681hz.mo3345a());
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
                m3278a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m3278a();
        abstractC1681hz.mo3356a(f2712a);
        if (this.f2721a != null && m3279a()) {
            abstractC1681hz.mo3353a(f2711a);
            abstractC1681hz.mo3357a(this.f2721a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2720a != null && m3282b()) {
            abstractC1681hz.mo3353a(f2713b);
            this.f2720a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2723b != null) {
            abstractC1681hz.mo3353a(f2714c);
            abstractC1681hz.mo3357a(this.f2723b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2724c != null) {
            abstractC1681hz.mo3353a(f2715d);
            abstractC1681hz.mo3357a(this.f2724c);
            abstractC1681hz.mo3362b();
        }
        if (this.f2725d != null) {
            abstractC1681hz.mo3353a(f2716e);
            abstractC1681hz.mo3357a(this.f2725d);
            abstractC1681hz.mo3362b();
        }
        if (this.f2726e != null && m3289f()) {
            abstractC1681hz.mo3353a(f2717f);
            abstractC1681hz.mo3357a(this.f2726e);
            abstractC1681hz.mo3362b();
        }
        if (this.f2727f != null && m3290g()) {
            abstractC1681hz.mo3353a(f2718g);
            abstractC1681hz.mo3357a(this.f2727f);
            abstractC1681hz.mo3362b();
        }
        if (this.f2722a != null && m3291h()) {
            abstractC1681hz.mo3353a(f2719h);
            abstractC1681hz.mo3354a(new C1679hx((byte) 11, this.f2722a.size()));
            Iterator<String> it = this.f2722a.iterator();
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
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = false;
        if (m3279a()) {
            sb.append("debug:");
            String str = this.f2721a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m3282b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1648gt c1648gt = this.f2720a;
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
        String str2 = this.f2723b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f2724c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f2725d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (m3289f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f2726e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m3290g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f2727f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m3291h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f2722a;
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
    public void m3278a() {
        if (this.f2723b == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f2724c == null) {
            throw new C1683ia("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f2725d == null) {
            throw new C1683ia("Required field 'topic' was not present! Struct: " + toString());
        }
    }
}
