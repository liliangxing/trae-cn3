package com.huawei.hmf.tasks;

import android.os.Looper;
import com.huawei.hmf.tasks.p018a.C1006i;
import com.huawei.hmf.tasks.p018a.C1007j;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class Tasks {
    public static C1007j IMPL = new C1007j();

    public static Task<List<Task<?>>> allOf(Collection<? extends Task<?>> collection) {
        return C1007j.m862a(collection);
    }

    public static Task<List<Task<?>>> allOf(Task<?>... taskArr) {
        return C1007j.m862a(Arrays.asList(taskArr));
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return IMPL.m865a(TaskExecutors.immediate(), callable);
    }

    public static <TResult> Task<TResult> callInBackground(Callable<TResult> callable) {
        return IMPL.m865a(TaskExecutors.background(), callable);
    }

    public static <TResult> Task<TResult> callInBackground(Executor executor, Callable<TResult> callable) {
        return IMPL.m865a(executor, callable);
    }

    public static <TResult> Task<TResult> fromCanceled() {
        C1006i c1006i = new C1006i();
        c1006i.m860a();
        return c1006i;
    }

    public static <TResult> Task<TResult> fromException(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }

    public static <TResult> Task<TResult> fromResult(TResult tresult) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(tresult);
        return taskCompletionSource.getTask();
    }

    public static Task<Void> join(Collection<? extends Task<?>> collection) {
        return C1007j.m863b(collection);
    }

    public static Task<Void> join(Task<?>... taskArr) {
        return C1007j.m863b(Arrays.asList(taskArr));
    }

    public static <TResult> Task<List<TResult>> successOf(Collection<? extends Task<TResult>> collection) {
        return C1007j.m864c(collection);
    }

    public static <TResult> Task<List<TResult>> successOf(Task<?>... taskArr) {
        return C1007j.m864c(Arrays.asList(taskArr));
    }

    public static <TResult> TResult await(Task<TResult> task) throws ExecutionException, InterruptedException {
        C1007j c1007j = IMPL;
        c1007j.getClass();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (task.isComplete()) {
                return (TResult) c1007j.m866a(task);
            }
            C1007j.d dVar = new C1007j.d();
            ((C1006i) task).addOnSuccessListener(TaskExecutors.uiThread(), dVar).addOnFailureListener(dVar);
            dVar.f938a.await();
            return (TResult) c1007j.m866a(task);
        }
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        C1007j c1007j = IMPL;
        c1007j.getClass();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (!task.isComplete()) {
                C1007j.d dVar = new C1007j.d();
                ((C1006i) task).addOnSuccessListener(TaskExecutors.uiThread(), dVar).addOnFailureListener(dVar);
                if (!dVar.f938a.await(j, timeUnit)) {
                    throw new TimeoutException("Timed out waiting for Task");
                }
            }
            return (TResult) c1007j.m866a(task);
        }
        throw new IllegalStateException("await must not be called on the UI thread");
    }
}
