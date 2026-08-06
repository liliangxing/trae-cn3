package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* renamed from: com.xiaomi.push.eu */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1595eu {

    /* renamed from: a */
    public static final byte[] f1672a = {80, 85, 83, 72};

    /* renamed from: a */
    private byte f1673a;

    /* renamed from: a */
    private int f1674a;

    /* renamed from: a */
    private short f1675a;

    /* renamed from: b */
    private byte[] f1676b;

    /* renamed from: com.xiaomi.push.eu$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface b {
        /* renamed from: a */
        byte mo2478a();

        /* renamed from: a */
        byte[] mo2479a(byte[] bArr, int i);
    }

    /* renamed from: com.xiaomi.push.eu$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class c {
    }

    protected C1595eu(byte b2, int i, byte[] bArr) {
        this((short) 1, b2, i, bArr);
    }

    protected C1595eu(short s, byte b2, int i, byte[] bArr) {
        this.f1675a = s;
        this.f1673a = b2;
        this.f1674a = i;
        this.f1676b = bArr;
    }

    /* renamed from: a */
    public static C1595eu m2470a(byte b2, int i, byte[] bArr) {
        return new C1595eu(b2, i, bArr);
    }

    /* renamed from: a */
    public static C1595eu m2471a(short s, byte b2, int i, byte[] bArr) {
        return new C1595eu(s, b2, i, bArr);
    }

    /* renamed from: a */
    public static C1595eu m2472a(byte[] bArr) {
        if (m2473a(bArr)) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            order.getInt();
            short s = order.getShort();
            byte b2 = order.get();
            int i = order.getInt();
            byte[] bArr2 = new byte[order.getInt()];
            order.get(bArr2);
            return m2471a(s, b2, i, bArr2);
        }
        return m2470a((byte) 0, bArr.length, bArr);
    }

    /* renamed from: a */
    public static boolean m2473a(byte[] bArr) {
        byte[] bArr2 = f1672a;
        return m2474a(bArr2, bArr, bArr2.length);
    }

    /* renamed from: a */
    public static boolean m2474a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: com.xiaomi.push.eu$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class d implements b {
        @Override // com.xiaomi.push.C1595eu.b
        /* renamed from: a */
        public byte mo2478a() {
            return (byte) 2;
        }

        @Override // com.xiaomi.push.C1595eu.b
        /* renamed from: a */
        public byte[] mo2479a(byte[] bArr, int i) {
            GZIPInputStream gZIPInputStream = null;
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
                try {
                    byte[] bArr2 = new byte[i];
                    gZIPInputStream2.read(bArr2);
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return bArr2;
                } catch (IOException unused2) {
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* renamed from: com.xiaomi.push.eu$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        public static final c f1677a = new c();

        /* renamed from: a */
        public static final d f1678a = new d();

        /* renamed from: a */
        public static byte[] m2476a(byte[] bArr) {
            return m2477a(bArr, f1678a);
        }

        /* renamed from: a */
        public static byte[] m2477a(byte[] bArr, b bVar) {
            if (!C1595eu.m2473a(bArr)) {
                return bArr;
            }
            C1595eu m2472a = C1595eu.m2472a(bArr);
            return (m2472a.f1673a == 0 || m2472a.f1673a != bVar.mo2478a()) ? m2472a.f1676b : bVar.mo2479a(m2472a.f1676b, m2472a.f1674a);
        }
    }
}
