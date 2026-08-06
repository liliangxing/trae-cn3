package com.bytedance.ttnet.utils;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class RsaDecoder {
    private static final String PUB_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQwuhlG2hSvAH1pxaCawFQTHQPEa+MLm0muwhkPd6hCTxmodQOCTbwWzaZazk8GDtV4AwBAM8jIeHP7z9bYxmZeT/lKjgvbplEWURevOQ4O6rYahjL8i4vyf431ocW+POx+kQbJ8Tr4EAuqjEUmP2nw6WUQ6/hMjQv/CS6SfqpEQIDAQAB";

    public static String decodeSign(String str) throws Throwable {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(PUB_KEY, 0)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, generatePublic);
        return new String(cipher.doFinal(Base64.decode(str, 0)));
    }

    public static byte[] encode(byte[] bArr) throws Throwable {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(PUB_KEY, 0)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }

    public static byte[] aesEncrpt(byte[] bArr, String str) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec);
        byte[] doFinal = cipher.doFinal(str.getBytes("UTF-8"));
        byte[] bArr2 = new byte[doFinal.length + 16];
        System.arraycopy(cipher.getIV(), 0, bArr2, 0, 16);
        System.arraycopy(doFinal, 0, bArr2, 16, doFinal.length);
        return bArr2;
    }
}
