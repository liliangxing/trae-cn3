package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes7.dex */
public final class c {
    private final int a;

    /* renamed from: a, reason: collision with other field name */
    private final OutputStream f233a;

    /* renamed from: a, reason: collision with other field name */
    private final byte[] f234a;
    private int b;

    public static int a(boolean z) {
        return 1;
    }

    public static int c(long j) {
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

    public static int d(int i) {
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

    private c(byte[] bArr, int i, int i2) {
        this.f233a = null;
        this.f234a = bArr;
        this.b = i;
        this.a = i + i2;
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f233a = outputStream;
        this.f234a = bArr;
        this.b = 0;
        this.a = bArr.length;
    }

    public static c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static c a(OutputStream outputStream, int i) {
        return new c(outputStream, new byte[i]);
    }

    public static c a(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9677a(int i, long j) {
        c(i, 0);
        m9682a(j);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m9690b(int i, long j) {
        c(i, 0);
        m9691b(j);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9676a(int i, int i2) {
        c(i, 0);
        m9675a(i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9681a(int i, boolean z) {
        c(i, 0);
        m9686a(z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9680a(int i, String str) {
        c(i, 2);
        m9685a(str);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9679a(int i, e eVar) {
        c(i, 2);
        m9684a(eVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9678a(int i, com.xiaomi.push.a aVar) {
        c(i, 2);
        m9683a(aVar);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m9689b(int i, int i2) {
        c(i, 0);
        m9688b(i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9682a(long j) {
        m9693c(j);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m9691b(long j) {
        m9693c(j);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9675a(int i) {
        if (i >= 0) {
            m9694d(i);
        } else {
            m9693c(i);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9686a(boolean z) {
        m9692c(z ? 1 : 0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9685a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m9694d(bytes.length);
        a(bytes);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9684a(e eVar) {
        m9694d(eVar.a());
        eVar.a(this);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9683a(com.xiaomi.push.a aVar) {
        byte[] m9605a = aVar.m9605a();
        m9694d(m9605a.length);
        a(m9605a);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m9688b(int i) {
        m9694d(i);
    }

    public static int a(int i, long j) {
        return c(i) + a(j);
    }

    public static int b(int i, long j) {
        return c(i) + b(j);
    }

    public static int a(int i, int i2) {
        return c(i) + a(i2);
    }

    public static int a(int i, boolean z) {
        return c(i) + a(z);
    }

    public static int a(int i, String str) {
        return c(i) + a(str);
    }

    public static int a(int i, e eVar) {
        return c(i) + a(eVar);
    }

    public static int a(int i, com.xiaomi.push.a aVar) {
        return c(i) + a(aVar);
    }

    public static int b(int i, int i2) {
        return c(i) + b(i2);
    }

    public static int a(long j) {
        return c(j);
    }

    public static int b(long j) {
        return c(j);
    }

    public static int a(int i) {
        if (i >= 0) {
            return d(i);
        }
        return 10;
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(e eVar) {
        int b = eVar.b();
        return d(b) + b;
    }

    public static int a(com.xiaomi.push.a aVar) {
        return d(aVar.a()) + aVar.a();
    }

    public static int b(int i) {
        return d(i);
    }

    private void c() {
        OutputStream outputStream = this.f233a;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f234a, 0, this.b);
        this.b = 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9674a() {
        if (this.f233a != null) {
            c();
        }
    }

    public int a() {
        if (this.f233a == null) {
            return this.a - this.b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public void a(byte b) {
        if (this.b == this.a) {
            c();
        }
        byte[] bArr = this.f234a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m9692c(int i) {
        a((byte) i);
    }

    public void a(byte[] bArr) {
        m9687a(bArr, 0, bArr.length);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9687a(byte[] bArr, int i, int i2) {
        int i3 = this.a;
        int i4 = this.b;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f234a, i4, i2);
            this.b += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f234a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.b = this.a;
        c();
        if (i7 <= this.a) {
            System.arraycopy(bArr, i6, this.f234a, 0, i7);
            this.b = i7;
        } else {
            this.f233a.write(bArr, i6, i7);
        }
    }

    public void c(int i, int i2) {
        m9694d(f.a(i, i2));
    }

    public static int c(int i) {
        return d(f.a(i, 0));
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m9694d(int i) {
        while ((i & (-128)) != 0) {
            m9692c((i & 127) | 128);
            i >>>= 7;
        }
        m9692c(i);
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m9693c(long j) {
        while (((-128) & j) != 0) {
            m9692c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m9692c((int) j);
    }
}
