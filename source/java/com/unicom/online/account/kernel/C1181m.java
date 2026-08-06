package com.unicom.online.account.kernel;

/* renamed from: com.unicom.online.account.kernel.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1181m {
    /* renamed from: a */
    public static String m542a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(String.valueOf(hexString));
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
