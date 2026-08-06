package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.gp */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1644gp implements InterfaceC1671hp<C1644gp, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public int f2217a;

    /* renamed from: a */
    public long f2218a;

    /* renamed from: a */
    public String f2219a;

    /* renamed from: a */
    private BitSet f2220a = new BitSet(6);

    /* renamed from: a */
    public boolean f2221a;

    /* renamed from: b */
    public int f2222b;

    /* renamed from: b */
    public boolean f2223b;

    /* renamed from: c */
    public int f2224c;

    /* renamed from: a */
    private static final C1687ie f2210a = new C1687ie("OnlineConfigItem");

    /* renamed from: a */
    private static final C1678hw f2209a = new C1678hw("", (byte) 8, 1);

    /* renamed from: b */
    private static final C1678hw f2211b = new C1678hw("", (byte) 8, 2);

    /* renamed from: c */
    private static final C1678hw f2212c = new C1678hw("", (byte) 2, 3);

    /* renamed from: d */
    private static final C1678hw f2213d = new C1678hw("", (byte) 8, 4);

    /* renamed from: e */
    private static final C1678hw f2214e = new C1678hw("", (byte) 10, 5);

    /* renamed from: f */
    private static final C1678hw f2215f = new C1678hw("", (byte) 11, 6);

    /* renamed from: g */
    private static final C1678hw f2216g = new C1678hw("", (byte) 2, 7);

    /* renamed from: a */
    public void m2788a() {
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public int m2784a() {
        return this.f2217a;
    }

    /* renamed from: a */
    public boolean m2790a() {
        return this.f2220a.get(0);
    }

    /* renamed from: a */
    public void m2789a(boolean z) {
        this.f2220a.set(0, z);
    }

    /* renamed from: b */
    public int m2792b() {
        return this.f2222b;
    }

    /* renamed from: b */
    public boolean m2794b() {
        return this.f2220a.get(1);
    }

    /* renamed from: b */
    public void m2793b(boolean z) {
        this.f2220a.set(1, z);
    }

    /* renamed from: c */
    public boolean m2797c() {
        return this.f2220a.get(2);
    }

    /* renamed from: c */
    public void m2796c(boolean z) {
        this.f2220a.set(2, z);
    }

    /* renamed from: c */
    public int m2795c() {
        return this.f2224c;
    }

    /* renamed from: d */
    public boolean m2799d() {
        return this.f2220a.get(3);
    }

    /* renamed from: d */
    public void m2798d(boolean z) {
        this.f2220a.set(3, z);
    }

    /* renamed from: a */
    public long m2786a() {
        return this.f2218a;
    }

    /* renamed from: e */
    public boolean m2801e() {
        return this.f2220a.get(4);
    }

    /* renamed from: e */
    public void m2800e(boolean z) {
        this.f2220a.set(4, z);
    }

    /* renamed from: a */
    public String m2787a() {
        return this.f2219a;
    }

    /* renamed from: f */
    public boolean m2803f() {
        return this.f2219a != null;
    }

    /* renamed from: g */
    public boolean m2804g() {
        return this.f2223b;
    }

    /* renamed from: h */
    public boolean m2805h() {
        return this.f2220a.get(5);
    }

    /* renamed from: f */
    public void m2802f(boolean z) {
        this.f2220a.set(5, z);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1644gp)) {
            return m2791a((C1644gp) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2791a(C1644gp c1644gp) {
        if (c1644gp == null) {
            return false;
        }
        boolean m2790a = m2790a();
        boolean m2790a2 = c1644gp.m2790a();
        if ((m2790a || m2790a2) && !(m2790a && m2790a2 && this.f2217a == c1644gp.f2217a)) {
            return false;
        }
        boolean m2794b = m2794b();
        boolean m2794b2 = c1644gp.m2794b();
        if ((m2794b || m2794b2) && !(m2794b && m2794b2 && this.f2222b == c1644gp.f2222b)) {
            return false;
        }
        boolean m2797c = m2797c();
        boolean m2797c2 = c1644gp.m2797c();
        if ((m2797c || m2797c2) && !(m2797c && m2797c2 && this.f2221a == c1644gp.f2221a)) {
            return false;
        }
        boolean m2799d = m2799d();
        boolean m2799d2 = c1644gp.m2799d();
        if ((m2799d || m2799d2) && !(m2799d && m2799d2 && this.f2224c == c1644gp.f2224c)) {
            return false;
        }
        boolean m2801e = m2801e();
        boolean m2801e2 = c1644gp.m2801e();
        if ((m2801e || m2801e2) && !(m2801e && m2801e2 && this.f2218a == c1644gp.f2218a)) {
            return false;
        }
        boolean m2803f = m2803f();
        boolean m2803f2 = c1644gp.m2803f();
        if ((m2803f || m2803f2) && !(m2803f && m2803f2 && this.f2219a.equals(c1644gp.f2219a))) {
            return false;
        }
        boolean m2805h = m2805h();
        boolean m2805h2 = c1644gp.m2805h();
        if (m2805h || m2805h2) {
            return m2805h && m2805h2 && this.f2223b == c1644gp.f2223b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1644gp c1644gp) {
        int m3324a;
        int m3318a;
        int m3316a;
        int m3315a;
        int m3324a2;
        int m3315a2;
        int m3315a3;
        if (!getClass().equals(c1644gp.getClass())) {
            return getClass().getName().compareTo(c1644gp.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2790a()).compareTo(Boolean.valueOf(c1644gp.m2790a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2790a() && (m3315a3 = C1672hq.m3315a(this.f2217a, c1644gp.f2217a)) != 0) {
            return m3315a3;
        }
        int compareTo2 = Boolean.valueOf(m2794b()).compareTo(Boolean.valueOf(c1644gp.m2794b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2794b() && (m3315a2 = C1672hq.m3315a(this.f2222b, c1644gp.f2222b)) != 0) {
            return m3315a2;
        }
        int compareTo3 = Boolean.valueOf(m2797c()).compareTo(Boolean.valueOf(c1644gp.m2797c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m2797c() && (m3324a2 = C1672hq.m3324a(this.f2221a, c1644gp.f2221a)) != 0) {
            return m3324a2;
        }
        int compareTo4 = Boolean.valueOf(m2799d()).compareTo(Boolean.valueOf(c1644gp.m2799d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m2799d() && (m3315a = C1672hq.m3315a(this.f2224c, c1644gp.f2224c)) != 0) {
            return m3315a;
        }
        int compareTo5 = Boolean.valueOf(m2801e()).compareTo(Boolean.valueOf(c1644gp.m2801e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m2801e() && (m3316a = C1672hq.m3316a(this.f2218a, c1644gp.f2218a)) != 0) {
            return m3316a;
        }
        int compareTo6 = Boolean.valueOf(m2803f()).compareTo(Boolean.valueOf(c1644gp.m2803f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m2803f() && (m3318a = C1672hq.m3318a(this.f2219a, c1644gp.f2219a)) != 0) {
            return m3318a;
        }
        int compareTo7 = Boolean.valueOf(m2805h()).compareTo(Boolean.valueOf(c1644gp.m2805h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!m2805h() || (m3324a = C1672hq.m3324a(this.f2223b, c1644gp.f2223b)) == 0) {
            return 0;
        }
        return m3324a;
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
                        if (mo3340a.f2770a == 8) {
                            this.f2217a = abstractC1681hz.mo3338a();
                            m2789a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 8) {
                            this.f2222b = abstractC1681hz.mo3338a();
                            m2793b(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 2) {
                            this.f2221a = abstractC1681hz.mo3361a();
                            m2796c(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 8) {
                            this.f2224c = abstractC1681hz.mo3338a();
                            m2798d(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 10) {
                            this.f2218a = abstractC1681hz.mo3339a();
                            m2800e(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                        if (mo3340a.f2770a == 11) {
                            this.f2219a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 2) {
                            this.f2223b = abstractC1681hz.mo3361a();
                            m2802f(true);
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
                m2788a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2788a();
        abstractC1681hz.mo3356a(f2210a);
        if (m2790a()) {
            abstractC1681hz.mo3353a(f2209a);
            abstractC1681hz.mo3351a(this.f2217a);
            abstractC1681hz.mo3362b();
        }
        if (m2794b()) {
            abstractC1681hz.mo3353a(f2211b);
            abstractC1681hz.mo3351a(this.f2222b);
            abstractC1681hz.mo3362b();
        }
        if (m2797c()) {
            abstractC1681hz.mo3353a(f2212c);
            abstractC1681hz.mo3360a(this.f2221a);
            abstractC1681hz.mo3362b();
        }
        if (m2799d()) {
            abstractC1681hz.mo3353a(f2213d);
            abstractC1681hz.mo3351a(this.f2224c);
            abstractC1681hz.mo3362b();
        }
        if (m2801e()) {
            abstractC1681hz.mo3353a(f2214e);
            abstractC1681hz.mo3352a(this.f2218a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2219a != null && m2803f()) {
            abstractC1681hz.mo3353a(f2215f);
            abstractC1681hz.mo3357a(this.f2219a);
            abstractC1681hz.mo3362b();
        }
        if (m2805h()) {
            abstractC1681hz.mo3353a(f2216g);
            abstractC1681hz.mo3360a(this.f2223b);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (m2790a()) {
            sb.append("key:");
            sb.append(this.f2217a);
            z = false;
        } else {
            z = true;
        }
        if (m2794b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f2222b);
            z = false;
        }
        if (m2797c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f2221a);
            z = false;
        }
        if (m2799d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f2224c);
            z = false;
        }
        if (m2801e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f2218a);
            z = false;
        }
        if (m2803f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f2219a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        } else {
            z2 = z;
        }
        if (m2805h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f2223b);
        }
        sb.append(")");
        return sb.toString();
    }
}
