package com.huawei.hmf.tasks.p018a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0999b<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a */
    public OnCanceledListener f888a;

    /* renamed from: b */
    public Executor f889b;

    /* renamed from: c */
    public final Object f890c = new Object();

    /* renamed from: com.huawei.hmf.tasks.a.b$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C0999b.this.f890c) {
                if (C0999b.this.f888a != null) {
                    C0999b.this.f888a.onCanceled();
                }
            }
        }
    }

    public C0999b(Executor executor, OnCanceledListener onCanceledListener) {
        this.f888a = onCanceledListener;
        this.f889b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public void cancel() {
        synchronized (this.f890c) {
            this.f888a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        if (((C1006i) task).f920c) {
            this.f889b.execute(new a());
        }
    }
}
