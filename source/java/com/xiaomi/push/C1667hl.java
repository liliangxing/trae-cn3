package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.hl */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1667hl implements InterfaceC1671hp<C1667hl, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f2701a;

    /* renamed from: a */
    public C1648gt f2702a;

    /* renamed from: a */
    public String f2703a;

    /* renamed from: a */
    private BitSet f2704a = new BitSet(3);

    /* renamed from: b */
    public long f2705b;

    /* renamed from: b */
    public String f2706b;

    /* renamed from: c */
    public long f2707c;

    /* renamed from: c */
    public String f2708c;

    /* renamed from: d */
    public String f2709d;

    /* renamed from: e */
    public String f2710e;

    /* renamed from: a */
    private static final C1687ie f2692a = new C1687ie("XmPushActionUnRegistrationResult");

    /* renamed from: a */
    private static final C1678hw f2691a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f2693b = new C1678hw("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1678hw f2694c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2695d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2696e = new C1678hw("", (byte) 10, 6);

    /* renamed from: f */
    private static final C1678hw f2697f = new C1678hw("", (byte) 11, 7);

    /* renamed from: g */
    private static final C1678hw f2698g = new C1678hw("", (byte) 11, 8);

    /* renamed from: h */
    private static final C1678hw f2699h = new C1678hw("", (byte) 10, 9);

    /* renamed from: i */
    private static final C1678hw f2700i = new C1678hw("", (byte) 10, 10);

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m3264a() {
        return this.f2703a != null;
    }

    /* renamed from: b */
    public boolean m3267b() {
        return this.f2702a != null;
    }

    /* renamed from: c */
    public boolean m3269c() {
        return this.f2706b != null;
    }

    /* renamed from: d */
    public boolean m3270d() {
        return this.f2708c != null;
    }

    /* renamed from: e */
    public boolean m3271e() {
        return this.f2704a.get(0);
    }

    /* renamed from: a */
    public void m3263a(boolean z) {
        this.f2704a.set(0, z);
    }

    /* renamed from: f */
    public boolean m3272f() {
        return this.f2709d != null;
    }

    /* renamed from: a */
    public String m3261a() {
        return this.f2710e;
    }

    /* renamed from: g */
    public boolean m3273g() {
        return this.f2710e != null;
    }

    /* renamed from: h */
    public boolean m3274h() {
        return this.f2704a.get(1);
    }

    /* renamed from: b */
    public void m3266b(boolean z) {
        this.f2704a.set(1, z);
    }

    /* renamed from: i */
    public boolean m3275i() {
        return this.f2704a.get(2);
    }

    /* renamed from: c */
    public void m3268c(boolean z) {
        this.f2704a.set(2, z);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1667hl)) {
            return m3265a((C1667hl) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3265a(C1667hl c1667hl) {
        if (c1667hl == null) {
            return false;
        }
        boolean m3264a = m3264a();
        boolean m3264a2 = c1667hl.m3264a();
        if ((m3264a || m3264a2) && !(m3264a && m3264a2 && this.f2703a.equals(c1667hl.f2703a))) {
            return false;
        }
        boolean m3267b = m3267b();
        boolean m3267b2 = c1667hl.m3267b();
        if ((m3267b || m3267b2) && !(m3267b && m3267b2 && this.f2702a.m2884a(c1667hl.f2702a))) {
            return false;
        }
        boolean m3269c = m3269c();
        boolean m3269c2 = c1667hl.m3269c();
        if ((m3269c || m3269c2) && !(m3269c && m3269c2 && this.f2706b.equals(c1667hl.f2706b))) {
            return false;
        }
        boolean m3270d = m3270d();
        boolean m3270d2 = c1667hl.m3270d();
        if (((m3270d || m3270d2) && !(m3270d && m3270d2 && this.f2708c.equals(c1667hl.f2708c))) || this.f2701a != c1667hl.f2701a) {
            return false;
        }
        boolean m3272f = m3272f();
        boolean m3272f2 = c1667hl.m3272f();
        if ((m3272f || m3272f2) && !(m3272f && m3272f2 && this.f2709d.equals(c1667hl.f2709d))) {
            return false;
        }
        boolean m3273g = m3273g();
        boolean m3273g2 = c1667hl.m3273g();
        if ((m3273g || m3273g2) && !(m3273g && m3273g2 && this.f2710e.equals(c1667hl.f2710e))) {
            return false;
        }
        boolean m3274h = m3274h();
        boolean m3274h2 = c1667hl.m3274h();
        if ((m3274h || m3274h2) && !(m3274h && m3274h2 && this.f2705b == c1667hl.f2705b)) {
            return false;
        }
        boolean m3275i = m3275i();
        boolean m3275i2 = c1667hl.m3275i();
        if (m3275i || m3275i2) {
            return m3275i && m3275i2 && this.f2707c == c1667hl.f2707c;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1667hl c1667hl) {
        int m3316a;
        int m3316a2;
        int m3318a;
        int m3318a2;
        int m3316a3;
        int m3318a3;
        int m3318a4;
        int m3317a;
        int m3318a5;
        if (!getClass().equals(c1667hl.getClass())) {
            return getClass().getName().compareTo(c1667hl.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3264a()).compareTo(Boolean.valueOf(c1667hl.m3264a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3264a() && (m3318a5 = C1672hq.m3318a(this.f2703a, c1667hl.f2703a)) != 0) {
            return m3318a5;
        }
        int compareTo2 = Boolean.valueOf(m3267b()).compareTo(Boolean.valueOf(c1667hl.m3267b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3267b() && (m3317a = C1672hq.m3317a(this.f2702a, c1667hl.f2702a)) != 0) {
            return m3317a;
        }
        int compareTo3 = Boolean.valueOf(m3269c()).compareTo(Boolean.valueOf(c1667hl.m3269c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3269c() && (m3318a4 = C1672hq.m3318a(this.f2706b, c1667hl.f2706b)) != 0) {
            return m3318a4;
        }
        int compareTo4 = Boolean.valueOf(m3270d()).compareTo(Boolean.valueOf(c1667hl.m3270d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3270d() && (m3318a3 = C1672hq.m3318a(this.f2708c, c1667hl.f2708c)) != 0) {
            return m3318a3;
        }
        int compareTo5 = Boolean.valueOf(m3271e()).compareTo(Boolean.valueOf(c1667hl.m3271e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3271e() && (m3316a3 = C1672hq.m3316a(this.f2701a, c1667hl.f2701a)) != 0) {
            return m3316a3;
        }
        int compareTo6 = Boolean.valueOf(m3272f()).compareTo(Boolean.valueOf(c1667hl.m3272f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3272f() && (m3318a2 = C1672hq.m3318a(this.f2709d, c1667hl.f2709d)) != 0) {
            return m3318a2;
        }
        int compareTo7 = Boolean.valueOf(m3273g()).compareTo(Boolean.valueOf(c1667hl.m3273g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3273g() && (m3318a = C1672hq.m3318a(this.f2710e, c1667hl.f2710e)) != 0) {
            return m3318a;
        }
        int compareTo8 = Boolean.valueOf(m3274h()).compareTo(Boolean.valueOf(c1667hl.m3274h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3274h() && (m3316a2 = C1672hq.m3316a(this.f2705b, c1667hl.f2705b)) != 0) {
            return m3316a2;
        }
        int compareTo9 = Boolean.valueOf(m3275i()).compareTo(Boolean.valueOf(c1667hl.m3275i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!m3275i() || (m3316a = C1672hq.m3316a(this.f2707c, c1667hl.f2707c)) == 0) {
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
                            this.f2703a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2702a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2706b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2708c = abstractC1681hz.mo3345a();
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
                            this.f2701a = abstractC1681hz.mo3339a();
                            m3263a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f2709d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 11) {
                            this.f2710e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 9:
                        if (mo3340a.f2770a == 10) {
                            this.f2705b = abstractC1681hz.mo3339a();
                            m3266b(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 10) {
                            this.f2707c = abstractC1681hz.mo3339a();
                            m3268c(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                }
                abstractC1681hz.mo3369g();
            } else {
                abstractC1681hz.mo3368f();
                if (!m3271e()) {
                    throw new C1683ia("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m3262a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m3262a();
        abstractC1681hz.mo3356a(f2692a);
        if (this.f2703a != null && m3264a()) {
            abstractC1681hz.mo3353a(f2691a);
            abstractC1681hz.mo3357a(this.f2703a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2702a != null && m3267b()) {
            abstractC1681hz.mo3353a(f2693b);
            this.f2702a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2706b != null) {
            abstractC1681hz.mo3353a(f2694c);
            abstractC1681hz.mo3357a(this.f2706b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2708c != null) {
            abstractC1681hz.mo3353a(f2695d);
            abstractC1681hz.mo3357a(this.f2708c);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3353a(f2696e);
        abstractC1681hz.mo3352a(this.f2701a);
        abstractC1681hz.mo3362b();
        if (this.f2709d != null && m3272f()) {
            abstractC1681hz.mo3353a(f2697f);
            abstractC1681hz.mo3357a(this.f2709d);
            abstractC1681hz.mo3362b();
        }
        if (this.f2710e != null && m3273g()) {
            abstractC1681hz.mo3353a(f2698g);
            abstractC1681hz.mo3357a(this.f2710e);
            abstractC1681hz.mo3362b();
        }
        if (m3274h()) {
            abstractC1681hz.mo3353a(f2699h);
            abstractC1681hz.mo3352a(this.f2705b);
            abstractC1681hz.mo3362b();
        }
        if (m3275i()) {
            abstractC1681hz.mo3353a(f2700i);
            abstractC1681hz.mo3352a(this.f2707c);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = false;
        if (m3264a()) {
            sb.append("debug:");
            String str = this.f2703a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m3267b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1648gt c1648gt = this.f2702a;
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
        String str2 = this.f2706b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f2708c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f2701a);
        if (m3272f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f2709d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m3273g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f2710e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m3274h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f2705b);
        }
        if (m3275i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f2707c);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m3262a() {
        if (this.f2706b == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f2708c == null) {
            throw new C1683ia("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
