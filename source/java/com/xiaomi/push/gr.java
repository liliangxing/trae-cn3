package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class gr implements hp<gr, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f617a;

    /* renamed from: a, reason: collision with other field name */
    public long f618a;

    /* renamed from: a, reason: collision with other field name */
    public String f619a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f620a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f621a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f622a;

    /* renamed from: b, reason: collision with other field name */
    public int f623b;

    /* renamed from: b, reason: collision with other field name */
    public String f624b;

    /* renamed from: b, reason: collision with other field name */
    public Map<String, String> f625b;

    /* renamed from: c, reason: collision with other field name */
    public int f626c;

    /* renamed from: c, reason: collision with other field name */
    public String f627c;

    /* renamed from: c, reason: collision with other field name */
    public Map<String, String> f628c;

    /* renamed from: d, reason: collision with other field name */
    public String f629d;

    /* renamed from: e, reason: collision with other field name */
    public String f630e;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f616a = new ie("PushMetaInfo");
    private static final hw a = new hw("", (byte) 11, 1);
    private static final hw b = new hw("", (byte) 10, 2);
    private static final hw c = new hw("", (byte) 11, 3);
    private static final hw d = new hw("", (byte) 11, 4);
    private static final hw e = new hw("", (byte) 11, 5);
    private static final hw f = new hw("", (byte) 8, 6);
    private static final hw g = new hw("", (byte) 11, 7);
    private static final hw h = new hw("", (byte) 8, 8);
    private static final hw i = new hw("", (byte) 8, 9);
    private static final hw j = new hw("", (byte) 13, 10);
    private static final hw k = new hw("", (byte) 13, 11);
    private static final hw l = new hw("", (byte) 2, 12);
    private static final hw m = new hw("", (byte) 13, 13);

    public int hashCode() {
        return 0;
    }

    public gr() {
        this.f620a = new BitSet(5);
        this.f622a = false;
    }

    public gr(gr grVar) {
        BitSet bitSet = new BitSet(5);
        this.f620a = bitSet;
        bitSet.clear();
        this.f620a.or(grVar.f620a);
        if (grVar.m9976a()) {
            this.f619a = grVar.f619a;
        }
        this.f618a = grVar.f618a;
        if (grVar.m9982c()) {
            this.f624b = grVar.f624b;
        }
        if (grVar.m9983d()) {
            this.f627c = grVar.f627c;
        }
        if (grVar.e()) {
            this.f629d = grVar.f629d;
        }
        this.f617a = grVar.f617a;
        if (grVar.g()) {
            this.f630e = grVar.f630e;
        }
        this.f623b = grVar.f623b;
        this.f626c = grVar.f626c;
        if (grVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : grVar.f621a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f621a = hashMap;
        }
        if (grVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : grVar.f625b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f625b = hashMap2;
        }
        this.f622a = grVar.f622a;
        if (grVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : grVar.f628c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f628c = hashMap3;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public gr m9972a() {
        return new gr(this);
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m9973a() {
        return this.f619a;
    }

    public gr a(String str) {
        this.f619a = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m9976a() {
        return this.f619a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m9971a() {
        return this.f618a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m9980b() {
        return this.f620a.get(0);
    }

    public void a(boolean z) {
        this.f620a.set(0, z);
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m9978b() {
        return this.f624b;
    }

    public gr b(String str) {
        this.f624b = str;
        return this;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m9982c() {
        return this.f624b != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m9981c() {
        return this.f627c;
    }

    public gr c(String str) {
        this.f627c = str;
        return this;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m9983d() {
        return this.f627c != null;
    }

    public String d() {
        return this.f629d;
    }

    public gr d(String str) {
        this.f629d = str;
        return this;
    }

    public boolean e() {
        return this.f629d != null;
    }

    public int a() {
        return this.f617a;
    }

    public gr a(int i2) {
        this.f617a = i2;
        b(true);
        return this;
    }

    public boolean f() {
        return this.f620a.get(1);
    }

    public void b(boolean z) {
        this.f620a.set(1, z);
    }

    public boolean g() {
        return this.f630e != null;
    }

    public int b() {
        return this.f623b;
    }

    public gr b(int i2) {
        this.f623b = i2;
        c(true);
        return this;
    }

    public boolean h() {
        return this.f620a.get(2);
    }

    public void c(boolean z) {
        this.f620a.set(2, z);
    }

    public int c() {
        return this.f626c;
    }

    public gr c(int i2) {
        this.f626c = i2;
        d(true);
        return this;
    }

    public boolean i() {
        return this.f620a.get(3);
    }

    public void d(boolean z) {
        this.f620a.set(3, z);
    }

    public void a(String str, String str2) {
        if (this.f621a == null) {
            this.f621a = new HashMap();
        }
        this.f621a.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m9974a() {
        return this.f621a;
    }

    public gr a(Map<String, String> map) {
        this.f621a = map;
        return this;
    }

    public boolean j() {
        return this.f621a != null;
    }

    public void b(String str, String str2) {
        if (this.f625b == null) {
            this.f625b = new HashMap();
        }
        this.f625b.put(str, str2);
    }

    /* renamed from: b, reason: collision with other method in class */
    public Map<String, String> m9979b() {
        return this.f625b;
    }

    public boolean k() {
        return this.f625b != null;
    }

    public boolean l() {
        return this.f622a;
    }

    public boolean m() {
        return this.f620a.get(4);
    }

    public void e(boolean z) {
        this.f620a.set(4, z);
    }

    public boolean n() {
        return this.f628c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gr)) {
            return m9977a((gr) obj);
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m9977a(gr grVar) {
        if (grVar == null) {
            return false;
        }
        boolean m9976a = m9976a();
        boolean m9976a2 = grVar.m9976a();
        if (((m9976a || m9976a2) && !(m9976a && m9976a2 && this.f619a.equals(grVar.f619a))) || this.f618a != grVar.f618a) {
            return false;
        }
        boolean m9982c = m9982c();
        boolean m9982c2 = grVar.m9982c();
        if ((m9982c || m9982c2) && !(m9982c && m9982c2 && this.f624b.equals(grVar.f624b))) {
            return false;
        }
        boolean m9983d = m9983d();
        boolean m9983d2 = grVar.m9983d();
        if ((m9983d || m9983d2) && !(m9983d && m9983d2 && this.f627c.equals(grVar.f627c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = grVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f629d.equals(grVar.f629d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = grVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f617a == grVar.f617a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = grVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f630e.equals(grVar.f630e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = grVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f623b == grVar.f623b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = grVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f626c == grVar.f626c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = grVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f621a.equals(grVar.f621a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = grVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f625b.equals(grVar.f625b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = grVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f622a == grVar.f622a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = grVar.n();
        if (n || n2) {
            return n && n2 && this.f628c.equals(grVar.f628c);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gr grVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        if (!getClass().equals(grVar.getClass())) {
            return getClass().getName().compareTo(grVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m9976a()).compareTo(Boolean.valueOf(grVar.m9976a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m9976a() && (a14 = hq.a(this.f619a, grVar.f619a)) != 0) {
            return a14;
        }
        int compareTo2 = Boolean.valueOf(m9980b()).compareTo(Boolean.valueOf(grVar.m9980b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m9980b() && (a13 = hq.a(this.f618a, grVar.f618a)) != 0) {
            return a13;
        }
        int compareTo3 = Boolean.valueOf(m9982c()).compareTo(Boolean.valueOf(grVar.m9982c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m9982c() && (a12 = hq.a(this.f624b, grVar.f624b)) != 0) {
            return a12;
        }
        int compareTo4 = Boolean.valueOf(m9983d()).compareTo(Boolean.valueOf(grVar.m9983d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m9983d() && (a11 = hq.a(this.f627c, grVar.f627c)) != 0) {
            return a11;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(grVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a10 = hq.a(this.f629d, grVar.f629d)) != 0) {
            return a10;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(grVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a9 = hq.a(this.f617a, grVar.f617a)) != 0) {
            return a9;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(grVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a8 = hq.a(this.f630e, grVar.f630e)) != 0) {
            return a8;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(grVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a7 = hq.a(this.f623b, grVar.f623b)) != 0) {
            return a7;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(grVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a6 = hq.a(this.f626c, grVar.f626c)) != 0) {
            return a6;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(grVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a5 = hq.a(this.f621a, grVar.f621a)) != 0) {
            return a5;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(grVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a4 = hq.a(this.f625b, grVar.f625b)) != 0) {
            return a4;
        }
        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(grVar.m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m() && (a3 = hq.a(this.f622a, grVar.f622a)) != 0) {
            return a3;
        }
        int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(grVar.n()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (!n() || (a2 = hq.a(this.f628c, grVar.f628c)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo10085a();
        while (true) {
            hw mo10081a = hzVar.mo10081a();
            if (mo10081a.a != 0) {
                int i2 = 0;
                switch (mo10081a.f887a) {
                    case 1:
                        if (mo10081a.a == 11) {
                            this.f619a = hzVar.mo10086a();
                            break;
                        } else {
                            ic.a(hzVar, mo10081a.a);
                            break;
                        }
                    case 2:
                        if (mo10081a.a == 10) {
                            this.f618a = hzVar.mo10080a();
                            a(true);
                            break;
                        } else {
                            ic.a(hzVar, mo10081a.a);
                            break;
                        }
                    case 3:
                        if (mo10081a.a == 11) {
                            this.f624b = hzVar.mo10086a();
                            break;
                        } else {
                            ic.a(hzVar, mo10081a.a);
                            break;
                        }
                    case 4:
                        if (mo10081a.a == 11) {
                            this.f627c = hzVar.mo10086a();
                            break;
                        } else {
                            ic.a(hzVar, mo10081a.a);
                            break;
                        }
                    case 5:
                        if (mo10081a.a == 11) {
                            this.f629d = hzVar.mo10086a();
                            break;
                        } else {
                            ic.a(hzVar, mo10081a.a);
                            break;
                        }
                    case 6:
                        if (mo10081a.a == 8) {
                            this.f617a = hzVar.mo10079a();
                            b(true);
                            break;
                        } else {
                            ic.a(hzVar, mo10081a.a);
                            break;
                        }
                    case 7:
                        if (mo10081a.a == 11) {
                            this.f630e = hzVar.mo10086a();
                            break;
                        } else {
                            ic.a(hzVar, mo10081a.a);
                            break;
                        }
                    case 8:
                        if (mo10081a.a == 8) {
                            this.f623b = hzVar.mo10079a();
                            c(true);
                            break;
                        } else {
                            ic.a(hzVar, mo10081a.a);
                            break;
                        }
                    case 9:
                        if (mo10081a.a == 8) {
                            this.f626c = hzVar.mo10079a();
                            d(true);
                            break;
                        } else {
                            ic.a(hzVar, mo10081a.a);
                            break;
                        }
                    case 10:
                        if (mo10081a.a == 13) {
                            hy mo10083a = hzVar.mo10083a();
                            this.f621a = new HashMap(mo10083a.f889a * 2);
                            while (i2 < mo10083a.f889a) {
                                this.f621a.put(hzVar.mo10086a(), hzVar.mo10086a());
                                i2++;
                            }
                            hzVar.h();
                            break;
                        } else {
                            ic.a(hzVar, mo10081a.a);
                            break;
                        }
                    case 11:
                        if (mo10081a.a == 13) {
                            hy mo10083a2 = hzVar.mo10083a();
                            this.f625b = new HashMap(mo10083a2.f889a * 2);
                            while (i2 < mo10083a2.f889a) {
                                this.f625b.put(hzVar.mo10086a(), hzVar.mo10086a());
                                i2++;
                            }
                            hzVar.h();
                            break;
                        } else {
                            ic.a(hzVar, mo10081a.a);
                            break;
                        }
                    case 12:
                        if (mo10081a.a == 2) {
                            this.f622a = hzVar.mo10091a();
                            e(true);
                            break;
                        } else {
                            ic.a(hzVar, mo10081a.a);
                            break;
                        }
                    case 13:
                        if (mo10081a.a == 13) {
                            hy mo10083a3 = hzVar.mo10083a();
                            this.f628c = new HashMap(mo10083a3.f889a * 2);
                            while (i2 < mo10083a3.f889a) {
                                this.f628c.put(hzVar.mo10086a(), hzVar.mo10086a());
                                i2++;
                            }
                            hzVar.h();
                            break;
                        } else {
                            ic.a(hzVar, mo10081a.a);
                            break;
                        }
                    default:
                        ic.a(hzVar, mo10081a.a);
                        break;
                }
                hzVar.g();
            } else {
                hzVar.f();
                if (!m9980b()) {
                    throw new ia("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m9975a();
                return;
            }
        }
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m9975a();
        hzVar.a(f616a);
        if (this.f619a != null) {
            hzVar.a(a);
            hzVar.a(this.f619a);
            hzVar.b();
        }
        hzVar.a(b);
        hzVar.a(this.f618a);
        hzVar.b();
        if (this.f624b != null && m9982c()) {
            hzVar.a(c);
            hzVar.a(this.f624b);
            hzVar.b();
        }
        if (this.f627c != null && m9983d()) {
            hzVar.a(d);
            hzVar.a(this.f627c);
            hzVar.b();
        }
        if (this.f629d != null && e()) {
            hzVar.a(e);
            hzVar.a(this.f629d);
            hzVar.b();
        }
        if (f()) {
            hzVar.a(f);
            hzVar.mo10090a(this.f617a);
            hzVar.b();
        }
        if (this.f630e != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f630e);
            hzVar.b();
        }
        if (h()) {
            hzVar.a(h);
            hzVar.mo10090a(this.f623b);
            hzVar.b();
        }
        if (i()) {
            hzVar.a(i);
            hzVar.mo10090a(this.f626c);
            hzVar.b();
        }
        if (this.f621a != null && j()) {
            hzVar.a(j);
            hzVar.a(new hy((byte) 11, (byte) 11, this.f621a.size()));
            for (Map.Entry<String, String> entry : this.f621a.entrySet()) {
                hzVar.a(entry.getKey());
                hzVar.a(entry.getValue());
            }
            hzVar.d();
            hzVar.b();
        }
        if (this.f625b != null && k()) {
            hzVar.a(k);
            hzVar.a(new hy((byte) 11, (byte) 11, this.f625b.size()));
            for (Map.Entry<String, String> entry2 : this.f625b.entrySet()) {
                hzVar.a(entry2.getKey());
                hzVar.a(entry2.getValue());
            }
            hzVar.d();
            hzVar.b();
        }
        if (m()) {
            hzVar.a(l);
            hzVar.a(this.f622a);
            hzVar.b();
        }
        if (this.f628c != null && n()) {
            hzVar.a(m);
            hzVar.a(new hy((byte) 11, (byte) 11, this.f628c.size()));
            for (Map.Entry<String, String> entry3 : this.f628c.entrySet()) {
                hzVar.a(entry3.getKey());
                hzVar.a(entry3.getValue());
            }
            hzVar.d();
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo10089a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(id:");
        String str = this.f619a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str));
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f618a);
        if (m9982c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f624b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (m9983d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f627c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f629d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f617a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f630e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f623b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f626c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f621a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f625b;
            if (map2 == null) {
                sb.append("null");
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f622a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f628c;
            if (map3 == null) {
                sb.append("null");
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9975a() {
        if (this.f619a == null) {
            throw new ia("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
