package ms.bd.p001c;

import java.util.Locale;
import kotlin.io.encoding.Base64;

/* renamed from: ms.bd.c.u1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0214u1 implements Cloneable {

    /* renamed from: a */
    public long f403a;

    /* renamed from: b */
    public long f404b;

    /* renamed from: c */
    public long f405c;

    /* renamed from: d */
    public long f406d;

    /* renamed from: e */
    public final C0209t1 f407e = new C0209t1();

    /* renamed from: f */
    public long f408f;

    static {
    }

    public final String toString() {
        this.f407e.getClass();
        Locale locale = Locale.US;
        String str = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "607e6f", new byte[]{98, 54, 8, 84, 13, Base64.padSymbol, 112, 21, 42, 112, 35, 126, 1, 2});
        Long valueOf = Long.valueOf(this.f403a);
        Long valueOf2 = Long.valueOf(this.f404b);
        Long valueOf3 = Long.valueOf(this.f405c);
        long j = this.f406d;
        return String.format(locale, str, valueOf, valueOf2, valueOf3, Long.valueOf(j != 0 ? this.f408f - j : 0L), this.f407e);
    }

    public final C0214u1 clone() {
        try {
            return (C0214u1) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
