package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class CompletableFromSingle<T> extends Completable {
    final SingleSource<T> single;

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.single = singleSource;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.single.subscribe(new CompletableFromSingleObserver(completableObserver));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {

        /* renamed from: co */
        final CompletableObserver f3co;

        CompletableFromSingleObserver(CompletableObserver completableObserver) {
            this.f3co = completableObserver;
        }

        public void onError(Throwable th) {
            this.f3co.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.f3co.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            this.f3co.onComplete();
        }
    }
}
