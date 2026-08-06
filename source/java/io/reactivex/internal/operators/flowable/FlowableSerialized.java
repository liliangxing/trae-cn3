package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.subscribers.SerializedSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FlowableSerialized<T> extends AbstractFlowableWithUpstream<T, T> {
    public FlowableSerialized(Flowable<T> flowable) {
        super(flowable);
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SerializedSubscriber(subscriber));
    }
}
