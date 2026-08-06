package com.xiaomi.push;

/* renamed from: com.xiaomi.push.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1466a {

    /* renamed from: a */
    public static final C1466a f916a = new C1466a(new byte[0]);

    /* renamed from: a */
    private volatile int f917a = 0;

    /* renamed from: a */
    private final byte[] f918a;

    private C1466a(byte[] bArr) {
        this.f918a = bArr;
    }

    /* renamed from: a */
    public int m1435a() {
        return this.f918a.length;
    }

    /* renamed from: a */
    public static C1466a m1434a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new C1466a(bArr2);
    }

    /* renamed from: a */
    public static C1466a m1433a(byte[] bArr) {
        return m1434a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public byte[] m1436a() {
        byte[] bArr = this.f918a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1466a)) {
            return false;
        }
        byte[] bArr = this.f918a;
        int length = bArr.length;
        byte[] bArr2 = ((C1466a) obj).f918a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f917a;
        if (i == 0) {
            byte[] bArr = this.f918a;
            int length = bArr.length;
            for (byte b : bArr) {
                length = (length * 31) + b;
            }
            i = length == 0 ? 1 : length;
            this.f917a = i;
        }
        return i;
    }
}
