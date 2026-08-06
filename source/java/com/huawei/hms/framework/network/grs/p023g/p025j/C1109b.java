package com.huawei.hms.framework.network.grs.p023g.p025j;

import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.p023g.C1102d;
import java.util.concurrent.Future;

/* renamed from: com.huawei.hms.framework.network.grs.g.j.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1109b {

    /* renamed from: a */
    private final Future<C1102d> f1367a;

    /* renamed from: b */
    private final long f1368b = SystemClock.elapsedRealtime();

    public C1109b(Future<C1102d> future) {
        this.f1367a = future;
    }

    /* renamed from: a */
    public Future<C1102d> m1348a() {
        return this.f1367a;
    }

    /* renamed from: b */
    public boolean m1349b() {
        return SystemClock.elapsedRealtime() - this.f1368b <= 300000;
    }
}
