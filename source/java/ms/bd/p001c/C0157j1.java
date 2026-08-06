package ms.bd.p001c;

import android.content.Context;
import android.content.Intent;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;

/* renamed from: ms.bd.c.j1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0157j1 {

    /* renamed from: a */
    public final Context f196a;

    /* renamed from: b */
    public C0163k1 f197b;

    /* renamed from: c */
    public final ServiceConnectionC0151i1 f198c = new ServiceConnectionC0151i1(this);

    public C0157j1(Context context) {
        this.f196a = context;
    }

    /* renamed from: a */
    public final void m132a(C0235y2 c0235y2) {
        Intent intent = new Intent();
        intent.setClassName((String) AbstractC0190p2.m166a(16777217, 0, 0L, "24610a", new byte[]{32, 57, 72, 11, 21, 99, 56, 91, 99, 100, 53, Utf8.REPLACEMENT_BYTE, 70, 64, 6, 114, 34, Tnaf.POW_2_WIDTH, 117, 119, 42, 53, 64}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "da27f1", new byte[]{118, 108, 76, 13, 67, 51, 110, 14, 103, 98, 99, 106, 66, 70, 80, 34, 116, 69, 113, 113, 124, 96, 68, 13, 125, 35, 113, 73, 96, 98, 124, 103, 114, 70, 75, 48, 110, 67, 102}));
        if (this.f196a.bindService(intent, this.f198c, 1)) {
            try {
                C0163k1 c0163k1 = this.f197b;
                if (c0163k1 != null) {
                    c0235y2.f473a.f479a = c0163k1.m136a();
                }
            } catch (Throwable unused) {
            }
            this.f196a.unbindService(this.f198c);
        }
    }
}
