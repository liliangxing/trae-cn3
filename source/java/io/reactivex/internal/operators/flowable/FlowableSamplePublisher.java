package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FlowableSamplePublisher<T> extends Flowable<T> {
    final boolean emitLast;
    final Publisher<?> other;
    final Publisher<T> source;

    public FlowableSamplePublisher(Publisher<T> publisher, Publisher<?> publisher2, boolean z) {
        this.source = publisher;
        this.other = publisher2;
        this.emitLast = z;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.emitLast) {
            this.source.subscribe(new SampleMainEmitLast(serializedSubscriber, this.other));
        } else {
            this.source.subscribe(new SampleMainNoLast(serializedSubscriber, this.other));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static abstract class SamplePublisherSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3517602651313910099L;
        final Subscriber<? super T> downstream;
        final Publisher<?> sampler;
        Subscription upstream;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<Subscription> other = new AtomicReference<>();

        abstract void completeMain();

        abstract void completeOther();

        abstract void run();

        SamplePublisherSubscriber(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            this.downstream = subscriber;
            this.sampler = publisher;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new SamplerSubscriber(this));
                    subscription.request(LongCompanionObject.MAX_VALUE);
                }
            }
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onError(th);
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            completeMain();
        }

        void setOther(Subscription subscription) {
            SubscriptionHelper.setOnce(this.other, subscription, LongCompanionObject.MAX_VALUE);
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.other);
            this.upstream.cancel();
        }

        public void error(Throwable th) {
            this.upstream.cancel();
            this.downstream.onError(th);
        }

        public void complete() {
            this.upstream.cancel();
            completeOther();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(andSet);
                    BackpressureHelper.produced(this.requested, 1L);
                } else {
                    cancel();
                    this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
                }
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class SamplerSubscriber<T> implements FlowableSubscriber<Object> {
        final SamplePublisherSubscriber<T> parent;

        SamplerSubscriber(SamplePublisherSubscriber<T> samplePublisherSubscriber) {
            this.parent = samplePublisherSubscriber;
        }

        public void onSubscribe(Subscription subscription) {
            this.parent.setOther(subscription);
        }

        public void onNext(Object obj) {
            this.parent.run();
        }

        public void onError(Throwable th) {
            this.parent.error(th);
        }

        public void onComplete() {
            this.parent.complete();
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class SampleMainNoLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        SampleMainNoLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber, publisher);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void completeMain() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void completeOther() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void run() {
            emit();
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class SampleMainEmitLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        SampleMainEmitLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber, publisher);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void completeMain() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void completeOther() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void run() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            do {
                boolean z = this.done;
                emit();
                if (z) {
                    this.downstream.onComplete();
                    return;
                }
            } while (this.wip.decrementAndGet() != 0);
        }
    }
}
