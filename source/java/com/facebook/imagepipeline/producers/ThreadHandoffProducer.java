package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ThreadHandoffProducer<T> implements Producer<T> {
    public static final String EXTRA_PENDING_TIME = "pendingTime";
    public static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
    private final Producer<T> mInputProducer;
    private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public ThreadHandoffProducer(Producer<T> producer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(final Consumer<T> consumer, final ProducerContext producerContext) {
        final ProducerListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        final StatefulHandoffProducerRunnable<T> statefulHandoffProducerRunnable = new StatefulHandoffProducerRunnable<T>(consumer, listener, PRODUCER_NAME, id) { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer.1
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            protected void disposeResult(T t) {
            }

            @Override // com.facebook.common.executors.StatefulRunnable
            protected T getResult() throws Exception {
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onSuccess(T t) {
                ProducerListener producerListener = listener;
                String str = id;
                producerListener.onProducerFinishWithSuccess(str, ThreadHandoffProducer.PRODUCER_NAME, producerListener.requiresExtraMap(str) ? getExtraMapOnSuccess(t) : null);
                ThreadHandoffProducer.this.mInputProducer.produceResults(consumer, producerContext);
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            protected Map<String, String> getExtraMapOnSuccess(T t) {
                long pendingTime = getPendingTime();
                if (pendingTime > 0) {
                    return ImmutableMap.m414of(ThreadHandoffProducer.EXTRA_PENDING_TIME, String.valueOf(pendingTime));
                }
                return null;
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            protected Map<String, String> getExtraMapOnFailure(Exception exc) {
                long pendingTime = getPendingTime();
                if (pendingTime > 0) {
                    return ImmutableMap.m414of(ThreadHandoffProducer.EXTRA_PENDING_TIME, String.valueOf(pendingTime));
                }
                return null;
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                statefulHandoffProducerRunnable.cancel();
                ThreadHandoffProducer.this.mThreadHandoffProducerQueue.remove(statefulHandoffProducerRunnable);
            }
        });
        this.mThreadHandoffProducerQueue.addToQueueOrExecute(statefulHandoffProducerRunnable);
    }
}
