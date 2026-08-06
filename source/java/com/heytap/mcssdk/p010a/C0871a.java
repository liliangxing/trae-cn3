package com.heytap.mcssdk.p010a;

import com.facebook.imageutils.JfifUtil;
import java.math.BigInteger;
import org.apache.commons.codec.binary.StringUtils;

/* renamed from: com.heytap.mcssdk.a.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0871a extends AbstractC0872b {

    /* renamed from: m */
    private static final int f468m = 6;

    /* renamed from: n */
    private static final int f469n = 3;

    /* renamed from: o */
    private static final int f470o = 4;

    /* renamed from: s */
    private static final int f474s = 63;

    /* renamed from: t */
    private final byte[] f475t;

    /* renamed from: u */
    private final byte[] f476u;

    /* renamed from: v */
    private final byte[] f477v;

    /* renamed from: w */
    private final int f478w;

    /* renamed from: x */
    private final int f479x;

    /* renamed from: y */
    private int f480y;

    /* renamed from: a */
    static final byte[] f467a = {13, 10};

    /* renamed from: p */
    private static final byte[] f471p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: q */
    private static final byte[] f472q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: r */
    private static final byte[] f473r = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public C0871a() {
        this(0);
    }

    public C0871a(int i) {
        this(i, f467a);
    }

    public C0871a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0871a(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.f476u = f473r;
        if (bArr != null) {
            if (m577l(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + StringUtils.newStringUtf8(bArr) + "]");
            }
            if (i > 0) {
                this.f479x = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.f477v = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.f478w = this.f479x - 1;
                this.f475t = !z ? f472q : f471p;
            }
        }
        this.f479x = 4;
        this.f477v = null;
        this.f478w = this.f479x - 1;
        this.f475t = !z ? f472q : f471p;
    }

    public C0871a(boolean z) {
        this(76, f467a, z);
    }

    /* renamed from: a */
    public static boolean m543a(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = f473r;
                if (b >= bArr.length || bArr[b] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m544a(String str) {
        return m550b(StringUtils.getBytesUtf8(str));
    }

    /* renamed from: a */
    public static boolean m545a(byte[] bArr) {
        return m550b(bArr);
    }

    /* renamed from: a */
    public static byte[] m546a(BigInteger bigInteger) {
        if (bigInteger != null) {
            return m547a(m552b(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    /* renamed from: a */
    public static byte[] m547a(byte[] bArr, boolean z) {
        return m548a(bArr, z, false);
    }

    /* renamed from: a */
    public static byte[] m548a(byte[] bArr, boolean z, boolean z2) {
        return m549a(bArr, z, z2, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static byte[] m549a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C0871a c0871a = z ? new C0871a(z2) : new C0871a(0, f467a, z2);
        long m = c0871a.m578m(bArr);
        if (m <= i) {
            return c0871a.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + m + ") than the specified maximum size of " + i);
    }

    /* renamed from: b */
    public static boolean m550b(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!m543a(bArr[i]) && !m565c(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static byte[] m551b(String str) {
        return new C0871a().m572c(str);
    }

    /* renamed from: b */
    static byte[] m552b(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i = 0;
        }
        int i2 = bitLength / 8;
        int i3 = i2 - length;
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i, bArr, i3, length);
        return bArr;
    }

    /* renamed from: c */
    public static byte[] m553c(byte[] bArr) {
        return m547a(bArr, false);
    }

    /* renamed from: d */
    public static String m554d(byte[] bArr) {
        return StringUtils.newStringUtf8(m547a(bArr, false));
    }

    /* renamed from: e */
    public static byte[] m555e(byte[] bArr) {
        return m548a(bArr, false, true);
    }

    /* renamed from: f */
    public static String m556f(byte[] bArr) {
        return StringUtils.newStringUtf8(m548a(bArr, false, true));
    }

    /* renamed from: g */
    public static byte[] m557g(byte[] bArr) {
        return m547a(bArr, true);
    }

    /* renamed from: h */
    public static byte[] m558h(byte[] bArr) {
        return new C0871a().decode(bArr);
    }

    /* renamed from: i */
    public static BigInteger m559i(byte[] bArr) {
        return new BigInteger(1, m558h(bArr));
    }

    @Override // com.heytap.mcssdk.p010a.AbstractC0872b
    /* renamed from: a */
    void mo560a(byte[] bArr, int i, int i2) {
        if (this.f491j) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                m567a(this.f479x);
                this.f493l = (this.f493l + 1) % 3;
                int i4 = i + 1;
                int i5 = bArr[i];
                if (i5 < 0) {
                    i5 += 256;
                }
                this.f480y = (this.f480y << 8) + i5;
                if (this.f493l == 0) {
                    byte[] bArr2 = this.f489h;
                    int i6 = this.f490i;
                    this.f490i = i6 + 1;
                    bArr2[i6] = this.f475t[(this.f480y >> 18) & 63];
                    byte[] bArr3 = this.f489h;
                    int i7 = this.f490i;
                    this.f490i = i7 + 1;
                    bArr3[i7] = this.f475t[(this.f480y >> 12) & 63];
                    byte[] bArr4 = this.f489h;
                    int i8 = this.f490i;
                    this.f490i = i8 + 1;
                    bArr4[i8] = this.f475t[(this.f480y >> 6) & 63];
                    byte[] bArr5 = this.f489h;
                    int i9 = this.f490i;
                    this.f490i = i9 + 1;
                    bArr5[i9] = this.f475t[this.f480y & 63];
                    this.f492k += 4;
                    if (this.f488g > 0 && this.f488g <= this.f492k) {
                        System.arraycopy(this.f477v, 0, this.f489h, this.f490i, this.f477v.length);
                        this.f490i += this.f477v.length;
                        this.f492k = 0;
                    }
                }
                i3++;
                i = i4;
            }
            return;
        }
        this.f491j = true;
        if (this.f493l == 0 && this.f488g == 0) {
            return;
        }
        m567a(this.f479x);
        int i10 = this.f490i;
        int i11 = this.f493l;
        if (i11 == 1) {
            byte[] bArr6 = this.f489h;
            int i12 = this.f490i;
            this.f490i = i12 + 1;
            bArr6[i12] = this.f475t[(this.f480y >> 2) & 63];
            byte[] bArr7 = this.f489h;
            int i13 = this.f490i;
            this.f490i = i13 + 1;
            byte[] bArr8 = this.f475t;
            bArr7[i13] = bArr8[(this.f480y << 4) & 63];
            if (bArr8 == f471p) {
                byte[] bArr9 = this.f489h;
                int i14 = this.f490i;
                this.f490i = i14 + 1;
                bArr9[i14] = 61;
                byte[] bArr10 = this.f489h;
                int i15 = this.f490i;
                this.f490i = i15 + 1;
                bArr10[i15] = 61;
            }
        } else if (i11 == 2) {
            byte[] bArr11 = this.f489h;
            int i16 = this.f490i;
            this.f490i = i16 + 1;
            bArr11[i16] = this.f475t[(this.f480y >> 10) & 63];
            byte[] bArr12 = this.f489h;
            int i17 = this.f490i;
            this.f490i = i17 + 1;
            bArr12[i17] = this.f475t[(this.f480y >> 4) & 63];
            byte[] bArr13 = this.f489h;
            int i18 = this.f490i;
            this.f490i = i18 + 1;
            byte[] bArr14 = this.f475t;
            bArr13[i18] = bArr14[(this.f480y << 2) & 63];
            if (bArr14 == f471p) {
                byte[] bArr15 = this.f489h;
                int i19 = this.f490i;
                this.f490i = i19 + 1;
                bArr15[i19] = 61;
            }
        }
        this.f492k += this.f490i - i10;
        if (this.f488g <= 0 || this.f492k <= 0) {
            return;
        }
        System.arraycopy(this.f477v, 0, this.f489h, this.f490i, this.f477v.length);
        this.f490i += this.f477v.length;
    }

    /* renamed from: a */
    public boolean m561a() {
        return this.f475t == f472q;
    }

    @Override // com.heytap.mcssdk.p010a.AbstractC0872b
    /* renamed from: b */
    void mo562b(byte[] bArr, int i, int i2) {
        byte b;
        if (this.f491j) {
            return;
        }
        if (i2 < 0) {
            this.f491j = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            m567a(this.f478w);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == 61) {
                this.f491j = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = f473r;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    this.f493l = (this.f493l + 1) % 4;
                    this.f480y = (this.f480y << 6) + b;
                    if (this.f493l == 0) {
                        byte[] bArr3 = this.f489h;
                        int i5 = this.f490i;
                        this.f490i = i5 + 1;
                        bArr3[i5] = (byte) ((this.f480y >> 16) & JfifUtil.MARKER_FIRST_BYTE);
                        byte[] bArr4 = this.f489h;
                        int i6 = this.f490i;
                        this.f490i = i6 + 1;
                        bArr4[i6] = (byte) ((this.f480y >> 8) & JfifUtil.MARKER_FIRST_BYTE);
                        byte[] bArr5 = this.f489h;
                        int i7 = this.f490i;
                        this.f490i = i7 + 1;
                        bArr5[i7] = (byte) (this.f480y & JfifUtil.MARKER_FIRST_BYTE);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!this.f491j || this.f493l == 0) {
            return;
        }
        m567a(this.f478w);
        int i8 = this.f493l;
        if (i8 == 2) {
            this.f480y >>= 4;
            byte[] bArr6 = this.f489h;
            int i9 = this.f490i;
            this.f490i = i9 + 1;
            bArr6[i9] = (byte) (this.f480y & JfifUtil.MARKER_FIRST_BYTE);
            return;
        }
        if (i8 != 3) {
            return;
        }
        this.f480y >>= 2;
        byte[] bArr7 = this.f489h;
        int i10 = this.f490i;
        this.f490i = i10 + 1;
        bArr7[i10] = (byte) ((this.f480y >> 8) & JfifUtil.MARKER_FIRST_BYTE);
        byte[] bArr8 = this.f489h;
        int i11 = this.f490i;
        this.f490i = i11 + 1;
        bArr8[i11] = (byte) (this.f480y & JfifUtil.MARKER_FIRST_BYTE);
    }

    @Override // com.heytap.mcssdk.p010a.AbstractC0872b
    /* renamed from: b */
    protected boolean mo563b(byte b) {
        if (b >= 0) {
            byte[] bArr = this.f476u;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }
}
