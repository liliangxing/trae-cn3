package com.xiaomi.push;

import java.io.IOException;

/* loaded from: classes7.dex */
public abstract class e {
    public abstract int a();

    public abstract e a(b bVar);

    public abstract void a(c cVar);

    public abstract int b();

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m9852a() {
        int b = b();
        byte[] bArr = new byte[b];
        m9851a(bArr, 0, b);
        return bArr;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9851a(byte[] bArr, int i, int i2) {
        try {
            c a = c.a(bArr, i, i2);
            a(a);
            a.b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public e a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public e a(byte[] bArr, int i, int i2) {
        try {
            b a = b.a(bArr, i, i2);
            a(a);
            a.m9646a(0);
            return this;
        } catch (d e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(b bVar, int i) {
        return bVar.m9648a(i);
    }
}
