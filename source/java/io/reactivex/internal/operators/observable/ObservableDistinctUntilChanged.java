package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {
    final BiPredicate<? super K, ? super K> comparer;
    final Function<? super T, K> keySelector;

    public ObservableDistinctUntilChanged(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.keySelector = function;
        this.comparer = biPredicate;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DistinctUntilChangedObserver(observer, this.keySelector, this.comparer));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {
        final BiPredicate<? super K, ? super K> comparer;
        boolean hasValue;
        final Function<? super T, K> keySelector;
        K last;

        DistinctUntilChangedObserver(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.keySelector = function;
            this.comparer = biPredicate;
        }

        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext(t);
                return;
            }
            try {
                K k = (K) this.keySelector.apply(t);
                if (this.hasValue) {
                    boolean test = this.comparer.test(this.last, k);
                    this.last = k;
                    if (test) {
                        return;
                    }
                } else {
                    this.hasValue = true;
                    this.last = k;
                }
                this.downstream.onNext(t);
            } catch (Throwable th) {
                fail(th);
            }
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        public T poll() throws Exception {
            while (true) {
                T t = (T) this.qd.poll();
                if (t == null) {
                    return null;
                }
                K k = (K) this.keySelector.apply(t);
                if (!this.hasValue) {
                    this.hasValue = true;
                    this.last = k;
                    return t;
                }
                if (!this.comparer.test(this.last, k)) {
                    this.last = k;
                    return t;
                }
                this.last = k;
            }
        }
    }
}
