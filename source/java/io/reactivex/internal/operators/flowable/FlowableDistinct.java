package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FlowableDistinct<T, K> extends AbstractFlowableWithUpstream<T, T> {
    final Callable<? extends Collection<? super K>> collectionSupplier;
    final Function<? super T, K> keySelector;

    public FlowableDistinct(Flowable<T> flowable, Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        super(flowable);
        this.keySelector = function;
        this.collectionSupplier = callable;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            this.source.subscribe(new DistinctSubscriber(subscriber, this.keySelector, (Collection) ObjectHelper.requireNonNull(this.collectionSupplier.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class DistinctSubscriber<T, K> extends BasicFuseableSubscriber<T, T> {
        final Collection<? super K> collection;
        final Function<? super T, K> keySelector;

        DistinctSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, Collection<? super K> collection) {
            super(subscriber);
            this.keySelector = function;
            this.collection = collection;
        }

        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 0) {
                try {
                    if (this.collection.add(ObjectHelper.requireNonNull(this.keySelector.apply(t), "The keySelector returned a null key"))) {
                        this.downstream.onNext(t);
                        return;
                    } else {
                        this.upstream.request(1L);
                        return;
                    }
                } catch (Throwable th) {
                    fail(th);
                    return;
                }
            }
            this.downstream.onNext((Object) null);
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.collection.clear();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.collection.clear();
            this.downstream.onComplete();
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        public T poll() throws Exception {
            T t;
            while (true) {
                t = (T) this.f71qs.poll();
                if (t == null || this.collection.add((Object) ObjectHelper.requireNonNull(this.keySelector.apply(t), "The keySelector returned a null key"))) {
                    break;
                }
                if (this.sourceMode == 2) {
                    this.upstream.request(1L);
                }
            }
            return t;
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber
        public void clear() {
            this.collection.clear();
            super.clear();
        }
    }
}
