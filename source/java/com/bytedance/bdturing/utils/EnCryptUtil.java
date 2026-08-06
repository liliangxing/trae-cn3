package com.bytedance.bdturing.utils;

import android.util.Base64;
import android.util.Pair;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import org.bouncycastle.math.ec.Tnaf;

/* loaded from: classes3.dex */
public class EnCryptUtil {
    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final byte[] HEADER_BYTES = {116, 99, 6, Tnaf.POW_2_WIDTH, 0, 0};
    private static final int RANDOM_KEY_LEN = 32;
    private static final String RANDOM_STR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int TAG_LENGTH_BIT = 128;

    public static String aesEncrypt(String str, String str2) {
        try {
            String randomKey = getRandomKey();
            Pair<byte[], byte[]> aesIvAndKey = getAesIvAndKey(randomKey, str2);
            SecretKeySpec secretKeySpec = new SecretKeySpec((byte[]) aesIvAndKey.second, "AES");
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, (byte[]) aesIvAndKey.first);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(1, secretKeySpec, gCMParameterSpec);
            byte[] sha512 = sha512(str);
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            ByteBuffer allocate = ByteBuffer.allocate(sha512.length + bytes.length);
            allocate.put(sha512);
            allocate.put(bytes);
            byte[] doFinal = cipher.doFinal(allocate.array());
            byte[] bytes2 = randomKey.getBytes(StandardCharsets.UTF_8);
            byte[] bArr = HEADER_BYTES;
            ByteBuffer allocate2 = ByteBuffer.allocate(bArr.length + bytes2.length + doFinal.length);
            allocate2.put(bArr);
            allocate2.put(bytes2);
            allocate2.put(doFinal);
            return Base64.encodeToString(allocate2.array(), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Pair<byte[], byte[]> getAesIvAndKey(String str, String str2) {
        byte[] sha512 = sha512(str);
        byte[] hexStrToByteArray = hexStrToByteArray(str2);
        ByteBuffer allocate = ByteBuffer.allocate(sha512.length + hexStrToByteArray.length);
        allocate.put(sha512).put(hexStrToByteArray);
        byte[] sha5122 = sha512(allocate.array());
        byte[] bArr = new byte[32];
        byte[] bArr2 = new byte[12];
        for (int i = 0; i < 44; i++) {
            if (i < 32) {
                bArr[i] = sha5122[i];
            } else {
                bArr2[i - 32] = sha5122[i];
            }
        }
        return new Pair<>(bArr2, bArr);
    }

    private static byte[] sha512(String str) {
        try {
            return MessageDigest.getInstance("SHA-512").digest(str.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] sha512(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-512").digest(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString().toLowerCase();
    }

    private static byte[] hexStrToByteArray(String str) {
        byte[] bArr;
        int length = str.length();
        if (length % 2 == 1) {
            length++;
            bArr = new byte[length / 2];
            str = "0" + str;
        } else {
            bArr = new byte[length / 2];
        }
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i, i3), 16);
            i2++;
            i = i3;
        }
        return bArr;
    }

    private static String getRandomKey() {
        char[] charArray = RANDOM_STR.toCharArray();
        char[] cArr = new char[32];
        for (int i = 0; i < 32; i++) {
            cArr[i] = charArray[Math.min((int) (Math.random() * charArray.length), charArray.length - 1)];
        }
        return new String(cArr);
    }

    public static String getMD5Hex(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
