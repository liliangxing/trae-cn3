package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1515bv;
import java.lang.ref.WeakReference;

/* renamed from: com.xiaomi.push.bo */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RunnableC1508bo implements Runnable {

    /* renamed from: a */
    private String f1095a;

    /* renamed from: a */
    private WeakReference<Context> f1096a;

    public RunnableC1508bo(String str, WeakReference<Context> weakReference) {
        this.f1095a = str;
        this.f1096a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f1096a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (C1519bz.m1724a(this.f1095a) > C1507bn.f1093a) {
            C1511br m1698a = C1511br.m1698a(this.f1095a);
            C1510bq m1694a = C1510bq.m1694a(this.f1095a);
            m1698a.m1716a(m1694a);
            m1694a.m1716a(C1509bp.m1691a(context, this.f1095a, 1000));
            C1515bv.m1703a(context).m1707a((C1515bv.a) m1698a);
            return;
        }
        AbstractC1417b.m1098b("=====> do not need clean db");
    }
}
