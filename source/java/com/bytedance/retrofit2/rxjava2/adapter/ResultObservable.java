package com.bytedance.retrofit2.rxjava2.adapter;

import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class ResultObservable<T> extends Observable<Result<T>> {
    private final Observable<SsResponse<T>> upstream;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultObservable(Observable<SsResponse<T>> observable) {
        this.upstream = observable;
    }

    protected void subscribeActual(Observer<? super Result<T>> observer) {
        this.upstream.subscribe(new ResultObserver(observer));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class ResultObserver<R> implements Observer<SsResponse<R>> {
        private final Observer<? super Result<R>> observer;

        ResultObserver(Observer<? super Result<R>> observer) {
            this.observer = observer;
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }

        public void onNext(SsResponse<R> ssResponse) {
            this.observer.onNext(Result.response(ssResponse));
        }

        public void onError(Throwable th) {
            try {
                this.observer.onNext(Result.error(th));
                this.observer.onComplete();
            } catch (Throwable th2) {
                try {
                    this.observer.onError(th2);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    RxJavaPlugins.onError(new CompositeException(new Throwable[]{th2, th3}));
                }
            }
        }

        public void onComplete() {
            this.observer.onComplete();
        }
    }
}
