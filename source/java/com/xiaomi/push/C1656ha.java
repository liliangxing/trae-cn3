package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.ha */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1656ha implements InterfaceC1671hp<C1656ha, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public EnumC1633ge f2437a;

    /* renamed from: a */
    public C1646gr f2438a;

    /* renamed from: a */
    public C1648gt f2439a;

    /* renamed from: a */
    public String f2440a;

    /* renamed from: a */
    public ByteBuffer f2441a;

    /* renamed from: b */
    public String f2444b;

    /* renamed from: a */
    private static final C1687ie f2429a = new C1687ie("XmPushActionContainer");

    /* renamed from: a */
    private static final C1678hw f2428a = new C1678hw("", (byte) 8, 1);

    /* renamed from: b */
    private static final C1678hw f2430b = new C1678hw("", (byte) 2, 2);

    /* renamed from: c */
    private static final C1678hw f2431c = new C1678hw("", (byte) 2, 3);

    /* renamed from: d */
    private static final C1678hw f2432d = new C1678hw("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1678hw f2433e = new C1678hw("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1678hw f2434f = new C1678hw("", (byte) 11, 6);

    /* renamed from: g */
    private static final C1678hw f2435g = new C1678hw("", (byte) 12, 7);

    /* renamed from: h */
    private static final C1678hw f2436h = new C1678hw("", (byte) 12, 8);

    /* renamed from: a */
    private BitSet f2442a = new BitSet(2);

    /* renamed from: a */
    public boolean f2443a = true;

    /* renamed from: b */
    public boolean f2445b = true;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public EnumC1633ge m3009a() {
        return this.f2437a;
    }

    /* renamed from: a */
    public C1656ha m3011a(EnumC1633ge enumC1633ge) {
        this.f2437a = enumC1633ge;
        return this;
    }

    /* renamed from: a */
    public boolean m3020a() {
        return this.f2437a != null;
    }

    /* renamed from: b */
    public boolean m3027b() {
        return this.f2443a;
    }

    /* renamed from: a */
    public C1656ha m3016a(boolean z) {
        this.f2443a = z;
        m3019a(true);
        return this;
    }

    /* renamed from: c */
    public boolean m3028c() {
        return this.f2442a.get(0);
    }

    /* renamed from: a */
    public void m3019a(boolean z) {
        this.f2442a.set(0, z);
    }

    /* renamed from: b */
    public C1656ha m3024b(boolean z) {
        this.f2445b = z;
        m3026b(true);
        return this;
    }

    /* renamed from: d */
    public boolean m3029d() {
        return this.f2442a.get(1);
    }

    /* renamed from: b */
    public void m3026b(boolean z) {
        this.f2442a.set(1, z);
    }

    /* renamed from: a */
    public byte[] m3022a() {
        m3015a(C1672hq.m3327a(this.f2441a));
        return this.f2441a.array();
    }

    /* renamed from: a */
    public C1656ha m3015a(ByteBuffer byteBuffer) {
        this.f2441a = byteBuffer;
        return this;
    }

    /* renamed from: e */
    public boolean m3030e() {
        return this.f2441a != null;
    }

    /* renamed from: a */
    public String m3017a() {
        return this.f2440a;
    }

    /* renamed from: a */
    public C1656ha m3014a(String str) {
        this.f2440a = str;
        return this;
    }

    /* renamed from: f */
    public boolean m3031f() {
        return this.f2440a != null;
    }

    /* renamed from: b */
    public String m3025b() {
        return this.f2444b;
    }

    /* renamed from: b */
    public C1656ha m3023b(String str) {
        this.f2444b = str;
        return this;
    }

    /* renamed from: g */
    public boolean m3032g() {
        return this.f2444b != null;
    }

    /* renamed from: a */
    public C1656ha m3013a(C1648gt c1648gt) {
        this.f2439a = c1648gt;
        return this;
    }

    /* renamed from: h */
    public boolean m3033h() {
        return this.f2439a != null;
    }

    /* renamed from: a */
    public C1646gr m3010a() {
        return this.f2438a;
    }

    /* renamed from: a */
    public C1656ha m3012a(C1646gr c1646gr) {
        this.f2438a = c1646gr;
        return this;
    }

    /* renamed from: i */
    public boolean m3034i() {
        return this.f2438a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1656ha)) {
            return m3021a((C1656ha) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3021a(C1656ha c1656ha) {
        if (c1656ha == null) {
            return false;
        }
        boolean m3020a = m3020a();
        boolean m3020a2 = c1656ha.m3020a();
        if (((m3020a || m3020a2) && (!m3020a || !m3020a2 || !this.f2437a.equals(c1656ha.f2437a))) || this.f2443a != c1656ha.f2443a || this.f2445b != c1656ha.f2445b) {
            return false;
        }
        boolean m3030e = m3030e();
        boolean m3030e2 = c1656ha.m3030e();
        if ((m3030e || m3030e2) && !(m3030e && m3030e2 && this.f2441a.equals(c1656ha.f2441a))) {
            return false;
        }
        boolean m3031f = m3031f();
        boolean m3031f2 = c1656ha.m3031f();
        if ((m3031f || m3031f2) && !(m3031f && m3031f2 && this.f2440a.equals(c1656ha.f2440a))) {
            return false;
        }
        boolean m3032g = m3032g();
        boolean m3032g2 = c1656ha.m3032g();
        if ((m3032g || m3032g2) && !(m3032g && m3032g2 && this.f2444b.equals(c1656ha.f2444b))) {
            return false;
        }
        boolean m3033h = m3033h();
        boolean m3033h2 = c1656ha.m3033h();
        if ((m3033h || m3033h2) && !(m3033h && m3033h2 && this.f2439a.m2884a(c1656ha.f2439a))) {
            return false;
        }
        boolean m3034i = m3034i();
        boolean m3034i2 = c1656ha.m3034i();
        if (m3034i || m3034i2) {
            return m3034i && m3034i2 && this.f2438a.m2848a(c1656ha.f2438a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1656ha c1656ha) {
        int m3317a;
        int m3317a2;
        int m3318a;
        int m3318a2;
        int m3317a3;
        int m3324a;
        int m3324a2;
        int m3317a4;
        if (!getClass().equals(c1656ha.getClass())) {
            return getClass().getName().compareTo(c1656ha.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3020a()).compareTo(Boolean.valueOf(c1656ha.m3020a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3020a() && (m3317a4 = C1672hq.m3317a(this.f2437a, c1656ha.f2437a)) != 0) {
            return m3317a4;
        }
        int compareTo2 = Boolean.valueOf(m3028c()).compareTo(Boolean.valueOf(c1656ha.m3028c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3028c() && (m3324a2 = C1672hq.m3324a(this.f2443a, c1656ha.f2443a)) != 0) {
            return m3324a2;
        }
        int compareTo3 = Boolean.valueOf(m3029d()).compareTo(Boolean.valueOf(c1656ha.m3029d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3029d() && (m3324a = C1672hq.m3324a(this.f2445b, c1656ha.f2445b)) != 0) {
            return m3324a;
        }
        int compareTo4 = Boolean.valueOf(m3030e()).compareTo(Boolean.valueOf(c1656ha.m3030e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3030e() && (m3317a3 = C1672hq.m3317a(this.f2441a, c1656ha.f2441a)) != 0) {
            return m3317a3;
        }
        int compareTo5 = Boolean.valueOf(m3031f()).compareTo(Boolean.valueOf(c1656ha.m3031f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3031f() && (m3318a2 = C1672hq.m3318a(this.f2440a, c1656ha.f2440a)) != 0) {
            return m3318a2;
        }
        int compareTo6 = Boolean.valueOf(m3032g()).compareTo(Boolean.valueOf(c1656ha.m3032g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3032g() && (m3318a = C1672hq.m3318a(this.f2444b, c1656ha.f2444b)) != 0) {
            return m3318a;
        }
        int compareTo7 = Boolean.valueOf(m3033h()).compareTo(Boolean.valueOf(c1656ha.m3033h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m3033h() && (m3317a2 = C1672hq.m3317a(this.f2439a, c1656ha.f2439a)) != 0) {
            return m3317a2;
        }
        int compareTo8 = Boolean.valueOf(m3034i()).compareTo(Boolean.valueOf(c1656ha.m3034i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!m3034i() || (m3317a = C1672hq.m3317a(this.f2438a, c1656ha.f2438a)) == 0) {
            return 0;
        }
        return m3317a;
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
                        if (mo3340a.f2770a == 8) {
                            this.f2437a = EnumC1633ge.m2713a(abstractC1681hz.mo3338a());
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 2:
                        if (mo3340a.f2770a == 2) {
                            this.f2443a = abstractC1681hz.mo3361a();
                            m3019a(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 3:
                        if (mo3340a.f2770a == 2) {
                            this.f2445b = abstractC1681hz.mo3361a();
                            m3026b(true);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 4:
                        if (mo3340a.f2770a == 11) {
                            this.f2441a = abstractC1681hz.mo3347a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 5:
                        if (mo3340a.f2770a == 11) {
                            this.f2440a = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 6:
                        if (mo3340a.f2770a == 11) {
                            this.f2444b = abstractC1681hz.mo3345a();
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 7:
                        if (mo3340a.f2770a == 12) {
                            C1648gt c1648gt = new C1648gt();
                            this.f2439a = c1648gt;
                            c1648gt.mo2352a(abstractC1681hz);
                            break;
                        } else {
                            C1685ic.m3406a(abstractC1681hz, mo3340a.f2770a);
                            break;
                        }
                    case 8:
                        if (mo3340a.f2770a == 12) {
                            C1646gr c1646gr = new C1646gr();
                            this.f2438a = c1646gr;
                            c1646gr.mo2352a(abstractC1681hz);
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
                if (!m3028c()) {
                    throw new C1683ia("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!m3029d()) {
                    throw new C1683ia("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                m3018a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC1671hp
    /* renamed from: b */
    public void mo2358b(AbstractC1681hz abstractC1681hz) {
        m3018a();
        abstractC1681hz.mo3356a(f2429a);
        if (this.f2437a != null) {
            abstractC1681hz.mo3353a(f2428a);
            abstractC1681hz.mo3351a(this.f2437a.m2714a());
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3353a(f2430b);
        abstractC1681hz.mo3360a(this.f2443a);
        abstractC1681hz.mo3362b();
        abstractC1681hz.mo3353a(f2431c);
        abstractC1681hz.mo3360a(this.f2445b);
        abstractC1681hz.mo3362b();
        if (this.f2441a != null) {
            abstractC1681hz.mo3353a(f2432d);
            abstractC1681hz.mo3358a(this.f2441a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2440a != null && m3031f()) {
            abstractC1681hz.mo3353a(f2433e);
            abstractC1681hz.mo3357a(this.f2440a);
            abstractC1681hz.mo3362b();
        }
        if (this.f2444b != null && m3032g()) {
            abstractC1681hz.mo3353a(f2434f);
            abstractC1681hz.mo3357a(this.f2444b);
            abstractC1681hz.mo3362b();
        }
        if (this.f2439a != null) {
            abstractC1681hz.mo3353a(f2435g);
            this.f2439a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        if (this.f2438a != null && m3034i()) {
            abstractC1681hz.mo3353a(f2436h);
            this.f2438a.mo2358b(abstractC1681hz);
            abstractC1681hz.mo3362b();
        }
        abstractC1681hz.mo3364c();
        abstractC1681hz.mo3349a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(action:");
        EnumC1633ge enumC1633ge = this.f2437a;
        if (enumC1633ge == null) {
            sb.append("null");
        } else {
            sb.append(enumC1633ge);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f2443a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f2445b);
        if (m3031f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f2440a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (m3032g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f2444b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        C1648gt c1648gt = this.f2439a;
        if (c1648gt == null) {
            sb.append("null");
        } else {
            sb.append(c1648gt);
        }
        if (m3034i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            C1646gr c1646gr = this.f2438a;
            if (c1646gr == null) {
                sb.append("null");
            } else {
                sb.append(c1646gr);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m3018a() {
        if (this.f2437a == null) {
            throw new C1683ia("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f2441a == null) {
            throw new C1683ia("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f2439a == null) {
            throw new C1683ia("Required field 'target' was not present! Struct: " + toString());
        }
    }
}
