package com.bytedance.upc.common.utils;

import java.security.MessageDigest;

/* loaded from: classes6.dex */
public class MD5Utils {
    protected static char[] sHexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private MD5Utils() {
    }

    public static String byteArrayToHex(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static String getStrMD5(String str) {
        try {
            return byteArrayToHex(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
