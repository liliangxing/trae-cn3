package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.hh */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1663hh implements InterfaceC1671hp<C1663hh, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public C1645gq f2615a;

    /* renamed from: a */
    public C1648gt f2616a;

    /* renamed from: a */
    public String f2617a;

    /* renamed from: a */
    public Map<String, String> f2619a;

    /* renamed from: b */
    public String f2621b;

    /* renamed from: c */
    public String f2622c;

    /* renamed from: d */
    public String f2623d;

    /* renamed from: e */
    public String f2624e;

    /* renamed from: f */
    public String f2625f;

    /* renamed from: g */
    public String f2626g;

    /* renamed from: h */
    public String f2627h;

    /* renamed from: a */
    private static final C1687ie f2603a = new C1687ie("XmPushActionSendMessage");

    /* renamed from: a */
    private static final C1678hw f2602a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f2604b = new C1678hw("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1678hw f2605c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2606d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2607e = new C1678hw("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1678hw f2608f = new C1678hw("", (byte) 11, 6);

    /* renamed from: g */
    private static final C1678hw f2609g = new C1678hw("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1678hw f2610h = new C1678hw("", (byte) 12, 8);

    /* renamed from: i */
    private static final C1678hw f2611i = new C1678hw("", (byte) 2, 9);

    /* renamed from: j */
    private static final C1678hw f2612j = new C1678hw("", (byte) 13, 10);

    /* renamed from: k */
    private static final C1678hw f2613k = new C1678hw("", (byte) 11, 11);

    /* renamed from: l */
    private static final C1678hw f2614l = new C1678hw("", (byte) 11, 12);

    /* renamed from: a */
    private BitSet f2618a = new BitSet(1);

    /* renamed from: a */
    public boolean f2620a = true;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m3188a() {
        return this.f2617a != null;
    }

    /* renamed from: b */
    public boolean m3191b() {
        return this.f2616a != null;
    }

    /* renamed from: a */
    public String m3185a() {
        return this.f2621b;
    }

    /* renamed from: c */
    public boolean m3193c() {
        return this.f2621b != null;
    }

    /* renamed from: b */
    public String m3190b() {
        return this.f2622c;
    }

    /* renamed from: d */
    public boolean m3195d() {
        return this.f2622c != null;
    }

    /* renamed from: e */
    public boolean m3197e() {
        return this.f2623d != null;
    }

    /* renamed from: c */
    public String m3192c() {
        return this.f2624e;
    }

    /* renamed from: f */
    public boolean m3199f() {
        return this.f2624e != null;
    }

    /* renamed from: d */
    public String m3194d() {
        return this.f2625f;
    }

    /* renamed from: g */
    public boolean m3200g() {
        return this.f2625f != null;
    }

    /* renamed from: a */
    public C1645gq m3184a() {
        return this.f2615a;
    }

    /* renamed from: h */
    public boolean m3201h() {
        return this.f2615a != null;
    }

    /* renamed from: i */
    public boolean m3202i() {
        return this.f2618a.get(0);
    }

    /* renamed from: a */
    public void m3187a(boolean z) {
        this.f2618a.set(0, z);
    }

    /* renamed from: j */
    public boolean m3203j() {
        return this.f2619a != null;
    }

    /* renamed from: e */
    public String m3196e() {
        return this.f2626g;
    }

    /* renamed from: k */
    public boolean m3204k() {
        return this.f2626g != null;
    }

    /* renamed from: f */
    public String m3198f() {
        return this.f2627h;
    }

    /* renamed from: l */
    public boolean m3205l() {
        return this.f2627h != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1663hh)) {
            return m3189a((C1663hh) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3189a(C1663hh c1663hh) {
        if (c1663hh == null) {
            return false;
        }
        boolean m3188a = m3188a();
        boolean m3188a2 = c1663hh.m3188a();
        if ((m3188a || m3188a2) && !(m3188a && m3188a2 && this.f2617a.equals(c1663hh.f2617a))) {
            return false;
        }
        boolean m3191b = m3191b();
        boolean m3191b2 = c1663hh.m3191b();
        if ((m3191b || m3191b2) && !(m3191b && m3191b2 && this.f2616a.m2884a(c1663hh.f2616a))) {
            return false;
        }
        boolean m3193c = m3193c();
        boolean m3193c2 = c1663hh.m3193c();
        if ((m3193c || m3193c2) && !(m3193c && m3193c2 && this.f2621b.equals(c1663hh.f2621b))) {
            return false;
        }
        boolean m3195d = m3195d();
        boolean m3195d2 = c1663hh.m3195d();
        if ((m3195d || m3195d2) && !(m3195d && m3195d2 && this.f2622c.equals(c1663hh.f2622c))) {
            return false;
        }
        boolean m3197e = m3197e();
        boolean m3197e2 = c1663hh.m3197e();
        if ((m3197e || m3197e2) && !(m3197e && m3197e2 && this.f2623d.equals(c1663hh.f2623d))) {
            return false;
        }
        boolean m3199f = m3199f();
        boolean m3199f2 = c1663hh.m3199f();
        if ((m3199f || m3199f2) && !(m3199f && m3199f2 && this.f2624e.equals(c1663hh.f2624e))) {
            return false;
        }
        boolean m3200g = m3200g();
        boolean m3200g2 = c1663hh.m3200g();
        if ((m3200g || m3200g2) && !(m3200g && m3200g2 && this.f2625f.equals(c1663hh.f2625f))) {
            return false;
        }
        boolean m3201h = m3201h();
        boolean m3201h2 = c1663hh.m3201h();
        if ((m3201h || m3201h2) && !(m3201h && m3201h2 && this.f2615a.m2812a(c1663hh.f2615a))) {
            return false;
        }
        boolean m3202i = m3202i();
        boolean m3202i2 = c1663hh.m3202i();
        if ((m3202i || m3202i2) && !(m3202i && m3202i2 && this.f2620a == c1663hh.f2620a)) {
            return false;
        }
        boolean m3203j = m3203j();
        boolean m3203j2 = c1663hh.m3203j();
        if ((m3203j || m3203j2) && !(m3203j && m3203j2 && this.f2619a.equals(c1663hh.f2619a))) {
            return false;
        }
        boolean m3204k = m3204k();
        boolean m3204k2 = c1663hh.m3204k();
        if ((m3204k || m3204k2) && !(m3204k && m3204k2 && this.f2626g.equals(c1663hh.f2626g))) {
            return false;
        }
        boolean m3205l = m3205l();
        boolean m3205l2 = c1663hh.m3205l();
        if (m3205l || m3205l2) {
            return m3205l && m3205l2 && this.f2627h.equals(c1663hh.f2627h);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1663hh c1663hh) {
        int m3318a;
        int m3318a2;
        int m3321a;
        int m3324a;
        int m3317a;
        int m3318a3;
        int m3318a4;
        int m3318a5;
        int m3318a6;
        int m3318a7;
        int m3317a2;
        int m3318a8;
        if (!getClass().equals(c1663hh.getClass())) {
            return getClass().getName().compareTo(c1663hh.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3188a()).compareTo(Boolean.valueOf(c1663hh.m3188a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3188a() && (m3318a8 = C1672hq.m3318a(this.f2617a, c1663hh.f2617a)) != 0) {
            return m3318a8;
        }
        int compareTo2 = Boolean.valueOf(m3191b()).compareTo(Boolean.valueOf(c1663hh.m3191b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3191b() && (m3317a2 = C1672hq.m3317a(this.f2616a, c1663hh.f2616a)) != 0) {
            return m3317a2;
        }
        int compareTo3 = Boolean.valueOf(m3193c()).compareTo(Boolean.valueOf(c1663hh.m3193c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3193c() && (m3318a7 = C1672hq.m3318a(this.f2621b, c1663hh.f2621b)) != 0) {
            return m3318a7;
        }
        int compareTo4 = Boolean.valueOf(m3195d()).compareTo(Boolean.valueOf(c1663hh.m3195d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3195d() && (m3318a6 = C1672hq.m3318a(this.f2622c, c1663hh.f2622c)) != 0) {
            return m3318a6;
        }
        int compareTo5 = Boolean.valueOf(m3197e()).compareTo(Boolean.valueOf(c1663hh.m3197e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3197e() && (m3318a5 = C1672hq.m3318a(this.f2623d, c1663hh.f2623d)) != 0) {
            return m3318a5;
        }
        int compareTo6 = Boolean.valueOf(m3199f()).compareTo(Boolean.valueOf(c1663hh.m3199f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3199f() && (m3318a4 = C1672hq.m3318a(this.f2624e, c1663hh.f2624e)) != 0) {
            return m3318a4;
        }
        int compareTo7 = Boolean.valueOf(m3200g()).compareTo(Boolean.valueOf(c1663hh.m3200g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3200g() && (m3318a3 = C1672hq.m3318a(this.f2625f, c1663hh.f2625f)) != 0) {
            return m3318a3;
        }
        int compareTo8 = Boolean.valueOf(m3201h()).compareTo(Boolean.valueOf(c1663hh.m3201h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m3201h() && (m3317a = C1672hq.m3317a(this.f2615a, c1663hh.f2615a)) != 0) {
            return m3317a;
        }
        int compareTo9 = Boolean.valueOf(m3202i()).compareTo(Boolean.valueOf(c1663hh.m3202i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m3202i() && (m3324a = C1672hq.m3324a(this.f2620a, c1663hh.f2620a)) != 0) {
            return m3324a;
        }
        int compareTo10 = Boolean.valueOf(m3203j()).compareTo(Boolean.valueOf(c1663hh.m3203j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m3203j() && (m3321a = C1672hq.m3321a(this.f2619a, c1663hh.f2619a)) != 0) {
            return m3321a;
        }
        int compareTo11 = Boolean.valueOf(m3204k()).compareTo(Boolean.valueOf(c1663hh.m3204k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m3204k() && (m3318a2 = C1672hq.m3318a(this.f2626g, c1663hh.f2626g)) != 0) {
            return m3318a2;
        }
        int compareTo12 = Boolean.valueOf(m3205l()).compareTo(Boolean.valueOf(c1663hh.m3205l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!m3205l() || (m3318a = C1672hq.m3318a(this.f2627h, c1663hh.f2627h)) == 0) {
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
                            this.f2617a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2616a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2621b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2622c = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 11) {
                            this.f2623d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                        if (mo3340a.f2770a == 11) {
                            this.f2624e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f2625f = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 12) {
                            C1645gq c1645gq = new C1645gq();
                            this.f2615a = c1645gq;
                            c1645gq.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 9:
                        if (mo3340a.f2770a == 2) {
                            this.f2620a = abstractC1681hz.mo3361a();
                            m3187a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 10:
                        if (mo3340a.f2770a == 13) {
                            C1680hy mo3342a = abstractC1681hz.mo3342a();
                            this.f2619a = new HashMap(mo3342a.f2776a * 2);
                            for (int i = 0; i < mo3342a.f2776a; i++) {
                                this.f2619a.put(abstractC1681hz.mo3345a(), abstractC1681hz.mo3345a());
                            }
                            abstractC1681hz.mo3370h();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 11:
                        if (mo3340a.f2770a == 11) {
                            this.f2626g = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 12:
                        if (mo3340a.f2770a == 11) {
                            this.f2627h = abstractC1681hz.mo3345a();
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
                m3186a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m3186a();
        abstractC1681hz.mo3356a(f2603a);
        if (this.f2617a != null && m3188a()) {
            abstractC1681hz.mo3353a(f2602a);
            abstractC1681hz.mo3357a(this.f2617a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2616a != null && m3191b()) {
            abstractC1681hz.mo3353a(f2604b);
            this.f2616a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2621b != null) {
            abstractC1681hz.mo3353a(f2605c);
            abstractC1681hz.mo3357a(this.f2621b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2622c != null) {
            abstractC1681hz.mo3353a(f2606d);
            abstractC1681hz.mo3357a(this.f2622c);
            abstractC1681hz.mo3362b();
        }
        if (this.f2623d != null && m3197e()) {
            abstractC1681hz.mo3353a(f2607e);
            abstractC1681hz.mo3357a(this.f2623d);
            abstractC1681hz.mo3362b();
        }
        if (this.f2624e != null && m3199f()) {
            abstractC1681hz.mo3353a(f2608f);
            abstractC1681hz.mo3357a(this.f2624e);
            abstractC1681hz.mo3362b();
        }
        if (this.f2625f != null && m3200g()) {
            abstractC1681hz.mo3353a(f2609g);
            abstractC1681hz.mo3357a(this.f2625f);
            abstractC1681hz.mo3362b();
        }
        if (this.f2615a != null && m3201h()) {
            abstractC1681hz.mo3353a(f2610h);
            this.f2615a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (m3202i()) {
            abstractC1681hz.mo3353a(f2611i);
            abstractC1681hz.mo3360a(this.f2620a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2619a != null && m3203j()) {
            abstractC1681hz.mo3353a(f2612j);
            abstractC1681hz.mo3355a(new C1680hy((byte) 11, (byte) 11, this.f2619a.size()));
            for (Map.Entry<String, String> entry : this.f2619a.entrySet()) {
                abstractC1681hz.mo3357a(entry.getKey());
                abstractC1681hz.mo3357a(entry.getValue());
            }
            abstractC1681hz.mo3366d();
            abstractC1681hz.mo3362b();
        }
        if (this.f2626g != null && m3204k()) {
            abstractC1681hz.mo3353a(f2613k);
            abstractC1681hz.mo3357a(this.f2626g);
            abstractC1681hz.mo3362b();
        }
        if (this.f2627h != null && m3205l()) {
            abstractC1681hz.mo3353a(f2614l);
            abstractC1681hz.mo3357a(this.f2627h);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (m3188a()) {
            sb.append("debug:");
            String str = this.f2617a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m3191b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1648gt c1648gt = this.f2616a;
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
        String str2 = this.f2621b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f2622c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (m3197e()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f2623d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m3199f()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f2624e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m3200g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f2625f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m3201h()) {
            sb.append(", ");
            sb.append("message:");
            C1645gq c1645gq = this.f2615a;
            if (c1645gq == null) {
                sb.append("null");
            } else {
                sb.append(c1645gq);
            }
        }
        if (m3202i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f2620a);
        }
        if (m3203j()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f2619a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (m3204k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f2626g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (m3205l()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.f2627h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m3186a() {
        if (this.f2621b == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f2622c == null) {
            throw new C1683ia("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
