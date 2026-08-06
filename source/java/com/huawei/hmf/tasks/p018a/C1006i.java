package com.huawei.hmf.tasks.p018a;

import android.app.Activity;
import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.SuccessContinuation;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1006i<TResult> extends Task<TResult> {

    /* renamed from: b */
    public boolean f919b;

    /* renamed from: c */
    public volatile boolean f920c;

    /* renamed from: d */
    public TResult f921d;

    /* renamed from: e */
    public Exception f922e;

    /* renamed from: a */
    public final Object f918a = new Object();

    /* renamed from: f */
    public List<ExecuteResult<TResult>> f923f = new ArrayList();

    /* renamed from: com.huawei.hmf.tasks.a.i$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class a implements OnSuccessListener<TResult> {

        /* renamed from: a */
        public final /* synthetic */ SuccessContinuation f924a;

        /* renamed from: b */
        public final /* synthetic */ C1006i f925b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* renamed from: com.huawei.hmf.tasks.a.i$a$a, reason: collision with other inner class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public class C1639a<TContinuationResult> implements OnCompleteListener<TContinuationResult> {
            public C1639a() {
            }

            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public void onComplete(Task<TContinuationResult> task) {
                if (task.isSuccessful()) {
                    a.this.f925b.m859a((C1006i) task.getResult());
                } else if (((C1006i) task).f920c) {
                    a.this.f925b.m860a();
                } else {
                    a.this.f925b.m858a(task.getException());
                }
            }
        }

        public a(C1006i c1006i, SuccessContinuation successContinuation, C1006i c1006i2) {
            this.f924a = successContinuation;
            this.f925b = c1006i2;
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public void onSuccess(TResult tresult) {
            try {
                Task then = this.f924a.then(tresult);
                if (then == null) {
                    this.f925b.m858a((Exception) new NullPointerException("SuccessContinuation returned null"));
                } else {
                    ((C1006i) then).addOnCompleteListener(TaskExecutors.uiThread(), new C1639a());
                }
            } catch (Exception e) {
                this.f925b.m858a(e);
            }
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.i$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class b implements OnFailureListener {

        /* renamed from: a */
        public final /* synthetic */ C1006i f927a;

        public b(C1006i c1006i, C1006i c1006i2) {
            this.f927a = c1006i2;
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            this.f927a.m858a(exc);
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.i$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class c implements OnCanceledListener {

        /* renamed from: a */
        public final /* synthetic */ C1006i f928a;

        public c(C1006i c1006i, C1006i c1006i2) {
            this.f928a = c1006i2;
        }

        @Override // com.huawei.hmf.tasks.OnCanceledListener
        public void onCanceled() {
            this.f928a.m860a();
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.i$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class d implements OnCompleteListener<TResult> {

        /* renamed from: a */
        public final /* synthetic */ Continuation f929a;

        /* renamed from: b */
        public final /* synthetic */ C1006i f930b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* renamed from: com.huawei.hmf.tasks.a.i$d$a */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public class a<TContinuationResult> implements OnCompleteListener<TContinuationResult> {
            public a() {
            }

            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public void onComplete(Task<TContinuationResult> task) {
                if (task.isSuccessful()) {
                    d.this.f930b.m859a((C1006i) task.getResult());
                } else if (((C1006i) task).f920c) {
                    d.this.f930b.m860a();
                } else {
                    d.this.f930b.m858a(task.getException());
                }
            }
        }

        public d(C1006i c1006i, Continuation continuation, C1006i c1006i2) {
            this.f929a = continuation;
            this.f930b = c1006i2;
        }

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public void onComplete(Task<TResult> task) {
            try {
                Task task2 = (Task) this.f929a.then(task);
                if (task2 == null) {
                    this.f930b.m858a((Exception) new NullPointerException("Continuation returned null"));
                } else {
                    ((C1006i) task2).addOnCompleteListener(TaskExecutors.uiThread(), new a());
                }
            } catch (Exception e) {
                this.f930b.m858a(e);
            }
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.i$e */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class e implements OnCompleteListener<TResult> {

        /* renamed from: a */
        public final /* synthetic */ C1006i f932a;

        /* renamed from: b */
        public final /* synthetic */ Continuation f933b;

        public e(C1006i c1006i, C1006i c1006i2, Continuation continuation) {
            this.f932a = c1006i2;
            this.f933b = continuation;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public void onComplete(Task<TResult> task) {
            if (((C1006i) task).f920c) {
                this.f932a.m860a();
                return;
            }
            try {
                this.f932a.m859a((C1006i) this.f933b.then(task));
            } catch (Exception e) {
                this.f932a.m858a(e);
            }
        }
    }

    /* renamed from: a */
    public Task<TResult> m857a(ExecuteResult<TResult> executeResult) {
        boolean isComplete;
        synchronized (this.f918a) {
            isComplete = isComplete();
            if (!isComplete) {
                this.f923f.add(executeResult);
            }
        }
        if (isComplete) {
            executeResult.onComplete(this);
        }
        return this;
    }

    /* renamed from: a */
    public final void m858a(Exception exc) {
        synchronized (this.f918a) {
            if (this.f919b) {
                return;
            }
            this.f919b = true;
            this.f922e = exc;
            this.f918a.notifyAll();
            m861b();
        }
    }

    /* renamed from: a */
    public final void m859a(TResult tresult) {
        synchronized (this.f918a) {
            if (this.f919b) {
                return;
            }
            this.f919b = true;
            this.f921d = tresult;
            this.f918a.notifyAll();
            m861b();
        }
    }

    /* renamed from: a */
    public final boolean m860a() {
        synchronized (this.f918a) {
            if (this.f919b) {
                return false;
            }
            this.f919b = true;
            this.f920c = true;
            this.f918a.notifyAll();
            m861b();
            return true;
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        C0999b c0999b = new C0999b(TaskExecutors.uiThread(), onCanceledListener);
        FragmentC1004g.m855a(activity, c0999b);
        return m857a((ExecuteResult) c0999b);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        return m857a((ExecuteResult) new C0999b(TaskExecutors.uiThread(), onCanceledListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        return m857a((ExecuteResult) new C0999b(executor, onCanceledListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCompleteListener(Activity activity, OnCompleteListener<TResult> onCompleteListener) {
        C1001d c1001d = new C1001d(TaskExecutors.uiThread(), onCompleteListener);
        FragmentC1004g.m855a(activity, c1001d);
        return m857a((ExecuteResult) c1001d);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.uiThread(), onCompleteListener);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        return m857a((ExecuteResult) new C1001d(executor, onCompleteListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        C1003f c1003f = new C1003f(TaskExecutors.uiThread(), onFailureListener);
        FragmentC1004g.m855a(activity, c1003f);
        return m857a((ExecuteResult) c1003f);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        return m857a((ExecuteResult) new C1003f(TaskExecutors.uiThread(), onFailureListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        return m857a((ExecuteResult) new C1003f(executor, onFailureListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnSuccessListener(Activity activity, OnSuccessListener<TResult> onSuccessListener) {
        C1005h c1005h = new C1005h(TaskExecutors.uiThread(), onSuccessListener);
        FragmentC1004g.m855a(activity, c1005h);
        return m857a((ExecuteResult) c1005h);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnSuccessListener(OnSuccessListener<TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.uiThread(), onSuccessListener);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        return m857a((ExecuteResult) new C1005h(executor, onSuccessListener));
    }

    /* renamed from: b */
    public final void m861b() {
        synchronized (this.f918a) {
            Iterator<ExecuteResult<TResult>> it = this.f923f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onComplete(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f923f = null;
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        Executor uiThread = TaskExecutors.uiThread();
        C1006i c1006i = new C1006i();
        addOnCompleteListener(uiThread, new e(this, c1006i, continuation));
        return c1006i;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        C1006i c1006i = new C1006i();
        addOnCompleteListener(executor, new e(this, c1006i, continuation));
        return c1006i;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        Executor uiThread = TaskExecutors.uiThread();
        C1006i c1006i = new C1006i();
        addOnCompleteListener(uiThread, new d(this, continuation, c1006i));
        return c1006i;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        C1006i c1006i = new C1006i();
        addOnCompleteListener(executor, new d(this, continuation, c1006i));
        return c1006i;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Exception getException() {
        Exception exc;
        synchronized (this.f918a) {
            exc = this.f922e;
        }
        return exc;
    }

    @Override // com.huawei.hmf.tasks.Task
    public TResult getResult() {
        TResult tresult;
        synchronized (this.f918a) {
            if (this.f922e != null) {
                throw new RuntimeException(this.f922e);
            }
            tresult = this.f921d;
        }
        return tresult;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <E extends Throwable> TResult getResultThrowException(Class<E> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f918a) {
            if (cls != null) {
                if (cls.isInstance(this.f922e)) {
                    throw cls.cast(this.f922e);
                }
            }
            if (this.f922e != null) {
                throw new RuntimeException(this.f922e);
            }
            tresult = this.f921d;
        }
        return tresult;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isCanceled() {
        return this.f920c;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isComplete() {
        boolean z;
        synchronized (this.f918a) {
            z = this.f919b;
        }
        return z;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isSuccessful() {
        boolean z;
        synchronized (this.f918a) {
            z = this.f919b && !this.f920c && this.f922e == null;
        }
        return z;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        Executor uiThread = TaskExecutors.uiThread();
        C1006i c1006i = new C1006i();
        addOnSuccessListener(uiThread, new a(this, successContinuation, c1006i));
        addOnFailureListener(new b(this, c1006i));
        m857a((ExecuteResult) new C0999b(TaskExecutors.uiThread(), new c(this, c1006i)));
        return c1006i;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        C1006i c1006i = new C1006i();
        addOnSuccessListener(executor, new a(this, successContinuation, c1006i));
        addOnFailureListener(new b(this, c1006i));
        m857a((ExecuteResult) new C0999b(TaskExecutors.uiThread(), new c(this, c1006i)));
        return c1006i;
    }
}
