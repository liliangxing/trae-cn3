package com.bytedance.android.tools.superkv;

/* loaded from: classes3.dex */
class Adler32Java {
    private static final int BASE = 65521;

    private Adler32Java() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long calc(byte[] bArr, int i, int i2) {
        long j = 1;
        long j2 = 0;
        for (int i3 = i; i3 < i + i2; i3++) {
            j = (j + bArr[i3]) % 65521;
            j2 = (j2 + j) % 65521;
        }
        return (j2 << 16) + j;
    }
}
