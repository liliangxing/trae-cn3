package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ii */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1691ii extends AbstractC1692ij {

    /* renamed from: a */
    private int f2802a;

    /* renamed from: a */
    private byte[] f2803a;

    /* renamed from: b */
    private int f2804b;

    /* renamed from: a */
    public void m3412a(byte[] bArr) {
        m3416b(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public void m3416b(byte[] bArr, int i, int i2) {
        this.f2803a = bArr;
        this.f2802a = i;
        this.f2804b = i + i2;
    }

    @Override // com.xiaomi.push.AbstractC1692ij
    /* renamed from: a */
    public int mo3408a(byte[] bArr, int i, int i2) {
        int mo3415b = mo3415b();
        if (i2 > mo3415b) {
            i2 = mo3415b;
        }
        if (i2 > 0) {
            System.arraycopy(this.f2803a, this.f2802a, bArr, i, i2);
            mo3411a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.AbstractC1692ij
    /* renamed from: a */
    public void mo3409a(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.AbstractC1692ij
    /* renamed from: a */
    public byte[] mo3413a() {
        return this.f2803a;
    }

    @Override // com.xiaomi.push.AbstractC1692ij
    /* renamed from: a_ */
    public int mo3414a_() {
        return this.f2802a;
    }

    @Override // com.xiaomi.push.AbstractC1692ij
    /* renamed from: b */
    public int mo3415b() {
        return this.f2804b - this.f2802a;
    }

    @Override // com.xiaomi.push.AbstractC1692ij
    /* renamed from: a */
    public void mo3411a(int i) {
        this.f2802a += i;
    }
}
