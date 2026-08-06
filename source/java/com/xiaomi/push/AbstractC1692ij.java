package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ij */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1692ij {
    /* renamed from: a */
    public abstract int mo3408a(byte[] bArr, int i, int i2);

    /* renamed from: a */
    public void mo3411a(int i) {
    }

    /* renamed from: a */
    public abstract void mo3409a(byte[] bArr, int i, int i2);

    /* renamed from: a */
    public byte[] mo3413a() {
        return null;
    }

    /* renamed from: a_ */
    public int mo3414a_() {
        return 0;
    }

    /* renamed from: b */
    public int mo3415b() {
        return -1;
    }

    /* renamed from: b */
    public int m3417b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int mo3408a = mo3408a(bArr, i + i3, i2 - i3);
            if (mo3408a <= 0) {
                throw new C1693ik("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes.");
            }
            i3 += mo3408a;
        }
        return i3;
    }
}
