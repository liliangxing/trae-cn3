package com.huawei.hmf.tasks.p018a;

import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.TaskExecutors;
import com.huawei.hmf.tasks.p018a.C1006i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1007j {

    /* renamed from: com.huawei.hmf.tasks.a.j$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ TaskCompletionSource f934a;

        /* renamed from: b */
        public final /* synthetic */ Callable f935b;

        public a(C1007j c1007j, TaskCompletionSource taskCompletionSource, Callable callable) {
            this.f934a = taskCompletionSource;
            this.f935b = callable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f934a.setResult(this.f935b.call());
            } catch (Exception e) {
                this.f934a.setException(e);
            }
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.j$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class b implements Continuation<Void, List<Task<?>>> {

        /* renamed from: a */
        public final /* synthetic */ Collection f936a;

        public b(Collection collection) {
            this.f936a = collection;
        }

        @Override // com.huawei.hmf.tasks.Continuation
        public List<Task<?>> then(Task<Void> task) throws Exception {
            ArrayList arrayList = new ArrayList(this.f936a.size());
            arrayList.addAll(this.f936a);
            return arrayList;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TResult] */
    /* renamed from: com.huawei.hmf.tasks.a.j$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class c<TResult> implements Continuation<Void, List<TResult>> {

        /* renamed from: a */
        public final /* synthetic */ Collection f937a;

        public c(Collection collection) {
            this.f937a = collection;
        }

        @Override // com.huawei.hmf.tasks.Continuation
        public Object then(Task<Void> task) throws Exception {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f937a.iterator();
            while (it.hasNext()) {
                arrayList.add(((Task) it.next()).getResult());
            }
            return arrayList;
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.j$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class d<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {

        /* renamed from: a */
        public final CountDownLatch f938a = new CountDownLatch(1);

        @Override // com.huawei.hmf.tasks.OnCanceledListener
        public void onCanceled() {
            this.f938a.countDown();
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            this.f938a.countDown();
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public final void onSuccess(TResult tresult) {
            this.f938a.countDown();
        }
    }

    /* renamed from: b */
    public static Task<Void> m863b(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setResult(null);
            return taskCompletionSource.getTask();
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("task can not is null");
            }
        }
        C1006i c1006i = new C1006i();
        C1002e c1002e = new C1002e(collection.size(), c1006i);
        for (Task<?> task : collection) {
            task.addOnSuccessListener(TaskExecutors.immediate(), c1002e);
            C1006i c1006i2 = (C1006i) task;
            c1006i2.m857a((ExecuteResult) new C1003f(TaskExecutors.immediate(), c1002e));
            c1006i2.m857a((ExecuteResult) new C0999b(TaskExecutors.immediate(), c1002e));
        }
        return c1006i;
    }

    /* renamed from: a */
    public <TResult> Task<TResult> m865a(Executor executor, Callable<TResult> callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            executor.execute(new a(this, taskCompletionSource, callable));
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
        return taskCompletionSource.getTask();
    }

    /* renamed from: a */
    public final <TResult> TResult m866a(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    /* renamed from: a */
    public static Task<List<Task<?>>> m862a(Collection<? extends Task<?>> collection) {
        Task<Void> m863b = m863b(collection);
        b bVar = new b(collection);
        C1006i c1006i = (C1006i) m863b;
        c1006i.getClass();
        Executor uiThread = TaskExecutors.uiThread();
        C1006i c1006i2 = new C1006i();
        c1006i.addOnCompleteListener(uiThread, new C1006i.e(c1006i, c1006i2, bVar));
        return c1006i2;
    }

    /* renamed from: c */
    public static <TResult> Task<List<TResult>> m864c(Collection<? extends Task<?>> collection) {
        Task<Void> m863b = m863b(collection);
        c cVar = new c(collection);
        C1006i c1006i = (C1006i) m863b;
        c1006i.getClass();
        Executor uiThread = TaskExecutors.uiThread();
        C1006i c1006i2 = new C1006i();
        c1006i.addOnCompleteListener(uiThread, new C1006i.e(c1006i, c1006i2, cVar));
        return c1006i2;
    }
}
