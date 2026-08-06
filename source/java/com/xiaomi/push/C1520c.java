package com.xiaomi.push;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.xiaomi.push.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1520c {

    /* renamed from: a */
    private final int f1131a;

    /* renamed from: a */
    private final OutputStream f1132a;

    /* renamed from: a */
    private final byte[] f1133a;

    /* renamed from: b */
    private int f1134b;

    /* renamed from: a */
    public static int m1736a(boolean z) {
        return 1;
    }

    /* renamed from: c */
    public static int m1745c(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* renamed from: d */
    public static int m1747d(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    private C1520c(byte[] bArr, int i, int i2) {
        this.f1132a = null;
        this.f1133a = bArr;
        this.f1134b = i;
        this.f1131a = i + i2;
    }

    private C1520c(OutputStream outputStream, byte[] bArr) {
        this.f1132a = outputStream;
        this.f1133a = bArr;
        this.f1134b = 0;
        this.f1131a = bArr.length;
    }

    /* renamed from: a */
    public static C1520c m1737a(OutputStream outputStream) {
        return m1738a(outputStream, 4096);
    }

    /* renamed from: a */
    public static C1520c m1738a(OutputStream outputStream, int i) {
        return new C1520c(outputStream, new byte[i]);
    }

    /* renamed from: a */
    public static C1520c m1739a(byte[] bArr, int i, int i2) {
        return new C1520c(bArr, i, i2);
    }

    /* renamed from: a */
    public void m1753a(int i, long j) {
        m1771c(i, 0);
        m1758a(j);
    }

    /* renamed from: b */
    public void m1768b(int i, long j) {
        m1771c(i, 0);
        m1769b(j);
    }

    /* renamed from: a */
    public void m1752a(int i, int i2) {
        m1771c(i, 0);
        m1751a(i2);
    }

    /* renamed from: a */
    public void m1757a(int i, boolean z) {
        m1771c(i, 0);
        m1762a(z);
    }

    /* renamed from: a */
    public void m1756a(int i, String str) {
        m1771c(i, 2);
        m1761a(str);
    }

    /* renamed from: a */
    public void m1755a(int i, AbstractC1574e abstractC1574e) {
        m1771c(i, 2);
        m1760a(abstractC1574e);
    }

    /* renamed from: a */
    public void m1754a(int i, C1466a c1466a) {
        m1771c(i, 2);
        m1759a(c1466a);
    }

    /* renamed from: b */
    public void m1767b(int i, int i2) {
        m1771c(i, 0);
        m1766b(i2);
    }

    /* renamed from: a */
    public void m1758a(long j) {
        m1772c(j);
    }

    /* renamed from: b */
    public void m1769b(long j) {
        m1772c(j);
    }

    /* renamed from: a */
    public void m1751a(int i) {
        if (i >= 0) {
            m1773d(i);
        } else {
            m1772c(i);
        }
    }

    /* renamed from: a */
    public void m1762a(boolean z) {
        m1770c(z ? 1 : 0);
    }

    /* renamed from: a */
    public void m1761a(String str) {
        byte[] bytes = str.getBytes(HTTP.UTF_8);
        m1773d(bytes.length);
        m1763a(bytes);
    }

    /* renamed from: a */
    public void m1760a(AbstractC1574e abstractC1574e) {
        m1773d(abstractC1574e.mo2060a());
        abstractC1574e.mo2066a(this);
    }

    /* renamed from: a */
    public void m1759a(C1466a c1466a) {
        byte[] m1436a = c1466a.m1436a();
        m1773d(m1436a.length);
        m1763a(m1436a);
    }

    /* renamed from: b */
    public void m1766b(int i) {
        m1773d(i);
    }

    /* renamed from: a */
    public static int m1727a(int i, long j) {
        return m1744c(i) + m1732a(j);
    }

    /* renamed from: b */
    public static int m1742b(int i, long j) {
        return m1744c(i) + m1743b(j);
    }

    /* renamed from: a */
    public static int m1726a(int i, int i2) {
        return m1744c(i) + m1725a(i2);
    }

    /* renamed from: a */
    public static int m1731a(int i, boolean z) {
        return m1744c(i) + m1736a(z);
    }

    /* renamed from: a */
    public static int m1730a(int i, String str) {
        return m1744c(i) + m1735a(str);
    }

    /* renamed from: a */
    public static int m1729a(int i, AbstractC1574e abstractC1574e) {
        return m1744c(i) + m1734a(abstractC1574e);
    }

    /* renamed from: a */
    public static int m1728a(int i, C1466a c1466a) {
        return m1744c(i) + m1733a(c1466a);
    }

    /* renamed from: b */
    public static int m1741b(int i, int i2) {
        return m1744c(i) + m1740b(i2);
    }

    /* renamed from: a */
    public static int m1732a(long j) {
        return m1745c(j);
    }

    /* renamed from: b */
    public static int m1743b(long j) {
        return m1745c(j);
    }

    /* renamed from: a */
    public static int m1725a(int i) {
        if (i >= 0) {
            return m1747d(i);
        }
        return 10;
    }

    /* renamed from: a */
    public static int m1735a(String str) {
        try {
            byte[] bytes = str.getBytes(HTTP.UTF_8);
            return m1747d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    /* renamed from: a */
    public static int m1734a(AbstractC1574e abstractC1574e) {
        int mo2068b = abstractC1574e.mo2068b();
        return m1747d(mo2068b) + mo2068b;
    }

    /* renamed from: a */
    public static int m1733a(C1466a c1466a) {
        return m1747d(c1466a.m1435a()) + c1466a.m1435a();
    }

    /* renamed from: b */
    public static int m1740b(int i) {
        return m1747d(i);
    }

    /* renamed from: c */
    private void m1746c() {
        OutputStream outputStream = this.f1132a;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f1133a, 0, this.f1134b);
        this.f1134b = 0;
    }

    /* renamed from: a */
    public void m1749a() {
        if (this.f1132a != null) {
            m1746c();
        }
    }

    /* renamed from: a */
    public int m1748a() {
        if (this.f1132a == null) {
            return this.f1131a - this.f1134b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: b */
    public void m1765b() {
        if (m1748a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: com.xiaomi.push.c$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    /* renamed from: a */
    public void m1750a(byte b) {
        if (this.f1134b == this.f1131a) {
            m1746c();
        }
        byte[] bArr = this.f1133a;
        int i = this.f1134b;
        this.f1134b = i + 1;
        bArr[i] = b;
    }

    /* renamed from: c */
    public void m1770c(int i) {
        m1750a((byte) i);
    }

    /* renamed from: a */
    public void m1763a(byte[] bArr) {
        m1764a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void m1764a(byte[] bArr, int i, int i2) {
        int i3 = this.f1131a;
        int i4 = this.f1134b;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f1133a, i4, i2);
            this.f1134b += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f1133a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f1134b = this.f1131a;
        m1746c();
        if (i7 <= this.f1131a) {
            System.arraycopy(bArr, i6, this.f1133a, 0, i7);
            this.f1134b = i7;
        } else {
            this.f1132a.write(bArr, i6, i7);
        }
    }

    /* renamed from: c */
    public void m1771c(int i, int i2) {
        m1773d(C1601f.m2528a(i, i2));
    }

    /* renamed from: c */
    public static int m1744c(int i) {
        return m1747d(C1601f.m2528a(i, 0));
    }

    /* renamed from: d */
    public void m1773d(int i) {
        while ((i & (-128)) != 0) {
            m1770c((i & PropertyIDConstants.OutlineWidth) | 128);
            i >>>= 7;
        }
        m1770c(i);
    }

    /* renamed from: c */
    public void m1772c(long j) {
        while (((-128) & j) != 0) {
            m1770c((((int) j) & PropertyIDConstants.OutlineWidth) | 128);
            j >>>= 7;
        }
        m1770c((int) j);
    }
}
