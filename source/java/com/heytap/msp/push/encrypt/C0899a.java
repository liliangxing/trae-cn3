package com.heytap.msp.push.encrypt;

import com.facebook.imageutils.JfifUtil;
import java.math.BigInteger;
import org.apache.commons.codec.binary.StringUtils;

/* renamed from: com.heytap.msp.push.encrypt.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0899a extends AbstractC0900b {

    /* renamed from: m */
    private static final int f642m = 6;

    /* renamed from: n */
    private static final int f643n = 3;

    /* renamed from: o */
    private static final int f644o = 4;

    /* renamed from: s */
    private static final int f648s = 63;

    /* renamed from: t */
    private final byte[] f649t;

    /* renamed from: u */
    private final byte[] f650u;

    /* renamed from: v */
    private final byte[] f651v;

    /* renamed from: w */
    private final int f652w;

    /* renamed from: x */
    private final int f653x;

    /* renamed from: y */
    private int f654y;

    /* renamed from: a */
    static final byte[] f641a = {13, 10};

    /* renamed from: p */
    private static final byte[] f645p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: q */
    private static final byte[] f646q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: r */
    private static final byte[] f647r = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public C0899a() {
        this(0);
    }

    public C0899a(int i) {
        this(i, f641a);
    }

    public C0899a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0899a(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.f650u = f647r;
        if (bArr != null) {
            if (m728l(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + StringUtils.newStringUtf8(bArr) + "]");
            }
            if (i > 0) {
                this.f653x = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.f651v = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.f652w = this.f653x - 1;
                this.f649t = !z ? f646q : f645p;
            }
        }
        this.f653x = 4;
        this.f651v = null;
        this.f652w = this.f653x - 1;
        this.f649t = !z ? f646q : f645p;
    }

    public C0899a(boolean z) {
        this(76, f641a, z);
    }

    /* renamed from: a */
    public static boolean m694a(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = f647r;
                if (b >= bArr.length || bArr[b] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m695a(String str) {
        return m701b(StringUtils.getBytesUtf8(str));
    }

    /* renamed from: a */
    public static boolean m696a(byte[] bArr) {
        return m701b(bArr);
    }

    /* renamed from: a */
    public static byte[] m697a(BigInteger bigInteger) {
        if (bigInteger != null) {
            return m698a(m703b(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    /* renamed from: a */
    public static byte[] m698a(byte[] bArr, boolean z) {
        return m699a(bArr, z, false);
    }

    /* renamed from: a */
    public static byte[] m699a(byte[] bArr, boolean z, boolean z2) {
        return m700a(bArr, z, z2, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static byte[] m700a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C0899a c0899a = z ? new C0899a(z2) : new C0899a(0, f641a, z2);
        long m = c0899a.m729m(bArr);
        if (m <= i) {
            return c0899a.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + m + ") than the specified maximum size of " + i);
    }

    /* renamed from: b */
    public static boolean m701b(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!m694a(bArr[i]) && !m716c(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static byte[] m702b(String str) {
        return new C0899a().m723c(str);
    }

    /* renamed from: b */
    static byte[] m703b(BigInteger bigInteger) {
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
    public static byte[] m704c(byte[] bArr) {
        return m698a(bArr, false);
    }

    /* renamed from: d */
    public static String m705d(byte[] bArr) {
        return StringUtils.newStringUtf8(m698a(bArr, false));
    }

    /* renamed from: e */
    public static byte[] m706e(byte[] bArr) {
        return m699a(bArr, false, true);
    }

    /* renamed from: f */
    public static String m707f(byte[] bArr) {
        return StringUtils.newStringUtf8(m699a(bArr, false, true));
    }

    /* renamed from: g */
    public static byte[] m708g(byte[] bArr) {
        return m698a(bArr, true);
    }

    /* renamed from: h */
    public static byte[] m709h(byte[] bArr) {
        return new C0899a().decode(bArr);
    }

    /* renamed from: i */
    public static BigInteger m710i(byte[] bArr) {
        return new BigInteger(1, m709h(bArr));
    }

    @Override // com.heytap.msp.push.encrypt.AbstractC0900b
    /* renamed from: a */
    void mo711a(byte[] bArr, int i, int i2) {
        if (this.f665j) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                m718a(this.f653x);
                this.f667l = (this.f667l + 1) % 3;
                int i4 = i + 1;
                int i5 = bArr[i];
                if (i5 < 0) {
                    i5 += 256;
                }
                this.f654y = (this.f654y << 8) + i5;
                if (this.f667l == 0) {
                    byte[] bArr2 = this.f663h;
                    int i6 = this.f664i;
                    this.f664i = i6 + 1;
                    bArr2[i6] = this.f649t[(this.f654y >> 18) & 63];
                    byte[] bArr3 = this.f663h;
                    int i7 = this.f664i;
                    this.f664i = i7 + 1;
                    bArr3[i7] = this.f649t[(this.f654y >> 12) & 63];
                    byte[] bArr4 = this.f663h;
                    int i8 = this.f664i;
                    this.f664i = i8 + 1;
                    bArr4[i8] = this.f649t[(this.f654y >> 6) & 63];
                    byte[] bArr5 = this.f663h;
                    int i9 = this.f664i;
                    this.f664i = i9 + 1;
                    bArr5[i9] = this.f649t[this.f654y & 63];
                    this.f666k += 4;
                    if (this.f662g > 0 && this.f662g <= this.f666k) {
                        System.arraycopy(this.f651v, 0, this.f663h, this.f664i, this.f651v.length);
                        this.f664i += this.f651v.length;
                        this.f666k = 0;
                    }
                }
                i3++;
                i = i4;
            }
            return;
        }
        this.f665j = true;
        if (this.f667l == 0 && this.f662g == 0) {
            return;
        }
        m718a(this.f653x);
        int i10 = this.f664i;
        int i11 = this.f667l;
        if (i11 == 1) {
            byte[] bArr6 = this.f663h;
            int i12 = this.f664i;
            this.f664i = i12 + 1;
            bArr6[i12] = this.f649t[(this.f654y >> 2) & 63];
            byte[] bArr7 = this.f663h;
            int i13 = this.f664i;
            this.f664i = i13 + 1;
            byte[] bArr8 = this.f649t;
            bArr7[i13] = bArr8[(this.f654y << 4) & 63];
            if (bArr8 == f645p) {
                byte[] bArr9 = this.f663h;
                int i14 = this.f664i;
                this.f664i = i14 + 1;
                bArr9[i14] = 61;
                byte[] bArr10 = this.f663h;
                int i15 = this.f664i;
                this.f664i = i15 + 1;
                bArr10[i15] = 61;
            }
        } else if (i11 == 2) {
            byte[] bArr11 = this.f663h;
            int i16 = this.f664i;
            this.f664i = i16 + 1;
            bArr11[i16] = this.f649t[(this.f654y >> 10) & 63];
            byte[] bArr12 = this.f663h;
            int i17 = this.f664i;
            this.f664i = i17 + 1;
            bArr12[i17] = this.f649t[(this.f654y >> 4) & 63];
            byte[] bArr13 = this.f663h;
            int i18 = this.f664i;
            this.f664i = i18 + 1;
            byte[] bArr14 = this.f649t;
            bArr13[i18] = bArr14[(this.f654y << 2) & 63];
            if (bArr14 == f645p) {
                byte[] bArr15 = this.f663h;
                int i19 = this.f664i;
                this.f664i = i19 + 1;
                bArr15[i19] = 61;
            }
        }
        this.f666k += this.f664i - i10;
        if (this.f662g <= 0 || this.f666k <= 0) {
            return;
        }
        System.arraycopy(this.f651v, 0, this.f663h, this.f664i, this.f651v.length);
        this.f664i += this.f651v.length;
    }

    /* renamed from: a */
    public boolean m712a() {
        return this.f649t == f646q;
    }

    @Override // com.heytap.msp.push.encrypt.AbstractC0900b
    /* renamed from: b */
    void mo713b(byte[] bArr, int i, int i2) {
        byte b;
        if (this.f665j) {
            return;
        }
        if (i2 < 0) {
            this.f665j = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            m718a(this.f652w);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == 61) {
                this.f665j = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = f647r;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    this.f667l = (this.f667l + 1) % 4;
                    this.f654y = (this.f654y << 6) + b;
                    if (this.f667l == 0) {
                        byte[] bArr3 = this.f663h;
                        int i5 = this.f664i;
                        this.f664i = i5 + 1;
                        bArr3[i5] = (byte) ((this.f654y >> 16) & JfifUtil.MARKER_FIRST_BYTE);
                        byte[] bArr4 = this.f663h;
                        int i6 = this.f664i;
                        this.f664i = i6 + 1;
                        bArr4[i6] = (byte) ((this.f654y >> 8) & JfifUtil.MARKER_FIRST_BYTE);
                        byte[] bArr5 = this.f663h;
                        int i7 = this.f664i;
                        this.f664i = i7 + 1;
                        bArr5[i7] = (byte) (this.f654y & JfifUtil.MARKER_FIRST_BYTE);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!this.f665j || this.f667l == 0) {
            return;
        }
        m718a(this.f652w);
        int i8 = this.f667l;
        if (i8 == 2) {
            this.f654y >>= 4;
            byte[] bArr6 = this.f663h;
            int i9 = this.f664i;
            this.f664i = i9 + 1;
            bArr6[i9] = (byte) (this.f654y & JfifUtil.MARKER_FIRST_BYTE);
            return;
        }
        if (i8 != 3) {
            return;
        }
        this.f654y >>= 2;
        byte[] bArr7 = this.f663h;
        int i10 = this.f664i;
        this.f664i = i10 + 1;
        bArr7[i10] = (byte) ((this.f654y >> 8) & JfifUtil.MARKER_FIRST_BYTE);
        byte[] bArr8 = this.f663h;
        int i11 = this.f664i;
        this.f664i = i11 + 1;
        bArr8[i11] = (byte) (this.f654y & JfifUtil.MARKER_FIRST_BYTE);
    }

    @Override // com.heytap.msp.push.encrypt.AbstractC0900b
    /* renamed from: b */
    protected boolean mo714b(byte b) {
        if (b >= 0) {
            byte[] bArr = this.f650u;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }
}
