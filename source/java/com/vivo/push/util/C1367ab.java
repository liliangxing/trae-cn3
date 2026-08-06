package com.vivo.push.util;

import android.util.Base64;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: RSAUtils.java */
/* renamed from: com.vivo.push.util.ab */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1367ab {

    /* renamed from: a */
    private static String f650a = "RSA";

    /* renamed from: a */
    public static String m935a(Key key) {
        return Base64.encodeToString(key.getEncoded(), 2);
    }

    /* renamed from: a */
    public static PublicKey m936a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(f650a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    /* renamed from: a */
    public static boolean m937a(byte[] bArr, PublicKey publicKey, byte[] bArr2) throws Exception {
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }
}
