package com.xiaomi.push;

/* renamed from: com.xiaomi.push.x */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1803x {
    /* renamed from: a */
    public static byte[] m4118a(int i) {
        return new byte[]{(byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) i};
    }

    /* renamed from: a */
    public static int m4117a(byte[] bArr) {
        if (bArr.length != 4) {
            throw new IllegalArgumentException("the length of bytes must be 4");
        }
        return (bArr[3] & 255) | 0 | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }
}
