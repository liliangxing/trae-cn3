package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1562do;
import com.xiaomi.push.service.C1752aj;
import com.xiaomi.push.service.C1760ar;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.push.eq */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1591eq {

    /* renamed from: a */
    int f1649a;

    /* renamed from: a */
    private C1562do.a f1650a;

    /* renamed from: a */
    String f1651a;

    /* renamed from: a */
    private short f1652a;

    /* renamed from: b */
    private final long f1653b;

    /* renamed from: b */
    private byte[] f1654b;

    /* renamed from: b */
    private static String f1648b = C1624fw.m2646a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a */
    private static long f1646a = 0;

    /* renamed from: a */
    private static final byte[] f1647a = new byte[0];

    public C1591eq() {
        this.f1652a = (short) 2;
        this.f1654b = f1647a;
        this.f1651a = null;
        this.f1653b = System.currentTimeMillis();
        this.f1650a = new C1562do.a();
        this.f1649a = 1;
    }

    C1591eq(C1562do.a aVar, short s, byte[] bArr) {
        this.f1652a = (short) 2;
        this.f1654b = f1647a;
        this.f1651a = null;
        this.f1653b = System.currentTimeMillis();
        this.f1650a = aVar;
        this.f1652a = s;
        this.f1654b = bArr;
        this.f1649a = 2;
    }

    /* renamed from: a */
    public long m2430a() {
        return this.f1653b;
    }

    /* renamed from: a */
    public void m2438a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f1650a.m2096c(str);
        this.f1650a.m2080a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f1650a.m2101d(str2);
    }

    /* renamed from: a */
    public String m2431a() {
        return this.f1650a.m2097c();
    }

    /* renamed from: b */
    public String m2446b() {
        return this.f1650a.m2102d();
    }

    /* renamed from: a */
    public void m2434a(int i) {
        this.f1650a.m2081a(i);
    }

    /* renamed from: a */
    public int m2429a() {
        return this.f1650a.m2092c();
    }

    /* renamed from: a */
    public void m2437a(String str) {
        this.f1650a.m2105e(str);
    }

    /* renamed from: a */
    public void m2435a(long j) {
        this.f1650a.m2082a(j);
    }

    /* renamed from: a */
    public boolean m2441a() {
        return this.f1650a.m2115j();
    }

    /* renamed from: b */
    public int m2444b() {
        return this.f1650a.m2108f();
    }

    /* renamed from: c */
    public String m2452c() {
        return this.f1650a.m2110f();
    }

    /* renamed from: b */
    public boolean m2449b() {
        return this.f1650a.m2117l();
    }

    /* renamed from: b */
    public void m2447b(long j) {
        this.f1650a.m2088b(j);
    }

    /* renamed from: c */
    public void m2453c(long j) {
        this.f1650a.m2095c(j);
    }

    /* renamed from: b */
    public long m2445b() {
        return this.f1650a.m2086b();
    }

    /* renamed from: c */
    public long m2451c() {
        return this.f1650a.m2079a();
    }

    /* renamed from: d */
    public static synchronized String m2428d() {
        String sb;
        synchronized (C1591eq.class) {
            StringBuilder append = new StringBuilder().append(f1648b);
            long j = f1646a;
            f1646a = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    /* renamed from: e */
    public String m2455e() {
        String m2106e = this.f1650a.m2106e();
        if ("ID_NOT_AVAILABLE".equals(m2106e)) {
            return null;
        }
        if (this.f1650a.m2112g()) {
            return m2106e;
        }
        String m2428d = m2428d();
        this.f1650a.m2105e(m2428d);
        return m2428d;
    }

    /* renamed from: b */
    public void m2448b(String str) {
        this.f1651a = str;
    }

    /* renamed from: f */
    public String m2456f() {
        return this.f1651a;
    }

    /* renamed from: c */
    public void m2454c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("@");
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf("/", indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            this.f1650a.m2082a(parseLong);
            this.f1650a.m2083a(substring);
            this.f1650a.m2089b(substring2);
        } catch (Exception e) {
            AbstractC1417b.m1089a("Blob parse user err " + e.getMessage());
        }
    }

    /* renamed from: a */
    public void m2436a(long j, String str, String str2) {
        if (j != 0) {
            this.f1650a.m2082a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f1650a.m2083a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f1650a.m2089b(str2);
    }

    /* renamed from: g */
    public String m2457g() {
        if (this.f1650a.m2091b()) {
            return Long.toString(this.f1650a.m2079a()) + "@" + this.f1650a.m2084a() + "/" + this.f1650a.m2090b();
        }
        return null;
    }

    /* renamed from: a */
    public void m2440a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f1650a.m2094c(1);
            this.f1654b = C1760ar.m3747a(C1760ar.m3745a(str, m2455e()), bArr);
        } else {
            this.f1650a.m2094c(0);
            this.f1654b = bArr;
        }
    }

    /* renamed from: a */
    public byte[] m2442a() {
        return C1592er.m2458a(this, this.f1654b);
    }

    /* renamed from: a */
    public byte[] m2443a(String str) {
        if (this.f1650a.m2104e() == 1) {
            return C1592er.m2458a(this, C1760ar.m3747a(C1760ar.m3745a(str, m2455e()), this.f1654b));
        }
        if (this.f1650a.m2104e() == 0) {
            return C1592er.m2458a(this, this.f1654b);
        }
        AbstractC1417b.m1089a("unknow cipher = " + this.f1650a.m2104e());
        return C1592er.m2458a(this, this.f1654b);
    }

    @Deprecated
    /* renamed from: a */
    public static C1591eq m2426a(AbstractC1615fn abstractC1615fn, String str) {
        int i;
        C1591eq c1591eq = new C1591eq();
        try {
            i = Integer.parseInt(abstractC1615fn.m2611k());
        } catch (Exception e) {
            AbstractC1417b.m1089a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        c1591eq.m2434a(i);
        c1591eq.m2437a(abstractC1615fn.m2610j());
        c1591eq.m2454c(abstractC1615fn.m2615m());
        c1591eq.m2448b(abstractC1615fn.m2617n());
        c1591eq.m2438a("XMLMSG", (String) null);
        try {
            c1591eq.m2440a(abstractC1615fn.mo2575a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                c1591eq.m2439a((short) 3);
            } else {
                c1591eq.m2439a((short) 2);
                c1591eq.m2438a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            AbstractC1417b.m1089a("Blob setPayload err： " + e2.getMessage());
        }
        return c1591eq;
    }

    /* renamed from: c */
    public int mo2450c() {
        return this.f1650a.mo2068b() + 8 + this.f1654b.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public ByteBuffer mo2432a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(mo2450c());
        }
        byteBuffer.putShort(this.f1652a);
        byteBuffer.putShort((short) this.f1650a.mo2060a());
        byteBuffer.putInt(this.f1654b.length);
        int position = byteBuffer.position();
        this.f1650a.m2335a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f1650a.mo2060a());
        byteBuffer.position(position + this.f1650a.mo2060a());
        byteBuffer.put(this.f1654b);
        return byteBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C1591eq m2427a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            C1562do.a aVar = new C1562do.a();
            aVar.m2335a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new C1591eq(aVar, s, bArr);
        } catch (Exception e) {
            AbstractC1417b.m1089a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    /* renamed from: a */
    public short m2433a() {
        return this.f1652a;
    }

    /* renamed from: a */
    public void m2439a(short s) {
        this.f1652a = s;
    }

    public String toString() {
        return "Blob [chid=" + m2429a() + "; Id=" + C1752aj.m3693a(m2455e()) + "; cmd=" + m2431a() + "; type=" + ((int) m2433a()) + "; from=" + m2457g() + " ]";
    }
}
