package com.xiaomi.push;

import android.content.Context;

/* renamed from: com.xiaomi.push.aa */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1467aa {

    /* renamed from: a */
    static final char[] f919a = "0123456789ABCDEF".toCharArray();

    /* renamed from: a */
    public static boolean m1438a(Context context) {
        return C1805z.f3274a;
    }

    /* renamed from: a */
    public static String m1437a(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2 * 2);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i + i3] & 255;
            char[] cArr = f919a;
            sb.append(cArr[i4 >> 4]);
            sb.append(cArr[i4 & 15]);
        }
        return sb.toString();
    }
}
