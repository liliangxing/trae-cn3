package com.huawei.hms.hatool;

import com.heytap.mcssdk.constant.C0878a;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* renamed from: com.huawei.hms.hatool.m1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1162m1 {

    /* renamed from: b */
    private static C1162m1 f1519b = new C1162m1();

    /* renamed from: a */
    private a f1520a = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.hatool.m1$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class a {

        /* renamed from: a */
        String f1521a;

        /* renamed from: b */
        String f1522b;

        /* renamed from: c */
        long f1523c = 0;

        a() {
        }

        /* renamed from: a */
        void m1636a(long j) {
            C1162m1.this.f1520a.f1523c = j;
        }

        /* renamed from: a */
        void m1637a(String str) {
            C1162m1.this.f1520a.f1522b = str;
        }

        /* renamed from: b */
        void m1638b(String str) {
            C1162m1.this.f1520a.f1521a = str;
        }
    }

    /* renamed from: d */
    public static C1162m1 m1631d() {
        return f1519b;
    }

    /* renamed from: a */
    public String m1632a() {
        return this.f1520a.f1522b;
    }

    /* renamed from: a */
    public void m1633a(String str, String str2) {
        long m1634b = m1634b();
        String m1796c = C1185w0.m1796c(str, str2);
        if (m1796c == null || m1796c.isEmpty()) {
            C1182v.m1785e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (m1634b == 0) {
            m1634b = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - m1634b <= C0878a.f521g) {
            return;
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        String m1548a = C1146h0.m1548a(m1796c, generateSecureRandomStr);
        this.f1520a.m1636a(m1634b);
        this.f1520a.m1638b(generateSecureRandomStr);
        this.f1520a.m1637a(m1548a);
    }

    /* renamed from: b */
    public long m1634b() {
        return this.f1520a.f1523c;
    }

    /* renamed from: c */
    public String m1635c() {
        return this.f1520a.f1521a;
    }
}
