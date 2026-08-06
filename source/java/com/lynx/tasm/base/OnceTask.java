package com.lynx.tasm.base;

import androidx.core.util.Consumer;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class OnceTask<T> implements Runnable {
    private static final String TAG = "OnceTask";
    private Consumer<Exception> mExceptionHandler;
    private final FutureTask<T> mFutureTask;
    private final AtomicBoolean mStarted;

    public OnceTask(Callable<T> callable) {
        this.mStarted = new AtomicBoolean(false);
        this.mExceptionHandler = null;
        this.mFutureTask = new FutureTask<>(callable);
    }

    public OnceTask(Callable<T> callable, Consumer<Exception> consumer) {
        this.mStarted = new AtomicBoolean(false);
        this.mExceptionHandler = null;
        this.mFutureTask = new FutureTask<>(callable);
        this.mExceptionHandler = consumer;
    }

    protected void tryRun() {
        if (this.mStarted.compareAndSet(false, true)) {
            this.mFutureTask.run();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        tryRun();
    }

    public T get() {
        try {
            return this.mFutureTask.get();
        } catch (Exception e) {
            LLog.e(TAG, "Get result from OnceTask failed since: " + e.toString());
            Consumer<Exception> consumer = this.mExceptionHandler;
            if (consumer == null) {
                return null;
            }
            consumer.accept(e);
            return null;
        }
    }
}
