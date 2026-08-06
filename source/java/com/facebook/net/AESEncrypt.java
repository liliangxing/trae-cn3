package com.facebook.net;

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
import okhttp3.internal.Util;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AESEncrypt {
    private static final String CIPHER_ALGORITHM = "AES/CFB/NoPadding";
    private static final String KEY_ALGORITHM = "AES";
    private static final int MAGIC_LENGTH = 16;
    private static final String TAG = "AESEncrypt";

    public static SecretKeySpec getSecretKey(String str) {
        return new SecretKeySpec(str.getBytes(Util.UTF_8), KEY_ALGORITHM);
    }

    public static byte[] decrypt(byte[] bArr, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        SecretKeySpec secretKey = getSecretKey(str);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        int blockSize = cipher.getBlockSize() + 16;
        IvParameterSpec ivParameterSpec = new IvParameterSpec(Arrays.copyOfRange(bArr, 16, blockSize));
        byte[] copyOfRange = Arrays.copyOfRange(bArr, blockSize, bArr.length);
        cipher.init(2, secretKey, ivParameterSpec);
        return cipher.doFinal(copyOfRange);
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
