package com.unicom.online.account.kernel;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.unicom.online.account.kernel.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1175g {

    /* renamed from: a */
    private static final char[] f252a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: a */
    public static String m528a() {
        try {
            String replace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            return (TextUtils.isEmpty(replace) || replace.length() < 32) ? C1166ab.m458c().substring(0, 32) : replace;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m529a(String str, String str2, String str3) {
        return m531c(str, str2, str3);
    }

    /* renamed from: b */
    public static String m530b(String str, String str2, String str3) {
        try {
            return m532d(str, str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private static String m531c(String str, String str2, String str3) {
        if (str2.length() != 16 || str3.length() != 16) {
            return "";
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(new String(C1176h.m535b("QUVTL0NCQy9QS0NTNVBhZGRpbmc=")));
            byte[] bytes = str.getBytes("utf-8");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return C1176h.m534a(cipher.doFinal(bytes));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidAlgorithmParameterException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return null;
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e6) {
            e6.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    private static String m532d(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        try {
            if (str.length() != 0 && str.trim().length() != 0) {
                if (str2 == null) {
                    throw new Exception("decrypt key is null");
                }
                if (str2.length() != 16) {
                    throw new Exception("decrypt key length error");
                }
                if (str3.length() != 16) {
                    throw new Exception(" iv decrypt key length error");
                }
                byte[] m535b = C1176h.m535b(str);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, new SecretKeySpec(str2.getBytes("utf-8"), "AES"), new IvParameterSpec(str3.getBytes("utf-8")));
                return new String(cipher.doFinal(m535b), "utf-8");
            }
            return null;
        } catch (Exception e) {
            throw new Exception("decrypt errot", e);
        }
    }
}
