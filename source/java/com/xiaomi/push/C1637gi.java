package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.gi */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1637gi implements InterfaceC1671hp<C1637gi, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f1976a;

    /* renamed from: a */
    public String f1977a;

    /* renamed from: a */
    private BitSet f1978a = new BitSet(3);

    /* renamed from: a */
    public Map<String, String> f1979a;

    /* renamed from: a */
    public boolean f1980a;

    /* renamed from: b */
    public long f1981b;

    /* renamed from: b */
    public String f1982b;

    /* renamed from: c */
    public String f1983c;

    /* renamed from: d */
    public String f1984d;

    /* renamed from: e */
    public String f1985e;

    /* renamed from: f */
    public String f1986f;

    /* renamed from: g */
    public String f1987g;

    /* renamed from: a */
    private static final C1687ie f1965a = new C1687ie("ClientUploadDataItem");

    /* renamed from: a */
    private static final C1678hw f1964a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f1966b = new C1678hw("", (byte) 11, 2);

    /* renamed from: c */
    private static final C1678hw f1967c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f1968d = new C1678hw("", (byte) 10, 4);

    /* renamed from: e */
    private static final C1678hw f1969e = new C1678hw("", (byte) 10, 5);

    /* renamed from: f */
    private static final C1678hw f1970f = new C1678hw("", (byte) 2, 6);

    /* renamed from: g */
    private static final C1678hw f1971g = new C1678hw("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1678hw f1972h = new C1678hw("", (byte) 11, 8);

    /* renamed from: i */
    private static final C1678hw f1973i = new C1678hw("", (byte) 11, 9);

    /* renamed from: j */
    private static final C1678hw f1974j = new C1678hw("", (byte) 13, 10);

    /* renamed from: k */
    private static final C1678hw f1975k = new C1678hw("", (byte) 11, 11);

    /* renamed from: a */
    public void m2732a() {
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public String m2730a() {
        return this.f1977a;
    }

    /* renamed from: a */
    public C1637gi m2727a(String str) {
        this.f1977a = str;
        return this;
    }

    /* renamed from: a */
    public boolean m2735a() {
        return this.f1977a != null;
    }

    /* renamed from: b */
    public C1637gi m2738b(String str) {
        this.f1982b = str;
        return this;
    }

    /* renamed from: b */
    public boolean m2741b() {
        return this.f1982b != null;
    }

    /* renamed from: b */
    public String m2739b() {
        return this.f1983c;
    }

    /* renamed from: c */
    public C1637gi m2742c(String str) {
        this.f1983c = str;
        return this;
    }

    /* renamed from: c */
    public boolean m2745c() {
        return this.f1983c != null;
    }

    /* renamed from: a */
    public C1637gi m2726a(long j) {
        this.f1976a = j;
        m2734a(true);
        return this;
    }

    /* renamed from: d */
    public boolean m2748d() {
        return this.f1978a.get(0);
    }

    /* renamed from: a */
    public void m2734a(boolean z) {
        this.f1978a.set(0, z);
    }

    /* renamed from: a */
    public long m2725a() {
        return this.f1981b;
    }

    /* renamed from: b */
    public C1637gi m2737b(long j) {
        this.f1981b = j;
        m2740b(true);
        return this;
    }

    /* renamed from: e */
    public boolean m2751e() {
        return this.f1978a.get(1);
    }

    /* renamed from: b */
    public void m2740b(boolean z) {
        this.f1978a.set(1, z);
    }

    /* renamed from: a */
    public C1637gi m2729a(boolean z) {
        this.f1980a = z;
        m2744c(true);
        return this;
    }

    /* renamed from: f */
    public boolean m2753f() {
        return this.f1978a.get(2);
    }

    /* renamed from: c */
    public void m2744c(boolean z) {
        this.f1978a.set(2, z);
    }

    /* renamed from: d */
    public C1637gi m2746d(String str) {
        this.f1984d = str;
        return this;
    }

    /* renamed from: g */
    public boolean m2755g() {
        return this.f1984d != null;
    }

    /* renamed from: c */
    public String m2743c() {
        return this.f1985e;
    }

    /* renamed from: e */
    public C1637gi m2749e(String str) {
        this.f1985e = str;
        return this;
    }

    /* renamed from: h */
    public boolean m2756h() {
        return this.f1985e != null;
    }

    /* renamed from: d */
    public String m2747d() {
        return this.f1986f;
    }

    /* renamed from: f */
    public C1637gi m2752f(String str) {
        this.f1986f = str;
        return this;
    }

    /* renamed from: i */
    public boolean m2757i() {
        return this.f1986f != null;
    }

    /* renamed from: a */
    public void m2733a(String str, String str2) {
        if (this.f1979a == null) {
            this.f1979a = new HashMap();
        }
        this.f1979a.put(str, str2);
    }

    /* renamed from: a */
    public Map<String, String> m2731a() {
        return this.f1979a;
    }

    /* renamed from: a */
    public C1637gi m2728a(Map<String, String> map) {
        this.f1979a = map;
        return this;
    }

    /* renamed from: j */
    public boolean m2758j() {
        return this.f1979a != null;
    }

    /* renamed from: e */
    public String m2750e() {
        return this.f1987g;
    }

    /* renamed from: g */
    public C1637gi m2754g(String str) {
        this.f1987g = str;
        return this;
    }

    /* renamed from: k */
    public boolean m2759k() {
        return this.f1987g != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1637gi)) {
            return m2736a((C1637gi) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2736a(C1637gi c1637gi) {
        if (c1637gi == null) {
            return false;
        }
        boolean m2735a = m2735a();
        boolean m2735a2 = c1637gi.m2735a();
        if ((m2735a || m2735a2) && !(m2735a && m2735a2 && this.f1977a.equals(c1637gi.f1977a))) {
            return false;
        }
        boolean m2741b = m2741b();
        boolean m2741b2 = c1637gi.m2741b();
        if ((m2741b || m2741b2) && !(m2741b && m2741b2 && this.f1982b.equals(c1637gi.f1982b))) {
            return false;
        }
        boolean m2745c = m2745c();
        boolean m2745c2 = c1637gi.m2745c();
        if ((m2745c || m2745c2) && !(m2745c && m2745c2 && this.f1983c.equals(c1637gi.f1983c))) {
            return false;
        }
        boolean m2748d = m2748d();
        boolean m2748d2 = c1637gi.m2748d();
        if ((m2748d || m2748d2) && !(m2748d && m2748d2 && this.f1976a == c1637gi.f1976a)) {
            return false;
        }
        boolean m2751e = m2751e();
        boolean m2751e2 = c1637gi.m2751e();
        if ((m2751e || m2751e2) && !(m2751e && m2751e2 && this.f1981b == c1637gi.f1981b)) {
            return false;
        }
        boolean m2753f = m2753f();
        boolean m2753f2 = c1637gi.m2753f();
        if ((m2753f || m2753f2) && !(m2753f && m2753f2 && this.f1980a == c1637gi.f1980a)) {
            return false;
        }
        boolean m2755g = m2755g();
        boolean m2755g2 = c1637gi.m2755g();
        if ((m2755g || m2755g2) && !(m2755g && m2755g2 && this.f1984d.equals(c1637gi.f1984d))) {
            return false;
        }
        boolean m2756h = m2756h();
        boolean m2756h2 = c1637gi.m2756h();
        if ((m2756h || m2756h2) && !(m2756h && m2756h2 && this.f1985e.equals(c1637gi.f1985e))) {
            return false;
        }
        boolean m2757i = m2757i();
        boolean m2757i2 = c1637gi.m2757i();
        if ((m2757i || m2757i2) && !(m2757i && m2757i2 && this.f1986f.equals(c1637gi.f1986f))) {
            return false;
        }
        boolean m2758j = m2758j();
        boolean m2758j2 = c1637gi.m2758j();
        if ((m2758j || m2758j2) && !(m2758j && m2758j2 && this.f1979a.equals(c1637gi.f1979a))) {
            return false;
        }
        boolean m2759k = m2759k();
        boolean m2759k2 = c1637gi.m2759k();
        if (m2759k || m2759k2) {
            return m2759k && m2759k2 && this.f1987g.equals(c1637gi.f1987g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1637gi c1637gi) {
        int m3318a;
        int m3321a;
        int m3318a2;
        int m3318a3;
        int m3318a4;
        int m3324a;
        int m3316a;
        int m3316a2;
        int m3318a5;
        int m3318a6;
        int m3318a7;
        if (!getClass().equals(c1637gi.getClass())) {
            return getClass().getName().compareTo(c1637gi.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2735a()).compareTo(Boolean.valueOf(c1637gi.m2735a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2735a() && (m3318a7 = C1672hq.m3318a(this.f1977a, c1637gi.f1977a)) != 0) {
            return m3318a7;
        }
        int compareTo2 = Boolean.valueOf(m2741b()).compareTo(Boolean.valueOf(c1637gi.m2741b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2741b() && (m3318a6 = C1672hq.m3318a(this.f1982b, c1637gi.f1982b)) != 0) {
            return m3318a6;
        }
        int compareTo3 = Boolean.valueOf(m2745c()).compareTo(Boolean.valueOf(c1637gi.m2745c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m2745c() && (m3318a5 = C1672hq.m3318a(this.f1983c, c1637gi.f1983c)) != 0) {
            return m3318a5;
        }
        int compareTo4 = Boolean.valueOf(m2748d()).compareTo(Boolean.valueOf(c1637gi.m2748d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m2748d() && (m3316a2 = C1672hq.m3316a(this.f1976a, c1637gi.f1976a)) != 0) {
            return m3316a2;
        }
        int compareTo5 = Boolean.valueOf(m2751e()).compareTo(Boolean.valueOf(c1637gi.m2751e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m2751e() && (m3316a = C1672hq.m3316a(this.f1981b, c1637gi.f1981b)) != 0) {
            return m3316a;
        }
        int compareTo6 = Boolean.valueOf(m2753f()).compareTo(Boolean.valueOf(c1637gi.m2753f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m2753f() && (m3324a = C1672hq.m3324a(this.f1980a, c1637gi.f1980a)) != 0) {
            return m3324a;
        }
        int compareTo7 = Boolean.valueOf(m2755g()).compareTo(Boolean.valueOf(c1637gi.m2755g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m2755g() && (m3318a4 = C1672hq.m3318a(this.f1984d, c1637gi.f1984d)) != 0) {
            return m3318a4;
        }
        int compareTo8 = Boolean.valueOf(m2756h()).compareTo(Boolean.valueOf(c1637gi.m2756h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m2756h() && (m3318a3 = C1672hq.m3318a(this.f1985e, c1637gi.f1985e)) != 0) {
            return m3318a3;
        }
        int compareTo9 = Boolean.valueOf(m2757i()).compareTo(Boolean.valueOf(c1637gi.m2757i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m2757i() && (m3318a2 = C1672hq.m3318a(this.f1986f, c1637gi.f1986f)) != 0) {
            return m3318a2;
        }
        int compareTo10 = Boolean.valueOf(m2758j()).compareTo(Boolean.valueOf(c1637gi.m2758j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m2758j() && (m3321a = C1672hq.m3321a(this.f1979a, c1637gi.f1979a)) != 0) {
            return m3321a;
        }
        int compareTo11 = Boolean.valueOf(m2759k()).compareTo(Boolean.valueOf(c1637gi.m2759k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!m2759k() || (m3318a = C1672hq.m3318a(this.f1987g, c1637gi.f1987g)) == 0) {
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
                            this.f1977a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 11) {
                            this.f1982b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f1983c = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 10) {
                            this.f1976a = abstractC1681hz.mo3339a();
                            m2734a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 10) {
                            this.f1981b = abstractC1681hz.mo3339a();
                            m2740b(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                        if (mo3340a.f2770a == 2) {
                            this.f1980a = abstractC1681hz.mo3361a();
                            m2744c(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f1984d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 11) {
                            this.f1985e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 9:
                        if (mo3340a.f2770a == 11) {
                            this.f1986f = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 13) {
                            C1680hy mo3342a = abstractC1681hz.mo3342a();
                            this.f1979a = new HashMap(mo3342a.f2776a * 2);
                            for (int i = 0; i < mo3342a.f2776a; i++) {
                                this.f1979a.put(abstractC1681hz.mo3345a(), abstractC1681hz.mo3345a());
                            }
                            abstractC1681hz.mo3370h();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 11:
                        if (mo3340a.f2770a == 11) {
                            this.f1987g = abstractC1681hz.mo3345a();
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
                m2732a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2732a();
        abstractC1681hz.mo3356a(f1965a);
        if (this.f1977a != null && m2735a()) {
            abstractC1681hz.mo3353a(f1964a);
            abstractC1681hz.mo3357a(this.f1977a);
            abstractC1681hz.mo3362b();
        }
        if (this.f1982b != null && m2741b()) {
            abstractC1681hz.mo3353a(f1966b);
            abstractC1681hz.mo3357a(this.f1982b);
            abstractC1681hz.mo3362b();
        }
        if (this.f1983c != null && m2745c()) {
            abstractC1681hz.mo3353a(f1967c);
            abstractC1681hz.mo3357a(this.f1983c);
            abstractC1681hz.mo3362b();
        }
        if (m2748d()) {
            abstractC1681hz.mo3353a(f1968d);
            abstractC1681hz.mo3352a(this.f1976a);
            abstractC1681hz.mo3362b();
        }
        if (m2751e()) {
            abstractC1681hz.mo3353a(f1969e);
            abstractC1681hz.mo3352a(this.f1981b);
            abstractC1681hz.mo3362b();
        }
        if (m2753f()) {
            abstractC1681hz.mo3353a(f1970f);
            abstractC1681hz.mo3360a(this.f1980a);
            abstractC1681hz.mo3362b();
        }
        if (this.f1984d != null && m2755g()) {
            abstractC1681hz.mo3353a(f1971g);
            abstractC1681hz.mo3357a(this.f1984d);
            abstractC1681hz.mo3362b();
        }
        if (this.f1985e != null && m2756h()) {
            abstractC1681hz.mo3353a(f1972h);
            abstractC1681hz.mo3357a(this.f1985e);
            abstractC1681hz.mo3362b();
        }
        if (this.f1986f != null && m2757i()) {
            abstractC1681hz.mo3353a(f1973i);
            abstractC1681hz.mo3357a(this.f1986f);
            abstractC1681hz.mo3362b();
        }
        if (this.f1979a != null && m2758j()) {
            abstractC1681hz.mo3353a(f1974j);
            abstractC1681hz.mo3355a(new C1680hy((byte) 11, (byte) 11, this.f1979a.size()));
            for (Map.Entry<String, String> entry : this.f1979a.entrySet()) {
                abstractC1681hz.mo3357a(entry.getKey());
                abstractC1681hz.mo3357a(entry.getValue());
            }
            abstractC1681hz.mo3366d();
            abstractC1681hz.mo3362b();
        }
        if (this.f1987g != null && m2759k()) {
            abstractC1681hz.mo3353a(f1975k);
            abstractC1681hz.mo3357a(this.f1987g);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = false;
        if (m2735a()) {
            sb.append("channel:");
            String str = this.f1977a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m2741b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.f1982b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (m2745c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f1983c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (m2748d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f1976a);
            z = false;
        }
        if (m2751e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f1981b);
            z = false;
        }
        if (m2753f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f1980a);
            z = false;
        }
        if (m2755g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f1984d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (m2756h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.f1985e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (m2757i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f1986f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (m2758j()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f1979a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        } else {
            z2 = z;
        }
        if (m2759k()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.f1987g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
