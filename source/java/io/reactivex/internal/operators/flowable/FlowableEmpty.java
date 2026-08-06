package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FlowableEmpty extends Flowable<Object> implements ScalarCallable<Object> {
    public static final Flowable<Object> INSTANCE = new FlowableEmpty();

    public Object call() {
        return null;
    }

    private FlowableEmpty() {
    }

    public void subscribeActual(Subscriber<? super Object> subscriber) {
        EmptySubscription.complete(subscriber);
    }
}
