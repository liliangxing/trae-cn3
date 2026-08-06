package ms.bd.p001c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.io.encoding.Base64;

/* renamed from: ms.bd.c.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0107b {

    /* renamed from: a */
    public final Context f131a;

    /* renamed from: b */
    public final LinkedBlockingQueue f132b = new LinkedBlockingQueue(1);

    /* renamed from: c */
    public final ServiceConnectionC0101a f133c = new ServiceConnectionC0101a(this);

    public C0107b(Context context) {
        this.f131a = context;
    }

    /* renamed from: a */
    public final void m71a(C0235y2 c0235y2) {
        if (C0240z2.m216a(this.f131a, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "50f1b7", new byte[]{39, Base64.padSymbol, 24, 11, 92, 51, 35, 2, 121, 108, 55, 51, 91, 118, 72, 48, 38, 29, 50, 108, 33, 60, 1, 68, 79, 57, 18, 56, 19}))) {
            Intent intent = new Intent();
            intent.setAction((String) AbstractC0190p2.m166a(16777217, 0, 0L, "d94fdc", new byte[]{118, 52, 74, 92, 90, 103, 114, 11, 43, 59, 102, 58, 9, 19, 88, 96, 110, 23, 107, 120, 84, 24, 100, 55, 104, 71, 88, 60, 76, 18}));
            intent.setComponent(new ComponentName((String) AbstractC0190p2.m166a(16777217, 0, 0L, "18d7cd", new byte[]{35, 53, 26, 13, 93, 96, 39, 10, 123, 106, 51, 59, 89, 112, 73, 99, 34, 21, 48, 106, 37, 52, 3, 66, 78, 106, 22, 48, 17}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "d147fd", new byte[]{118, 60, 74, 13, 88, 96, 114, 3, 43, 106, 102, 50, 9, 112, 76, 99, 119, 28, 96, 106, 112, Base64.padSymbol, 83, 66, 75, 106, 67, 57, 65, 41, 70, 38, 87, 83, 85, 118, 106, 21, 107, 115, 116, 33, 94, 103, 112, 87, 84, 21, 119, 113, 124, 48, 66})));
            if (this.f131a.bindService(intent, this.f133c, 1)) {
                try {
                    c0235y2.f473a.f479a = new C0113c((IBinder) this.f132b.take()).m75a();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.f131a.unbindService(this.f133c);
                    throw th;
                }
                this.f131a.unbindService(this.f133c);
            }
        }
    }
}
