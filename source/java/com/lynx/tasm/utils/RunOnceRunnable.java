package com.lynx.tasm.utils;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public class RunOnceRunnable implements Runnable {
    public static int STATUS_EXCEPTION = 2;
    public static int STATUS_FINISHED = 3;
    public static int STATUS_IDLE = 0;
    public static int STATUS_RUNNING = 1;
    private final Runnable runnable;
    private final AtomicInteger status = new AtomicInteger(STATUS_IDLE);
    private final AtomicReference<Throwable> exception = new AtomicReference<>(null);
    private final CountDownLatch done = new CountDownLatch(1);

    public RunOnceRunnable(Runnable runnable) {
        this.runnable = (Runnable) Objects.requireNonNull(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.status.compareAndSet(STATUS_IDLE, STATUS_RUNNING)) {
            try {
                this.runnable.run();
                this.status.set(STATUS_FINISHED);
            } catch (Throwable th) {
                try {
                    this.status.set(STATUS_EXCEPTION);
                    this.exception.set(th);
                    throw new RuntimeException(th);
                } finally {
                    this.done.countDown();
                }
            }
        }
    }

    public boolean waitForComplete(long j, TimeUnit timeUnit) {
        try {
            return this.done.await(j, timeUnit);
        } catch (InterruptedException unused) {
            return false;
        }
    }

    public int getStatus() {
        return this.status.get();
    }

    public Throwable getException() {
        return this.exception.get();
    }
}
