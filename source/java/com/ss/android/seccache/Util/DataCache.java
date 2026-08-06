package com.ss.android.seccache.Util;

import android.util.Base64;
import com.ss.android.seccache.KeystoreImpl;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes7.dex */
public class DataCache {
    private static final String AES_MODE_M_OR_GREATER = "AES/GCM/NoPadding";
    private static final String ENCODE = "UTF-8";
    private static final int IV_LENGTH_BYTES = 12;
    private static final String RANDOM_ALGORITHM = "SHA1PRNG";
    private static final String TAG = "DataCache";

    public static String encryptString(String str) throws Exception {
        return Base64.encodeToString(encrypt(str.getBytes("UTF-8")), 0);
    }

    public static String decryptString(String str, String str2) throws Exception {
        return new String(decrypt(Base64.decode(str, 2)));
    }

    private static byte[] encrypt(byte[] bArr) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_MODE_M_OR_GREATER);
        byte[] generateIv = generateIv();
        cipher.init(1, KeystoreImpl.INSTANCE.getSecretKeyAPIMorGreater(), new GCMParameterSpec(128, generateIv));
        byte[] doFinal = cipher.doFinal(bArr);
        ByteBuffer allocate = ByteBuffer.allocate(generateIv.length + 4 + doFinal.length);
        allocate.putInt(generateIv.length);
        allocate.put(generateIv);
        allocate.put(doFinal);
        return allocate.array();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] generateIv() throws GeneralSecurityException {
        byte[] bArr = new byte[12];
        SecureRandom.getInstance(RANDOM_ALGORITHM).nextBytes(bArr);
        return bArr;
    }

    static byte[] decrypt(byte[] bArr) throws Exception {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        int i = wrap.getInt();
        if (i < 12 || i >= 16) {
            throw new IllegalArgumentException("invalid iv length");
        }
        byte[] bArr2 = new byte[i];
        wrap.get(bArr2);
        byte[] bArr3 = new byte[wrap.remaining()];
        wrap.get(bArr3);
        Cipher cipher = Cipher.getInstance(AES_MODE_M_OR_GREATER);
        cipher.init(2, KeystoreImpl.INSTANCE.getSecretKeyAPIMorGreater(), new GCMParameterSpec(128, bArr2));
        return cipher.doFinal(bArr3);
    }
}
