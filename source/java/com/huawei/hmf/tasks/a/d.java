package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes6.dex */
public class d<TResult> implements ExecuteResult<TResult> {
    public OnCompleteListener<TResult> a;
    public Executor b;
    public final Object c = new Object();

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public final /* synthetic */ Task a;

        public a(Task task) {
            this.a = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (d.this.c) {
                if (d.this.a != null) {
                    d.this.a.onComplete(this.a);
                }
            }
        }
    }

    public d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.a = onCompleteListener;
        this.b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public void cancel() {
        synchronized (this.c) {
            this.a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        this.b.execute(new a(task));
    }
}
