package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.hk */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1666hk implements InterfaceC1671hp<C1666hk, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f2678a;

    /* renamed from: a */
    public C1648gt f2679a;

    /* renamed from: a */
    public String f2680a;

    /* renamed from: a */
    private BitSet f2681a = new BitSet(2);

    /* renamed from: a */
    public boolean f2682a = true;

    /* renamed from: b */
    public String f2683b;

    /* renamed from: c */
    public String f2684c;

    /* renamed from: d */
    public String f2685d;

    /* renamed from: e */
    public String f2686e;

    /* renamed from: f */
    public String f2687f;

    /* renamed from: g */
    public String f2688g;

    /* renamed from: h */
    public String f2689h;

    /* renamed from: i */
    public String f2690i;

    /* renamed from: a */
    private static final C1687ie f2666a = new C1687ie("XmPushActionUnRegistration");

    /* renamed from: a */
    private static final C1678hw f2665a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f2667b = new C1678hw("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1678hw f2668c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2669d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2670e = new C1678hw("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1678hw f2671f = new C1678hw("", (byte) 11, 6);

    /* renamed from: g */
    private static final C1678hw f2672g = new C1678hw("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1678hw f2673h = new C1678hw("", (byte) 11, 8);

    /* renamed from: i */
    private static final C1678hw f2674i = new C1678hw("", (byte) 11, 9);

    /* renamed from: j */
    private static final C1678hw f2675j = new C1678hw("", (byte) 11, 10);

    /* renamed from: k */
    private static final C1678hw f2676k = new C1678hw("", (byte) 2, 11);

    /* renamed from: l */
    private static final C1678hw f2677l = new C1678hw("", (byte) 10, 12);

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m3242a() {
        return this.f2680a != null;
    }

    /* renamed from: b */
    public boolean m3246b() {
        return this.f2679a != null;
    }

    /* renamed from: a */
    public C1666hk m3239a(String str) {
        this.f2683b = str;
        return this;
    }

    /* renamed from: c */
    public boolean m3248c() {
        return this.f2683b != null;
    }

    /* renamed from: b */
    public C1666hk m3244b(String str) {
        this.f2684c = str;
        return this;
    }

    /* renamed from: d */
    public boolean m3250d() {
        return this.f2684c != null;
    }

    /* renamed from: c */
    public C1666hk m3247c(String str) {
        this.f2685d = str;
        return this;
    }

    /* renamed from: e */
    public boolean m3252e() {
        return this.f2685d != null;
    }

    /* renamed from: f */
    public boolean m3253f() {
        return this.f2686e != null;
    }

    /* renamed from: d */
    public C1666hk m3249d(String str) {
        this.f2687f = str;
        return this;
    }

    /* renamed from: g */
    public boolean m3254g() {
        return this.f2687f != null;
    }

    /* renamed from: e */
    public C1666hk m3251e(String str) {
        this.f2688g = str;
        return this;
    }

    /* renamed from: h */
    public boolean m3255h() {
        return this.f2688g != null;
    }

    /* renamed from: i */
    public boolean m3256i() {
        return this.f2689h != null;
    }

    /* renamed from: j */
    public boolean m3257j() {
        return this.f2690i != null;
    }

    /* renamed from: k */
    public boolean m3258k() {
        return this.f2681a.get(0);
    }

    /* renamed from: a */
    public void m3241a(boolean z) {
        this.f2681a.set(0, z);
    }

    /* renamed from: l */
    public boolean m3259l() {
        return this.f2681a.get(1);
    }

    /* renamed from: b */
    public void m3245b(boolean z) {
        this.f2681a.set(1, z);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1666hk)) {
            return m3243a((C1666hk) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3243a(C1666hk c1666hk) {
        if (c1666hk == null) {
            return false;
        }
        boolean m3242a = m3242a();
        boolean m3242a2 = c1666hk.m3242a();
        if ((m3242a || m3242a2) && !(m3242a && m3242a2 && this.f2680a.equals(c1666hk.f2680a))) {
            return false;
        }
        boolean m3246b = m3246b();
        boolean m3246b2 = c1666hk.m3246b();
        if ((m3246b || m3246b2) && !(m3246b && m3246b2 && this.f2679a.m2884a(c1666hk.f2679a))) {
            return false;
        }
        boolean m3248c = m3248c();
        boolean m3248c2 = c1666hk.m3248c();
        if ((m3248c || m3248c2) && !(m3248c && m3248c2 && this.f2683b.equals(c1666hk.f2683b))) {
            return false;
        }
        boolean m3250d = m3250d();
        boolean m3250d2 = c1666hk.m3250d();
        if ((m3250d || m3250d2) && !(m3250d && m3250d2 && this.f2684c.equals(c1666hk.f2684c))) {
            return false;
        }
        boolean m3252e = m3252e();
        boolean m3252e2 = c1666hk.m3252e();
        if ((m3252e || m3252e2) && !(m3252e && m3252e2 && this.f2685d.equals(c1666hk.f2685d))) {
            return false;
        }
        boolean m3253f = m3253f();
        boolean m3253f2 = c1666hk.m3253f();
        if ((m3253f || m3253f2) && !(m3253f && m3253f2 && this.f2686e.equals(c1666hk.f2686e))) {
            return false;
        }
        boolean m3254g = m3254g();
        boolean m3254g2 = c1666hk.m3254g();
        if ((m3254g || m3254g2) && !(m3254g && m3254g2 && this.f2687f.equals(c1666hk.f2687f))) {
            return false;
        }
        boolean m3255h = m3255h();
        boolean m3255h2 = c1666hk.m3255h();
        if ((m3255h || m3255h2) && !(m3255h && m3255h2 && this.f2688g.equals(c1666hk.f2688g))) {
            return false;
        }
        boolean m3256i = m3256i();
        boolean m3256i2 = c1666hk.m3256i();
        if ((m3256i || m3256i2) && !(m3256i && m3256i2 && this.f2689h.equals(c1666hk.f2689h))) {
            return false;
        }
        boolean m3257j = m3257j();
        boolean m3257j2 = c1666hk.m3257j();
        if ((m3257j || m3257j2) && !(m3257j && m3257j2 && this.f2690i.equals(c1666hk.f2690i))) {
            return false;
        }
        boolean m3258k = m3258k();
        boolean m3258k2 = c1666hk.m3258k();
        if ((m3258k || m3258k2) && !(m3258k && m3258k2 && this.f2682a == c1666hk.f2682a)) {
            return false;
        }
        boolean m3259l = m3259l();
        boolean m3259l2 = c1666hk.m3259l();
        if (m3259l || m3259l2) {
            return m3259l && m3259l2 && this.f2678a == c1666hk.f2678a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1666hk c1666hk) {
        int m3316a;
        int m3324a;
        int m3318a;
        int m3318a2;
        int m3318a3;
        int m3318a4;
        int m3318a5;
        int m3318a6;
        int m3318a7;
        int m3318a8;
        int m3317a;
        int m3318a9;
        if (!getClass().equals(c1666hk.getClass())) {
            return getClass().getName().compareTo(c1666hk.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3242a()).compareTo(Boolean.valueOf(c1666hk.m3242a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3242a() && (m3318a9 = C1672hq.m3318a(this.f2680a, c1666hk.f2680a)) != 0) {
            return m3318a9;
        }
        int compareTo2 = Boolean.valueOf(m3246b()).compareTo(Boolean.valueOf(c1666hk.m3246b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3246b() && (m3317a = C1672hq.m3317a(this.f2679a, c1666hk.f2679a)) != 0) {
            return m3317a;
        }
        int compareTo3 = Boolean.valueOf(m3248c()).compareTo(Boolean.valueOf(c1666hk.m3248c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3248c() && (m3318a8 = C1672hq.m3318a(this.f2683b, c1666hk.f2683b)) != 0) {
            return m3318a8;
        }
        int compareTo4 = Boolean.valueOf(m3250d()).compareTo(Boolean.valueOf(c1666hk.m3250d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3250d() && (m3318a7 = C1672hq.m3318a(this.f2684c, c1666hk.f2684c)) != 0) {
            return m3318a7;
        }
        int compareTo5 = Boolean.valueOf(m3252e()).compareTo(Boolean.valueOf(c1666hk.m3252e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3252e() && (m3318a6 = C1672hq.m3318a(this.f2685d, c1666hk.f2685d)) != 0) {
            return m3318a6;
        }
        int compareTo6 = Boolean.valueOf(m3253f()).compareTo(Boolean.valueOf(c1666hk.m3253f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3253f() && (m3318a5 = C1672hq.m3318a(this.f2686e, c1666hk.f2686e)) != 0) {
            return m3318a5;
        }
        int compareTo7 = Boolean.valueOf(m3254g()).compareTo(Boolean.valueOf(c1666hk.m3254g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3254g() && (m3318a4 = C1672hq.m3318a(this.f2687f, c1666hk.f2687f)) != 0) {
            return m3318a4;
        }
        int compareTo8 = Boolean.valueOf(m3255h()).compareTo(Boolean.valueOf(c1666hk.m3255h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3255h() && (m3318a3 = C1672hq.m3318a(this.f2688g, c1666hk.f2688g)) != 0) {
            return m3318a3;
        }
        int compareTo9 = Boolean.valueOf(m3256i()).compareTo(Boolean.valueOf(c1666hk.m3256i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3256i() && (m3318a2 = C1672hq.m3318a(this.f2689h, c1666hk.f2689h)) != 0) {
            return m3318a2;
        }
        int compareTo10 = Boolean.valueOf(m3257j()).compareTo(Boolean.valueOf(c1666hk.m3257j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3257j() && (m3318a = C1672hq.m3318a(this.f2690i, c1666hk.f2690i)) != 0) {
            return m3318a;
        }
        int compareTo11 = Boolean.valueOf(m3258k()).compareTo(Boolean.valueOf(c1666hk.m3258k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m3258k() && (m3324a = C1672hq.m3324a(this.f2682a, c1666hk.f2682a)) != 0) {
            return m3324a;
        }
        int compareTo12 = Boolean.valueOf(m3259l()).compareTo(Boolean.valueOf(c1666hk.m3259l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!m3259l() || (m3316a = C1672hq.m3316a(this.f2678a, c1666hk.f2678a)) == 0) {
            return 0;
        }
        return m3316a;
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
                            this.f2680a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2679a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2683b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2684c = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 11) {
                            this.f2685d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                        if (mo3340a.f2770a == 11) {
                            this.f2686e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f2687f = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 11) {
                            this.f2688g = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 9:
                        if (mo3340a.f2770a == 11) {
                            this.f2689h = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 11) {
                            this.f2690i = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 11:
                        if (mo3340a.f2770a == 2) {
                            this.f2682a = abstractC1681hz.mo3361a();
                            m3241a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 12:
                        if (mo3340a.f2770a == 10) {
                            this.f2678a = abstractC1681hz.mo3339a();
                            m3245b(true);
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
                m3240a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m3240a();
        abstractC1681hz.mo3356a(f2666a);
        if (this.f2680a != null && m3242a()) {
            abstractC1681hz.mo3353a(f2665a);
            abstractC1681hz.mo3357a(this.f2680a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2679a != null && m3246b()) {
            abstractC1681hz.mo3353a(f2667b);
            this.f2679a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2683b != null) {
            abstractC1681hz.mo3353a(f2668c);
            abstractC1681hz.mo3357a(this.f2683b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2684c != null) {
            abstractC1681hz.mo3353a(f2669d);
            abstractC1681hz.mo3357a(this.f2684c);
            abstractC1681hz.mo3362b();
        }
        if (this.f2685d != null && m3252e()) {
            abstractC1681hz.mo3353a(f2670e);
            abstractC1681hz.mo3357a(this.f2685d);
            abstractC1681hz.mo3362b();
        }
        if (this.f2686e != null && m3253f()) {
            abstractC1681hz.mo3353a(f2671f);
            abstractC1681hz.mo3357a(this.f2686e);
            abstractC1681hz.mo3362b();
        }
        if (this.f2687f != null && m3254g()) {
            abstractC1681hz.mo3353a(f2672g);
            abstractC1681hz.mo3357a(this.f2687f);
            abstractC1681hz.mo3362b();
        }
        if (this.f2688g != null && m3255h()) {
            abstractC1681hz.mo3353a(f2673h);
            abstractC1681hz.mo3357a(this.f2688g);
            abstractC1681hz.mo3362b();
        }
        if (this.f2689h != null && m3256i()) {
            abstractC1681hz.mo3353a(f2674i);
            abstractC1681hz.mo3357a(this.f2689h);
            abstractC1681hz.mo3362b();
        }
        if (this.f2690i != null && m3257j()) {
            abstractC1681hz.mo3353a(f2675j);
            abstractC1681hz.mo3357a(this.f2690i);
            abstractC1681hz.mo3362b();
        }
        if (m3258k()) {
            abstractC1681hz.mo3353a(f2676k);
            abstractC1681hz.mo3360a(this.f2682a);
            abstractC1681hz.mo3362b();
        }
        if (m3259l()) {
            abstractC1681hz.mo3353a(f2677l);
            abstractC1681hz.mo3352a(this.f2678a);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = false;
        if (m3242a()) {
            sb.append("debug:");
            String str = this.f2680a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m3246b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1648gt c1648gt = this.f2679a;
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
        String str2 = this.f2683b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f2684c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (m3252e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.f2685d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m3253f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f2686e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m3254g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f2687f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m3255h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.f2688g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (m3256i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.f2689h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m3257j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f2690i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (m3258k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f2682a);
        }
        if (m3259l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f2678a);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m3240a() {
        if (this.f2683b == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f2684c == null) {
            throw new C1683ia("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
