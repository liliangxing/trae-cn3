package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.huawei.agconnect.config.impl.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0986l {
    /* renamed from: a */
    private static String m823a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Log.w("ResourcesUtils", "resName is empty");
            return null;
        }
        int identifier = context.getResources().getIdentifier(str2, "string", str);
        if (identifier == 0) {
            Log.w("ResourcesUtils", "resId == 0");
            return null;
        }
        try {
            return context.getResources().getString(identifier);
        } catch (Resources.NotFoundException e) {
            Log.e("ResourcesUtils", "resources not fund" + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static String m824a(Context context, String str, String str2, String str3) {
        try {
            return m823a(context, str, str2 + Hex.encodeHexString(m825a(str3.getBytes("utf-8"))));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            Log.e("ResourcesUtils", "getResources exception:" + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m825a(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256").digest(bArr);
    }
}
