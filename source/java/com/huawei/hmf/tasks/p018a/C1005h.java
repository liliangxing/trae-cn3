package com.huawei.hmf.tasks.p018a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1005h<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a */
    public OnSuccessListener<TResult> f913a;

    /* renamed from: b */
    public Executor f914b;

    /* renamed from: c */
    public final Object f915c = new Object();

    /* renamed from: com.huawei.hmf.tasks.a.h$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Task f916a;

        public a(Task task) {
            this.f916a = task;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (C1005h.this.f915c) {
                if (C1005h.this.f913a != null) {
                    C1005h.this.f913a.onSuccess(this.f916a.getResult());
                }
            }
        }
    }

    public C1005h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.f913a = onSuccessListener;
        this.f914b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public void cancel() {
        synchronized (this.f915c) {
            this.f913a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        if (!task.isSuccessful() || ((C1006i) task).f920c) {
            return;
        }
        this.f914b.execute(new a(task));
    }
}
