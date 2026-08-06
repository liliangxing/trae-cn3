package com.apm.lite.p021i;

import android.content.Context;
import android.os.Handler;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0794q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.apm.lite.i.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0765d {

    /* renamed from: a */
    private List<AbstractRunnableC0762a> f494a = new ArrayList(3);

    private C0765d(Handler handler, Context context) {
        if (C0778a.m746b(context)) {
            this.f494a.add(new C0764c(handler, 0L, 15000L));
        }
    }

    /* renamed from: a */
    public static C0765d m646a(Handler handler, Context context) {
        return new C0765d(handler, context);
    }

    /* renamed from: a */
    public void m647a() {
        C0794q.m887a((Object) ("[ScheduleTaskManager] execute, task size=" + this.f494a.size()));
        Iterator<AbstractRunnableC0762a> it = this.f494a.iterator();
        while (it.hasNext()) {
            try {
                it.next().m641a();
            } catch (Throwable unused) {
            }
        }
    }
}
