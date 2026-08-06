package com.ss.android.seccache.Util;

import android.util.Log;
import com.ss.android.seccache.KeystoreImpl;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes7.dex */
public class DiskCache {
    private static final String AES_MODE_M_OR_GREATER = "AES/GCM/NoPadding";
    private static final String ENCRYPT_SUFFIX = "_en";
    private static final int IV_LENGTH_BYTES = 12;
    private static final String TAG = "DiskCache";

    public static boolean encryptFile(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            String str2 = str + ENCRYPT_SUFFIX;
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            byte[] generateIv = DataCache.generateIv();
            fileOutputStream.write(generateIv, 0, generateIv.length);
            Cipher cipher = Cipher.getInstance(AES_MODE_M_OR_GREATER);
            cipher.init(1, KeystoreImpl.INSTANCE.getSecretKeyAPIMorGreater(), new GCMParameterSpec(128, generateIv));
            CipherInputStream cipherInputStream = new CipherInputStream(fileInputStream, cipher);
            while (true) {
                int read = cipherInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            cipherInputStream.close();
            fileInputStream.close();
            fileOutputStream.close();
            if (!new File(str2).renameTo(new File(str))) {
                Log.e(TAG, "rename file failed");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] decryptFile(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[12];
            fileInputStream.read(bArr, 0, 12);
            Cipher cipher = Cipher.getInstance(AES_MODE_M_OR_GREATER);
            cipher.init(2, KeystoreImpl.INSTANCE.getSecretKeyAPIMorGreater(), new GCMParameterSpec(128, bArr));
            CipherInputStream cipherInputStream = new CipherInputStream(fileInputStream, cipher);
            byte[] readInputStream = readInputStream(cipherInputStream);
            cipherInputStream.close();
            fileInputStream.close();
            return readInputStream;
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static InputStream decryptFile2Stream(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[12];
            fileInputStream.read(bArr, 0, 12);
            Cipher cipher = Cipher.getInstance(AES_MODE_M_OR_GREATER);
            cipher.init(2, KeystoreImpl.INSTANCE.getSecretKeyAPIMorGreater(), new GCMParameterSpec(128, bArr));
            return new CipherInputStream(fileInputStream, cipher);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
