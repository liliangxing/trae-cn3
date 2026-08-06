package com.bytedance.apm.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/* loaded from: classes3.dex */
public class ThreadWithBlockingQueue {
    private final BlockingQueue<Runnable> mQueue = new LinkedTransferQueue();
    private final Thread mThread;

    public ThreadWithBlockingQueue(String str) {
        this.mThread = new Thread(new Runnable() { // from class: com.bytedance.apm.thread.ThreadWithBlockingQueue.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        ((Runnable) ThreadWithBlockingQueue.this.mQueue.take()).run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, str);
    }

    public void start() {
        this.mThread.start();
    }

    public final boolean post(Runnable runnable) {
        return this.mQueue.offer(runnable);
    }
}
