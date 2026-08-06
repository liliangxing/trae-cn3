package com.ss.android.deviceregister.core.cache.internal;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.SecureRandom;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* loaded from: classes7.dex */
public final class EncryptUtils {
    private static String key;

    public static byte[] encrypt(String str, String str2) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        Key key2 = toKey(str2.getBytes());
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(1, key2, secureRandom);
        return Base64.encode(cipher.doFinal(str.getBytes("UTF-8")), 0);
    }

    public static String decrypt(byte[] bArr, String str) throws Exception {
        byte[] decode = Base64.decode(bArr, 0);
        SecureRandom secureRandom = new SecureRandom();
        Key key2 = toKey(str.getBytes());
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(2, key2, secureRandom);
        return new String(cipher.doFinal(decode), "UTF-8");
    }

    private static Key toKey(byte[] bArr) throws Exception {
        return SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr));
    }

    private static String byte2String(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; bArr != null && i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i] & UByte.MAX_VALUE);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static byte[] str2Byte(String str) throws NumberFormatException {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) Integer.parseInt(new String(bytes, i, 2), 16);
        }
        return bArr;
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

    public static String[] genRandomKeyAndIv() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom();
            keyGenerator.init(128, secureRandom);
            byte[] bArr = new byte[8];
            secureRandom.nextBytes(bArr);
            String[] strArr = {byte2String(keyGenerator.generateKey().getEncoded()), byte2String(bArr)};
            if (isValidKeyIv(strArr)) {
                return strArr;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isValidKeyIv(String[] strArr) {
        return strArr != null && strArr.length == 2 && !TextUtils.isEmpty(strArr[0]) && strArr[0].length() == 32 && !TextUtils.isEmpty(strArr[1]) && strArr[1].length() == 16;
    }

    private static byte[] transStrCharToByte(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static byte[] decryptAesCbc(byte[] bArr, String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            cipher.init(2, new SecretKeySpec(transStrCharToByte(str), "AES"), new IvParameterSpec(transStrCharToByte(str2)));
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:
    
        if (r2 == null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] gzipUncompress(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2 = null;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            } catch (IOException unused) {
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream = null;
            }
        } catch (IOException unused2) {
            byteArrayInputStream = null;
        } catch (Throwable th3) {
            byteArrayInputStream = null;
            th = th3;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException unused3) {
                    }
                }
            }
            gZIPInputStream.close();
        } catch (IOException unused4) {
            gZIPInputStream2 = gZIPInputStream;
            if (gZIPInputStream2 != null) {
                try {
                    gZIPInputStream2.close();
                } catch (IOException unused5) {
                }
            }
        } catch (Throwable th4) {
            th = th4;
            if (gZIPInputStream != null) {
                try {
                    gZIPInputStream.close();
                } catch (IOException unused6) {
                }
            }
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                    throw th;
                } catch (IOException unused7) {
                    throw th;
                }
            }
            throw th;
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException unused8) {
            return byteArrayOutputStream.toByteArray();
        }
    }
}
