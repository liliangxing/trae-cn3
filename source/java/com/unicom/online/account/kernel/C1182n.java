package com.unicom.online.account.kernel;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.unicom.online.account.kernel.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1182n {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static byte[] m543a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        if (bArr == null || bArr.length != 16) {
            throw new C1183o(EnumC1178j.E10410);
        }
        if (bArr3 == null) {
            throw new C1183o(EnumC1178j.E10400);
        }
        if (bArr2 == null) {
            throw new C1183o(EnumC1178j.E10411);
        }
        int length = bArr3.length;
        if (i == 1) {
            if (length <= 0) {
                throw new C1183o(EnumC1178j.E10408);
            }
        } else if (length <= 0 || bArr3.length % 16 != 0) {
            throw new C1183o(EnumC1178j.E10409);
        }
        if (bArr2.length != 16) {
            throw new C1183o(EnumC1178j.E10411);
        }
        new SecretKeySpec(bArr, "SM4");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        try {
            Cipher cipher = Cipher.getInstance("SM4/CBC/PKCS5Padding", "BC");
            cipher.init(i, new SecretKeySpec(bArr, "SM4"), ivParameterSpec);
            return cipher.doFinal(bArr3);
        } catch (Exception e) {
            if (i == 1) {
                throw new C1183o(EnumC1178j.E10204, e);
            }
            throw new C1183o(EnumC1178j.E10205, e);
        }
    }
}
