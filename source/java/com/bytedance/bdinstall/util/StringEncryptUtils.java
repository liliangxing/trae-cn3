package com.bytedance.bdinstall.util;

import android.text.TextUtils;
import android.util.Base64;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class StringEncryptUtils {
    private static final String SHA_256 = "SHA-256";
    private static final String iv = "NIfb&95GUY86Gfgh";
    private static String key;

    public static String encryptBySHA256(String str) {
        return encrypt(str, "SHA-256");
    }

    public static String encrypt(String str, String str2) {
        byte[] bytes = str.getBytes();
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = "SHA-256";
            }
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(bytes);
            return bytes2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException | Exception unused) {
            return null;
        }
    }

    private static String bytes2Hex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] encryptAES(String str, String str2) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr = new byte[length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            cipher.init(1, new SecretKeySpec(str2.getBytes(), "AES"), new IvParameterSpec(iv.getBytes()));
            return Base64.encode(cipher.doFinal(bArr), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptAES(byte[] bArr, String str) throws Exception {
        try {
            byte[] decode = Base64.decode(bArr, 0);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, new SecretKeySpec(str.getBytes(), "AES"), new IvParameterSpec(iv.getBytes()));
            return new String(cipher.doFinal(decode)).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Key toKey(byte[] bArr) throws Exception {
        return SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr));
    }

    public static String getBytedanceString() {
        if (TextUtils.isEmpty(key)) {
            key = base64DecodeToString("Ynl0ZWRhbmNl");
        }
        return key;
    }

    public static String base64DecodeToString(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (Exception unused) {
            return "";
        }
    }
}
