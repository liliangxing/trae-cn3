package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class c extends CancellationToken {
    public final List<Runnable> a = new ArrayList();
    public final Object b = new Object();
    public boolean c = false;

    public final void a() {
        if (this.c) {
            return;
        }
        synchronized (this.b) {
            this.c = true;
            Iterator<Runnable> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public boolean isCancellationRequested() {
        return this.c;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public CancellationToken register(Runnable runnable) {
        synchronized (this.b) {
            if (this.c) {
                runnable.run();
            } else {
                this.a.add(runnable);
            }
        }
        return this;
    }
}
