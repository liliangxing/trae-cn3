package com.xiaomi.push;

import com.xiaomi.push.service.C1752aj;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.gr */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1646gr implements InterfaceC1671hp<C1646gr, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public int f2277a;

    /* renamed from: a */
    public long f2278a;

    /* renamed from: a */
    public String f2279a;

    /* renamed from: a */
    private BitSet f2280a;

    /* renamed from: a */
    public Map<String, String> f2281a;

    /* renamed from: a */
    public boolean f2282a;

    /* renamed from: b */
    public int f2283b;

    /* renamed from: b */
    public String f2284b;

    /* renamed from: b */
    public Map<String, String> f2285b;

    /* renamed from: c */
    public int f2286c;

    /* renamed from: c */
    public String f2287c;

    /* renamed from: c */
    public Map<String, String> f2288c;

    /* renamed from: d */
    public String f2289d;

    /* renamed from: e */
    public String f2290e;

    /* renamed from: a */
    private static final C1687ie f2264a = new C1687ie("PushMetaInfo");

    /* renamed from: a */
    private static final C1678hw f2263a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f2265b = new C1678hw("", (byte) 10, 2);

    /* renamed from: c */
    private static final C1678hw f2266c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2267d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2268e = new C1678hw("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1678hw f2269f = new C1678hw("", (byte) 8, 6);

    /* renamed from: g */
    private static final C1678hw f2270g = new C1678hw("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1678hw f2271h = new C1678hw("", (byte) 8, 8);

    /* renamed from: i */
    private static final C1678hw f2272i = new C1678hw("", (byte) 8, 9);

    /* renamed from: j */
    private static final C1678hw f2273j = new C1678hw("", (byte) 13, 10);

    /* renamed from: k */
    private static final C1678hw f2274k = new C1678hw("", (byte) 13, 11);

    /* renamed from: l */
    private static final C1678hw f2275l = new C1678hw("", (byte) 2, 12);

    /* renamed from: m */
    private static final C1678hw f2276m = new C1678hw("", (byte) 13, 13);

    public int hashCode() {
        return 0;
    }

    public C1646gr() {
        this.f2280a = new BitSet(5);
        this.f2282a = false;
    }

    public C1646gr(C1646gr c1646gr) {
        BitSet bitSet = new BitSet(5);
        this.f2280a = bitSet;
        bitSet.clear();
        this.f2280a.or(c1646gr.f2280a);
        if (c1646gr.m2847a()) {
            this.f2279a = c1646gr.f2279a;
        }
        this.f2278a = c1646gr.f2278a;
        if (c1646gr.m2862c()) {
            this.f2284b = c1646gr.f2284b;
        }
        if (c1646gr.m2866d()) {
            this.f2287c = c1646gr.f2287c;
        }
        if (c1646gr.m2868e()) {
            this.f2289d = c1646gr.f2289d;
        }
        this.f2277a = c1646gr.f2277a;
        if (c1646gr.m2870g()) {
            this.f2290e = c1646gr.f2290e;
        }
        this.f2283b = c1646gr.f2283b;
        this.f2286c = c1646gr.f2286c;
        if (c1646gr.m2873j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : c1646gr.f2281a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f2281a = hashMap;
        }
        if (c1646gr.m2874k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : c1646gr.f2285b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f2285b = hashMap2;
        }
        this.f2282a = c1646gr.f2282a;
        if (c1646gr.m2877n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : c1646gr.f2288c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f2288c = hashMap3;
        }
    }

    /* renamed from: a */
    public C1646gr m2838a() {
        return new C1646gr(this);
    }

    /* renamed from: a */
    public String m2842a() {
        return this.f2279a;
    }

    /* renamed from: a */
    public C1646gr m2840a(String str) {
        this.f2279a = str;
        return this;
    }

    /* renamed from: a */
    public boolean m2847a() {
        return this.f2279a != null;
    }

    /* renamed from: a */
    public long m2837a() {
        return this.f2278a;
    }

    /* renamed from: b */
    public boolean m2856b() {
        return this.f2280a.get(0);
    }

    /* renamed from: a */
    public void m2846a(boolean z) {
        this.f2280a.set(0, z);
    }

    /* renamed from: b */
    public String m2852b() {
        return this.f2284b;
    }

    /* renamed from: b */
    public C1646gr m2851b(String str) {
        this.f2284b = str;
        return this;
    }

    /* renamed from: c */
    public boolean m2862c() {
        return this.f2284b != null;
    }

    /* renamed from: c */
    public String m2860c() {
        return this.f2287c;
    }

    /* renamed from: c */
    public C1646gr m2859c(String str) {
        this.f2287c = str;
        return this;
    }

    /* renamed from: d */
    public boolean m2866d() {
        return this.f2287c != null;
    }

    /* renamed from: d */
    public String m2864d() {
        return this.f2289d;
    }

    /* renamed from: d */
    public C1646gr m2863d(String str) {
        this.f2289d = str;
        return this;
    }

    /* renamed from: e */
    public boolean m2868e() {
        return this.f2289d != null;
    }

    /* renamed from: a */
    public int m2835a() {
        return this.f2277a;
    }

    /* renamed from: a */
    public C1646gr m2839a(int i) {
        this.f2277a = i;
        m2855b(true);
        return this;
    }

    /* renamed from: f */
    public boolean m2869f() {
        return this.f2280a.get(1);
    }

    /* renamed from: b */
    public void m2855b(boolean z) {
        this.f2280a.set(1, z);
    }

    /* renamed from: g */
    public boolean m2870g() {
        return this.f2290e != null;
    }

    /* renamed from: b */
    public int m2849b() {
        return this.f2283b;
    }

    /* renamed from: b */
    public C1646gr m2850b(int i) {
        this.f2283b = i;
        m2861c(true);
        return this;
    }

    /* renamed from: h */
    public boolean m2871h() {
        return this.f2280a.get(2);
    }

    /* renamed from: c */
    public void m2861c(boolean z) {
        this.f2280a.set(2, z);
    }

    /* renamed from: c */
    public int m2857c() {
        return this.f2286c;
    }

    /* renamed from: c */
    public C1646gr m2858c(int i) {
        this.f2286c = i;
        m2865d(true);
        return this;
    }

    /* renamed from: i */
    public boolean m2872i() {
        return this.f2280a.get(3);
    }

    /* renamed from: d */
    public void m2865d(boolean z) {
        this.f2280a.set(3, z);
    }

    /* renamed from: a */
    public void m2845a(String str, String str2) {
        if (this.f2281a == null) {
            this.f2281a = new HashMap();
        }
        this.f2281a.put(str, str2);
    }

    /* renamed from: a */
    public Map<String, String> m2843a() {
        return this.f2281a;
    }

    /* renamed from: a */
    public C1646gr m2841a(Map<String, String> map) {
        this.f2281a = map;
        return this;
    }

    /* renamed from: j */
    public boolean m2873j() {
        return this.f2281a != null;
    }

    /* renamed from: b */
    public void m2854b(String str, String str2) {
        if (this.f2285b == null) {
            this.f2285b = new HashMap();
        }
        this.f2285b.put(str, str2);
    }

    /* renamed from: b */
    public Map<String, String> m2853b() {
        return this.f2285b;
    }

    /* renamed from: k */
    public boolean m2874k() {
        return this.f2285b != null;
    }

    /* renamed from: l */
    public boolean m2875l() {
        return this.f2282a;
    }

    /* renamed from: m */
    public boolean m2876m() {
        return this.f2280a.get(4);
    }

    /* renamed from: e */
    public void m2867e(boolean z) {
        this.f2280a.set(4, z);
    }

    /* renamed from: n */
    public boolean m2877n() {
        return this.f2288c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1646gr)) {
            return m2848a((C1646gr) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2848a(C1646gr c1646gr) {
        if (c1646gr == null) {
            return false;
        }
        boolean m2847a = m2847a();
        boolean m2847a2 = c1646gr.m2847a();
        if (((m2847a || m2847a2) && !(m2847a && m2847a2 && this.f2279a.equals(c1646gr.f2279a))) || this.f2278a != c1646gr.f2278a) {
            return false;
        }
        boolean m2862c = m2862c();
        boolean m2862c2 = c1646gr.m2862c();
        if ((m2862c || m2862c2) && !(m2862c && m2862c2 && this.f2284b.equals(c1646gr.f2284b))) {
            return false;
        }
        boolean m2866d = m2866d();
        boolean m2866d2 = c1646gr.m2866d();
        if ((m2866d || m2866d2) && !(m2866d && m2866d2 && this.f2287c.equals(c1646gr.f2287c))) {
            return false;
        }
        boolean m2868e = m2868e();
        boolean m2868e2 = c1646gr.m2868e();
        if ((m2868e || m2868e2) && !(m2868e && m2868e2 && this.f2289d.equals(c1646gr.f2289d))) {
            return false;
        }
        boolean m2869f = m2869f();
        boolean m2869f2 = c1646gr.m2869f();
        if ((m2869f || m2869f2) && !(m2869f && m2869f2 && this.f2277a == c1646gr.f2277a)) {
            return false;
        }
        boolean m2870g = m2870g();
        boolean m2870g2 = c1646gr.m2870g();
        if ((m2870g || m2870g2) && !(m2870g && m2870g2 && this.f2290e.equals(c1646gr.f2290e))) {
            return false;
        }
        boolean m2871h = m2871h();
        boolean m2871h2 = c1646gr.m2871h();
        if ((m2871h || m2871h2) && !(m2871h && m2871h2 && this.f2283b == c1646gr.f2283b)) {
            return false;
        }
        boolean m2872i = m2872i();
        boolean m2872i2 = c1646gr.m2872i();
        if ((m2872i || m2872i2) && !(m2872i && m2872i2 && this.f2286c == c1646gr.f2286c)) {
            return false;
        }
        boolean m2873j = m2873j();
        boolean m2873j2 = c1646gr.m2873j();
        if ((m2873j || m2873j2) && !(m2873j && m2873j2 && this.f2281a.equals(c1646gr.f2281a))) {
            return false;
        }
        boolean m2874k = m2874k();
        boolean m2874k2 = c1646gr.m2874k();
        if ((m2874k || m2874k2) && !(m2874k && m2874k2 && this.f2285b.equals(c1646gr.f2285b))) {
            return false;
        }
        boolean m2876m = m2876m();
        boolean m2876m2 = c1646gr.m2876m();
        if ((m2876m || m2876m2) && !(m2876m && m2876m2 && this.f2282a == c1646gr.f2282a)) {
            return false;
        }
        boolean m2877n = m2877n();
        boolean m2877n2 = c1646gr.m2877n();
        if (m2877n || m2877n2) {
            return m2877n && m2877n2 && this.f2288c.equals(c1646gr.f2288c);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1646gr c1646gr) {
        int m3321a;
        int m3324a;
        int m3321a2;
        int m3321a3;
        int m3315a;
        int m3315a2;
        int m3318a;
        int m3315a3;
        int m3318a2;
        int m3318a3;
        int m3318a4;
        int m3316a;
        int m3318a5;
        if (!getClass().equals(c1646gr.getClass())) {
            return getClass().getName().compareTo(c1646gr.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2847a()).compareTo(Boolean.valueOf(c1646gr.m2847a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2847a() && (m3318a5 = C1672hq.m3318a(this.f2279a, c1646gr.f2279a)) != 0) {
            return m3318a5;
        }
        int compareTo2 = Boolean.valueOf(m2856b()).compareTo(Boolean.valueOf(c1646gr.m2856b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2856b() && (m3316a = C1672hq.m3316a(this.f2278a, c1646gr.f2278a)) != 0) {
            return m3316a;
        }
        int compareTo3 = Boolean.valueOf(m2862c()).compareTo(Boolean.valueOf(c1646gr.m2862c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m2862c() && (m3318a4 = C1672hq.m3318a(this.f2284b, c1646gr.f2284b)) != 0) {
            return m3318a4;
        }
        int compareTo4 = Boolean.valueOf(m2866d()).compareTo(Boolean.valueOf(c1646gr.m2866d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m2866d() && (m3318a3 = C1672hq.m3318a(this.f2287c, c1646gr.f2287c)) != 0) {
            return m3318a3;
        }
        int compareTo5 = Boolean.valueOf(m2868e()).compareTo(Boolean.valueOf(c1646gr.m2868e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m2868e() && (m3318a2 = C1672hq.m3318a(this.f2289d, c1646gr.f2289d)) != 0) {
            return m3318a2;
        }
        int compareTo6 = Boolean.valueOf(m2869f()).compareTo(Boolean.valueOf(c1646gr.m2869f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m2869f() && (m3315a3 = C1672hq.m3315a(this.f2277a, c1646gr.f2277a)) != 0) {
            return m3315a3;
        }
        int compareTo7 = Boolean.valueOf(m2870g()).compareTo(Boolean.valueOf(c1646gr.m2870g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m2870g() && (m3318a = C1672hq.m3318a(this.f2290e, c1646gr.f2290e)) != 0) {
            return m3318a;
        }
        int compareTo8 = Boolean.valueOf(m2871h()).compareTo(Boolean.valueOf(c1646gr.m2871h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m2871h() && (m3315a2 = C1672hq.m3315a(this.f2283b, c1646gr.f2283b)) != 0) {
            return m3315a2;
        }
        int compareTo9 = Boolean.valueOf(m2872i()).compareTo(Boolean.valueOf(c1646gr.m2872i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m2872i() && (m3315a = C1672hq.m3315a(this.f2286c, c1646gr.f2286c)) != 0) {
            return m3315a;
        }
        int compareTo10 = Boolean.valueOf(m2873j()).compareTo(Boolean.valueOf(c1646gr.m2873j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m2873j() && (m3321a3 = C1672hq.m3321a(this.f2281a, c1646gr.f2281a)) != 0) {
            return m3321a3;
        }
        int compareTo11 = Boolean.valueOf(m2874k()).compareTo(Boolean.valueOf(c1646gr.m2874k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m2874k() && (m3321a2 = C1672hq.m3321a(this.f2285b, c1646gr.f2285b)) != 0) {
            return m3321a2;
        }
        int compareTo12 = Boolean.valueOf(m2876m()).compareTo(Boolean.valueOf(c1646gr.m2876m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m2876m() && (m3324a = C1672hq.m3324a(this.f2282a, c1646gr.f2282a)) != 0) {
            return m3324a;
        }
        int compareTo13 = Boolean.valueOf(m2877n()).compareTo(Boolean.valueOf(c1646gr.m2877n()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (!m2877n() || (m3321a = C1672hq.m3321a(this.f2288c, c1646gr.f2288c)) == 0) {
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
                int i = 0;
                switch (mo3340a.f2772a) {
                    case 1:
                        if (mo3340a.f2770a == 11) {
                            this.f2279a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 10) {
                            this.f2278a = abstractC1681hz.mo3339a();
                            m2846a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2284b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2287c = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 11) {
                            this.f2289d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                        if (mo3340a.f2770a == 8) {
                            this.f2277a = abstractC1681hz.mo3338a();
                            m2855b(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f2290e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 8) {
                            this.f2283b = abstractC1681hz.mo3338a();
                            m2861c(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 9:
                        if (mo3340a.f2770a == 8) {
                            this.f2286c = abstractC1681hz.mo3338a();
                            m2865d(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 13) {
                            C1680hy mo3342a = abstractC1681hz.mo3342a();
                            this.f2281a = new HashMap(mo3342a.f2776a * 2);
                            while (i < mo3342a.f2776a) {
                                this.f2281a.put(abstractC1681hz.mo3345a(), abstractC1681hz.mo3345a());
                                i++;
                            }
                            abstractC1681hz.mo3370h();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 11:
                        if (mo3340a.f2770a == 13) {
                            C1680hy mo3342a2 = abstractC1681hz.mo3342a();
                            this.f2285b = new HashMap(mo3342a2.f2776a * 2);
                            while (i < mo3342a2.f2776a) {
                                this.f2285b.put(abstractC1681hz.mo3345a(), abstractC1681hz.mo3345a());
                                i++;
                            }
                            abstractC1681hz.mo3370h();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 12:
                        if (mo3340a.f2770a == 2) {
                            this.f2282a = abstractC1681hz.mo3361a();
                            m2867e(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 13:
                        if (mo3340a.f2770a == 13) {
                            C1680hy mo3342a3 = abstractC1681hz.mo3342a();
                            this.f2288c = new HashMap(mo3342a3.f2776a * 2);
                            while (i < mo3342a3.f2776a) {
                                this.f2288c.put(abstractC1681hz.mo3345a(), abstractC1681hz.mo3345a());
                                i++;
                            }
                            abstractC1681hz.mo3370h();
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
                if (!m2856b()) {
                    throw new C1683ia("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m2844a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2844a();
        abstractC1681hz.mo3356a(f2264a);
        if (this.f2279a != null) {
            abstractC1681hz.mo3353a(f2263a);
            abstractC1681hz.mo3357a(this.f2279a);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3353a(f2265b);
        abstractC1681hz.mo3352a(this.f2278a);
        abstractC1681hz.mo3362b();
        if (this.f2284b != null && m2862c()) {
            abstractC1681hz.mo3353a(f2266c);
            abstractC1681hz.mo3357a(this.f2284b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2287c != null && m2866d()) {
            abstractC1681hz.mo3353a(f2267d);
            abstractC1681hz.mo3357a(this.f2287c);
            abstractC1681hz.mo3362b();
        }
        if (this.f2289d != null && m2868e()) {
            abstractC1681hz.mo3353a(f2268e);
            abstractC1681hz.mo3357a(this.f2289d);
            abstractC1681hz.mo3362b();
        }
        if (m2869f()) {
            abstractC1681hz.mo3353a(f2269f);
            abstractC1681hz.mo3351a(this.f2277a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2290e != null && m2870g()) {
            abstractC1681hz.mo3353a(f2270g);
            abstractC1681hz.mo3357a(this.f2290e);
            abstractC1681hz.mo3362b();
        }
        if (m2871h()) {
            abstractC1681hz.mo3353a(f2271h);
            abstractC1681hz.mo3351a(this.f2283b);
            abstractC1681hz.mo3362b();
        }
        if (m2872i()) {
            abstractC1681hz.mo3353a(f2272i);
            abstractC1681hz.mo3351a(this.f2286c);
            abstractC1681hz.mo3362b();
        }
        if (this.f2281a != null && m2873j()) {
            abstractC1681hz.mo3353a(f2273j);
            abstractC1681hz.mo3355a(new C1680hy((byte) 11, (byte) 11, this.f2281a.size()));
            for (Map.Entry<String, String> entry : this.f2281a.entrySet()) {
                abstractC1681hz.mo3357a(entry.getKey());
                abstractC1681hz.mo3357a(entry.getValue());
            }
            abstractC1681hz.mo3366d();
            abstractC1681hz.mo3362b();
        }
        if (this.f2285b != null && m2874k()) {
            abstractC1681hz.mo3353a(f2274k);
            abstractC1681hz.mo3355a(new C1680hy((byte) 11, (byte) 11, this.f2285b.size()));
            for (Map.Entry<String, String> entry2 : this.f2285b.entrySet()) {
                abstractC1681hz.mo3357a(entry2.getKey());
                abstractC1681hz.mo3357a(entry2.getValue());
            }
            abstractC1681hz.mo3366d();
            abstractC1681hz.mo3362b();
        }
        if (m2876m()) {
            abstractC1681hz.mo3353a(f2275l);
            abstractC1681hz.mo3360a(this.f2282a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2288c != null && m2877n()) {
            abstractC1681hz.mo3353a(f2276m);
            abstractC1681hz.mo3355a(new C1680hy((byte) 11, (byte) 11, this.f2288c.size()));
            for (Map.Entry<String, String> entry3 : this.f2288c.entrySet()) {
                abstractC1681hz.mo3357a(entry3.getKey());
                abstractC1681hz.mo3357a(entry3.getValue());
            }
            abstractC1681hz.mo3366d();
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(id:");
        String str = this.f2279a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(C1752aj.m3693a(str));
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f2278a);
        if (m2862c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f2284b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (m2866d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f2287c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (m2868e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f2289d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m2869f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f2277a);
        }
        if (m2870g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f2290e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m2871h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f2283b);
        }
        if (m2872i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f2286c);
        }
        if (m2873j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f2281a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (m2874k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f2285b;
            if (map2 == null) {
                sb.append("null");
            } else {
                sb.append(map2);
            }
        }
        if (m2876m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f2282a);
        }
        if (m2877n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f2288c;
            if (map3 == null) {
                sb.append("null");
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m2844a() {
        if (this.f2279a == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
