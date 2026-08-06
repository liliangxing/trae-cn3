package com.huawei.secure.android.common.encrypt.aes;

import com.huawei.secure.android.common.encrypt.utils.C1290b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CipherUtil {

    /* renamed from: a */
    private static final String f1979a = "CipherUtil";

    /* renamed from: b */
    private static final String f1980b = "AES/GCM/NoPadding";

    /* renamed from: c */
    private static final String f1981c = "AES/CBC/PKCS5Padding";

    /* renamed from: d */
    private static final String f1982d = "AES";

    /* renamed from: e */
    private static final String f1983e = "";

    /* renamed from: f */
    private static final int f1984f = 16;

    /* renamed from: g */
    private static final int f1985g = 12;

    /* renamed from: h */
    private static final int f1986h = 16;

    /* renamed from: a */
    private static Cipher m2252a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2 != null && bArr2.length >= 16) {
            return m2253a(bArr, bArr2, i, f1981c);
        }
        C1290b.m2316b(f1979a, "cbc iv param is not right");
        return null;
    }

    /* renamed from: b */
    private static Cipher m2254b(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2 != null && bArr2.length >= 12) {
            return m2253a(bArr, bArr2, i, f1980b);
        }
        C1290b.m2316b(f1979a, "gcm iv param is not right");
        return null;
    }

    public static Cipher getAesCbcDecryptCipher(byte[] bArr, Cipher cipher) {
        return getAesCbcDecryptCipher(bArr, cipher.getIV());
    }

    public static Cipher getAesCbcEncryptCipher(byte[] bArr) {
        return getAesCbcEncryptCipher(bArr, EncryptUtil.generateSecureRandom(16));
    }

    public static int getAesCbcEncryptContentLen(byte[] bArr, byte[] bArr2) {
        return getAesCbcEncryptContentLen(bArr, bArr2, EncryptUtil.generateSecureRandom(16));
    }

    public static Cipher getAesGcmDecryptCipher(byte[] bArr, Cipher cipher) {
        return getAesGcmDecryptCipher(bArr, cipher.getIV());
    }

    public static Cipher getAesGcmEncryptCipher(byte[] bArr) {
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(12);
        C1290b.m2314a(f1979a, "getEncryptCipher: iv is : " + HexUtil.byteArray2HexStr(generateSecureRandom));
        return getAesGcmEncryptCipher(bArr, generateSecureRandom);
    }

    public static int getAesGcmEncryptContentLen(byte[] bArr, byte[] bArr2) {
        return getAesGcmEncryptContentLen(bArr, bArr2, EncryptUtil.generateSecureRandom(12));
    }

    public static int getContent(Cipher cipher, byte[] bArr, byte[] bArr2) {
        if (cipher != null && bArr != null) {
            try {
                return cipher.doFinal(bArr, 0, bArr.length, bArr2);
            } catch (BadPaddingException unused) {
                C1290b.m2316b(f1979a, "getContent: BadPaddingException");
                return -1;
            } catch (IllegalBlockSizeException unused2) {
                C1290b.m2316b(f1979a, "getContent: IllegalBlockSizeException");
                return -1;
            } catch (ShortBufferException unused3) {
                C1290b.m2316b(f1979a, "getContent: ShortBufferException");
                return -1;
            }
        }
        C1290b.m2316b(f1979a, "getEncryptCOntent: cipher is null or content is null");
        return -1;
    }

    public static Cipher getAesCbcDecryptCipher(byte[] bArr, byte[] bArr2) {
        return m2252a(bArr, bArr2, 2);
    }

    public static Cipher getAesCbcEncryptCipher(byte[] bArr, byte[] bArr2) {
        return m2252a(bArr, bArr2, 1);
    }

    public static int getAesCbcEncryptContentLen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return m2251a(getAesCbcEncryptCipher(bArr2, bArr3), bArr);
    }

    public static Cipher getAesGcmDecryptCipher(byte[] bArr, byte[] bArr2) {
        return m2254b(bArr, bArr2, 2);
    }

    public static int getAesGcmEncryptContentLen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return m2251a(getAesGcmEncryptCipher(bArr2, bArr3), bArr);
    }

    public static Cipher getAesGcmEncryptCipher(byte[] bArr, byte[] bArr2) {
        return m2254b(bArr, bArr2, 1);
    }

    /* renamed from: a */
    private static Cipher m2253a(byte[] bArr, byte[] bArr2, int i, String str) {
        AlgorithmParameterSpec ivParameterSpec;
        if (bArr != null && bArr.length >= 16 && AesGcm.isBuildVersionHigherThan19()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f1982d);
                Cipher cipher = Cipher.getInstance(str);
                if (f1980b.equals(str)) {
                    ivParameterSpec = AesGcm.getGcmAlgorithmParams(bArr2);
                } else {
                    ivParameterSpec = new IvParameterSpec(bArr2);
                }
                cipher.init(i, secretKeySpec, ivParameterSpec);
                return cipher;
            } catch (GeneralSecurityException e) {
                C1290b.m2316b(f1979a, "GCM encrypt data error" + e.getMessage());
                return null;
            }
        }
        C1290b.m2316b(f1979a, "gcm encrypt param is not right");
        return null;
    }

    @Deprecated
    public static int getContent(Cipher cipher, byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        if (cipher != null && bArr != null) {
            return cipher.doFinal(bArr, i, i2, bArr2, i3);
        }
        C1290b.m2316b(f1979a, "getEncryptCOntent: cipher is null or content is null");
        return -1;
    }

    public static int getContent(CipherConfig cipherConfig) throws IllegalBlockSizeException, ShortBufferException, BadPaddingException {
        if (cipherConfig == null) {
            return -1;
        }
        return getContent(cipherConfig.getCipher(), cipherConfig.getInput(), cipherConfig.getInputOffset(), cipherConfig.getInputLen(), cipherConfig.getOutput(), cipherConfig.getOutputOffset());
    }

    public static byte[] getContent(Cipher cipher, byte[] bArr) {
        if (cipher != null && bArr != null) {
            try {
                return cipher.doFinal(bArr, 0, bArr.length);
            } catch (BadPaddingException unused) {
                C1290b.m2316b(f1979a, "getContent: BadPaddingException");
                return new byte[0];
            } catch (IllegalBlockSizeException unused2) {
                C1290b.m2316b(f1979a, "getContent: IllegalBlockSizeException");
                return new byte[0];
            }
        }
        C1290b.m2316b(f1979a, "getEncryptCOntent: cipher is null or content is null");
        return new byte[0];
    }

    /* renamed from: a */
    private static int m2251a(Cipher cipher, byte[] bArr) {
        if (cipher == null || bArr == null) {
            return -1;
        }
        return cipher.getOutputSize(bArr.length);
    }
}
