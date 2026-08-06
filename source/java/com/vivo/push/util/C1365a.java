package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESParseManager.java */
/* renamed from: com.vivo.push.util.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1365a {

    /* renamed from: c */
    private static volatile C1365a f645c;

    /* renamed from: a */
    private byte[] f646a;

    /* renamed from: b */
    private byte[] f647b;

    private C1365a(Context context) {
        C1369ad.m941c().m944a(ContextDelegate.getContext(context));
    }

    /* renamed from: a */
    public static synchronized C1365a m920a(Context context) {
        C1365a c1365a;
        synchronized (C1365a.class) {
            if (f645c == null) {
                synchronized (C1365a.class) {
                    if (f645c == null) {
                        f645c = new C1365a(context.getApplicationContext());
                    }
                }
            }
            c1365a = f645c;
        }
        return c1365a;
    }

    /* renamed from: a */
    public final String m923a(String str) throws Exception {
        String m1004a = C1383j.m1004a(m921a());
        String m1004a2 = C1383j.m1004a(m922b());
        byte[] decode = Base64.decode(str, 2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(m1004a2.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(m1004a.getBytes("utf-8")));
        return new String(cipher.doFinal(decode), "utf-8");
    }

    /* renamed from: a */
    private synchronized byte[] m921a() {
        byte[] bArr = this.f646a;
        if (bArr == null || bArr.length <= 0) {
            this.f646a = C1369ad.m941c().m945d();
        }
        return this.f646a;
    }

    /* renamed from: b */
    private synchronized byte[] m922b() {
        byte[] bArr = this.f647b;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] m946e = C1369ad.m941c().m946e();
        this.f647b = m946e;
        return m946e;
    }
}
