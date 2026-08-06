package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* renamed from: com.huawei.hms.hatool.o0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1167o0 {

    /* renamed from: c */
    private static C1167o0 f1528c;

    /* renamed from: a */
    private String f1529a;

    /* renamed from: b */
    private String f1530b;

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003b, code lost:
    
        if (m1668f() != false) goto L12;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String m1662a(String str) {
        String decrypt = m1668f() ? AesGcmKS.decrypt("analytics_keystore", str) : "";
        if (TextUtils.isEmpty(decrypt)) {
            C1182v.m1781c("hmsSdk", "deCrypt work key first");
            decrypt = C1163n.m1640a(str, m1667e());
            if (TextUtils.isEmpty(decrypt)) {
                decrypt = EncryptUtil.generateSecureRandomStr(16);
                m1665c(m1663b(decrypt));
            } else if (m1668f()) {
                m1665c(m1663b(decrypt));
                C1186x.m1805c();
            }
        }
        return decrypt;
    }

    /* renamed from: b */
    private String m1663b(String str) {
        return m1668f() ? AesGcmKS.encrypt("analytics_keystore", str) : C1163n.m1642b(str, m1667e());
    }

    /* renamed from: c */
    private String m1664c() {
        String m1464a = C1133d.m1464a(AbstractC1173q0.m1707i(), "Privacy_MY", "PrivacyData", "");
        if (!TextUtils.isEmpty(m1464a)) {
            return m1662a(m1464a);
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        m1665c(m1663b(generateSecureRandomStr));
        return generateSecureRandomStr;
    }

    /* renamed from: c */
    private boolean m1665c(String str) {
        C1182v.m1781c("hmsSdk", "refresh sp aes key");
        if (TextUtils.isEmpty(str)) {
            C1182v.m1781c("hmsSdk", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        C1133d.m1469b(AbstractC1173q0.m1707i(), "Privacy_MY", "PrivacyData", str);
        C1133d.m1468b(AbstractC1173q0.m1707i(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    /* renamed from: d */
    public static C1167o0 m1666d() {
        if (f1528c == null) {
            m1669g();
        }
        return f1528c;
    }

    /* renamed from: e */
    private String m1667e() {
        if (TextUtils.isEmpty(this.f1530b)) {
            this.f1530b = new C1186x().m1807a();
        }
        return this.f1530b;
    }

    /* renamed from: f */
    private boolean m1668f() {
        return true;
    }

    /* renamed from: g */
    private static synchronized void m1669g() {
        synchronized (C1167o0.class) {
            if (f1528c == null) {
                f1528c = new C1167o0();
            }
        }
    }

    /* renamed from: a */
    public String m1670a() {
        if (TextUtils.isEmpty(this.f1529a)) {
            this.f1529a = m1664c();
        }
        return this.f1529a;
    }

    /* renamed from: b */
    public void m1671b() {
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        if (m1665c(m1663b(generateSecureRandomStr))) {
            this.f1529a = generateSecureRandomStr;
        }
    }
}
