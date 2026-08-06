package com.bytedance.networkstackapplib;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class MyTimeoutTask {
    public static final int ERROR_HAVE_EXCEPTION = -2;
    public static final int ERROR_TOO_MANY_THREAD = -1;
    private static final int MAX_THREAD_COUNT = 5;
    private static int threadConnt;
    private boolean haveException = false;

    static /* synthetic */ int access$008() {
        int i = threadConnt;
        threadConnt = i + 1;
        return i;
    }

    static /* synthetic */ int access$010() {
        int i = threadConnt;
        threadConnt = i - 1;
        return i;
    }

    public long startTask(int i, final Runnable runnable) {
        if (threadConnt > 5) {
            return -1L;
        }
        this.haveException = false;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        long currentTimeMillis = System.currentTimeMillis();
        new Thread(new Runnable() { // from class: com.bytedance.networkstackapplib.MyTimeoutTask.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        MyTimeoutTask.access$008();
                        runnable.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                        MyTimeoutTask.this.haveException = true;
                    }
                } finally {
                    countDownLatch.countDown();
                    MyTimeoutTask.access$010();
                }
            }
        }).start();
        try {
            countDownLatch.await(i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.haveException) {
            return -2L;
        }
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public long startTwoTasksNeedOneFinished(int i, final Runnable runnable, final Runnable runnable2) {
        if (threadConnt > 10) {
            return -1L;
        }
        this.haveException = false;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        long currentTimeMillis = System.currentTimeMillis();
        new Thread(new Runnable() { // from class: com.bytedance.networkstackapplib.MyTimeoutTask.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        MyTimeoutTask.access$008();
                        runnable.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                        MyTimeoutTask.this.haveException = true;
                    }
                } finally {
                    countDownLatch.countDown();
                    MyTimeoutTask.access$010();
                }
            }
        }).start();
        new Thread(new Runnable() { // from class: com.bytedance.networkstackapplib.MyTimeoutTask.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        MyTimeoutTask.access$008();
                        runnable2.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                        MyTimeoutTask.this.haveException = true;
                    }
                } finally {
                    countDownLatch.countDown();
                    MyTimeoutTask.access$010();
                }
            }
        }).start();
        try {
            countDownLatch.await(i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.haveException) {
            return -2L;
        }
        return System.currentTimeMillis() - currentTimeMillis;
    }
}
