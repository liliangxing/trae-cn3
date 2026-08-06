package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class MaybeFlatMapIterableObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final MaybeSource<T> source;

    public MaybeFlatMapIterableObservable(MaybeSource<T> maybeSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.source = maybeSource;
        this.mapper = function;
    }

    protected void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new FlatMapIterableObserver(observer, this.mapper));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class FlatMapIterableObserver<T, R> extends BasicQueueDisposable<R> implements MaybeObserver<T> {
        volatile boolean cancelled;
        final Observer<? super R> downstream;

        /* renamed from: it */
        volatile Iterator<? extends R> f34it;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        Disposable upstream;

        FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.downstream = observer;
            this.mapper = function;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            Observer<? super R> observer = this.downstream;
            try {
                Iterator<? extends R> it = ((Iterable) this.mapper.apply(t)).iterator();
                if (!it.hasNext()) {
                    observer.onComplete();
                    return;
                }
                this.f34it = it;
                if (this.outputFused) {
                    observer.onNext((Object) null);
                    observer.onComplete();
                    return;
                }
                while (!this.cancelled) {
                    try {
                        observer.onNext(it.next());
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                observer.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            observer.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        observer.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                observer.onError(th3);
            }
        }

        public void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public void clear() {
            this.f34it = null;
        }

        public boolean isEmpty() {
            return this.f34it == null;
        }

        public R poll() throws Exception {
            Iterator<? extends R> it = this.f34it;
            if (it == null) {
                return null;
            }
            R r = (R) ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f34it = null;
            }
            return r;
        }
    }
}
