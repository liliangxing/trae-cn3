package com.xiaomi.push;

import android.text.TextUtils;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/* renamed from: com.xiaomi.push.ba */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1494ba {
    /* renamed from: a */
    public static String m1630a(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return m1631a(objArr, str, 0, objArr.length);
    }

    /* renamed from: a */
    public static String m1631a(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        Object obj = objArr[i];
        StringBuffer stringBuffer = new StringBuffer(i3 * ((obj == null ? 16 : obj.toString().length()) + str.length()));
        for (int i4 = i; i4 < i2; i4++) {
            if (i4 > i) {
                stringBuffer.append(str);
            }
            Object obj2 = objArr[i4];
            if (obj2 != null) {
                stringBuffer.append(obj2);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m1628a(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return next.toString();
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        if (next != null) {
            stringBuffer.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                stringBuffer.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                stringBuffer.append(next2);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m1627a(Collection<?> collection, String str) {
        if (collection == null) {
            return null;
        }
        return m1628a(collection.iterator(), str);
    }

    /* renamed from: a */
    public static String m1624a(int i) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m1625a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(m1633a(str));
            return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    /* renamed from: a */
    public static String m1629a(byte[] bArr) {
        String str;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            str = String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (Exception unused) {
            str = "";
        }
        return str.toLowerCase();
    }

    /* renamed from: b */
    public static String m1634b(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(m1633a(str));
            return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    /* renamed from: a */
    public static byte[] m1633a(String str) {
        try {
            return str.getBytes(HTTP.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    /* renamed from: b */
    public static String m1635b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return new String(bArr, HTTP.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    /* renamed from: a */
    public static boolean m1632a(String str) {
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < 0 || charAt > 127) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static String m1626a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        if (i <= 0 || length < i) {
            i = length / 3;
            if (i <= 1) {
                i = 1;
            }
            if (i > 3) {
                i = 3;
            }
        }
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (i3 % i == 0) {
                sb.append("*");
            } else {
                sb.append(str.charAt(i2));
            }
            i2 = i3;
        }
        return sb.toString();
    }
}
