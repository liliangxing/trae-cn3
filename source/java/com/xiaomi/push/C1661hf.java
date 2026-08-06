package com.xiaomi.push;

import com.xiaomi.push.service.C1752aj;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.hf */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1661hf implements InterfaceC1671hp<C1661hf, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public int f2565a;

    /* renamed from: a */
    public long f2566a;

    /* renamed from: a */
    public C1648gt f2567a;

    /* renamed from: a */
    public String f2568a;

    /* renamed from: a */
    public List<String> f2570a;

    /* renamed from: b */
    public int f2572b;

    /* renamed from: b */
    public long f2573b;

    /* renamed from: b */
    public String f2574b;

    /* renamed from: c */
    public long f2575c;

    /* renamed from: c */
    public String f2576c;

    /* renamed from: d */
    public String f2577d;

    /* renamed from: e */
    public String f2578e;

    /* renamed from: f */
    public String f2579f;

    /* renamed from: g */
    public String f2580g;

    /* renamed from: h */
    public String f2581h;

    /* renamed from: i */
    public String f2582i;

    /* renamed from: j */
    public String f2583j;

    /* renamed from: k */
    public String f2584k;

    /* renamed from: l */
    public String f2585l;

    /* renamed from: a */
    private static final C1687ie f2545a = new C1687ie("XmPushActionRegistrationResult");

    /* renamed from: a */
    private static final C1678hw f2544a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f2546b = new C1678hw("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1678hw f2547c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2548d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2549e = new C1678hw("", (byte) 10, 6);

    /* renamed from: f */
    private static final C1678hw f2550f = new C1678hw("", (byte) 11, 7);

    /* renamed from: g */
    private static final C1678hw f2551g = new C1678hw("", (byte) 11, 8);

    /* renamed from: h */
    private static final C1678hw f2552h = new C1678hw("", (byte) 11, 9);

    /* renamed from: i */
    private static final C1678hw f2553i = new C1678hw("", (byte) 11, 10);

    /* renamed from: j */
    private static final C1678hw f2554j = new C1678hw("", (byte) 10, 11);

    /* renamed from: k */
    private static final C1678hw f2555k = new C1678hw("", (byte) 11, 12);

    /* renamed from: l */
    private static final C1678hw f2556l = new C1678hw("", (byte) 11, 13);

    /* renamed from: m */
    private static final C1678hw f2557m = new C1678hw("", (byte) 10, 14);

    /* renamed from: n */
    private static final C1678hw f2558n = new C1678hw("", (byte) 11, 15);

    /* renamed from: o */
    private static final C1678hw f2559o = new C1678hw("", (byte) 8, 16);

    /* renamed from: p */
    private static final C1678hw f2560p = new C1678hw("", (byte) 11, 17);

    /* renamed from: q */
    private static final C1678hw f2561q = new C1678hw("", (byte) 8, 18);

    /* renamed from: r */
    private static final C1678hw f2562r = new C1678hw("", (byte) 11, 19);

    /* renamed from: s */
    private static final C1678hw f2563s = new C1678hw("", (byte) 2, 20);

    /* renamed from: t */
    private static final C1678hw f2564t = new C1678hw("", (byte) 15, 21);

    /* renamed from: a */
    private BitSet f2569a = new BitSet(6);

    /* renamed from: a */
    public boolean f2571a = false;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m3144a() {
        return this.f2568a != null;
    }

    /* renamed from: b */
    public boolean m3148b() {
        return this.f2567a != null;
    }

    /* renamed from: a */
    public String m3140a() {
        return this.f2574b;
    }

    /* renamed from: c */
    public boolean m3151c() {
        return this.f2574b != null;
    }

    /* renamed from: d */
    public boolean m3153d() {
        return this.f2576c != null;
    }

    /* renamed from: a */
    public long m3139a() {
        return this.f2566a;
    }

    /* renamed from: e */
    public boolean m3155e() {
        return this.f2569a.get(0);
    }

    /* renamed from: a */
    public void m3143a(boolean z) {
        this.f2569a.set(0, z);
    }

    /* renamed from: f */
    public boolean m3157f() {
        return this.f2577d != null;
    }

    /* renamed from: g */
    public boolean m3158g() {
        return this.f2578e != null;
    }

    /* renamed from: b */
    public String m3146b() {
        return this.f2579f;
    }

    /* renamed from: h */
    public boolean m3159h() {
        return this.f2579f != null;
    }

    /* renamed from: c */
    public String m3149c() {
        return this.f2580g;
    }

    /* renamed from: i */
    public boolean m3160i() {
        return this.f2580g != null;
    }

    /* renamed from: j */
    public boolean m3161j() {
        return this.f2569a.get(1);
    }

    /* renamed from: b */
    public void m3147b(boolean z) {
        this.f2569a.set(1, z);
    }

    /* renamed from: k */
    public boolean m3162k() {
        return this.f2581h != null;
    }

    /* renamed from: l */
    public boolean m3163l() {
        return this.f2582i != null;
    }

    /* renamed from: m */
    public boolean m3164m() {
        return this.f2569a.get(2);
    }

    /* renamed from: c */
    public void m3150c(boolean z) {
        this.f2569a.set(2, z);
    }

    /* renamed from: n */
    public boolean m3165n() {
        return this.f2583j != null;
    }

    /* renamed from: o */
    public boolean m3166o() {
        return this.f2569a.get(3);
    }

    /* renamed from: d */
    public void m3152d(boolean z) {
        this.f2569a.set(3, z);
    }

    /* renamed from: p */
    public boolean m3167p() {
        return this.f2584k != null;
    }

    /* renamed from: q */
    public boolean m3168q() {
        return this.f2569a.get(4);
    }

    /* renamed from: e */
    public void m3154e(boolean z) {
        this.f2569a.set(4, z);
    }

    /* renamed from: r */
    public boolean m3169r() {
        return this.f2585l != null;
    }

    /* renamed from: s */
    public boolean m3170s() {
        return this.f2569a.get(5);
    }

    /* renamed from: f */
    public void m3156f(boolean z) {
        this.f2569a.set(5, z);
    }

    /* renamed from: a */
    public List<String> m3141a() {
        return this.f2570a;
    }

    /* renamed from: t */
    public boolean m3171t() {
        return this.f2570a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1661hf)) {
            return m3145a((C1661hf) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3145a(C1661hf c1661hf) {
        if (c1661hf == null) {
            return false;
        }
        boolean m3144a = m3144a();
        boolean m3144a2 = c1661hf.m3144a();
        if ((m3144a || m3144a2) && !(m3144a && m3144a2 && this.f2568a.equals(c1661hf.f2568a))) {
            return false;
        }
        boolean m3148b = m3148b();
        boolean m3148b2 = c1661hf.m3148b();
        if ((m3148b || m3148b2) && !(m3148b && m3148b2 && this.f2567a.m2884a(c1661hf.f2567a))) {
            return false;
        }
        boolean m3151c = m3151c();
        boolean m3151c2 = c1661hf.m3151c();
        if ((m3151c || m3151c2) && !(m3151c && m3151c2 && this.f2574b.equals(c1661hf.f2574b))) {
            return false;
        }
        boolean m3153d = m3153d();
        boolean m3153d2 = c1661hf.m3153d();
        if (((m3153d || m3153d2) && !(m3153d && m3153d2 && this.f2576c.equals(c1661hf.f2576c))) || this.f2566a != c1661hf.f2566a) {
            return false;
        }
        boolean m3157f = m3157f();
        boolean m3157f2 = c1661hf.m3157f();
        if ((m3157f || m3157f2) && !(m3157f && m3157f2 && this.f2577d.equals(c1661hf.f2577d))) {
            return false;
        }
        boolean m3158g = m3158g();
        boolean m3158g2 = c1661hf.m3158g();
        if ((m3158g || m3158g2) && !(m3158g && m3158g2 && this.f2578e.equals(c1661hf.f2578e))) {
            return false;
        }
        boolean m3159h = m3159h();
        boolean m3159h2 = c1661hf.m3159h();
        if ((m3159h || m3159h2) && !(m3159h && m3159h2 && this.f2579f.equals(c1661hf.f2579f))) {
            return false;
        }
        boolean m3160i = m3160i();
        boolean m3160i2 = c1661hf.m3160i();
        if ((m3160i || m3160i2) && !(m3160i && m3160i2 && this.f2580g.equals(c1661hf.f2580g))) {
            return false;
        }
        boolean m3161j = m3161j();
        boolean m3161j2 = c1661hf.m3161j();
        if ((m3161j || m3161j2) && !(m3161j && m3161j2 && this.f2573b == c1661hf.f2573b)) {
            return false;
        }
        boolean m3162k = m3162k();
        boolean m3162k2 = c1661hf.m3162k();
        if ((m3162k || m3162k2) && !(m3162k && m3162k2 && this.f2581h.equals(c1661hf.f2581h))) {
            return false;
        }
        boolean m3163l = m3163l();
        boolean m3163l2 = c1661hf.m3163l();
        if ((m3163l || m3163l2) && !(m3163l && m3163l2 && this.f2582i.equals(c1661hf.f2582i))) {
            return false;
        }
        boolean m3164m = m3164m();
        boolean m3164m2 = c1661hf.m3164m();
        if ((m3164m || m3164m2) && !(m3164m && m3164m2 && this.f2575c == c1661hf.f2575c)) {
            return false;
        }
        boolean m3165n = m3165n();
        boolean m3165n2 = c1661hf.m3165n();
        if ((m3165n || m3165n2) && !(m3165n && m3165n2 && this.f2583j.equals(c1661hf.f2583j))) {
            return false;
        }
        boolean m3166o = m3166o();
        boolean m3166o2 = c1661hf.m3166o();
        if ((m3166o || m3166o2) && !(m3166o && m3166o2 && this.f2565a == c1661hf.f2565a)) {
            return false;
        }
        boolean m3167p = m3167p();
        boolean m3167p2 = c1661hf.m3167p();
        if ((m3167p || m3167p2) && !(m3167p && m3167p2 && this.f2584k.equals(c1661hf.f2584k))) {
            return false;
        }
        boolean m3168q = m3168q();
        boolean m3168q2 = c1661hf.m3168q();
        if ((m3168q || m3168q2) && !(m3168q && m3168q2 && this.f2572b == c1661hf.f2572b)) {
            return false;
        }
        boolean m3169r = m3169r();
        boolean m3169r2 = c1661hf.m3169r();
        if ((m3169r || m3169r2) && !(m3169r && m3169r2 && this.f2585l.equals(c1661hf.f2585l))) {
            return false;
        }
        boolean m3170s = m3170s();
        boolean m3170s2 = c1661hf.m3170s();
        if ((m3170s || m3170s2) && !(m3170s && m3170s2 && this.f2571a == c1661hf.f2571a)) {
            return false;
        }
        boolean m3171t = m3171t();
        boolean m3171t2 = c1661hf.m3171t();
        if (m3171t || m3171t2) {
            return m3171t && m3171t2 && this.f2570a.equals(c1661hf.f2570a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1661hf c1661hf) {
        int m3320a;
        int m3324a;
        int m3318a;
        int m3315a;
        int m3318a2;
        int m3315a2;
        int m3318a3;
        int m3316a;
        int m3318a4;
        int m3318a5;
        int m3316a2;
        int m3318a6;
        int m3318a7;
        int m3318a8;
        int m3318a9;
        int m3316a3;
        int m3318a10;
        int m3318a11;
        int m3317a;
        int m3318a12;
        if (!getClass().equals(c1661hf.getClass())) {
            return getClass().getName().compareTo(c1661hf.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3144a()).compareTo(Boolean.valueOf(c1661hf.m3144a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3144a() && (m3318a12 = C1672hq.m3318a(this.f2568a, c1661hf.f2568a)) != 0) {
            return m3318a12;
        }
        int compareTo2 = Boolean.valueOf(m3148b()).compareTo(Boolean.valueOf(c1661hf.m3148b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3148b() && (m3317a = C1672hq.m3317a(this.f2567a, c1661hf.f2567a)) != 0) {
            return m3317a;
        }
        int compareTo3 = Boolean.valueOf(m3151c()).compareTo(Boolean.valueOf(c1661hf.m3151c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3151c() && (m3318a11 = C1672hq.m3318a(this.f2574b, c1661hf.f2574b)) != 0) {
            return m3318a11;
        }
        int compareTo4 = Boolean.valueOf(m3153d()).compareTo(Boolean.valueOf(c1661hf.m3153d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3153d() && (m3318a10 = C1672hq.m3318a(this.f2576c, c1661hf.f2576c)) != 0) {
            return m3318a10;
        }
        int compareTo5 = Boolean.valueOf(m3155e()).compareTo(Boolean.valueOf(c1661hf.m3155e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3155e() && (m3316a3 = C1672hq.m3316a(this.f2566a, c1661hf.f2566a)) != 0) {
            return m3316a3;
        }
        int compareTo6 = Boolean.valueOf(m3157f()).compareTo(Boolean.valueOf(c1661hf.m3157f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3157f() && (m3318a9 = C1672hq.m3318a(this.f2577d, c1661hf.f2577d)) != 0) {
            return m3318a9;
        }
        int compareTo7 = Boolean.valueOf(m3158g()).compareTo(Boolean.valueOf(c1661hf.m3158g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3158g() && (m3318a8 = C1672hq.m3318a(this.f2578e, c1661hf.f2578e)) != 0) {
            return m3318a8;
        }
        int compareTo8 = Boolean.valueOf(m3159h()).compareTo(Boolean.valueOf(c1661hf.m3159h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3159h() && (m3318a7 = C1672hq.m3318a(this.f2579f, c1661hf.f2579f)) != 0) {
            return m3318a7;
        }
        int compareTo9 = Boolean.valueOf(m3160i()).compareTo(Boolean.valueOf(c1661hf.m3160i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3160i() && (m3318a6 = C1672hq.m3318a(this.f2580g, c1661hf.f2580g)) != 0) {
            return m3318a6;
        }
        int compareTo10 = Boolean.valueOf(m3161j()).compareTo(Boolean.valueOf(c1661hf.m3161j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3161j() && (m3316a2 = C1672hq.m3316a(this.f2573b, c1661hf.f2573b)) != 0) {
            return m3316a2;
        }
        int compareTo11 = Boolean.valueOf(m3162k()).compareTo(Boolean.valueOf(c1661hf.m3162k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m3162k() && (m3318a5 = C1672hq.m3318a(this.f2581h, c1661hf.f2581h)) != 0) {
            return m3318a5;
        }
        int compareTo12 = Boolean.valueOf(m3163l()).compareTo(Boolean.valueOf(c1661hf.m3163l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m3163l() && (m3318a4 = C1672hq.m3318a(this.f2582i, c1661hf.f2582i)) != 0) {
            return m3318a4;
        }
        int compareTo13 = Boolean.valueOf(m3164m()).compareTo(Boolean.valueOf(c1661hf.m3164m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m3164m() && (m3316a = C1672hq.m3316a(this.f2575c, c1661hf.f2575c)) != 0) {
            return m3316a;
        }
        int compareTo14 = Boolean.valueOf(m3165n()).compareTo(Boolean.valueOf(c1661hf.m3165n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (m3165n() && (m3318a3 = C1672hq.m3318a(this.f2583j, c1661hf.f2583j)) != 0) {
            return m3318a3;
        }
        int compareTo15 = Boolean.valueOf(m3166o()).compareTo(Boolean.valueOf(c1661hf.m3166o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (m3166o() && (m3315a2 = C1672hq.m3315a(this.f2565a, c1661hf.f2565a)) != 0) {
            return m3315a2;
        }
        int compareTo16 = Boolean.valueOf(m3167p()).compareTo(Boolean.valueOf(c1661hf.m3167p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (m3167p() && (m3318a2 = C1672hq.m3318a(this.f2584k, c1661hf.f2584k)) != 0) {
            return m3318a2;
        }
        int compareTo17 = Boolean.valueOf(m3168q()).compareTo(Boolean.valueOf(c1661hf.m3168q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (m3168q() && (m3315a = C1672hq.m3315a(this.f2572b, c1661hf.f2572b)) != 0) {
            return m3315a;
        }
        int compareTo18 = Boolean.valueOf(m3169r()).compareTo(Boolean.valueOf(c1661hf.m3169r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (m3169r() && (m3318a = C1672hq.m3318a(this.f2585l, c1661hf.f2585l)) != 0) {
            return m3318a;
        }
        int compareTo19 = Boolean.valueOf(m3170s()).compareTo(Boolean.valueOf(c1661hf.m3170s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (m3170s() && (m3324a = C1672hq.m3324a(this.f2571a, c1661hf.f2571a)) != 0) {
            return m3324a;
        }
        int compareTo20 = Boolean.valueOf(m3171t()).compareTo(Boolean.valueOf(c1661hf.m3171t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!m3171t() || (m3320a = C1672hq.m3320a(this.f2570a, c1661hf.f2570a)) == 0) {
            return 0;
        }
        return m3320a;
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
                            this.f2568a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2567a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2574b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2576c = abstractC1681hz.mo3345a();
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
                            this.f2566a = abstractC1681hz.mo3339a();
                            m3143a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f2577d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 11) {
                            this.f2578e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 9:
                        if (mo3340a.f2770a == 11) {
                            this.f2579f = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 11) {
                            this.f2580g = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 11:
                        if (mo3340a.f2770a == 10) {
                            this.f2573b = abstractC1681hz.mo3339a();
                            m3147b(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 12:
                        if (mo3340a.f2770a == 11) {
                            this.f2581h = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 13:
                        if (mo3340a.f2770a == 11) {
                            this.f2582i = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 14:
                        if (mo3340a.f2770a == 10) {
                            this.f2575c = abstractC1681hz.mo3339a();
                            m3150c(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 15:
                        if (mo3340a.f2770a == 11) {
                            this.f2583j = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 16:
                        if (mo3340a.f2770a == 8) {
                            this.f2565a = abstractC1681hz.mo3338a();
                            m3152d(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 17:
                        if (mo3340a.f2770a == 11) {
                            this.f2584k = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 18:
                        if (mo3340a.f2770a == 8) {
                            this.f2572b = abstractC1681hz.mo3338a();
                            m3154e(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 19:
                        if (mo3340a.f2770a == 11) {
                            this.f2585l = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 20:
                        if (mo3340a.f2770a == 2) {
                            this.f2571a = abstractC1681hz.mo3361a();
                            m3156f(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 21:
                        if (mo3340a.f2770a == 15) {
                            C1679hx mo3341a = abstractC1681hz.mo3341a();
                            this.f2570a = new ArrayList(mo3341a.f2774a);
                            for (int i = 0; i < mo3341a.f2774a; i++) {
                                this.f2570a.add(abstractC1681hz.mo3345a());
                            }
                            abstractC1681hz.mo3371i();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                }
                abstractC1681hz.mo3369g();
            } else {
                abstractC1681hz.mo3368f();
                if (!m3155e()) {
                    throw new C1683ia("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m3142a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m3142a();
        abstractC1681hz.mo3356a(f2545a);
        if (this.f2568a != null && m3144a()) {
            abstractC1681hz.mo3353a(f2544a);
            abstractC1681hz.mo3357a(this.f2568a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2567a != null && m3148b()) {
            abstractC1681hz.mo3353a(f2546b);
            this.f2567a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2574b != null) {
            abstractC1681hz.mo3353a(f2547c);
            abstractC1681hz.mo3357a(this.f2574b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2576c != null) {
            abstractC1681hz.mo3353a(f2548d);
            abstractC1681hz.mo3357a(this.f2576c);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3353a(f2549e);
        abstractC1681hz.mo3352a(this.f2566a);
        abstractC1681hz.mo3362b();
        if (this.f2577d != null && m3157f()) {
            abstractC1681hz.mo3353a(f2550f);
            abstractC1681hz.mo3357a(this.f2577d);
            abstractC1681hz.mo3362b();
        }
        if (this.f2578e != null && m3158g()) {
            abstractC1681hz.mo3353a(f2551g);
            abstractC1681hz.mo3357a(this.f2578e);
            abstractC1681hz.mo3362b();
        }
        if (this.f2579f != null && m3159h()) {
            abstractC1681hz.mo3353a(f2552h);
            abstractC1681hz.mo3357a(this.f2579f);
            abstractC1681hz.mo3362b();
        }
        if (this.f2580g != null && m3160i()) {
            abstractC1681hz.mo3353a(f2553i);
            abstractC1681hz.mo3357a(this.f2580g);
            abstractC1681hz.mo3362b();
        }
        if (m3161j()) {
            abstractC1681hz.mo3353a(f2554j);
            abstractC1681hz.mo3352a(this.f2573b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2581h != null && m3162k()) {
            abstractC1681hz.mo3353a(f2555k);
            abstractC1681hz.mo3357a(this.f2581h);
            abstractC1681hz.mo3362b();
        }
        if (this.f2582i != null && m3163l()) {
            abstractC1681hz.mo3353a(f2556l);
            abstractC1681hz.mo3357a(this.f2582i);
            abstractC1681hz.mo3362b();
        }
        if (m3164m()) {
            abstractC1681hz.mo3353a(f2557m);
            abstractC1681hz.mo3352a(this.f2575c);
            abstractC1681hz.mo3362b();
        }
        if (this.f2583j != null && m3165n()) {
            abstractC1681hz.mo3353a(f2558n);
            abstractC1681hz.mo3357a(this.f2583j);
            abstractC1681hz.mo3362b();
        }
        if (m3166o()) {
            abstractC1681hz.mo3353a(f2559o);
            abstractC1681hz.mo3351a(this.f2565a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2584k != null && m3167p()) {
            abstractC1681hz.mo3353a(f2560p);
            abstractC1681hz.mo3357a(this.f2584k);
            abstractC1681hz.mo3362b();
        }
        if (m3168q()) {
            abstractC1681hz.mo3353a(f2561q);
            abstractC1681hz.mo3351a(this.f2572b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2585l != null && m3169r()) {
            abstractC1681hz.mo3353a(f2562r);
            abstractC1681hz.mo3357a(this.f2585l);
            abstractC1681hz.mo3362b();
        }
        if (m3170s()) {
            abstractC1681hz.mo3353a(f2563s);
            abstractC1681hz.mo3360a(this.f2571a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2570a != null && m3171t()) {
            abstractC1681hz.mo3353a(f2564t);
            abstractC1681hz.mo3354a(new C1679hx((byte) 11, this.f2570a.size()));
            Iterator<String> it = this.f2570a.iterator();
            while (it.hasNext()) {
                abstractC1681hz.mo3357a(it.next());
            }
            abstractC1681hz.mo3367e();
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = false;
        if (m3144a()) {
            sb.append("debug:");
            String str = this.f2568a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m3148b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1648gt c1648gt = this.f2567a;
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
        String str2 = this.f2574b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(C1752aj.m3693a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f2576c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f2566a);
        if (m3157f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f2577d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m3158g()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f2578e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m3160i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f2580g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m3161j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f2573b);
        }
        if (m3162k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str7 = this.f2581h;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (m3163l()) {
            sb.append(", ");
            sb.append("clientId:");
            String str8 = this.f2582i;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m3164m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f2575c);
        }
        if (m3165n()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str9 = this.f2583j;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (m3166o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f2565a);
        }
        if (m3167p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str10 = this.f2584k;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (m3168q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f2572b);
        }
        if (m3169r()) {
            sb.append(", ");
            sb.append("region:");
            String str11 = this.f2585l;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (m3170s()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f2571a);
        }
        if (m3171t()) {
            sb.append(", ");
            sb.append("autoMarkPkgs:");
            List<String> list = this.f2570a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m3142a() {
        if (this.f2574b == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f2576c == null) {
            throw new C1683ia("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
