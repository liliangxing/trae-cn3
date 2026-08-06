package com.bytedance.retrofit2.rxjava2.adapter;

import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class BodyObservable<T> extends Observable<T> {
    private final Observable<SsResponse<T>> upstream;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BodyObservable(Observable<SsResponse<T>> observable) {
        this.upstream = observable;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.upstream.subscribe(new BodyObserver(observer));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class BodyObserver<R> implements Observer<SsResponse<R>> {
        private final Observer<? super R> observer;
        private boolean terminated;

        BodyObserver(Observer<? super R> observer) {
            this.observer = observer;
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }

        public void onNext(SsResponse<R> ssResponse) {
            if (ssResponse.isSuccessful()) {
                this.observer.onNext(ssResponse.body());
                return;
            }
            this.terminated = true;
            HttpException httpException = new HttpException(ssResponse);
            try {
                this.observer.onError(httpException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(new Throwable[]{httpException, th}));
            }
        }

        public void onComplete() {
            if (this.terminated) {
                return;
            }
            this.observer.onComplete();
        }

        public void onError(Throwable th) {
            if (!this.terminated) {
                this.observer.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            RxJavaPlugins.onError(assertionError);
        }
    }
}
