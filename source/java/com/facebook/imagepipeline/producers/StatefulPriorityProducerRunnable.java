package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.PriorityRunnable;

/* loaded from: classes6.dex */
public abstract class StatefulPriorityProducerRunnable<T> extends StatefulProducerRunnable<T> implements PriorityRunnable {
    private int mPriority;

    public StatefulPriorityProducerRunnable(Consumer<T> consumer, ProducerListener producerListener, String str, String str2, int i) {
        super(consumer, producerListener, str, str2);
        this.mPriority = i;
    }

    @Override // com.facebook.common.executors.PriorityRunnable
    public int getPriority() {
        return this.mPriority;
    }
}
