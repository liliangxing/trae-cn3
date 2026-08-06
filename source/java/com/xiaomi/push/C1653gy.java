package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.gy */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1653gy implements InterfaceC1671hp<C1653gy, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f2394a;

    /* renamed from: a */
    public C1648gt f2395a;

    /* renamed from: a */
    public String f2396a;

    /* renamed from: a */
    public List<String> f2398a;

    /* renamed from: b */
    public String f2400b;

    /* renamed from: c */
    public String f2402c;

    /* renamed from: d */
    public String f2403d;

    /* renamed from: e */
    public String f2404e;

    /* renamed from: a */
    private static final C1687ie f2384a = new C1687ie("XmPushActionCommand");

    /* renamed from: a */
    private static final C1678hw f2383a = new C1678hw("", (byte) 12, 2);

    /* renamed from: b */
    private static final C1678hw f2385b = new C1678hw("", (byte) 11, 3);

    /* renamed from: c */
    private static final C1678hw f2386c = new C1678hw("", (byte) 11, 4);

    /* renamed from: d */
    private static final C1678hw f2387d = new C1678hw("", (byte) 11, 5);

    /* renamed from: e */
    private static final C1678hw f2388e = new C1678hw("", (byte) 15, 6);

    /* renamed from: f */
    private static final C1678hw f2389f = new C1678hw("", (byte) 11, 7);

    /* renamed from: g */
    private static final C1678hw f2390g = new C1678hw("", (byte) 11, 9);

    /* renamed from: h */
    private static final C1678hw f2391h = new C1678hw("", (byte) 2, 10);

    /* renamed from: i */
    private static final C1678hw f2392i = new C1678hw("", (byte) 2, 11);

    /* renamed from: j */
    private static final C1678hw f2393j = new C1678hw("", (byte) 10, 12);

    /* renamed from: a */
    private BitSet f2397a = new BitSet(3);

    /* renamed from: a */
    public boolean f2399a = false;

    /* renamed from: b */
    public boolean f2401b = true;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m2969a() {
        return this.f2395a != null;
    }

    /* renamed from: a */
    public C1653gy m2964a(String str) {
        this.f2396a = str;
        return this;
    }

    /* renamed from: b */
    public boolean m2973b() {
        return this.f2396a != null;
    }

    /* renamed from: b */
    public C1653gy m2971b(String str) {
        this.f2400b = str;
        return this;
    }

    /* renamed from: c */
    public boolean m2976c() {
        return this.f2400b != null;
    }

    /* renamed from: a */
    public String m2965a() {
        return this.f2402c;
    }

    /* renamed from: c */
    public C1653gy m2974c(String str) {
        this.f2402c = str;
        return this;
    }

    /* renamed from: d */
    public boolean m2978d() {
        return this.f2402c != null;
    }

    /* renamed from: a */
    public void m2967a(String str) {
        if (this.f2398a == null) {
            this.f2398a = new ArrayList();
        }
        this.f2398a.add(str);
    }

    /* renamed from: e */
    public boolean m2980e() {
        return this.f2398a != null;
    }

    /* renamed from: d */
    public C1653gy m2977d(String str) {
        this.f2403d = str;
        return this;
    }

    /* renamed from: f */
    public boolean m2981f() {
        return this.f2403d != null;
    }

    /* renamed from: e */
    public C1653gy m2979e(String str) {
        this.f2404e = str;
        return this;
    }

    /* renamed from: g */
    public boolean m2982g() {
        return this.f2404e != null;
    }

    /* renamed from: h */
    public boolean m2983h() {
        return this.f2397a.get(0);
    }

    /* renamed from: a */
    public void m2968a(boolean z) {
        this.f2397a.set(0, z);
    }

    /* renamed from: i */
    public boolean m2984i() {
        return this.f2397a.get(1);
    }

    /* renamed from: b */
    public void m2972b(boolean z) {
        this.f2397a.set(1, z);
    }

    /* renamed from: j */
    public boolean m2985j() {
        return this.f2397a.get(2);
    }

    /* renamed from: c */
    public void m2975c(boolean z) {
        this.f2397a.set(2, z);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1653gy)) {
            return m2970a((C1653gy) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2970a(C1653gy c1653gy) {
        if (c1653gy == null) {
            return false;
        }
        boolean m2969a = m2969a();
        boolean m2969a2 = c1653gy.m2969a();
        if ((m2969a || m2969a2) && !(m2969a && m2969a2 && this.f2395a.m2884a(c1653gy.f2395a))) {
            return false;
        }
        boolean m2973b = m2973b();
        boolean m2973b2 = c1653gy.m2973b();
        if ((m2973b || m2973b2) && !(m2973b && m2973b2 && this.f2396a.equals(c1653gy.f2396a))) {
            return false;
        }
        boolean m2976c = m2976c();
        boolean m2976c2 = c1653gy.m2976c();
        if ((m2976c || m2976c2) && !(m2976c && m2976c2 && this.f2400b.equals(c1653gy.f2400b))) {
            return false;
        }
        boolean m2978d = m2978d();
        boolean m2978d2 = c1653gy.m2978d();
        if ((m2978d || m2978d2) && !(m2978d && m2978d2 && this.f2402c.equals(c1653gy.f2402c))) {
            return false;
        }
        boolean m2980e = m2980e();
        boolean m2980e2 = c1653gy.m2980e();
        if ((m2980e || m2980e2) && !(m2980e && m2980e2 && this.f2398a.equals(c1653gy.f2398a))) {
            return false;
        }
        boolean m2981f = m2981f();
        boolean m2981f2 = c1653gy.m2981f();
        if ((m2981f || m2981f2) && !(m2981f && m2981f2 && this.f2403d.equals(c1653gy.f2403d))) {
            return false;
        }
        boolean m2982g = m2982g();
        boolean m2982g2 = c1653gy.m2982g();
        if ((m2982g || m2982g2) && !(m2982g && m2982g2 && this.f2404e.equals(c1653gy.f2404e))) {
            return false;
        }
        boolean m2983h = m2983h();
        boolean m2983h2 = c1653gy.m2983h();
        if ((m2983h || m2983h2) && !(m2983h && m2983h2 && this.f2399a == c1653gy.f2399a)) {
            return false;
        }
        boolean m2984i = m2984i();
        boolean m2984i2 = c1653gy.m2984i();
        if ((m2984i || m2984i2) && !(m2984i && m2984i2 && this.f2401b == c1653gy.f2401b)) {
            return false;
        }
        boolean m2985j = m2985j();
        boolean m2985j2 = c1653gy.m2985j();
        if (m2985j || m2985j2) {
            return m2985j && m2985j2 && this.f2394a == c1653gy.f2394a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1653gy c1653gy) {
        int m3316a;
        int m3324a;
        int m3324a2;
        int m3318a;
        int m3318a2;
        int m3320a;
        int m3318a3;
        int m3318a4;
        int m3318a5;
        int m3317a;
        if (!getClass().equals(c1653gy.getClass())) {
            return getClass().getName().compareTo(c1653gy.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2969a()).compareTo(Boolean.valueOf(c1653gy.m2969a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2969a() && (m3317a = C1672hq.m3317a(this.f2395a, c1653gy.f2395a)) != 0) {
            return m3317a;
        }
        int compareTo2 = Boolean.valueOf(m2973b()).compareTo(Boolean.valueOf(c1653gy.m2973b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2973b() && (m3318a5 = C1672hq.m3318a(this.f2396a, c1653gy.f2396a)) != 0) {
            return m3318a5;
        }
        int compareTo3 = Boolean.valueOf(m2976c()).compareTo(Boolean.valueOf(c1653gy.m2976c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m2976c() && (m3318a4 = C1672hq.m3318a(this.f2400b, c1653gy.f2400b)) != 0) {
            return m3318a4;
        }
        int compareTo4 = Boolean.valueOf(m2978d()).compareTo(Boolean.valueOf(c1653gy.m2978d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m2978d() && (m3318a3 = C1672hq.m3318a(this.f2402c, c1653gy.f2402c)) != 0) {
            return m3318a3;
        }
        int compareTo5 = Boolean.valueOf(m2980e()).compareTo(Boolean.valueOf(c1653gy.m2980e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m2980e() && (m3320a = C1672hq.m3320a(this.f2398a, c1653gy.f2398a)) != 0) {
            return m3320a;
        }
        int compareTo6 = Boolean.valueOf(m2981f()).compareTo(Boolean.valueOf(c1653gy.m2981f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m2981f() && (m3318a2 = C1672hq.m3318a(this.f2403d, c1653gy.f2403d)) != 0) {
            return m3318a2;
        }
        int compareTo7 = Boolean.valueOf(m2982g()).compareTo(Boolean.valueOf(c1653gy.m2982g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m2982g() && (m3318a = C1672hq.m3318a(this.f2404e, c1653gy.f2404e)) != 0) {
            return m3318a;
        }
        int compareTo8 = Boolean.valueOf(m2983h()).compareTo(Boolean.valueOf(c1653gy.m2983h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m2983h() && (m3324a2 = C1672hq.m3324a(this.f2399a, c1653gy.f2399a)) != 0) {
            return m3324a2;
        }
        int compareTo9 = Boolean.valueOf(m2984i()).compareTo(Boolean.valueOf(c1653gy.m2984i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m2984i() && (m3324a = C1672hq.m3324a(this.f2401b, c1653gy.f2401b)) != 0) {
            return m3324a;
        }
        int compareTo10 = Boolean.valueOf(m2985j()).compareTo(Boolean.valueOf(c1653gy.m2985j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!m2985j() || (m3316a = C1672hq.m3316a(this.f2394a, c1653gy.f2394a)) == 0) {
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
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2395a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2396a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2400b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 11) {
                            this.f2402c = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                        if (mo3340a.f2770a == 15) {
                            C1679hx mo3341a = abstractC1681hz.mo3341a();
                            this.f2398a = new ArrayList(mo3341a.f2774a);
                            for (int i = 0; i < mo3341a.f2774a; i++) {
                                this.f2398a.add(abstractC1681hz.mo3345a());
                            }
                            abstractC1681hz.mo3371i();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f2403d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                    default:
                        C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                        break;
                    case 9:
                        if (mo3340a.f2770a == 11) {
                            this.f2404e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 2) {
                            this.f2399a = abstractC1681hz.mo3361a();
                            m2968a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 11:
                        if (mo3340a.f2770a == 2) {
                            this.f2401b = abstractC1681hz.mo3361a();
                            m2972b(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 12:
                        if (mo3340a.f2770a == 10) {
                            this.f2394a = abstractC1681hz.mo3339a();
                            m2975c(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                }
                abstractC1681hz.mo3369g();
            } else {
                abstractC1681hz.mo3368f();
                m2966a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2966a();
        abstractC1681hz.mo3356a(f2384a);
        if (this.f2395a != null && m2969a()) {
            abstractC1681hz.mo3353a(f2383a);
            this.f2395a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2396a != null) {
            abstractC1681hz.mo3353a(f2385b);
            abstractC1681hz.mo3357a(this.f2396a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2400b != null) {
            abstractC1681hz.mo3353a(f2386c);
            abstractC1681hz.mo3357a(this.f2400b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2402c != null) {
            abstractC1681hz.mo3353a(f2387d);
            abstractC1681hz.mo3357a(this.f2402c);
            abstractC1681hz.mo3362b();
        }
        if (this.f2398a != null && m2980e()) {
            abstractC1681hz.mo3353a(f2388e);
            abstractC1681hz.mo3354a(new C1679hx((byte) 11, this.f2398a.size()));
            Iterator<String> it = this.f2398a.iterator();
            while (it.hasNext()) {
                abstractC1681hz.mo3357a(it.next());
            }
            abstractC1681hz.mo3367e();
            abstractC1681hz.mo3362b();
        }
        if (this.f2403d != null && m2981f()) {
            abstractC1681hz.mo3353a(f2389f);
            abstractC1681hz.mo3357a(this.f2403d);
            abstractC1681hz.mo3362b();
        }
        if (this.f2404e != null && m2982g()) {
            abstractC1681hz.mo3353a(f2390g);
            abstractC1681hz.mo3357a(this.f2404e);
            abstractC1681hz.mo3362b();
        }
        if (m2983h()) {
            abstractC1681hz.mo3353a(f2391h);
            abstractC1681hz.mo3360a(this.f2399a);
            abstractC1681hz.mo3362b();
        }
        if (m2984i()) {
            abstractC1681hz.mo3353a(f2392i);
            abstractC1681hz.mo3360a(this.f2401b);
            abstractC1681hz.mo3362b();
        }
        if (m2985j()) {
            abstractC1681hz.mo3353a(f2393j);
            abstractC1681hz.mo3352a(this.f2394a);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m2969a()) {
            sb.append("target:");
            C1648gt c1648gt = this.f2395a;
            if (c1648gt == null) {
                sb.append("null");
            } else {
                sb.append(c1648gt);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f2396a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f2400b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f2402c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (m2980e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f2398a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m2981f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f2403d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m2982g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f2404e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m2983h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f2399a);
        }
        if (m2984i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f2401b);
        }
        if (m2985j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f2394a);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m2966a() {
        if (this.f2396a == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f2400b == null) {
            throw new C1683ia("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f2402c == null) {
            throw new C1683ia("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }
}
