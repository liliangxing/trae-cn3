package com.bytedance.realx.base;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class ThreadUtils {

    /* loaded from: classes4.dex */
    public interface BlockingOperation {
        void run() throws InterruptedException;
    }

    /* loaded from: classes4.dex */
    public static class ThreadChecker {
        private Thread thread = Thread.currentThread();

        public void checkIsOnValidThread() {
            if (this.thread == null) {
                this.thread = Thread.currentThread();
            }
            if (Thread.currentThread() != this.thread) {
                throw new IllegalStateException("Wrong thread");
            }
        }

        public void detachThread() {
            this.thread = null;
        }
    }

    public static void checkIsOnMainThread() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new IllegalStateException("Not on main thread!");
        }
    }

    public static void executeUninterruptibly(BlockingOperation operation) {
        boolean z = false;
        while (true) {
            try {
                operation.run();
                break;
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static boolean joinUninterruptibly(final Thread thread, long timeoutMs) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = false;
        long j = timeoutMs;
        while (j > 0) {
            try {
                thread.join(j);
                break;
            } catch (InterruptedException unused) {
                j = timeoutMs - (SystemClock.elapsedRealtime() - elapsedRealtime);
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return !thread.isAlive();
    }

    public static void joinUninterruptibly(final Thread thread) {
        executeUninterruptibly(new BlockingOperation() { // from class: com.bytedance.realx.base.ThreadUtils.1
            @Override // com.bytedance.realx.base.ThreadUtils.BlockingOperation
            public void run() throws InterruptedException {
                thread.join();
            }
        });
    }

    public static void awaitUninterruptibly(final CountDownLatch latch) {
        executeUninterruptibly(new BlockingOperation() { // from class: com.bytedance.realx.base.ThreadUtils.2
            @Override // com.bytedance.realx.base.ThreadUtils.BlockingOperation
            public void run() throws InterruptedException {
                latch.await();
            }
        });
    }

    public static boolean awaitUninterruptibly(CountDownLatch barrier, long timeoutMs) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = false;
        long j = timeoutMs;
        boolean z2 = false;
        while (true) {
            try {
                z = barrier.await(j, TimeUnit.MILLISECONDS);
                break;
            } catch (InterruptedException unused) {
                j = timeoutMs - (SystemClock.elapsedRealtime() - elapsedRealtime);
                if (j <= 0) {
                    z2 = true;
                    break;
                }
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return z;
    }

    public static <V> V invokeAtFrontUninterruptibly(final Handler handler, final Callable<V> callable) {
        if (handler.getLooper().getThread() == Thread.currentThread()) {
            try {
                return callable.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        final C1Result c1Result = new C1Result();
        final C1CaughtException c1CaughtException = new C1CaughtException();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (!handler.post(new Runnable() { // from class: com.bytedance.realx.base.ThreadUtils.3
            /* JADX WARN: Type inference failed for: r1v2, types: [V, java.lang.Object] */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1Result.this.value = callable.call();
                } catch (Exception e2) {
                    c1CaughtException.e = e2;
                }
                countDownLatch.countDown();
            }
        })) {
            return null;
        }
        awaitUninterruptibly(countDownLatch);
        if (c1CaughtException.e != null) {
            RuntimeException runtimeException = new RuntimeException(c1CaughtException.e);
            runtimeException.setStackTrace(concatStackTraces(c1CaughtException.e.getStackTrace(), runtimeException.getStackTrace()));
            throw runtimeException;
        }
        return c1Result.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.realx.base.ThreadUtils$1CaughtException, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class C1CaughtException {
        Exception e;

        C1CaughtException() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.realx.base.ThreadUtils$1Result, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class C1Result {
        public V value;

        C1Result() {
        }
    }

    public static void invokeAtFrontUninterruptibly(final Handler handler, final Runnable runner) {
        invokeAtFrontUninterruptibly(handler, new Callable<Void>() { // from class: com.bytedance.realx.base.ThreadUtils.4
            @Override // java.util.concurrent.Callable
            public Void call() {
                runner.run();
                return null;
            }
        });
    }

    static StackTraceElement[] concatStackTraces(StackTraceElement[] inner, StackTraceElement[] outer) {
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[inner.length + outer.length];
        System.arraycopy(inner, 0, stackTraceElementArr, 0, inner.length);
        System.arraycopy(outer, 0, stackTraceElementArr, inner.length, outer.length);
        return stackTraceElementArr;
    }
}
