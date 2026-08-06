package com.facebook.imagepipeline.producers;

import android.os.SystemClock;

/* loaded from: classes6.dex */
public abstract class StatefulHandoffProducerRunnable<T> extends StatefulProducerRunnable<T> {
    private long enqueueTime;
    private long pendingTime;

    public StatefulHandoffProducerRunnable(Consumer<T> consumer, ProducerListener producerListener, String str, String str2) {
        super(consumer, producerListener, str, str2);
    }

    public void enqueue() {
        this.enqueueTime = SystemClock.elapsedRealtime();
    }

    public void dequeue() {
        if (this.enqueueTime > 0) {
            this.pendingTime = SystemClock.elapsedRealtime() - this.enqueueTime;
        }
    }

    public long getPendingTime() {
        long j = this.pendingTime;
        if (j > 0) {
            return j;
        }
        return 0L;
    }
}
