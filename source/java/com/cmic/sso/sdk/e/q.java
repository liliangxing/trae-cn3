package com.cmic.sso.sdk.e;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.security.SecureRandom;
import java.util.UUID;

/* compiled from: UmcUtils.java */
/* loaded from: classes6.dex */
public class q {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = a;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static byte[] a() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static String b() {
        return UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public static String c() {
        return d().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    private static String d() {
        return UUID.randomUUID().toString();
    }

    public static void a(com.cmic.sso.sdk.a aVar, String str) {
        if (TextUtils.isEmpty(aVar.b("interfaceType", ""))) {
            aVar.a("interfaceType", str);
        } else {
            aVar.a("interfaceType", aVar.b("interfaceType") + ";" + str);
        }
    }

    public static void b(com.cmic.sso.sdk.a aVar, String str) {
        if (TextUtils.isEmpty(aVar.b("interfaceCode", ""))) {
            aVar.a("interfaceCode", str);
        } else {
            aVar.a("interfaceCode", aVar.b("interfaceCode") + ";" + str);
        }
    }

    public static void c(com.cmic.sso.sdk.a aVar, String str) {
        if (TextUtils.isEmpty(aVar.b("interfaceElasped", ""))) {
            aVar.a("interfaceElasped", str);
        } else {
            aVar.a("interfaceElasped", aVar.b("interfaceElasped") + ";" + str);
        }
    }

    public static boolean a(com.cmic.sso.sdk.a.a aVar) {
        return k.a("logCloseTime", 0L) + ((long) (((aVar.l() * 60) * 60) * 1000)) >= System.currentTimeMillis();
    }
}
