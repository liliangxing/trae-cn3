package com.huawei.hmf.tasks.p018a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1001d<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a */
    public OnCompleteListener<TResult> f895a;

    /* renamed from: b */
    public Executor f896b;

    /* renamed from: c */
    public final Object f897c = new Object();

    /* renamed from: com.huawei.hmf.tasks.a.d$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Task f898a;

        public a(Task task) {
            this.f898a = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C1001d.this.f897c) {
                if (C1001d.this.f895a != null) {
                    C1001d.this.f895a.onComplete(this.f898a);
                }
            }
        }
    }

    public C1001d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f895a = onCompleteListener;
        this.f896b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public void cancel() {
        synchronized (this.f897c) {
            this.f895a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        this.f896b.execute(new a(task));
    }
}
