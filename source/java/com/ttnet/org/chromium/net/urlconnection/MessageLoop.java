package com.ttnet.org.chromium.net.urlconnection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public class MessageLoop implements Executor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long INVALID_THREAD_ID = -1;
    private static final AtomicBoolean mDisableValidThreadAssert = new AtomicBoolean(false);
    private boolean mLoopFailed;
    private boolean mLoopRunning;
    private InterruptedIOException mPriorInterruptedIOException;
    private RuntimeException mPriorRuntimeException;
    private long mThreadId = -1;
    private final BlockingQueue<Runnable> mQueue = new LinkedBlockingQueue();

    private boolean calledOnValidThread() {
        if (mDisableValidThreadAssert.get()) {
            return true;
        }
        long j = this.mThreadId;
        if (j != -1) {
            return j == Thread.currentThread().getId();
        }
        this.mThreadId = Thread.currentThread().getId();
        return true;
    }

    public boolean onValidThread() {
        long j = this.mThreadId;
        return j == -1 || j == Thread.currentThread().getId();
    }

    private Runnable take(boolean z, long j) throws InterruptedIOException {
        Runnable poll;
        try {
            if (!z) {
                poll = this.mQueue.take();
            } else {
                poll = this.mQueue.poll(j, TimeUnit.NANOSECONDS);
            }
            if (poll != null) {
                return poll;
            }
            throw new SocketTimeoutException("ttnet");
        } catch (InterruptedException e) {
            InterruptedIOException interruptedIOException = new InterruptedIOException();
            interruptedIOException.initCause(e);
            throw interruptedIOException;
        }
    }

    public void loop() throws IOException {
        loop(0);
    }

    public void loop(int i) throws IOException {
        long nanoTime = System.nanoTime();
        long convert = TimeUnit.NANOSECONDS.convert(i, TimeUnit.MILLISECONDS);
        if (this.mLoopFailed) {
            InterruptedIOException interruptedIOException = this.mPriorInterruptedIOException;
            if (interruptedIOException != null) {
                throw interruptedIOException;
            }
            throw this.mPriorRuntimeException;
        }
        if (this.mLoopRunning) {
            throw new IllegalStateException("Cannot run loop when it is already running.");
        }
        this.mLoopRunning = true;
        while (this.mLoopRunning) {
            if (i == 0) {
                try {
                    take(false, 0L).run();
                } catch (SocketTimeoutException e) {
                    this.mLoopRunning = false;
                    this.mLoopFailed = true;
                    throw e;
                } catch (InterruptedIOException e2) {
                    this.mLoopRunning = false;
                    this.mLoopFailed = true;
                    this.mPriorInterruptedIOException = e2;
                    throw e2;
                } catch (RuntimeException e3) {
                    this.mLoopRunning = false;
                    this.mLoopFailed = true;
                    this.mPriorRuntimeException = e3;
                    throw e3;
                }
            } else {
                take(true, (convert - System.nanoTime()) + nanoTime).run();
            }
        }
    }

    public void reset() {
        this.mLoopFailed = false;
    }

    public static void disableVaildThreadAssert(boolean z) {
        mDisableValidThreadAssert.set(z);
    }

    public void quit() {
        this.mLoopRunning = false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) throws RejectedExecutionException {
        if (runnable == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.mQueue.put(runnable);
        } catch (InterruptedException e) {
            throw new RejectedExecutionException(e);
        }
    }

    public boolean isRunning() {
        return this.mLoopRunning;
    }

    public boolean hasLoopFailed() {
        return this.mLoopFailed;
    }
}
