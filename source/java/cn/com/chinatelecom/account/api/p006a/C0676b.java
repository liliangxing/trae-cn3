package cn.com.chinatelecom.account.api.p006a;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: cn.com.chinatelecom.account.api.a.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0676b {

    /* renamed from: a */
    private static String f120a = "RSA/ECB/PKCS1Padding";

    /* renamed from: a */
    public static String m184a(String str, RSAPublicKey rSAPublicKey) {
        try {
            return C0677c.m187a(m186a(rSAPublicKey, str.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static PublicKey m185a(String str) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C0675a.m182a(str)));
    }

    /* renamed from: a */
    public static byte[] m186a(RSAPublicKey rSAPublicKey, byte[] bArr) {
        if (rSAPublicKey == null) {
            throw new Exception(C0678d.m189a(new byte[]{-17, Byte.MIN_VALUE, -86, -17, -91, -116, -17, -113, -90, -29, -104, -81, -18, -78, -80, -19, -93, -80, 38, 42, -30, -91, -67, -30, -92, -76, -19, -73, -92}));
        }
        try {
            Cipher cipher = Cipher.getInstance(f120a);
            cipher.init(1, rSAPublicKey);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException unused) {
            throw new Exception(C0678d.m189a(new byte[]{-17, Byte.MIN_VALUE, -86, -17, -91, -116, -17, -113, -90, -29, -104, -81, -29, -105, -108, -20, -71, -97, 38, -30, -91, -67, -20, -87, -118, -20, -107, -81}));
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception(C0678d.m189a(new byte[]{-20, -99, -86, -20, -89, -82, -17, Byte.MIN_VALUE, -86, -17, -91, -116, -19, -92, -99, -20, -71, -97}));
        } catch (BadPaddingException unused3) {
            throw new Exception(C0678d.m189a(new byte[]{-20, -110, -124, -20, -100, -115, -20, -97, -70, -20, -121, -92, -17, -67, -72, -20, -121, -107, -17, -105, -123}));
        } catch (IllegalBlockSizeException unused4) {
            throw new Exception(C0678d.m189a(new byte[]{-20, -110, -124, -20, -100, -115, -29, -97, -75, -17, -80, -84, -29, -105, -108, -20, -71, -97}));
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
