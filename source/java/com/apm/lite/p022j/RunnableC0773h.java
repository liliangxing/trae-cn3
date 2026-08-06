package com.apm.lite.p022j;

import android.content.Context;
import com.apm.lite.C0744d;
import com.apm.lite.C0749e;
import com.apm.lite.nativecrash.NativeImpl;
import com.apm.lite.p012b.C0735d;
import com.apm.lite.p016d.C0746b;
import com.apm.lite.p021i.C0765d;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0793p;
import com.apm.lite.p023k.C0794q;
import com.apm.lite.runtime.C0832m;
import com.apm.lite.runtime.C0835p;

/* renamed from: com.apm.lite.j.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class RunnableC0773h implements Runnable {

    /* renamed from: a */
    private Context f553a;

    private RunnableC0773h(Context context) {
        this.f553a = context;
    }

    /* renamed from: a */
    public static void m713a(Context context) {
        m714a(context, 0);
    }

    /* renamed from: a */
    public static void m714a(Context context, int i) {
        C0832m.m1190b().m1239a(new RunnableC0773h(context), i);
    }

    /* renamed from: a */
    public static boolean m715a() {
        return C0767b.m656a().m679c() || !C0778a.m746b(C0749e.m565g());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            C0735d.m430d();
        } catch (Throwable unused) {
        }
        try {
            if (C0778a.m746b(this.f553a)) {
                C0767b.m656a().m677a(C0793p.m885b(this.f553a));
            } else {
                NativeImpl.setUploadEnd();
            }
            C0835p.m1198a().m1209a(C0749e.m553a().m1122b(), C0746b.m509b());
            if (C0832m.m1190b().m1236a() == null || C0744d.m450a() == null) {
            }
        } catch (Throwable th) {
            try {
                C0794q.m893b(th);
            } finally {
                C0835p.m1198a().m1209a(C0749e.m553a().m1122b(), C0746b.m509b());
                if (C0832m.m1190b().m1236a() != null && C0744d.m450a() != null) {
                    C0765d.m646a(C0832m.m1190b().m1236a(), this.f553a).m647a();
                }
            }
        }
    }
}
