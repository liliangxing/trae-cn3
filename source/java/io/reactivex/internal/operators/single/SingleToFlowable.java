package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class SingleToFlowable<T> extends Flowable<T> {
    final SingleSource<? extends T> source;

    public SingleToFlowable(SingleSource<? extends T> singleSource) {
        this.source = singleSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SingleToFlowableObserver(subscriber));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 187782011903685568L;
        Disposable upstream;

        SingleToFlowableObserver(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            complete(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }
    }
}
