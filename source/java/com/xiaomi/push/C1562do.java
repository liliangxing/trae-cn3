package com.xiaomi.push;

/* renamed from: com.xiaomi.push.do */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1562do {

    /* renamed from: com.xiaomi.push.do$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class b extends AbstractC1574e {

        /* renamed from: a */
        private boolean f1376a;

        /* renamed from: c */
        private boolean f1380c;

        /* renamed from: d */
        private boolean f1382d;

        /* renamed from: e */
        private boolean f1383e;

        /* renamed from: b */
        private boolean f1378b = false;

        /* renamed from: a */
        private int f1375a = 0;

        /* renamed from: b */
        private int f1377b = 0;

        /* renamed from: c */
        private int f1379c = 0;

        /* renamed from: d */
        private int f1381d = -1;

        /* renamed from: a */
        public boolean m2122a() {
            return this.f1378b;
        }

        /* renamed from: b */
        public boolean m2124b() {
            return this.f1376a;
        }

        /* renamed from: a */
        public b m2121a(boolean z) {
            this.f1376a = true;
            this.f1378b = z;
            return this;
        }

        /* renamed from: c */
        public int m2125c() {
            return this.f1375a;
        }

        /* renamed from: c */
        public boolean m2127c() {
            return this.f1380c;
        }

        /* renamed from: a */
        public b m2120a(int i) {
            this.f1380c = true;
            this.f1375a = i;
            return this;
        }

        /* renamed from: d */
        public int m2128d() {
            return this.f1377b;
        }

        /* renamed from: d */
        public boolean m2129d() {
            return this.f1382d;
        }

        /* renamed from: b */
        public b m2123b(int i) {
            this.f1382d = true;
            this.f1377b = i;
            return this;
        }

        /* renamed from: e */
        public int m2130e() {
            return this.f1379c;
        }

        /* renamed from: e */
        public boolean m2131e() {
            return this.f1383e;
        }

        /* renamed from: c */
        public b m2126c(int i) {
            this.f1383e = true;
            this.f1379c = i;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public void mo2066a(C1520c c1520c) {
            if (m2124b()) {
                c1520c.m1757a(1, m2122a());
            }
            if (m2127c()) {
                c1520c.m1752a(3, m2125c());
            }
            if (m2129d()) {
                c1520c.m1752a(4, m2128d());
            }
            if (m2131e()) {
                c1520c.m1752a(5, m2130e());
            }
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public int mo2060a() {
            if (this.f1381d < 0) {
                mo2068b();
            }
            return this.f1381d;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: b */
        public int mo2068b() {
            int m1731a = m2124b() ? 0 + C1520c.m1731a(1, m2122a()) : 0;
            if (m2127c()) {
                m1731a += C1520c.m1726a(3, m2125c());
            }
            if (m2129d()) {
                m1731a += C1520c.m1726a(4, m2128d());
            }
            if (m2131e()) {
                m1731a += C1520c.m1726a(5, m2130e());
            }
            this.f1381d = m1731a;
            return m1731a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public b mo2062a(C1493b c1493b) {
            while (true) {
                int m1603a = c1493b.m1603a();
                if (m1603a == 0) {
                    return this;
                }
                if (m1603a == 8) {
                    m2121a(c1493b.m1611a());
                } else if (m1603a == 24) {
                    m2120a(c1493b.m1614b());
                } else if (m1603a == 32) {
                    m2123b(c1493b.m1614b());
                } else if (m1603a != 40) {
                    if (!m2337a(c1493b, m1603a)) {
                        return this;
                    }
                } else {
                    m2126c(c1493b.m1614b());
                }
            }
        }

        /* renamed from: a */
        public static b m2119a(byte[] bArr) {
            return (b) new b().m2119a(bArr);
        }
    }

    /* renamed from: com.xiaomi.push.do$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class a extends AbstractC1574e {

        /* renamed from: a */
        private boolean f1351a;

        /* renamed from: b */
        private boolean f1355b;

        /* renamed from: c */
        private boolean f1359c;

        /* renamed from: d */
        private boolean f1362d;

        /* renamed from: e */
        private boolean f1365e;

        /* renamed from: f */
        private boolean f1367f;

        /* renamed from: g */
        private boolean f1368g;

        /* renamed from: h */
        private boolean f1369h;

        /* renamed from: i */
        private boolean f1370i;

        /* renamed from: j */
        private boolean f1371j;

        /* renamed from: k */
        private boolean f1372k;

        /* renamed from: l */
        private boolean f1373l;

        /* renamed from: m */
        private boolean f1374m;

        /* renamed from: a */
        private int f1348a = 0;

        /* renamed from: a */
        private long f1349a = 0;

        /* renamed from: a */
        private String f1350a = "";

        /* renamed from: b */
        private String f1354b = "";

        /* renamed from: c */
        private String f1358c = "";

        /* renamed from: d */
        private String f1361d = "";

        /* renamed from: e */
        private String f1364e = "";

        /* renamed from: b */
        private int f1352b = 1;

        /* renamed from: c */
        private int f1356c = 0;

        /* renamed from: d */
        private int f1360d = 0;

        /* renamed from: f */
        private String f1366f = "";

        /* renamed from: b */
        private long f1353b = 0;

        /* renamed from: c */
        private long f1357c = 0;

        /* renamed from: e */
        private int f1363e = -1;

        /* renamed from: c */
        public int m2092c() {
            return this.f1348a;
        }

        /* renamed from: a */
        public boolean m2085a() {
            return this.f1351a;
        }

        /* renamed from: a */
        public a m2081a(int i) {
            this.f1351a = true;
            this.f1348a = i;
            return this;
        }

        /* renamed from: a */
        public long m2079a() {
            return this.f1349a;
        }

        /* renamed from: b */
        public boolean m2091b() {
            return this.f1355b;
        }

        /* renamed from: a */
        public a m2082a(long j) {
            this.f1355b = true;
            this.f1349a = j;
            return this;
        }

        /* renamed from: a */
        public String m2084a() {
            return this.f1350a;
        }

        /* renamed from: c */
        public boolean m2098c() {
            return this.f1359c;
        }

        /* renamed from: a */
        public a m2083a(String str) {
            this.f1359c = true;
            this.f1350a = str;
            return this;
        }

        /* renamed from: b */
        public String m2090b() {
            return this.f1354b;
        }

        /* renamed from: d */
        public boolean m2103d() {
            return this.f1362d;
        }

        /* renamed from: b */
        public a m2089b(String str) {
            this.f1362d = true;
            this.f1354b = str;
            return this;
        }

        /* renamed from: c */
        public String m2097c() {
            return this.f1358c;
        }

        /* renamed from: e */
        public boolean m2107e() {
            return this.f1365e;
        }

        /* renamed from: c */
        public a m2096c(String str) {
            this.f1365e = true;
            this.f1358c = str;
            return this;
        }

        /* renamed from: d */
        public String m2102d() {
            return this.f1361d;
        }

        /* renamed from: f */
        public boolean m2111f() {
            return this.f1367f;
        }

        /* renamed from: d */
        public a m2101d(String str) {
            this.f1367f = true;
            this.f1361d = str;
            return this;
        }

        /* renamed from: a */
        public a m2080a() {
            this.f1367f = false;
            this.f1361d = "";
            return this;
        }

        /* renamed from: e */
        public String m2106e() {
            return this.f1364e;
        }

        /* renamed from: g */
        public boolean m2112g() {
            return this.f1368g;
        }

        /* renamed from: e */
        public a m2105e(String str) {
            this.f1368g = true;
            this.f1364e = str;
            return this;
        }

        /* renamed from: h */
        public boolean m2113h() {
            return this.f1369h;
        }

        /* renamed from: d */
        public int m2099d() {
            return this.f1352b;
        }

        /* renamed from: b */
        public a m2087b(int i) {
            this.f1369h = true;
            this.f1352b = i;
            return this;
        }

        /* renamed from: e */
        public int m2104e() {
            return this.f1356c;
        }

        /* renamed from: i */
        public boolean m2114i() {
            return this.f1370i;
        }

        /* renamed from: c */
        public a m2094c(int i) {
            this.f1370i = true;
            this.f1356c = i;
            return this;
        }

        /* renamed from: f */
        public int m2108f() {
            return this.f1360d;
        }

        /* renamed from: j */
        public boolean m2115j() {
            return this.f1371j;
        }

        /* renamed from: d */
        public a m2100d(int i) {
            this.f1371j = true;
            this.f1360d = i;
            return this;
        }

        /* renamed from: f */
        public String m2110f() {
            return this.f1366f;
        }

        /* renamed from: k */
        public boolean m2116k() {
            return this.f1372k;
        }

        /* renamed from: f */
        public a m2109f(String str) {
            this.f1372k = true;
            this.f1366f = str;
            return this;
        }

        /* renamed from: b */
        public long m2086b() {
            return this.f1353b;
        }

        /* renamed from: l */
        public boolean m2117l() {
            return this.f1373l;
        }

        /* renamed from: b */
        public a m2088b(long j) {
            this.f1373l = true;
            this.f1353b = j;
            return this;
        }

        /* renamed from: c */
        public long m2093c() {
            return this.f1357c;
        }

        /* renamed from: m */
        public boolean m2118m() {
            return this.f1374m;
        }

        /* renamed from: c */
        public a m2095c(long j) {
            this.f1374m = true;
            this.f1357c = j;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public void mo2066a(C1520c c1520c) {
            if (m2085a()) {
                c1520c.m1752a(1, m2092c());
            }
            if (m2091b()) {
                c1520c.m1768b(2, m2079a());
            }
            if (m2098c()) {
                c1520c.m1756a(3, m2084a());
            }
            if (m2103d()) {
                c1520c.m1756a(4, m2090b());
            }
            if (m2107e()) {
                c1520c.m1756a(5, m2097c());
            }
            if (m2111f()) {
                c1520c.m1756a(6, m2102d());
            }
            if (m2112g()) {
                c1520c.m1756a(7, m2106e());
            }
            if (m2113h()) {
                c1520c.m1752a(8, m2099d());
            }
            if (m2114i()) {
                c1520c.m1752a(9, m2104e());
            }
            if (m2115j()) {
                c1520c.m1752a(10, m2108f());
            }
            if (m2116k()) {
                c1520c.m1756a(11, m2110f());
            }
            if (m2117l()) {
                c1520c.m1768b(12, m2086b());
            }
            if (m2118m()) {
                c1520c.m1768b(13, m2093c());
            }
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public int mo2060a() {
            if (this.f1363e < 0) {
                mo2068b();
            }
            return this.f1363e;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: b */
        public int mo2068b() {
            int m1726a = m2085a() ? 0 + C1520c.m1726a(1, m2092c()) : 0;
            if (m2091b()) {
                m1726a += C1520c.m1742b(2, m2079a());
            }
            if (m2098c()) {
                m1726a += C1520c.m1730a(3, m2084a());
            }
            if (m2103d()) {
                m1726a += C1520c.m1730a(4, m2090b());
            }
            if (m2107e()) {
                m1726a += C1520c.m1730a(5, m2097c());
            }
            if (m2111f()) {
                m1726a += C1520c.m1730a(6, m2102d());
            }
            if (m2112g()) {
                m1726a += C1520c.m1730a(7, m2106e());
            }
            if (m2113h()) {
                m1726a += C1520c.m1726a(8, m2099d());
            }
            if (m2114i()) {
                m1726a += C1520c.m1726a(9, m2104e());
            }
            if (m2115j()) {
                m1726a += C1520c.m1726a(10, m2108f());
            }
            if (m2116k()) {
                m1726a += C1520c.m1730a(11, m2110f());
            }
            if (m2117l()) {
                m1726a += C1520c.m1742b(12, m2086b());
            }
            if (m2118m()) {
                m1726a += C1520c.m1742b(13, m2093c());
            }
            this.f1363e = m1726a;
            return m1726a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public a mo2062a(C1493b c1493b) {
            while (true) {
                int m1603a = c1493b.m1603a();
                switch (m1603a) {
                    case 0:
                        return this;
                    case 8:
                        m2081a(c1493b.m1614b());
                        break;
                    case 16:
                        m2082a(c1493b.m1615b());
                        break;
                    case 26:
                        m2083a(c1493b.m1607a());
                        break;
                    case 34:
                        m2089b(c1493b.m1607a());
                        break;
                    case 42:
                        m2096c(c1493b.m1607a());
                        break;
                    case 50:
                        m2101d(c1493b.m1607a());
                        break;
                    case 58:
                        m2105e(c1493b.m1607a());
                        break;
                    case 64:
                        m2087b(c1493b.m1614b());
                        break;
                    case 72:
                        m2094c(c1493b.m1614b());
                        break;
                    case 80:
                        m2100d(c1493b.m1614b());
                        break;
                    case 90:
                        m2109f(c1493b.m1607a());
                        break;
                    case 96:
                        m2088b(c1493b.m1615b());
                        break;
                    case 104:
                        m2095c(c1493b.m1615b());
                        break;
                    default:
                        if (!m2337a(c1493b, m1603a)) {
                            return this;
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: com.xiaomi.push.do$e */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class e extends AbstractC1574e {

        /* renamed from: a */
        private boolean f1410a;

        /* renamed from: b */
        private boolean f1414b;

        /* renamed from: c */
        private boolean f1417c;

        /* renamed from: d */
        private boolean f1420d;

        /* renamed from: e */
        private boolean f1423e;

        /* renamed from: f */
        private boolean f1425f;

        /* renamed from: g */
        private boolean f1426g;

        /* renamed from: h */
        private boolean f1427h;

        /* renamed from: i */
        private boolean f1428i;

        /* renamed from: j */
        private boolean f1429j;

        /* renamed from: k */
        private boolean f1430k;

        /* renamed from: l */
        private boolean f1431l;

        /* renamed from: m */
        private boolean f1432m;

        /* renamed from: a */
        private int f1406a = 0;

        /* renamed from: a */
        private String f1409a = "";

        /* renamed from: b */
        private String f1413b = "";

        /* renamed from: c */
        private String f1416c = "";

        /* renamed from: b */
        private int f1411b = 0;

        /* renamed from: d */
        private String f1419d = "";

        /* renamed from: e */
        private String f1422e = "";

        /* renamed from: f */
        private String f1424f = "";

        /* renamed from: a */
        private b f1408a = null;

        /* renamed from: c */
        private int f1415c = 0;

        /* renamed from: a */
        private C1466a f1407a = C1466a.f916a;

        /* renamed from: b */
        private C1466a f1412b = C1466a.f916a;

        /* renamed from: d */
        private int f1418d = 0;

        /* renamed from: e */
        private int f1421e = -1;

        /* renamed from: c */
        public int m2177c() {
            return this.f1406a;
        }

        /* renamed from: a */
        public boolean m2170a() {
            return this.f1410a;
        }

        /* renamed from: a */
        public e m2165a(int i) {
            this.f1410a = true;
            this.f1406a = i;
            return this;
        }

        /* renamed from: a */
        public String m2169a() {
            return this.f1409a;
        }

        /* renamed from: b */
        public boolean m2176b() {
            return this.f1414b;
        }

        /* renamed from: a */
        public e m2168a(String str) {
            this.f1414b = true;
            this.f1409a = str;
            return this;
        }

        /* renamed from: b */
        public String m2175b() {
            return this.f1413b;
        }

        /* renamed from: c */
        public boolean m2181c() {
            return this.f1417c;
        }

        /* renamed from: b */
        public e m2174b(String str) {
            this.f1417c = true;
            this.f1413b = str;
            return this;
        }

        /* renamed from: c */
        public String m2180c() {
            return this.f1416c;
        }

        /* renamed from: d */
        public boolean m2186d() {
            return this.f1420d;
        }

        /* renamed from: c */
        public e m2179c(String str) {
            this.f1420d = true;
            this.f1416c = str;
            return this;
        }

        /* renamed from: d */
        public int m2182d() {
            return this.f1411b;
        }

        /* renamed from: e */
        public boolean m2190e() {
            return this.f1423e;
        }

        /* renamed from: b */
        public e m2172b(int i) {
            this.f1423e = true;
            this.f1411b = i;
            return this;
        }

        /* renamed from: d */
        public String m2185d() {
            return this.f1419d;
        }

        /* renamed from: f */
        public boolean m2194f() {
            return this.f1425f;
        }

        /* renamed from: d */
        public e m2184d(String str) {
            this.f1425f = true;
            this.f1419d = str;
            return this;
        }

        /* renamed from: e */
        public String m2189e() {
            return this.f1422e;
        }

        /* renamed from: g */
        public boolean m2195g() {
            return this.f1426g;
        }

        /* renamed from: e */
        public e m2188e(String str) {
            this.f1426g = true;
            this.f1422e = str;
            return this;
        }

        /* renamed from: f */
        public String m2193f() {
            return this.f1424f;
        }

        /* renamed from: h */
        public boolean m2196h() {
            return this.f1427h;
        }

        /* renamed from: f */
        public e m2192f(String str) {
            this.f1427h = true;
            this.f1424f = str;
            return this;
        }

        /* renamed from: i */
        public boolean m2197i() {
            return this.f1428i;
        }

        /* renamed from: a */
        public b m2164a() {
            return this.f1408a;
        }

        /* renamed from: a */
        public e m2167a(b bVar) {
            bVar.getClass();
            this.f1428i = true;
            this.f1408a = bVar;
            return this;
        }

        /* renamed from: e */
        public int m2187e() {
            return this.f1415c;
        }

        /* renamed from: j */
        public boolean m2198j() {
            return this.f1429j;
        }

        /* renamed from: c */
        public e m2178c(int i) {
            this.f1429j = true;
            this.f1415c = i;
            return this;
        }

        /* renamed from: a */
        public C1466a m2163a() {
            return this.f1407a;
        }

        /* renamed from: k */
        public boolean m2199k() {
            return this.f1430k;
        }

        /* renamed from: a */
        public e m2166a(C1466a c1466a) {
            this.f1430k = true;
            this.f1407a = c1466a;
            return this;
        }

        /* renamed from: b */
        public C1466a m2171b() {
            return this.f1412b;
        }

        /* renamed from: l */
        public boolean m2200l() {
            return this.f1431l;
        }

        /* renamed from: b */
        public e m2173b(C1466a c1466a) {
            this.f1431l = true;
            this.f1412b = c1466a;
            return this;
        }

        /* renamed from: f */
        public int m2191f() {
            return this.f1418d;
        }

        /* renamed from: m */
        public boolean m2201m() {
            return this.f1432m;
        }

        /* renamed from: d */
        public e m2183d(int i) {
            this.f1432m = true;
            this.f1418d = i;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public void mo2066a(C1520c c1520c) {
            if (m2170a()) {
                c1520c.m1767b(1, m2177c());
            }
            if (m2176b()) {
                c1520c.m1756a(2, m2169a());
            }
            if (m2181c()) {
                c1520c.m1756a(3, m2175b());
            }
            if (m2186d()) {
                c1520c.m1756a(4, m2180c());
            }
            if (m2190e()) {
                c1520c.m1752a(5, m2182d());
            }
            if (m2194f()) {
                c1520c.m1756a(6, m2185d());
            }
            if (m2195g()) {
                c1520c.m1756a(7, m2189e());
            }
            if (m2196h()) {
                c1520c.m1756a(8, m2193f());
            }
            if (m2197i()) {
                c1520c.m1755a(9, (AbstractC1574e) m2164a());
            }
            if (m2198j()) {
                c1520c.m1752a(10, m2187e());
            }
            if (m2199k()) {
                c1520c.m1754a(11, m2163a());
            }
            if (m2200l()) {
                c1520c.m1754a(12, m2171b());
            }
            if (m2201m()) {
                c1520c.m1752a(13, m2191f());
            }
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public int mo2060a() {
            if (this.f1421e < 0) {
                mo2068b();
            }
            return this.f1421e;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: b */
        public int mo2068b() {
            int m1741b = m2170a() ? 0 + C1520c.m1741b(1, m2177c()) : 0;
            if (m2176b()) {
                m1741b += C1520c.m1730a(2, m2169a());
            }
            if (m2181c()) {
                m1741b += C1520c.m1730a(3, m2175b());
            }
            if (m2186d()) {
                m1741b += C1520c.m1730a(4, m2180c());
            }
            if (m2190e()) {
                m1741b += C1520c.m1726a(5, m2182d());
            }
            if (m2194f()) {
                m1741b += C1520c.m1730a(6, m2185d());
            }
            if (m2195g()) {
                m1741b += C1520c.m1730a(7, m2189e());
            }
            if (m2196h()) {
                m1741b += C1520c.m1730a(8, m2193f());
            }
            if (m2197i()) {
                m1741b += C1520c.m1729a(9, (AbstractC1574e) m2164a());
            }
            if (m2198j()) {
                m1741b += C1520c.m1726a(10, m2187e());
            }
            if (m2199k()) {
                m1741b += C1520c.m1728a(11, m2163a());
            }
            if (m2200l()) {
                m1741b += C1520c.m1728a(12, m2171b());
            }
            if (m2201m()) {
                m1741b += C1520c.m1726a(13, m2191f());
            }
            this.f1421e = m1741b;
            return m1741b;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public e mo2062a(C1493b c1493b) {
            while (true) {
                int m1603a = c1493b.m1603a();
                switch (m1603a) {
                    case 0:
                        return this;
                    case 8:
                        m2165a(c1493b.m1618c());
                        break;
                    case 18:
                        m2168a(c1493b.m1607a());
                        break;
                    case 26:
                        m2174b(c1493b.m1607a());
                        break;
                    case 34:
                        m2179c(c1493b.m1607a());
                        break;
                    case 40:
                        m2172b(c1493b.m1614b());
                        break;
                    case 50:
                        m2184d(c1493b.m1607a());
                        break;
                    case 58:
                        m2188e(c1493b.m1607a());
                        break;
                    case 66:
                        m2192f(c1493b.m1607a());
                        break;
                    case 74:
                        b bVar = new b();
                        c1493b.m1610a(bVar);
                        m2167a(bVar);
                        break;
                    case 80:
                        m2178c(c1493b.m1614b());
                        break;
                    case 90:
                        m2166a(c1493b.m1606a());
                        break;
                    case 98:
                        m2173b(c1493b.m1606a());
                        break;
                    case 104:
                        m2183d(c1493b.m1614b());
                        break;
                    default:
                        if (!m2337a(c1493b, m1603a)) {
                            return this;
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: com.xiaomi.push.do$f */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class f extends AbstractC1574e {

        /* renamed from: a */
        private boolean f1436a;

        /* renamed from: b */
        private boolean f1438b;

        /* renamed from: c */
        private boolean f1439c;

        /* renamed from: a */
        private String f1435a = "";

        /* renamed from: b */
        private String f1437b = "";

        /* renamed from: a */
        private b f1434a = null;

        /* renamed from: a */
        private int f1433a = -1;

        /* renamed from: a */
        public String m2206a() {
            return this.f1435a;
        }

        /* renamed from: a */
        public boolean m2207a() {
            return this.f1436a;
        }

        /* renamed from: a */
        public f m2205a(String str) {
            this.f1436a = true;
            this.f1435a = str;
            return this;
        }

        /* renamed from: b */
        public String m2209b() {
            return this.f1437b;
        }

        /* renamed from: b */
        public boolean m2210b() {
            return this.f1438b;
        }

        /* renamed from: b */
        public f m2208b(String str) {
            this.f1438b = true;
            this.f1437b = str;
            return this;
        }

        /* renamed from: c */
        public boolean m2211c() {
            return this.f1439c;
        }

        /* renamed from: a */
        public b m2203a() {
            return this.f1434a;
        }

        /* renamed from: a */
        public f m2204a(b bVar) {
            bVar.getClass();
            this.f1439c = true;
            this.f1434a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public void mo2066a(C1520c c1520c) {
            if (m2207a()) {
                c1520c.m1756a(1, m2206a());
            }
            if (m2210b()) {
                c1520c.m1756a(2, m2209b());
            }
            if (m2211c()) {
                c1520c.m1755a(3, (AbstractC1574e) m2203a());
            }
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public int mo2060a() {
            if (this.f1433a < 0) {
                mo2068b();
            }
            return this.f1433a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: b */
        public int mo2068b() {
            int m1730a = m2207a() ? 0 + C1520c.m1730a(1, m2206a()) : 0;
            if (m2210b()) {
                m1730a += C1520c.m1730a(2, m2209b());
            }
            if (m2211c()) {
                m1730a += C1520c.m1729a(3, (AbstractC1574e) m2203a());
            }
            this.f1433a = m1730a;
            return m1730a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public f mo2062a(C1493b c1493b) {
            while (true) {
                int m1603a = c1493b.m1603a();
                if (m1603a == 0) {
                    return this;
                }
                if (m1603a == 10) {
                    m2205a(c1493b.m1607a());
                } else if (m1603a == 18) {
                    m2208b(c1493b.m1607a());
                } else if (m1603a != 26) {
                    if (!m2337a(c1493b, m1603a)) {
                        return this;
                    }
                } else {
                    b bVar = new b();
                    c1493b.m1610a(bVar);
                    m2204a(bVar);
                }
            }
        }

        /* renamed from: a */
        public static f m2202a(byte[] bArr) {
            return (f) new f().m2202a(bArr);
        }
    }

    /* renamed from: com.xiaomi.push.do$h */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class h extends AbstractC1574e {

        /* renamed from: a */
        private boolean f1449a;

        /* renamed from: b */
        private boolean f1451b;

        /* renamed from: a */
        private int f1447a = 0;

        /* renamed from: a */
        private String f1448a = "";

        /* renamed from: b */
        private int f1450b = -1;

        /* renamed from: c */
        public int m2228c() {
            return this.f1447a;
        }

        /* renamed from: a */
        public boolean m2226a() {
            return this.f1449a;
        }

        /* renamed from: a */
        public h m2223a(int i) {
            this.f1449a = true;
            this.f1447a = i;
            return this;
        }

        /* renamed from: a */
        public String m2225a() {
            return this.f1448a;
        }

        /* renamed from: b */
        public boolean m2227b() {
            return this.f1451b;
        }

        /* renamed from: a */
        public h m2224a(String str) {
            this.f1451b = true;
            this.f1448a = str;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public void mo2066a(C1520c c1520c) {
            if (m2226a()) {
                c1520c.m1752a(1, m2228c());
            }
            if (m2227b()) {
                c1520c.m1756a(2, m2225a());
            }
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public int mo2060a() {
            if (this.f1450b < 0) {
                mo2068b();
            }
            return this.f1450b;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: b */
        public int mo2068b() {
            int m1726a = m2226a() ? 0 + C1520c.m1726a(1, m2228c()) : 0;
            if (m2227b()) {
                m1726a += C1520c.m1730a(2, m2225a());
            }
            this.f1450b = m1726a;
            return m1726a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public h mo2062a(C1493b c1493b) {
            while (true) {
                int m1603a = c1493b.m1603a();
                if (m1603a == 0) {
                    return this;
                }
                if (m1603a == 8) {
                    m2223a(c1493b.m1614b());
                } else if (m1603a != 18) {
                    if (!m2337a(c1493b, m1603a)) {
                        return this;
                    }
                } else {
                    m2224a(c1493b.m1607a());
                }
            }
        }

        /* renamed from: a */
        public static h m2222a(byte[] bArr) {
            return (h) new h().m2222a(bArr);
        }
    }

    /* renamed from: com.xiaomi.push.do$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class c extends AbstractC1574e {

        /* renamed from: a */
        private boolean f1386a;

        /* renamed from: b */
        private boolean f1388b;

        /* renamed from: c */
        private boolean f1390c;

        /* renamed from: d */
        private boolean f1392d;

        /* renamed from: e */
        private boolean f1394e;

        /* renamed from: f */
        private boolean f1396f;

        /* renamed from: a */
        private String f1385a = "";

        /* renamed from: b */
        private String f1387b = "";

        /* renamed from: c */
        private String f1389c = "";

        /* renamed from: d */
        private String f1391d = "";

        /* renamed from: e */
        private String f1393e = "";

        /* renamed from: f */
        private String f1395f = "";

        /* renamed from: a */
        private int f1384a = -1;

        /* renamed from: a */
        public String m2133a() {
            return this.f1385a;
        }

        /* renamed from: a */
        public boolean m2134a() {
            return this.f1386a;
        }

        /* renamed from: a */
        public c m2132a(String str) {
            this.f1386a = true;
            this.f1385a = str;
            return this;
        }

        /* renamed from: b */
        public String m2136b() {
            return this.f1387b;
        }

        /* renamed from: b */
        public boolean m2137b() {
            return this.f1388b;
        }

        /* renamed from: b */
        public c m2135b(String str) {
            this.f1388b = true;
            this.f1387b = str;
            return this;
        }

        /* renamed from: c */
        public String m2139c() {
            return this.f1389c;
        }

        /* renamed from: c */
        public boolean m2140c() {
            return this.f1390c;
        }

        /* renamed from: c */
        public c m2138c(String str) {
            this.f1390c = true;
            this.f1389c = str;
            return this;
        }

        /* renamed from: d */
        public String m2142d() {
            return this.f1391d;
        }

        /* renamed from: d */
        public boolean m2143d() {
            return this.f1392d;
        }

        /* renamed from: d */
        public c m2141d(String str) {
            this.f1392d = true;
            this.f1391d = str;
            return this;
        }

        /* renamed from: e */
        public String m2145e() {
            return this.f1393e;
        }

        /* renamed from: e */
        public boolean m2146e() {
            return this.f1394e;
        }

        /* renamed from: e */
        public c m2144e(String str) {
            this.f1394e = true;
            this.f1393e = str;
            return this;
        }

        /* renamed from: f */
        public String m2148f() {
            return this.f1395f;
        }

        /* renamed from: f */
        public boolean m2149f() {
            return this.f1396f;
        }

        /* renamed from: f */
        public c m2147f(String str) {
            this.f1396f = true;
            this.f1395f = str;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public void mo2066a(C1520c c1520c) {
            if (m2134a()) {
                c1520c.m1756a(1, m2133a());
            }
            if (m2137b()) {
                c1520c.m1756a(2, m2136b());
            }
            if (m2140c()) {
                c1520c.m1756a(3, m2139c());
            }
            if (m2143d()) {
                c1520c.m1756a(4, m2142d());
            }
            if (m2146e()) {
                c1520c.m1756a(5, m2145e());
            }
            if (m2149f()) {
                c1520c.m1756a(6, m2148f());
            }
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public int mo2060a() {
            if (this.f1384a < 0) {
                mo2068b();
            }
            return this.f1384a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: b */
        public int mo2068b() {
            int m1730a = m2134a() ? 0 + C1520c.m1730a(1, m2133a()) : 0;
            if (m2137b()) {
                m1730a += C1520c.m1730a(2, m2136b());
            }
            if (m2140c()) {
                m1730a += C1520c.m1730a(3, m2139c());
            }
            if (m2143d()) {
                m1730a += C1520c.m1730a(4, m2142d());
            }
            if (m2146e()) {
                m1730a += C1520c.m1730a(5, m2145e());
            }
            if (m2149f()) {
                m1730a += C1520c.m1730a(6, m2148f());
            }
            this.f1384a = m1730a;
            return m1730a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public c mo2062a(C1493b c1493b) {
            while (true) {
                int m1603a = c1493b.m1603a();
                if (m1603a == 0) {
                    return this;
                }
                if (m1603a == 10) {
                    m2132a(c1493b.m1607a());
                } else if (m1603a == 18) {
                    m2135b(c1493b.m1607a());
                } else if (m1603a == 26) {
                    m2138c(c1493b.m1607a());
                } else if (m1603a == 34) {
                    m2141d(c1493b.m1607a());
                } else if (m1603a == 42) {
                    m2144e(c1493b.m1607a());
                } else if (m1603a != 50) {
                    if (!m2337a(c1493b, m1603a)) {
                        return this;
                    }
                } else {
                    m2147f(c1493b.m1607a());
                }
            }
        }
    }

    /* renamed from: com.xiaomi.push.do$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class d extends AbstractC1574e {

        /* renamed from: a */
        private boolean f1399a;

        /* renamed from: c */
        private boolean f1403c;

        /* renamed from: d */
        private boolean f1404d;

        /* renamed from: e */
        private boolean f1405e;

        /* renamed from: b */
        private boolean f1401b = false;

        /* renamed from: a */
        private String f1398a = "";

        /* renamed from: b */
        private String f1400b = "";

        /* renamed from: c */
        private String f1402c = "";

        /* renamed from: a */
        private int f1397a = -1;

        /* renamed from: a */
        public boolean m2154a() {
            return this.f1401b;
        }

        /* renamed from: b */
        public boolean m2157b() {
            return this.f1399a;
        }

        /* renamed from: a */
        public d m2152a(boolean z) {
            this.f1399a = true;
            this.f1401b = z;
            return this;
        }

        /* renamed from: a */
        public String m2153a() {
            return this.f1398a;
        }

        /* renamed from: c */
        public boolean m2160c() {
            return this.f1403c;
        }

        /* renamed from: a */
        public d m2151a(String str) {
            this.f1403c = true;
            this.f1398a = str;
            return this;
        }

        /* renamed from: b */
        public String m2156b() {
            return this.f1400b;
        }

        /* renamed from: d */
        public boolean m2161d() {
            return this.f1404d;
        }

        /* renamed from: b */
        public d m2155b(String str) {
            this.f1404d = true;
            this.f1400b = str;
            return this;
        }

        /* renamed from: c */
        public String m2159c() {
            return this.f1402c;
        }

        /* renamed from: e */
        public boolean m2162e() {
            return this.f1405e;
        }

        /* renamed from: c */
        public d m2158c(String str) {
            this.f1405e = true;
            this.f1402c = str;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public void mo2066a(C1520c c1520c) {
            if (m2157b()) {
                c1520c.m1757a(1, m2154a());
            }
            if (m2160c()) {
                c1520c.m1756a(2, m2153a());
            }
            if (m2161d()) {
                c1520c.m1756a(3, m2156b());
            }
            if (m2162e()) {
                c1520c.m1756a(4, m2159c());
            }
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public int mo2060a() {
            if (this.f1397a < 0) {
                mo2068b();
            }
            return this.f1397a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: b */
        public int mo2068b() {
            int m1731a = m2157b() ? 0 + C1520c.m1731a(1, m2154a()) : 0;
            if (m2160c()) {
                m1731a += C1520c.m1730a(2, m2153a());
            }
            if (m2161d()) {
                m1731a += C1520c.m1730a(3, m2156b());
            }
            if (m2162e()) {
                m1731a += C1520c.m1730a(4, m2159c());
            }
            this.f1397a = m1731a;
            return m1731a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public d mo2062a(C1493b c1493b) {
            while (true) {
                int m1603a = c1493b.m1603a();
                if (m1603a == 0) {
                    return this;
                }
                if (m1603a == 8) {
                    m2152a(c1493b.m1611a());
                } else if (m1603a == 18) {
                    m2151a(c1493b.m1607a());
                } else if (m1603a == 26) {
                    m2155b(c1493b.m1607a());
                } else if (m1603a != 34) {
                    if (!m2337a(c1493b, m1603a)) {
                        return this;
                    }
                } else {
                    m2158c(c1493b.m1607a());
                }
            }
        }

        /* renamed from: a */
        public static d m2150a(byte[] bArr) {
            return (d) new d().m2150a(bArr);
        }
    }

    /* renamed from: com.xiaomi.push.do$j */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class j extends AbstractC1574e {

        /* renamed from: a */
        private boolean f1458a;

        /* renamed from: b */
        private boolean f1459b;

        /* renamed from: a */
        private C1466a f1456a = C1466a.f916a;

        /* renamed from: a */
        private b f1457a = null;

        /* renamed from: a */
        private int f1455a = -1;

        /* renamed from: a */
        public C1466a m2234a() {
            return this.f1456a;
        }

        /* renamed from: a */
        public boolean m2238a() {
            return this.f1458a;
        }

        /* renamed from: a */
        public j m2236a(C1466a c1466a) {
            this.f1458a = true;
            this.f1456a = c1466a;
            return this;
        }

        /* renamed from: b */
        public boolean m2239b() {
            return this.f1459b;
        }

        /* renamed from: a */
        public b m2235a() {
            return this.f1457a;
        }

        /* renamed from: a */
        public j m2237a(b bVar) {
            bVar.getClass();
            this.f1459b = true;
            this.f1457a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public void mo2066a(C1520c c1520c) {
            if (m2238a()) {
                c1520c.m1754a(1, m2234a());
            }
            if (m2239b()) {
                c1520c.m1755a(2, (AbstractC1574e) m2235a());
            }
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public int mo2060a() {
            if (this.f1455a < 0) {
                mo2068b();
            }
            return this.f1455a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: b */
        public int mo2068b() {
            int m1728a = m2238a() ? 0 + C1520c.m1728a(1, m2234a()) : 0;
            if (m2239b()) {
                m1728a += C1520c.m1729a(2, (AbstractC1574e) m2235a());
            }
            this.f1455a = m1728a;
            return m1728a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public j mo2062a(C1493b c1493b) {
            while (true) {
                int m1603a = c1493b.m1603a();
                if (m1603a == 0) {
                    return this;
                }
                if (m1603a == 10) {
                    m2236a(c1493b.m1606a());
                } else if (m1603a != 18) {
                    if (!m2337a(c1493b, m1603a)) {
                        return this;
                    }
                } else {
                    b bVar = new b();
                    c1493b.m1610a(bVar);
                    m2237a(bVar);
                }
            }
        }

        /* renamed from: a */
        public static j m2233a(byte[] bArr) {
            return (j) new j().m2233a(bArr);
        }
    }

    /* renamed from: com.xiaomi.push.do$g */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class g extends AbstractC1574e {

        /* renamed from: a */
        private boolean f1442a;

        /* renamed from: b */
        private boolean f1444b;

        /* renamed from: c */
        private boolean f1446c;

        /* renamed from: a */
        private String f1441a = "";

        /* renamed from: b */
        private String f1443b = "";

        /* renamed from: c */
        private String f1445c = "";

        /* renamed from: a */
        private int f1440a = -1;

        /* renamed from: a */
        public String m2214a() {
            return this.f1441a;
        }

        /* renamed from: a */
        public boolean m2215a() {
            return this.f1442a;
        }

        /* renamed from: a */
        public g m2213a(String str) {
            this.f1442a = true;
            this.f1441a = str;
            return this;
        }

        /* renamed from: b */
        public String m2217b() {
            return this.f1443b;
        }

        /* renamed from: b */
        public boolean m2218b() {
            return this.f1444b;
        }

        /* renamed from: b */
        public g m2216b(String str) {
            this.f1444b = true;
            this.f1443b = str;
            return this;
        }

        /* renamed from: c */
        public String m2220c() {
            return this.f1445c;
        }

        /* renamed from: c */
        public boolean m2221c() {
            return this.f1446c;
        }

        /* renamed from: c */
        public g m2219c(String str) {
            this.f1446c = true;
            this.f1445c = str;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public void mo2066a(C1520c c1520c) {
            if (m2215a()) {
                c1520c.m1756a(1, m2214a());
            }
            if (m2218b()) {
                c1520c.m1756a(2, m2217b());
            }
            if (m2221c()) {
                c1520c.m1756a(3, m2220c());
            }
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public int mo2060a() {
            if (this.f1440a < 0) {
                mo2068b();
            }
            return this.f1440a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: b */
        public int mo2068b() {
            int m1730a = m2215a() ? 0 + C1520c.m1730a(1, m2214a()) : 0;
            if (m2218b()) {
                m1730a += C1520c.m1730a(2, m2217b());
            }
            if (m2221c()) {
                m1730a += C1520c.m1730a(3, m2220c());
            }
            this.f1440a = m1730a;
            return m1730a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public g mo2062a(C1493b c1493b) {
            while (true) {
                int m1603a = c1493b.m1603a();
                if (m1603a == 0) {
                    return this;
                }
                if (m1603a == 10) {
                    m2213a(c1493b.m1607a());
                } else if (m1603a == 18) {
                    m2216b(c1493b.m1607a());
                } else if (m1603a != 26) {
                    if (!m2337a(c1493b, m1603a)) {
                        return this;
                    }
                } else {
                    m2219c(c1493b.m1607a());
                }
            }
        }

        /* renamed from: a */
        public static g m2212a(byte[] bArr) {
            return (g) new g().m2212a(bArr);
        }
    }

    /* renamed from: com.xiaomi.push.do$k */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class k extends AbstractC1574e {

        /* renamed from: a */
        private boolean f1463a;

        /* renamed from: b */
        private boolean f1467b;

        /* renamed from: c */
        private boolean f1468c;

        /* renamed from: d */
        private boolean f1469d;

        /* renamed from: e */
        private boolean f1470e;

        /* renamed from: g */
        private boolean f1472g;

        /* renamed from: a */
        private String f1462a = "";

        /* renamed from: b */
        private String f1466b = "";

        /* renamed from: a */
        private long f1461a = 0;

        /* renamed from: b */
        private long f1465b = 0;

        /* renamed from: f */
        private boolean f1471f = false;

        /* renamed from: a */
        private int f1460a = 0;

        /* renamed from: b */
        private int f1464b = -1;

        /* renamed from: a */
        public String m2246a() {
            return this.f1462a;
        }

        /* renamed from: a */
        public boolean m2247a() {
            return this.f1463a;
        }

        /* renamed from: a */
        public k m2244a(String str) {
            this.f1463a = true;
            this.f1462a = str;
            return this;
        }

        /* renamed from: b */
        public String m2251b() {
            return this.f1466b;
        }

        /* renamed from: b */
        public boolean m2252b() {
            return this.f1467b;
        }

        /* renamed from: b */
        public k m2250b(String str) {
            this.f1467b = true;
            this.f1466b = str;
            return this;
        }

        /* renamed from: a */
        public long m2241a() {
            return this.f1461a;
        }

        /* renamed from: c */
        public boolean m2254c() {
            return this.f1468c;
        }

        /* renamed from: a */
        public k m2243a(long j) {
            this.f1468c = true;
            this.f1461a = j;
            return this;
        }

        /* renamed from: b */
        public long m2248b() {
            return this.f1465b;
        }

        /* renamed from: d */
        public boolean m2255d() {
            return this.f1469d;
        }

        /* renamed from: b */
        public k m2249b(long j) {
            this.f1469d = true;
            this.f1465b = j;
            return this;
        }

        /* renamed from: e */
        public boolean m2256e() {
            return this.f1471f;
        }

        /* renamed from: f */
        public boolean m2257f() {
            return this.f1470e;
        }

        /* renamed from: a */
        public k m2245a(boolean z) {
            this.f1470e = true;
            this.f1471f = z;
            return this;
        }

        /* renamed from: c */
        public int m2253c() {
            return this.f1460a;
        }

        /* renamed from: g */
        public boolean m2258g() {
            return this.f1472g;
        }

        /* renamed from: a */
        public k m2242a(int i) {
            this.f1472g = true;
            this.f1460a = i;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public void mo2066a(C1520c c1520c) {
            if (m2247a()) {
                c1520c.m1756a(1, m2246a());
            }
            if (m2252b()) {
                c1520c.m1756a(2, m2251b());
            }
            if (m2254c()) {
                c1520c.m1753a(3, m2241a());
            }
            if (m2255d()) {
                c1520c.m1753a(4, m2248b());
            }
            if (m2257f()) {
                c1520c.m1757a(5, m2256e());
            }
            if (m2258g()) {
                c1520c.m1752a(6, m2253c());
            }
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public int mo2060a() {
            if (this.f1464b < 0) {
                mo2068b();
            }
            return this.f1464b;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: b */
        public int mo2068b() {
            int m1730a = m2247a() ? 0 + C1520c.m1730a(1, m2246a()) : 0;
            if (m2252b()) {
                m1730a += C1520c.m1730a(2, m2251b());
            }
            if (m2254c()) {
                m1730a += C1520c.m1727a(3, m2241a());
            }
            if (m2255d()) {
                m1730a += C1520c.m1727a(4, m2248b());
            }
            if (m2257f()) {
                m1730a += C1520c.m1731a(5, m2256e());
            }
            if (m2258g()) {
                m1730a += C1520c.m1726a(6, m2253c());
            }
            this.f1464b = m1730a;
            return m1730a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public k mo2062a(C1493b c1493b) {
            while (true) {
                int m1603a = c1493b.m1603a();
                if (m1603a == 0) {
                    return this;
                }
                if (m1603a == 10) {
                    m2244a(c1493b.m1607a());
                } else if (m1603a == 18) {
                    m2250b(c1493b.m1607a());
                } else if (m1603a == 24) {
                    m2243a(c1493b.m1605a());
                } else if (m1603a == 32) {
                    m2249b(c1493b.m1605a());
                } else if (m1603a == 40) {
                    m2245a(c1493b.m1611a());
                } else if (m1603a != 48) {
                    if (!m2337a(c1493b, m1603a)) {
                        return this;
                    }
                } else {
                    m2242a(c1493b.m1614b());
                }
            }
        }

        /* renamed from: a */
        public static k m2240a(byte[] bArr) {
            return (k) new k().m2240a(bArr);
        }
    }

    /* renamed from: com.xiaomi.push.do$i */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class i extends AbstractC1574e {

        /* renamed from: a */
        private boolean f1454a;

        /* renamed from: a */
        private C1466a f1453a = C1466a.f916a;

        /* renamed from: a */
        private int f1452a = -1;

        /* renamed from: a */
        public C1466a m2230a() {
            return this.f1453a;
        }

        /* renamed from: a */
        public boolean m2232a() {
            return this.f1454a;
        }

        /* renamed from: a */
        public i m2231a(C1466a c1466a) {
            this.f1454a = true;
            this.f1453a = c1466a;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public void mo2066a(C1520c c1520c) {
            if (m2232a()) {
                c1520c.m1754a(1, m2230a());
            }
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public int mo2060a() {
            if (this.f1452a < 0) {
                mo2068b();
            }
            return this.f1452a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: b */
        public int mo2068b() {
            int m1728a = m2232a() ? 0 + C1520c.m1728a(1, m2230a()) : 0;
            this.f1452a = m1728a;
            return m1728a;
        }

        @Override // com.xiaomi.push.AbstractC1574e
        /* renamed from: a */
        public i mo2062a(C1493b c1493b) {
            while (true) {
                int m1603a = c1493b.m1603a();
                if (m1603a == 0) {
                    return this;
                }
                if (m1603a != 10) {
                    if (!m2337a(c1493b, m1603a)) {
                        return this;
                    }
                } else {
                    m2231a(c1493b.m1606a());
                }
            }
        }

        /* renamed from: a */
        public static i m2229a(byte[] bArr) {
            return (i) new i().m2229a(bArr);
        }
    }
}
