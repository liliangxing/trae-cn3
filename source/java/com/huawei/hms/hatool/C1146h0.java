package com.huawei.hms.hatool;

import android.util.Base64;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.facebook.net.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.huawei.hms.hatool.h0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1146h0 {
    /* renamed from: a */
    public static String m1548a(String str, String str2) {
        try {
            return m1549a(str, str2.getBytes(Utf8Charset.NAME));
        } catch (UnsupportedEncodingException unused) {
            C1182v.m1781c("hmsSdk", "Unsupported encoding exception,utf-8");
            return "";
        }
    }

    /* renamed from: a */
    public static String m1549a(String str, byte[] bArr) {
        String str2;
        if (bArr == null || bArr.length == 0) {
            C1182v.m1786f("hmsSdk", "encrypt: content is empty or null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(m1551a(bArr, m1550a(Base64.decode(str, 0))));
        } catch (NoSuchAlgorithmException unused) {
            str2 = "encrypt(): getInstance - No such algorithm,transformation";
            C1182v.m1786f("hmsSdk", str2);
            return "";
        } catch (InvalidKeySpecException unused2) {
            str2 = "encrypt(): Invalid key specification";
            C1182v.m1786f("hmsSdk", str2);
            return "";
        }
    }

    /* renamed from: a */
    private static PublicKey m1550a(byte[] bArr) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
    }

    /* renamed from: a */
    private static byte[] m1551a(byte[] bArr, PublicKey publicKey) {
        String str;
        try {
            if (publicKey == null) {
                throw new UnsupportedEncodingException("The loaded public key is null");
            }
            Cipher cipher = Cipher.getInstance(EncryptUtil.ANDROID_TRANSFORMATION);
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (UnsupportedEncodingException unused) {
            str = "rsaEncrypt(): getBytes - Unsupported coding format!";
            C1182v.m1786f("hmsSdk", str);
            return new byte[0];
        } catch (InvalidKeyException unused2) {
            str = "rsaEncrypt(): init - Invalid key!";
            C1182v.m1786f("hmsSdk", str);
            return new byte[0];
        } catch (NoSuchAlgorithmException unused3) {
            str = "rsaEncrypt(): getInstance - No such algorithm,transformation";
            C1182v.m1786f("hmsSdk", str);
            return new byte[0];
        } catch (BadPaddingException unused4) {
            str = "rsaEncrypt():False filling parameters!";
            C1182v.m1786f("hmsSdk", str);
            return new byte[0];
        } catch (IllegalBlockSizeException unused5) {
            str = "rsaEncrypt(): doFinal - The provided block is not filled with";
            C1182v.m1786f("hmsSdk", str);
            return new byte[0];
        } catch (NoSuchPaddingException unused6) {
            str = "rsaEncrypt():  No such filling parameters ";
            C1182v.m1786f("hmsSdk", str);
            return new byte[0];
        }
    }
}
