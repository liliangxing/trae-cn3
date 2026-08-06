package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.dn */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1561dn {

    /* renamed from: com.xiaomi.push.dn$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class a extends AbstractC1574e {

        /* renamed from: a */
        private boolean f1340a;

        /* renamed from: b */
        private boolean f1342b;

        /* renamed from: d */
        private boolean f1345d;

        /* renamed from: e */
        private boolean f1346e;

        /* renamed from: a */
        private int f1338a = 0;

        /* renamed from: c */
        private boolean f1344c = false;

        /* renamed from: b */
        private int f1341b = 0;

        /* renamed from: f */
        private boolean f1347f = false;

        /* renamed from: a */
        private List<String> f1339a = Collections.emptyList();

        /* renamed from: c */
        private int f1343c = -1;

        /* renamed from: c */
        public int m2072c() {
            return this.f1338a;
        }

        /* renamed from: a */
        public boolean m2067a() {
            return this.f1340a;
        }

        /* renamed from: a */
        public a m2061a(int i) {
            this.f1340a = true;
            this.f1338a = i;
            return this;
        }

        /* renamed from: b */
        public boolean m2071b() {
            return this.f1344c;
        }

        /* renamed from: c */
        public boolean m2073c() {
            return this.f1342b;
        }

        /* renamed from: a */
        public a m2064a(boolean z) {
            this.f1342b = true;
            this.f1344c = z;
            return this;
        }

        /* renamed from: d */
        public int m2074d() {
            return this.f1341b;
        }

        /* renamed from: d */
        public boolean m2075d() {
            return this.f1345d;
        }

        /* renamed from: b */
        public a m2069b(int i) {
            this.f1345d = true;
            this.f1341b = i;
            return this;
        }

        /* renamed from: e */
        public boolean m2077e() {
            return this.f1347f;
        }

        /* renamed from: f */
        public boolean m2078f() {
            return this.f1346e;
        }

        /* renamed from: b */
        public a m2070b(boolean z) {
            this.f1346e = true;
            this.f1347f = z;
            return this;
        }

        /* renamed from: a */
        public List<String> m2065a() {
            return this.f1339a;
        }

        /* renamed from: e */
        public int m2076e() {
            return this.f1339a.size();
        }

        /* renamed from: a */
        public a m2063a(String str) {
            str.getClass();
            if (this.f1339a.isEmpty()) {
                this.f1339a = new ArrayList();
            }
            this.f1339a.add(str);
            return this;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public void mo2066a(C1520c c1520c) {
            if (m2067a()) {
                c1520c.m1767b(1, m2072c());
            }
            if (m2073c()) {
                c1520c.m1757a(2, m2071b());
            }
            if (m2075d()) {
                c1520c.m1752a(3, m2074d());
            }
            if (m2078f()) {
                c1520c.m1757a(4, m2077e());
            }
            Iterator<String> it = m2065a().iterator();
            while (it.hasNext()) {
                c1520c.m1756a(5, it.next());
            }
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public int mo2060a() {
            if (this.f1343c < 0) {
                mo2068b();
            }
            return this.f1343c;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: b */
        public int mo2068b() {
            int i = 0;
            int m1741b = m2067a() ? C1520c.m1741b(1, m2072c()) + 0 : 0;
            if (m2073c()) {
                m1741b += C1520c.m1731a(2, m2071b());
            }
            if (m2075d()) {
                m1741b += C1520c.m1726a(3, m2074d());
            }
            if (m2078f()) {
                m1741b += C1520c.m1731a(4, m2077e());
            }
            Iterator<String> it = m2065a().iterator();
            while (it.hasNext()) {
                i += C1520c.m1735a(it.next());
            }
            int size = m1741b + i + (m2065a().size() * 1);
            this.f1343c = size;
            return size;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public a mo2062a(C1493b c1493b) {
            while (true) {
                int m1603a = c1493b.m1603a();
                if (m1603a == 0) {
                    return this;
                }
                if (m1603a == 8) {
                    m2061a(c1493b.m1618c());
                } else if (m1603a == 16) {
                    m2064a(c1493b.m1611a());
                } else if (m1603a == 24) {
                    m2069b(c1493b.m1614b());
                } else if (m1603a == 32) {
                    m2070b(c1493b.m1611a());
                } else if (m1603a != 42) {
                    if (!m2337a(c1493b, m1603a)) {
                        return this;
                    }
                } else {
                    m2063a(c1493b.m1607a());
                }
            }
        }

        /* renamed from: a */
        public static a m2058a(byte[] bArr) {
            return (a) new a().m2058a(bArr);
        }

        /* renamed from: b */
        public static a m2059b(C1493b c1493b) {
            return new a().mo2062a(c1493b);
        }
    }
}
