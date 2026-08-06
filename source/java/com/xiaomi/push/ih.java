package com.xiaomi.push;

/* loaded from: classes7.dex */
public class ih extends ij {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private hr f895a;

    public ih(int i) {
        this.f895a = new hr(i);
    }

    @Override // com.xiaomi.push.ij
    public int a(byte[] bArr, int i, int i2) {
        byte[] m10077a = this.f895a.m10077a();
        if (i2 > this.f895a.a() - this.a) {
            i2 = this.f895a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(m10077a, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.ij
    /* renamed from: a */
    public void mo10100a(byte[] bArr, int i, int i2) {
        this.f895a.write(bArr, i, i2);
    }

    public int a() {
        return this.f895a.size();
    }
}
