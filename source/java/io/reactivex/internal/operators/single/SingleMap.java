package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class SingleMap<T, R> extends Single<R> {
    final Function<? super T, ? extends R> mapper;
    final SingleSource<? extends T> source;

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.source = singleSource;
        this.mapper = function;
    }

    protected void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe(new MapSingleObserver(singleObserver, this.mapper));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class MapSingleObserver<T, R> implements SingleObserver<T> {
        final Function<? super T, ? extends R> mapper;

        /* renamed from: t */
        final SingleObserver<? super R> f66t;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
            this.f66t = singleObserver;
            this.mapper = function;
        }

        public void onSubscribe(Disposable disposable) {
            this.f66t.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            try {
                this.f66t.onSuccess(ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onError(th);
            }
        }

        public void onError(Throwable th) {
            this.f66t.onError(th);
        }
    }
}
