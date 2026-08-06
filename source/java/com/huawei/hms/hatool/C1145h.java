package com.huawei.hms.hatool;

/* renamed from: com.huawei.hms.hatool.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1145h {

    /* renamed from: a */
    private byte[] f1463a;

    /* renamed from: b */
    private int f1464b = 0;

    public C1145h(int i) {
        this.f1463a = null;
        this.f1463a = new byte[i];
    }

    /* renamed from: a */
    public void m1545a(byte[] bArr, int i) {
        if (i <= 0) {
            return;
        }
        byte[] bArr2 = this.f1463a;
        int length = bArr2.length;
        int i2 = this.f1464b;
        if (length - i2 >= i) {
            System.arraycopy(bArr, 0, bArr2, i2, i);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i) << 1];
            System.arraycopy(bArr2, 0, bArr3, 0, i2);
            System.arraycopy(bArr, 0, bArr3, this.f1464b, i);
            this.f1463a = bArr3;
        }
        this.f1464b += i;
    }

    /* renamed from: a */
    public byte[] m1546a() {
        int i = this.f1464b;
        if (i <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.f1463a, 0, bArr, 0, i);
        return bArr;
    }

    /* renamed from: b */
    public int m1547b() {
        return this.f1464b;
    }
}
