package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ih */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1690ih extends AbstractC1692ij {

    /* renamed from: a */
    private int f2800a;

    /* renamed from: a */
    private C1673hr f2801a;

    public C1690ih(int i) {
        this.f2801a = new C1673hr(i);
    }

    @Override // com.xiaomi.push.AbstractC1692ij
    /* renamed from: a */
    public int mo3408a(byte[] bArr, int i, int i2) {
        byte[] m3332a = this.f2801a.m3332a();
        if (i2 > this.f2801a.m3331a() - this.f2800a) {
            i2 = this.f2801a.m3331a() - this.f2800a;
        }
        if (i2 > 0) {
            System.arraycopy(m3332a, this.f2800a, bArr, i, i2);
            this.f2800a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.AbstractC1692ij
    /* renamed from: a */
    public void mo3409a(byte[] bArr, int i, int i2) {
        this.f2801a.write(bArr, i, i2);
    }

    /* renamed from: a */
    public int m3410a() {
        return this.f2801a.size();
    }
}
