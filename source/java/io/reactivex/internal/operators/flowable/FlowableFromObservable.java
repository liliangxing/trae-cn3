package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FlowableFromObservable<T> extends Flowable<T> {
    private final Observable<T> upstream;

    public FlowableFromObservable(Observable<T> observable) {
        this.upstream = observable;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.upstream.subscribe(new SubscriberObserver(subscriber));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class SubscriberObserver<T> implements Observer<T>, Subscription {
        final Subscriber<? super T> downstream;
        Disposable upstream;

        public void request(long j) {
        }

        SubscriberObserver(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }

        public void cancel() {
            this.upstream.dispose();
        }
    }
}
