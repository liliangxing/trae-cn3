package ms.bd.p001c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import okio.Utf8;

/* renamed from: ms.bd.c.p3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0191p3 {

    /* renamed from: a */
    public final Context f311a;

    /* renamed from: b */
    public final LinkedBlockingQueue f312b = new LinkedBlockingQueue(1);

    /* renamed from: c */
    public final ServiceConnectionC0186o3 f313c = new ServiceConnectionC0186o3(this);

    public C0191p3(Context context) {
        this.f311a = context;
    }

    /* renamed from: a */
    public final void m168a(C0235y2 c0235y2) {
        if (C0240z2.m216a(this.f311a, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "be8b06", new byte[]{112, 104, 70, 88, 28, 32, 108, 87, 124, 60, 116, 41, 74, 24, 11, 51, 110, 77, 109, 124, 119, 98, 93, 31, 12, 36, 104, 64, 122, 55, 97, 113, 66, 21, 10}))) {
            boolean z = false;
            try {
                this.f311a.getPackageManager().getPackageInfo((String) AbstractC0190p2.m166a(16777217, 0, 0L, "531ba1", new byte[]{39, 62, 79, 88, 77, 39, 59, 1, 117, 60, 35, Byte.MAX_VALUE, 67, 24, 90, 52, 57, 27, 100, 124, 32, 52, 84, 31, 93, 35, Utf8.REPLACEMENT_BYTE, 22, 115, 55, 54, 39, 75, 21, 91}), 0);
            } catch (Exception unused) {
            }
            Intent intent = new Intent();
            intent.setClassName((String) AbstractC0190p2.m166a(16777217, 0, 0L, "6bd7f3", new byte[]{36, 111, 26, 13, 74, 37, 56, 80, 32, 105, 32, 46, 22, 77, 93, 54, 58, 74, 49, 41, 35, 101, 1, 74, 90, 33, 60, 71, 38, 98, 53, 118, 30, 64, 92}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "5ca9c7", new byte[]{39, 110, 31, 3, 79, 33, 59, 81, 37, 103, 35, 47, 19, 67, 88, 50, 57, 75, 52, 39, 32, 100, 4, 68, 95, 37, Utf8.REPLACEMENT_BYTE, 70, 35, 108, 54, 119, 27, 78, 89, 110, 18, 71, 38, 96, 39, 100, 59, 73, 111, 37, 36, 84, 57, 106, 33}));
            try {
                z = this.f311a.bindService(intent, this.f313c, 1);
                if (z) {
                    c0235y2.f473a.f479a = new C0196q3((IBinder) this.f312b.take()).m174a();
                }
                if (!z) {
                    return;
                }
            } catch (Exception unused2) {
                if (!z) {
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    this.f311a.unbindService(this.f313c);
                }
                throw th;
            }
            this.f311a.unbindService(this.f313c);
        }
    }
}
