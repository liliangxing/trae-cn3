package com.apm.lite.p021i;

import android.content.Context;
import android.os.Handler;
import com.apm.lite.C0749e;
import com.apm.lite.p016d.C0746b;
import com.apm.lite.runtime.C0832m;
import com.apm.lite.runtime.C0835p;
import java.util.Map;

/* renamed from: com.apm.lite.i.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0763b extends AbstractRunnableC0762a {

    /* renamed from: a */
    private static Runnable f493a = new Runnable() { // from class: com.apm.lite.i.b.1
        @Override // java.lang.Runnable
        public void run() {
            C0832m.m1190b().m1236a().removeCallbacks(this);
            C0832m.m1190b().m1238a(new C0763b(C0832m.m1190b().m1236a(), 0L, 30000L, C0749e.m565g()));
        }
    };

    public C0763b(Handler handler, long j, long j2, Context context) {
        super(handler, j, j2);
    }

    /* renamed from: d */
    public static void m645d() {
        C0832m.m1190b().m1239a(f493a, 100L);
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<String, Object> map;
        try {
            map = C0749e.m553a().m1122b();
        } catch (Throwable unused) {
            map = null;
        }
        try {
            C0835p.m1198a().m1209a(map, C0746b.m509b());
        } catch (Throwable unused2) {
        }
    }
}
