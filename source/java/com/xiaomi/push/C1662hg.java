package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.hg */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1662hg implements InterfaceC1671hp<C1662hg, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f2594a;

    /* renamed from: a */
    public C1648gt f2595a;

    /* renamed from: a */
    public String f2596a;

    /* renamed from: a */
    private BitSet f2597a = new BitSet(1);

    /* renamed from: b */
    public String f2598b;

    /* renamed from: c */
    public String f2599c;

    /* renamed from: d */
    public String f2600d;

    /* renamed from: e */
    public String f2601e;

    /* renamed from: a */
    private static final C1687ie f2587a = new C1687ie("XmPushActionSendFeedbackResult");

    /* renamed from: a */
    private static final C1678hw f2586a = new C1678hw("", (byte) 11, 1);

    /* renamed from: b */
    private static final C1678hw f2588b = new C1678hw("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1678hw f2589c = new C1678hw("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1678hw f2590d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2591e = new C1678hw("", (byte) 10, 6);

    /* renamed from: f */
    private static final C1678hw f2592f = new C1678hw("", (byte) 11, 7);

    /* renamed from: g */
    private static final C1678hw f2593g = new C1678hw("", (byte) 11, 8);

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public boolean m3175a() {
        return this.f2596a != null;
    }

    /* renamed from: b */
    public boolean m3177b() {
        return this.f2595a != null;
    }

    /* renamed from: c */
    public boolean m3178c() {
        return this.f2598b != null;
    }

    /* renamed from: d */
    public boolean m3179d() {
        return this.f2599c != null;
    }

    /* renamed from: e */
    public boolean m3180e() {
        return this.f2597a.get(0);
    }

    /* renamed from: a */
    public void m3174a(boolean z) {
        this.f2597a.set(0, z);
    }

    /* renamed from: f */
    public boolean m3181f() {
        return this.f2600d != null;
    }

    /* renamed from: g */
    public boolean m3182g() {
        return this.f2601e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1662hg)) {
            return m3176a((C1662hg) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3176a(C1662hg c1662hg) {
        if (c1662hg == null) {
            return false;
        }
        boolean m3175a = m3175a();
        boolean m3175a2 = c1662hg.m3175a();
        if ((m3175a || m3175a2) && !(m3175a && m3175a2 && this.f2596a.equals(c1662hg.f2596a))) {
            return false;
        }
        boolean m3177b = m3177b();
        boolean m3177b2 = c1662hg.m3177b();
        if ((m3177b || m3177b2) && !(m3177b && m3177b2 && this.f2595a.m2884a(c1662hg.f2595a))) {
            return false;
        }
        boolean m3178c = m3178c();
        boolean m3178c2 = c1662hg.m3178c();
        if ((m3178c || m3178c2) && !(m3178c && m3178c2 && this.f2598b.equals(c1662hg.f2598b))) {
            return false;
        }
        boolean m3179d = m3179d();
        boolean m3179d2 = c1662hg.m3179d();
        if (((m3179d || m3179d2) && !(m3179d && m3179d2 && this.f2599c.equals(c1662hg.f2599c))) || this.f2594a != c1662hg.f2594a) {
            return false;
        }
        boolean m3181f = m3181f();
        boolean m3181f2 = c1662hg.m3181f();
        if ((m3181f || m3181f2) && !(m3181f && m3181f2 && this.f2600d.equals(c1662hg.f2600d))) {
            return false;
        }
        boolean m3182g = m3182g();
        boolean m3182g2 = c1662hg.m3182g();
        if (m3182g || m3182g2) {
            return m3182g && m3182g2 && this.f2601e.equals(c1662hg.f2601e);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1662hg c1662hg) {
        int m3318a;
        int m3318a2;
        int m3316a;
        int m3318a3;
        int m3318a4;
        int m3317a;
        int m3318a5;
        if (!getClass().equals(c1662hg.getClass())) {
            return getClass().getName().compareTo(c1662hg.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3175a()).compareTo(Boolean.valueOf(c1662hg.m3175a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3175a() && (m3318a5 = C1672hq.m3318a(this.f2596a, c1662hg.f2596a)) != 0) {
            return m3318a5;
        }
        int compareTo2 = Boolean.valueOf(m3177b()).compareTo(Boolean.valueOf(c1662hg.m3177b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3177b() && (m3317a = C1672hq.m3317a(this.f2595a, c1662hg.f2595a)) != 0) {
            return m3317a;
        }
        int compareTo3 = Boolean.valueOf(m3178c()).compareTo(Boolean.valueOf(c1662hg.m3178c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3178c() && (m3318a4 = C1672hq.m3318a(this.f2598b, c1662hg.f2598b)) != 0) {
            return m3318a4;
        }
        int compareTo4 = Boolean.valueOf(m3179d()).compareTo(Boolean.valueOf(c1662hg.m3179d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3179d() && (m3318a3 = C1672hq.m3318a(this.f2599c, c1662hg.f2599c)) != 0) {
            return m3318a3;
        }
        int compareTo5 = Boolean.valueOf(m3180e()).compareTo(Boolean.valueOf(c1662hg.m3180e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3180e() && (m3316a = C1672hq.m3316a(this.f2594a, c1662hg.f2594a)) != 0) {
            return m3316a;
        }
        int compareTo6 = Boolean.valueOf(m3181f()).compareTo(Boolean.valueOf(c1662hg.m3181f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3181f() && (m3318a2 = C1672hq.m3318a(this.f2600d, c1662hg.f2600d)) != 0) {
            return m3318a2;
        }
        int compareTo7 = Boolean.valueOf(m3182g()).compareTo(Boolean.valueOf(c1662hg.m3182g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!m3182g() || (m3318a = C1672hq.m3318a(this.f2601e, c1662hg.f2601e)) == 0) {
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
                            this.f2596a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2595a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 11) {
                            this.f2598b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2599c = abstractC1681hz.mo3345a();
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
                            this.f2594a = abstractC1681hz.mo3339a();
                            m3174a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 11) {
                            this.f2600d = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 11) {
                            this.f2601e = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                }
                abstractC1681hz.mo3369g();
            } else {
                abstractC1681hz.mo3368f();
                if (!m3180e()) {
                    throw new C1683ia("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m3173a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m3173a();
        abstractC1681hz.mo3356a(f2587a);
        if (this.f2596a != null && m3175a()) {
            abstractC1681hz.mo3353a(f2586a);
            abstractC1681hz.mo3357a(this.f2596a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2595a != null && m3177b()) {
            abstractC1681hz.mo3353a(f2588b);
            this.f2595a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2598b != null) {
            abstractC1681hz.mo3353a(f2589c);
            abstractC1681hz.mo3357a(this.f2598b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2599c != null) {
            abstractC1681hz.mo3353a(f2590d);
            abstractC1681hz.mo3357a(this.f2599c);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3353a(f2591e);
        abstractC1681hz.mo3352a(this.f2594a);
        abstractC1681hz.mo3362b();
        if (this.f2600d != null && m3181f()) {
            abstractC1681hz.mo3353a(f2592f);
            abstractC1681hz.mo3357a(this.f2600d);
            abstractC1681hz.mo3362b();
        }
        if (this.f2601e != null && m3182g()) {
            abstractC1681hz.mo3353a(f2593g);
            abstractC1681hz.mo3357a(this.f2601e);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = false;
        if (m3175a()) {
            sb.append("debug:");
            String str = this.f2596a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m3177b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1648gt c1648gt = this.f2595a;
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
        String str2 = this.f2598b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f2599c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f2594a);
        if (m3181f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f2600d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m3182g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f2601e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m3173a() {
        if (this.f2598b == null) {
            throw new C1683ia("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f2599c == null) {
            throw new C1683ia("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
