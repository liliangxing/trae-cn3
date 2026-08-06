package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.Cdo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class eq {

    /* renamed from: a, reason: collision with other field name */
    int f451a;

    /* renamed from: a, reason: collision with other field name */
    private Cdo.a f452a;

    /* renamed from: a, reason: collision with other field name */
    String f453a;

    /* renamed from: a, reason: collision with other field name */
    private short f454a;

    /* renamed from: b, reason: collision with other field name */
    private final long f455b;

    /* renamed from: b, reason: collision with other field name */
    private byte[] f456b;
    private static String b = fw.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    private static long a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static final byte[] f450a = new byte[0];

    public eq() {
        this.f454a = (short) 2;
        this.f456b = f450a;
        this.f453a = null;
        this.f455b = System.currentTimeMillis();
        this.f452a = new Cdo.a();
        this.f451a = 1;
    }

    eq(Cdo.a aVar, short s, byte[] bArr) {
        this.f454a = (short) 2;
        this.f456b = f450a;
        this.f453a = null;
        this.f455b = System.currentTimeMillis();
        this.f452a = aVar;
        this.f454a = s;
        this.f456b = bArr;
        this.f451a = 2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m9867a() {
        return this.f455b;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f452a.c(str);
        this.f452a.m9760a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f452a.d(str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m9868a() {
        return this.f452a.m9767c();
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m9875b() {
        return this.f452a.m9769d();
    }

    public void a(int i) {
        this.f452a.a(i);
    }

    public int a() {
        return this.f452a.c();
    }

    public void a(String str) {
        this.f452a.e(str);
    }

    public void a(long j) {
        this.f452a.a(j);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m9871a() {
        return this.f452a.j();
    }

    public int b() {
        return this.f452a.f();
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m9878c() {
        return this.f452a.m9773f();
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m9876b() {
        return this.f452a.l();
    }

    public void b(long j) {
        this.f452a.b(j);
    }

    public void c(long j) {
        this.f452a.c(j);
    }

    /* renamed from: b, reason: collision with other method in class */
    public long m9874b() {
        return this.f452a.m9763b();
    }

    /* renamed from: c, reason: collision with other method in class */
    public long m9877c() {
        return this.f452a.m9759a();
    }

    public static synchronized String d() {
        String sb;
        synchronized (eq.class) {
            StringBuilder append = new StringBuilder().append(b);
            long j = a;
            a = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public String e() {
        String m9771e = this.f452a.m9771e();
        if ("ID_NOT_AVAILABLE".equals(m9771e)) {
            return null;
        }
        if (this.f452a.g()) {
            return m9771e;
        }
        String d = d();
        this.f452a.e(d);
        return d;
    }

    public void b(String str) {
        this.f453a = str;
    }

    public String f() {
        return this.f453a;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("@");
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf("/", indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            this.f452a.a(parseLong);
            this.f452a.a(substring);
            this.f452a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m9528a("Blob parse user err " + e.getMessage());
        }
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f452a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f452a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f452a.b(str2);
    }

    public String g() {
        if (this.f452a.m9765b()) {
            return Long.toString(this.f452a.m9759a()) + "@" + this.f452a.m9761a() + "/" + this.f452a.m9764b();
        }
        return null;
    }

    public void a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f452a.c(1);
            this.f456b = com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(str, e()), bArr);
        } else {
            this.f452a.c(0);
            this.f456b = bArr;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m9872a() {
        return er.a(this, this.f456b);
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m9873a(String str) {
        if (this.f452a.e() == 1) {
            return er.a(this, com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(str, e()), this.f456b));
        }
        if (this.f452a.e() == 0) {
            return er.a(this, this.f456b);
        }
        com.xiaomi.channel.commonutils.logger.b.m9528a("unknow cipher = " + this.f452a.e());
        return er.a(this, this.f456b);
    }

    @Deprecated
    public static eq a(fn fnVar, String str) {
        int i;
        eq eqVar = new eq();
        try {
            i = Integer.parseInt(fnVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m9528a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        eqVar.a(i);
        eqVar.a(fnVar.j());
        eqVar.c(fnVar.m());
        eqVar.b(fnVar.n());
        eqVar.a("XMLMSG", (String) null);
        try {
            eqVar.a(fnVar.mo9909a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                eqVar.a((short) 3);
            } else {
                eqVar.a((short) 2);
                eqVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m9528a("Blob setPayload err： " + e2.getMessage());
        }
        return eqVar;
    }

    public int c() {
        return this.f452a.b() + 8 + this.f456b.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo9869a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f454a);
        byteBuffer.putShort((short) this.f452a.a());
        byteBuffer.putInt(this.f456b.length);
        int position = byteBuffer.position();
        this.f452a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f452a.a());
        byteBuffer.position(position + this.f452a.a());
        byteBuffer.put(this.f456b);
        return byteBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static eq a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            Cdo.a aVar = new Cdo.a();
            aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new eq(aVar, s, bArr);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m9528a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public short m9870a() {
        return this.f454a;
    }

    public void a(short s) {
        this.f454a = s;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.aj.a(e()) + "; cmd=" + m9868a() + "; type=" + ((int) m9870a()) + "; from=" + g() + " ]";
    }
}
