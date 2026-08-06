package com.heytap.msp.push.encrypt;

import java.math.BigInteger;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.apache.commons.codec.binary.StringUtils;
import org.bouncycastle.math.ec.Tnaf;

/* loaded from: classes6.dex */
public class a extends b {
    private static final int m = 6;
    private static final int n = 3;
    private static final int o = 4;
    private static final int s = 63;
    private final byte[] t;
    private final byte[] u;
    private final byte[] v;
    private final int w;
    private final int x;
    private int y;
    static final byte[] a = {13, 10};
    private static final byte[] p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] r = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, Tnaf.POW_2_WIDTH, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public a() {
        this(0);
    }

    public a(int i) {
        this(i, a);
    }

    public a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.u = r;
        if (bArr != null) {
            if (l(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + StringUtils.newStringUtf8(bArr) + "]");
            }
            if (i > 0) {
                this.x = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.v = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.w = this.x - 1;
                this.t = !z ? q : p;
            }
        }
        this.x = 4;
        this.v = null;
        this.w = this.x - 1;
        this.t = !z ? q : p;
    }

    public a(boolean z) {
        this(76, a, z);
    }

    public static boolean a(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = r;
                if (b >= bArr.length || bArr[b] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean a(String str) {
        return b(StringUtils.getBytesUtf8(str));
    }

    public static boolean a(byte[] bArr) {
        return b(bArr);
    }

    public static byte[] a(BigInteger bigInteger) {
        if (bigInteger != null) {
            return a(b(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    public static byte[] a(byte[] bArr, boolean z) {
        return a(bArr, z, false);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2) {
        return a(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = z ? new a(z2) : new a(0, a, z2);
        long m2 = aVar.m(bArr);
        if (m2 <= i) {
            return aVar.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + m2 + ") than the specified maximum size of " + i);
    }

    public static boolean b(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!a(bArr[i]) && !c(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static byte[] b(String str) {
        return new a().c(str);
    }

    static byte[] b(BigInteger bigInteger) {
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

    public static byte[] c(byte[] bArr) {
        return a(bArr, false);
    }

    public static String d(byte[] bArr) {
        return StringUtils.newStringUtf8(a(bArr, false));
    }

    public static byte[] e(byte[] bArr) {
        return a(bArr, false, true);
    }

    public static String f(byte[] bArr) {
        return StringUtils.newStringUtf8(a(bArr, false, true));
    }

    public static byte[] g(byte[] bArr) {
        return a(bArr, true);
    }

    public static byte[] h(byte[] bArr) {
        return new a().decode(bArr);
    }

    public static BigInteger i(byte[] bArr) {
        return new BigInteger(1, h(bArr));
    }

    @Override // com.heytap.msp.push.encrypt.b
    void a(byte[] bArr, int i, int i2) {
        if (this.j) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                a(this.x);
                this.l = (this.l + 1) % 3;
                int i4 = i + 1;
                int i5 = bArr[i];
                if (i5 < 0) {
                    i5 += 256;
                }
                this.y = (this.y << 8) + i5;
                if (this.l == 0) {
                    byte[] bArr2 = this.h;
                    int i6 = this.i;
                    this.i = i6 + 1;
                    bArr2[i6] = this.t[(this.y >> 18) & 63];
                    byte[] bArr3 = this.h;
                    int i7 = this.i;
                    this.i = i7 + 1;
                    bArr3[i7] = this.t[(this.y >> 12) & 63];
                    byte[] bArr4 = this.h;
                    int i8 = this.i;
                    this.i = i8 + 1;
                    bArr4[i8] = this.t[(this.y >> 6) & 63];
                    byte[] bArr5 = this.h;
                    int i9 = this.i;
                    this.i = i9 + 1;
                    bArr5[i9] = this.t[this.y & 63];
                    this.k += 4;
                    if (this.g > 0 && this.g <= this.k) {
                        System.arraycopy(this.v, 0, this.h, this.i, this.v.length);
                        this.i += this.v.length;
                        this.k = 0;
                    }
                }
                i3++;
                i = i4;
            }
            return;
        }
        this.j = true;
        if (this.l == 0 && this.g == 0) {
            return;
        }
        a(this.x);
        int i10 = this.i;
        int i11 = this.l;
        if (i11 == 1) {
            byte[] bArr6 = this.h;
            int i12 = this.i;
            this.i = i12 + 1;
            bArr6[i12] = this.t[(this.y >> 2) & 63];
            byte[] bArr7 = this.h;
            int i13 = this.i;
            this.i = i13 + 1;
            byte[] bArr8 = this.t;
            bArr7[i13] = bArr8[(this.y << 4) & 63];
            if (bArr8 == p) {
                byte[] bArr9 = this.h;
                int i14 = this.i;
                this.i = i14 + 1;
                bArr9[i14] = Base64.padSymbol;
                byte[] bArr10 = this.h;
                int i15 = this.i;
                this.i = i15 + 1;
                bArr10[i15] = Base64.padSymbol;
            }
        } else if (i11 == 2) {
            byte[] bArr11 = this.h;
            int i16 = this.i;
            this.i = i16 + 1;
            bArr11[i16] = this.t[(this.y >> 10) & 63];
            byte[] bArr12 = this.h;
            int i17 = this.i;
            this.i = i17 + 1;
            bArr12[i17] = this.t[(this.y >> 4) & 63];
            byte[] bArr13 = this.h;
            int i18 = this.i;
            this.i = i18 + 1;
            byte[] bArr14 = this.t;
            bArr13[i18] = bArr14[(this.y << 2) & 63];
            if (bArr14 == p) {
                byte[] bArr15 = this.h;
                int i19 = this.i;
                this.i = i19 + 1;
                bArr15[i19] = Base64.padSymbol;
            }
        }
        this.k += this.i - i10;
        if (this.g <= 0 || this.k <= 0) {
            return;
        }
        System.arraycopy(this.v, 0, this.h, this.i, this.v.length);
        this.i += this.v.length;
    }

    public boolean a() {
        return this.t == q;
    }

    @Override // com.heytap.msp.push.encrypt.b
    void b(byte[] bArr, int i, int i2) {
        byte b;
        if (this.j) {
            return;
        }
        if (i2 < 0) {
            this.j = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            a(this.w);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == 61) {
                this.j = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = r;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    this.l = (this.l + 1) % 4;
                    this.y = (this.y << 6) + b;
                    if (this.l == 0) {
                        byte[] bArr3 = this.h;
                        int i5 = this.i;
                        this.i = i5 + 1;
                        bArr3[i5] = (byte) ((this.y >> 16) & 255);
                        byte[] bArr4 = this.h;
                        int i6 = this.i;
                        this.i = i6 + 1;
                        bArr4[i6] = (byte) ((this.y >> 8) & 255);
                        byte[] bArr5 = this.h;
                        int i7 = this.i;
                        this.i = i7 + 1;
                        bArr5[i7] = (byte) (this.y & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!this.j || this.l == 0) {
            return;
        }
        a(this.w);
        int i8 = this.l;
        if (i8 == 2) {
            this.y >>= 4;
            byte[] bArr6 = this.h;
            int i9 = this.i;
            this.i = i9 + 1;
            bArr6[i9] = (byte) (this.y & 255);
            return;
        }
        if (i8 != 3) {
            return;
        }
        this.y >>= 2;
        byte[] bArr7 = this.h;
        int i10 = this.i;
        this.i = i10 + 1;
        bArr7[i10] = (byte) ((this.y >> 8) & 255);
        byte[] bArr8 = this.h;
        int i11 = this.i;
        this.i = i11 + 1;
        bArr8[i11] = (byte) (this.y & 255);
    }

    @Override // com.heytap.msp.push.encrypt.b
    protected boolean b(byte b) {
        if (b >= 0) {
            byte[] bArr = this.u;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }
}
