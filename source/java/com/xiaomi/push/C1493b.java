package com.xiaomi.push;

import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.ttm.utils.AVLogger;
import java.io.InputStream;
import java.util.Vector;

/* renamed from: com.xiaomi.push.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1493b {

    /* renamed from: a */
    private int f1032a;

    /* renamed from: a */
    private final InputStream f1033a;

    /* renamed from: a */
    private final byte[] f1034a;

    /* renamed from: b */
    private int f1035b;

    /* renamed from: c */
    private int f1036c;

    /* renamed from: d */
    private int f1037d;

    /* renamed from: e */
    private int f1038e;

    /* renamed from: f */
    private int f1039f;

    /* renamed from: g */
    private int f1040g;

    /* renamed from: h */
    private int f1041h;

    /* renamed from: i */
    private int f1042i;

    /* renamed from: a */
    public static C1493b m1598a(InputStream inputStream) {
        return new C1493b(inputStream);
    }

    /* renamed from: a */
    public static C1493b m1599a(byte[] bArr, int i, int i2) {
        return new C1493b(bArr, i, i2);
    }

    /* renamed from: a */
    public int m1603a() {
        if (m1617b()) {
            this.f1037d = 0;
            return 0;
        }
        int m1621d = m1621d();
        this.f1037d = m1621d;
        if (m1621d != 0) {
            return m1621d;
        }
        throw C1547d.m2001d();
    }

    /* renamed from: a */
    public void m1609a(int i) {
        if (this.f1037d != i) {
            throw C1547d.m2002e();
        }
    }

    /* renamed from: a */
    public boolean m1612a(int i) {
        int m2527a = C1601f.m2527a(i);
        if (m2527a == 0) {
            m1614b();
            return true;
        }
        if (m2527a == 1) {
            m1622d();
            return true;
        }
        if (m2527a == 2) {
            m1620c(m1621d());
            return true;
        }
        if (m2527a == 3) {
            m1608a();
            m1609a(C1601f.m2528a(C1601f.m2529b(i), 4));
            return true;
        }
        if (m2527a == 4) {
            return false;
        }
        if (m2527a == 5) {
            m1623e();
            return true;
        }
        throw C1547d.m2003f();
    }

    /* renamed from: a */
    public void m1608a() {
        int m1603a;
        do {
            m1603a = m1603a();
            if (m1603a == 0) {
                return;
            }
        } while (m1612a(m1603a));
    }

    /* renamed from: a */
    public long m1605a() {
        return m1619c();
    }

    /* renamed from: b */
    public long m1615b() {
        return m1619c();
    }

    /* renamed from: b */
    public int m1614b() {
        return m1621d();
    }

    /* renamed from: a */
    public boolean m1611a() {
        return m1621d() != 0;
    }

    /* renamed from: a */
    public String m1607a() {
        int m1621d = m1621d();
        if (m1621d <= this.f1032a - this.f1036c && m1621d > 0) {
            String str = new String(this.f1034a, this.f1036c, m1621d, HTTP.UTF_8);
            this.f1036c += m1621d;
            return str;
        }
        return new String(m1613a(m1621d), HTTP.UTF_8);
    }

    /* renamed from: a */
    public void m1610a(AbstractC1574e abstractC1574e) {
        int m1621d = m1621d();
        if (this.f1040g >= this.f1041h) {
            throw C1547d.m2004g();
        }
        int m1604a = m1604a(m1621d);
        this.f1040g++;
        abstractC1574e.mo2062a(this);
        m1609a(0);
        this.f1040g--;
        m1616b(m1604a);
    }

    /* renamed from: a */
    public C1466a m1606a() {
        int m1621d = m1621d();
        int i = this.f1032a;
        int i2 = this.f1036c;
        if (m1621d <= i - i2 && m1621d > 0) {
            C1466a m1434a = C1466a.m1434a(this.f1034a, i2, m1621d);
            this.f1036c += m1621d;
            return m1434a;
        }
        return C1466a.m1433a(m1613a(m1621d));
    }

    /* renamed from: c */
    public int m1618c() {
        return m1621d();
    }

    /* renamed from: d */
    public int m1621d() {
        int i;
        byte m1602a = m1602a();
        if (m1602a >= 0) {
            return m1602a;
        }
        int i2 = m1602a & Byte.MAX_VALUE;
        byte m1602a2 = m1602a();
        if (m1602a2 >= 0) {
            i = m1602a2 << 7;
        } else {
            i2 |= (m1602a2 & Byte.MAX_VALUE) << 7;
            byte m1602a3 = m1602a();
            if (m1602a3 >= 0) {
                i = m1602a3 << 14;
            } else {
                i2 |= (m1602a3 & Byte.MAX_VALUE) << 14;
                byte m1602a4 = m1602a();
                if (m1602a4 < 0) {
                    int i3 = i2 | ((m1602a4 & Byte.MAX_VALUE) << 21);
                    byte m1602a5 = m1602a();
                    int i4 = i3 | (m1602a5 << 28);
                    if (m1602a5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (m1602a() >= 0) {
                            return i4;
                        }
                    }
                    throw C1547d.m2000c();
                }
                i = m1602a4 << 21;
            }
        }
        return i2 | i;
    }

    /* renamed from: c */
    public long m1619c() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((m1602a() & 128) == 0) {
                return j;
            }
        }
        throw C1547d.m2000c();
    }

    /* renamed from: e */
    public int m1623e() {
        return (m1602a() & 255) | ((m1602a() & 255) << 8) | ((m1602a() & 255) << 16) | ((m1602a() & 255) << 24);
    }

    /* renamed from: d */
    public long m1622d() {
        return ((m1602a() & 255) << 8) | (m1602a() & 255) | ((m1602a() & 255) << 16) | ((m1602a() & 255) << 24) | ((m1602a() & 255) << 32) | ((m1602a() & 255) << 40) | ((m1602a() & 255) << 48) | ((m1602a() & 255) << 56);
    }

    private C1493b(byte[] bArr, int i, int i2) {
        this.f1039f = Integer.MAX_VALUE;
        this.f1041h = 64;
        this.f1042i = AVLogger.LEVEL_LOG_ERROR;
        this.f1034a = bArr;
        this.f1032a = i2 + i;
        this.f1036c = i;
        this.f1033a = null;
    }

    private C1493b(InputStream inputStream) {
        this.f1039f = Integer.MAX_VALUE;
        this.f1041h = 64;
        this.f1042i = AVLogger.LEVEL_LOG_ERROR;
        this.f1034a = new byte[4096];
        this.f1032a = 0;
        this.f1036c = 0;
        this.f1033a = inputStream;
    }

    /* renamed from: a */
    public int m1604a(int i) {
        if (i < 0) {
            throw C1547d.m1999b();
        }
        int i2 = i + this.f1038e + this.f1036c;
        int i3 = this.f1039f;
        if (i2 > i3) {
            throw C1547d.m1998a();
        }
        this.f1039f = i2;
        m1601b();
        return i3;
    }

    /* renamed from: b */
    private void m1601b() {
        int i = this.f1032a + this.f1035b;
        this.f1032a = i;
        int i2 = this.f1038e + i;
        int i3 = this.f1039f;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.f1035b = i4;
            this.f1032a = i - i4;
            return;
        }
        this.f1035b = 0;
    }

    /* renamed from: b */
    public void m1616b(int i) {
        this.f1039f = i;
        m1601b();
    }

    /* renamed from: b */
    public boolean m1617b() {
        return this.f1036c == this.f1032a && !m1600a(false);
    }

    /* renamed from: a */
    private boolean m1600a(boolean z) {
        int i = this.f1036c;
        int i2 = this.f1032a;
        if (i < i2) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        int i3 = this.f1038e;
        if (i3 + i2 == this.f1039f) {
            if (z) {
                throw C1547d.m1998a();
            }
            return false;
        }
        this.f1038e = i3 + i2;
        this.f1036c = 0;
        InputStream inputStream = this.f1033a;
        int read = inputStream == null ? -1 : inputStream.read(this.f1034a);
        this.f1032a = read;
        if (read == 0 || read < -1) {
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f1032a + "\nThe InputStream implementation is buggy.");
        }
        if (read == -1) {
            this.f1032a = 0;
            if (z) {
                throw C1547d.m1998a();
            }
            return false;
        }
        m1601b();
        int i4 = this.f1038e + this.f1032a + this.f1035b;
        if (i4 > this.f1042i || i4 < 0) {
            throw C1547d.m2005h();
        }
        return true;
    }

    /* renamed from: a */
    public byte m1602a() {
        if (this.f1036c == this.f1032a) {
            m1600a(true);
        }
        byte[] bArr = this.f1034a;
        int i = this.f1036c;
        this.f1036c = i + 1;
        return bArr[i];
    }

    /* renamed from: a */
    public byte[] m1613a(int i) {
        if (i < 0) {
            throw C1547d.m1999b();
        }
        int i2 = this.f1038e;
        int i3 = this.f1036c;
        int i4 = i2 + i3 + i;
        int i5 = this.f1039f;
        if (i4 > i5) {
            m1620c((i5 - i2) - i3);
            throw C1547d.m1998a();
        }
        int i6 = this.f1032a;
        if (i <= i6 - i3) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.f1034a, i3, bArr, 0, i);
            this.f1036c += i;
            return bArr;
        }
        if (i < 4096) {
            byte[] bArr2 = new byte[i];
            int i7 = i6 - i3;
            System.arraycopy(this.f1034a, i3, bArr2, 0, i7);
            this.f1036c = this.f1032a;
            m1600a(true);
            while (true) {
                int i8 = i - i7;
                int i9 = this.f1032a;
                if (i8 > i9) {
                    System.arraycopy(this.f1034a, 0, bArr2, i7, i9);
                    int i10 = this.f1032a;
                    i7 += i10;
                    this.f1036c = i10;
                    m1600a(true);
                } else {
                    System.arraycopy(this.f1034a, 0, bArr2, i7, i8);
                    this.f1036c = i8;
                    return bArr2;
                }
            }
        } else {
            this.f1038e = i2 + i6;
            this.f1036c = 0;
            this.f1032a = 0;
            int i11 = i6 - i3;
            int i12 = i - i11;
            Vector vector = new Vector();
            while (i12 > 0) {
                int min = Math.min(i12, 4096);
                byte[] bArr3 = new byte[min];
                int i13 = 0;
                while (i13 < min) {
                    InputStream inputStream = this.f1033a;
                    int read = inputStream == null ? -1 : inputStream.read(bArr3, i13, min - i13);
                    if (read == -1) {
                        throw C1547d.m1998a();
                    }
                    this.f1038e += read;
                    i13 += read;
                }
                i12 -= min;
                vector.addElement(bArr3);
            }
            byte[] bArr4 = new byte[i];
            System.arraycopy(this.f1034a, i3, bArr4, 0, i11);
            for (int i14 = 0; i14 < vector.size(); i14++) {
                byte[] bArr5 = (byte[]) vector.elementAt(i14);
                System.arraycopy(bArr5, 0, bArr4, i11, bArr5.length);
                i11 += bArr5.length;
            }
            return bArr4;
        }
    }

    /* renamed from: c */
    public void m1620c(int i) {
        if (i < 0) {
            throw C1547d.m1999b();
        }
        int i2 = this.f1038e;
        int i3 = this.f1036c;
        int i4 = i2 + i3 + i;
        int i5 = this.f1039f;
        if (i4 > i5) {
            m1620c((i5 - i2) - i3);
            throw C1547d.m1998a();
        }
        int i6 = this.f1032a;
        if (i <= i6 - i3) {
            this.f1036c = i3 + i;
            return;
        }
        int i7 = i6 - i3;
        this.f1038e = i2 + i6;
        this.f1036c = 0;
        this.f1032a = 0;
        while (i7 < i) {
            InputStream inputStream = this.f1033a;
            int skip = inputStream == null ? -1 : (int) inputStream.skip(i - i7);
            if (skip <= 0) {
                throw C1547d.m1998a();
            }
            i7 += skip;
            this.f1038e += skip;
        }
    }
}
