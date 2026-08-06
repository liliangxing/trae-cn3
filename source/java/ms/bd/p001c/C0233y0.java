package ms.bd.p001c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* renamed from: ms.bd.c.y0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0233y0 {

    /* renamed from: a */
    public final Context f470a;

    /* renamed from: b */
    public final LinkedBlockingQueue f471b = new LinkedBlockingQueue(1024);

    /* renamed from: c */
    public final ServiceConnectionC0228x0 f472c = new ServiceConnectionC0228x0(this);

    public C0233y0(Context context) {
        this.f470a = context;
    }

    /* renamed from: a */
    public final void m211a(C0235y2 c0235y2) {
        if (C0240z2.m216a(this.f470a, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "abb5f2", new byte[]{115, 111, 28, 15, 81, 48, 99, 84, 54, 108, 62, 104, 6, 72, 93}))) {
            Intent intent = new Intent((String) AbstractC0190p2.m166a(16777217, 0, 0L, "34ed76", new byte[]{33, 57, 27, 94, 29, 46, 52, 28, 39, 122, 45, 38, 19, 30, 12, 36, 38, 28, 55, 49, 108, 25, 38, 53, 38, 8, 20, 38, 11, 7, 7, 4, 32, 57, 43, 4}));
            intent.setPackage((String) AbstractC0190p2.m166a(16777217, 0, 0L, "b54fa8", new byte[]{112, 56, 74, 92, 86, 58, 96, 3, 96, Utf8.REPLACEMENT_BYTE, Base64.padSymbol, Utf8.REPLACEMENT_BYTE, 80, 27, 90}));
            if (this.f470a.bindService(intent, this.f472c, 1)) {
                try {
                    c0235y2.f473a.f479a = new C0238z0((IBinder) this.f471b.take()).m213a();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.f470a.unbindService(this.f472c);
                    throw th;
                }
                this.f470a.unbindService(this.f472c);
            }
        }
    }
}
