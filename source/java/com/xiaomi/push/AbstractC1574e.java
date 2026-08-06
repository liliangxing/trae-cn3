package com.xiaomi.push;

import java.io.IOException;

/* renamed from: com.xiaomi.push.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1574e {
    /* renamed from: a */
    public abstract int mo2060a();

    /* renamed from: a */
    public abstract AbstractC1574e mo2062a(C1493b c1493b);

    /* renamed from: a */
    public abstract void mo2066a(C1520c c1520c);

    /* renamed from: b */
    public abstract int mo2068b();

    /* renamed from: a */
    public byte[] m2338a() {
        int mo2068b = mo2068b();
        byte[] bArr = new byte[mo2068b];
        m2336a(bArr, 0, mo2068b);
        return bArr;
    }

    /* renamed from: a */
    public void m2336a(byte[] bArr, int i, int i2) {
        try {
            C1520c m1739a = C1520c.m1739a(bArr, i, i2);
            mo2066a(m1739a);
            m1739a.m1765b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    /* renamed from: a */
    public AbstractC1574e m2334a(byte[] bArr) {
        return m2335a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public AbstractC1574e m2335a(byte[] bArr, int i, int i2) {
        try {
            C1493b m1599a = C1493b.m1599a(bArr, i, i2);
            mo2062a(m1599a);
            m1599a.m1609a(0);
            return this;
        } catch (C1547d e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m2337a(C1493b c1493b, int i) {
        return c1493b.m1612a(i);
    }
}
