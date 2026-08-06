package com.facebook.net;

import android.util.Base64;
import com.facebook.common.logging.FLog;
import com.ss.android.update.UpdateDialogNewBase;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes6.dex */
public class EncryptUtil {
    public static final String ANDROID_TRANSFORMATION = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    public static final int MAX_DECRYPT_SIZE = 1000;
    public static final int MAX_ENCRYPT_SIZE = 1000;
    private static final String TAG = "EncryptUtil";

    public static String encryptByPublicKey(String str, String str2) {
        try {
            try {
                return Base64.encodeToString(encryptByPublicKey(str2.getBytes(), (RSAPublicKey) getPublicKey(str)), 2);
            } catch (Exception e) {
                FLog.d(TAG, "encryptByPublicKey:2 Exception = " + e);
                e.printStackTrace();
                return "";
            }
        } catch (Exception e2) {
            FLog.d(TAG, "encryptByPublicKey:getPublicKey exception = " + e2);
            e2.printStackTrace();
            return "";
        }
    }

    public static PublicKey getPublicKey(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replace("-----BEGIN RSA PUBLIC KEY-----", "").replace("-----END RSA PUBLIC KEY-----", "").replace(UpdateDialogNewBase.TYPE, ""), 0)));
    }

    public static byte[] encryptByPublicKey(byte[] bArr, RSAPublicKey rSAPublicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ANDROID_TRANSFORMATION);
        cipher.init(1, rSAPublicKey);
        int outputSize = cipher.getOutputSize(bArr.length);
        byte[] bArr2 = new byte[outputSize];
        FLog.e(TAG, "encryptByPublicKey: data.len = " + bArr.length + " outLen = " + outputSize);
        int length = bArr.length / 1000;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int update = cipher.update(bArr, i, 1000, bArr2, i2);
            FLog.e(TAG, "encryptByPublicKey: outLen = " + update + " inLen = 1000");
            i += 1000;
            i2 += update;
        }
        if (i <= bArr.length) {
            cipher.update(bArr, i, bArr.length - i, bArr2, i2);
        }
        return cipher.doFinal();
    }
}
