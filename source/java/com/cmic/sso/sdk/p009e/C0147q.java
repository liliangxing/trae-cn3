package com.cmic.sso.sdk.p009e;

import android.text.TextUtils;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.p001a.C0089a;
import java.security.SecureRandom;
import java.util.UUID;

/* compiled from: UmcUtils.java */
/* renamed from: com.cmic.sso.sdk.e.q */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0147q {

    /* renamed from: a */
    private static final char[] f336a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m395a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f336a;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static byte[] m398a() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    /* renamed from: b */
    public static String m399b() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /* renamed from: c */
    public static String m401c() {
        return m403d().replace("-", "");
    }

    /* renamed from: d */
    private static String m403d() {
        return UUID.randomUUID().toString();
    }

    /* renamed from: a */
    public static void m396a(C0088a c0088a, String str) {
        if (TextUtils.isEmpty(c0088a.m68b("interfaceType", ""))) {
            c0088a.m60a("interfaceType", str);
        } else {
            c0088a.m60a("interfaceType", c0088a.m67b("interfaceType") + ";" + str);
        }
    }

    /* renamed from: b */
    public static void m400b(C0088a c0088a, String str) {
        if (TextUtils.isEmpty(c0088a.m68b("interfaceCode", ""))) {
            c0088a.m60a("interfaceCode", str);
        } else {
            c0088a.m60a("interfaceCode", c0088a.m67b("interfaceCode") + ";" + str);
        }
    }

    /* renamed from: c */
    public static void m402c(C0088a c0088a, String str) {
        if (TextUtils.isEmpty(c0088a.m68b("interfaceElasped", ""))) {
            c0088a.m60a("interfaceElasped", str);
        } else {
            c0088a.m60a("interfaceElasped", c0088a.m67b("interfaceElasped") + ";" + str);
        }
    }

    /* renamed from: a */
    public static boolean m397a(C0089a c0089a) {
        return C0141k.m365a("logCloseTime", 0L) + ((long) (((c0089a.m94l() * 60) * 60) * 1000)) >= System.currentTimeMillis();
    }
}
