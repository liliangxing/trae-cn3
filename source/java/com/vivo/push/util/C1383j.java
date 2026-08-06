package com.vivo.push.util;

/* compiled from: CryptographicTool.java */
/* renamed from: com.vivo.push.util.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1383j {
    /* renamed from: a */
    public static String m1004a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (bArr[i] ^ 16);
        }
        return new String(cArr);
    }
}
