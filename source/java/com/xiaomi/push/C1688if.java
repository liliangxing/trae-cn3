package com.xiaomi.push;

import com.ss.android.http.legacy.protocol.HTTP;
import com.xiaomi.push.C1677hv;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.push.if */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1688if extends C1677hv {

    /* renamed from: b */
    private static int f2793b = 10000;

    /* renamed from: c */
    private static int f2794c = 10000;

    /* renamed from: d */
    private static int f2795d = 10000;

    /* renamed from: e */
    private static int f2796e = 10485760;

    /* renamed from: f */
    private static int f2797f = 104857600;

    public C1688if(AbstractC1692ij abstractC1692ij, boolean z, boolean z2) {
        super(abstractC1692ij, z, z2);
    }

    /* renamed from: com.xiaomi.push.if$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a extends C1677hv.a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        @Override // com.xiaomi.push.C1677hv.a, com.xiaomi.push.InterfaceC1684ib
        /* renamed from: a */
        public AbstractC1681hz mo3373a(AbstractC1692ij abstractC1692ij) {
            C1688if c1688if = new C1688if(abstractC1692ij, this.f2768a, this.f2769b);
            if (this.f2767a != 0) {
                c1688if.m3363b(this.f2767a);
            }
            return c1688if;
        }
    }

    @Override // com.xiaomi.push.C1677hv, com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public C1680hy mo3342a() {
        byte a2 = mo3341a();
        byte a3 = mo3341a();
        int a4 = mo3341a();
        if (a4 > f2793b) {
            throw new C1683ia(3, "Thrift map size " + a4 + " out of range!");
        }
        return new C1680hy(a2, a3, a4);
    }

    @Override // com.xiaomi.push.C1677hv, com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public C1679hx mo3341a() {
        byte a2 = mo3341a();
        int a3 = mo3341a();
        if (a3 > f2794c) {
            throw new C1683ia(3, "Thrift list size " + a3 + " out of range!");
        }
        return new C1679hx(a2, a3);
    }

    @Override // com.xiaomi.push.C1677hv, com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public C1686id mo3343a() {
        byte a2 = mo3341a();
        int a3 = mo3341a();
        if (a3 > f2795d) {
            throw new C1683ia(3, "Thrift set size " + a3 + " out of range!");
        }
        return new C1686id(a2, a3);
    }

    @Override // com.xiaomi.push.C1677hv, com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public String mo3345a() {
        int a2 = mo3341a();
        if (a2 > f2796e) {
            throw new C1683ia(3, "Thrift string size " + a2 + " out of range!");
        }
        if (this.f2778a.mo3415b() >= a2) {
            try {
                String str = new String(this.f2778a.mo3413a(), this.f2778a.mo3414a_(), a2, HTTP.UTF_8);
                this.f2778a.mo3411a(a2);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new C1675ht("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return m3346a(a2);
    }

    @Override // com.xiaomi.push.C1677hv, com.xiaomi.push.AbstractC1681hz
    /* renamed from: a */
    public ByteBuffer mo3347a() {
        int a2 = mo3341a();
        if (a2 > f2797f) {
            throw new C1683ia(3, "Thrift binary size " + a2 + " out of range!");
        }
        m3365c(a2);
        if (this.f2778a.mo3415b() >= a2) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f2778a.mo3413a(), this.f2778a.mo3414a_(), a2);
            this.f2778a.mo3411a(a2);
            return wrap;
        }
        byte[] bArr = new byte[a2];
        this.f2778a.m3417b(bArr, 0, a2);
        return ByteBuffer.wrap(bArr);
    }
}
