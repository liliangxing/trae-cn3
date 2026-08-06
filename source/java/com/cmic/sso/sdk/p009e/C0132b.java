package com.cmic.sso.sdk.p009e;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
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
/* renamed from: com.cmic.sso.sdk.e.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0132b {

    /* renamed from: a */
    private static byte[] f306a;

    /* renamed from: a */
    public static boolean m321a(Context context, boolean z) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.getKey("CMCC_SDK_V1", null) != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            return m320a(context);
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m320a(Context context) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder("CMCC_SDK_V1", 3).setDigests("SHA-256", "SHA-512").setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setRandomizedEncryptionRequired(false).setKeySize(256).build());
            Thread.sleep(1000L);
            keyGenerator.generateKey();
            return true;
        } catch (Exception e) {
            C0133c.m326a("KeystoreUtil", e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m318a(Context context, String str) {
        m319a();
        byte[] m324b = m324b(context);
        if (m324b != null) {
            return C0131a.m315a(m324b, str, f306a);
        }
        m319a();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static String m323b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] m324b = m324b(context);
        if (m324b != null) {
            return C0131a.m317b(m324b, str, f306a);
        }
        m319a();
        return null;
    }

    /* renamed from: b */
    private static synchronized byte[] m324b(Context context) {
        Cipher cipher;
        byte[] doFinal;
        Cipher cipher2;
        synchronized (C0132b.class) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load(null);
                if (!m321a(context, false)) {
                    return null;
                }
                String m322b = m322b();
                if (TextUtils.isEmpty(m322b)) {
                    doFinal = C0147q.m398a();
                    f306a = C0147q.m398a();
                    Key key = keyStore.getKey("CMCC_SDK_V1", null);
                    if (key instanceof SecretKey) {
                        C0133c.m328b("KeystoreUtil", "随机生成aes秘钥");
                        cipher2 = Cipher.getInstance("AES/CBC/PKCS7Padding");
                        cipher2.init(1, key, new IvParameterSpec(f306a));
                    } else {
                        if (!(key instanceof PrivateKey)) {
                            return null;
                        }
                        PublicKey publicKey = keyStore.getCertificate("CMCC_SDK_V1").getPublicKey();
                        cipher2 = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
                        C0133c.m328b("KeystoreUtil", "生成rsa密");
                        cipher2.init(1, publicKey);
                    }
                    String encodeToString = Base64.encodeToString(cipher2.doFinal(doFinal), 0);
                    String encodeToString2 = Base64.encodeToString(f306a, 0);
                    HashMap hashMap = new HashMap();
                    hashMap.put("AES_IV", encodeToString2);
                    hashMap.put("AES_KEY", encodeToString);
                    C0141k.m372a(hashMap);
                } else {
                    f306a = Base64.decode(m325c(), 0);
                    byte[] decode = Base64.decode(m322b, 0);
                    Key key2 = keyStore.getKey("CMCC_SDK_V1", null);
                    if (key2 == null) {
                        return null;
                    }
                    if (key2 instanceof SecretKey) {
                        cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                        cipher.init(2, key2, new IvParameterSpec(f306a));
                        C0133c.m328b("KeystoreUtil", "使用aes");
                    } else {
                        if (!(key2 instanceof PrivateKey)) {
                            return null;
                        }
                        cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
                        cipher.init(2, key2);
                        C0133c.m328b("KeystoreUtil", "使用rsa");
                    }
                    doFinal = cipher.doFinal(decode);
                    C0133c.m328b("KeystoreUtil", "是否解密出秘钥：" + (TextUtils.isEmpty(Base64.encodeToString(doFinal, 0)) ? false : true));
                }
                return doFinal;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* renamed from: a */
    public static void m319a() {
        C0141k.m370a("AES_KEY");
    }

    /* renamed from: b */
    private static String m322b() {
        return C0141k.m374b("AES_KEY", "");
    }

    /* renamed from: c */
    private static String m325c() {
        return C0141k.m374b("AES_IV", "");
    }
}
