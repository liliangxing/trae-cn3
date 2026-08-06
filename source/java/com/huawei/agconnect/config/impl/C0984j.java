package com.huawei.agconnect.config.impl;

import android.util.Log;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.huawei.agconnect.config.impl.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0984j {
    /* renamed from: a */
    public static SecretKey m816a(C0978d c0978d) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (c0978d == null || !c0978d.m800a()) {
            throw new IllegalArgumentException("invalid data for generating the key.");
        }
        Log.d("AGC_Keys", "build aes key, iterationCount:" + c0978d.m806g());
        SecretKey generateSecret = SecretKeyFactory.getInstance(c0978d.m805f()).generateSecret(new PBEKeySpec(Hex.encodeHexString(m820a(Hex.decodeHexString(c0978d.m801b()), Hex.decodeHexString(c0978d.m802c()), Hex.decodeHexString(c0978d.m803d()))).toCharArray(), Hex.decodeHexString(c0978d.m804e()), c0978d.m806g(), c0978d.m807h() * 8));
        Log.d("AGC_Keys", "build aes key end");
        return new SecretKeySpec(generateSecret.getEncoded(), "AES");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static byte[] m817a(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        if (secretKey == null || bArr == null) {
            throw new NullPointerException("key or cipherText must not be null.");
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 1, 17);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKey, new IvParameterSpec(copyOfRange));
        return cipher.doFinal(bArr, copyOfRange.length + 1, (bArr.length - copyOfRange.length) - 1);
    }

    /* renamed from: a */
    private static byte[] m818a(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("bytes must not be null.");
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (i < 0) {
                bArr[i2] = (byte) (bArr[i2] << (-i));
            } else {
                bArr[i2] = (byte) (bArr[i2] >> i);
            }
        }
        return bArr;
    }

    /* renamed from: a */
    private static byte[] m819a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            throw new NullPointerException("left or right must not be null.");
        }
        if (bArr.length != bArr2.length) {
            throw new IllegalArgumentException("left and right must be the same length.");
        }
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    /* renamed from: a */
    public static byte[] m820a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return m819a(m818a(m819a(m818a(bArr, -4), bArr2), 6), bArr3);
    }
}
