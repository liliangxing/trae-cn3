package com.heytap.msp.push.encrypt;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;

/* renamed from: com.heytap.msp.push.encrypt.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC0900b implements BinaryDecoder, BinaryEncoder {

    /* renamed from: a */
    private static final int f655a = 2;

    /* renamed from: b */
    public static final int f656b = 76;

    /* renamed from: c */
    public static final int f657c = 64;

    /* renamed from: d */
    protected static final int f658d = 255;

    /* renamed from: e */
    protected static final byte f659e = 61;

    /* renamed from: m */
    private static final int f660m = 8192;

    /* renamed from: f */
    protected final byte f661f = f659e;

    /* renamed from: g */
    protected final int f662g;

    /* renamed from: h */
    protected byte[] f663h;

    /* renamed from: i */
    protected int f664i;

    /* renamed from: j */
    protected boolean f665j;

    /* renamed from: k */
    protected int f666k;

    /* renamed from: l */
    protected int f667l;

    /* renamed from: n */
    private final int f668n;

    /* renamed from: o */
    private final int f669o;

    /* renamed from: p */
    private final int f670p;

    /* renamed from: q */
    private int f671q;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0900b(int i, int i2, int i3, int i4) {
        this.f668n = i;
        this.f669o = i2;
        this.f662g = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.f670p = i4;
    }

    /* renamed from: a */
    private void m715a() {
        byte[] bArr = this.f663h;
        if (bArr == null) {
            this.f663h = new byte[m724d()];
            this.f664i = 0;
            this.f671q = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f663h = bArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public static boolean m716c(byte b) {
        return b == 9 || b == 10 || b == 13 || b == 32;
    }

    /* renamed from: e */
    private void m717e() {
        this.f663h = null;
        this.f664i = 0;
        this.f671q = 0;
        this.f666k = 0;
        this.f667l = 0;
        this.f665j = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m718a(int i) {
        byte[] bArr = this.f663h;
        if (bArr == null || bArr.length < this.f664i + i) {
            m715a();
        }
    }

    /* renamed from: a */
    abstract void mo711a(byte[] bArr, int i, int i2);

    /* renamed from: b */
    abstract void mo713b(byte[] bArr, int i, int i2);

    /* renamed from: b */
    boolean m719b() {
        return this.f663h != null;
    }

    /* renamed from: b */
    protected abstract boolean mo714b(byte b);

    /* renamed from: b */
    public boolean m720b(byte[] bArr, boolean z) {
        byte b;
        for (int i = 0; i < bArr.length; i++) {
            if (!mo714b(bArr[i]) && (!z || ((b = bArr[i]) != 61 && !m716c(b)))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    int m721c() {
        if (this.f663h != null) {
            return this.f664i - this.f671q;
        }
        return 0;
    }

    /* renamed from: c */
    int m722c(byte[] bArr, int i, int i2) {
        if (this.f663h == null) {
            return this.f665j ? -1 : 0;
        }
        int min = Math.min(m721c(), i2);
        System.arraycopy(this.f663h, this.f671q, bArr, i, min);
        int i3 = this.f671q + min;
        this.f671q = i3;
        if (i3 >= this.f664i) {
            this.f663h = null;
        }
        return min;
    }

    /* renamed from: c */
    public byte[] m723c(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    /* renamed from: d */
    protected int m724d() {
        return 8192;
    }

    /* renamed from: d */
    public boolean m725d(String str) {
        return m720b(StringUtils.getBytesUtf8(str), true);
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return m723c((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        m717e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo713b(bArr, 0, bArr.length);
        mo713b(bArr, 0, -1);
        int i = this.f664i;
        byte[] bArr2 = new byte[i];
        m722c(bArr2, 0, i);
        return bArr2;
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        m717e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo711a(bArr, 0, bArr.length);
        mo711a(bArr, 0, -1);
        int i = this.f664i - this.f671q;
        byte[] bArr2 = new byte[i];
        m722c(bArr2, 0, i);
        return bArr2;
    }

    /* renamed from: j */
    public String m726j(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    /* renamed from: k */
    public String m727k(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public boolean m728l(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (61 == b || mo714b(b)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    public long m729m(byte[] bArr) {
        int length = bArr.length;
        int i = this.f668n;
        long j = (((length + i) - 1) / i) * this.f669o;
        int i2 = this.f662g;
        return i2 > 0 ? j + ((((i2 + j) - 1) / i2) * this.f670p) : j;
    }
}
