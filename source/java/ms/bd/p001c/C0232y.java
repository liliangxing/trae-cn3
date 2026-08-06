package ms.bd.p001c;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;

/* renamed from: ms.bd.c.y */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0232y {

    /* renamed from: a */
    public final Context f466a;

    /* renamed from: b */
    public final String f467b = (String) AbstractC0190p2.m166a(16777217, 0, 0, "80ea82", new byte[]{42, Base64.padSymbol, 27, 91, 10, 33, 50, 21, 122, 60, 58, 51});

    /* renamed from: c */
    public final LinkedBlockingQueue f468c = new LinkedBlockingQueue(1);

    /* renamed from: d */
    public final ServiceConnectionC0227x f469d = new ServiceConnectionC0227x(this);

    public C0232y(Context context) {
        this.f466a = context;
    }

    /* renamed from: a */
    public final void m210a(C0235y2 c0235y2) {
        if (Build.VERSION.SDK_INT <= 28 ? false : C0240z2.m216a(this.f466a, this.f467b)) {
            String packageName = this.f466a.getPackageName();
            Intent intent = new Intent();
            intent.setClassName(this.f467b, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "a4d262", new byte[]{115, 57, 26, 8, 4, 33, 107, 17, 123, 111, 99, 55, 89, 85, 12, 55, 116, 28, 54, 103, 62, 27, 4, 71, 34, 41, 81, Tnaf.POW_2_WIDTH, 39, 116, 121, 53, 18}));
            intent.setAction((String) AbstractC0190p2.m166a(16777217, 0, 0L, "408291", new byte[]{38, Base64.padSymbol, 70, 8, 4, 51, 57, 95, 100, 113, 36, 124, 74, 69, 18, 47, 56, 31, 39, 113, 49, 51, 89, 82, 72, 53, 50, 3, Byte.MAX_VALUE, 107, 38, 55}));
            intent.putExtra((String) AbstractC0190p2.m166a(16777217, 0, 0L, "657e2e", new byte[]{36, 56, 73, 95, 15, 103, 59, 90, 107, 38, 38, 121, 84, Tnaf.POW_2_WIDTH, 31, 115, 56, 90, 118, 62, 32, 57, 69, 28, 8}), packageName);
            try {
                intent.putExtra((String) AbstractC0190p2.m166a(16777217, 0, 0L, "4e702d", new byte[]{38, 104, 73, 10, 15, 102, 57, 10, 107, 115, 36, 41, 84, 69, 31, 114, 58, 10, 116, 117, 43, 110, 74, 87, 8, 103}), true);
                this.f466a.startService(intent);
            } catch (Exception unused) {
            }
            Intent intent2 = new Intent();
            intent2.setClassName((String) AbstractC0190p2.m166a(16777217, 0, 0L, "16e73e", new byte[]{35, 59, 27, 13, 1, 118, 59, 19, 122, 106, 51, 53}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "7a0bb9", new byte[]{37, 108, 78, 88, 80, 42, Base64.padSymbol, 68, 47, Utf8.REPLACEMENT_BYTE, 53, 98, 13, 5, 88, 60, 34, 73, 98, 55, 104, 78, 80, 23, 116, 42, 7, 69, 115, 36, 47, 96, 70}));
            intent2.setAction((String) AbstractC0190p2.m166a(16777217, 0, 0L, "a8a0f8", new byte[]{115, 53, 31, 10, 91, 58, 108, 87, Base64.padSymbol, 115, 113, 116, 19, 71, 77, 38, 109, 23, 126, 98, 121, 52, 22, 80, 86, 97, 113, 28, 34, 118, 121, 57, 23}));
            intent2.putExtra((String) AbstractC0190p2.m166a(16777217, 0, 0L, "a3bfe1", new byte[]{115, 62, 28, 92, 88, 51, 108, 92, 62, 37, 113, Byte.MAX_VALUE, 1, 19, 72, 39, 111, 92, 35, Base64.padSymbol, 119, Utf8.REPLACEMENT_BYTE, Tnaf.POW_2_WIDTH, 31, 95}), packageName);
            if (this.f466a.bindService(intent2, this.f469d, 1)) {
                try {
                    c0235y2.f473a.f479a = new C0237z((IBinder) this.f468c.take()).m212a();
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    this.f466a.unbindService(this.f469d);
                    throw th;
                }
                this.f466a.unbindService(this.f469d);
            }
        }
    }
}
