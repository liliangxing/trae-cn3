package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.gz */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1654gz implements InterfaceC1671hp<C1654gz, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f2416a;

    /* renamed from: a */
    public C1648gt f2417a;

    /* renamed from: a */
    public String f2418a;

    /* renamed from: a */
    public List<String> f2420a;

    /* renamed from: b */
    public String f2422b;

    /* renamed from: c */
    public String f2423c;

    /* renamed from: d */
    public String f2424d;

    /* renamed from: e */
    public String f2425e;

    /* renamed from: f */
    public String f2426f;

    /* renamed from: a */
    private static final C1687ie f2406a = new C1687ie("XmPushActionCommandResult");

    /* renamed from: a */
    private static final C1678hw f2405a = new C1678hw("", (byte) 12, 2);

    /* renamed from: b */
    private static final C1678hw f2407b = new C1678hw("", (byte) 11, 3);

    /* renamed from: c */
    private static final C1678hw f2408c = new C1678hw("", (byte) 11, 4);

    /* renamed from: d */
    private static final C1678hw f2409d = new C1678hw("", (byte) 11, 5);

    /* renamed from: e */
    private static final C1678hw f2410e = new C1678hw("", (byte) 10, 7);

    /* renamed from: f */
    private static final C1678hw f2411f = new C1678hw("", (byte) 11, 8);

    /* renamed from: g */
    private static final C1678hw f2412g = new C1678hw("", (byte) 11, 9);

    /* renamed from: h */
    private static final C1678hw f2413h = new C1678hw("", (byte) 15, 10);

    /* renamed from: i */
    private static final C1678hw f2414i = new C1678hw("", (byte) 11, 12);

    /* renamed from: j */
    private static final C1678hw f2415j = new C1678hw("", (byte) 2, 13);

    /* renamed from: a */
    private BitSet f2419a = new BitSet(2);

    /* renamed from: a */
    public boolean f2421a = true;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m2991a() {
        return this.f2417a != null;
    }

    /* renamed from: a */
    public String m2987a() {
        return this.f2418a;
    }

    /* renamed from: b */
    public boolean m2995b() {
        return this.f2418a != null;
    }

    /* renamed from: c */
    public boolean m2997c() {
        return this.f2422b != null;
    }

    /* renamed from: b */
    public String m2993b() {
        return this.f2423c;
    }

    /* renamed from: d */
    public boolean m2998d() {
        return this.f2423c != null;
    }

    /* renamed from: e */
    public boolean m2999e() {
        return this.f2419a.get(0);
    }

    /* renamed from: a */
    public void m2990a(boolean z) {
        this.f2419a.set(0, z);
    }

    /* renamed from: f */
    public boolean m3000f() {
        return this.f2424d != null;
    }

    /* renamed from: g */
    public boolean m3001g() {
        return this.f2425e != null;
    }

    /* renamed from: a */
    public List<String> m2988a() {
        return this.f2420a;
    }

    /* renamed from: h */
    public boolean m3002h() {
        return this.f2420a != null;
    }

    /* renamed from: c */
    public String m2996c() {
        return this.f2426f;
    }

    /* renamed from: i */
    public boolean m3003i() {
        return this.f2426f != null;
    }

    /* renamed from: j */
    public boolean m3004j() {
        return this.f2419a.get(1);
    }

    /* renamed from: b */
    public void m2994b(boolean z) {
        this.f2419a.set(1, z);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1654gz)) {
            return m2992a((C1654gz) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2992a(C1654gz c1654gz) {
        if (c1654gz == null) {
            return false;
        }
        boolean m2991a = m2991a();
        boolean m2991a2 = c1654gz.m2991a();
        if ((m2991a || m2991a2) && !(m2991a && m2991a2 && this.f2417a.m2884a(c1654gz.f2417a))) {
            return false;
        }
        boolean m2995b = m2995b();
        boolean m2995b2 = c1654gz.m2995b();
        if ((m2995b || m2995b2) && !(m2995b && m2995b2 && this.f2418a.equals(c1654gz.f2418a))) {
            return false;
        }
        boolean m2997c = m2997c();
        boolean m2997c2 = c1654gz.m2997c();
        if ((m2997c || m2997c2) && !(m2997c && m2997c2 && this.f2422b.equals(c1654gz.f2422b))) {
            return false;
        }
        boolean m2998d = m2998d();
        boolean m2998d2 = c1654gz.m2998d();
        if (((m2998d || m2998d2) && !(m2998d && m2998d2 && this.f2423c.equals(c1654gz.f2423c))) || this.f2416a != c1654gz.f2416a) {
            return false;
        }
        boolean m3000f = m3000f();
        boolean m3000f2 = c1654gz.m3000f();
        if ((m3000f || m3000f2) && !(m3000f && m3000f2 && this.f2424d.equals(c1654gz.f2424d))) {
            return false;
        }
        boolean m3001g = m3001g();
        boolean m3001g2 = c1654gz.m3001g();
        if ((m3001g || m3001g2) && !(m3001g && m3001g2 && this.f2425e.equals(c1654gz.f2425e))) {
            return false;
        }
        boolean m3002h = m3002h();
        boolean m3002h2 = c1654gz.m3002h();
        if ((m3002h || m3002h2) && !(m3002h && m3002h2 && this.f2420a.equals(c1654gz.f2420a))) {
            return false;
        }
        boolean m3003i = m3003i();
        boolean m3003i2 = c1654gz.m3003i();
        if ((m3003i || m3003i2) && !(m3003i && m3003i2 && this.f2426f.equals(c1654gz.f2426f))) {
            return false;
        }
        boolean m3004j = m3004j();
        boolean m3004j2 = c1654gz.m3004j();
        if (m3004j || m3004j2) {
            return m3004j && m3004j2 && this.f2421a == c1654gz.f2421a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1654gz c1654gz) {
        int m3324a;
        int m3318a;
        int m3320a;
        int m3318a2;
        int m3318a3;
        int m3316a;
        int m3318a4;
        int m3318a5;
        int m3318a6;
        int m3317a;
        if (!getClass().equals(c1654gz.getClass())) {
            return getClass().getName().compareTo(c1654gz.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2991a()).compareTo(Boolean.valueOf(c1654gz.m2991a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2991a() && (m3317a = C1672hq.m3317a(this.f2417a, c1654gz.f2417a)) != 0) {
            return m3317a;
        }
        int compareTo2 = Boolean.valueOf(m2995b()).compareTo(Boolean.valueOf(c1654gz.m2995b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2995b() && (m3318a6 = C1672hq.m3318a(this.f2418a, c1654gz.f2418a)) != 0) {
            return m3318a6;
        }
        int compareTo3 = Boolean.valueOf(m2997c()).compareTo(Boolean.valueOf(c1654gz.m2997c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m2997c() && (m3318a5 = C1672hq.m3318a(this.f2422b, c1654gz.f2422b)) != 0) {
            return m3318a5;
        }
        int compareTo4 = Boolean.valueOf(m2998d()).compareTo(Boolean.valueOf(c1654gz.m2998d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m2998d() && (m3318a4 = C1672hq.m3318a(this.f2423c, c1654gz.f2423c)) != 0) {
            return m3318a4;
        }
        int compareTo5 = Boolean.valueOf(m2999e()).compareTo(Boolean.valueOf(c1654gz.m2999e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m2999e() && (m3316a = C1672hq.m3316a(this.f2416a, c1654gz.f2416a)) != 0) {
            return m3316a;
        }
        int compareTo6 = Boolean.valueOf(m3000f()).compareTo(Boolean.valueOf(c1654gz.m3000f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3000f() && (m3318a3 = C1672hq.m3318a(this.f2424d, c1654gz.f2424d)) != 0) {
            return m3318a3;
        }
        int compareTo7 = Boolean.valueOf(m3001g()).compareTo(Boolean.valueOf(c1654gz.m3001g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3001g() && (m3318a2 = C1672hq.m3318a(this.f2425e, c1654gz.f2425e)) != 0) {
            return m3318a2;
        }
        int compareTo8 = Boolean.valueOf(m3002h()).compareTo(Boolean.valueOf(c1654gz.m3002h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3002h() && (m3320a = C1672hq.m3320a(this.f2420a, c1654gz.f2420a)) != 0) {
            return m3320a;
        }
        int compareTo9 = Boolean.valueOf(m3003i()).compareTo(Boolean.valueOf(c1654gz.m3003i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3003i() && (m3318a = C1672hq.m3318a(this.f2426f, c1654gz.f2426f)) != 0) {
            return m3318a;
        }
        int compareTo10 = Boolean.valueOf(m3004j()).compareTo(Boolean.valueOf(c1654gz.m3004j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!m3004j() || (m3324a = C1672hq.m3324a(this.f2421a, c1654gz.f2421a)) == 0) {
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
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2417a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2418a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2422b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 11) {
                            this.f2423c = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                    case 11:
                    default:
                        C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                        break;
                    case 7:
                        if (mo3340a.f2770a == 10) {
                            this.f2416a = abstractC1681hz.mo3339a();
                            m2990a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 11) {
                            this.f2424d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 9:
                        if (mo3340a.f2770a == 11) {
                            this.f2425e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 15) {
                            C1679hx mo3341a = abstractC1681hz.mo3341a();
                            this.f2420a = new ArrayList(mo3341a.f2774a);
                            for (int i = 0; i < mo3341a.f2774a; i++) {
                                this.f2420a.add(abstractC1681hz.mo3345a());
                            }
                            abstractC1681hz.mo3371i();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 12:
                        if (mo3340a.f2770a == 11) {
                            this.f2426f = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 13:
                        if (mo3340a.f2770a == 2) {
                            this.f2421a = abstractC1681hz.mo3361a();
                            m2994b(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                }
                abstractC1681hz.mo3369g();
            } else {
                abstractC1681hz.mo3368f();
                if (!m2999e()) {
                    throw new C1683ia("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m2989a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m2989a();
        abstractC1681hz.mo3356a(f2406a);
        if (this.f2417a != null && m2991a()) {
            abstractC1681hz.mo3353a(f2405a);
            this.f2417a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2418a != null) {
            abstractC1681hz.mo3353a(f2407b);
            abstractC1681hz.mo3357a(this.f2418a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2422b != null) {
            abstractC1681hz.mo3353a(f2408c);
            abstractC1681hz.mo3357a(this.f2422b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2423c != null) {
            abstractC1681hz.mo3353a(f2409d);
            abstractC1681hz.mo3357a(this.f2423c);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3353a(f2410e);
        abstractC1681hz.mo3352a(this.f2416a);
        abstractC1681hz.mo3362b();
        if (this.f2424d != null && m3000f()) {
            abstractC1681hz.mo3353a(f2411f);
            abstractC1681hz.mo3357a(this.f2424d);
            abstractC1681hz.mo3362b();
        }
        if (this.f2425e != null && m3001g()) {
            abstractC1681hz.mo3353a(f2412g);
            abstractC1681hz.mo3357a(this.f2425e);
            abstractC1681hz.mo3362b();
        }
        if (this.f2420a != null && m3002h()) {
            abstractC1681hz.mo3353a(f2413h);
            abstractC1681hz.mo3354a(new C1679hx((byte) 11, this.f2420a.size()));
            Iterator<String> it = this.f2420a.iterator();
            while (it.hasNext()) {
                abstractC1681hz.mo3357a(it.next());
            }
            abstractC1681hz.mo3367e();
            abstractC1681hz.mo3362b();
        }
        if (this.f2426f != null && m3003i()) {
            abstractC1681hz.mo3353a(f2414i);
            abstractC1681hz.mo3357a(this.f2426f);
            abstractC1681hz.mo3362b();
        }
        if (m3004j()) {
            abstractC1681hz.mo3353a(f2415j);
            abstractC1681hz.mo3360a(this.f2421a);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m2991a()) {
            sb.append("target:");
            C1648gt c1648gt = this.f2417a;
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
        String str = this.f2418a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f2422b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f2423c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f2416a);
        if (m3000f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f2424d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m3001g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f2425e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m3002h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f2420a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m3003i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f2426f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m3004j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f2421a);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m2989a() {
        if (this.f2418a == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f2422b == null) {
            throw new C1683ia("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f2423c == null) {
            throw new C1683ia("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }
}
