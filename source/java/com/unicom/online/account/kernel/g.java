package com.unicom.online.account.kernel;

import android.text.TextUtils;
import com.bytedance.platform.godzilla.common.Constant;
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
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* loaded from: classes7.dex */
public final class g {
    private static final char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    public static String a() {
        try {
            String replace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            return (TextUtils.isEmpty(replace) || replace.length() < 32) ? ab.c().substring(0, 32) : replace;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2, String str3) {
        return c(str, str2, str3);
    }

    public static String b(String str, String str2, String str3) {
        try {
            return d(str, str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String c(String str, String str2, String str3) {
        if (str2.length() != 16 || str3.length() != 16) {
            return "";
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(new String(h.b("QUVTL0NCQy9QS0NTNVBhZGRpbmc=")));
            byte[] bytes = str.getBytes(Constant.CHARSET_UTF_8);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return h.a(cipher.doFinal(bytes));
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

    private static String d(String str, String str2, String str3) {
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
                byte[] b = h.b(str);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, new SecretKeySpec(str2.getBytes(Constant.CHARSET_UTF_8), "AES"), new IvParameterSpec(str3.getBytes(Constant.CHARSET_UTF_8)));
                return new String(cipher.doFinal(b), Constant.CHARSET_UTF_8);
            }
            return null;
        } catch (Exception e) {
            throw new Exception("decrypt errot", e);
        }
    }
}
