package com.xiaomi.push;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.xiaomi.push.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1655h {

    /* renamed from: a */
    private static final byte[] f2427a = {100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32};

    /* renamed from: a */
    public static byte[] m3006a(byte[] bArr, byte[] bArr2) {
        return m3005a(bArr, 2).doFinal(bArr2);
    }

    /* renamed from: b */
    public static byte[] m3007b(byte[] bArr, byte[] bArr2) {
        return m3005a(bArr, 1).doFinal(bArr2);
    }

    /* renamed from: a */
    private static Cipher m3005a(byte[] bArr, int i) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f2427a);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i, secretKeySpec, ivParameterSpec);
        return cipher;
    }
}
