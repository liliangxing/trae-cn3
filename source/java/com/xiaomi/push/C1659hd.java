package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.hd */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1659hd implements InterfaceC1671hp<C1659hd, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f2468a;

    /* renamed from: a */
    public C1648gt f2469a;

    /* renamed from: a */
    public String f2470a;

    /* renamed from: a */
    public ByteBuffer f2471a;

    /* renamed from: a */
    private BitSet f2472a;

    /* renamed from: a */
    public Map<String, String> f2473a;

    /* renamed from: a */
    public boolean f2474a;

    /* renamed from: b */
    public String f2475b;

    /* renamed from: b */
    public boolean f2476b;

    /* renamed from: c */
    public String f2477c;

    /* renamed from: d */
    public String f2478d;

    /* renamed from: e */
    public String f2479e;

    /* renamed from: f */
    public String f2480f;

    /* renamed from: g */
    public String f2481g;

    /* renamed from: h */
    public String f2482h;

    /* renamed from: i */
    public String f2483i;

    /* renamed from: a */
    private static final C1687ie f2453a = new C1687ie("XmPushActionNotification");

    /* renamed from: a */
    private static final C1678hw f2452a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f2454b = new C1678hw("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1678hw f2455c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2456d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2457e = new C1678hw("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1678hw f2458f = new C1678hw("", (byte) 2, 6);

    /* renamed from: g */
    private static final C1678hw f2459g = new C1678hw("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1678hw f2460h = new C1678hw("", (byte) 13, 8);

    /* renamed from: i */
    private static final C1678hw f2461i = new C1678hw("", (byte) 11, 9);

    /* renamed from: j */
    private static final C1678hw f2462j = new C1678hw("", (byte) 11, 10);

    /* renamed from: k */
    private static final C1678hw f2463k = new C1678hw("", (byte) 11, 12);

    /* renamed from: l */
    private static final C1678hw f2464l = new C1678hw("", (byte) 11, 13);

    /* renamed from: m */
    private static final C1678hw f2465m = new C1678hw("", (byte) 11, 14);

    /* renamed from: n */
    private static final C1678hw f2466n = new C1678hw("", (byte) 10, 15);

    /* renamed from: o */
    private static final C1678hw f2467o = new C1678hw("", (byte) 2, 20);

    public int hashCode() {
        return 0;
    }

    public C1659hd() {
        this.f2472a = new BitSet(3);
        this.f2474a = true;
        this.f2476b = false;
    }

    public C1659hd(String str, boolean z) {
        this();
        this.f2475b = str;
        this.f2474a = z;
        m3056a(true);
    }

    /* renamed from: a */
    public boolean m3057a() {
        return this.f2470a != null;
    }

    /* renamed from: a */
    public C1648gt m3046a() {
        return this.f2469a;
    }

    /* renamed from: b */
    public boolean m3063b() {
        return this.f2469a != null;
    }

    /* renamed from: a */
    public String m3052a() {
        return this.f2475b;
    }

    /* renamed from: a */
    public C1659hd m3047a(String str) {
        this.f2475b = str;
        return this;
    }

    /* renamed from: c */
    public boolean m3067c() {
        return this.f2475b != null;
    }

    /* renamed from: b */
    public String m3061b() {
        return this.f2477c;
    }

    /* renamed from: b */
    public C1659hd m3060b(String str) {
        this.f2477c = str;
        return this;
    }

    /* renamed from: d */
    public boolean m3070d() {
        return this.f2477c != null;
    }

    /* renamed from: c */
    public String m3065c() {
        return this.f2478d;
    }

    /* renamed from: c */
    public C1659hd m3064c(String str) {
        this.f2478d = str;
        return this;
    }

    /* renamed from: e */
    public boolean m3071e() {
        return this.f2478d != null;
    }

    /* renamed from: a */
    public C1659hd m3050a(boolean z) {
        this.f2474a = z;
        m3056a(true);
        return this;
    }

    /* renamed from: f */
    public boolean m3072f() {
        return this.f2472a.get(0);
    }

    /* renamed from: a */
    public void m3056a(boolean z) {
        this.f2472a.set(0, z);
    }

    /* renamed from: g */
    public boolean m3073g() {
        return this.f2479e != null;
    }

    /* renamed from: a */
    public void m3055a(String str, String str2) {
        if (this.f2473a == null) {
            this.f2473a = new HashMap();
        }
        this.f2473a.put(str, str2);
    }

    /* renamed from: a */
    public Map<String, String> m3053a() {
        return this.f2473a;
    }

    /* renamed from: a */
    public C1659hd m3049a(Map<String, String> map) {
        this.f2473a = map;
        return this;
    }

    /* renamed from: h */
    public boolean m3074h() {
        return this.f2473a != null;
    }

    /* renamed from: d */
    public String m3069d() {
        return this.f2480f;
    }

    /* renamed from: d */
    public C1659hd m3068d(String str) {
        this.f2480f = str;
        return this;
    }

    /* renamed from: i */
    public boolean m3075i() {
        return this.f2480f != null;
    }

    /* renamed from: j */
    public boolean m3076j() {
        return this.f2481g != null;
    }

    /* renamed from: k */
    public boolean m3077k() {
        return this.f2482h != null;
    }

    /* renamed from: l */
    public boolean m3078l() {
        return this.f2483i != null;
    }

    /* renamed from: a */
    public byte[] m3059a() {
        m3048a(C1672hq.m3327a(this.f2471a));
        return this.f2471a.array();
    }

    /* renamed from: a */
    public C1659hd m3051a(byte[] bArr) {
        m3048a(ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a */
    public C1659hd m3048a(ByteBuffer byteBuffer) {
        this.f2471a = byteBuffer;
        return this;
    }

    /* renamed from: m */
    public boolean m3079m() {
        return this.f2471a != null;
    }

    /* renamed from: n */
    public boolean m3080n() {
        return this.f2472a.get(1);
    }

    /* renamed from: b */
    public void m3062b(boolean z) {
        this.f2472a.set(1, z);
    }

    /* renamed from: o */
    public boolean m3081o() {
        return this.f2472a.get(2);
    }

    /* renamed from: c */
    public void m3066c(boolean z) {
        this.f2472a.set(2, z);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1659hd)) {
            return m3058a((C1659hd) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3058a(C1659hd c1659hd) {
        if (c1659hd == null) {
            return false;
        }
        boolean m3057a = m3057a();
        boolean m3057a2 = c1659hd.m3057a();
        if ((m3057a || m3057a2) && !(m3057a && m3057a2 && this.f2470a.equals(c1659hd.f2470a))) {
            return false;
        }
        boolean m3063b = m3063b();
        boolean m3063b2 = c1659hd.m3063b();
        if ((m3063b || m3063b2) && !(m3063b && m3063b2 && this.f2469a.m2884a(c1659hd.f2469a))) {
            return false;
        }
        boolean m3067c = m3067c();
        boolean m3067c2 = c1659hd.m3067c();
        if ((m3067c || m3067c2) && !(m3067c && m3067c2 && this.f2475b.equals(c1659hd.f2475b))) {
            return false;
        }
        boolean m3070d = m3070d();
        boolean m3070d2 = c1659hd.m3070d();
        if ((m3070d || m3070d2) && !(m3070d && m3070d2 && this.f2477c.equals(c1659hd.f2477c))) {
            return false;
        }
        boolean m3071e = m3071e();
        boolean m3071e2 = c1659hd.m3071e();
        if (((m3071e || m3071e2) && !(m3071e && m3071e2 && this.f2478d.equals(c1659hd.f2478d))) || this.f2474a != c1659hd.f2474a) {
            return false;
        }
        boolean m3073g = m3073g();
        boolean m3073g2 = c1659hd.m3073g();
        if ((m3073g || m3073g2) && !(m3073g && m3073g2 && this.f2479e.equals(c1659hd.f2479e))) {
            return false;
        }
        boolean m3074h = m3074h();
        boolean m3074h2 = c1659hd.m3074h();
        if ((m3074h || m3074h2) && !(m3074h && m3074h2 && this.f2473a.equals(c1659hd.f2473a))) {
            return false;
        }
        boolean m3075i = m3075i();
        boolean m3075i2 = c1659hd.m3075i();
        if ((m3075i || m3075i2) && !(m3075i && m3075i2 && this.f2480f.equals(c1659hd.f2480f))) {
            return false;
        }
        boolean m3076j = m3076j();
        boolean m3076j2 = c1659hd.m3076j();
        if ((m3076j || m3076j2) && !(m3076j && m3076j2 && this.f2481g.equals(c1659hd.f2481g))) {
            return false;
        }
        boolean m3077k = m3077k();
        boolean m3077k2 = c1659hd.m3077k();
        if ((m3077k || m3077k2) && !(m3077k && m3077k2 && this.f2482h.equals(c1659hd.f2482h))) {
            return false;
        }
        boolean m3078l = m3078l();
        boolean m3078l2 = c1659hd.m3078l();
        if ((m3078l || m3078l2) && !(m3078l && m3078l2 && this.f2483i.equals(c1659hd.f2483i))) {
            return false;
        }
        boolean m3079m = m3079m();
        boolean m3079m2 = c1659hd.m3079m();
        if ((m3079m || m3079m2) && !(m3079m && m3079m2 && this.f2471a.equals(c1659hd.f2471a))) {
            return false;
        }
        boolean m3080n = m3080n();
        boolean m3080n2 = c1659hd.m3080n();
        if ((m3080n || m3080n2) && !(m3080n && m3080n2 && this.f2468a == c1659hd.f2468a)) {
            return false;
        }
        boolean m3081o = m3081o();
        boolean m3081o2 = c1659hd.m3081o();
        if (m3081o || m3081o2) {
            return m3081o && m3081o2 && this.f2476b == c1659hd.f2476b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1659hd c1659hd) {
        int m3324a;
        int m3316a;
        int m3317a;
        int m3318a;
        int m3318a2;
        int m3318a3;
        int m3318a4;
        int m3321a;
        int m3318a5;
        int m3324a2;
        int m3318a6;
        int m3318a7;
        int m3318a8;
        int m3317a2;
        int m3318a9;
        if (!getClass().equals(c1659hd.getClass())) {
            return getClass().getName().compareTo(c1659hd.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3057a()).compareTo(Boolean.valueOf(c1659hd.m3057a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3057a() && (m3318a9 = C1672hq.m3318a(this.f2470a, c1659hd.f2470a)) != 0) {
            return m3318a9;
        }
        int compareTo2 = Boolean.valueOf(m3063b()).compareTo(Boolean.valueOf(c1659hd.m3063b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3063b() && (m3317a2 = C1672hq.m3317a(this.f2469a, c1659hd.f2469a)) != 0) {
            return m3317a2;
        }
        int compareTo3 = Boolean.valueOf(m3067c()).compareTo(Boolean.valueOf(c1659hd.m3067c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3067c() && (m3318a8 = C1672hq.m3318a(this.f2475b, c1659hd.f2475b)) != 0) {
            return m3318a8;
        }
        int compareTo4 = Boolean.valueOf(m3070d()).compareTo(Boolean.valueOf(c1659hd.m3070d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3070d() && (m3318a7 = C1672hq.m3318a(this.f2477c, c1659hd.f2477c)) != 0) {
            return m3318a7;
        }
        int compareTo5 = Boolean.valueOf(m3071e()).compareTo(Boolean.valueOf(c1659hd.m3071e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3071e() && (m3318a6 = C1672hq.m3318a(this.f2478d, c1659hd.f2478d)) != 0) {
            return m3318a6;
        }
        int compareTo6 = Boolean.valueOf(m3072f()).compareTo(Boolean.valueOf(c1659hd.m3072f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3072f() && (m3324a2 = C1672hq.m3324a(this.f2474a, c1659hd.f2474a)) != 0) {
            return m3324a2;
        }
        int compareTo7 = Boolean.valueOf(m3073g()).compareTo(Boolean.valueOf(c1659hd.m3073g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3073g() && (m3318a5 = C1672hq.m3318a(this.f2479e, c1659hd.f2479e)) != 0) {
            return m3318a5;
        }
        int compareTo8 = Boolean.valueOf(m3074h()).compareTo(Boolean.valueOf(c1659hd.m3074h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3074h() && (m3321a = C1672hq.m3321a(this.f2473a, c1659hd.f2473a)) != 0) {
            return m3321a;
        }
        int compareTo9 = Boolean.valueOf(m3075i()).compareTo(Boolean.valueOf(c1659hd.m3075i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3075i() && (m3318a4 = C1672hq.m3318a(this.f2480f, c1659hd.f2480f)) != 0) {
            return m3318a4;
        }
        int compareTo10 = Boolean.valueOf(m3076j()).compareTo(Boolean.valueOf(c1659hd.m3076j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3076j() && (m3318a3 = C1672hq.m3318a(this.f2481g, c1659hd.f2481g)) != 0) {
            return m3318a3;
        }
        int compareTo11 = Boolean.valueOf(m3077k()).compareTo(Boolean.valueOf(c1659hd.m3077k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m3077k() && (m3318a2 = C1672hq.m3318a(this.f2482h, c1659hd.f2482h)) != 0) {
            return m3318a2;
        }
        int compareTo12 = Boolean.valueOf(m3078l()).compareTo(Boolean.valueOf(c1659hd.m3078l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m3078l() && (m3318a = C1672hq.m3318a(this.f2483i, c1659hd.f2483i)) != 0) {
            return m3318a;
        }
        int compareTo13 = Boolean.valueOf(m3079m()).compareTo(Boolean.valueOf(c1659hd.m3079m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m3079m() && (m3317a = C1672hq.m3317a(this.f2471a, c1659hd.f2471a)) != 0) {
            return m3317a;
        }
        int compareTo14 = Boolean.valueOf(m3080n()).compareTo(Boolean.valueOf(c1659hd.m3080n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (m3080n() && (m3316a = C1672hq.m3316a(this.f2468a, c1659hd.f2468a)) != 0) {
            return m3316a;
        }
        int compareTo15 = Boolean.valueOf(m3081o()).compareTo(Boolean.valueOf(c1659hd.m3081o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (!m3081o() || (m3324a = C1672hq.m3324a(this.f2476b, c1659hd.f2476b)) == 0) {
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
                        if (mo3340a.f2770a == 11) {
                            this.f2470a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2469a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2475b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2477c = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 11) {
                            this.f2478d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                        if (mo3340a.f2770a == 2) {
                            this.f2474a = abstractC1681hz.mo3361a();
                            m3056a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f2479e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 13) {
                            C1680hy mo3342a = abstractC1681hz.mo3342a();
                            this.f2473a = new HashMap(mo3342a.f2776a * 2);
                            for (int i = 0; i < mo3342a.f2776a; i++) {
                                this.f2473a.put(abstractC1681hz.mo3345a(), abstractC1681hz.mo3345a());
                            }
                            abstractC1681hz.mo3370h();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 9:
                        if (mo3340a.f2770a == 11) {
                            this.f2480f = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 11) {
                            this.f2481g = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 11:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    default:
                        C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                        break;
                    case 12:
                        if (mo3340a.f2770a == 11) {
                            this.f2482h = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 13:
                        if (mo3340a.f2770a == 11) {
                            this.f2483i = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 14:
                        if (mo3340a.f2770a == 11) {
                            this.f2471a = abstractC1681hz.mo3347a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 15:
                        if (mo3340a.f2770a == 10) {
                            this.f2468a = abstractC1681hz.mo3339a();
                            m3062b(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 20:
                        if (mo3340a.f2770a == 2) {
                            this.f2476b = abstractC1681hz.mo3361a();
                            m3066c(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                }
                abstractC1681hz.mo3369g();
            } else {
                abstractC1681hz.mo3368f();
                if (!m3072f()) {
                    throw new C1683ia("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m3054a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m3054a();
        abstractC1681hz.mo3356a(f2453a);
        if (this.f2470a != null && m3057a()) {
            abstractC1681hz.mo3353a(f2452a);
            abstractC1681hz.mo3357a(this.f2470a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2469a != null && m3063b()) {
            abstractC1681hz.mo3353a(f2454b);
            this.f2469a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2475b != null) {
            abstractC1681hz.mo3353a(f2455c);
            abstractC1681hz.mo3357a(this.f2475b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2477c != null && m3070d()) {
            abstractC1681hz.mo3353a(f2456d);
            abstractC1681hz.mo3357a(this.f2477c);
            abstractC1681hz.mo3362b();
        }
        if (this.f2478d != null && m3071e()) {
            abstractC1681hz.mo3353a(f2457e);
            abstractC1681hz.mo3357a(this.f2478d);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3353a(f2458f);
        abstractC1681hz.mo3360a(this.f2474a);
        abstractC1681hz.mo3362b();
        if (this.f2479e != null && m3073g()) {
            abstractC1681hz.mo3353a(f2459g);
            abstractC1681hz.mo3357a(this.f2479e);
            abstractC1681hz.mo3362b();
        }
        if (this.f2473a != null && m3074h()) {
            abstractC1681hz.mo3353a(f2460h);
            abstractC1681hz.mo3355a(new C1680hy((byte) 11, (byte) 11, this.f2473a.size()));
            for (Map.Entry<String, String> entry : this.f2473a.entrySet()) {
                abstractC1681hz.mo3357a(entry.getKey());
                abstractC1681hz.mo3357a(entry.getValue());
            }
            abstractC1681hz.mo3366d();
            abstractC1681hz.mo3362b();
        }
        if (this.f2480f != null && m3075i()) {
            abstractC1681hz.mo3353a(f2461i);
            abstractC1681hz.mo3357a(this.f2480f);
            abstractC1681hz.mo3362b();
        }
        if (this.f2481g != null && m3076j()) {
            abstractC1681hz.mo3353a(f2462j);
            abstractC1681hz.mo3357a(this.f2481g);
            abstractC1681hz.mo3362b();
        }
        if (this.f2482h != null && m3077k()) {
            abstractC1681hz.mo3353a(f2463k);
            abstractC1681hz.mo3357a(this.f2482h);
            abstractC1681hz.mo3362b();
        }
        if (this.f2483i != null && m3078l()) {
            abstractC1681hz.mo3353a(f2464l);
            abstractC1681hz.mo3357a(this.f2483i);
            abstractC1681hz.mo3362b();
        }
        if (this.f2471a != null && m3079m()) {
            abstractC1681hz.mo3353a(f2465m);
            abstractC1681hz.mo3358a(this.f2471a);
            abstractC1681hz.mo3362b();
        }
        if (m3080n()) {
            abstractC1681hz.mo3353a(f2466n);
            abstractC1681hz.mo3352a(this.f2468a);
            abstractC1681hz.mo3362b();
        }
        if (m3081o()) {
            abstractC1681hz.mo3353a(f2467o);
            abstractC1681hz.mo3360a(this.f2476b);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = false;
        if (m3057a()) {
            sb.append("debug:");
            String str = this.f2470a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m3063b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1648gt c1648gt = this.f2469a;
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
        String str2 = this.f2475b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (m3070d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f2477c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (m3071e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f2478d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f2474a);
        if (m3073g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f2479e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m3074h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f2473a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (m3075i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f2480f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m3076j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f2481g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (m3077k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f2482h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m3078l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f2483i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (m3079m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f2471a;
            if (byteBuffer == null) {
                sb.append("null");
            } else {
                C1672hq.m3328a(byteBuffer, sb);
            }
        }
        if (m3080n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f2468a);
        }
        if (m3081o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f2476b);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m3054a() {
        if (this.f2475b == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
