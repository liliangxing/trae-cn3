package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.huawei.secure.android.common.encrypt.utils.C1290b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class AesGcm {

    /* renamed from: a */
    private static final String f1965a = "security:";

    /* renamed from: b */
    private static final String f1966b = "AES/GCM/NoPadding";

    /* renamed from: c */
    private static final String f1967c = "AES";

    /* renamed from: d */
    private static final String f1968d = "GCM";

    /* renamed from: e */
    private static final String f1969e = "";

    /* renamed from: f */
    private static final int f1970f = 16;

    /* renamed from: g */
    private static final int f1971g = 12;

    /* renamed from: h */
    private static final int f1972h = 2;

    private AesGcm() {
    }

    /* renamed from: a */
    private static byte[] m2246a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C1290b.m2316b(f1968d, "encrypt 5 content is null");
            return new byte[0];
        }
        if (bArr == null) {
            C1290b.m2316b(f1968d, "encrypt 5 key is null");
            return new byte[0];
        }
        if (bArr.length < 16) {
            C1290b.m2316b(f1968d, "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr2 == null) {
            C1290b.m2316b(f1968d, "encrypt 5 iv is null");
            return new byte[0];
        }
        if (bArr2.length < 12) {
            C1290b.m2316b(f1968d, "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!isBuildVersionHigherThan19()) {
            C1290b.m2316b(f1968d, "encrypt 5 build version not higher than 19");
            return new byte[0];
        }
        try {
            return encrypt(str.getBytes(Utf8Charset.NAME), bArr, bArr2);
        } catch (UnsupportedEncodingException e) {
            C1290b.m2316b(f1968d, "GCM encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: b */
    private static byte[] m2249b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 12];
        System.arraycopy(bArr, 12, bArr2, 0, bArr.length - 12);
        return bArr2;
    }

    /* renamed from: c */
    private static byte[] m2250c(byte[] bArr) {
        if (bArr != null && bArr.length >= 12) {
            byte[] bArr2 = new byte[12];
            System.arraycopy(bArr, 0, bArr2, 0, 12);
            return bArr2;
        }
        C1290b.m2316b(f1968d, "getIV error: bt length less than 12 bytes.");
        return new byte[0];
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C1290b.m2316b(f1968d, "decrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C1290b.m2316b(f1968d, "decrypt 1 key is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C1290b.m2316b(f1968d, "decrypt 1 build version not higher than 19");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length < 16) {
            C1290b.m2316b(f1968d, "decrypt 1 key error: 1 key length less than 16 bytes.");
            return "";
        }
        return decrypt(str, hexStr2ByteArray);
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String m2241c = AesCbc.m2241c(str);
            if ("".equals(m2241c)) {
                return "";
            }
            int indexOf = m2241c.indexOf(58);
            if (indexOf >= 0) {
                return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(m2241c.substring(indexOf + 1))), bArr, HexUtil.hexStr2ByteArray(m2241c.substring(0, indexOf)));
            }
            C1290b.m2316b(f1968d, " gcm cipherText data missing colon");
        }
        return "";
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] m2243d = AesCbc.m2243d(bArr);
        if (m2243d.length == 0) {
            return new byte[0];
        }
        int m2244a = m2244a(m2243d);
        if (m2244a >= 0) {
            byte[] copyOf = Arrays.copyOf(m2243d, m2244a);
            int length = (m2243d.length - copyOf.length) - 1;
            byte[] bArr3 = new byte[length];
            System.arraycopy(m2243d, m2244a + 1, bArr3, 0, length);
            return decrypt(bArr3, bArr2, copyOf);
        }
        C1290b.m2316b(f1968d, " gcm cipherText data missing colon");
        return new byte[0];
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C1290b.m2316b(f1968d, "encrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C1290b.m2316b(f1968d, "encrypt 1 key is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C1290b.m2316b(f1968d, "encrypt 1 build version not higher than 19");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length < 16) {
            C1290b.m2316b(f1968d, "encrypt key error: key length less than 16 bytes.");
            return "";
        }
        return encrypt(str, hexStr2ByteArray);
    }

    public static boolean isBuildVersionHigherThan19() {
        return true;
    }

    /* renamed from: b */
    private static String m2248b(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        C1290b.m2316b(f1968d, "IV is invalid.");
        return "";
    }

    public static AlgorithmParameterSpec getGcmAlgorithmParams(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }

    public static String decrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            C1290b.m2316b(f1968d, "decrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            C1290b.m2316b(f1968d, "decrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C1290b.m2316b(f1968d, "decrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C1290b.m2316b(f1968d, "decrypt 2 build version not higher than 19");
            return "";
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f1967c);
            Cipher cipher = Cipher.getInstance(f1966b);
            String m2248b = m2248b(str);
            String m2245a = m2245a(str);
            if (TextUtils.isEmpty(m2248b)) {
                C1290b.m2316b(f1968d, "decrypt 2 iv is null");
                return "";
            }
            if (TextUtils.isEmpty(m2245a)) {
                C1290b.m2316b(f1968d, "decrypt 2 encrypt content is null");
                return "";
            }
            cipher.init(2, secretKeySpec, getGcmAlgorithmParams(HexUtil.hexStr2ByteArray(m2248b)));
            return new String(cipher.doFinal(HexUtil.hexStr2ByteArray(m2245a)), Utf8Charset.NAME);
        } catch (UnsupportedEncodingException | NullPointerException | GeneralSecurityException e) {
            C1290b.m2316b(f1968d, "GCM decrypt data exception: " + e.getMessage());
            return "";
        }
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new String(decryptWithCryptHeadReturnByte(bArr, bArr2), Utf8Charset.NAME);
        } catch (UnsupportedEncodingException unused) {
            C1290b.m2316b(f1968d, "UnsupportedEncodingException");
            return "";
        }
    }

    public static String encrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            C1290b.m2316b(f1968d, "encrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            C1290b.m2316b(f1968d, "encrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C1290b.m2316b(f1968d, "encrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C1290b.m2316b(f1968d, "encrypt 2 build version not higher than 19");
            return "";
        }
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(12);
        byte[] m2246a = m2246a(str, bArr, generateSecureRandom);
        if (m2246a == null || m2246a.length == 0) {
            return "";
        }
        return HexUtil.byteArray2HexStr(generateSecureRandom) + HexUtil.byteArray2HexStr(m2246a);
    }

    /* renamed from: a */
    private static byte[] m2247a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* renamed from: a */
    private static String m2245a(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    /* renamed from: a */
    private static int m2244a(byte[] bArr) {
        return bArr[12] == 58 ? 12 : -1;
    }

    public static String encrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            C1290b.m2316b(f1968d, "encrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C1290b.m2316b(f1968d, "encrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            C1290b.m2316b(f1968d, "encrypt 3 iv is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C1290b.m2316b(f1968d, "encrypt 3 build version not higher than 19");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length < 16) {
            C1290b.m2316b(f1968d, "encrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (hexStr2ByteArray2.length < 12) {
            C1290b.m2316b(f1968d, "encrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return encrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
    }

    public static String decrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            C1290b.m2316b(f1968d, "decrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C1290b.m2316b(f1968d, "decrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            C1290b.m2316b(f1968d, "decrypt 3 iv is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C1290b.m2316b(f1968d, "decrypt 3 build version not higher than 19");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length < 16) {
            C1290b.m2316b(f1968d, "decrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (hexStr2ByteArray2.length < 12) {
            C1290b.m2316b(f1968d, "decrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return decrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C1290b.m2316b(f1968d, "encrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            C1290b.m2316b(f1968d, "encrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C1290b.m2316b(f1968d, "encrypt 4 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            C1290b.m2316b(f1968d, "encrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 12) {
            C1290b.m2316b(f1968d, "encrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C1290b.m2316b(f1968d, "encrypt 4 build version not higher than 19");
            return "";
        }
        return HexUtil.byteArray2HexStr(m2246a(str, bArr, bArr2));
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C1290b.m2316b(f1968d, "decrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            C1290b.m2316b(f1968d, "decrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C1290b.m2316b(f1968d, "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            C1290b.m2316b(f1968d, "decrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 12) {
            C1290b.m2316b(f1968d, "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C1290b.m2316b(f1968d, "decrypt 4 build version not higher than 19");
            return "";
        }
        try {
            return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), Utf8Charset.NAME);
        } catch (UnsupportedEncodingException e) {
            C1290b.m2316b(f1968d, "GCM decrypt data exception: " + e.getMessage());
            return "";
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            C1290b.m2316b(f1968d, "encrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            C1290b.m2316b(f1968d, "encrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            C1290b.m2316b(f1968d, "encrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            C1290b.m2316b(f1968d, "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            C1290b.m2316b(f1968d, "encrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 12) {
            C1290b.m2316b(f1968d, "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!isBuildVersionHigherThan19()) {
            C1290b.m2316b(f1968d, "encrypt 6 build version not higher than 19");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f1967c);
            Cipher cipher = Cipher.getInstance(f1966b);
            cipher.init(1, secretKeySpec, getGcmAlgorithmParams(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e) {
            C1290b.m2316b(f1968d, "GCM encrypt data error" + e.getMessage());
            return new byte[0];
        } catch (GeneralSecurityException e2) {
            C1290b.m2316b(f1968d, "GCM encrypt data error" + e2.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            C1290b.m2316b(f1968d, "decrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            C1290b.m2316b(f1968d, "decrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            C1290b.m2316b(f1968d, "decrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            C1290b.m2316b(f1968d, "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            C1290b.m2316b(f1968d, "decrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 12) {
            C1290b.m2316b(f1968d, "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!isBuildVersionHigherThan19()) {
            C1290b.m2316b(f1968d, "decrypt 6 build version not higher than 19");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f1967c);
            Cipher cipher = Cipher.getInstance(f1966b);
            cipher.init(2, secretKeySpec, getGcmAlgorithmParams(bArr3));
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            C1290b.m2316b(f1968d, "GCM decrypt data exception: " + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(12);
        return m2247a(generateSecureRandom, encrypt(bArr, bArr2, generateSecureRandom));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        byte[] m2250c = m2250c(bArr);
        if (m2250c.length < 12) {
            C1290b.m2316b(f1968d, "get iv from content error.");
            return new byte[0];
        }
        return decrypt(m2249b(bArr), bArr2, m2250c);
    }
}
