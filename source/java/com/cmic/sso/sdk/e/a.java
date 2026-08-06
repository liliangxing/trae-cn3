package com.cmic.sso.sdk.e;

import android.util.Base64;
import com.bytedance.platform.godzilla.common.Constant;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESUtils.java */
/* loaded from: classes6.dex */
public class a {
    public static String a(byte[] bArr, String str, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
            return Base64.encodeToString(cipher.doFinal(str.getBytes(Constant.CHARSET_UTF_8)), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(byte[] bArr, String str, byte[] bArr2) {
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return new String(cipher.doFinal(decode), Constant.CHARSET_UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
