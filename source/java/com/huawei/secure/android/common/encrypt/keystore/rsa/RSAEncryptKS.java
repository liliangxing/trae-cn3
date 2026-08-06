package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* loaded from: classes6.dex */
public abstract class RSAEncryptKS {
    private static final String a = "RSAEncryptKS";
    private static final String b = "AndroidKeyStore";
    private static final String c = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    private static final String d = "";
    private static final int e = 2048;
    private static final int f = 3072;

    private static boolean a() {
        return true;
    }

    private static PublicKey b(String str, boolean z) {
        if (!b(str)) {
            a(str, z);
        }
        Certificate c2 = c(str);
        if (c2 != null) {
            return c2.getPublicKey();
        }
        return null;
    }

    private static Certificate c(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.getCertificate(str);
        } catch (IOException e2) {
            b.b(a, "IOException: " + e2.getMessage());
            return null;
        } catch (KeyStoreException e3) {
            b.b(a, "KeyStoreException: " + e3.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e4) {
            b.b(a, "NoSuchAlgorithmException: " + e4.getMessage());
            return null;
        } catch (CertificateException e5) {
            b.b(a, "CertificateException: " + e5.getMessage());
            return null;
        } catch (Exception e6) {
            b.b(a, "Exception: " + e6.getMessage());
            return null;
        }
    }

    @Deprecated
    public static String decrpyt(String str, String str2) {
        try {
            return new String(decrpyt(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            b.b(a, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        } catch (Exception e3) {
            b.b(a, "Exception: " + e3.getMessage());
            return "";
        }
    }

    public static String decrpytNew(String str, String str2) {
        try {
            return new String(decrpytNew(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            b.b(a, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        } catch (Exception e3) {
            b.b(a, "Exception: " + e3.getMessage());
            return "";
        }
    }

    @Deprecated
    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encrypt(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e2) {
            b.b(a, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        }
    }

    public static String encryptNew(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encryptNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e2) {
            b.b(a, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        }
    }

    private static byte[] a(String str, byte[] bArr, boolean z) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(a, "sdk version is too low");
                return bArr2;
            }
            PublicKey b2 = b(str, z);
            if (b2 == null) {
                b.b(a, "Public key is null");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
                cipher.init(1, b2, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e2) {
                b.b(a, "InvalidAlgorithmParameterException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                b.b(a, "InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e4) {
                b.b(a, "NoSuchAlgorithmException: " + e4.getMessage());
                return bArr2;
            } catch (BadPaddingException e5) {
                b.b(a, "BadPaddingException: " + e5.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e6) {
                b.b(a, "IllegalBlockSizeException: " + e6.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e7) {
                b.b(a, "NoSuchPaddingException: " + e7.getMessage());
                return bArr2;
            } catch (Exception e8) {
                b.b(a, "Exception: " + e8.getMessage());
                return bArr2;
            }
        }
        b.b(a, "alias or content is null");
        return bArr2;
    }

    @Deprecated
    public static byte[] encrypt(String str, byte[] bArr) {
        return a(str, bArr, false);
    }

    public static byte[] encryptNew(String str, byte[] bArr) {
        return a(str, bArr, true);
    }

    private static boolean b(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.getKey(str, null) != null;
        } catch (IOException e2) {
            b.b(a, "IOException: " + e2.getMessage());
            return false;
        } catch (KeyStoreException e3) {
            b.b(a, "KeyStoreException: " + e3.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e4) {
            b.b(a, "NoSuchAlgorithmException: " + e4.getMessage());
            return false;
        } catch (UnrecoverableKeyException e5) {
            b.b(a, "UnrecoverableKeyException: " + e5.getMessage());
            return false;
        } catch (CertificateException e6) {
            b.b(a, "CertificateException: " + e6.getMessage());
            return false;
        } catch (Exception e7) {
            b.b(a, "Exception: " + e7.getMessage());
            return false;
        }
    }

    public static byte[] decrpytNew(String str, byte[] bArr) {
        return decrpyt(str, bArr);
    }

    @Deprecated
    public static byte[] decrpyt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(a, "sdk version is too low");
                return bArr2;
            }
            PrivateKey a2 = a(str);
            if (a2 == null) {
                b.b(a, "Private key is null");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
                cipher.init(2, a2, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e2) {
                b.b(a, "InvalidAlgorithmParameterException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                b.b(a, "InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e4) {
                b.b(a, "NoSuchAlgorithmException: " + e4.getMessage());
                return bArr2;
            } catch (BadPaddingException e5) {
                b.b(a, "BadPaddingException: " + e5.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e6) {
                b.b(a, "IllegalBlockSizeException: " + e6.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e7) {
                b.b(a, "NoSuchPaddingException: " + e7.getMessage());
                return bArr2;
            } catch (Exception e8) {
                b.b(a, "Exception: " + e8.getMessage());
                return bArr2;
            }
        }
        b.b(a, "alias or encrypted content is null");
        return bArr2;
    }

    private static synchronized KeyPair a(String str, boolean z) {
        synchronized (RSAEncryptKS.class) {
            KeyPair keyPair = null;
            if (b(str)) {
                b.b(a, "Key pair exits");
                return null;
            }
            b.c(a, "generate key pair.");
            try {
                try {
                    try {
                        try {
                            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                            if (!z) {
                                keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("OAEPPadding").setKeySize(2048).build());
                            } else {
                                keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("OAEPPadding").setKeySize(f).build());
                            }
                            keyPair = keyPairGenerator.generateKeyPair();
                        } catch (NoSuchProviderException e2) {
                            b.b(a, "NoSuchProviderException: " + e2.getMessage());
                        }
                    } catch (NoSuchAlgorithmException e3) {
                        b.b(a, "NoSuchAlgorithmException: " + e3.getMessage());
                    }
                } catch (InvalidAlgorithmParameterException e4) {
                    b.b(a, "InvalidAlgorithmParameterException: " + e4.getMessage());
                }
            } catch (Exception e5) {
                b.b(a, "Exception: " + e5.getMessage());
            }
            return keyPair;
        }
    }

    private static PrivateKey a(String str) {
        if (!b(str)) {
            return null;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return (PrivateKey) keyStore.getKey(str, null);
        } catch (IOException e2) {
            b.b(a, "IOException: " + e2.getMessage());
            return null;
        } catch (KeyStoreException e3) {
            b.b(a, "KeyStoreException: " + e3.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e4) {
            b.b(a, "NoSuchAlgorithmException: " + e4.getMessage());
            return null;
        } catch (UnrecoverableKeyException e5) {
            b.b(a, "UnrecoverableKeyException: " + e5.getMessage());
            return null;
        } catch (CertificateException e6) {
            b.b(a, "CertificateException: " + e6.getMessage());
            return null;
        } catch (Exception e7) {
            b.b(a, "Exception: " + e7.getMessage());
            return null;
        }
    }
}
