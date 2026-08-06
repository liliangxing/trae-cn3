package com.xiaomi.push;

import com.ss.android.http.legacy.protocol.HTTP;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.push.hv */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1677hv extends AbstractC1681hz {

    /* renamed from: a */
    private static final C1687ie f2754a = new C1687ie();

    /* renamed from: a */
    protected int f2755a;

    /* renamed from: a */
    protected boolean f2756a;

    /* renamed from: a */
    private byte[] f2757a;

    /* renamed from: b */
    protected boolean f2758b;

    /* renamed from: b */
    private byte[] f2759b;

    /* renamed from: c */
    protected boolean f2760c;

    /* renamed from: c */
    private byte[] f2761c;

    /* renamed from: d */
    private byte[] f2762d;

    /* renamed from: e */
    private byte[] f2763e;

    /* renamed from: f */
    private byte[] f2764f;

    /* renamed from: g */
    private byte[] f2765g;

    /* renamed from: h */
    private byte[] f2766h;

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public void mo3349a() {
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public void mo3356a(C1687ie c1687ie) {
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: b */
    public void mo3362b() {
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: d */
    public void mo3366d() {
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: e */
    public void mo3367e() {
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: f */
    public void mo3368f() {
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: g */
    public void mo3369g() {
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: h */
    public void mo3370h() {
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: i */
    public void mo3371i() {
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: j */
    public void mo3372j() {
    }

    /* renamed from: com.xiaomi.push.hv$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a implements InterfaceC1684ib {

        /* renamed from: a */
        protected int f2767a;

        /* renamed from: a */
        protected boolean f2768a;

        /* renamed from: b */
        protected boolean f2769b;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f2768a = z;
            this.f2769b = z2;
            this.f2767a = i;
        }

        @Override // com.xiaomi.push.InterfaceC1684ib
        /* renamed from: a */
        public AbstractC1681hz mo3373a(AbstractC1692ij abstractC1692ij) {
            C1677hv c1677hv = new C1677hv(abstractC1692ij, this.f2768a, this.f2769b);
            int i = this.f2767a;
            if (i != 0) {
                c1677hv.m3363b(i);
            }
            return c1677hv;
        }
    }

    public C1677hv(AbstractC1692ij abstractC1692ij, boolean z, boolean z2) {
        super(abstractC1692ij);
        this.f2760c = false;
        this.f2757a = new byte[1];
        this.f2759b = new byte[2];
        this.f2761c = new byte[4];
        this.f2762d = new byte[8];
        this.f2763e = new byte[1];
        this.f2764f = new byte[2];
        this.f2765g = new byte[4];
        this.f2766h = new byte[8];
        this.f2756a = z;
        this.f2758b = z2;
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public void mo3353a(C1678hw c1678hw) {
        mo3350a(c1678hw.f2770a);
        mo3359a(c1678hw.f2772a);
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: c */
    public void mo3364c() {
        mo3350a((byte) 0);
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public void mo3355a(C1680hy c1680hy) {
        mo3350a(c1680hy.f2775a);
        mo3350a(c1680hy.f2777b);
        mo3351a(c1680hy.f2776a);
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public void mo3354a(C1679hx c1679hx) {
        mo3350a(c1679hx.f2773a);
        mo3351a(c1679hx.f2774a);
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public void mo3360a(boolean z) {
        mo3350a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public void mo3350a(byte b) {
        this.f2757a[0] = b;
        this.f2778a.mo3409a(this.f2757a, 0, 1);
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public void mo3359a(short s) {
        byte[] bArr = this.f2759b;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.f2778a.mo3409a(this.f2759b, 0, 2);
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public void mo3351a(int i) {
        byte[] bArr = this.f2761c;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.f2778a.mo3409a(this.f2761c, 0, 4);
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public void mo3352a(long j) {
        byte[] bArr = this.f2762d;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        this.f2778a.mo3409a(this.f2762d, 0, 8);
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public void mo3357a(String str) {
        try {
            byte[] bytes = str.getBytes(HTTP.UTF_8);
            mo3351a(bytes.length);
            this.f2778a.mo3409a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new C1675ht("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public void mo3358a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo3351a(limit);
        this.f2778a.mo3409a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public C1687ie mo3344a() {
        return f2754a;
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public C1678hw mo3340a() {
        byte mo3336a = mo3336a();
        return new C1678hw("", mo3336a, mo3336a == 0 ? (short) 0 : mo3348a());
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public C1680hy mo3342a() {
        return new C1680hy(mo3336a(), mo3336a(), mo3338a());
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public C1679hx mo3341a() {
        return new C1679hx(mo3336a(), mo3338a());
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public C1686id mo3343a() {
        return new C1686id(mo3336a(), mo3338a());
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public boolean mo3361a() {
        return mo3336a() == 1;
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public byte mo3336a() {
        if (this.f2778a.mo3415b() >= 1) {
            byte b = this.f2778a.mo3413a()[this.f2778a.mo3414a_()];
            this.f2778a.mo3411a(1);
            return b;
        }
        m3335a(this.f2763e, 0, 1);
        return this.f2763e[0];
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public short mo3348a() {
        int i;
        byte[] bArr = this.f2764f;
        if (this.f2778a.mo3415b() >= 2) {
            bArr = this.f2778a.mo3413a();
            i = this.f2778a.mo3414a_();
            this.f2778a.mo3411a(2);
        } else {
            m3335a(this.f2764f, 0, 2);
            i = 0;
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public int mo3338a() {
        int i;
        byte[] bArr = this.f2765g;
        if (this.f2778a.mo3415b() >= 4) {
            bArr = this.f2778a.mo3413a();
            i = this.f2778a.mo3414a_();
            this.f2778a.mo3411a(4);
        } else {
            m3335a(this.f2765g, 0, 4);
            i = 0;
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public long mo3339a() {
        int i;
        byte[] bArr = this.f2766h;
        if (this.f2778a.mo3415b() >= 8) {
            bArr = this.f2778a.mo3413a();
            i = this.f2778a.mo3414a_();
            this.f2778a.mo3411a(8);
        } else {
            m3335a(this.f2766h, 0, 8);
            i = 0;
        }
        return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public double mo3337a() {
        return Double.longBitsToDouble(mo3339a());
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public String mo3345a() {
        int mo3338a = mo3338a();
        if (this.f2778a.mo3415b() >= mo3338a) {
            try {
                String str = new String(this.f2778a.mo3413a(), this.f2778a.mo3414a_(), mo3338a, HTTP.UTF_8);
                this.f2778a.mo3411a(mo3338a);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new C1675ht("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return m3346a(mo3338a);
    }

    /* renamed from: a */
    public String m3346a(int i) {
        try {
            m3365c(i);
            byte[] bArr = new byte[i];
            this.f2778a.m3417b(bArr, 0, i);
            return new String(bArr, HTTP.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            throw new C1675ht("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public ByteBuffer mo3347a() {
        int mo3338a = mo3338a();
        m3365c(mo3338a);
        if (this.f2778a.mo3415b() >= mo3338a) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f2778a.mo3413a(), this.f2778a.mo3414a_(), mo3338a);
            this.f2778a.mo3411a(mo3338a);
            return wrap;
        }
        byte[] bArr = new byte[mo3338a];
        this.f2778a.m3417b(bArr, 0, mo3338a);
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    private int m3335a(byte[] bArr, int i, int i2) {
        m3365c(i2);
        return this.f2778a.m3417b(bArr, i, i2);
    }

    /* renamed from: b */
    public void m3363b(int i) {
        this.f2755a = i;
        this.f2760c = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void m3365c(int i) {
        if (i < 0) {
            throw new C1675ht("Negative length: " + i);
        }
        if (this.f2760c) {
            int i2 = this.f2755a - i;
            this.f2755a = i2;
            if (i2 < 0) {
                throw new C1675ht("Message length exceeded: " + i);
            }
        }
    }
}
