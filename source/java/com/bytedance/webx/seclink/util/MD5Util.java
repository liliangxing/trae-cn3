package com.bytedance.webx.seclink.util;

import java.security.MessageDigest;

/* loaded from: classes6.dex */
public final class MD5Util {
    private static final String TAG = "MD5Util";
    private static char[] sHexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private MD5Util() {
        throw new UnsupportedOperationException("u can't instantiate me");
    }

    public static String getMd5(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return bufferToHex(messageDigest.digest());
        } catch (Exception e) {
            Log.e(TAG, "getMd5", e);
            ExceptionUtil.handleException(e);
            return "";
        }
    }

    private static String bufferToHex(byte[] bArr) {
        return bufferToHex(bArr, 0, bArr.length);
    }

    private static String bufferToHex(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2 * 2);
        int i3 = i2 + i;
        while (i < i3) {
            appendHexPair(bArr[i], sb);
            i++;
        }
        return sb.toString();
    }

    private static void appendHexPair(byte b, StringBuilder sb) {
        char[] cArr = sHexDigits;
        char c = cArr[(b & 240) >> 4];
        char c2 = cArr[b & 15];
        sb.append(c);
        sb.append(c2);
    }
}
