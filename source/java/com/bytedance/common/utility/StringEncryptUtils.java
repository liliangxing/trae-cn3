package com.bytedance.common.utility;

@Deprecated
/* loaded from: classes3.dex */
public final class StringEncryptUtils {
    public static final String MD5 = "MD5";
    public static final String SHA_1 = "SHA-1";
    public static final String SHA_256 = "SHA-256";

    private StringEncryptUtils() {
    }

    public static String encryptBySHA256(String str) {
        return com.bytedance.android.standard.tools.security.StringEncryptUtils.encryptBySHA256(str);
    }

    public static String encrypt(String str, String str2) {
        return com.bytedance.android.standard.tools.security.StringEncryptUtils.encrypt(str, str2);
    }

    public static String bytes2Hex(byte[] bArr) {
        return com.bytedance.android.standard.tools.security.StringEncryptUtils.bytes2Hex(bArr);
    }
}
