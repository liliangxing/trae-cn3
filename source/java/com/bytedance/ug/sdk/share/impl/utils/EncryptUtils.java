package com.bytedance.ug.sdk.share.impl.utils;

import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class EncryptUtils {
    private static final String TAG = "";

    public static String sha256(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return bytes2Hex(messageDigest.digest());
        } catch (Throwable th) {
            Logger.e("", "sha256()...error", th);
            return "";
        }
    }

    private static String bytes2Hex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Throwable th) {
            Logger.e("", "bytes2Hex()...error", th);
            return "";
        }
    }
}
