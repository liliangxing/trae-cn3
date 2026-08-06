package com.cmic.sso.sdk.p009e;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* compiled from: MD5STo16Byte.java */
/* renamed from: com.cmic.sso.sdk.e.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0134d {
    /* renamed from: a */
    public static String m329a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return m330a(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m330a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return C0147q.m395a(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }
}
