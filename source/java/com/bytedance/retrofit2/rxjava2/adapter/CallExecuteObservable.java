package com.bytedance.retrofit2.rxjava2.adapter;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class CallExecuteObservable<T> extends Observable<SsResponse<T>> {
    private final Call<T> originalCall;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallExecuteObservable(Call<T> call) {
        this.originalCall = call;
    }

    protected void subscribeActual(Observer<? super SsResponse<T>> observer) {
        boolean z;
        Call<T> clone = this.originalCall.clone();
        observer.onSubscribe(new CallDisposable(clone));
        try {
            SsResponse<T> execute = clone.execute();
            if (!clone.isCanceled()) {
                observer.onNext(execute);
            }
            if (clone.isCanceled()) {
                return;
            }
            try {
                observer.onComplete();
            } catch (Throwable th) {
                th = th;
                z = true;
                Exceptions.throwIfFatal(th);
                if (z) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                if (clone.isCanceled()) {
                    return;
                }
                try {
                    observer.onError(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(new Throwable[]{th, th2}));
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class CallDisposable implements Disposable {
        private final Call<?> call;

        CallDisposable(Call<?> call) {
            this.call = call;
        }

        public void dispose() {
            this.call.cancel();
        }

        public boolean isDisposed() {
            return this.call.isCanceled();
        }
    }
}
