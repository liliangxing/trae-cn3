package com.huawei.hmf.tasks.p018a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.hmf.tasks.a.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1000c extends CancellationToken {

    /* renamed from: a */
    public final List<Runnable> f892a = new ArrayList();

    /* renamed from: b */
    public final Object f893b = new Object();

    /* renamed from: c */
    public boolean f894c = false;

    /* renamed from: a */
    public final void m853a() {
        if (this.f894c) {
            return;
        }
        synchronized (this.f893b) {
            this.f894c = true;
            Iterator<Runnable> it = this.f892a.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public boolean isCancellationRequested() {
        return this.f894c;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public CancellationToken register(Runnable runnable) {
        synchronized (this.f893b) {
            if (this.f894c) {
                runnable.run();
            } else {
                this.f892a.add(runnable);
            }
        }
        return this;
    }
}
