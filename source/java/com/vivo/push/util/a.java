package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import com.bytedance.platform.godzilla.common.Constant;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESParseManager.java */
/* loaded from: classes7.dex */
public class a {
    private static volatile a c;
    private byte[] a;
    private byte[] b;

    private a(Context context) {
        ad.c().a(ContextDelegate.getContext(context));
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                synchronized (a.class) {
                    if (c == null) {
                        c = new a(context.getApplicationContext());
                    }
                }
            }
            aVar = c;
        }
        return aVar;
    }

    public final String a(String str) throws Exception {
        String a = j.a(a());
        String a2 = j.a(b());
        byte[] decode = Base64.decode(str, 2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(a2.getBytes(Constant.CHARSET_UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(a.getBytes(Constant.CHARSET_UTF_8)));
        return new String(cipher.doFinal(decode), Constant.CHARSET_UTF_8);
    }

    private synchronized byte[] a() {
        byte[] bArr = this.a;
        if (bArr == null || bArr.length <= 0) {
            this.a = ad.c().d();
        }
        return this.a;
    }

    private synchronized byte[] b() {
        byte[] bArr = this.b;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] e = ad.c().e();
        this.b = e;
        return e;
    }
}
