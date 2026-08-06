package com.ss.android.token;

import android.os.Build;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class RSAUtils {
    private static String RSA = "RSA";
    private static String RSA_PKCS1 = "RSA/ECB/PKCS1Padding";

    public static KeyPair generateRSAKeyPair() {
        return generateRSAKeyPair(1024);
    }

    public static KeyPair generateRSAKeyPair(int i) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
            keyPairGenerator.initialize(i);
            return keyPairGenerator.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            TTTokenMonitor.monitorError(e);
            return null;
        }
    }

    public static byte[] encryptData(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_PKCS1);
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            TTTokenMonitor.monitorError(e);
            return null;
        }
    }

    public static byte[] decryptData(byte[] bArr, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_PKCS1);
            cipher.init(2, privateKey);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            TTTokenMonitor.monitorError(e);
            return null;
        }
    }

    public static PublicKey getPublicKey(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(RSA).generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static PrivateKey getPrivateKey(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(RSA).generatePrivate(new PKCS8EncodedKeySpec(bArr));
    }

    public static PublicKey getPublicKey(String str, String str2) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(RSA).generatePublic(new RSAPublicKeySpec(new BigInteger(str), new BigInteger(str2)));
    }

    public static PrivateKey getPrivateKey(String str, String str2) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(RSA).generatePrivate(new RSAPublicKeySpec(new BigInteger(str), new BigInteger(str2)));
    }

    public static PublicKey loadPublicKey(String str) throws Exception {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("key data is null");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("no such algorithm");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("invalid keySpec");
        }
    }

    public static PrivateKey loadPrivateKey(String str) throws Exception {
        KeyFactory keyFactory;
        try {
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decode(str, 0));
            if (Build.VERSION.SDK_INT >= 28) {
                keyFactory = KeyFactory.getInstance("RSA");
            } else {
                keyFactory = KeyFactory.getInstance("RSA", "BC");
            }
            return (RSAPrivateKey) keyFactory.generatePrivate(pKCS8EncodedKeySpec);
        } catch (NullPointerException unused) {
            throw new Exception("key data is null");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("no such algorithm");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("invalid key spec");
        }
    }

    private static String readKey(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.charAt(0) != '-') {
                        sb.append(readLine);
                        sb.append('\r');
                    }
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader2.close();
                } catch (Exception e) {
                    TTTokenMonitor.monitorError(e);
                    e.printStackTrace();
                }
                return sb2;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e2) {
                        TTTokenMonitor.monitorError(e2);
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void printPublicKeyInfo(PublicKey publicKey) {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) publicKey;
        System.out.println("----------RSAPublicKey----------");
        System.out.println("Modulus.length=" + rSAPublicKey.getModulus().bitLength());
        System.out.println("Modulus=" + rSAPublicKey.getModulus().toString());
        System.out.println("PublicExponent.length=" + rSAPublicKey.getPublicExponent().bitLength());
        System.out.println("PublicExponent=" + rSAPublicKey.getPublicExponent().toString());
    }

    public static void printPrivateKeyInfo(PrivateKey privateKey) {
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) privateKey;
        System.out.println("----------RSAPrivateKey ----------");
        System.out.println("Modulus.length=" + rSAPrivateKey.getModulus().bitLength());
        System.out.println("Modulus=" + rSAPrivateKey.getModulus().toString());
        System.out.println("PrivateExponent.length=" + rSAPrivateKey.getPrivateExponent().bitLength());
        System.out.println("PrivatecExponent=" + rSAPrivateKey.getPrivateExponent().toString());
    }

    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static String byteArrayToHex(byte[] bArr) {
        char[] charArray = "0123456789abcdef".toCharArray();
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr[i3] = charArray[i2 >>> 4];
            cArr[i3 + 1] = charArray[i2 & 15];
        }
        return new String(cArr);
    }
}
