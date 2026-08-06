package com.xiaomi.push;

import com.xiaomi.push.service.C1752aj;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.he */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1660he implements InterfaceC1671hp<C1660he, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public int f2514a;

    /* renamed from: a */
    public long f2515a;

    /* renamed from: a */
    public EnumC1647gs f2516a;

    /* renamed from: a */
    public C1648gt f2517a;

    /* renamed from: a */
    public String f2518a;

    /* renamed from: a */
    public Map<String, String> f2520a;

    /* renamed from: b */
    public int f2522b;

    /* renamed from: b */
    public long f2523b;

    /* renamed from: b */
    public String f2524b;

    /* renamed from: c */
    public int f2526c;

    /* renamed from: c */
    public String f2527c;

    /* renamed from: d */
    public String f2529d;

    /* renamed from: e */
    public String f2530e;

    /* renamed from: f */
    public String f2531f;

    /* renamed from: g */
    public String f2532g;

    /* renamed from: h */
    public String f2533h;

    /* renamed from: i */
    public String f2534i;

    /* renamed from: j */
    public String f2535j;

    /* renamed from: k */
    public String f2536k;

    /* renamed from: l */
    public String f2537l;

    /* renamed from: m */
    public String f2538m;

    /* renamed from: n */
    public String f2539n;

    /* renamed from: o */
    public String f2540o;

    /* renamed from: p */
    public String f2541p;

    /* renamed from: q */
    public String f2542q;

    /* renamed from: r */
    public String f2543r;

    /* renamed from: a */
    private static final C1687ie f2488a = new C1687ie("XmPushActionRegistration");

    /* renamed from: a */
    private static final C1678hw f2487a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f2489b = new C1678hw("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1678hw f2490c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2491d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2492e = new C1678hw("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1678hw f2493f = new C1678hw("", (byte) 11, 6);

    /* renamed from: g */
    private static final C1678hw f2494g = new C1678hw("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1678hw f2495h = new C1678hw("", (byte) 11, 8);

    /* renamed from: i */
    private static final C1678hw f2496i = new C1678hw("", (byte) 11, 9);

    /* renamed from: j */
    private static final C1678hw f2497j = new C1678hw("", (byte) 11, 10);

    /* renamed from: k */
    private static final C1678hw f2498k = new C1678hw("", (byte) 11, 11);

    /* renamed from: l */
    private static final C1678hw f2499l = new C1678hw("", (byte) 11, 12);

    /* renamed from: m */
    private static final C1678hw f2500m = new C1678hw("", (byte) 8, 13);

    /* renamed from: n */
    private static final C1678hw f2501n = new C1678hw("", (byte) 8, 14);

    /* renamed from: o */
    private static final C1678hw f2502o = new C1678hw("", (byte) 11, 15);

    /* renamed from: p */
    private static final C1678hw f2503p = new C1678hw("", (byte) 11, 16);

    /* renamed from: q */
    private static final C1678hw f2504q = new C1678hw("", (byte) 11, 17);

    /* renamed from: r */
    private static final C1678hw f2505r = new C1678hw("", (byte) 11, 18);

    /* renamed from: s */
    private static final C1678hw f2506s = new C1678hw("", (byte) 8, 19);

    /* renamed from: t */
    private static final C1678hw f2507t = new C1678hw("", (byte) 8, 20);

    /* renamed from: u */
    private static final C1678hw f2508u = new C1678hw("", (byte) 2, 21);

    /* renamed from: v */
    private static final C1678hw f2509v = new C1678hw("", (byte) 10, 22);

    /* renamed from: w */
    private static final C1678hw f2510w = new C1678hw("", (byte) 10, 23);

    /* renamed from: x */
    private static final C1678hw f2511x = new C1678hw("", (byte) 11, 24);

    /* renamed from: y */
    private static final C1678hw f2512y = new C1678hw("", (byte) 11, 25);

    /* renamed from: z */
    private static final C1678hw f2513z = new C1678hw("", (byte) 2, 26);

    /* renamed from: A */
    private static final C1678hw f2484A = new C1678hw("", (byte) 13, 100);

    /* renamed from: B */
    private static final C1678hw f2485B = new C1678hw("", (byte) 2, 101);

    /* renamed from: C */
    private static final C1678hw f2486C = new C1678hw("", (byte) 11, 102);

    /* renamed from: a */
    private BitSet f2519a = new BitSet(8);

    /* renamed from: a */
    public boolean f2521a = true;

    /* renamed from: c */
    public boolean f2528c = false;

    /* renamed from: b */
    public boolean f2525b = false;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m3092a() {
        return this.f2518a != null;
    }

    /* renamed from: b */
    public boolean m3098b() {
        return this.f2517a != null;
    }

    /* renamed from: a */
    public String m3089a() {
        return this.f2524b;
    }

    /* renamed from: a */
    public C1660he m3088a(String str) {
        this.f2524b = str;
        return this;
    }

    /* renamed from: c */
    public boolean m3103c() {
        return this.f2524b != null;
    }

    /* renamed from: b */
    public String m3096b() {
        return this.f2527c;
    }

    /* renamed from: b */
    public C1660he m3095b(String str) {
        this.f2527c = str;
        return this;
    }

    /* renamed from: d */
    public boolean m3106d() {
        return this.f2527c != null;
    }

    /* renamed from: c */
    public C1660he m3100c(String str) {
        this.f2529d = str;
        return this;
    }

    /* renamed from: e */
    public boolean m3109e() {
        return this.f2529d != null;
    }

    /* renamed from: d */
    public C1660he m3104d(String str) {
        this.f2530e = str;
        return this;
    }

    /* renamed from: f */
    public boolean m3112f() {
        return this.f2530e != null;
    }

    /* renamed from: c */
    public String m3101c() {
        return this.f2531f;
    }

    /* renamed from: e */
    public C1660he m3107e(String str) {
        this.f2531f = str;
        return this;
    }

    /* renamed from: g */
    public boolean m3115g() {
        return this.f2531f != null;
    }

    /* renamed from: f */
    public C1660he m3110f(String str) {
        this.f2532g = str;
        return this;
    }

    /* renamed from: h */
    public boolean m3118h() {
        return this.f2532g != null;
    }

    /* renamed from: g */
    public C1660he m3113g(String str) {
        this.f2533h = str;
        return this;
    }

    /* renamed from: i */
    public boolean m3120i() {
        return this.f2533h != null;
    }

    /* renamed from: j */
    public boolean m3121j() {
        return this.f2534i != null;
    }

    /* renamed from: k */
    public boolean m3122k() {
        return this.f2535j != null;
    }

    /* renamed from: h */
    public C1660he m3116h(String str) {
        this.f2536k = str;
        return this;
    }

    /* renamed from: l */
    public boolean m3123l() {
        return this.f2536k != null;
    }

    /* renamed from: a */
    public C1660he m3086a(int i) {
        this.f2514a = i;
        m3091a(true);
        return this;
    }

    /* renamed from: m */
    public boolean m3124m() {
        return this.f2519a.get(0);
    }

    /* renamed from: a */
    public void m3091a(boolean z) {
        this.f2519a.set(0, z);
    }

    /* renamed from: b */
    public C1660he m3094b(int i) {
        this.f2522b = i;
        m3097b(true);
        return this;
    }

    /* renamed from: n */
    public boolean m3125n() {
        return this.f2519a.get(1);
    }

    /* renamed from: b */
    public void m3097b(boolean z) {
        this.f2519a.set(1, z);
    }

    /* renamed from: o */
    public boolean m3126o() {
        return this.f2537l != null;
    }

    /* renamed from: p */
    public boolean m3127p() {
        return this.f2538m != null;
    }

    /* renamed from: q */
    public boolean m3128q() {
        return this.f2539n != null;
    }

    /* renamed from: i */
    public C1660he m3119i(String str) {
        this.f2540o = str;
        return this;
    }

    /* renamed from: r */
    public boolean m3129r() {
        return this.f2540o != null;
    }

    /* renamed from: c */
    public C1660he m3099c(int i) {
        this.f2526c = i;
        m3102c(true);
        return this;
    }

    /* renamed from: s */
    public boolean m3130s() {
        return this.f2519a.get(2);
    }

    /* renamed from: c */
    public void m3102c(boolean z) {
        this.f2519a.set(2, z);
    }

    /* renamed from: a */
    public C1660he m3087a(EnumC1647gs enumC1647gs) {
        this.f2516a = enumC1647gs;
        return this;
    }

    /* renamed from: t */
    public boolean m3131t() {
        return this.f2516a != null;
    }

    /* renamed from: u */
    public boolean m3132u() {
        return this.f2519a.get(3);
    }

    /* renamed from: d */
    public void m3105d(boolean z) {
        this.f2519a.set(3, z);
    }

    /* renamed from: v */
    public boolean m3133v() {
        return this.f2519a.get(4);
    }

    /* renamed from: e */
    public void m3108e(boolean z) {
        this.f2519a.set(4, z);
    }

    /* renamed from: w */
    public boolean m3134w() {
        return this.f2519a.get(5);
    }

    /* renamed from: f */
    public void m3111f(boolean z) {
        this.f2519a.set(5, z);
    }

    /* renamed from: x */
    public boolean m3135x() {
        return this.f2541p != null;
    }

    /* renamed from: y */
    public boolean m3136y() {
        return this.f2542q != null;
    }

    /* renamed from: z */
    public boolean m3137z() {
        return this.f2519a.get(6);
    }

    /* renamed from: g */
    public void m3114g(boolean z) {
        this.f2519a.set(6, z);
    }

    /* renamed from: A */
    public boolean m3082A() {
        return this.f2520a != null;
    }

    /* renamed from: B */
    public boolean m3083B() {
        return this.f2519a.get(7);
    }

    /* renamed from: h */
    public void m3117h(boolean z) {
        this.f2519a.set(7, z);
    }

    /* renamed from: C */
    public boolean m3084C() {
        return this.f2543r != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1660he)) {
            return m3093a((C1660he) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3093a(C1660he c1660he) {
        if (c1660he == null) {
            return false;
        }
        boolean m3092a = m3092a();
        boolean m3092a2 = c1660he.m3092a();
        if ((m3092a || m3092a2) && !(m3092a && m3092a2 && this.f2518a.equals(c1660he.f2518a))) {
            return false;
        }
        boolean m3098b = m3098b();
        boolean m3098b2 = c1660he.m3098b();
        if ((m3098b || m3098b2) && !(m3098b && m3098b2 && this.f2517a.m2884a(c1660he.f2517a))) {
            return false;
        }
        boolean m3103c = m3103c();
        boolean m3103c2 = c1660he.m3103c();
        if ((m3103c || m3103c2) && !(m3103c && m3103c2 && this.f2524b.equals(c1660he.f2524b))) {
            return false;
        }
        boolean m3106d = m3106d();
        boolean m3106d2 = c1660he.m3106d();
        if ((m3106d || m3106d2) && !(m3106d && m3106d2 && this.f2527c.equals(c1660he.f2527c))) {
            return false;
        }
        boolean m3109e = m3109e();
        boolean m3109e2 = c1660he.m3109e();
        if ((m3109e || m3109e2) && !(m3109e && m3109e2 && this.f2529d.equals(c1660he.f2529d))) {
            return false;
        }
        boolean m3112f = m3112f();
        boolean m3112f2 = c1660he.m3112f();
        if ((m3112f || m3112f2) && !(m3112f && m3112f2 && this.f2530e.equals(c1660he.f2530e))) {
            return false;
        }
        boolean m3115g = m3115g();
        boolean m3115g2 = c1660he.m3115g();
        if ((m3115g || m3115g2) && !(m3115g && m3115g2 && this.f2531f.equals(c1660he.f2531f))) {
            return false;
        }
        boolean m3118h = m3118h();
        boolean m3118h2 = c1660he.m3118h();
        if ((m3118h || m3118h2) && !(m3118h && m3118h2 && this.f2532g.equals(c1660he.f2532g))) {
            return false;
        }
        boolean m3120i = m3120i();
        boolean m3120i2 = c1660he.m3120i();
        if ((m3120i || m3120i2) && !(m3120i && m3120i2 && this.f2533h.equals(c1660he.f2533h))) {
            return false;
        }
        boolean m3121j = m3121j();
        boolean m3121j2 = c1660he.m3121j();
        if ((m3121j || m3121j2) && !(m3121j && m3121j2 && this.f2534i.equals(c1660he.f2534i))) {
            return false;
        }
        boolean m3122k = m3122k();
        boolean m3122k2 = c1660he.m3122k();
        if ((m3122k || m3122k2) && !(m3122k && m3122k2 && this.f2535j.equals(c1660he.f2535j))) {
            return false;
        }
        boolean m3123l = m3123l();
        boolean m3123l2 = c1660he.m3123l();
        if ((m3123l || m3123l2) && !(m3123l && m3123l2 && this.f2536k.equals(c1660he.f2536k))) {
            return false;
        }
        boolean m3124m = m3124m();
        boolean m3124m2 = c1660he.m3124m();
        if ((m3124m || m3124m2) && !(m3124m && m3124m2 && this.f2514a == c1660he.f2514a)) {
            return false;
        }
        boolean m3125n = m3125n();
        boolean m3125n2 = c1660he.m3125n();
        if ((m3125n || m3125n2) && !(m3125n && m3125n2 && this.f2522b == c1660he.f2522b)) {
            return false;
        }
        boolean m3126o = m3126o();
        boolean m3126o2 = c1660he.m3126o();
        if ((m3126o || m3126o2) && !(m3126o && m3126o2 && this.f2537l.equals(c1660he.f2537l))) {
            return false;
        }
        boolean m3127p = m3127p();
        boolean m3127p2 = c1660he.m3127p();
        if ((m3127p || m3127p2) && !(m3127p && m3127p2 && this.f2538m.equals(c1660he.f2538m))) {
            return false;
        }
        boolean m3128q = m3128q();
        boolean m3128q2 = c1660he.m3128q();
        if ((m3128q || m3128q2) && !(m3128q && m3128q2 && this.f2539n.equals(c1660he.f2539n))) {
            return false;
        }
        boolean m3129r = m3129r();
        boolean m3129r2 = c1660he.m3129r();
        if ((m3129r || m3129r2) && !(m3129r && m3129r2 && this.f2540o.equals(c1660he.f2540o))) {
            return false;
        }
        boolean m3130s = m3130s();
        boolean m3130s2 = c1660he.m3130s();
        if ((m3130s || m3130s2) && !(m3130s && m3130s2 && this.f2526c == c1660he.f2526c)) {
            return false;
        }
        boolean m3131t = m3131t();
        boolean m3131t2 = c1660he.m3131t();
        if ((m3131t || m3131t2) && !(m3131t && m3131t2 && this.f2516a.equals(c1660he.f2516a))) {
            return false;
        }
        boolean m3132u = m3132u();
        boolean m3132u2 = c1660he.m3132u();
        if ((m3132u || m3132u2) && !(m3132u && m3132u2 && this.f2521a == c1660he.f2521a)) {
            return false;
        }
        boolean m3133v = m3133v();
        boolean m3133v2 = c1660he.m3133v();
        if ((m3133v || m3133v2) && !(m3133v && m3133v2 && this.f2515a == c1660he.f2515a)) {
            return false;
        }
        boolean m3134w = m3134w();
        boolean m3134w2 = c1660he.m3134w();
        if ((m3134w || m3134w2) && !(m3134w && m3134w2 && this.f2523b == c1660he.f2523b)) {
            return false;
        }
        boolean m3135x = m3135x();
        boolean m3135x2 = c1660he.m3135x();
        if ((m3135x || m3135x2) && !(m3135x && m3135x2 && this.f2541p.equals(c1660he.f2541p))) {
            return false;
        }
        boolean m3136y = m3136y();
        boolean m3136y2 = c1660he.m3136y();
        if ((m3136y || m3136y2) && !(m3136y && m3136y2 && this.f2542q.equals(c1660he.f2542q))) {
            return false;
        }
        boolean m3137z = m3137z();
        boolean m3137z2 = c1660he.m3137z();
        if ((m3137z || m3137z2) && !(m3137z && m3137z2 && this.f2525b == c1660he.f2525b)) {
            return false;
        }
        boolean m3082A = m3082A();
        boolean m3082A2 = c1660he.m3082A();
        if ((m3082A || m3082A2) && !(m3082A && m3082A2 && this.f2520a.equals(c1660he.f2520a))) {
            return false;
        }
        boolean m3083B = m3083B();
        boolean m3083B2 = c1660he.m3083B();
        if ((m3083B || m3083B2) && !(m3083B && m3083B2 && this.f2528c == c1660he.f2528c)) {
            return false;
        }
        boolean m3084C = m3084C();
        boolean m3084C2 = c1660he.m3084C();
        if (m3084C || m3084C2) {
            return m3084C && m3084C2 && this.f2543r.equals(c1660he.f2543r);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1660he c1660he) {
        int m3318a;
        int m3324a;
        int m3321a;
        int m3324a2;
        int m3318a2;
        int m3318a3;
        int m3316a;
        int m3316a2;
        int m3324a3;
        int m3317a;
        int m3315a;
        int m3318a4;
        int m3318a5;
        int m3318a6;
        int m3318a7;
        int m3315a2;
        int m3315a3;
        int m3318a8;
        int m3318a9;
        int m3318a10;
        int m3318a11;
        int m3318a12;
        int m3318a13;
        int m3318a14;
        int m3318a15;
        int m3318a16;
        int m3318a17;
        int m3317a2;
        int m3318a18;
        if (!getClass().equals(c1660he.getClass())) {
            return getClass().getName().compareTo(c1660he.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3092a()).compareTo(Boolean.valueOf(c1660he.m3092a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3092a() && (m3318a18 = C1672hq.m3318a(this.f2518a, c1660he.f2518a)) != 0) {
            return m3318a18;
        }
        int compareTo2 = Boolean.valueOf(m3098b()).compareTo(Boolean.valueOf(c1660he.m3098b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3098b() && (m3317a2 = C1672hq.m3317a(this.f2517a, c1660he.f2517a)) != 0) {
            return m3317a2;
        }
        int compareTo3 = Boolean.valueOf(m3103c()).compareTo(Boolean.valueOf(c1660he.m3103c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3103c() && (m3318a17 = C1672hq.m3318a(this.f2524b, c1660he.f2524b)) != 0) {
            return m3318a17;
        }
        int compareTo4 = Boolean.valueOf(m3106d()).compareTo(Boolean.valueOf(c1660he.m3106d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3106d() && (m3318a16 = C1672hq.m3318a(this.f2527c, c1660he.f2527c)) != 0) {
            return m3318a16;
        }
        int compareTo5 = Boolean.valueOf(m3109e()).compareTo(Boolean.valueOf(c1660he.m3109e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3109e() && (m3318a15 = C1672hq.m3318a(this.f2529d, c1660he.f2529d)) != 0) {
            return m3318a15;
        }
        int compareTo6 = Boolean.valueOf(m3112f()).compareTo(Boolean.valueOf(c1660he.m3112f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3112f() && (m3318a14 = C1672hq.m3318a(this.f2530e, c1660he.f2530e)) != 0) {
            return m3318a14;
        }
        int compareTo7 = Boolean.valueOf(m3115g()).compareTo(Boolean.valueOf(c1660he.m3115g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3115g() && (m3318a13 = C1672hq.m3318a(this.f2531f, c1660he.f2531f)) != 0) {
            return m3318a13;
        }
        int compareTo8 = Boolean.valueOf(m3118h()).compareTo(Boolean.valueOf(c1660he.m3118h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3118h() && (m3318a12 = C1672hq.m3318a(this.f2532g, c1660he.f2532g)) != 0) {
            return m3318a12;
        }
        int compareTo9 = Boolean.valueOf(m3120i()).compareTo(Boolean.valueOf(c1660he.m3120i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3120i() && (m3318a11 = C1672hq.m3318a(this.f2533h, c1660he.f2533h)) != 0) {
            return m3318a11;
        }
        int compareTo10 = Boolean.valueOf(m3121j()).compareTo(Boolean.valueOf(c1660he.m3121j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3121j() && (m3318a10 = C1672hq.m3318a(this.f2534i, c1660he.f2534i)) != 0) {
            return m3318a10;
        }
        int compareTo11 = Boolean.valueOf(m3122k()).compareTo(Boolean.valueOf(c1660he.m3122k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m3122k() && (m3318a9 = C1672hq.m3318a(this.f2535j, c1660he.f2535j)) != 0) {
            return m3318a9;
        }
        int compareTo12 = Boolean.valueOf(m3123l()).compareTo(Boolean.valueOf(c1660he.m3123l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m3123l() && (m3318a8 = C1672hq.m3318a(this.f2536k, c1660he.f2536k)) != 0) {
            return m3318a8;
        }
        int compareTo13 = Boolean.valueOf(m3124m()).compareTo(Boolean.valueOf(c1660he.m3124m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m3124m() && (m3315a3 = C1672hq.m3315a(this.f2514a, c1660he.f2514a)) != 0) {
            return m3315a3;
        }
        int compareTo14 = Boolean.valueOf(m3125n()).compareTo(Boolean.valueOf(c1660he.m3125n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (m3125n() && (m3315a2 = C1672hq.m3315a(this.f2522b, c1660he.f2522b)) != 0) {
            return m3315a2;
        }
        int compareTo15 = Boolean.valueOf(m3126o()).compareTo(Boolean.valueOf(c1660he.m3126o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (m3126o() && (m3318a7 = C1672hq.m3318a(this.f2537l, c1660he.f2537l)) != 0) {
            return m3318a7;
        }
        int compareTo16 = Boolean.valueOf(m3127p()).compareTo(Boolean.valueOf(c1660he.m3127p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (m3127p() && (m3318a6 = C1672hq.m3318a(this.f2538m, c1660he.f2538m)) != 0) {
            return m3318a6;
        }
        int compareTo17 = Boolean.valueOf(m3128q()).compareTo(Boolean.valueOf(c1660he.m3128q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (m3128q() && (m3318a5 = C1672hq.m3318a(this.f2539n, c1660he.f2539n)) != 0) {
            return m3318a5;
        }
        int compareTo18 = Boolean.valueOf(m3129r()).compareTo(Boolean.valueOf(c1660he.m3129r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (m3129r() && (m3318a4 = C1672hq.m3318a(this.f2540o, c1660he.f2540o)) != 0) {
            return m3318a4;
        }
        int compareTo19 = Boolean.valueOf(m3130s()).compareTo(Boolean.valueOf(c1660he.m3130s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (m3130s() && (m3315a = C1672hq.m3315a(this.f2526c, c1660he.f2526c)) != 0) {
            return m3315a;
        }
        int compareTo20 = Boolean.valueOf(m3131t()).compareTo(Boolean.valueOf(c1660he.m3131t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (m3131t() && (m3317a = C1672hq.m3317a(this.f2516a, c1660he.f2516a)) != 0) {
            return m3317a;
        }
        int compareTo21 = Boolean.valueOf(m3132u()).compareTo(Boolean.valueOf(c1660he.m3132u()));
        if (compareTo21 != 0) {
            return compareTo21;
        }
        if (m3132u() && (m3324a3 = C1672hq.m3324a(this.f2521a, c1660he.f2521a)) != 0) {
            return m3324a3;
        }
        int compareTo22 = Boolean.valueOf(m3133v()).compareTo(Boolean.valueOf(c1660he.m3133v()));
        if (compareTo22 != 0) {
            return compareTo22;
        }
        if (m3133v() && (m3316a2 = C1672hq.m3316a(this.f2515a, c1660he.f2515a)) != 0) {
            return m3316a2;
        }
        int compareTo23 = Boolean.valueOf(m3134w()).compareTo(Boolean.valueOf(c1660he.m3134w()));
        if (compareTo23 != 0) {
            return compareTo23;
        }
        if (m3134w() && (m3316a = C1672hq.m3316a(this.f2523b, c1660he.f2523b)) != 0) {
            return m3316a;
        }
        int compareTo24 = Boolean.valueOf(m3135x()).compareTo(Boolean.valueOf(c1660he.m3135x()));
        if (compareTo24 != 0) {
            return compareTo24;
        }
        if (m3135x() && (m3318a3 = C1672hq.m3318a(this.f2541p, c1660he.f2541p)) != 0) {
            return m3318a3;
        }
        int compareTo25 = Boolean.valueOf(m3136y()).compareTo(Boolean.valueOf(c1660he.m3136y()));
        if (compareTo25 != 0) {
            return compareTo25;
        }
        if (m3136y() && (m3318a2 = C1672hq.m3318a(this.f2542q, c1660he.f2542q)) != 0) {
            return m3318a2;
        }
        int compareTo26 = Boolean.valueOf(m3137z()).compareTo(Boolean.valueOf(c1660he.m3137z()));
        if (compareTo26 != 0) {
            return compareTo26;
        }
        if (m3137z() && (m3324a2 = C1672hq.m3324a(this.f2525b, c1660he.f2525b)) != 0) {
            return m3324a2;
        }
        int compareTo27 = Boolean.valueOf(m3082A()).compareTo(Boolean.valueOf(c1660he.m3082A()));
        if (compareTo27 != 0) {
            return compareTo27;
        }
        if (m3082A() && (m3321a = C1672hq.m3321a(this.f2520a, c1660he.f2520a)) != 0) {
            return m3321a;
        }
        int compareTo28 = Boolean.valueOf(m3083B()).compareTo(Boolean.valueOf(c1660he.m3083B()));
        if (compareTo28 != 0) {
            return compareTo28;
        }
        if (m3083B() && (m3324a = C1672hq.m3324a(this.f2528c, c1660he.f2528c)) != 0) {
            return m3324a;
        }
        int compareTo29 = Boolean.valueOf(m3084C()).compareTo(Boolean.valueOf(c1660he.m3084C()));
        if (compareTo29 != 0) {
            return compareTo29;
        }
        if (!m3084C() || (m3318a = C1672hq.m3318a(this.f2543r, c1660he.f2543r)) == 0) {
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
                short s = mo3340a.f2772a;
                switch (s) {
                    case 1:
                        if (mo3340a.f2770a == 11) {
                            this.f2518a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2517a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2524b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2527c = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 11) {
                            this.f2529d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                        if (mo3340a.f2770a == 11) {
                            this.f2530e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f2531f = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 11) {
                            this.f2532g = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 9:
                        if (mo3340a.f2770a == 11) {
                            this.f2533h = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 11) {
                            this.f2534i = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 11:
                        if (mo3340a.f2770a == 11) {
                            this.f2535j = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 12:
                        if (mo3340a.f2770a == 11) {
                            this.f2536k = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 13:
                        if (mo3340a.f2770a == 8) {
                            this.f2514a = abstractC1681hz.mo3338a();
                            m3091a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 14:
                        if (mo3340a.f2770a == 8) {
                            this.f2522b = abstractC1681hz.mo3338a();
                            m3097b(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 15:
                        if (mo3340a.f2770a == 11) {
                            this.f2537l = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 16:
                        if (mo3340a.f2770a == 11) {
                            this.f2538m = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 17:
                        if (mo3340a.f2770a == 11) {
                            this.f2539n = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 18:
                        if (mo3340a.f2770a == 11) {
                            this.f2540o = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 19:
                        if (mo3340a.f2770a == 8) {
                            this.f2526c = abstractC1681hz.mo3338a();
                            m3102c(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 20:
                        if (mo3340a.f2770a == 8) {
                            this.f2516a = EnumC1647gs.m2878a(abstractC1681hz.mo3338a());
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 21:
                        if (mo3340a.f2770a == 2) {
                            this.f2521a = abstractC1681hz.mo3361a();
                            m3105d(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 22:
                        if (mo3340a.f2770a == 10) {
                            this.f2515a = abstractC1681hz.mo3339a();
                            m3108e(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 23:
                        if (mo3340a.f2770a == 10) {
                            this.f2523b = abstractC1681hz.mo3339a();
                            m3111f(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 24:
                        if (mo3340a.f2770a == 11) {
                            this.f2541p = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 25:
                        if (mo3340a.f2770a == 11) {
                            this.f2542q = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 26:
                        if (mo3340a.f2770a == 2) {
                            this.f2525b = abstractC1681hz.mo3361a();
                            m3114g(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    default:
                        switch (s) {
                            case 100:
                                if (mo3340a.f2770a == 13) {
                                    C1680hy mo3342a = abstractC1681hz.mo3342a();
                                    this.f2520a = new HashMap(mo3342a.f2776a * 2);
                                    for (int i = 0; i < mo3342a.f2776a; i++) {
                                        this.f2520a.put(abstractC1681hz.mo3345a(), abstractC1681hz.mo3345a());
                                    }
                                    abstractC1681hz.mo3370h();
                                    break;
                                } else {
                                    C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                                    break;
                                }
                            case 101:
                                if (mo3340a.f2770a == 2) {
                                    this.f2528c = abstractC1681hz.mo3361a();
                                    m3117h(true);
                                    break;
                                } else {
                                    C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                                    break;
                                }
                            case 102:
                                if (mo3340a.f2770a == 11) {
                                    this.f2543r = abstractC1681hz.mo3345a();
                                    break;
                                } else {
                                    C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                                    break;
                                }
                            default:
                                C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                                break;
                        }
                }
                abstractC1681hz.mo3369g();
            } else {
                abstractC1681hz.mo3368f();
                m3090a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m3090a();
        abstractC1681hz.mo3356a(f2488a);
        if (this.f2518a != null && m3092a()) {
            abstractC1681hz.mo3353a(f2487a);
            abstractC1681hz.mo3357a(this.f2518a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2517a != null && m3098b()) {
            abstractC1681hz.mo3353a(f2489b);
            this.f2517a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2524b != null) {
            abstractC1681hz.mo3353a(f2490c);
            abstractC1681hz.mo3357a(this.f2524b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2527c != null) {
            abstractC1681hz.mo3353a(f2491d);
            abstractC1681hz.mo3357a(this.f2527c);
            abstractC1681hz.mo3362b();
        }
        if (this.f2529d != null && m3109e()) {
            abstractC1681hz.mo3353a(f2492e);
            abstractC1681hz.mo3357a(this.f2529d);
            abstractC1681hz.mo3362b();
        }
        if (this.f2530e != null && m3112f()) {
            abstractC1681hz.mo3353a(f2493f);
            abstractC1681hz.mo3357a(this.f2530e);
            abstractC1681hz.mo3362b();
        }
        if (this.f2531f != null) {
            abstractC1681hz.mo3353a(f2494g);
            abstractC1681hz.mo3357a(this.f2531f);
            abstractC1681hz.mo3362b();
        }
        if (this.f2532g != null && m3118h()) {
            abstractC1681hz.mo3353a(f2495h);
            abstractC1681hz.mo3357a(this.f2532g);
            abstractC1681hz.mo3362b();
        }
        if (this.f2533h != null && m3120i()) {
            abstractC1681hz.mo3353a(f2496i);
            abstractC1681hz.mo3357a(this.f2533h);
            abstractC1681hz.mo3362b();
        }
        if (this.f2534i != null && m3121j()) {
            abstractC1681hz.mo3353a(f2497j);
            abstractC1681hz.mo3357a(this.f2534i);
            abstractC1681hz.mo3362b();
        }
        if (this.f2535j != null && m3122k()) {
            abstractC1681hz.mo3353a(f2498k);
            abstractC1681hz.mo3357a(this.f2535j);
            abstractC1681hz.mo3362b();
        }
        if (this.f2536k != null && m3123l()) {
            abstractC1681hz.mo3353a(f2499l);
            abstractC1681hz.mo3357a(this.f2536k);
            abstractC1681hz.mo3362b();
        }
        if (m3124m()) {
            abstractC1681hz.mo3353a(f2500m);
            abstractC1681hz.mo3351a(this.f2514a);
            abstractC1681hz.mo3362b();
        }
        if (m3125n()) {
            abstractC1681hz.mo3353a(f2501n);
            abstractC1681hz.mo3351a(this.f2522b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2537l != null && m3126o()) {
            abstractC1681hz.mo3353a(f2502o);
            abstractC1681hz.mo3357a(this.f2537l);
            abstractC1681hz.mo3362b();
        }
        if (this.f2538m != null && m3127p()) {
            abstractC1681hz.mo3353a(f2503p);
            abstractC1681hz.mo3357a(this.f2538m);
            abstractC1681hz.mo3362b();
        }
        if (this.f2539n != null && m3128q()) {
            abstractC1681hz.mo3353a(f2504q);
            abstractC1681hz.mo3357a(this.f2539n);
            abstractC1681hz.mo3362b();
        }
        if (this.f2540o != null && m3129r()) {
            abstractC1681hz.mo3353a(f2505r);
            abstractC1681hz.mo3357a(this.f2540o);
            abstractC1681hz.mo3362b();
        }
        if (m3130s()) {
            abstractC1681hz.mo3353a(f2506s);
            abstractC1681hz.mo3351a(this.f2526c);
            abstractC1681hz.mo3362b();
        }
        if (this.f2516a != null && m3131t()) {
            abstractC1681hz.mo3353a(f2507t);
            abstractC1681hz.mo3351a(this.f2516a.m2879a());
            abstractC1681hz.mo3362b();
        }
        if (m3132u()) {
            abstractC1681hz.mo3353a(f2508u);
            abstractC1681hz.mo3360a(this.f2521a);
            abstractC1681hz.mo3362b();
        }
        if (m3133v()) {
            abstractC1681hz.mo3353a(f2509v);
            abstractC1681hz.mo3352a(this.f2515a);
            abstractC1681hz.mo3362b();
        }
        if (m3134w()) {
            abstractC1681hz.mo3353a(f2510w);
            abstractC1681hz.mo3352a(this.f2523b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2541p != null && m3135x()) {
            abstractC1681hz.mo3353a(f2511x);
            abstractC1681hz.mo3357a(this.f2541p);
            abstractC1681hz.mo3362b();
        }
        if (this.f2542q != null && m3136y()) {
            abstractC1681hz.mo3353a(f2512y);
            abstractC1681hz.mo3357a(this.f2542q);
            abstractC1681hz.mo3362b();
        }
        if (m3137z()) {
            abstractC1681hz.mo3353a(f2513z);
            abstractC1681hz.mo3360a(this.f2525b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2520a != null && m3082A()) {
            abstractC1681hz.mo3353a(f2484A);
            abstractC1681hz.mo3355a(new C1680hy((byte) 11, (byte) 11, this.f2520a.size()));
            for (Map.Entry<String, String> entry : this.f2520a.entrySet()) {
                abstractC1681hz.mo3357a(entry.getKey());
                abstractC1681hz.mo3357a(entry.getValue());
            }
            abstractC1681hz.mo3366d();
            abstractC1681hz.mo3362b();
        }
        if (m3083B()) {
            abstractC1681hz.mo3353a(f2485B);
            abstractC1681hz.mo3360a(this.f2528c);
            abstractC1681hz.mo3362b();
        }
        if (this.f2543r != null && m3084C()) {
            abstractC1681hz.mo3353a(f2486C);
            abstractC1681hz.mo3357a(this.f2543r);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z2 = false;
        if (m3092a()) {
            sb.append("debug:");
            String str = this.f2518a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m3098b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1648gt c1648gt = this.f2517a;
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
        String str2 = this.f2524b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(C1752aj.m3693a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f2527c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (m3109e()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f2529d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m3112f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f2530e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f2531f;
        if (str6 == null) {
            sb.append("null");
        } else {
            sb.append(str6);
        }
        if (m3118h()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f2532g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (m3120i()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f2533h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m3121j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f2534i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (m3122k()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.f2535j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (m3123l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.f2536k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (m3124m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f2514a);
        }
        if (m3125n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f2522b);
        }
        if (m3126o()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.f2537l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (m3127p()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.f2538m;
            if (str13 == null) {
                sb.append("null");
            } else {
                sb.append(str13);
            }
        }
        if (m3128q()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.f2539n;
            if (str14 == null) {
                sb.append("null");
            } else {
                sb.append(str14);
            }
        }
        if (m3129r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.f2540o;
            if (str15 == null) {
                sb.append("null");
            } else {
                sb.append(str15);
            }
        }
        if (m3130s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f2526c);
        }
        if (m3131t()) {
            sb.append(", ");
            sb.append("reason:");
            EnumC1647gs enumC1647gs = this.f2516a;
            if (enumC1647gs == null) {
                sb.append("null");
            } else {
                sb.append(enumC1647gs);
            }
        }
        if (m3132u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f2521a);
        }
        if (m3133v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f2515a);
        }
        if (m3134w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f2523b);
        }
        if (m3135x()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.f2541p;
            if (str16 == null) {
                sb.append("null");
            } else {
                sb.append(str16);
            }
        }
        if (m3136y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.f2542q;
            if (str17 == null) {
                sb.append("null");
            } else {
                sb.append(str17);
            }
        }
        if (m3137z()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f2525b);
        }
        if (m3082A()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f2520a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (m3083B()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f2528c);
        }
        if (m3084C()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.f2543r;
            if (str18 == null) {
                sb.append("null");
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m3090a() {
        if (this.f2524b == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f2527c == null) {
            throw new C1683ia("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f2531f == null) {
            throw new C1683ia("Required field 'token' was not present! Struct: " + toString());
        }
    }
}
