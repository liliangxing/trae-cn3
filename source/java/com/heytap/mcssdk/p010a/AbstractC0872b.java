package com.heytap.mcssdk.p010a;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;

/* renamed from: com.heytap.mcssdk.a.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC0872b implements BinaryDecoder, BinaryEncoder {

    /* renamed from: a */
    private static final int f481a = 2;

    /* renamed from: b */
    public static final int f482b = 76;

    /* renamed from: c */
    public static final int f483c = 64;

    /* renamed from: d */
    protected static final int f484d = 255;

    /* renamed from: e */
    protected static final byte f485e = 61;

    /* renamed from: m */
    private static final int f486m = 8192;

    /* renamed from: f */
    protected final byte f487f = f485e;

    /* renamed from: g */
    protected final int f488g;

    /* renamed from: h */
    protected byte[] f489h;

    /* renamed from: i */
    protected int f490i;

    /* renamed from: j */
    protected boolean f491j;

    /* renamed from: k */
    protected int f492k;

    /* renamed from: l */
    protected int f493l;

    /* renamed from: n */
    private final int f494n;

    /* renamed from: o */
    private final int f495o;

    /* renamed from: p */
    private final int f496p;

    /* renamed from: q */
    private int f497q;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0872b(int i, int i2, int i3, int i4) {
        this.f494n = i;
        this.f495o = i2;
        this.f488g = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.f496p = i4;
    }

    /* renamed from: a */
    private void m564a() {
        byte[] bArr = this.f489h;
        if (bArr == null) {
            this.f489h = new byte[m573d()];
            this.f490i = 0;
            this.f497q = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f489h = bArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public static boolean m565c(byte b) {
        return b == 9 || b == 10 || b == 13 || b == 32;
    }

    /* renamed from: e */
    private void m566e() {
        this.f489h = null;
        this.f490i = 0;
        this.f497q = 0;
        this.f492k = 0;
        this.f493l = 0;
        this.f491j = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m567a(int i) {
        byte[] bArr = this.f489h;
        if (bArr == null || bArr.length < this.f490i + i) {
            m564a();
        }
    }

    /* renamed from: a */
    abstract void mo560a(byte[] bArr, int i, int i2);

    /* renamed from: b */
    abstract void mo562b(byte[] bArr, int i, int i2);

    /* renamed from: b */
    boolean m568b() {
        return this.f489h != null;
    }

    /* renamed from: b */
    protected abstract boolean mo563b(byte b);

    /* renamed from: b */
    public boolean m569b(byte[] bArr, boolean z) {
        byte b;
        for (int i = 0; i < bArr.length; i++) {
            if (!mo563b(bArr[i]) && (!z || ((b = bArr[i]) != 61 && !m565c(b)))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    int m570c() {
        if (this.f489h != null) {
            return this.f490i - this.f497q;
        }
        return 0;
    }

    /* renamed from: c */
    int m571c(byte[] bArr, int i, int i2) {
        if (this.f489h == null) {
            return this.f491j ? -1 : 0;
        }
        int min = Math.min(m570c(), i2);
        System.arraycopy(this.f489h, this.f497q, bArr, i, min);
        int i3 = this.f497q + min;
        this.f497q = i3;
        if (i3 >= this.f490i) {
            this.f489h = null;
        }
        return min;
    }

    /* renamed from: c */
    public byte[] m572c(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    /* renamed from: d */
    protected int m573d() {
        return 8192;
    }

    /* renamed from: d */
    public boolean m574d(String str) {
        return m569b(StringUtils.getBytesUtf8(str), true);
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return m572c((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        m566e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo562b(bArr, 0, bArr.length);
        mo562b(bArr, 0, -1);
        int i = this.f490i;
        byte[] bArr2 = new byte[i];
        m571c(bArr2, 0, i);
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
        m566e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo560a(bArr, 0, bArr.length);
        mo560a(bArr, 0, -1);
        int i = this.f490i - this.f497q;
        byte[] bArr2 = new byte[i];
        m571c(bArr2, 0, i);
        return bArr2;
    }

    /* renamed from: j */
    public String m575j(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    /* renamed from: k */
    public String m576k(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public boolean m577l(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (61 == b || mo563b(b)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    public long m578m(byte[] bArr) {
        int length = bArr.length;
        int i = this.f494n;
        long j = (((length + i) - 1) / i) * this.f495o;
        int i2 = this.f488g;
        return i2 > 0 ? j + ((((i2 + j) - 1) / i2) * this.f496p) : j;
    }
}
