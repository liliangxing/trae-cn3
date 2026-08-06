package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FlowableWindowBoundarySelector<T, B, V> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final Function<? super B, ? extends Publisher<V>> close;
    final Publisher<B> open;

    public FlowableWindowBoundarySelector(Flowable<T> flowable, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
        super(flowable);
        this.open = publisher;
        this.close = function;
        this.bufferSize = i;
    }

    protected void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.source.subscribe(new WindowBoundaryMainSubscriber(new SerializedSubscriber(subscriber), this.open, this.close, this.bufferSize));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class WindowBoundaryMainSubscriber<T, B, V> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        final AtomicReference<Disposable> boundary;
        final int bufferSize;
        final Function<? super B, ? extends Publisher<V>> close;
        final Publisher<B> open;
        final CompositeDisposable resources;
        Subscription upstream;
        final AtomicLong windows;

        /* renamed from: ws */
        final List<UnicastProcessor<T>> f30ws;

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public boolean accept(Subscriber<? super Flowable<T>> subscriber, Object obj) {
            return false;
        }

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.boundary = new AtomicReference<>();
            AtomicLong atomicLong = new AtomicLong();
            this.windows = atomicLong;
            this.open = publisher;
            this.close = function;
            this.bufferSize = i;
            this.resources = new CompositeDisposable();
            this.f30ws = new ArrayList();
            atomicLong.lazySet(1L);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                OperatorWindowBoundaryOpenSubscriber operatorWindowBoundaryOpenSubscriber = new OperatorWindowBoundaryOpenSubscriber(this);
                if (UByte$$ExternalSyntheticBackport0.m37m((AtomicReference) this.boundary, (Object) null, (Object) operatorWindowBoundaryOpenSubscriber)) {
                    this.windows.getAndIncrement();
                    subscription.request(LongCompanionObject.MAX_VALUE);
                    this.open.subscribe(operatorWindowBoundaryOpenSubscriber);
                }
            }
        }

        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (fastEnter()) {
                Iterator<UnicastProcessor<T>> it = this.f30ws.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            if (this.windows.decrementAndGet() == 0) {
                this.resources.dispose();
            }
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            if (this.windows.decrementAndGet() == 0) {
                this.resources.dispose();
            }
            this.downstream.onComplete();
        }

        void error(Throwable th) {
            this.upstream.cancel();
            this.resources.dispose();
            DisposableHelper.dispose(this.boundary);
            this.downstream.onError(th);
        }

        public void request(long j) {
            requested(j);
        }

        public void cancel() {
            this.cancelled = true;
        }

        void dispose() {
            this.resources.dispose();
            DisposableHelper.dispose(this.boundary);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            Subscriber<? super V> subscriber = this.downstream;
            List<UnicastProcessor<T>> list = this.f30ws;
            int i = 1;
            while (true) {
                boolean z = this.done;
                Object poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    dispose();
                    Throwable th = this.error;
                    if (th != null) {
                        Iterator<UnicastProcessor<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastProcessor<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (!z2) {
                    if (poll instanceof WindowOperation) {
                        WindowOperation windowOperation = (WindowOperation) poll;
                        if (windowOperation.f31w != null) {
                            if (list.remove(windowOperation.f31w)) {
                                windowOperation.f31w.onComplete();
                                if (this.windows.decrementAndGet() == 0) {
                                    dispose();
                                    return;
                                }
                            } else {
                                continue;
                            }
                        } else if (!this.cancelled) {
                            UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize);
                            long requested = requested();
                            if (requested != 0) {
                                list.add(create);
                                subscriber.onNext(create);
                                if (requested != LongCompanionObject.MAX_VALUE) {
                                    produced(1L);
                                }
                                try {
                                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.close.apply(windowOperation.open), "The publisher supplied is null");
                                    OperatorWindowBoundaryCloseSubscriber operatorWindowBoundaryCloseSubscriber = new OperatorWindowBoundaryCloseSubscriber(this, create);
                                    if (this.resources.add(operatorWindowBoundaryCloseSubscriber)) {
                                        this.windows.getAndIncrement();
                                        publisher.subscribe(operatorWindowBoundaryCloseSubscriber);
                                    }
                                } catch (Throwable th2) {
                                    this.cancelled = true;
                                    subscriber.onError(th2);
                                }
                            } else {
                                this.cancelled = true;
                                subscriber.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                            }
                        }
                    } else {
                        Iterator<UnicastProcessor<T>> it3 = list.iterator();
                        while (it3.hasNext()) {
                            it3.next().onNext(NotificationLite.getValue(poll));
                        }
                    }
                } else {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        void open(B b) {
            this.queue.offer(new WindowOperation(null, b));
            if (enter()) {
                drainLoop();
            }
        }

        void close(OperatorWindowBoundaryCloseSubscriber<T, V> operatorWindowBoundaryCloseSubscriber) {
            this.resources.delete(operatorWindowBoundaryCloseSubscriber);
            this.queue.offer(new WindowOperation(operatorWindowBoundaryCloseSubscriber.f29w, null));
            if (enter()) {
                drainLoop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class WindowOperation<T, B> {
        final B open;

        /* renamed from: w */
        final UnicastProcessor<T> f31w;

        WindowOperation(UnicastProcessor<T> unicastProcessor, B b) {
            this.f31w = unicastProcessor;
            this.open = b;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class OperatorWindowBoundaryOpenSubscriber<T, B> extends DisposableSubscriber<B> {
        final WindowBoundaryMainSubscriber<T, B, ?> parent;

        OperatorWindowBoundaryOpenSubscriber(WindowBoundaryMainSubscriber<T, B, ?> windowBoundaryMainSubscriber) {
            this.parent = windowBoundaryMainSubscriber;
        }

        public void onNext(B b) {
            this.parent.open(b);
        }

        public void onError(Throwable th) {
            this.parent.error(th);
        }

        public void onComplete() {
            this.parent.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class OperatorWindowBoundaryCloseSubscriber<T, V> extends DisposableSubscriber<V> {
        boolean done;
        final WindowBoundaryMainSubscriber<T, ?, V> parent;

        /* renamed from: w */
        final UnicastProcessor<T> f29w;

        OperatorWindowBoundaryCloseSubscriber(WindowBoundaryMainSubscriber<T, ?, V> windowBoundaryMainSubscriber, UnicastProcessor<T> unicastProcessor) {
            this.parent = windowBoundaryMainSubscriber;
            this.f29w = unicastProcessor;
        }

        public void onNext(V v) {
            cancel();
            onComplete();
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.parent.error(th);
            }
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.close(this);
        }
    }
}
