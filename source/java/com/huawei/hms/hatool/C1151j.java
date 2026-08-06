package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.UUID;

/* renamed from: com.huawei.hms.hatool.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1151j {

    /* renamed from: b */
    private static C1151j f1478b;

    /* renamed from: a */
    private Context f1479a;

    /* renamed from: com.huawei.hms.hatool.j$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class a extends AbstractC1137e0 {

        /* renamed from: a */
        String f1480a;

        /* renamed from: b */
        String f1481b;

        public a(String str, String str2) {
            this.f1480a = str;
            this.f1481b = str2;
        }

        @Override // com.huawei.hms.hatool.AbstractC1137e0
        /* renamed from: a */
        public String mo1486a() {
            return AbstractC1190z.m1820d(this.f1480a, this.f1481b);
        }

        @Override // com.huawei.hms.hatool.AbstractC1137e0
        /* renamed from: a */
        public String mo1487a(String str) {
            return SHA.sha256Encrypt(str);
        }

        @Override // com.huawei.hms.hatool.AbstractC1137e0
        /* renamed from: b */
        public String mo1488b() {
            return AbstractC1190z.m1823g(this.f1480a, this.f1481b);
        }

        @Override // com.huawei.hms.hatool.AbstractC1137e0
        /* renamed from: c */
        public String mo1489c() {
            return AbstractC1190z.m1826j(this.f1480a, this.f1481b);
        }

        @Override // com.huawei.hms.hatool.AbstractC1137e0
        /* renamed from: d */
        public int mo1490d() {
            return (AbstractC1190z.m1827k(this.f1480a, this.f1481b) ? 4 : 0) | 0 | (AbstractC1190z.m1821e(this.f1480a, this.f1481b) ? 2 : 0) | (AbstractC1190z.m1824h(this.f1480a, this.f1481b) ? 1 : 0);
        }
    }

    /* renamed from: a */
    public static C1151j m1564a() {
        C1151j c1151j;
        synchronized (C1151j.class) {
            if (f1478b == null) {
                f1478b = new C1151j();
            }
            c1151j = f1478b;
        }
        return c1151j;
    }

    /* renamed from: a */
    public String m1565a(String str, String str2) {
        return AbstractC1149i0.m1559a(this.f1479a, str, str2);
    }

    /* renamed from: a */
    public String m1566a(boolean z) {
        if (!z) {
            return "";
        }
        String m1699e = AbstractC1173q0.m1699e();
        if (TextUtils.isEmpty(m1699e)) {
            m1699e = C1133d.m1464a(this.f1479a, "global_v2", "uuid", "");
            if (TextUtils.isEmpty(m1699e)) {
                m1699e = UUID.randomUUID().toString().replace("-", "");
                C1133d.m1469b(this.f1479a, "global_v2", "uuid", m1699e);
            }
            AbstractC1173q0.m1706h(m1699e);
        }
        return m1699e;
    }

    /* renamed from: a */
    public void m1567a(Context context) {
        if (this.f1479a == null) {
            this.f1479a = context;
        }
    }

    /* renamed from: b */
    public String m1568b(String str, String str2) {
        return AbstractC1149i0.m1560b(this.f1479a, str, str2);
    }

    /* renamed from: c */
    public C1148i m1569c(String str, String str2) {
        return new a(str, str2).m1485a(this.f1479a);
    }

    /* renamed from: d */
    public String m1570d(String str, String str2) {
        return AbstractC1141f1.m1501b(str, str2);
    }

    /* renamed from: e */
    public Pair<String, String> m1571e(String str, String str2) {
        if (!AbstractC1190z.m1822f(str, str2)) {
            return new Pair<>("", "");
        }
        String m1541p = C1176s.m1722c().m1727b().m1541p();
        String m1543q = C1176s.m1722c().m1727b().m1543q();
        if (!TextUtils.isEmpty(m1541p) && !TextUtils.isEmpty(m1543q)) {
            return new Pair<>(m1541p, m1543q);
        }
        Pair<String, String> m1809e = C1187x0.m1809e(this.f1479a);
        C1176s.m1722c().m1727b().m1532k((String) m1809e.first);
        C1176s.m1722c().m1727b().m1534l((String) m1809e.second);
        return m1809e;
    }

    /* renamed from: f */
    public String m1572f(String str, String str2) {
        return AbstractC1141f1.m1500a(str, str2);
    }
}
