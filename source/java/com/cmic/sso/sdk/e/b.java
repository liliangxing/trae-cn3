package com.cmic.sso.sdk.e;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.sdk.bdticketguard.key.TeeKeyHelperKt;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: KeystoreUtil.java */
/* loaded from: classes6.dex */
public class b {
    private static byte[] a;

    public static boolean a(Context context, boolean z) {
        try {
            KeyStore keyStore = KeyStore.getInstance(TeeKeyHelperKt.KEY_STORE_PROVIDER_ANDROID);
            keyStore.load(null);
            if (keyStore.getKey("CMCC_SDK_V1", null) != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            return a(context);
        }
        return false;
    }

    private static boolean a(Context context) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", TeeKeyHelperKt.KEY_STORE_PROVIDER_ANDROID);
            keyGenerator.init(new KeyGenParameterSpec.Builder("CMCC_SDK_V1", 3).setDigests("SHA-256", "SHA-512").setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setRandomizedEncryptionRequired(false).setKeySize(256).build());
            Thread.sleep(1000L);
            keyGenerator.generateKey();
            return true;
        } catch (Exception e) {
            c.a("KeystoreUtil", e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, String str) {
        a();
        byte[] b = b(context);
        if (b != null) {
            return a.a(b, str, a);
        }
        a();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] b = b(context);
        if (b != null) {
            return a.b(b, str, a);
        }
        a();
        return null;
    }

    private static synchronized byte[] b(Context context) {
        Cipher cipher;
        byte[] doFinal;
        Cipher cipher2;
        synchronized (b.class) {
            try {
                KeyStore keyStore = KeyStore.getInstance(TeeKeyHelperKt.KEY_STORE_PROVIDER_ANDROID);
                keyStore.load(null);
                if (!a(context, false)) {
                    return null;
                }
                String b = b();
                if (TextUtils.isEmpty(b)) {
                    doFinal = q.a();
                    a = q.a();
                    Key key = keyStore.getKey("CMCC_SDK_V1", null);
                    if (key instanceof SecretKey) {
                        c.b("KeystoreUtil", "随机生成aes秘钥");
                        cipher2 = Cipher.getInstance("AES/CBC/PKCS7Padding");
                        cipher2.init(1, key, new IvParameterSpec(a));
                    } else {
                        if (!(key instanceof PrivateKey)) {
                            return null;
                        }
                        PublicKey publicKey = keyStore.getCertificate("CMCC_SDK_V1").getPublicKey();
                        cipher2 = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
                        c.b("KeystoreUtil", "生成rsa密");
                        cipher2.init(1, publicKey);
                    }
                    String encodeToString = Base64.encodeToString(cipher2.doFinal(doFinal), 0);
                    String encodeToString2 = Base64.encodeToString(a, 0);
                    HashMap hashMap = new HashMap();
                    hashMap.put("AES_IV", encodeToString2);
                    hashMap.put("AES_KEY", encodeToString);
                    k.a(hashMap);
                } else {
                    a = Base64.decode(c(), 0);
                    byte[] decode = Base64.decode(b, 0);
                    Key key2 = keyStore.getKey("CMCC_SDK_V1", null);
                    if (key2 == null) {
                        return null;
                    }
                    if (key2 instanceof SecretKey) {
                        cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                        cipher.init(2, key2, new IvParameterSpec(a));
                        c.b("KeystoreUtil", "使用aes");
                    } else {
                        if (!(key2 instanceof PrivateKey)) {
                            return null;
                        }
                        cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
                        cipher.init(2, key2);
                        c.b("KeystoreUtil", "使用rsa");
                    }
                    doFinal = cipher.doFinal(decode);
                    c.b("KeystoreUtil", "是否解密出秘钥：" + (TextUtils.isEmpty(Base64.encodeToString(doFinal, 0)) ? false : true));
                }
                return doFinal;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void a() {
        k.a("AES_KEY");
    }

    private static String b() {
        return k.b("AES_KEY", "");
    }

    private static String c() {
        return k.b("AES_IV", "");
    }
}
