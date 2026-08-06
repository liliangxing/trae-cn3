package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.gu */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1649gu implements InterfaceC1671hp<C1649gu, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public int f2331a;

    /* renamed from: a */
    public long f2332a;

    /* renamed from: a */
    public C1648gt f2333a;

    /* renamed from: a */
    public C1663hh f2334a;

    /* renamed from: a */
    public String f2335a;

    /* renamed from: a */
    public Map<String, String> f2337a;

    /* renamed from: a */
    public short f2338a;

    /* renamed from: b */
    public String f2340b;

    /* renamed from: b */
    public short f2341b;

    /* renamed from: c */
    public String f2342c;

    /* renamed from: d */
    public String f2343d;

    /* renamed from: e */
    public String f2344e;

    /* renamed from: f */
    public String f2345f;

    /* renamed from: g */
    public String f2346g;

    /* renamed from: h */
    public String f2347h;

    /* renamed from: i */
    public String f2348i;

    /* renamed from: j */
    public String f2349j;

    /* renamed from: k */
    public String f2350k;

    /* renamed from: l */
    public String f2351l;

    /* renamed from: a */
    private static final C1687ie f2311a = new C1687ie("XmPushActionAckMessage");

    /* renamed from: a */
    private static final C1678hw f2310a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f2312b = new C1678hw("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1678hw f2313c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2314d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2315e = new C1678hw("", (byte) 10, 5);

    /* renamed from: f */
    private static final C1678hw f2316f = new C1678hw("", (byte) 11, 6);

    /* renamed from: g */
    private static final C1678hw f2317g = new C1678hw("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1678hw f2318h = new C1678hw("", (byte) 12, 8);

    /* renamed from: i */
    private static final C1678hw f2319i = new C1678hw("", (byte) 11, 9);

    /* renamed from: j */
    private static final C1678hw f2320j = new C1678hw("", (byte) 11, 10);

    /* renamed from: k */
    private static final C1678hw f2321k = new C1678hw("", (byte) 2, 11);

    /* renamed from: l */
    private static final C1678hw f2322l = new C1678hw("", (byte) 11, 12);

    /* renamed from: m */
    private static final C1678hw f2323m = new C1678hw("", (byte) 11, 13);

    /* renamed from: n */
    private static final C1678hw f2324n = new C1678hw("", (byte) 11, 14);

    /* renamed from: o */
    private static final C1678hw f2325o = new C1678hw("", (byte) 6, 15);

    /* renamed from: p */
    private static final C1678hw f2326p = new C1678hw("", (byte) 6, 16);

    /* renamed from: q */
    private static final C1678hw f2327q = new C1678hw("", (byte) 11, 20);

    /* renamed from: r */
    private static final C1678hw f2328r = new C1678hw("", (byte) 11, 21);

    /* renamed from: s */
    private static final C1678hw f2329s = new C1678hw("", (byte) 8, 22);

    /* renamed from: t */
    private static final C1678hw f2330t = new C1678hw("", (byte) 13, 23);

    /* renamed from: a */
    private BitSet f2336a = new BitSet(5);

    /* renamed from: a */
    public boolean f2339a = false;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m2897a() {
        return this.f2335a != null;
    }

    /* renamed from: b */
    public boolean m2901b() {
        return this.f2333a != null;
    }

    /* renamed from: a */
    public C1649gu m2893a(String str) {
        this.f2340b = str;
        return this;
    }

    /* renamed from: c */
    public boolean m2904c() {
        return this.f2340b != null;
    }

    /* renamed from: b */
    public C1649gu m2899b(String str) {
        this.f2342c = str;
        return this;
    }

    /* renamed from: d */
    public boolean m2907d() {
        return this.f2342c != null;
    }

    /* renamed from: a */
    public C1649gu m2892a(long j) {
        this.f2332a = j;
        m2896a(true);
        return this;
    }

    /* renamed from: e */
    public boolean m2909e() {
        return this.f2336a.get(0);
    }

    /* renamed from: a */
    public void m2896a(boolean z) {
        this.f2336a.set(0, z);
    }

    /* renamed from: c */
    public C1649gu m2902c(String str) {
        this.f2343d = str;
        return this;
    }

    /* renamed from: f */
    public boolean m2910f() {
        return this.f2343d != null;
    }

    /* renamed from: d */
    public C1649gu m2905d(String str) {
        this.f2344e = str;
        return this;
    }

    /* renamed from: g */
    public boolean m2911g() {
        return this.f2344e != null;
    }

    /* renamed from: h */
    public boolean m2912h() {
        return this.f2334a != null;
    }

    /* renamed from: i */
    public boolean m2913i() {
        return this.f2345f != null;
    }

    /* renamed from: j */
    public boolean m2914j() {
        return this.f2346g != null;
    }

    /* renamed from: k */
    public boolean m2915k() {
        return this.f2336a.get(1);
    }

    /* renamed from: b */
    public void m2900b(boolean z) {
        this.f2336a.set(1, z);
    }

    /* renamed from: l */
    public boolean m2916l() {
        return this.f2347h != null;
    }

    /* renamed from: m */
    public boolean m2917m() {
        return this.f2348i != null;
    }

    /* renamed from: n */
    public boolean m2918n() {
        return this.f2349j != null;
    }

    /* renamed from: a */
    public C1649gu m2894a(short s) {
        this.f2338a = s;
        m2903c(true);
        return this;
    }

    /* renamed from: o */
    public boolean m2919o() {
        return this.f2336a.get(2);
    }

    /* renamed from: c */
    public void m2903c(boolean z) {
        this.f2336a.set(2, z);
    }

    /* renamed from: p */
    public boolean m2920p() {
        return this.f2336a.get(3);
    }

    /* renamed from: d */
    public void m2906d(boolean z) {
        this.f2336a.set(3, z);
    }

    /* renamed from: q */
    public boolean m2921q() {
        return this.f2350k != null;
    }

    /* renamed from: r */
    public boolean m2922r() {
        return this.f2351l != null;
    }

    /* renamed from: s */
    public boolean m2923s() {
        return this.f2336a.get(4);
    }

    /* renamed from: e */
    public void m2908e(boolean z) {
        this.f2336a.set(4, z);
    }

    /* renamed from: t */
    public boolean m2924t() {
        return this.f2337a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1649gu)) {
            return m2898a((C1649gu) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2898a(C1649gu c1649gu) {
        if (c1649gu == null) {
            return false;
        }
        boolean m2897a = m2897a();
        boolean m2897a2 = c1649gu.m2897a();
        if ((m2897a || m2897a2) && !(m2897a && m2897a2 && this.f2335a.equals(c1649gu.f2335a))) {
            return false;
        }
        boolean m2901b = m2901b();
        boolean m2901b2 = c1649gu.m2901b();
        if ((m2901b || m2901b2) && !(m2901b && m2901b2 && this.f2333a.m2884a(c1649gu.f2333a))) {
            return false;
        }
        boolean m2904c = m2904c();
        boolean m2904c2 = c1649gu.m2904c();
        if ((m2904c || m2904c2) && !(m2904c && m2904c2 && this.f2340b.equals(c1649gu.f2340b))) {
            return false;
        }
        boolean m2907d = m2907d();
        boolean m2907d2 = c1649gu.m2907d();
        if (((m2907d || m2907d2) && !(m2907d && m2907d2 && this.f2342c.equals(c1649gu.f2342c))) || this.f2332a != c1649gu.f2332a) {
            return false;
        }
        boolean m2910f = m2910f();
        boolean m2910f2 = c1649gu.m2910f();
        if ((m2910f || m2910f2) && !(m2910f && m2910f2 && this.f2343d.equals(c1649gu.f2343d))) {
            return false;
        }
        boolean m2911g = m2911g();
        boolean m2911g2 = c1649gu.m2911g();
        if ((m2911g || m2911g2) && !(m2911g && m2911g2 && this.f2344e.equals(c1649gu.f2344e))) {
            return false;
        }
        boolean m2912h = m2912h();
        boolean m2912h2 = c1649gu.m2912h();
        if ((m2912h || m2912h2) && !(m2912h && m2912h2 && this.f2334a.m3189a(c1649gu.f2334a))) {
            return false;
        }
        boolean m2913i = m2913i();
        boolean m2913i2 = c1649gu.m2913i();
        if ((m2913i || m2913i2) && !(m2913i && m2913i2 && this.f2345f.equals(c1649gu.f2345f))) {
            return false;
        }
        boolean m2914j = m2914j();
        boolean m2914j2 = c1649gu.m2914j();
        if ((m2914j || m2914j2) && !(m2914j && m2914j2 && this.f2346g.equals(c1649gu.f2346g))) {
            return false;
        }
        boolean m2915k = m2915k();
        boolean m2915k2 = c1649gu.m2915k();
        if ((m2915k || m2915k2) && !(m2915k && m2915k2 && this.f2339a == c1649gu.f2339a)) {
            return false;
        }
        boolean m2916l = m2916l();
        boolean m2916l2 = c1649gu.m2916l();
        if ((m2916l || m2916l2) && !(m2916l && m2916l2 && this.f2347h.equals(c1649gu.f2347h))) {
            return false;
        }
        boolean m2917m = m2917m();
        boolean m2917m2 = c1649gu.m2917m();
        if ((m2917m || m2917m2) && !(m2917m && m2917m2 && this.f2348i.equals(c1649gu.f2348i))) {
            return false;
        }
        boolean m2918n = m2918n();
        boolean m2918n2 = c1649gu.m2918n();
        if ((m2918n || m2918n2) && !(m2918n && m2918n2 && this.f2349j.equals(c1649gu.f2349j))) {
            return false;
        }
        boolean m2919o = m2919o();
        boolean m2919o2 = c1649gu.m2919o();
        if ((m2919o || m2919o2) && !(m2919o && m2919o2 && this.f2338a == c1649gu.f2338a)) {
            return false;
        }
        boolean m2920p = m2920p();
        boolean m2920p2 = c1649gu.m2920p();
        if ((m2920p || m2920p2) && !(m2920p && m2920p2 && this.f2341b == c1649gu.f2341b)) {
            return false;
        }
        boolean m2921q = m2921q();
        boolean m2921q2 = c1649gu.m2921q();
        if ((m2921q || m2921q2) && !(m2921q && m2921q2 && this.f2350k.equals(c1649gu.f2350k))) {
            return false;
        }
        boolean m2922r = m2922r();
        boolean m2922r2 = c1649gu.m2922r();
        if ((m2922r || m2922r2) && !(m2922r && m2922r2 && this.f2351l.equals(c1649gu.f2351l))) {
            return false;
        }
        boolean m2923s = m2923s();
        boolean m2923s2 = c1649gu.m2923s();
        if ((m2923s || m2923s2) && !(m2923s && m2923s2 && this.f2331a == c1649gu.f2331a)) {
            return false;
        }
        boolean m2924t = m2924t();
        boolean m2924t2 = c1649gu.m2924t();
        if (m2924t || m2924t2) {
            return m2924t && m2924t2 && this.f2337a.equals(c1649gu.f2337a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1649gu c1649gu) {
        int m3321a;
        int m3315a;
        int m3318a;
        int m3318a2;
        int m3323a;
        int m3323a2;
        int m3318a3;
        int m3318a4;
        int m3318a5;
        int m3324a;
        int m3318a6;
        int m3318a7;
        int m3317a;
        int m3318a8;
        int m3318a9;
        int m3316a;
        int m3318a10;
        int m3318a11;
        int m3317a2;
        int m3318a12;
        if (!getClass().equals(c1649gu.getClass())) {
            return getClass().getName().compareTo(c1649gu.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2897a()).compareTo(Boolean.valueOf(c1649gu.m2897a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2897a() && (m3318a12 = C1672hq.m3318a(this.f2335a, c1649gu.f2335a)) != 0) {
            return m3318a12;
        }
        int compareTo2 = Boolean.valueOf(m2901b()).compareTo(Boolean.valueOf(c1649gu.m2901b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2901b() && (m3317a2 = C1672hq.m3317a(this.f2333a, c1649gu.f2333a)) != 0) {
            return m3317a2;
        }
        int compareTo3 = Boolean.valueOf(m2904c()).compareTo(Boolean.valueOf(c1649gu.m2904c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m2904c() && (m3318a11 = C1672hq.m3318a(this.f2340b, c1649gu.f2340b)) != 0) {
            return m3318a11;
        }
        int compareTo4 = Boolean.valueOf(m2907d()).compareTo(Boolean.valueOf(c1649gu.m2907d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m2907d() && (m3318a10 = C1672hq.m3318a(this.f2342c, c1649gu.f2342c)) != 0) {
            return m3318a10;
        }
        int compareTo5 = Boolean.valueOf(m2909e()).compareTo(Boolean.valueOf(c1649gu.m2909e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m2909e() && (m3316a = C1672hq.m3316a(this.f2332a, c1649gu.f2332a)) != 0) {
            return m3316a;
        }
        int compareTo6 = Boolean.valueOf(m2910f()).compareTo(Boolean.valueOf(c1649gu.m2910f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m2910f() && (m3318a9 = C1672hq.m3318a(this.f2343d, c1649gu.f2343d)) != 0) {
            return m3318a9;
        }
        int compareTo7 = Boolean.valueOf(m2911g()).compareTo(Boolean.valueOf(c1649gu.m2911g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m2911g() && (m3318a8 = C1672hq.m3318a(this.f2344e, c1649gu.f2344e)) != 0) {
            return m3318a8;
        }
        int compareTo8 = Boolean.valueOf(m2912h()).compareTo(Boolean.valueOf(c1649gu.m2912h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m2912h() && (m3317a = C1672hq.m3317a(this.f2334a, c1649gu.f2334a)) != 0) {
            return m3317a;
        }
        int compareTo9 = Boolean.valueOf(m2913i()).compareTo(Boolean.valueOf(c1649gu.m2913i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m2913i() && (m3318a7 = C1672hq.m3318a(this.f2345f, c1649gu.f2345f)) != 0) {
            return m3318a7;
        }
        int compareTo10 = Boolean.valueOf(m2914j()).compareTo(Boolean.valueOf(c1649gu.m2914j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m2914j() && (m3318a6 = C1672hq.m3318a(this.f2346g, c1649gu.f2346g)) != 0) {
            return m3318a6;
        }
        int compareTo11 = Boolean.valueOf(m2915k()).compareTo(Boolean.valueOf(c1649gu.m2915k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m2915k() && (m3324a = C1672hq.m3324a(this.f2339a, c1649gu.f2339a)) != 0) {
            return m3324a;
        }
        int compareTo12 = Boolean.valueOf(m2916l()).compareTo(Boolean.valueOf(c1649gu.m2916l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m2916l() && (m3318a5 = C1672hq.m3318a(this.f2347h, c1649gu.f2347h)) != 0) {
            return m3318a5;
        }
        int compareTo13 = Boolean.valueOf(m2917m()).compareTo(Boolean.valueOf(c1649gu.m2917m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m2917m() && (m3318a4 = C1672hq.m3318a(this.f2348i, c1649gu.f2348i)) != 0) {
            return m3318a4;
        }
        int compareTo14 = Boolean.valueOf(m2918n()).compareTo(Boolean.valueOf(c1649gu.m2918n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (m2918n() && (m3318a3 = C1672hq.m3318a(this.f2349j, c1649gu.f2349j)) != 0) {
            return m3318a3;
        }
        int compareTo15 = Boolean.valueOf(m2919o()).compareTo(Boolean.valueOf(c1649gu.m2919o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (m2919o() && (m3323a2 = C1672hq.m3323a(this.f2338a, c1649gu.f2338a)) != 0) {
            return m3323a2;
        }
        int compareTo16 = Boolean.valueOf(m2920p()).compareTo(Boolean.valueOf(c1649gu.m2920p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (m2920p() && (m3323a = C1672hq.m3323a(this.f2341b, c1649gu.f2341b)) != 0) {
            return m3323a;
        }
        int compareTo17 = Boolean.valueOf(m2921q()).compareTo(Boolean.valueOf(c1649gu.m2921q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (m2921q() && (m3318a2 = C1672hq.m3318a(this.f2350k, c1649gu.f2350k)) != 0) {
            return m3318a2;
        }
        int compareTo18 = Boolean.valueOf(m2922r()).compareTo(Boolean.valueOf(c1649gu.m2922r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (m2922r() && (m3318a = C1672hq.m3318a(this.f2351l, c1649gu.f2351l)) != 0) {
            return m3318a;
        }
        int compareTo19 = Boolean.valueOf(m2923s()).compareTo(Boolean.valueOf(c1649gu.m2923s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (m2923s() && (m3315a = C1672hq.m3315a(this.f2331a, c1649gu.f2331a)) != 0) {
            return m3315a;
        }
        int compareTo20 = Boolean.valueOf(m2924t()).compareTo(Boolean.valueOf(c1649gu.m2924t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!m2924t() || (m3321a = C1672hq.m3321a(this.f2337a, c1649gu.f2337a)) == 0) {
            return 0;
        }
        return m3321a;
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
                            this.f2335a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2333a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2340b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2342c = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 10) {
                            this.f2332a = abstractC1681hz.mo3339a();
                            m2896a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                        if (mo3340a.f2770a == 11) {
                            this.f2343d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f2344e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 12) {
                            C1663hh c1663hh = new C1663hh();
                            this.f2334a = c1663hh;
                            c1663hh.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 9:
                        if (mo3340a.f2770a == 11) {
                            this.f2345f = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 11) {
                            this.f2346g = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 11:
                        if (mo3340a.f2770a == 2) {
                            this.f2339a = abstractC1681hz.mo3361a();
                            m2900b(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 12:
                        if (mo3340a.f2770a == 11) {
                            this.f2347h = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 13:
                        if (mo3340a.f2770a == 11) {
                            this.f2348i = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 14:
                        if (mo3340a.f2770a == 11) {
                            this.f2349j = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 15:
                        if (mo3340a.f2770a == 6) {
                            this.f2338a = abstractC1681hz.mo3348a();
                            m2903c(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 16:
                        if (mo3340a.f2770a == 6) {
                            this.f2341b = abstractC1681hz.mo3348a();
                            m2906d(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 17:
                    case 18:
                    case 19:
                    default:
                        C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                        break;
                    case 20:
                        if (mo3340a.f2770a == 11) {
                            this.f2350k = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 21:
                        if (mo3340a.f2770a == 11) {
                            this.f2351l = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 22:
                        if (mo3340a.f2770a == 8) {
                            this.f2331a = abstractC1681hz.mo3338a();
                            m2908e(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 23:
                        if (mo3340a.f2770a == 13) {
                            C1680hy mo3342a = abstractC1681hz.mo3342a();
                            this.f2337a = new HashMap(mo3342a.f2776a * 2);
                            for (int i = 0; i < mo3342a.f2776a; i++) {
                                this.f2337a.put(abstractC1681hz.mo3345a(), abstractC1681hz.mo3345a());
                            }
                            abstractC1681hz.mo3370h();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                }
                abstractC1681hz.mo3369g();
            } else {
                abstractC1681hz.mo3368f();
                if (!m2909e()) {
                    throw new C1683ia("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m2895a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2895a();
        abstractC1681hz.mo3356a(f2311a);
        if (this.f2335a != null && m2897a()) {
            abstractC1681hz.mo3353a(f2310a);
            abstractC1681hz.mo3357a(this.f2335a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2333a != null && m2901b()) {
            abstractC1681hz.mo3353a(f2312b);
            this.f2333a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2340b != null) {
            abstractC1681hz.mo3353a(f2313c);
            abstractC1681hz.mo3357a(this.f2340b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2342c != null) {
            abstractC1681hz.mo3353a(f2314d);
            abstractC1681hz.mo3357a(this.f2342c);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3353a(f2315e);
        abstractC1681hz.mo3352a(this.f2332a);
        abstractC1681hz.mo3362b();
        if (this.f2343d != null && m2910f()) {
            abstractC1681hz.mo3353a(f2316f);
            abstractC1681hz.mo3357a(this.f2343d);
            abstractC1681hz.mo3362b();
        }
        if (this.f2344e != null && m2911g()) {
            abstractC1681hz.mo3353a(f2317g);
            abstractC1681hz.mo3357a(this.f2344e);
            abstractC1681hz.mo3362b();
        }
        if (this.f2334a != null && m2912h()) {
            abstractC1681hz.mo3353a(f2318h);
            this.f2334a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2345f != null && m2913i()) {
            abstractC1681hz.mo3353a(f2319i);
            abstractC1681hz.mo3357a(this.f2345f);
            abstractC1681hz.mo3362b();
        }
        if (this.f2346g != null && m2914j()) {
            abstractC1681hz.mo3353a(f2320j);
            abstractC1681hz.mo3357a(this.f2346g);
            abstractC1681hz.mo3362b();
        }
        if (m2915k()) {
            abstractC1681hz.mo3353a(f2321k);
            abstractC1681hz.mo3360a(this.f2339a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2347h != null && m2916l()) {
            abstractC1681hz.mo3353a(f2322l);
            abstractC1681hz.mo3357a(this.f2347h);
            abstractC1681hz.mo3362b();
        }
        if (this.f2348i != null && m2917m()) {
            abstractC1681hz.mo3353a(f2323m);
            abstractC1681hz.mo3357a(this.f2348i);
            abstractC1681hz.mo3362b();
        }
        if (this.f2349j != null && m2918n()) {
            abstractC1681hz.mo3353a(f2324n);
            abstractC1681hz.mo3357a(this.f2349j);
            abstractC1681hz.mo3362b();
        }
        if (m2919o()) {
            abstractC1681hz.mo3353a(f2325o);
            abstractC1681hz.mo3359a(this.f2338a);
            abstractC1681hz.mo3362b();
        }
        if (m2920p()) {
            abstractC1681hz.mo3353a(f2326p);
            abstractC1681hz.mo3359a(this.f2341b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2350k != null && m2921q()) {
            abstractC1681hz.mo3353a(f2327q);
            abstractC1681hz.mo3357a(this.f2350k);
            abstractC1681hz.mo3362b();
        }
        if (this.f2351l != null && m2922r()) {
            abstractC1681hz.mo3353a(f2328r);
            abstractC1681hz.mo3357a(this.f2351l);
            abstractC1681hz.mo3362b();
        }
        if (m2923s()) {
            abstractC1681hz.mo3353a(f2329s);
            abstractC1681hz.mo3351a(this.f2331a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2337a != null && m2924t()) {
            abstractC1681hz.mo3353a(f2330t);
            abstractC1681hz.mo3355a(new C1680hy((byte) 11, (byte) 11, this.f2337a.size()));
            for (Map.Entry<String, String> entry : this.f2337a.entrySet()) {
                abstractC1681hz.mo3357a(entry.getKey());
                abstractC1681hz.mo3357a(entry.getValue());
            }
            abstractC1681hz.mo3366d();
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = false;
        if (m2897a()) {
            sb.append("debug:");
            String str = this.f2335a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m2901b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1648gt c1648gt = this.f2333a;
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
        String str2 = this.f2340b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f2342c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f2332a);
        if (m2910f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f2343d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m2911g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f2344e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m2912h()) {
            sb.append(", ");
            sb.append("request:");
            C1663hh c1663hh = this.f2334a;
            if (c1663hh == null) {
                sb.append("null");
            } else {
                sb.append(c1663hh);
            }
        }
        if (m2913i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f2345f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m2914j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f2346g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (m2915k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f2339a);
        }
        if (m2916l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f2347h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m2917m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f2348i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (m2918n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f2349j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (m2919o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f2338a);
        }
        if (m2920p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f2341b);
        }
        if (m2921q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f2350k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (m2922r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f2351l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (m2923s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f2331a);
        }
        if (m2924t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f2337a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m2895a() {
        if (this.f2340b == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f2342c == null) {
            throw new C1683ia("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
