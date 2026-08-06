package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class CompletableFromPublisher<T> extends Completable {
    final Publisher<T> flowable;

    public CompletableFromPublisher(Publisher<T> publisher) {
        this.flowable = publisher;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.flowable.subscribe(new FromPublisherSubscriber(completableObserver));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class FromPublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final CompletableObserver downstream;
        Subscription upstream;

        public void onNext(T t) {
        }

        FromPublisherSubscriber(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void dispose() {
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.upstream == SubscriptionHelper.CANCELLED;
        }
    }
}
