package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.ei */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1583ei implements InterfaceC1671hp<C1583ei, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public byte f1596a;

    /* renamed from: a */
    public int f1597a;

    /* renamed from: a */
    public String f1598a;

    /* renamed from: a */
    private BitSet f1599a = new BitSet(6);

    /* renamed from: b */
    public int f1600b;

    /* renamed from: b */
    public String f1601b;

    /* renamed from: c */
    public int f1602c;

    /* renamed from: c */
    public String f1603c;

    /* renamed from: d */
    public int f1604d;

    /* renamed from: d */
    public String f1605d;

    /* renamed from: e */
    public int f1606e;

    /* renamed from: a */
    private static final C1687ie f1586a = new C1687ie("StatsEvent");

    /* renamed from: a */
    private static final C1678hw f1585a = new C1678hw("", (byte) 3, 1);

    /* renamed from: b */
    private static final C1678hw f1587b = new C1678hw("", (byte) 8, 2);

    /* renamed from: c */
    private static final C1678hw f1588c = new C1678hw("", (byte) 8, 3);

    /* renamed from: d */
    private static final C1678hw f1589d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f1590e = new C1678hw("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1678hw f1591f = new C1678hw("", (byte) 8, 6);

    /* renamed from: g */
    private static final C1678hw f1592g = new C1678hw("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1678hw f1593h = new C1678hw("", (byte) 11, 8);

    /* renamed from: i */
    private static final C1678hw f1594i = new C1678hw("", (byte) 8, 9);

    /* renamed from: j */
    private static final C1678hw f1595j = new C1678hw("", (byte) 8, 10);

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public C1583ei m2348a(byte b) {
        this.f1596a = b;
        m2353a(true);
        return this;
    }

    /* renamed from: a */
    public boolean m2354a() {
        return this.f1599a.get(0);
    }

    /* renamed from: a */
    public void m2353a(boolean z) {
        this.f1599a.set(0, z);
    }

    /* renamed from: a */
    public C1583ei m2349a(int i) {
        this.f1597a = i;
        m2359b(true);
        return this;
    }

    /* renamed from: b */
    public boolean m2360b() {
        return this.f1599a.get(1);
    }

    /* renamed from: b */
    public void m2359b(boolean z) {
        this.f1599a.set(1, z);
    }

    /* renamed from: b */
    public C1583ei m2356b(int i) {
        this.f1600b = i;
        m2363c(true);
        return this;
    }

    /* renamed from: c */
    public boolean m2364c() {
        return this.f1599a.get(2);
    }

    /* renamed from: c */
    public void m2363c(boolean z) {
        this.f1599a.set(2, z);
    }

    /* renamed from: a */
    public C1583ei m2350a(String str) {
        this.f1598a = str;
        return this;
    }

    /* renamed from: d */
    public boolean m2368d() {
        return this.f1598a != null;
    }

    /* renamed from: b */
    public C1583ei m2357b(String str) {
        this.f1601b = str;
        return this;
    }

    /* renamed from: e */
    public boolean m2370e() {
        return this.f1601b != null;
    }

    /* renamed from: c */
    public C1583ei m2361c(int i) {
        this.f1602c = i;
        m2367d(true);
        return this;
    }

    /* renamed from: f */
    public boolean m2372f() {
        return this.f1599a.get(3);
    }

    /* renamed from: d */
    public void m2367d(boolean z) {
        this.f1599a.set(3, z);
    }

    /* renamed from: c */
    public C1583ei m2362c(String str) {
        this.f1603c = str;
        return this;
    }

    /* renamed from: g */
    public boolean m2373g() {
        return this.f1603c != null;
    }

    /* renamed from: d */
    public C1583ei m2366d(String str) {
        this.f1605d = str;
        return this;
    }

    /* renamed from: h */
    public boolean m2374h() {
        return this.f1605d != null;
    }

    /* renamed from: d */
    public C1583ei m2365d(int i) {
        this.f1604d = i;
        m2369e(true);
        return this;
    }

    /* renamed from: i */
    public boolean m2375i() {
        return this.f1599a.get(4);
    }

    /* renamed from: e */
    public void m2369e(boolean z) {
        this.f1599a.set(4, z);
    }

    /* renamed from: j */
    public boolean m2376j() {
        return this.f1599a.get(5);
    }

    /* renamed from: f */
    public void m2371f(boolean z) {
        this.f1599a.set(5, z);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1583ei)) {
            return m2355a((C1583ei) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2355a(C1583ei c1583ei) {
        if (c1583ei == null || this.f1596a != c1583ei.f1596a || this.f1597a != c1583ei.f1597a || this.f1600b != c1583ei.f1600b) {
            return false;
        }
        boolean m2368d = m2368d();
        boolean m2368d2 = c1583ei.m2368d();
        if ((m2368d || m2368d2) && !(m2368d && m2368d2 && this.f1598a.equals(c1583ei.f1598a))) {
            return false;
        }
        boolean m2370e = m2370e();
        boolean m2370e2 = c1583ei.m2370e();
        if ((m2370e || m2370e2) && !(m2370e && m2370e2 && this.f1601b.equals(c1583ei.f1601b))) {
            return false;
        }
        boolean m2372f = m2372f();
        boolean m2372f2 = c1583ei.m2372f();
        if ((m2372f || m2372f2) && !(m2372f && m2372f2 && this.f1602c == c1583ei.f1602c)) {
            return false;
        }
        boolean m2373g = m2373g();
        boolean m2373g2 = c1583ei.m2373g();
        if ((m2373g || m2373g2) && !(m2373g && m2373g2 && this.f1603c.equals(c1583ei.f1603c))) {
            return false;
        }
        boolean m2374h = m2374h();
        boolean m2374h2 = c1583ei.m2374h();
        if ((m2374h || m2374h2) && !(m2374h && m2374h2 && this.f1605d.equals(c1583ei.f1605d))) {
            return false;
        }
        boolean m2375i = m2375i();
        boolean m2375i2 = c1583ei.m2375i();
        if ((m2375i || m2375i2) && !(m2375i && m2375i2 && this.f1604d == c1583ei.f1604d)) {
            return false;
        }
        boolean m2376j = m2376j();
        boolean m2376j2 = c1583ei.m2376j();
        if (m2376j || m2376j2) {
            return m2376j && m2376j2 && this.f1606e == c1583ei.f1606e;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1583ei c1583ei) {
        int m3315a;
        int m3315a2;
        int m3318a;
        int m3318a2;
        int m3315a3;
        int m3318a3;
        int m3318a4;
        int m3315a4;
        int m3315a5;
        int m3314a;
        if (!getClass().equals(c1583ei.getClass())) {
            return getClass().getName().compareTo(c1583ei.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2354a()).compareTo(Boolean.valueOf(c1583ei.m2354a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2354a() && (m3314a = C1672hq.m3314a(this.f1596a, c1583ei.f1596a)) != 0) {
            return m3314a;
        }
        int compareTo2 = Boolean.valueOf(m2360b()).compareTo(Boolean.valueOf(c1583ei.m2360b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2360b() && (m3315a5 = C1672hq.m3315a(this.f1597a, c1583ei.f1597a)) != 0) {
            return m3315a5;
        }
        int compareTo3 = Boolean.valueOf(m2364c()).compareTo(Boolean.valueOf(c1583ei.m2364c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m2364c() && (m3315a4 = C1672hq.m3315a(this.f1600b, c1583ei.f1600b)) != 0) {
            return m3315a4;
        }
        int compareTo4 = Boolean.valueOf(m2368d()).compareTo(Boolean.valueOf(c1583ei.m2368d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m2368d() && (m3318a4 = C1672hq.m3318a(this.f1598a, c1583ei.f1598a)) != 0) {
            return m3318a4;
        }
        int compareTo5 = Boolean.valueOf(m2370e()).compareTo(Boolean.valueOf(c1583ei.m2370e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m2370e() && (m3318a3 = C1672hq.m3318a(this.f1601b, c1583ei.f1601b)) != 0) {
            return m3318a3;
        }
        int compareTo6 = Boolean.valueOf(m2372f()).compareTo(Boolean.valueOf(c1583ei.m2372f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m2372f() && (m3315a3 = C1672hq.m3315a(this.f1602c, c1583ei.f1602c)) != 0) {
            return m3315a3;
        }
        int compareTo7 = Boolean.valueOf(m2373g()).compareTo(Boolean.valueOf(c1583ei.m2373g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m2373g() && (m3318a2 = C1672hq.m3318a(this.f1603c, c1583ei.f1603c)) != 0) {
            return m3318a2;
        }
        int compareTo8 = Boolean.valueOf(m2374h()).compareTo(Boolean.valueOf(c1583ei.m2374h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m2374h() && (m3318a = C1672hq.m3318a(this.f1605d, c1583ei.f1605d)) != 0) {
            return m3318a;
        }
        int compareTo9 = Boolean.valueOf(m2375i()).compareTo(Boolean.valueOf(c1583ei.m2375i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m2375i() && (m3315a2 = C1672hq.m3315a(this.f1604d, c1583ei.f1604d)) != 0) {
            return m3315a2;
        }
        int compareTo10 = Boolean.valueOf(m2376j()).compareTo(Boolean.valueOf(c1583ei.m2376j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!m2376j() || (m3315a = C1672hq.m3315a(this.f1606e, c1583ei.f1606e)) == 0) {
            return 0;
        }
        return m3315a;
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
                        if (mo3340a.f2770a == 3) {
                            this.f1596a = abstractC1681hz.mo3336a();
                            m2353a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 8) {
                            this.f1597a = abstractC1681hz.mo3338a();
                            m2359b(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 8) {
                            this.f1600b = abstractC1681hz.mo3338a();
                            m2363c(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f1598a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 11) {
                            this.f1601b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                        if (mo3340a.f2770a == 8) {
                            this.f1602c = abstractC1681hz.mo3338a();
                            m2367d(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f1603c = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 11) {
                            this.f1605d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 9:
                        if (mo3340a.f2770a == 8) {
                            this.f1604d = abstractC1681hz.mo3338a();
                            m2369e(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 8) {
                            this.f1606e = abstractC1681hz.mo3338a();
                            m2371f(true);
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
                if (!m2354a()) {
                    throw new C1683ia("Required field 'chid' was not found in serialized data! Struct: " + toString());
                }
                if (!m2360b()) {
                    throw new C1683ia("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                if (!m2364c()) {
                    throw new C1683ia("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
                m2351a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2351a();
        abstractC1681hz.mo3356a(f1586a);
        abstractC1681hz.mo3353a(f1585a);
        abstractC1681hz.mo3350a(this.f1596a);
        abstractC1681hz.mo3362b();
        abstractC1681hz.mo3353a(f1587b);
        abstractC1681hz.mo3351a(this.f1597a);
        abstractC1681hz.mo3362b();
        abstractC1681hz.mo3353a(f1588c);
        abstractC1681hz.mo3351a(this.f1600b);
        abstractC1681hz.mo3362b();
        if (this.f1598a != null) {
            abstractC1681hz.mo3353a(f1589d);
            abstractC1681hz.mo3357a(this.f1598a);
            abstractC1681hz.mo3362b();
        }
        if (this.f1601b != null && m2370e()) {
            abstractC1681hz.mo3353a(f1590e);
            abstractC1681hz.mo3357a(this.f1601b);
            abstractC1681hz.mo3362b();
        }
        if (m2372f()) {
            abstractC1681hz.mo3353a(f1591f);
            abstractC1681hz.mo3351a(this.f1602c);
            abstractC1681hz.mo3362b();
        }
        if (this.f1603c != null && m2373g()) {
            abstractC1681hz.mo3353a(f1592g);
            abstractC1681hz.mo3357a(this.f1603c);
            abstractC1681hz.mo3362b();
        }
        if (this.f1605d != null && m2374h()) {
            abstractC1681hz.mo3353a(f1593h);
            abstractC1681hz.mo3357a(this.f1605d);
            abstractC1681hz.mo3362b();
        }
        if (m2375i()) {
            abstractC1681hz.mo3353a(f1594i);
            abstractC1681hz.mo3351a(this.f1604d);
            abstractC1681hz.mo3362b();
        }
        if (m2376j()) {
            abstractC1681hz.mo3353a(f1595j);
            abstractC1681hz.mo3351a(this.f1606e);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(chid:");
        sb.append((int) this.f1596a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f1597a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f1600b);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.f1598a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (m2370e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.f1601b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (m2372f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f1602c);
        }
        if (m2373g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.f1603c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (m2374h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.f1605d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m2375i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f1604d);
        }
        if (m2376j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f1606e);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m2351a() {
        if (this.f1598a == null) {
            throw new C1683ia("Required field 'connpt' was not present! Struct: " + toString());
        }
    }
}
