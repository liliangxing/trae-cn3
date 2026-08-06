package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ObservableFlattenIterable<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;

    public ObservableFlattenIterable(ObservableSource<T> observableSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        super(observableSource);
        this.mapper = function;
    }

    protected void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new FlattenIterableObserver(observer, this.mapper));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {
        final Observer<? super R> downstream;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        Disposable upstream;

        FlattenIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.downstream = observer;
            this.mapper = function;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (this.upstream == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                Iterator<T> it = ((Iterable) this.mapper.apply(t)).iterator();
                Observer<? super R> observer = this.downstream;
                while (it.hasNext()) {
                    try {
                        try {
                            observer.onNext(ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value"));
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.upstream.dispose();
                            onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.upstream.dispose();
                        onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.upstream.dispose();
                onError(th3);
            }
        }

        public void onError(Throwable th) {
            if (this.upstream == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th);
            } else {
                this.upstream = DisposableHelper.DISPOSED;
                this.downstream.onError(th);
            }
        }

        public void onComplete() {
            if (this.upstream == DisposableHelper.DISPOSED) {
                return;
            }
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onComplete();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }
    }
}
