package com.facebook.imagepipeline.cache;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
public class ImageDiskEncryptUtils {
    private static final String CIPHER_ALGORITHM = "AES/GCM/NoPadding";
    private static final String KEY_ALGORITHM = "AES";
    private static String key = "79e93ec548d39875969ea47be01345cc794f55626fd116f9b6cf4e5c77d313e4";
    private static byte[] nonce = {1, 2, 3, 2, 1, 8, 1, 2, 4, 3, 1, 2};

    public static byte[] encryptByte(InputStream inputStream) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        byte[] readFromRawInput = readFromRawInput(inputStream);
        byte[] bArr = toByte(key);
        byte[] copyOfRange = Arrays.copyOfRange(readFromRawInput, 0, readFromRawInput.length);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(nonce);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(1, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(copyOfRange);
    }

    public static byte[] decryptBytes(InputStream inputStream) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        byte[] readFromRawInput = readFromRawInput(inputStream);
        byte[] bArr = toByte(key);
        byte[] copyOfRange = Arrays.copyOfRange(readFromRawInput, 0, readFromRawInput.length);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(nonce);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(copyOfRange);
    }

    private static byte[] toByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    private static byte[] readFromRawInput(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
