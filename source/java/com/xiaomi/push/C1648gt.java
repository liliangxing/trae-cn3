package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.gt */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1648gt implements InterfaceC1671hp<C1648gt, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public String f2304a;

    /* renamed from: d */
    public String f2309d;

    /* renamed from: a */
    private static final C1687ie f2297a = new C1687ie("Target");

    /* renamed from: a */
    private static final C1678hw f2296a = new C1678hw("", (byte) 10, 1);

    /* renamed from: b */
    private static final C1678hw f2298b = new C1678hw("", (byte) 11, 2);

    /* renamed from: c */
    private static final C1678hw f2299c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2300d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2301e = new C1678hw("", (byte) 2, 5);

    /* renamed from: f */
    private static final C1678hw f2302f = new C1678hw("", (byte) 11, 7);

    /* renamed from: a */
    private BitSet f2305a = new BitSet(2);

    /* renamed from: a */
    public long f2303a = 5;

    /* renamed from: b */
    public String f2307b = "xiaomi.com";

    /* renamed from: c */
    public String f2308c = "";

    /* renamed from: a */
    public boolean f2306a = false;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m2883a() {
        return this.f2305a.get(0);
    }

    /* renamed from: a */
    public void m2882a(boolean z) {
        this.f2305a.set(0, z);
    }

    /* renamed from: b */
    public boolean m2886b() {
        return this.f2304a != null;
    }

    /* renamed from: c */
    public boolean m2887c() {
        return this.f2307b != null;
    }

    /* renamed from: d */
    public boolean m2888d() {
        return this.f2308c != null;
    }

    /* renamed from: e */
    public boolean m2889e() {
        return this.f2305a.get(1);
    }

    /* renamed from: b */
    public void m2885b(boolean z) {
        this.f2305a.set(1, z);
    }

    /* renamed from: f */
    public boolean m2890f() {
        return this.f2309d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1648gt)) {
            return m2884a((C1648gt) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2884a(C1648gt c1648gt) {
        if (c1648gt == null || this.f2303a != c1648gt.f2303a) {
            return false;
        }
        boolean m2886b = m2886b();
        boolean m2886b2 = c1648gt.m2886b();
        if ((m2886b || m2886b2) && !(m2886b && m2886b2 && this.f2304a.equals(c1648gt.f2304a))) {
            return false;
        }
        boolean m2887c = m2887c();
        boolean m2887c2 = c1648gt.m2887c();
        if ((m2887c || m2887c2) && !(m2887c && m2887c2 && this.f2307b.equals(c1648gt.f2307b))) {
            return false;
        }
        boolean m2888d = m2888d();
        boolean m2888d2 = c1648gt.m2888d();
        if ((m2888d || m2888d2) && !(m2888d && m2888d2 && this.f2308c.equals(c1648gt.f2308c))) {
            return false;
        }
        boolean m2889e = m2889e();
        boolean m2889e2 = c1648gt.m2889e();
        if ((m2889e || m2889e2) && !(m2889e && m2889e2 && this.f2306a == c1648gt.f2306a)) {
            return false;
        }
        boolean m2890f = m2890f();
        boolean m2890f2 = c1648gt.m2890f();
        if (m2890f || m2890f2) {
            return m2890f && m2890f2 && this.f2309d.equals(c1648gt.f2309d);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1648gt c1648gt) {
        int m3318a;
        int m3324a;
        int m3318a2;
        int m3318a3;
        int m3318a4;
        int m3316a;
        if (!getClass().equals(c1648gt.getClass())) {
            return getClass().getName().compareTo(c1648gt.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2883a()).compareTo(Boolean.valueOf(c1648gt.m2883a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2883a() && (m3316a = C1672hq.m3316a(this.f2303a, c1648gt.f2303a)) != 0) {
            return m3316a;
        }
        int compareTo2 = Boolean.valueOf(m2886b()).compareTo(Boolean.valueOf(c1648gt.m2886b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2886b() && (m3318a4 = C1672hq.m3318a(this.f2304a, c1648gt.f2304a)) != 0) {
            return m3318a4;
        }
        int compareTo3 = Boolean.valueOf(m2887c()).compareTo(Boolean.valueOf(c1648gt.m2887c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m2887c() && (m3318a3 = C1672hq.m3318a(this.f2307b, c1648gt.f2307b)) != 0) {
            return m3318a3;
        }
        int compareTo4 = Boolean.valueOf(m2888d()).compareTo(Boolean.valueOf(c1648gt.m2888d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m2888d() && (m3318a2 = C1672hq.m3318a(this.f2308c, c1648gt.f2308c)) != 0) {
            return m3318a2;
        }
        int compareTo5 = Boolean.valueOf(m2889e()).compareTo(Boolean.valueOf(c1648gt.m2889e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m2889e() && (m3324a = C1672hq.m3324a(this.f2306a, c1648gt.f2306a)) != 0) {
            return m3324a;
        }
        int compareTo6 = Boolean.valueOf(m2890f()).compareTo(Boolean.valueOf(c1648gt.m2890f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (!m2890f() || (m3318a = C1672hq.m3318a(this.f2309d, c1648gt.f2309d)) == 0) {
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
            if (mo3340a.f2770a == 0) {
                break;
            }
            short s = mo3340a.f2772a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            if (s != 5) {
                                if (s == 7) {
                                    if (mo3340a.f2770a == 11) {
                                        this.f2309d = abstractC1681hz.mo3345a();
                                    } else {
                                        C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                                    }
                                } else {
                                    C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                                }
                            } else if (mo3340a.f2770a == 2) {
                                this.f2306a = abstractC1681hz.mo3361a();
                                m2885b(true);
                            } else {
                                C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            }
                        } else if (mo3340a.f2770a == 11) {
                            this.f2308c = abstractC1681hz.mo3345a();
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                        }
                    } else if (mo3340a.f2770a == 11) {
                        this.f2307b = abstractC1681hz.mo3345a();
                    } else {
                        C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                    }
                } else if (mo3340a.f2770a == 11) {
                    this.f2304a = abstractC1681hz.mo3345a();
                } else {
                    C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                }
            } else if (mo3340a.f2770a == 10) {
                this.f2303a = abstractC1681hz.mo3339a();
                m2882a(true);
            } else {
                C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
            }
            abstractC1681hz.mo3369g();
        }
        abstractC1681hz.mo3368f();
        if (!m2883a()) {
            throw new C1683ia("Required field 'channelId' was not found in serialized data! Struct: " + toString());
        }
        m2881a();
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2881a();
        abstractC1681hz.mo3356a(f2297a);
        abstractC1681hz.mo3353a(f2296a);
        abstractC1681hz.mo3352a(this.f2303a);
        abstractC1681hz.mo3362b();
        if (this.f2304a != null) {
            abstractC1681hz.mo3353a(f2298b);
            abstractC1681hz.mo3357a(this.f2304a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2307b != null && m2887c()) {
            abstractC1681hz.mo3353a(f2299c);
            abstractC1681hz.mo3357a(this.f2307b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2308c != null && m2888d()) {
            abstractC1681hz.mo3353a(f2300d);
            abstractC1681hz.mo3357a(this.f2308c);
            abstractC1681hz.mo3362b();
        }
        if (m2889e()) {
            abstractC1681hz.mo3353a(f2301e);
            abstractC1681hz.mo3360a(this.f2306a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2309d != null && m2890f()) {
            abstractC1681hz.mo3353a(f2302f);
            abstractC1681hz.mo3357a(this.f2309d);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(channelId:");
        sb.append(this.f2303a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f2304a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (m2887c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f2307b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (m2888d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f2308c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (m2889e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f2306a);
        }
        if (m2890f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f2309d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m2881a() {
        if (this.f2304a == null) {
            throw new C1683ia("Required field 'userId' was not present! Struct: " + toString());
        }
    }
}
