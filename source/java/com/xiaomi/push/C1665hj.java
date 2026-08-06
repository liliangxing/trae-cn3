package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.hj */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1665hj implements InterfaceC1671hp<C1665hj, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f2655a;

    /* renamed from: a */
    public C1648gt f2656a;

    /* renamed from: a */
    public String f2657a;

    /* renamed from: a */
    private BitSet f2658a = new BitSet(1);

    /* renamed from: b */
    public String f2659b;

    /* renamed from: c */
    public String f2660c;

    /* renamed from: d */
    public String f2661d;

    /* renamed from: e */
    public String f2662e;

    /* renamed from: f */
    public String f2663f;

    /* renamed from: g */
    public String f2664g;

    /* renamed from: a */
    private static final C1687ie f2646a = new C1687ie("XmPushActionSubscriptionResult");

    /* renamed from: a */
    private static final C1678hw f2645a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f2647b = new C1678hw("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1678hw f2648c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2649d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2650e = new C1678hw("", (byte) 10, 6);

    /* renamed from: f */
    private static final C1678hw f2651f = new C1678hw("", (byte) 11, 7);

    /* renamed from: g */
    private static final C1678hw f2652g = new C1678hw("", (byte) 11, 8);

    /* renamed from: h */
    private static final C1678hw f2653h = new C1678hw("", (byte) 11, 9);

    /* renamed from: i */
    private static final C1678hw f2654i = new C1678hw("", (byte) 11, 10);

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m3226a() {
        return this.f2657a != null;
    }

    /* renamed from: b */
    public boolean m3229b() {
        return this.f2656a != null;
    }

    /* renamed from: a */
    public String m3223a() {
        return this.f2659b;
    }

    /* renamed from: c */
    public boolean m3231c() {
        return this.f2659b != null;
    }

    /* renamed from: d */
    public boolean m3232d() {
        return this.f2660c != null;
    }

    /* renamed from: e */
    public boolean m3233e() {
        return this.f2658a.get(0);
    }

    /* renamed from: a */
    public void m3225a(boolean z) {
        this.f2658a.set(0, z);
    }

    /* renamed from: f */
    public boolean m3234f() {
        return this.f2661d != null;
    }

    /* renamed from: b */
    public String m3228b() {
        return this.f2662e;
    }

    /* renamed from: g */
    public boolean m3235g() {
        return this.f2662e != null;
    }

    /* renamed from: h */
    public boolean m3236h() {
        return this.f2663f != null;
    }

    /* renamed from: c */
    public String m3230c() {
        return this.f2664g;
    }

    /* renamed from: i */
    public boolean m3237i() {
        return this.f2664g != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1665hj)) {
            return m3227a((C1665hj) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3227a(C1665hj c1665hj) {
        if (c1665hj == null) {
            return false;
        }
        boolean m3226a = m3226a();
        boolean m3226a2 = c1665hj.m3226a();
        if ((m3226a || m3226a2) && !(m3226a && m3226a2 && this.f2657a.equals(c1665hj.f2657a))) {
            return false;
        }
        boolean m3229b = m3229b();
        boolean m3229b2 = c1665hj.m3229b();
        if ((m3229b || m3229b2) && !(m3229b && m3229b2 && this.f2656a.m2884a(c1665hj.f2656a))) {
            return false;
        }
        boolean m3231c = m3231c();
        boolean m3231c2 = c1665hj.m3231c();
        if ((m3231c || m3231c2) && !(m3231c && m3231c2 && this.f2659b.equals(c1665hj.f2659b))) {
            return false;
        }
        boolean m3232d = m3232d();
        boolean m3232d2 = c1665hj.m3232d();
        if ((m3232d || m3232d2) && !(m3232d && m3232d2 && this.f2660c.equals(c1665hj.f2660c))) {
            return false;
        }
        boolean m3233e = m3233e();
        boolean m3233e2 = c1665hj.m3233e();
        if ((m3233e || m3233e2) && !(m3233e && m3233e2 && this.f2655a == c1665hj.f2655a)) {
            return false;
        }
        boolean m3234f = m3234f();
        boolean m3234f2 = c1665hj.m3234f();
        if ((m3234f || m3234f2) && !(m3234f && m3234f2 && this.f2661d.equals(c1665hj.f2661d))) {
            return false;
        }
        boolean m3235g = m3235g();
        boolean m3235g2 = c1665hj.m3235g();
        if ((m3235g || m3235g2) && !(m3235g && m3235g2 && this.f2662e.equals(c1665hj.f2662e))) {
            return false;
        }
        boolean m3236h = m3236h();
        boolean m3236h2 = c1665hj.m3236h();
        if ((m3236h || m3236h2) && !(m3236h && m3236h2 && this.f2663f.equals(c1665hj.f2663f))) {
            return false;
        }
        boolean m3237i = m3237i();
        boolean m3237i2 = c1665hj.m3237i();
        if (m3237i || m3237i2) {
            return m3237i && m3237i2 && this.f2664g.equals(c1665hj.f2664g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1665hj c1665hj) {
        int m3318a;
        int m3318a2;
        int m3318a3;
        int m3318a4;
        int m3316a;
        int m3318a5;
        int m3318a6;
        int m3317a;
        int m3318a7;
        if (!getClass().equals(c1665hj.getClass())) {
            return getClass().getName().compareTo(c1665hj.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3226a()).compareTo(Boolean.valueOf(c1665hj.m3226a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3226a() && (m3318a7 = C1672hq.m3318a(this.f2657a, c1665hj.f2657a)) != 0) {
            return m3318a7;
        }
        int compareTo2 = Boolean.valueOf(m3229b()).compareTo(Boolean.valueOf(c1665hj.m3229b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3229b() && (m3317a = C1672hq.m3317a(this.f2656a, c1665hj.f2656a)) != 0) {
            return m3317a;
        }
        int compareTo3 = Boolean.valueOf(m3231c()).compareTo(Boolean.valueOf(c1665hj.m3231c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3231c() && (m3318a6 = C1672hq.m3318a(this.f2659b, c1665hj.f2659b)) != 0) {
            return m3318a6;
        }
        int compareTo4 = Boolean.valueOf(m3232d()).compareTo(Boolean.valueOf(c1665hj.m3232d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3232d() && (m3318a5 = C1672hq.m3318a(this.f2660c, c1665hj.f2660c)) != 0) {
            return m3318a5;
        }
        int compareTo5 = Boolean.valueOf(m3233e()).compareTo(Boolean.valueOf(c1665hj.m3233e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3233e() && (m3316a = C1672hq.m3316a(this.f2655a, c1665hj.f2655a)) != 0) {
            return m3316a;
        }
        int compareTo6 = Boolean.valueOf(m3234f()).compareTo(Boolean.valueOf(c1665hj.m3234f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3234f() && (m3318a4 = C1672hq.m3318a(this.f2661d, c1665hj.f2661d)) != 0) {
            return m3318a4;
        }
        int compareTo7 = Boolean.valueOf(m3235g()).compareTo(Boolean.valueOf(c1665hj.m3235g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3235g() && (m3318a3 = C1672hq.m3318a(this.f2662e, c1665hj.f2662e)) != 0) {
            return m3318a3;
        }
        int compareTo8 = Boolean.valueOf(m3236h()).compareTo(Boolean.valueOf(c1665hj.m3236h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3236h() && (m3318a2 = C1672hq.m3318a(this.f2663f, c1665hj.f2663f)) != 0) {
            return m3318a2;
        }
        int compareTo9 = Boolean.valueOf(m3237i()).compareTo(Boolean.valueOf(c1665hj.m3237i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!m3237i() || (m3318a = C1672hq.m3318a(this.f2664g, c1665hj.f2664g)) == 0) {
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
            if (mo3340a.f2770a != 0) {
                switch (mo3340a.f2772a) {
                    case 1:
                        if (mo3340a.f2770a == 11) {
                            this.f2657a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2656a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2659b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2660c = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                    default:
                        C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                        break;
                    case 6:
                        if (mo3340a.f2770a == 10) {
                            this.f2655a = abstractC1681hz.mo3339a();
                            m3225a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f2661d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 11) {
                            this.f2662e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 9:
                        if (mo3340a.f2770a == 11) {
                            this.f2663f = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 11) {
                            this.f2664g = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                }
                abstractC1681hz.mo3369g();
            } else {
                abstractC1681hz.mo3368f();
                m3224a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m3224a();
        abstractC1681hz.mo3356a(f2646a);
        if (this.f2657a != null && m3226a()) {
            abstractC1681hz.mo3353a(f2645a);
            abstractC1681hz.mo3357a(this.f2657a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2656a != null && m3229b()) {
            abstractC1681hz.mo3353a(f2647b);
            this.f2656a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2659b != null) {
            abstractC1681hz.mo3353a(f2648c);
            abstractC1681hz.mo3357a(this.f2659b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2660c != null && m3232d()) {
            abstractC1681hz.mo3353a(f2649d);
            abstractC1681hz.mo3357a(this.f2660c);
            abstractC1681hz.mo3362b();
        }
        if (m3233e()) {
            abstractC1681hz.mo3353a(f2650e);
            abstractC1681hz.mo3352a(this.f2655a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2661d != null && m3234f()) {
            abstractC1681hz.mo3353a(f2651f);
            abstractC1681hz.mo3357a(this.f2661d);
            abstractC1681hz.mo3362b();
        }
        if (this.f2662e != null && m3235g()) {
            abstractC1681hz.mo3353a(f2652g);
            abstractC1681hz.mo3357a(this.f2662e);
            abstractC1681hz.mo3362b();
        }
        if (this.f2663f != null && m3236h()) {
            abstractC1681hz.mo3353a(f2653h);
            abstractC1681hz.mo3357a(this.f2663f);
            abstractC1681hz.mo3362b();
        }
        if (this.f2664g != null && m3237i()) {
            abstractC1681hz.mo3353a(f2654i);
            abstractC1681hz.mo3357a(this.f2664g);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = false;
        if (m3226a()) {
            sb.append("debug:");
            String str = this.f2657a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m3229b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1648gt c1648gt = this.f2656a;
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
        String str2 = this.f2659b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (m3232d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f2660c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (m3233e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f2655a);
        }
        if (m3234f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f2661d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m3235g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f2662e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m3236h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f2663f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m3237i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f2664g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m3224a() {
        if (this.f2659b == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
