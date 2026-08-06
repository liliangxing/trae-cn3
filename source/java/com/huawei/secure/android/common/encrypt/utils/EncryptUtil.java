package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;
import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.prng.SP800SecureRandomBuilder;

/* loaded from: classes6.dex */
public class EncryptUtil {
    private static final String a = "EncryptUtil";
    private static final String b = "RSA";
    private static boolean c = true;
    private static boolean d = true;

    /* JADX WARN: Removed duplicated region for block: B:19:0x001b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static SecureRandom a() {
        SecureRandom secureRandom;
        b.a(a, "generateSecureRandomNew ");
        try {
        } catch (NoSuchAlgorithmException unused) {
            b.b(a, "getSecureRandomBytes: NoSuchAlgorithmException");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            secureRandom = SecureRandom.getInstanceStrong();
            if (secureRandom == null) {
                try {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG");
                } catch (NoSuchAlgorithmException unused2) {
                    b.b(a, "NoSuchAlgorithmException");
                    return secureRandom;
                } catch (Throwable th) {
                    if (d) {
                        b.b(a, "exception : " + th.getMessage() + " , you should implementation bcprov-jdk15on library");
                        d = false;
                    }
                    return secureRandom;
                }
            }
            AESEngine aESEngine = new AESEngine();
            byte[] bArr = new byte[32];
            secureRandom.nextBytes(bArr);
            return new SP800SecureRandomBuilder(secureRandom, true).setEntropyBitsRequired(384).buildCTR(aESEngine, 256, bArr, false);
        }
        secureRandom = null;
        if (secureRandom == null) {
        }
        AESEngine aESEngine2 = new AESEngine();
        byte[] bArr2 = new byte[32];
        secureRandom.nextBytes(bArr2);
        return new SP800SecureRandomBuilder(secureRandom, true).setEntropyBitsRequired(384).buildCTR(aESEngine2, 256, bArr2, false);
    }

    public static SecureRandom genSecureRandom() {
        SecureRandom secureRandom;
        if (!c) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    secureRandom = SecureRandom.getInstanceStrong();
                } else {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG");
                }
                return secureRandom;
            } catch (NoSuchAlgorithmException unused) {
                b.b(a, "genSecureRandom: NoSuchAlgorithmException");
                return null;
            }
        }
        return a();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x001b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] generateSecureRandom(int i) {
        SecureRandom secureRandom;
        if (!c) {
            byte[] bArr = new byte[i];
            try {
            } catch (NoSuchAlgorithmException unused) {
                b.b(a, "getSecureRandomBytes: NoSuchAlgorithmException");
            }
            if (Build.VERSION.SDK_INT >= 26) {
                secureRandom = SecureRandom.getInstanceStrong();
                if (secureRandom == null) {
                    try {
                        secureRandom = SecureRandom.getInstance("SHA1PRNG");
                    } catch (NoSuchAlgorithmException unused2) {
                        b.b(a, "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                        return new byte[0];
                    } catch (Exception e) {
                        b.b(a, "getSecureRandomBytes getInstance: exception : " + e.getMessage());
                        return new byte[0];
                    }
                }
                secureRandom.nextBytes(bArr);
                return bArr;
            }
            secureRandom = null;
            if (secureRandom == null) {
            }
            secureRandom.nextBytes(bArr);
            return bArr;
        }
        return a(i);
    }

    public static String generateSecureRandomStr(int i) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i));
    }

    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance(b).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                b.b(a, "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.b(a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e2) {
            b.b(a, "base64 decode Exception" + e2.getMessage());
            return null;
        }
    }

    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(b).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                b.b(a, "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.b(a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e2) {
            b.b(a, "base64 decode Exception" + e2.getMessage());
            return null;
        }
    }

    public static boolean isBouncycastleFlag() {
        return c;
    }

    public static void setBouncycastleFlag(boolean z) {
        b.c(a, "setBouncycastleFlag: " + z);
        c = z;
    }

    private static byte[] a(int i) {
        SecureRandom a2 = a();
        if (a2 == null) {
            return new byte[0];
        }
        try {
            byte[] bArr = new byte[i];
            a2.nextBytes(bArr);
            return bArr;
        } catch (NullPointerException e) {
            b.b(a, "secureRandom nextBytes error is : " + e.getMessage());
            return new byte[0];
        }
    }
}
