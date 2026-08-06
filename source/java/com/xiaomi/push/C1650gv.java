package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.gv */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1650gv implements InterfaceC1671hp<C1650gv, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public C1648gt f2364a;

    /* renamed from: a */
    public String f2365a;

    /* renamed from: a */
    public Map<String, String> f2367a;

    /* renamed from: b */
    public String f2368b;

    /* renamed from: c */
    public String f2369c;

    /* renamed from: d */
    public String f2370d;

    /* renamed from: e */
    public String f2371e;

    /* renamed from: f */
    public String f2372f;

    /* renamed from: g */
    public String f2373g;

    /* renamed from: a */
    private static final C1687ie f2353a = new C1687ie("XmPushActionAckNotification");

    /* renamed from: a */
    private static final C1678hw f2352a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f2354b = new C1678hw("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1678hw f2355c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2356d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2357e = new C1678hw("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1678hw f2358f = new C1678hw("", (byte) 10, 7);

    /* renamed from: g */
    private static final C1678hw f2359g = new C1678hw("", (byte) 11, 8);

    /* renamed from: h */
    private static final C1678hw f2360h = new C1678hw("", (byte) 13, 9);

    /* renamed from: i */
    private static final C1678hw f2361i = new C1678hw("", (byte) 11, 10);

    /* renamed from: j */
    private static final C1678hw f2362j = new C1678hw("", (byte) 11, 11);

    /* renamed from: a */
    private BitSet f2366a = new BitSet(1);

    /* renamed from: a */
    public long f2363a = 0;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m2933a() {
        return this.f2365a != null;
    }

    /* renamed from: a */
    public C1650gv m2927a(C1648gt c1648gt) {
        this.f2364a = c1648gt;
        return this;
    }

    /* renamed from: b */
    public boolean m2937b() {
        return this.f2364a != null;
    }

    /* renamed from: a */
    public String m2929a() {
        return this.f2368b;
    }

    /* renamed from: a */
    public C1650gv m2928a(String str) {
        this.f2368b = str;
        return this;
    }

    /* renamed from: c */
    public boolean m2939c() {
        return this.f2368b != null;
    }

    /* renamed from: b */
    public C1650gv m2935b(String str) {
        this.f2369c = str;
        return this;
    }

    /* renamed from: d */
    public boolean m2941d() {
        return this.f2369c != null;
    }

    /* renamed from: b */
    public String m2936b() {
        return this.f2370d;
    }

    /* renamed from: c */
    public C1650gv m2938c(String str) {
        this.f2370d = str;
        return this;
    }

    /* renamed from: e */
    public boolean m2943e() {
        return this.f2370d != null;
    }

    /* renamed from: a */
    public C1650gv m2926a(long j) {
        this.f2363a = j;
        m2932a(true);
        return this;
    }

    /* renamed from: f */
    public boolean m2944f() {
        return this.f2366a.get(0);
    }

    /* renamed from: a */
    public void m2932a(boolean z) {
        this.f2366a.set(0, z);
    }

    /* renamed from: d */
    public C1650gv m2940d(String str) {
        this.f2371e = str;
        return this;
    }

    /* renamed from: g */
    public boolean m2945g() {
        return this.f2371e != null;
    }

    /* renamed from: a */
    public Map<String, String> m2930a() {
        return this.f2367a;
    }

    /* renamed from: h */
    public boolean m2946h() {
        return this.f2367a != null;
    }

    /* renamed from: e */
    public C1650gv m2942e(String str) {
        this.f2372f = str;
        return this;
    }

    /* renamed from: i */
    public boolean m2947i() {
        return this.f2372f != null;
    }

    /* renamed from: j */
    public boolean m2948j() {
        return this.f2373g != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1650gv)) {
            return m2934a((C1650gv) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2934a(C1650gv c1650gv) {
        if (c1650gv == null) {
            return false;
        }
        boolean m2933a = m2933a();
        boolean m2933a2 = c1650gv.m2933a();
        if ((m2933a || m2933a2) && !(m2933a && m2933a2 && this.f2365a.equals(c1650gv.f2365a))) {
            return false;
        }
        boolean m2937b = m2937b();
        boolean m2937b2 = c1650gv.m2937b();
        if ((m2937b || m2937b2) && !(m2937b && m2937b2 && this.f2364a.m2884a(c1650gv.f2364a))) {
            return false;
        }
        boolean m2939c = m2939c();
        boolean m2939c2 = c1650gv.m2939c();
        if ((m2939c || m2939c2) && !(m2939c && m2939c2 && this.f2368b.equals(c1650gv.f2368b))) {
            return false;
        }
        boolean m2941d = m2941d();
        boolean m2941d2 = c1650gv.m2941d();
        if ((m2941d || m2941d2) && !(m2941d && m2941d2 && this.f2369c.equals(c1650gv.f2369c))) {
            return false;
        }
        boolean m2943e = m2943e();
        boolean m2943e2 = c1650gv.m2943e();
        if ((m2943e || m2943e2) && !(m2943e && m2943e2 && this.f2370d.equals(c1650gv.f2370d))) {
            return false;
        }
        boolean m2944f = m2944f();
        boolean m2944f2 = c1650gv.m2944f();
        if ((m2944f || m2944f2) && !(m2944f && m2944f2 && this.f2363a == c1650gv.f2363a)) {
            return false;
        }
        boolean m2945g = m2945g();
        boolean m2945g2 = c1650gv.m2945g();
        if ((m2945g || m2945g2) && !(m2945g && m2945g2 && this.f2371e.equals(c1650gv.f2371e))) {
            return false;
        }
        boolean m2946h = m2946h();
        boolean m2946h2 = c1650gv.m2946h();
        if ((m2946h || m2946h2) && !(m2946h && m2946h2 && this.f2367a.equals(c1650gv.f2367a))) {
            return false;
        }
        boolean m2947i = m2947i();
        boolean m2947i2 = c1650gv.m2947i();
        if ((m2947i || m2947i2) && !(m2947i && m2947i2 && this.f2372f.equals(c1650gv.f2372f))) {
            return false;
        }
        boolean m2948j = m2948j();
        boolean m2948j2 = c1650gv.m2948j();
        if (m2948j || m2948j2) {
            return m2948j && m2948j2 && this.f2373g.equals(c1650gv.f2373g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1650gv c1650gv) {
        int m3318a;
        int m3318a2;
        int m3321a;
        int m3318a3;
        int m3316a;
        int m3318a4;
        int m3318a5;
        int m3318a6;
        int m3317a;
        int m3318a7;
        if (!getClass().equals(c1650gv.getClass())) {
            return getClass().getName().compareTo(c1650gv.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2933a()).compareTo(Boolean.valueOf(c1650gv.m2933a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2933a() && (m3318a7 = C1672hq.m3318a(this.f2365a, c1650gv.f2365a)) != 0) {
            return m3318a7;
        }
        int compareTo2 = Boolean.valueOf(m2937b()).compareTo(Boolean.valueOf(c1650gv.m2937b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2937b() && (m3317a = C1672hq.m3317a(this.f2364a, c1650gv.f2364a)) != 0) {
            return m3317a;
        }
        int compareTo3 = Boolean.valueOf(m2939c()).compareTo(Boolean.valueOf(c1650gv.m2939c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m2939c() && (m3318a6 = C1672hq.m3318a(this.f2368b, c1650gv.f2368b)) != 0) {
            return m3318a6;
        }
        int compareTo4 = Boolean.valueOf(m2941d()).compareTo(Boolean.valueOf(c1650gv.m2941d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m2941d() && (m3318a5 = C1672hq.m3318a(this.f2369c, c1650gv.f2369c)) != 0) {
            return m3318a5;
        }
        int compareTo5 = Boolean.valueOf(m2943e()).compareTo(Boolean.valueOf(c1650gv.m2943e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m2943e() && (m3318a4 = C1672hq.m3318a(this.f2370d, c1650gv.f2370d)) != 0) {
            return m3318a4;
        }
        int compareTo6 = Boolean.valueOf(m2944f()).compareTo(Boolean.valueOf(c1650gv.m2944f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m2944f() && (m3316a = C1672hq.m3316a(this.f2363a, c1650gv.f2363a)) != 0) {
            return m3316a;
        }
        int compareTo7 = Boolean.valueOf(m2945g()).compareTo(Boolean.valueOf(c1650gv.m2945g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m2945g() && (m3318a3 = C1672hq.m3318a(this.f2371e, c1650gv.f2371e)) != 0) {
            return m3318a3;
        }
        int compareTo8 = Boolean.valueOf(m2946h()).compareTo(Boolean.valueOf(c1650gv.m2946h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m2946h() && (m3321a = C1672hq.m3321a(this.f2367a, c1650gv.f2367a)) != 0) {
            return m3321a;
        }
        int compareTo9 = Boolean.valueOf(m2947i()).compareTo(Boolean.valueOf(c1650gv.m2947i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m2947i() && (m3318a2 = C1672hq.m3318a(this.f2372f, c1650gv.f2372f)) != 0) {
            return m3318a2;
        }
        int compareTo10 = Boolean.valueOf(m2948j()).compareTo(Boolean.valueOf(c1650gv.m2948j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!m2948j() || (m3318a = C1672hq.m3318a(this.f2373g, c1650gv.f2373g)) == 0) {
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
                            this.f2365a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2364a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2368b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2369c = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 11) {
                            this.f2370d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                    default:
                        C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                        break;
                    case 7:
                        if (mo3340a.f2770a == 10) {
                            this.f2363a = abstractC1681hz.mo3339a();
                            m2932a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 11) {
                            this.f2371e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 9:
                        if (mo3340a.f2770a == 13) {
                            C1680hy mo3342a = abstractC1681hz.mo3342a();
                            this.f2367a = new HashMap(mo3342a.f2776a * 2);
                            for (int i = 0; i < mo3342a.f2776a; i++) {
                                this.f2367a.put(abstractC1681hz.mo3345a(), abstractC1681hz.mo3345a());
                            }
                            abstractC1681hz.mo3370h();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 11) {
                            this.f2372f = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 11:
                        if (mo3340a.f2770a == 11) {
                            this.f2373g = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                }
                abstractC1681hz.mo3369g();
            } else {
                abstractC1681hz.mo3368f();
                m2931a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2931a();
        abstractC1681hz.mo3356a(f2353a);
        if (this.f2365a != null && m2933a()) {
            abstractC1681hz.mo3353a(f2352a);
            abstractC1681hz.mo3357a(this.f2365a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2364a != null && m2937b()) {
            abstractC1681hz.mo3353a(f2354b);
            this.f2364a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2368b != null) {
            abstractC1681hz.mo3353a(f2355c);
            abstractC1681hz.mo3357a(this.f2368b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2369c != null && m2941d()) {
            abstractC1681hz.mo3353a(f2356d);
            abstractC1681hz.mo3357a(this.f2369c);
            abstractC1681hz.mo3362b();
        }
        if (this.f2370d != null && m2943e()) {
            abstractC1681hz.mo3353a(f2357e);
            abstractC1681hz.mo3357a(this.f2370d);
            abstractC1681hz.mo3362b();
        }
        if (m2944f()) {
            abstractC1681hz.mo3353a(f2358f);
            abstractC1681hz.mo3352a(this.f2363a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2371e != null && m2945g()) {
            abstractC1681hz.mo3353a(f2359g);
            abstractC1681hz.mo3357a(this.f2371e);
            abstractC1681hz.mo3362b();
        }
        if (this.f2367a != null && m2946h()) {
            abstractC1681hz.mo3353a(f2360h);
            abstractC1681hz.mo3355a(new C1680hy((byte) 11, (byte) 11, this.f2367a.size()));
            for (Map.Entry<String, String> entry : this.f2367a.entrySet()) {
                abstractC1681hz.mo3357a(entry.getKey());
                abstractC1681hz.mo3357a(entry.getValue());
            }
            abstractC1681hz.mo3366d();
            abstractC1681hz.mo3362b();
        }
        if (this.f2372f != null && m2947i()) {
            abstractC1681hz.mo3353a(f2361i);
            abstractC1681hz.mo3357a(this.f2372f);
            abstractC1681hz.mo3362b();
        }
        if (this.f2373g != null && m2948j()) {
            abstractC1681hz.mo3353a(f2362j);
            abstractC1681hz.mo3357a(this.f2373g);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = false;
        if (m2933a()) {
            sb.append("debug:");
            String str = this.f2365a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m2937b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1648gt c1648gt = this.f2364a;
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
        String str2 = this.f2368b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (m2941d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f2369c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (m2943e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f2370d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m2944f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f2363a);
        }
        if (m2945g()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f2371e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m2946h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f2367a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (m2947i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f2372f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m2948j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f2373g;
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
    public void m2931a() {
        if (this.f2368b == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
