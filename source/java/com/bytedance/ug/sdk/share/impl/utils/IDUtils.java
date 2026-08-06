package com.bytedance.ug.sdk.share.impl.utils;

import android.text.TextUtils;
import java.security.MessageDigest;
import kotlin.UByte;

/* loaded from: classes4.dex */
public class IDUtils {
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static int generate(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String md5Hex = md5Hex(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(md5Hex)) {
            return 0;
        }
        return md5Hex.hashCode();
    }

    public static String md5Hex(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return toHexString(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return toHexString(bArr, 0, bArr.length);
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        if (bArr == null || i < 0 || i + i2 > bArr.length) {
            return null;
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & UByte.MAX_VALUE;
            int i7 = i4 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }
}
