package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.hn */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1669hn implements InterfaceC1671hp<C1669hn, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f2738a;

    /* renamed from: a */
    public C1648gt f2739a;

    /* renamed from: a */
    public String f2740a;

    /* renamed from: a */
    private BitSet f2741a = new BitSet(1);

    /* renamed from: b */
    public String f2742b;

    /* renamed from: c */
    public String f2743c;

    /* renamed from: d */
    public String f2744d;

    /* renamed from: e */
    public String f2745e;

    /* renamed from: f */
    public String f2746f;

    /* renamed from: g */
    public String f2747g;

    /* renamed from: a */
    private static final C1687ie f2729a = new C1687ie("XmPushActionUnSubscriptionResult");

    /* renamed from: a */
    private static final C1678hw f2728a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f2730b = new C1678hw("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1678hw f2731c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2732d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2733e = new C1678hw("", (byte) 10, 6);

    /* renamed from: f */
    private static final C1678hw f2734f = new C1678hw("", (byte) 11, 7);

    /* renamed from: g */
    private static final C1678hw f2735g = new C1678hw("", (byte) 11, 8);

    /* renamed from: h */
    private static final C1678hw f2736h = new C1678hw("", (byte) 11, 9);

    /* renamed from: i */
    private static final C1678hw f2737i = new C1678hw("", (byte) 11, 10);

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m3296a() {
        return this.f2740a != null;
    }

    /* renamed from: b */
    public boolean m3299b() {
        return this.f2739a != null;
    }

    /* renamed from: a */
    public String m3293a() {
        return this.f2742b;
    }

    /* renamed from: c */
    public boolean m3301c() {
        return this.f2742b != null;
    }

    /* renamed from: d */
    public boolean m3302d() {
        return this.f2743c != null;
    }

    /* renamed from: e */
    public boolean m3303e() {
        return this.f2741a.get(0);
    }

    /* renamed from: a */
    public void m3295a(boolean z) {
        this.f2741a.set(0, z);
    }

    /* renamed from: f */
    public boolean m3304f() {
        return this.f2744d != null;
    }

    /* renamed from: b */
    public String m3298b() {
        return this.f2745e;
    }

    /* renamed from: g */
    public boolean m3305g() {
        return this.f2745e != null;
    }

    /* renamed from: h */
    public boolean m3306h() {
        return this.f2746f != null;
    }

    /* renamed from: c */
    public String m3300c() {
        return this.f2747g;
    }

    /* renamed from: i */
    public boolean m3307i() {
        return this.f2747g != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1669hn)) {
            return m3297a((C1669hn) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3297a(C1669hn c1669hn) {
        if (c1669hn == null) {
            return false;
        }
        boolean m3296a = m3296a();
        boolean m3296a2 = c1669hn.m3296a();
        if ((m3296a || m3296a2) && !(m3296a && m3296a2 && this.f2740a.equals(c1669hn.f2740a))) {
            return false;
        }
        boolean m3299b = m3299b();
        boolean m3299b2 = c1669hn.m3299b();
        if ((m3299b || m3299b2) && !(m3299b && m3299b2 && this.f2739a.m2884a(c1669hn.f2739a))) {
            return false;
        }
        boolean m3301c = m3301c();
        boolean m3301c2 = c1669hn.m3301c();
        if ((m3301c || m3301c2) && !(m3301c && m3301c2 && this.f2742b.equals(c1669hn.f2742b))) {
            return false;
        }
        boolean m3302d = m3302d();
        boolean m3302d2 = c1669hn.m3302d();
        if ((m3302d || m3302d2) && !(m3302d && m3302d2 && this.f2743c.equals(c1669hn.f2743c))) {
            return false;
        }
        boolean m3303e = m3303e();
        boolean m3303e2 = c1669hn.m3303e();
        if ((m3303e || m3303e2) && !(m3303e && m3303e2 && this.f2738a == c1669hn.f2738a)) {
            return false;
        }
        boolean m3304f = m3304f();
        boolean m3304f2 = c1669hn.m3304f();
        if ((m3304f || m3304f2) && !(m3304f && m3304f2 && this.f2744d.equals(c1669hn.f2744d))) {
            return false;
        }
        boolean m3305g = m3305g();
        boolean m3305g2 = c1669hn.m3305g();
        if ((m3305g || m3305g2) && !(m3305g && m3305g2 && this.f2745e.equals(c1669hn.f2745e))) {
            return false;
        }
        boolean m3306h = m3306h();
        boolean m3306h2 = c1669hn.m3306h();
        if ((m3306h || m3306h2) && !(m3306h && m3306h2 && this.f2746f.equals(c1669hn.f2746f))) {
            return false;
        }
        boolean m3307i = m3307i();
        boolean m3307i2 = c1669hn.m3307i();
        if (m3307i || m3307i2) {
            return m3307i && m3307i2 && this.f2747g.equals(c1669hn.f2747g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1669hn c1669hn) {
        int m3318a;
        int m3318a2;
        int m3318a3;
        int m3318a4;
        int m3316a;
        int m3318a5;
        int m3318a6;
        int m3317a;
        int m3318a7;
        if (!getClass().equals(c1669hn.getClass())) {
            return getClass().getName().compareTo(c1669hn.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3296a()).compareTo(Boolean.valueOf(c1669hn.m3296a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3296a() && (m3318a7 = C1672hq.m3318a(this.f2740a, c1669hn.f2740a)) != 0) {
            return m3318a7;
        }
        int compareTo2 = Boolean.valueOf(m3299b()).compareTo(Boolean.valueOf(c1669hn.m3299b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3299b() && (m3317a = C1672hq.m3317a(this.f2739a, c1669hn.f2739a)) != 0) {
            return m3317a;
        }
        int compareTo3 = Boolean.valueOf(m3301c()).compareTo(Boolean.valueOf(c1669hn.m3301c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3301c() && (m3318a6 = C1672hq.m3318a(this.f2742b, c1669hn.f2742b)) != 0) {
            return m3318a6;
        }
        int compareTo4 = Boolean.valueOf(m3302d()).compareTo(Boolean.valueOf(c1669hn.m3302d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3302d() && (m3318a5 = C1672hq.m3318a(this.f2743c, c1669hn.f2743c)) != 0) {
            return m3318a5;
        }
        int compareTo5 = Boolean.valueOf(m3303e()).compareTo(Boolean.valueOf(c1669hn.m3303e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3303e() && (m3316a = C1672hq.m3316a(this.f2738a, c1669hn.f2738a)) != 0) {
            return m3316a;
        }
        int compareTo6 = Boolean.valueOf(m3304f()).compareTo(Boolean.valueOf(c1669hn.m3304f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3304f() && (m3318a4 = C1672hq.m3318a(this.f2744d, c1669hn.f2744d)) != 0) {
            return m3318a4;
        }
        int compareTo7 = Boolean.valueOf(m3305g()).compareTo(Boolean.valueOf(c1669hn.m3305g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3305g() && (m3318a3 = C1672hq.m3318a(this.f2745e, c1669hn.f2745e)) != 0) {
            return m3318a3;
        }
        int compareTo8 = Boolean.valueOf(m3306h()).compareTo(Boolean.valueOf(c1669hn.m3306h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3306h() && (m3318a2 = C1672hq.m3318a(this.f2746f, c1669hn.f2746f)) != 0) {
            return m3318a2;
        }
        int compareTo9 = Boolean.valueOf(m3307i()).compareTo(Boolean.valueOf(c1669hn.m3307i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!m3307i() || (m3318a = C1672hq.m3318a(this.f2747g, c1669hn.f2747g)) == 0) {
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
                            this.f2740a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2739a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2742b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2743c = abstractC1681hz.mo3345a();
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
                            this.f2738a = abstractC1681hz.mo3339a();
                            m3295a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f2744d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 11) {
                            this.f2745e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 9:
                        if (mo3340a.f2770a == 11) {
                            this.f2746f = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 11) {
                            this.f2747g = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                }
                abstractC1681hz.mo3369g();
            } else {
                abstractC1681hz.mo3368f();
                m3294a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m3294a();
        abstractC1681hz.mo3356a(f2729a);
        if (this.f2740a != null && m3296a()) {
            abstractC1681hz.mo3353a(f2728a);
            abstractC1681hz.mo3357a(this.f2740a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2739a != null && m3299b()) {
            abstractC1681hz.mo3353a(f2730b);
            this.f2739a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2742b != null) {
            abstractC1681hz.mo3353a(f2731c);
            abstractC1681hz.mo3357a(this.f2742b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2743c != null && m3302d()) {
            abstractC1681hz.mo3353a(f2732d);
            abstractC1681hz.mo3357a(this.f2743c);
            abstractC1681hz.mo3362b();
        }
        if (m3303e()) {
            abstractC1681hz.mo3353a(f2733e);
            abstractC1681hz.mo3352a(this.f2738a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2744d != null && m3304f()) {
            abstractC1681hz.mo3353a(f2734f);
            abstractC1681hz.mo3357a(this.f2744d);
            abstractC1681hz.mo3362b();
        }
        if (this.f2745e != null && m3305g()) {
            abstractC1681hz.mo3353a(f2735g);
            abstractC1681hz.mo3357a(this.f2745e);
            abstractC1681hz.mo3362b();
        }
        if (this.f2746f != null && m3306h()) {
            abstractC1681hz.mo3353a(f2736h);
            abstractC1681hz.mo3357a(this.f2746f);
            abstractC1681hz.mo3362b();
        }
        if (this.f2747g != null && m3307i()) {
            abstractC1681hz.mo3353a(f2737i);
            abstractC1681hz.mo3357a(this.f2747g);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = false;
        if (m3296a()) {
            sb.append("debug:");
            String str = this.f2740a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m3299b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1648gt c1648gt = this.f2739a;
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
        String str2 = this.f2742b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (m3302d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f2743c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (m3303e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f2738a);
        }
        if (m3304f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f2744d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m3305g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f2745e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m3306h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f2746f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m3307i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f2747g;
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
    public void m3294a() {
        if (this.f2742b == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
