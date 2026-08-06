package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class MaybeFlatMapIterableFlowable<T, R> extends Flowable<R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final MaybeSource<T> source;

    public MaybeFlatMapIterableFlowable(MaybeSource<T> maybeSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.source = maybeSource;
        this.mapper = function;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe(new FlatMapIterableObserver(subscriber, this.mapper));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements MaybeObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        volatile boolean cancelled;
        final Subscriber<? super R> downstream;

        /* renamed from: it */
        volatile Iterator<? extends R> f33it;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        final AtomicLong requested = new AtomicLong();
        Disposable upstream;

        FlatMapIterableObserver(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.downstream = subscriber;
            this.mapper = function;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            try {
                Iterator<? extends R> it = ((Iterable) this.mapper.apply(t)).iterator();
                if (!it.hasNext()) {
                    this.downstream.onComplete();
                } else {
                    this.f33it = it;
                    drain();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        void fastPath(Subscriber<? super R> subscriber, Iterator<? extends R> it) {
            while (!this.cancelled) {
                try {
                    subscriber.onNext(it.next());
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            subscriber.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        subscriber.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    subscriber.onError(th2);
                    return;
                }
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.downstream;
            Iterator<? extends R> it = this.f33it;
            if (this.outputFused && it != null) {
                subscriber.onNext((Object) null);
                subscriber.onComplete();
                return;
            }
            int i = 1;
            while (true) {
                if (it != null) {
                    long j = this.requested.get();
                    if (j == LongCompanionObject.MAX_VALUE) {
                        fastPath(subscriber, it);
                        return;
                    }
                    long j2 = 0;
                    while (j2 != j) {
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            subscriber.onNext(ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value"));
                            if (this.cancelled) {
                                return;
                            }
                            j2++;
                            try {
                                if (!it.hasNext()) {
                                    subscriber.onComplete();
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                subscriber.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            subscriber.onError(th2);
                            return;
                        }
                    }
                    if (j2 != 0) {
                        BackpressureHelper.produced(this.requested, j2);
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (it == null) {
                    it = this.f33it;
                }
            }
        }

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public void clear() {
            this.f33it = null;
        }

        public boolean isEmpty() {
            return this.f33it == null;
        }

        public R poll() throws Exception {
            Iterator<? extends R> it = this.f33it;
            if (it == null) {
                return null;
            }
            R r = (R) ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f33it = null;
            }
            return r;
        }
    }
}
