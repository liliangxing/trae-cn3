package com.huawei.hmf.tasks.p018a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1003f<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a */
    public OnFailureListener f906a;

    /* renamed from: b */
    public Executor f907b;

    /* renamed from: c */
    public final Object f908c = new Object();

    /* renamed from: com.huawei.hmf.tasks.a.f$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Task f909a;

        public a(Task task) {
            this.f909a = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C1003f.this.f908c) {
                if (C1003f.this.f906a != null) {
                    C1003f.this.f906a.onFailure(this.f909a.getException());
                }
            }
        }
    }

    public C1003f(Executor executor, OnFailureListener onFailureListener) {
        this.f906a = onFailureListener;
        this.f907b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public void cancel() {
        synchronized (this.f908c) {
            this.f906a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        if (task.isSuccessful() || ((C1006i) task).f920c) {
            return;
        }
        this.f907b.execute(new a(task));
    }
}
