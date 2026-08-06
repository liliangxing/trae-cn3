package com.bytedance.common.utility;

import java.io.File;

@Deprecated
/* loaded from: classes3.dex */
public final class DigestUtils {
    private static final int BYTE_RANGE = 8192;
    static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int MAX_STRING = 4;
    private static final int RADIX = 16;
    private static final int RADIX_OFFSET = 4;
    private static final int STRING_MASK_F = 15;
    private static final int STRING_MASK_FF = 255;

    private DigestUtils() {
    }

    public static String toHexString(byte[] bArr) {
        return com.bytedance.android.standard.tools.security.DigestUtils.toHexString(bArr);
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        return com.bytedance.android.standard.tools.security.DigestUtils.toHexString(bArr, i, i2);
    }

    public static byte[] hexStringToBytes(String str) throws IllegalArgumentException {
        return com.bytedance.android.standard.tools.security.DigestUtils.hexStringToBytes(str);
    }

    public static String md5Hex(File file) {
        return com.bytedance.android.standard.tools.security.DigestUtils.md5Hex(file);
    }

    public static String md5Hex(String str) {
        return com.bytedance.android.standard.tools.security.DigestUtils.md5Hex(str);
    }

    public static String md5Hex(byte[] bArr) {
        return com.bytedance.android.standard.tools.security.DigestUtils.md5Hex(bArr);
    }

    public static String md5Hex(byte[] bArr, int i, int i2) {
        return com.bytedance.android.standard.tools.security.DigestUtils.md5Hex(bArr, i, i2);
    }
}
