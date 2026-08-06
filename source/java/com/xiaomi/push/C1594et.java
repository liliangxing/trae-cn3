package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1562do;
import com.xiaomi.push.service.C1760ar;
import com.xiaomi.push.service.C1766ax;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

/* renamed from: com.xiaomi.push.et */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1594et {

    /* renamed from: a */
    private int f1664a;

    /* renamed from: a */
    private C1598ex f1665a;

    /* renamed from: a */
    private OutputStream f1666a;

    /* renamed from: a */
    private byte[] f1669a;

    /* renamed from: b */
    private int f1670b;

    /* renamed from: a */
    ByteBuffer f1667a = ByteBuffer.allocate(2048);

    /* renamed from: b */
    private ByteBuffer f1671b = ByteBuffer.allocate(4);

    /* renamed from: a */
    private Adler32 f1668a = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1594et(OutputStream outputStream, C1598ex c1598ex) {
        this.f1666a = new BufferedOutputStream(outputStream);
        this.f1665a = c1598ex;
        TimeZone timeZone = TimeZone.getDefault();
        this.f1664a = timeZone.getRawOffset() / 3600000;
        this.f1670b = timeZone.useDaylightTime() ? 1 : 0;
    }

    /* renamed from: a */
    public int m2465a(C1591eq c1591eq) {
        int mo2450c = c1591eq.mo2450c();
        if (mo2450c > 32768) {
            AbstractC1417b.m1089a("Blob size=" + mo2450c + " should be less than 32768 Drop blob chid=" + c1591eq.m2429a() + " id=" + c1591eq.m2455e());
            return 0;
        }
        this.f1667a.clear();
        int i = mo2450c + 8 + 4;
        if (i > this.f1667a.capacity() || this.f1667a.capacity() > 4096) {
            this.f1667a = ByteBuffer.allocate(i);
        }
        this.f1667a.putShort((short) -15618);
        this.f1667a.putShort((short) 5);
        this.f1667a.putInt(mo2450c);
        int position = this.f1667a.position();
        this.f1667a = c1591eq.mo2432a(this.f1667a);
        if (!"CONN".equals(c1591eq.m2431a())) {
            if (this.f1669a == null) {
                this.f1669a = this.f1665a.m2493a();
            }
            C1760ar.m3748a(this.f1669a, this.f1667a.array(), true, position, mo2450c);
        }
        this.f1668a.reset();
        this.f1668a.update(this.f1667a.array(), 0, this.f1667a.position());
        this.f1671b.putInt(0, (int) this.f1668a.getValue());
        this.f1666a.write(this.f1667a.array(), 0, this.f1667a.position());
        this.f1666a.write(this.f1671b.array(), 0, 4);
        this.f1666a.flush();
        int position2 = this.f1667a.position() + 4;
        AbstractC1417b.m1101c("[Slim] Wrote {cmd=" + c1591eq.m2431a() + ";chid=" + c1591eq.m2429a() + ";len=" + position2 + "}");
        return position2;
    }

    /* renamed from: a */
    public void m2466a() {
        C1562do.e eVar = new C1562do.e();
        eVar.m2165a(106);
        eVar.m2168a(Build.MODEL);
        eVar.m2174b(C1702q.m3464a());
        eVar.m2179c(C1766ax.m3769a());
        eVar.m2172b(48);
        eVar.m2184d(this.f1665a.m2513b());
        eVar.m2188e(this.f1665a.mo2484a());
        eVar.m2192f(Locale.getDefault().toString());
        eVar.m2178c(Build.VERSION.SDK_INT);
        eVar.m2183d(C1628g.m2677a(this.f1665a.mo2484a(), "com.xiaomi.xmsf"));
        byte[] mo2536a = this.f1665a.mo2484a().mo2536a();
        if (mo2536a != null) {
            eVar.m2167a(C1562do.b.m2119a(mo2536a));
        }
        C1591eq c1591eq = new C1591eq();
        c1591eq.m2434a(0);
        c1591eq.m2438a("CONN", (String) null);
        c1591eq.m2436a(0L, "xiaomi.com", null);
        c1591eq.m2440a(eVar.mo2060a(), (String) null);
        m2465a(c1591eq);
        AbstractC1417b.m1089a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=48 tz=" + this.f1664a + Constants.COLON_SEPARATOR + this.f1670b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    /* renamed from: b */
    public void m2467b() {
        C1591eq c1591eq = new C1591eq();
        c1591eq.m2438a("CLOSE", (String) null);
        m2465a(c1591eq);
        this.f1666a.close();
    }
}
