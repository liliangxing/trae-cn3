package com.cmic.sso.sdk.e;

import android.text.TextUtils;
import com.bytedance.platform.godzilla.common.Constant;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* compiled from: MD5STo16Byte.java */
/* loaded from: classes6.dex */
public class d {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(str.getBytes(Constant.CHARSET_UTF_8));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return q.a(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }
}
