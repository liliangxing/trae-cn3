package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    public FlowableDelay(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new DelaySubscriber(this.delayError ? subscriber : new SerializedSubscriber<>(subscriber), this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final long delay;
        final boolean delayError;
        final Subscriber<? super T> downstream;
        final TimeUnit unit;
        Subscription upstream;

        /* renamed from: w */
        final Scheduler.Worker f8w;

        DelaySubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.downstream = subscriber;
            this.delay = j;
            this.unit = timeUnit;
            this.f8w = worker;
            this.delayError = z;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f8w.schedule(new OnNext(t), this.delay, this.unit);
        }

        public void onError(Throwable th) {
            this.f8w.schedule(new OnError(th), this.delayError ? this.delay : 0L, this.unit);
        }

        public void onComplete() {
            this.f8w.schedule(new OnComplete(), this.delay, this.unit);
        }

        public void request(long j) {
            this.upstream.request(j);
        }

        public void cancel() {
            this.upstream.cancel();
            this.f8w.dispose();
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        final class OnNext implements Runnable {

            /* renamed from: t */
            private final T f10t;

            OnNext(T t) {
                this.f10t = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                DelaySubscriber.this.downstream.onNext(this.f10t);
            }
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        final class OnError implements Runnable {

            /* renamed from: t */
            private final Throwable f9t;

            OnError(Throwable th) {
                this.f9t = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.downstream.onError(this.f9t);
                } finally {
                    DelaySubscriber.this.f8w.dispose();
                }
            }
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.downstream.onComplete();
                } finally {
                    DelaySubscriber.this.f8w.dispose();
                }
            }
        }
    }
}
