package com.xiaomi.push;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.xiaomi.push.az */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1492az {
    /* renamed from: a */
    private static String m1594a(byte b) {
        int i = (b & Byte.MAX_VALUE) + (b < 0 ? 128 : 0);
        return (i < 16 ? "0" : "") + Integer.toHexString(i).toLowerCase();
    }

    /* renamed from: a */
    public static String m1595a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            messageDigest.update(str.getBytes(), 0, str.length());
            for (byte b : messageDigest.digest()) {
                stringBuffer.append(m1594a(b));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m1597b(String str) {
        return m1595a(str).subSequence(8, 24).toString();
    }

    /* renamed from: a */
    public static byte[] m1596a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }
}
