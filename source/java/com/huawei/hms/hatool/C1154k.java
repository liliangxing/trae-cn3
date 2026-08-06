package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1154k extends C1181u0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.hatool.k$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f1492a;

        static {
            int[] iArr = new int[EnumC1134d0.values().length];
            f1492a = iArr;
            try {
                iArr[EnumC1134d0.SN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1492a[EnumC1134d0.IMEI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1492a[EnumC1134d0.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: a */
    protected static C1140f0 m1584a(String str, String str2, String str3, String str4) {
        C1140f0 m1769a = C1181u0.m1769a(str, str2, str3, str4);
        String m1566a = C1151j.m1564a().m1566a(AbstractC1126a1.m1416c(str2, str3));
        long currentTimeMillis = System.currentTimeMillis();
        String sha256Encrypt = SHA.sha256Encrypt(AbstractC1173q0.m1701f() + m1566a + currentTimeMillis);
        m1769a.m1594f(String.valueOf(currentTimeMillis));
        m1769a.m1499g(sha256Encrypt);
        return m1769a;
    }

    /* renamed from: a */
    public static C1147h1 m1585a(List<C1129b1> list, String str, String str2, String str3, String str4) {
        C1147h1 m1772b = C1181u0.m1772b(str, str2);
        if (m1772b == null) {
            return null;
        }
        m1772b.m1552a(m1584a(C1162m1.m1631d().m1632a(), str, str2, str3));
        m1772b.m1553a(m1586a(str, str2));
        m1772b.m1554a(m1587a(str2, str, str4));
        m1772b.m1555a(AbstractC1126a1.m1420g(str, str2));
        m1772b.m1556a(list);
        return m1772b;
    }

    /* renamed from: a */
    protected static C1157l m1586a(String str, String str2) {
        C1157l m1770a = C1181u0.m1770a(str, str2);
        C1148i m1569c = C1151j.m1564a().m1569c(str, str2);
        m1770a.m1607g(C1151j.m1564a().m1566a(AbstractC1126a1.m1416c(str, str2)));
        m1770a.m1606f(AbstractC1126a1.m1428o(str, str2));
        m1770a.m1603c(C1151j.m1564a().m1572f(str, str2));
        int i = a.f1492a[m1569c.m1557a().ordinal()];
        if (i == 1) {
            m1770a.m1604d(m1569c.m1558b());
        } else if (i == 2) {
            m1770a.m1602b(m1569c.m1558b());
        } else if (i == 3) {
            m1770a.m1605e(m1569c.m1558b());
        }
        return m1770a;
    }

    /* renamed from: a */
    protected static C1189y0 m1587a(String str, String str2, String str3) {
        C1189y0 m1771a = C1181u0.m1771a(str, str2, str3);
        Pair<String, String> m1571e = C1151j.m1564a().m1571e(str2, str);
        m1771a.m1814f((String) m1571e.first);
        m1771a.m1815g((String) m1571e.second);
        m1771a.m1816h(AbstractC1166o.m1657b());
        m1771a.m1765d(C1151j.m1564a().m1570d(str2, str));
        return m1771a;
    }

    /* renamed from: b */
    public static Map<String, String> m1588b(String str, String str2, String str3) {
        Map<String, String> m1773c = C1181u0.m1773c(str, str3);
        Map<String, String> m1422i = AbstractC1126a1.m1422i(str, str2);
        if (m1422i == null) {
            return m1773c;
        }
        m1773c.putAll(m1422i);
        return m1773c;
    }
}
